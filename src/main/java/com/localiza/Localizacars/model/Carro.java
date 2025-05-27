package com.localiza.Localizacars.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.localiza.Localizacars.enums.StatusCarro;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "carro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;

    private String modelo;
    private String cor;
    private int ano;
    private String cidade;
    private String proprietario;
    private String placa;

    @Enumerated(EnumType.STRING)
    private StatusCarro statusCarro;
}
