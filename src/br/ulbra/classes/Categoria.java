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
public class Categoria {
    private int idPkCat;
    private String categoria;

    public int getIdPkCat() {
        return idPkCat;
    }

    public void setIdPkCat(int idPkCat) {
        this.idPkCat = idPkCat;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return  this.getCategoria();
    }

   
    
    
}
