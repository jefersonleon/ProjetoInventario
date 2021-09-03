
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
public class Sala {
    private int pkidSala;
    private String sala;

    public int getPkid() {
        return pkidSala;
    }

    public void setPkid(int pkidsala) {
        this.pkidSala = pkidsala;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Sala{" + "pkid=" + pkidSala + ", sala=" + sala + '}';
    }
    
    
}
