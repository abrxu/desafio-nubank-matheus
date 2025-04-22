package com.abrxu.nubank_desafio.dtos;

import com.abrxu.nubank_desafio.model.Contact;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record CustomerRegistrationResponseDTO(
        Long id, String nickname, String name, String phoneNumber,
        String email, List<Contact> contacts, LocalDateTime registrationDate
) {}
