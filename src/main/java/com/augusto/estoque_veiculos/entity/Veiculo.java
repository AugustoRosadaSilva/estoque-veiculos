package com.augusto.estoque_veiculos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Cor é obrigatória")
    private String cor;

    @NotNull(message = "Ano é obrigatório")
    @Min(value = 1900, message = "Ano inválido")
    private Integer ano;

    @NotNull(message = "Preço é obrigatório")
    @Min(value = 0, message = "Preço não pode ser negativo")
    private Double preco;

    @NotNull(message = "Quilometragem é obrigatória")
    @Min(value = 0, message = "Quilometragem inválida")
    private Double quilometragem;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status é obrigatório")
    private StatusVeiculo status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;
}