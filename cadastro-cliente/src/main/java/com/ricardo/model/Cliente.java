package com.ricardo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    @Length(min = 5, max = 200)
    private String nome;

    @Column
    @NotNull
    @Email
    private String email;

    @Column
    @NotNull
    @Length(min = 10, max = 11)
    private String telefone;

    @Column
    @NotNull
    @Length(min = 5, max = 200)
    private String endereco;
}
