package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.addressDto.UserAddressDTO;
import com.internship.HRapp.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AddressServiceInterface {

    List<UserAddressDTO> getAddresses();

    UserAddressDTO addNewAddress(UserAddressDTO addressDto);

    UserAddressDTO getAddressById(UUID addressID);

    void editAddress(UserAddressDTO addressDto);

    String deleteAddressById(UUID addressID);

}
