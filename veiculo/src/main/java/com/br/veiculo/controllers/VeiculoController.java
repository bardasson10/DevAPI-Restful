package com.br.veiculo.controllers;

import com.br.veiculo.model.VeiculoLista;
import com.br.veiculo.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ConcurrentModificationException;
import java.util.Objects;

@RestController
@RequestMapping("/automovel")
public class VeiculoController {

    @Autowired
    VeiculoService VeiculoService;
    @GetMapping("/lista")
    @ResponseBody
    public ResponseEntity<VeiculoService> listaVeiculos() {
        if (VeiculoService.getVeiculosLista().isEmpty()) {
            return ResponseEntity.notFound().build();
        }else{;
            return ResponseEntity.ok().body(VeiculoService);
        }
    }

    @PutMapping("/atualizar")
    @ResponseBody
    public ResponseEntity<String> atualizarVeiculo(@RequestParam Integer id, @RequestParam String marca,@RequestParam String modelo) {
        if (id == 0 || marca == null || modelo == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: Preencha todos os campos!");
        } else if (VeiculoService.getVeiculosLista().stream().noneMatch(veiculoService -> veiculoService.getId().equals(id))) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Veículo não encontrado!");
        } else {
            VeiculoService.atualizarVeiculo(id, marca, modelo);
            return ResponseEntity.status(HttpStatus.OK).body("Atualizado com sucesso!");
        }
    }

    @DeleteMapping("/deletar")
    @ResponseBody
    public ResponseEntity<String> deletarVeiculo(@RequestParam Integer id) {
        if (id == null || id <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: Preencha o campo ID!");
        }
        if (VeiculoService.getVeiculosLista().stream().noneMatch(veiculoService-> veiculoService.getId().equals(id))) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Veículo não encontrado!");
        } else {
            try {
                VeiculoService.deletarVeiculo(id);
            } catch (ConcurrentModificationException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Deletado com sucesso!");
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }


    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarVeiculo(@RequestParam Integer id, @RequestParam String marca, @RequestParam String modelo) {
        for (VeiculoLista veiculo : VeiculoService.getVeiculosLista()) {
            if (Objects.equals(veiculo.getId(), id)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: ID já existente!");
            }
        }
        VeiculoService.adicionarVeiculo(id, marca, modelo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Veículo adicionado com sucesso!");
    }


}
