package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.entity.Address;
import java.util.List;
import java.util.UUID;

public interface AddressServiceInterface {
    void getAddress(Address address);

    List<Address> getAddress();

    void addNewAddress(Address address);

    void deleteAddress(UUID addressId);

    void updateAddress(UUID addressId, String street, String city, String state, String postal_code);
}

