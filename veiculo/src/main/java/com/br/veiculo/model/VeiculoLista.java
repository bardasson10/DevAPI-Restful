package com.br.veiculo.model;


import nonapi.io.github.classgraph.json.Id;

public class VeiculoLista {

    private Integer id;
    private String Marca;
    private String Modelo;

    public VeiculoLista(Integer id, String Marca, String Modelo) {
        this.id = id;
        this.Marca = Marca;
        this.Modelo = Modelo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }
}
