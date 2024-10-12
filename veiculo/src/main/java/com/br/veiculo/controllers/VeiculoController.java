package com.br.veiculo.controllers;

import com.br.veiculo.model.VeiculoLista;
import com.br.veiculo.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
            String retorno = HttpStatus.OK + "Veículos listados com sucesso!";
            return VeiculoService.getVeiculosLista();
        }
    }

    @PostMapping("/adicionar")
    public String adicionarVeiculo(Integer id, String marca, String modelo) {
        if (id.equals(VeiculoLista.getId()) && marca.equals(VeiculoLista.getMarca()) && modelo.equals(VeiculoLista.getModelo())) {
            return HttpStatus.UNAUTHORIZED + "Veículo ja existe!";
        } else {
            return ("Veículo adicionado com sucesso!");
        }
    }

    @PutMapping("/atualizar")
    public String atualizarVeiculo(Integer id, String marca, String modelo) {
        if (id == 0 || marca == null || modelo == null) {
            return HttpStatus.UNAUTHORIZED + "Erro: Preencha todos os campos!";
        } else {
            VeiculoService.atualizarVeiculo(id, marca, modelo);
            return "Atualizado com sucesso!";
        }
    }

    @DeleteMapping("/deletar")
    public String deletarVeiculo(Integer id) {
        if (id == 0) {
            return HttpStatus.UNAUTHORIZED + "Erro: Preencha todos os campos!";
        }else {
            VeiculoService.deletarVeiculo(id);
            return "Deletado com suceso!";
        }
    }

}
