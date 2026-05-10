package com.augusto.estoque_veiculos.service;

import com.augusto.estoque_veiculos.entity.Modelo;
import com.augusto.estoque_veiculos.repository.ModeloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {

    private final ModeloRepository repository;

    public ModeloService(ModeloRepository repository) {
        this.repository = repository;
    }


    public List<Modelo> listarTodos() {
        return repository.findAll();
    }


    public Modelo buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado"));
    }


    public Modelo salvar(Modelo modelo) {
        return repository.save(modelo);
    }


    public Modelo atualizar(Long id, Modelo novoModelo) {

        Modelo modelo = buscarPorId(id);

        modelo.setNome(novoModelo.getNome());
        modelo.setMarca(novoModelo.getMarca());

        return repository.save(modelo);
    }


    public void deletar(Long id) {
        repository.deleteById(id);
    }
}