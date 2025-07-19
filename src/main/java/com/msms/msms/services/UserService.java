package com.msms.msms.services;

import org.springframework.stereotype.Service;

import com.msms.msms.helpers.ExceptionHelper;
import com.msms.msms.models.User;
import com.msms.msms.payloads.AddUserDto;
import com.msms.msms.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private AddressService addressService;

    private final UserRepository userRepository;
    private final ExceptionHelper exceptionHelper;

    public long userResposne = 0;

    public long addUser(AddUserDto addUserDto) {

        Long primaryAddId = addressService.addAddress(addUserDto.getPrimaryAdd());
        Long secondaryAddId = null;
        if (addUserDto.getSecondaryAdd() != null) {
            secondaryAddId = addressService.addAddress(addUserDto.getSecondaryAdd());
        }

        User user = new User();
        user.setEmailId(addUserDto.getEmailId());
        user.setFirstName(addUserDto.getFirstName());
        user.setGradeId(addUserDto.getGradeId());
        user.setLastName(addUserDto.getLastName());
        user.setMobileNumber(addUserDto.getMobileNumber());
        user.setPhoneNumber(addUserDto.getPhoneNumber());
        user.setPrimaryAddId(primaryAddId);
        user.setSecondaryAddId(secondaryAddId);
        user.setUserCategoryId(addUserDto.getUserCategoryId());

        try {
            user = userRepository.save(user);
        } catch (Exception e) {
            exceptionHelper.sendExceptionEmail(e);
        }
        return user.getUserId();
    }
}
