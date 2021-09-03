/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.classes;

/**
 *
 * @author Jeferson
 */
public class Hardware {
    private int idHard;
    private String nome;
    private String modelo;
    private String estado;
    private String data;
    private double preco;
    private Categoria categoria;
    private Marca marca;
    private String carateristica;

    public int getIdHard() {
        return idHard;
    }

    public void setIdHard(int idHard) {
        this.idHard = idHard;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getCarateristica() {
        return carateristica;
    }

    public void setCarateristica(String carateristica) {
        this.carateristica = carateristica;
    }

    @Override
    public String toString() {
        return "Hardware{" + "idHard=" + idHard + ", nome=" + nome + ", modelo=" + modelo + ", estado=" + estado + ", data=" + data + ", preco=" + preco + ", categoria=" + categoria + ", marca=" + marca + ", carateristica=" + carateristica + '}';
    }
    
    
    
    
    
    
    
    
}
