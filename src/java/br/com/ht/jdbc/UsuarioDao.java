package br.com.ht.jdbc;

import br.com.ht.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDao {

    private Connection con = FabricaDeConexao.getConection();

    public void cadastrar(Usuario usu) {
        String sql = "INSERT INTO USUARIO(nome,login,senha)VALUES(?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, usu.getNome());
            pst.setString(2, usu.getLogin());
            pst.setString(3, usu.getSenha());
            pst.execute();
            pst.close();
            System.out.println("sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e, "Atenção", 2);
        }
    }

    public void alterar(Usuario usuario) {
        String sql = "UPDATE USUARIO SET nome=?, login=?, senha=? WHERE id=?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getLogin());
            pst.setString(3, usuario.getSenha());
            pst.setInt(4, usuario.getId());
            pst.execute();
            pst.close();
            System.out.println("alterado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
            e.printStackTrace();
        }
    }

    public void excluir(Usuario usu) {
        String sql = "DELETE FROM USUARIO WHERE id=?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, usu.getId());
            pst.execute();
            pst.close();
            System.out.println("Excluido");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }
    }

    public List<Usuario> buscarTodos() {
        String sql = "SELECT * FROM USUARIO";
        List<Usuario> lista = new ArrayList<Usuario>();
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();//execiteQuery boolean se vd tras o resul
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setId(rs.getInt("id"));//pegando os dados da tabel id nome login senha
                usu.setNome(rs.getString("nome"));
                usu.setLogin(rs.getString("login"));
                usu.setSenha(rs.getString("senha"));
                lista.add(usu);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }
        return lista;
    }
    
    public Usuario buscaPorId(Integer id){
        String sql = "SELECT * FROM USUARIO WHERE ID=?";
        Usuario usuario = null;
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }
        return usuario;
    }
  
}