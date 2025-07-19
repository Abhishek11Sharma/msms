package com.msms.msms.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private String address1;
    private String address2;
    private Integer cityId;
    private Integer stateId;
    private String pincode;
}
