/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.dao;

import br.ulbra.classes.Categoria;
import br.ulbra.classes.Hardware;
import br.ulbra.classes.Marca;
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
public class HardwareDAO {

    Connection con;

    public HardwareDAO() throws SQLException {
        con = ConnectionFactory.getConnection();
    }

//MÉTODO CRIADO PARA INSERIR USUÁRIO NO BANCO DE DADOS
    public void create(Hardware h) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbHardware(nome,modelo,estado,data,"
                    + " preco,caracteristica,fkidcategoria,fkidmarca) VALUES (?,?,?,?,?,?,?,?)");

            stmt.setString(1, h.getNome());

            stmt.setString(2, h.getModelo());
            stmt.setString(3, h.getEstado());
            stmt.setString(4, h.getData());
            stmt.setDouble(5, h.getPreco());
            stmt.setString(6, h.getCarateristica());
            stmt.setInt(7, h.getCategoria().getIdPkCat());
            stmt.setInt(8, h.getMarca().getIdPkMarca());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Hardware Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar:" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

// MÉTODO CRIADO PARA EXCLUIR DO BANCO DE DADOS
    public void delete(Hardware h) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbHardware WHERE pkidhard = ?");
            stmt.setInt(1, h.getIdHard());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODO CRIADO PARA MODIFICAR NO BANCO DE DADOS
    public void update(Hardware h) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbhardware SET nome=?, modelo=?, estado=?, data=?, preco=?, caracteristica=?, fkidcategoria=?, fkidmarca=? WHERE pkidhard = ?");
            stmt.setString(1, h.getNome());
            stmt.setString(2, h.getModelo());
            stmt.setString(3, h.getEstado());
            stmt.setString(4, h.getData());
            stmt.setDouble(5, h.getPreco());
            stmt.setString(6, h.getCarateristica());

     
            stmt.setInt(7, h.getCategoria().getIdPkCat());
            stmt.setInt(8, h.getMarca().getIdPkMarca());
            stmt.setInt(9, h.getIdHard());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODOS CRIADOS PARA FAZER PESQUISAS NO BANCO DE DADOS
//MÉTODO PARA RETORNAR AS CATEGORIAS PARA A COMBOBOX
    public ArrayList<Categoria> listaCategoria() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Categoria> cs = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbcategoria order by categoria ASC ");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Categoria c = new Categoria();

                c.setIdPkCat(rs.getInt("pkidcategoria"));
                c.setCategoria(rs.getString("categoria"));

                cs.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HardwareDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return (ArrayList<Categoria>) cs;

    }

    //MÉTODO PARA RETORNAR AS MARCA PARA A COMBOBOX
    public ArrayList<Marca> listaMarca() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Marca> ms = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbmarca");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Marca m = new Marca();

                m.setIdPkMarca(rs.getInt("pkidmarca"));
                m.setMarca(rs.getString("marca"));

                ms.add(m);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HardwareDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return (ArrayList<Marca>) ms;

    }

//EM ORDEM DE CADASTRO TODOS
    public ArrayList<Hardware> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Hardware> hs = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT h.pkidhard, h.nome, h.modelo, h.estado, h.data,h.preco,"
                    + " h.caracteristica, c.categoria, m.marca FROM tbhardware as h "
                    + "join tbcategoria as c on (h.fkidCategoria=c.pkidcategoria) "
                    + "join tbmarca as m on (h.fkidmarca = m.pkidmarca)");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Hardware hard = new Hardware();
                Categoria c = new Categoria();
                c.setCategoria(rs.getString("categoria"));
                Marca m = new Marca();
                m.setMarca(rs.getString("marca"));
                hard.setIdHard(rs.getInt("pkidhard"));
                hard.setNome(rs.getString("nome"));
                hard.setModelo(rs.getString("modelo"));
                hard.setEstado(rs.getString("estado"));
                hard.setData(rs.getString("data"));
                hard.setPreco(rs.getDouble("preco"));
                hard.setCategoria(c);
                hard.setMarca(m);
                hard.setCarateristica(rs.getString("caracteristica"));
                hs.add(hard);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HardwareDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return (ArrayList<Hardware>) hs;

    }

//PESQUISA PELO LOGIN
    public List<Usuario> readForDesc(String desc, int opcao) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null;
        int tipo = 0;
        if (opcao == 1) {
            sql = "SELECT * FROM tbusuario ORDER BY nome ASC";
        } else if (opcao == 2) {
            sql = "SELECT * FROM tbusuario ORDER BY nome DESC";
        } else if (opcao == 3) {
            sql = "SELECT * FROM tbusuario WHERE nome LIKE ?";
            tipo = 1;
        } else {
            sql = "SELECT * FROM tbusuario WHERE email LIKE ?";
            tipo = 2;
        }

        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);

            if (tipo == 1 || tipo == 2) {
                stmt.setString(1, "%" + desc + "%");
            }
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setId(rs.getInt("pkidusuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCelular(rs.getString("fone"));
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HardwareDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return usuarios;
    }

}
