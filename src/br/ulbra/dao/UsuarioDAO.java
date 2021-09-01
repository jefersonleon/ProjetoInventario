/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.dao;

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
public class UsuarioDAO {

    Connection con;

    public UsuarioDAO() throws SQLException {
        con = ConnectionFactory.getConnection();
    }

//MÉTODO CRIADO PARA INSERIR USUÁRIO NO BANCO DE DADOS
    public void create(Usuario u) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbusuario (nome,email, senha,fone) VALUES (?,?,?,?)");

            stmt.setString(1, u.getNome());
          
            stmt.setString(2, u.getCelular());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getSenha());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuário Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

// MÉTODO CRIADO PARA EXCLUIR DO BANCO DE DADOS
    public void delete(Usuario u) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbusuario WHERE idusuario = ?");
            stmt.setInt(1, u.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODO CRIADO PARA MODIFICAR NO BANCO DE DADOS
    public void update(Usuario u) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbusuario SET nome = ?, fone = ?, email = ? WHERE idusuario = ?");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getCelular());
            stmt.setString(3, u.getEmail());
          

            stmt.setInt(6, u.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODOS CRIADOS PARA FAZER PESQUISAS NO BANCO DE DADOS
//EM ORDEM DE CADASTRO TODOS
    public ArrayList<Usuario> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbusuario");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setId(rs.getInt("idusuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCelular(rs.getString("fone"));
                usuario.setEmail(rs.getString("email"));

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return (ArrayList<Usuario>) usuarios;

    }

//PESQUISA PELO LOGIN
    public List<Usuario> readForDesc(String desc, int opcao) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null; int tipo = 0;
        if(opcao == 1){
            sql = "SELECT * FROM tbusuario ORDER BY nome ASC";
        }else if(opcao == 2){
             sql = "SELECT * FROM tbusuario ORDER BY nome DESC";
        }else if(opcao == 3){
           sql = "SELECT * FROM tbusuario WHERE nome LIKE ?";
           tipo=1;
        }else{
              sql = "SELECT * FROM tbusuario WHERE email LIKE ?";
              tipo = 2;
        }
        
        
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
          
            if (tipo==1 || tipo ==2){
                stmt.setString(1, "%" + desc + "%");                
            }
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setId(rs.getInt("idusuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCelular(rs.getString("fone"));
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return usuarios;
    }

    public boolean checkLogin(String email, String senha) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM tbusuario WHERE email = ? and senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

    }
}
