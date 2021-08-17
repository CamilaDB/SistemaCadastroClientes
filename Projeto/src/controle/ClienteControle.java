package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import dao.ClienteDAO;
import modelo.Cliente;
import visao.JanelaPrincipal;

public class ClienteControle implements ActionListener {

	private JanelaPrincipal jan;
	private Cliente cli;
	private ClienteDAO clidao;
	private boolean flag;

	public ClienteControle(JanelaPrincipal jan, Cliente cli) {
		this.jan = jan;
		this.cli = cli;
		clidao = new ClienteDAO();
		registraListeners();
	}

	public void registraListeners() {
		jan.getTelaCliente().getButtonCadastrar().addActionListener(this);
		jan.getTelaCliente().getButtonConsultar().addActionListener(this);
		jan.getTelaCliente().getButtonAtualizar().addActionListener(this);
		jan.getTelaCliente().getButtonRemover().addActionListener(this);
		jan.getTelaCliente().getButtonLimparCad().addActionListener(this);
	}

	public void cadastraCliente() {
		flag = true;
		try {
			transfereDados();
		} catch (Exception e) {
			// TODO: handle exception
			mensagemErro("Verifique campos em branco!");
		}
		if (flag == true)
			if (clidao.insereCliente(cli)) {
				JOptionPane.showMessageDialog(jan.getContentPane(), "Cadastro realizado com sucesso!", "CADASTRO", 0,
						new ImageIcon(ClienteControle.class.getResource("/figuras/check-1-icon.png")));
				limpaTelaCadastro();
			} else {
				JOptionPane.showMessageDialog(jan.getContentPane(),
						"Falha no cadastro!\nVerifique os campos e tente novamente.", "ERRO", 0);
			}
	}

	public void consultaCliente() {
		flag = true;
		cli.setCpf(jan.getTelaCliente().getFieldCPF().getText());
		try {
			clidao.selecionaCliente(cli);
		} catch (Exception e) {
			mensagemErro("O CPF não existe!");
		}

		if (flag == true) {
			jan.getTelaCliente().getFieldNome().setText(cli.getNome());
			jan.getTelaCliente().getComboBoxProfissao().setSelectedItem(cli.getProfissao());
			jan.getTelaCliente().getFieldEndereco().setText(cli.getEndereco());
			jan.getTelaCliente().getFieldEmail().setText(cli.getEmail());
			jan.getTelaCliente().getFieldTelefone().setText(cli.getTelefone());
			jan.getTelaCliente().getFieldDataNasc().setText(cli.getDataNascimento());

			if (cli.getGenero() == 'F') {
				jan.getTelaCliente().getRatioF().setSelected(true);
			} else if (cli.getGenero() == 'M') {
				jan.getTelaCliente().getRatioM().setSelected(true);
			}
		}

	}

	public void alteraCliente() {
		flag = true;
		try {
			transfereDados();
		} catch (Exception e) {
			mensagemErro("O CPF não existe!");
		}

		if (flag == true)
			if (clidao.atualizaCliente(cli)) {
				JOptionPane.showMessageDialog(jan.getContentPane(), "Dados atualizados com sucesso", "ATUALIZAR", 0,
						new ImageIcon(ClienteControle.class.getResource("/figuras/check-1-icon.png")));
			} else
				JOptionPane.showMessageDialog(jan.getContentPane(), "Dados não foram atualizados!", "ERRO", 0);
		
		limpaTelaCadastro();
	}

	public void removeCliente() {
		cli.setCpf(jan.getTelaCliente().getFieldCPF().getText());
		if (clidao.deletaCliente(cli.getCpf()))
			JOptionPane.showMessageDialog(jan.getContentPane(), "Cliente removido com sucesso!", "REMOVER", 0,
					new ImageIcon(ClienteControle.class.getResource("/figuras/check-1-icon.png")));
		else
			JOptionPane.showMessageDialog(jan.getContentPane(), "Cliente não foi removido!", "ERRO", 0);
		limpaTelaCadastro();
	}

	private void limpaTelaCadastro() {
		jan.getTelaCliente().getFieldCPF().setText("");
		jan.getTelaCliente().getFieldNome().setText("");
		jan.getTelaCliente().getGrupo().clearSelection();
		jan.getTelaCliente().getComboBoxProfissao().setSelectedIndex(0);
		jan.getTelaCliente().getFieldEndereco().setText("");
		jan.getTelaCliente().getFieldEmail().setText("");
		jan.getTelaCliente().getFieldTelefone().setText("");
		jan.getTelaCliente().getFieldDataNasc().setText("");
	}

	public void transfereDados() {
		cli.setCpf(jan.getTelaCliente().getFieldCPF().getText());
		cli.setNome(jan.getTelaCliente().getFieldNome().getText());
		cli.setGenero(jan.getTelaCliente().getGrupo().getSelection().getActionCommand().charAt(0));
		cli.setProfissao(jan.getTelaCliente().getComboBoxProfissao().getSelectedItem().toString());
		cli.setEndereco(jan.getTelaCliente().getFieldEndereco().getText());
		cli.setEmail(jan.getTelaCliente().getFieldEmail().getText());
		cli.setTelefone(jan.getTelaCliente().getFieldTelefone().getText());
		cli.setDataNascimento(jan.getTelaCliente().getFieldDataNasc().getText());
	}
	
	public void mensagemErro(String mensagem) {
		JOptionPane.showMessageDialog(jan.getContentPane(), mensagem, "ERRO", 0);
		flag = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Cadastrar")) {
			cadastraCliente();
		} else if (e.getActionCommand().equals("Limpar")) {
			limpaTelaCadastro();
		} else if (e.getActionCommand().equals("Consultar")) {
			consultaCliente();
		} else if (e.getActionCommand().equals("Atualizar")) {
			alteraCliente();
		} else if (e.getActionCommand().equals("Remover")) {
			removeCliente();
		}
	}

}
