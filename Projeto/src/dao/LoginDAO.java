package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Login;

public class LoginDAO {

	public LoginDAO() {
	}

	public boolean consultaLogin(Login login) {

		ConexaoMySQL.abrirConexao();

		String sql = "select * from login where usuario like ? and senha like ?";

		try {
			PreparedStatement prepS = ConexaoMySQL.getCon().prepareStatement(sql);
			prepS.setString(1, login.getUsuario());
			prepS.setString(2, login.getSenha());
			ResultSet res = prepS.executeQuery();

			if (res.next())
				return true;
			else
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			ConexaoMySQL.fecharConexao();
		}
	}

}
