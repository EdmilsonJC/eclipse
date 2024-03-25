package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {

	/** Módulo de conexão **/
	// Parâmetros de conexão

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1/dbagenda?useTimezone=true$serverTimezone=UTC";
	private String user = "root";
	private String password = "Aranha@01";

	// Método de conexão

	private Connection conectar() {
		Connection con = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;

		}
	}

//  Teste de conexão

//	public void TesteConexao() {
//		try {
//			
//			Connection con = conectar();
//			System.out.println(con);
//			con.close();
//			
//		} catch (Exception e) {
//			
//			System.out.println(e);
//		}
//	}

	/** CRUD CREATE **/

	public void inserirContato(JavaBeans contato) {

		String create = "INSERT INTO contatos (nome, fone, email) VALUES (?,?,?)";

		try {
			// abrir a conexão
			Connection con = conectar();

			// preparar a query para execução do banco de dados
			PreparedStatement pst = con.prepareStatement(create);

			// substituir os parametros (?) pelo conteúdo das variáveis
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());

			// Executar a query
			pst.executeUpdate();

			// Encerrar a conexão com o Banco de dados
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
