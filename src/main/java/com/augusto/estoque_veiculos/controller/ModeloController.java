package com.augusto.estoque_veiculos.controller;

import com.augusto.estoque_veiculos.entity.Modelo;
import com.augusto.estoque_veiculos.service.ModeloService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelos")
@CrossOrigin("*")
public class ModeloController {

    private final ModeloService service;

    public ModeloController(ModeloService service) {
        this.service = service;
    }

    @GetMapping
    public List<Modelo> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Modelo buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Modelo salvar(@RequestBody Modelo modelo) {
        return service.salvar(modelo);
    }

    @PutMapping("/{id}")
    public Modelo atualizar(@PathVariable Long id,
                            @RequestBody Modelo modelo) {

        return service.atualizar(id, modelo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}