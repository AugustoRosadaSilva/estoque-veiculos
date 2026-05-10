package com.augusto.estoque_veiculos.repository;

import com.augusto.estoque_veiculos.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModeloRepository
        extends JpaRepository<Modelo, Long> {

    Optional<Modelo> findByNome(String nome);
}