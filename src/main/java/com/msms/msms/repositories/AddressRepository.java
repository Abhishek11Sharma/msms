package com.msms.msms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msms.msms.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
