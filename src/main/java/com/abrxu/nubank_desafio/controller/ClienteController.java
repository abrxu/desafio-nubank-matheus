package com.abrxu.nubank_desafio.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes/v1")
public class ClienteController {

    @PostMapping
    public ResponseEntity<Client> registerCliente

}
