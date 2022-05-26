package com.internship.HRapp.controller;

import com.internship.HRapp.dto.addressDto.AddressDto;
import com.internship.HRapp.service.interfaces.AddressServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping (path ="api/v1/hr_management_system/addressess")
@RequiredArgsConstructor
public class AddressController {
    private final AddressServiceInterface addressServiceInterface;

    @GetMapping("getAll")
    public ResponseEntity<List<AddressDto>> findAllAddresses(){
        return ResponseEntity.ok(addressServiceInterface.getAddresses());
    }
    @PostMapping("/addNewAddress")
    public ResponseEntity<AddressDto> createNewAddress(@RequestBody AddressDto addressDto) {
        return ResponseEntity.ok(addressServiceInterface.addNewAddress(addressDto));
    }
    @PutMapping("editAddress/{addressID}")
    public void editAddress(@RequestParam AddressDto addressDto){
        addressServiceInterface.editAddress(addressDto);
    }


    @GetMapping("id/{addressID}")
    public ResponseEntity<AddressDto> findAddressById(@PathVariable UUID addressID){
        return ResponseEntity.ok(addressServiceInterface.getAddressById(addressID));
    }
    @DeleteMapping("delete/{addressID}")
    public String deleteRolesById(@PathVariable UUID addressID) {
        return addressServiceInterface.deleteAddressById(addressID);
    }
}