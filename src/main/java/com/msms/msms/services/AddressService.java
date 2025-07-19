package com.msms.msms.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.msms.msms.helpers.ExceptionHelper;
import com.msms.msms.models.Address;
import com.msms.msms.payloads.AddressDto;
import com.msms.msms.repositories.AddressRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;
    private final ExceptionHelper exceptionHelper;

    public Long addAddress(AddressDto addressDto) {

        Address address = modelMapper.map(addressDto, Address.class);

        try {
            address = addressRepository.save(address);
        } catch (Exception e) {
            exceptionHelper.sendExceptionEmail(e);
        }
        return address.getAddId();
    }
}
