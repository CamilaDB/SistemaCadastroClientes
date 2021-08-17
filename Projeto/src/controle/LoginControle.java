package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import dao.LoginDAO;
import modelo.Login;
import visao.JanelaPrincipal;

public class LoginControle implements ActionListener {

	private Login login;
	private JanelaPrincipal jan;
	private LoginDAO logindao;

	public LoginControle(JanelaPrincipal jan, Login login) {
		this.jan = jan;
		this.login = login;
		logindao = new LoginDAO();
		registraListeners();
	}

	public void registraListeners() {
		jan.getTelaLogin().getButtonEntrar().addActionListener(this);
		jan.getTelaLogin().getButtonLimparLogin().addActionListener(this);
	}

	public void verificaLogin() {
		login.setSenha(jan.getTelaLogin().getFieldSenha().getText());
		login.setUsuario(jan.getTelaLogin().getFieldUsuario().getText());

		if (logindao.consultaLogin(login)) {
			jan.getItemCliente().setEnabled(true);
			JOptionPane.showMessageDialog(jan.getContentPane(),
					"Login realizado com sucesso!\nAgora você pode acessar a área cliente.", "LOGIN", 3,
					new ImageIcon(LoginControle.class.getResource("/figuras/check-1-icon.png")));
			limpaTelaLogin();
		} else {
			JOptionPane.showMessageDialog(jan.getContentPane(), "Falha no login!\nTente novamente.", "ERRO", 0);
		}
	}

	public void limpaTelaLogin() {
		jan.getTelaLogin().getFieldSenha().setText("");
		jan.getTelaLogin().getFieldUsuario().setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Entrar")) {
			verificaLogin();
		} else if (e.getActionCommand().equals("Limpar")) {
			limpaTelaLogin();
		}
	}
}
