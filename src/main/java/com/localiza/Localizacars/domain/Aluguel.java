package com.localiza.Localizacars.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.localiza.Localizacars.utils.enums.StatusAluguel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "aluguel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;

    private Long cliente;
    private String carro;
    private String cidade;
    private int tempoAluguel;

    @Enumerated(EnumType.STRING)
    private StatusAluguel statusAluguel;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dataHoraInicio;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dataHoraFim;
}
