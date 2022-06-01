package com.internship.HRapp.service.implementation;

import com.internship.HRapp.entity.Address;
import com.internship.HRapp.service.interfaces.AddressServiceInterface;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@NoArgsConstructor
public class AddressServiceImpl implements AddressServiceInterface {
    @Override
    public void getAddress(Address address){
    }
    @Override
    public List<Address> getAddress(){
        return null;
    }
    @Override
    public void addNewAddress(Address address){
    }
    @Override
    public void deleteAddress(UUID AddressID){
    }

    @Override
    public void updateAddress(UUID addressId, String street, String city, String state, String postal_code) {

    }
}
