/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.dao;

import br.ulbra.classes.Sala;
import br.ulbra.classes.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeferson Leon
 */
public class SalaDAO {

    Connection con;

    public SalaDAO() throws SQLException {
        con = ConnectionFactory.getConnection();
    }

//MÉTODO CRIADO PARA INSERIR USUÁRIO NO BANCO DE DADOS
    public void create(Sala s) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbsala (sala) VALUES (?)");

            stmt.setString(1, s.getSala());
          
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Sala Salva com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

// MÉTODO CRIADO PARA EXCLUIR DO BANCO DE DADOS
    public void delete(Sala s) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbsala WHERE pkidsala = ?");
            stmt.setInt(1, s.getPkid());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODO CRIADO PARA MODIFICAR NO BANCO DE DADOS
    public void update(Sala s) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbsala SET sala = ? WHERE pkidsala = ?");
            stmt.setString(1, s.getSala());
            

            stmt.setInt(2, s.getPkid());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Sala Atualizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODOS CRIADOS PARA FAZER PESQUISAS NO BANCO DE DADOS
//EM ORDEM DE CADASTRO TODOS
    public ArrayList<Sala> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Sala> salas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbsala");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Sala sala = new Sala();

                sala.setPkid(rs.getInt("pkidsala"));
                sala.setSala(rs.getString("sala"));
                
                salas.add(sala);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return (ArrayList<Sala>) salas;

    }

//PESQUISA PELO LOGIN
    public List<Sala> readForDesc(String desc, int opcao) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null; int tipo = 0;
        if(opcao == 1){
            sql = "SELECT * FROM tbsala ORDER BY sala ASC";
        }else if(opcao == 2){
             sql = "SELECT * FROM tbsala ORDER BY sala DESC";
        }else {
           sql = "SELECT * FROM tbsala WHERE sala LIKE ?";
           tipo=1;
        }
        
        
        ArrayList<Sala> salas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
          
            if (tipo==1 || tipo ==2){
                stmt.setString(1, "%" + desc + "%");                
            }
            rs = stmt.executeQuery();

            while (rs.next()) {

                Sala sala = new Sala();

                sala.setPkid(rs.getInt("pkidsala"));
                sala.setSala(rs.getString("sala"));
                salas.add(sala);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return salas;
    }

    
}
