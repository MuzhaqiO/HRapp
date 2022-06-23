package com.internship.HRapp.repository;

import com.internship.HRapp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AddressRepo extends JpaRepository<Address,UUID> {
 //   @Query(value = "select addressID from Address")
    Address getAddressByAddressID(UUID addressID);

    List<Address> getAddressByUsersUserId(@Param("userId")UUID userId);
}