package com.internship.HRapp.repository;

import com.internship.HRapp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepo extends JpaRepository<Address,UUID> {

    @Query(value = "select addressID from Address")
    Address getAddressByAddressID(UUID addressID);

}
