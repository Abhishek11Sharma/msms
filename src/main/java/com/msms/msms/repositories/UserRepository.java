package com.msms.msms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msms.msms.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
