package br.edu.senaisp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import br.edu.senaisp.dao.SaborDAO;
import br.edu.senaisp.model.Sabor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/lista")
public class Lista extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("");
		
		StringBuilder html = new StringBuilder();
		html.append("");
		html.append("<!DOCTYPE html>");
		html.append("<html>");
		html.append("<head>");
		html.append("<meta charset='ISO-8859-1'>");
		html.append("<title>Pagina Principal</title>");
		html.append("</head>");
		html.append("<body>");
		
		SaborDAO dao = new SaborDAO();
		for (Sabor sabor : dao.lista()) {
			html.append("<h2>").append(sabor.getNome());
			html.append("<a href='/exclui?id="+ sabor.getId() +"'>Excluir</a>").append("</h2>");
			
		}
			
		html.append("</body>");
		html.append("</html>");
		
		PrintWriter pw = response.getWriter();
		pw.print(html.toString());

	}
}
