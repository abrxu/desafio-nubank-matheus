package com.abrxu.nubank_desafio.services;

import com.abrxu.nubank_desafio.dtos.CustomerRegistrationRequestDTO;
import com.abrxu.nubank_desafio.dtos.CustomerRegistrationResponseDTO;
import com.abrxu.nubank_desafio.mapper.CustomerMapper;
import com.abrxu.nubank_desafio.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerRegistrationResponseDTO registerCustomer(CustomerRegistrationRequestDTO dto) {
        var customer = customerMapper.toEntity(dto);
        var customerDb = customerRepository.save(customer);
        return customerMapper.toDto(customerDb);
    }
}
