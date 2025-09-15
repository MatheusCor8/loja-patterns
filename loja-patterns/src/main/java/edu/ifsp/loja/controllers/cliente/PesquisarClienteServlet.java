package edu.ifsp.loja.controllers.cliente;

import java.io.IOException;
import java.util.List;

import edu.ifsp.loja.modelo.Cliente;
import edu.ifsp.loja.persistencia.ClienteDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cliente/pesquisar")
public class PesquisarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String query = request.getParameter("query");

		if (query != null) {
			ClienteDAO dao = new ClienteDAO();
			List<Cliente> clientes = dao.findByName(query);
			request.setAttribute("clientes", clientes);
		}

		RequestDispatcher rd = request.getRequestDispatcher("/paginas/cliente/pesquisar.jsp");
		rd.forward(request, response);
	}

}
