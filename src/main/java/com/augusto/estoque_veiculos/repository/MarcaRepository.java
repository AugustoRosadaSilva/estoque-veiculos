package com.augusto.estoque_veiculos.repository;

import com.augusto.estoque_veiculos.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarcaRepository
        extends JpaRepository<Marca, Long> {

    Optional<Marca> findByNome(String nome);
}