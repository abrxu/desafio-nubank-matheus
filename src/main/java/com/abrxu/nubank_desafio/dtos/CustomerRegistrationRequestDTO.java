package com.abrxu.nubank_desafio.dtos;

import com.abrxu.nubank_desafio.model.Contact;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CustomerRegistrationRequestDTO(
        @Size(message = "O seu apelido não pode ter mais de 35 caracteres.", max = 35)
        String nickname,

        @NotNull(message = "É necessário informar um nome.")
        @NotBlank(message = "É necessário informar um nome.")
        @Size(message = "O seu nome não pode ter mais de 80 caracteres.")
        String name,

        @NotNull(message = "É necessário informar um número de telefone.")
        @NotBlank(message = "É necessário informar um número de telefone.")
        @Size(message = "O seu número de telefone não pode ter mais de 20 caracteres.")
        String phoneNumber,

        @NotNull(message = "É necessário informar um e-mail.")
        @NotBlank(message = "É necessário informar um e-mail.")
        @Size(message = "O seu e-mail não pode ter mais de 320 caracteres.")
        @Email(message = "O e-mail cadastrado deve ser um e-mail válido.")
        String email,

        List<@Valid Contact> contacts
) {
    public CustomerRegistrationRequestDTO {
        nickname = (nickname == null || nickname.isBlank()) ? null : nickname.trim();
        name = name.trim();
        phoneNumber = phoneNumber.trim();
        contacts = contacts == null ? List.of() : List.copyOf(contacts);
    }
}
