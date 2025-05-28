package com.localiza.Localizacars.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;


import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;

    @Column(unique=true)
    private Long cpf;

    @Column(unique=true)
    private String email;

    private String nome;

    private String cidade;

    private String senha;

    private Long idade;

}
