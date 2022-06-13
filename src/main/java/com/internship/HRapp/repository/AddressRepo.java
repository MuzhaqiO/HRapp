package com.internship.HRapp.repository;

import com.internship.HRapp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface AddressRepo extends JpaRepository<Address,UUID> {

    Address getAddressByAddressID(UUID addressID);
}