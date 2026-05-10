package com.augusto.estoque_veiculos.controller;

import com.augusto.estoque_veiculos.entity.Marca;
import com.augusto.estoque_veiculos.service.MarcaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaService service;

    public MarcaController(MarcaService service) {
        this.service = service;
    }


    @GetMapping
    public List<Marca> listar() {
        return service.listarTodos();
    }


    @GetMapping("/{id}")
    public Marca buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }


    @PostMapping
    public Marca salvar(@RequestBody Marca marca) {
        return service.salvar(marca);
    }


    @PutMapping("/{id}")
    public Marca atualizar(@PathVariable Long id,
                           @RequestBody Marca marca) {

        return service.atualizar(id, marca);
    }


    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}