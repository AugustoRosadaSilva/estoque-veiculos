package com.augusto.estoque_veiculos.service;

import com.augusto.estoque_veiculos.dto.VeiculoRequestDTO;
import com.augusto.estoque_veiculos.entity.Marca;
import com.augusto.estoque_veiculos.entity.Modelo;
import com.augusto.estoque_veiculos.entity.StatusVeiculo;
import com.augusto.estoque_veiculos.entity.Veiculo;
import com.augusto.estoque_veiculos.repository.MarcaRepository;
import com.augusto.estoque_veiculos.repository.ModeloRepository;
import com.augusto.estoque_veiculos.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    private final MarcaRepository marcaRepository;

    private final ModeloRepository modeloRepository;

    public VeiculoService(
            VeiculoRepository veiculoRepository,
            MarcaRepository marcaRepository,
            ModeloRepository modeloRepository
    ) {

        this.veiculoRepository = veiculoRepository;
        this.marcaRepository = marcaRepository;
        this.modeloRepository = modeloRepository;
    }

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Veiculo salvar(VeiculoRequestDTO dto) {



        Marca marca = marcaRepository
                .findByNome(dto.getMarca())
                .orElseGet(() -> {

                    Marca novaMarca = new Marca();

                    novaMarca.setNome(dto.getMarca());

                    return marcaRepository.save(novaMarca);
                });



        Modelo modelo = modeloRepository
                .findByNome(dto.getModelo())
                .orElseGet(() -> {

                    Modelo novoModelo = new Modelo();

                    novoModelo.setNome(dto.getModelo());

                    novoModelo.setMarca(marca);

                    return modeloRepository.save(novoModelo);
                });



        Veiculo veiculo = new Veiculo();

        veiculo.setCor(dto.getCor());

        veiculo.setAno(dto.getAno());

        veiculo.setPreco(dto.getPreco());

        veiculo.setQuilometragem(dto.getQuilometragem());

        veiculo.setStatus(StatusVeiculo.valueOf(dto.getStatus()));

        veiculo.setModelo(modelo);

        return veiculoRepository.save(veiculo);
    }

    public void deletar(Long id) {
        veiculoRepository.deleteById(id);
    }

    public Veiculo atualizar(Long id, VeiculoRequestDTO dto) {

        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Veículo não encontrado"));



        Marca marca = marcaRepository
                .findByNome(dto.getMarca())
                .orElseGet(() -> {

                    Marca novaMarca = new Marca();

                    novaMarca.setNome(dto.getMarca());

                    return marcaRepository.save(novaMarca);
                });



        Modelo modelo = modeloRepository
                .findByNome(dto.getModelo())
                .orElseGet(() -> {

                    Modelo novoModelo = new Modelo();

                    novoModelo.setNome(dto.getModelo());

                    novoModelo.setMarca(marca);

                    return modeloRepository.save(novoModelo);
                });



        veiculo.setCor(dto.getCor());

        veiculo.setAno(dto.getAno());

        veiculo.setPreco(dto.getPreco());

        veiculo.setQuilometragem(dto.getQuilometragem());

        veiculo.setStatus(StatusVeiculo.valueOf(dto.getStatus()));

        veiculo.setModelo(modelo);

        return veiculoRepository.save(veiculo);
    }

    public Veiculo buscarPorId(Long id) {

        return veiculoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Veículo não encontrado"));
    }
}
