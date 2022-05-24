package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.addressDto.AddressDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AddressServiceInterface {

    List<AddressDto> getAddresses();

    AddressDto addNewAddress(AddressDto addressDto);
    AddressDto getAddressById(UUID addressid);

    void editAddress(AddressDto addressDto);

    String deleteAddressById(UUID addressID);
}

