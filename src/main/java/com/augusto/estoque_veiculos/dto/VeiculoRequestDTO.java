package com.augusto.estoque_veiculos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoRequestDTO {

    private String marca;

    private String modelo;

    private String cor;

    private Integer ano;

    private Double preco;

    private Double quilometragem;

    private String status;
}