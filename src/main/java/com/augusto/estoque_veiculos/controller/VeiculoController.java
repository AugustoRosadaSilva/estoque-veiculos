package com.augusto.estoque_veiculos.controller;

import com.augusto.estoque_veiculos.dto.VeiculoRequestDTO;
import com.augusto.estoque_veiculos.entity.Veiculo;
import com.augusto.estoque_veiculos.service.VeiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin("*")
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Veiculo> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Veiculo salvar(
            @RequestBody VeiculoRequestDTO dto
    ) {

        return service.salvar(dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {

        service.deletar(id);
    }
}