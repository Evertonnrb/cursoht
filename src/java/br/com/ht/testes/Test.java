/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ht.testes;

import br.com.ht.entidades.Usuario;
import br.com.ht.jdbc.UsuarioDao;
import java.util.List;

/**
 *
 * @author everton
 */
public class Test {

    public static void main(String[] args) {
        //FabricaDeConexao.getConection();
        //testCadastrar();
        //testAlterar();
        //testExcluir();
        //testBuscarTodos();
        testBuscarPorId();
    }

    private static void testCadastrar() {
        Usuario usu = new Usuario();
        usu.setNome("Albatroz Figueiredo");
        usu.setLogin("Pozz");
        usu.setSenha("kkk");
        UsuarioDao usuDao = new UsuarioDao();
        usuDao.cadastrar(usu);
    }
    private static void testAlterar(){
        Usuario usuario = new Usuario();
        usuario.setId(2);
        usuario.setNome("Rita cadilac");
        usuario.setLogin("nono");
        usuario.setSenha("0000");
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.alterar(usuario);
    }
    private static void testExcluir(){
        Usuario usu = new Usuario();
        usu.setId(3);
        UsuarioDao usuDao = new UsuarioDao();
        usuDao.excluir(usu);
    }
    public static void testBuscarTodos(){
        UsuarioDao usuarioDao = new UsuarioDao();
        List<Usuario> resultado = usuarioDao.buscarTodos();
        for(Usuario c:resultado){
            System.out.println(c.getId()+""+c.getNome()+"\n"+c.getLogin()+"\n"+c.getSenha());
        }
    }
    public static void testBuscarPorId(){
       
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuRetorno = usuarioDao.buscaPorId(2);
        
        //System.out.println(usuarioDao.buscaPorId(2).getNome());
    
        if (usuRetorno != null) {
            System.out.println("nome "+usuRetorno.getNome());
        }
    
    }
}
