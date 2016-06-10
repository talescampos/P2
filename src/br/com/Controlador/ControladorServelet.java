package br.com.Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jdbc.ProdutoDAO;
import br.com.beans.Produto;

/**
 * Servlet implementation class ControladorServelet
 */
@WebServlet("/ControladorServelet")
public class ControladorServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ControladorServelet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Produto prod = new Produto();
		ProdutoDAO prodDAO = new ProdutoDAO();
		
		List<Produto> lista = prodDAO.buscarProduto(prod);
		
		request.setAttribute("lista", lista);
		RequestDispatcher saida = request.getRequestDispatcher("CatalogoDeProduto.jsp");
		saida.forward(request, response);
		
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
