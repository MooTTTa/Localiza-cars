package com.localiza.Localizacars.model;


import com.localiza.Localizacars.enums.StatusCarro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
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
    private StatusCarro statusCarro;
}
