package br.edu.senaisp.controller;

import java.io.IOException;

import br.edu.senaisp.model.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/novoCliente")
public class NovoCliente extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String rua = req.getParameter("rua");
		int numero = Integer.parseInt(req.getParameter("numero"));
		String bairro = req.getParameter("bairro");
		String telefone = req.getParameter("telefone");

		Cliente c = new Cliente();
		c.setNome(nome);
		c.setRua(rua);
		c.setNumero(numero);
		c.setBairro(bairro);
		c.setTelefone(telefone);

		//SaborDAO dao = new SaborDAO();
		//dao.novo(s);

	}

}
