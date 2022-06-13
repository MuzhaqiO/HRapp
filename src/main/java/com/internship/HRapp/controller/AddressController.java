package com.internship.HRapp.controller;

import com.internship.HRapp.dto.addressDto.AddressDto;
import com.internship.HRapp.dto.userDTO.AssignUserDTO;
import com.internship.HRapp.service.concretes.AddressService;
import com.internship.HRapp.service.interfaces.AddressServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping (path ="api/v1/hr_management_system/addresses")
@RequiredArgsConstructor
public class AddressController {
    @Autowired
    private final AddressServiceInterface addressServiceInterface;

    @GetMapping("getAll")
    public ResponseEntity<List<AddressDto>> findAllAddresses(){
        return ResponseEntity.ok(addressServiceInterface.getAddresses());
    }
    @PostMapping("addNewAddress")
    public ResponseEntity<AddressDto> createNewAddress(@RequestBody AddressDto addressDto) {
        return ResponseEntity.ok(addressServiceInterface.addNewAddress(addressDto));
    }
    @PutMapping("editAddress/{addressID}")
    public void editAddress(@RequestBody AddressDto addressDto){
        addressServiceInterface.editAddress(addressDto);
    }
    @PatchMapping("assignUser/{addressID}")
    public ResponseEntity<AssignUserDTO> assignUserToAddress(@PathVariable UUID addressID, @RequestBody AssignUserDTO assignUserDTO){
        return ResponseEntity.ok(addressServiceInterface.assignUserToAddress(addressID, assignUserDTO));
    }
    @PatchMapping("removeUser/{addressID}")
    public ResponseEntity<AssignUserDTO> removeUserFromAddress(@PathVariable UUID addressID, @RequestParam UUID userId){
        return ResponseEntity.ok(addressServiceInterface.removeUserFromAddress(addressID, userId));
    }

    @GetMapping("getAddressById/{addressID}")
    public ResponseEntity<AddressDto> findAddressById(@PathVariable UUID addressID){
        return ResponseEntity.ok(addressServiceInterface.getAddressById(addressID));
    }
    @DeleteMapping("deleteAddress/{addressId}")
    public String deleteRolesById(@PathVariable UUID addressID) {
        return addressServiceInterface.deleteAddressById(addressID);
    }
}