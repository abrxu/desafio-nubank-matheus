package com.abrxu.nubank_desafio.controller;

import com.abrxu.nubank_desafio.dtos.CustomerRegistrationRequestDTO;
import com.abrxu.nubank_desafio.dtos.CustomerRegistrationResponseDTO;
import com.abrxu.nubank_desafio.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes/v1")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerRegistrationResponseDTO> registerCustomer(@RequestBody CustomerRegistrationRequestDTO dto) {
        var response = customerService.registerCustomer(dto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
