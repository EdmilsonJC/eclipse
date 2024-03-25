package Controller;

import java.io.IOException;

import Model.DAO;
import Model.JavaBeans;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contatinho = new JavaBeans();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// teste de conexão
		// dao.TesteConexao();

		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main")) {
			Contatos(request, response);
		}else if(action.equals("/insert")) {
			novoContato(request, response);
		}else {
			response.sendRedirect("index.html");
		}

	}
	// Listar Contatos

	protected void Contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("Agenda.jsp");
	}
	
	// Listar Novo Contato

		protected void novoContato(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			//teste de recebimento dos dados do formulário
			//System.out.println(request.getParameter("nome"));
			//System.out.println(request.getParameter("fone"));
			//System.out.println(request.getParameter("email"));
			
			// setar as variáveis JavaBeans
			
			contatinho.setNome(request.getParameter("nome"));
			contatinho.setFone(request.getParameter("fone"));
			contatinho.setEmail(request.getParameter("email"));
			
			/** invocar o metodo inserirContato passando o objeto contato**/
			
			dao.inserirContato(contatinho);
			//redirecionar para o documento agenda.jsp
			
			response.sendRedirect("main");
			
		}

}
