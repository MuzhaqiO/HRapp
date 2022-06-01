package com.internship.HRapp.controller;

import com.internship.HRapp.entity.Address;
import com.internship.HRapp.service.implementation.AddressServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/hr/management_system")
@NoArgsConstructor
public class AddressController {
    private AddressServiceImpl addressServiceImpl;

    @GetMapping("/{addressid}")
    public List<Address> getAddress(){
        return addressServiceImpl.getAddress();
    }
    public void getAddress(Address address){
        addressServiceImpl.getAddress(address);
    }
    @PostMapping
    public void registerNewAddress(@RequestBody Address address){
        addressServiceImpl.addNewAddress(address);
    }
    @DeleteMapping(path = "{addressid}")
    public void deleteAddress(@PathVariable("addressid") UUID addressid){
        addressServiceImpl.deleteAddress(addressid);
    }
    @PutMapping()
    public void updateAddress(
            @RequestParam UUID addressid,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String street,
            @RequestParam(required = false) String postal_code){
        addressServiceImpl.updateAddress(addressid,state,city,street,postal_code);
    }
}
