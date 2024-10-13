package com.br.veiculo.controllers;

import com.br.veiculo.model.VeiculoLista;
import com.br.veiculo.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Objects;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    VeiculoService VeiculoService;
    VeiculoLista VeiculoLista;
    @GetMapping("/lista")
    public ArrayList<VeiculoLista> listaVeiculos() {
        if (VeiculoService.getVeiculosLista().isEmpty()) {
            return null;
        }else{
            String retorno = HttpStatus.OK + "\nLista de veículos:";
            return VeiculoService.getVeiculosLista();
        }
    }

    @PutMapping("/atualizar")
    public String atualizarVeiculo(Integer id, String marca, String modelo) {
        if (id == 0 || marca == null || modelo == null) {
            return HttpStatus.UNAUTHORIZED + "\nErro: Preencha todos os campos!";
        } else if (VeiculoService.getVeiculosLista().stream().noneMatch(veiculoLista -> veiculoLista.getId().equals(id))) {
            return HttpStatus.NO_CONTENT + "\nErro: Veículo não encontrado!";
        } else {
            VeiculoService.atualizarVeiculo(id, marca, modelo);
            return HttpStatus.OK+ "\nAtualizado com sucesso!";
        }
    }

    @DeleteMapping("/deletar")
    public String deletarVeiculo(Integer id) {
        if (id == null || id <= 0) {
            return HttpStatus.UNAUTHORIZED + "\nErro: Preencha o campo ID!";
        }
        if (VeiculoService.getVeiculosLista().stream().noneMatch(veiculoLista -> veiculoLista.getId().equals(id))) {
            return HttpStatus.NO_CONTENT + " \nErro: Veículo não encontrado!";
        } else {
            try {
                VeiculoService.deletarVeiculo(id);
            } catch (ConcurrentModificationException e) {
                return HttpStatus.OK + " \nVeiculo Deletado com sucesso!";
            }
        }
        return HttpStatus.OK + " \nDeletado com sucesso!";
    }


    @PostMapping("/adicionar")
    public String adicionarVeiculo(Integer id, String marca, String modelo) {
        for (VeiculoLista veiculo : VeiculoService.getVeiculosLista()) {
            if (Objects.equals(veiculo.getId(), id)) {
                return HttpStatus.UNAUTHORIZED + " \nERRO: Veículo ja existe!";
            }
        }
        VeiculoService.adicionarVeiculo(id, marca, modelo);
        return HttpStatus.OK+"\nAdicionado com sucesso!";
    }


}
