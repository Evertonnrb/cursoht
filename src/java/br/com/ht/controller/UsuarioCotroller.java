package br.com.ht.controller;

import br.com.ht.entidades.Usuario;
import br.com.ht.jdbc.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 @WebServlet("/usucontroller.do")
public class UsuarioCotroller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Helllo world"
                    + "</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioCotroller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        System.out.println("chamou o do get");
   
        String nome = request.getParameter("nome");
        System.out.println("Nome: "+nome);
        
        String empresa = request.getParameter("empresa");
        System.out.println("Empresa = "+empresa);
        
        PrintWriter saida = response.getWriter();
        saida.println("Nome "+nome+" Empresa "+empresa);
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String nome = request.getParameter("txt_nome");
        String login = request.getParameter("txt_login");
        String senha = request.getParameter("txt_senha");
        Usuario usu  = new Usuario();
        usu.setNome(nome);
        usu.setLogin(login);
        usu.setSenha(senha);
        
        UsuarioDao usuarioDao =  new UsuarioDao();
        usuarioDao.cadastrar(usu);
        
        System.out.println("chamou o do post");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
