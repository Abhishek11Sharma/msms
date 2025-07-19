package com.msms.msms.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.msms.msms.models.UserCategory;
import com.msms.msms.repositories.UserCategoryRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserCategoryService {

    private final UserCategoryRepository userCategoryRepository;

    @PostConstruct
    public void generateAutoUserCategory() {

        log.info("Generating auto user category");

        List<UserCategory> userCategories = new ArrayList<>(
                Arrays.asList(
                        new UserCategory(1, "Client"),
                        new UserCategory(2, "Admin"),
                        new UserCategory(3, "Teacher"),
                        new UserCategory(4, "Student")));

        try {
            userCategoryRepository.saveAll(userCategories);
        } catch (Exception e) {

        }
    }
}
