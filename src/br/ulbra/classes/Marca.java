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
public class Marca {
    private int idPkMarca;
    private String marca;

    public int getIdPkMarca() {
        return idPkMarca;
    }

    public void setIdPkMarca(int idPkMarca) {
        this.idPkMarca = idPkMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return this.getMarca();
    }
    
    
    
}
