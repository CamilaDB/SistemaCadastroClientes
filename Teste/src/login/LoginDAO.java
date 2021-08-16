package login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.ConexaoMySQL;

public class LoginDAO {
	
	public static boolean verificaLogin(String user, String code) {
		
		ConexaoMySQL.abrirConexao();

		String sql = "select * from login where usuario like ? and senha like ?";

		try {
			PreparedStatement prepS = ConexaoMySQL.getCon().prepareStatement(sql);
			prepS.setString(1, user);
			prepS.setString(2, code);
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
