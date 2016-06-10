package br.com.Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.jdbc.ClienteDAO;
import br.com.beans.Cliente;

/**
 * Servlet implementation class Autenticador
 */
@WebServlet("/Autenticador")
public class Autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autenticador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession(false);
		if(sessao!=null){
			sessao.invalidate();
		}
		
		response.sendRedirect("Index.jsp");
		
	}		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String slogin = request.getParameter("login");
		String ssenha = request.getParameter("senha");

		Cliente cli = new Cliente();
		cli.setLogin(slogin);
		cli.setSenha(ssenha);

		ClienteDAO cliDAO = new ClienteDAO();
		Cliente cliAutenticado = cliDAO.autenticacao(cli);

		if(cliAutenticado != null){
			HttpSession sessao = request.getSession();
			sessao.setAttribute("cliAutenticado", cliAutenticado);
			
			
			
			request.getRequestDispatcher("Index.jsp").forward(request, response);

		}
		else
		{
		response.sendRedirect("erroLogin.jsp");
		}
	
	
	}

}
