package cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.ConexaoMySQL;

public class ClienteDAO {

	public static boolean cadastraCliente(Cliente c) {
		ConexaoMySQL.abrirConexao();

		String sql = "insert into cliente values (?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement prepS = ConexaoMySQL.getCon().prepareStatement(sql);
			prepS.setString(1, c.getCpf());
			prepS.setString(2, c.getNome());
			prepS.setString(3, String.valueOf(c.getGenero()));
			prepS.setString(4, c.getDataNascimento());
			prepS.setString(5, c.getProfissao());
			prepS.setString(6, c.getEndereco());
			prepS.setString(7, c.getEmail());
			prepS.setString(8, c.getTelefone());

			int res = prepS.executeUpdate();

			if (res == 1)
				return true;
			else
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("a");
			return false;
		} finally {
			ConexaoMySQL.fecharConexao();
		}
	}

	public static boolean consultaCliente(Cliente c) {
		ConexaoMySQL.abrirConexao();

		String nome = null, dataNasc = null, profissao = null, endereco = null, email = null, tel = null, genero = null;
		String sql = "select * from cliente where cpf like ?";

		try {
			PreparedStatement prepS = ConexaoMySQL.getCon().prepareStatement(sql);
			prepS.setString(1, c.getCpf());
			ResultSet res = prepS.executeQuery();

			while (res.next()) {
				nome = res.getString(2);
				genero = res.getString(3);
				dataNasc = res.getString(4);
				profissao = res.getString(5);
				endereco = res.getString(6);
				email = res.getString(7);
				tel = res.getString(8);
			}
			c.setNome(nome);
			c.setGenero(genero.charAt(0));
			c.setDataNascimento(dataNasc);
			c.setProfissao(profissao);
			c.setEndereco(endereco);
			c.setEmail(email);
			c.setTelefone(tel);

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return false;
		} finally {
			ConexaoMySQL.fecharConexao();
		}
	}

	public static boolean atualizaCliente(Cliente c) {
		ConexaoMySQL.abrirConexao();

		String sql = "Update Cliente set nome=?, genero=?, dataNascimento=?, profissao=?, endereco=?, email=?, telefone=? where cpf like ?";
		try {
			PreparedStatement prepS = ConexaoMySQL.getCon().prepareStatement(sql);
			prepS.setString(1, c.getNome());
			prepS.setString(2, String.valueOf(c.getGenero()));
			prepS.setString(3, c.getDataNascimento());
			prepS.setString(4, c.getProfissao());
			prepS.setString(5, c.getEndereco());
			prepS.setString(6, c.getEmail());
			prepS.setString(7, c.getTelefone());
			prepS.setString(8, c.getCpf());

			int res = prepS.executeUpdate();

			if (res == 1)
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

	public static boolean deletaCliente(String c) {
		ConexaoMySQL.abrirConexao();

		String sql = "Delete from Cliente where cpf like ?";

		try {
			PreparedStatement prepS = ConexaoMySQL.getCon().prepareStatement(sql);
			prepS.setString(1, c);

			int res = prepS.executeUpdate();

			if (res == 1)
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
