package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.addressDto.UserAddressDTO;
import com.internship.HRapp.entity.Address;
import com.internship.HRapp.entity.User;
import com.internship.HRapp.mapper.AddressMapper;
import com.internship.HRapp.repository.AddressRepo;
import com.internship.HRapp.repository.UserRepo;
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
    private final UserRepo userRepo;

    @Override
    public UserAddressDTO getAddressById(UUID addressID){
        boolean exists = addressRepo.existsById(addressID);
        if (!exists){
            throw new IllegalStateException(
                    "Address with id " + addressID + " does not exist!"
            );
        }
        return addressMapper.modeltoDto(addressRepo.getById(addressID));
    }

    @Override
    public List<UserAddressDTO> getAddresses(){
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
    public UserAddressDTO addNewAddress(UserAddressDTO addressDto) {
        User user = userRepo.getById(addressDto.getUserId());
        Address createdAddress = addressRepo.save(addressMapper.dtotoModel(addressDto));
//        createdAddress.setUsers(user);
        return addressMapper.modeltoDto(createdAddress);
    }

    @Override
    public void  editAddress(@NotNull UserAddressDTO addressDto) {
        Address address =addressRepo.getAddressByAddressID(addressDto.getAddressID());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setStreet(addressDto.getStreet());
        address.setPostalCode(addressDto.getPostalCode());
        addressRepo.save(address);
    }
}