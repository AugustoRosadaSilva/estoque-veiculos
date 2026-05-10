package com.augusto.estoque_veiculos.service;

import com.augusto.estoque_veiculos.entity.Marca;
import com.augusto.estoque_veiculos.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    private final MarcaRepository repository;

    public MarcaService(MarcaRepository repository) {
        this.repository = repository;
    }


    public List<Marca> listarTodos() {
        return repository.findAll();
    }


    public Marca buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca não encontrada"));
    }


    public Marca salvar(Marca marca) {
        return repository.save(marca);
    }


    public Marca atualizar(Long id, Marca novaMarca) {

        Marca marca = buscarPorId(id);

        marca.setNome(novaMarca.getNome());

        return repository.save(marca);
    }


    public void deletar(Long id) {
        repository.deleteById(id);
    }
}