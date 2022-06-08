package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.addressDto.AddressDto;
import com.internship.HRapp.entity.Address;
import com.internship.HRapp.mapper.AddressMapper;
import com.internship.HRapp.repository.AddressRepo;
import com.internship.HRapp.service.interfaces.AddressServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressServiceInterface {
    private final AddressRepo addressRepo;
    private final AddressMapper addressMapper;

    @Override
    public AddressDto getAddressById(UUID addressid){
        return addressMapper.modeltoDto(addressRepo.getById(addressid));
    }

    @Override
    public List<AddressDto> getAddresses(){
        return addressMapper.toDto(addressRepo.findAll());
    }
    @Override
    public String deleteAddressById(UUID addressID){
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
}
