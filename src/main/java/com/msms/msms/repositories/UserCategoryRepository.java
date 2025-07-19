package com.msms.msms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msms.msms.models.UserCategory;

public interface UserCategoryRepository extends JpaRepository<UserCategory, Integer> {

}
