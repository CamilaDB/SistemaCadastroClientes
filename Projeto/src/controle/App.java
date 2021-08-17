package controle;

import modelo.Cliente;
import modelo.Login;
import visao.JanelaPrincipal;

public class App {
	
	public static void main(String[] args) {
		JanelaPrincipal j= new JanelaPrincipal();
		j.setVisible(true);
		
		Login login = new Login();
		LoginControle logincon = new LoginControle(j, login);
		
		Cliente c = new Cliente();
		ClienteControle clicon= new ClienteControle(j, c);
	}

}
