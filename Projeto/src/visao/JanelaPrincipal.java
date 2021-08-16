package visao;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class JanelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem itemLogin;
	private JMenuItem itemCliente;
	private JMenuItem itemSair;
	private CardLayout card;
	private TelaLogin telaLogin;
	private TelaCliente telaCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		setTitle("Sistema de Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 300);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 102, 102));
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		mnMenu.setForeground(SystemColor.text);
		menuBar.add(mnMenu);

		itemLogin = new JMenuItem("Login");
		itemLogin.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/figuras/Login-in-icon.png")));
		itemLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "TelaLogin");
			}
		});
		mnMenu.add(itemLogin);

		itemCliente = new JMenuItem("Cliente");
		itemCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "TelaCliente");
				JOptionPane.showMessageDialog(contentPane,
						"Obsevação:\nPara consultar digite o cpf e clique no botão consultar.\n",
						"CLIENTE", 1);
			}
		});
		itemCliente.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/figuras/User-icon.png")));
		mnMenu.add(itemCliente);
		itemCliente.setEnabled(false);

		itemSair = new JMenuItem("Sair");
		itemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(getContentPane(), "Deseja realmente sair do programa?",
						"Selecione uma opção", JOptionPane.YES_NO_OPTION) == 0)
					System.exit(0);
			}
		});
		itemSair.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/figuras/Login-out-icon.png")));
		mnMenu.add(itemSair);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		card = new CardLayout(0, 0);
		contentPane.setLayout(card);

		telaLogin = new TelaLogin();
		telaCliente = new TelaCliente();

		contentPane.add(telaLogin, "TelaLogin");
		contentPane.add(telaCliente, "TelaCliente");

	}

	public JMenuItem getItemLogin() {
		return itemLogin;
	}

	public void setItemLogin(JMenuItem itemLogin) {
		this.itemLogin = itemLogin;
	}

	public JMenuItem getItemSair() {
		return itemSair;
	}

	public void setItemSair(JMenuItem itemSair) {
		this.itemSair = itemSair;
	}

	public TelaLogin getTelaLogin() {
		return telaLogin;
	}

	public void setTelaLogin(TelaLogin telaLogin) {
		this.telaLogin = telaLogin;
	}

	public TelaCliente getTelaCliente() {
		return telaCliente;
	}

	public void setTelaCliente(TelaCliente telaCliente) {
		this.telaCliente = telaCliente;
	}

	public JMenuItem getItemCliente() {
		return itemCliente;
	}

	public void setItemCliente(JMenuItem itemCliente) {
		this.itemCliente = itemCliente;
	}

}
