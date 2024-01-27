package com.localiza.Localizacars.model;


import com.localiza.Localizacars.enums.StatusCarro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "carro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "modelo")
    private String modelo;
    @NotNull
    @Column(name = "cor")
    private String cor;
    @NotNull
    @Column(name = "ano")
    private int ano;
    @NotNull
    @Column(name = "cidade")
    private String cidade;
    @NotNull
    @Column(name = "proprietario")
    private String proprietario;
    @NotNull
    @Column(unique = true, name = "placa")
    private String placa;
    @NotNull
    @Column(name = "statusCarro")
    private StatusCarro statusCarro;

//    @ManyToOne
//    @JoinColumn(name = "client_id")
//    private Cliente cliente;
}
