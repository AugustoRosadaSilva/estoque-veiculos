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

    @PutMapping("/{id}")
    public Veiculo atualizar(@PathVariable Long id,
                             @RequestBody VeiculoRequestDTO dto) {

        return service.atualizar(id, dto);
    }

    @GetMapping("/{id}")
    public Veiculo buscarPorId(@PathVariable Long id) {

        return service.buscarPorId(id);
    }

    }


