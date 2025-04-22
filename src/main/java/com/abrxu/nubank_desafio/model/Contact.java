package com.abrxu.nubank_desafio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "txt_nickname", length = 35, nullable = false)
    private String nickname;

    @Column(name = "txt_name", length = 80, nullable = false)
    private String name;

    @Column(name = "txt_phone_number", length = 20, nullable = false)
    private String phoneNumber;

    @Column(name = "txt_secondary_phone_number", length = 20)
    private String secondaryPhoneNumber;

    // Sim, length 320 pois é o máximo que um email pode ter (64 antes do @ e 255 na parte de domínio do email)
    @Column(name = "txt_email", length = 320, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    @JsonBackReference
    private Customer customer;

    @Column(name = "dt_registration", nullable = false, updatable = false)
    private LocalDateTime registrationDate;

    @PrePersist
    protected void onCreate() {
        this.registrationDate = LocalDateTime.now();
    }

    @Column(name = "dt_last_updated")
    private LocalDateTime lastUpdated;

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdated = LocalDateTime.now();
    }

}
