package com.internship.HRapp.controller;

import com.internship.HRapp.dto.addressDto.AddressDto;
import com.internship.HRapp.service.concretes.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping (path ="api/v1/hr_management_system/addressess")
@RequiredArgsConstructor
public class AddressController {
    @Autowired
    private final AddressService addressService;

    @GetMapping("getAll")
    public ResponseEntity<List<AddressDto>> findAllAddresses(){
        return ResponseEntity.ok(addressService.getAddresses());
    }
    @PostMapping("/addNewAddress")
    public ResponseEntity<AddressDto> createNewAddress(@RequestBody AddressDto addressDto) {
        return ResponseEntity.ok(addressService.addNewAddress(addressDto));
    }
    @PutMapping("editAddress/{addressID}")
    public void editAddress(@RequestParam AddressDto addressDto){
        addressService.editAddress(addressDto);
    }


    @GetMapping("id/{addressID}")
    public ResponseEntity<AddressDto> findAddressById(@PathVariable UUID addressID){
        return ResponseEntity.ok(addressService.getAddressById(addressID));
    }
    @DeleteMapping("delete/{addressID}")
    public String deleteRolesById(@PathVariable UUID addressID) {
        return addressService.deleteAddressById(addressID);
    }
}