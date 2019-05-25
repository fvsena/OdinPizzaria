package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Usuario;

public class UsuarioDAO {
	public boolean validarLogin(Usuario usuario) {
		String retorno = "0";
		try {
			Connection conn = ConnectionManager.getInstance().getConnection();
			String sql = ""
					+ " SELECT"
					+ "	 CASE"
					+ "		WHEN COUNT(0) > 0 THEN 1"
					+ "		ELSE 0"
					+ "	 END AS Valido"
					+ " FROM"
					+ "	 Usuario WITH (NOLOCK)"
					+ " WHERE"
					+ "	 Login = ?"
					+ "	 AND Senha = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.login);
			statement.setString(2, usuario.senha);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				retorno = rs.getString("Valido");
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao consultar o banco de dados");
		}
		return retorno.equals("1");
	}
}
