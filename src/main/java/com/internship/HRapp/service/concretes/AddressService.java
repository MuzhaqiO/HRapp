package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.addressDto.AddressDto;
import com.internship.HRapp.entity.Address;
import com.internship.HRapp.mapper.AddressMapper;
import com.internship.HRapp.repository.AddressRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private AddressMapper addressMapper;


    public AddressDto getAddressById(UUID addressId){
        boolean exists = addressRepo.existsById(addressId);
        if (!exists){
            throw new IllegalStateException(
                    "Address with id " + addressId + " does not exist!"
            );
        }
        return addressMapper.modeltoDto(addressRepo.getById(addressId));
    }

    public List<AddressDto> getAddresses(){
        return addressMapper.toDto(addressRepo.findAll());
    }

    public String deleteAddressById(UUID addressId){
        boolean exists = addressRepo.existsById(addressId);
        if (!exists){
            throw new IllegalStateException(
                    "Address with id " + addressId + " does not exist!"
            );
        }
        addressRepo.deleteById(addressId);
        return "address removed {}" + addressId;
    }

    public AddressDto addNewAddress(AddressDto addressDto) {
        Address createdAddress = addressRepo.save(addressMapper.dtotoModel(addressDto));
        return addressMapper.modeltoDto(createdAddress);
    }

    public void  editAddress(@NotNull AddressDto addressDto) {
      Address address =addressRepo.getAddressByAddressID(addressDto.getAddressID());
      address.setCity(addressDto.getCity());
      address.setState(addressDto.getState());
      address.setStreet(addressDto.getStreet());
      address.setPostalCode(addressDto.getPostalCode());
        addressRepo.save(address);
    }
}
