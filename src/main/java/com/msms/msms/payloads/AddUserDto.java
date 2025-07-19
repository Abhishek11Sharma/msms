package com.msms.msms.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserDto {

    @NotBlank
    private String firstName;
    private String lastName;
    @NotBlank
    @Email
    private String emailId;
    @NotBlank
    private String phoneNumber;
    private String mobileNumber;
    @NotNull
    private Integer userCategoryId;
    @NotNull
    private Integer gradeId;

    @NotNull
    private AddressDto primaryAdd;
    private AddressDto secondaryAdd;
}
