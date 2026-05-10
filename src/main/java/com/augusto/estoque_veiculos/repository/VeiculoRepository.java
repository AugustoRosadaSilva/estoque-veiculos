package com.augusto.estoque_veiculos.repository;

import com.augusto.estoque_veiculos.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByStatus(String status);

    List<Veiculo> findByAno(Integer ano);

    List<Veiculo> findByPrecoBetween(Double min, Double max);
}