package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.addressDto.AddressDto;
import com.internship.HRapp.dto.userDTO.AssignUserDTO;
import com.internship.HRapp.entity.Address;
import com.internship.HRapp.mapper.AddressMapper;
import com.internship.HRapp.mapper.UserMapper;
import com.internship.HRapp.repository.AddressRepo;
import com.internship.HRapp.service.interfaces.AddressServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class AddressService implements AddressServiceInterface {
    private final AddressRepo addressRepo;
    private final AddressMapper addressMapper;
    private final UserMapper userMapper;

    @Override
    public AddressDto getAddressById(UUID addressID){
        boolean exists = addressRepo.existsById(addressID);
        if (!exists){
            throw new IllegalStateException(
                    "Address with id " + addressID + " does not exist!"
            );
        }
        return addressMapper.modeltoDto(addressRepo.getById(addressID));
    }

    @Override
    public List<AddressDto> getAddresses(){
        return addressMapper.toDto(addressRepo.findAll());
    }

    @Override
    public String deleteAddressById(UUID addressID){
        boolean exists = addressRepo.existsById(addressID);
        if (!exists){
            throw new IllegalStateException(
                    "Address with id " + addressID + " does not exist!"
            );
        }
        addressRepo.deleteById(addressID);
        return "address removed {}" + addressID;
    }

    @Override
    public AddressDto addNewAddress(AddressDto addressDto) {
        Address createdAddress = addressRepo.save(addressMapper.dtotoModel(addressDto));
        return addressMapper.modeltoDto(createdAddress);
    }

    @Override
    public void  editAddress(@NotNull AddressDto addressDto) {
      Address address =addressRepo.getAddressByAddressID(addressDto.getAddressID());
      address.setCity(addressDto.getCity());
      address.setState(addressDto.getState());
      address.setStreet(addressDto.getStreet());
      address.setPostalCode(addressDto.getPostalCode());
        addressRepo.save(address);
    }
    @Override
    public AssignUserDTO assignUserToAddress(UUID addressID, AssignUserDTO assignUserDTO) {
        Address address = addressRepo.getById(addressID);
        address.getUsers().addAll(userMapper.toEntitiesGet(assignUserDTO.getUsers()));
        addressRepo.save(address);
        return addressMapper.toDTOAssignUser(addressRepo.getById(addressID));
    }
    @Override
    public AssignUserDTO removeUserFromAddress(UUID addressID, UUID userId){
        Address address = addressRepo.getById(addressID);
        address.getUsers().removeIf(user -> user.getUserId().equals(userId));
        addressRepo.save(address);
        return addressMapper.toDTOAssignUser(addressRepo.getById(addressID));
    }
}
