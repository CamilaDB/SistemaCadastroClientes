package visao;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;

public class TelaLogin extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField fieldUsuario;
	private JTextField fieldSenha;
	private JButton buttonEntrar;
	private JButton buttonLimparLogin;

	/**
	 * Create the panel.
	 */
	public TelaLogin() {
		setLayout(new MigLayout("", "[200px][][150px][200px]", "[30px][][10px][][5px][][15px][]"));
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(0, 102, 102));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 22));
		add(lblLogin, "cell 0 1 4 1,alignx center");
		
		JLabel labelUsuario = new JLabel("Usu\u00E1rio");
		add(labelUsuario, "cell 1 3,alignx left");
		
		fieldUsuario = new JTextField();
		add(fieldUsuario, "cell 2 3,growx");
		fieldUsuario.setColumns(10);
		
		JLabel labelSenha = new JLabel("Senha");
		add(labelSenha, "cell 1 5,alignx left");
		
		fieldSenha = new JPasswordField();
		add(fieldSenha, "cell 2 5,growx");
		fieldSenha.setColumns(10);
	
		
		buttonEntrar = new JButton("Entrar");
		buttonEntrar.setBackground(new Color(0, 102, 102));
		buttonEntrar.setForeground(SystemColor.text);
		add(buttonEntrar, "flowx,cell 2 7,alignx right");
		
		buttonLimparLogin = new JButton("Limpar");
		buttonLimparLogin.setBackground(new Color(0, 102, 102));
		buttonLimparLogin.setForeground(SystemColor.text);
		add(buttonLimparLogin, "cell 2 7");

	}

	public JTextField getFieldUsuario() {
		return fieldUsuario;
	}

	public void setFieldUsuario(JTextField fieldUsuario) {
		this.fieldUsuario = fieldUsuario;
	}

	public JTextField getFieldSenha() {
		return fieldSenha;
	}

	public void setFieldSenha(JTextField fieldSenha) {
		this.fieldSenha = fieldSenha;
	}

	public JButton getButtonEntrar() {
		return buttonEntrar;
	}

	public void setButtonEntrar(JButton buttonEntrar) {
		this.buttonEntrar = buttonEntrar;
	}

	public JButton getButtonLimparLogin() {
		return buttonLimparLogin;
	}

	public void setButtonLimparLogin(JButton buttonLimparLogin) {
		this.buttonLimparLogin = buttonLimparLogin;
	}

}
