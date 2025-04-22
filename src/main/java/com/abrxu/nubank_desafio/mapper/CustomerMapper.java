package com.abrxu.nubank_desafio.mapper;

import com.abrxu.nubank_desafio.dtos.CustomerRegistrationRequestDTO;
import com.abrxu.nubank_desafio.dtos.CustomerRegistrationResponseDTO;
import com.abrxu.nubank_desafio.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerRegistrationResponseDTO toDto(Customer customer) {
        return CustomerRegistrationResponseDTO.builder()
                .id(customer.getId())
                .nickname(customer.getNickname())
                .name(customer.getName())
                .phoneNumber(customer.getPhoneNumber())
                .email(customer.getEmail())
                .contacts(customer.getContacts())
                .registrationDate(customer.getRegistrationDate())
                .build();
    }

    public Customer toEntity(CustomerRegistrationRequestDTO dto) {
        var customer = new Customer();
        customer.setNickname(dto.nickname());
        customer.setName(dto.name());
        customer.setPhoneNumber(dto.phoneNumber());
        customer.setEmail(dto.email());
        customer.setContacts(dto.contacts());
        return customer;
    }

}
