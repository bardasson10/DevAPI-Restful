package com.br.veiculo.services;


import com.br.veiculo.model.VeiculoLista;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
@Service
public class VeiculoService {

    ArrayList<VeiculoLista> veiculos = new ArrayList<>();

    public VeiculoService() {
        veiculos.add(new VeiculoLista(1, "Chevrolet", "Onix"));
        veiculos.add(new VeiculoLista(2, "Volkswagen", "Gol"));
        veiculos.add(new VeiculoLista(3, "Fiat", "Uno"));
        veiculos.add(new VeiculoLista(4, "Ford", "Ka"));
        veiculos.add(new VeiculoLista(5, "Renault", "Kwid"));
    }

    public ArrayList<VeiculoLista> getVeiculosLista() {
        return veiculos;
    }

    public String adicionarVeiculo(Integer id, String marca, String modelo) {
        veiculos.add(new VeiculoLista(id, marca, modelo));
        return "Adicionado com sucesso!";
    }

    public void atualizarVeiculo(Integer id, String marca, String modelo) {
        for (VeiculoLista veiculo : veiculos) {
            if (veiculo.getId() == id) {
                veiculo.setMarca(marca);
                veiculo.setModelo(modelo);
            }
        }
    }

    public void deletarVeiculo(Integer id) {
        for (VeiculoLista veiculo : veiculos) {
            if (veiculo.getId() == id) {
                veiculos.remove(veiculo);
            }
        }
    }


}
