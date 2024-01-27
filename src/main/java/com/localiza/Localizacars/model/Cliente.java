package com.localiza.Localizacars.model;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique=true, name = "cpf")
    private Long cpf;
    @NotNull
    @Column(unique=true, name = "email")
    private String email;

    @NotNull
    @Column(name = "nome")
    private String nome;
    @NotNull
    @Column(name = "cidade")
    private String cidade;
    @NotNull
    @Column(name = "senha")
    private String senha;
    @NotNull
    @Column(name = "idade")
    private Long idade;
}
