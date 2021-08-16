package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class TelaCliente extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField fieldNome;
	private JFormattedTextField fieldCPF;
	private JTextField fieldEndereco;
	private JTextField fieldEmail;
	private JFormattedTextField fieldTelefone;
	private JFormattedTextField fieldDataNasc;
	private JComboBox<String> comboBoxProfissao;
	private JButton buttonCadastrar;
	private JButton buttonLimparCad;
	private JRadioButton ratioF;
	private JRadioButton ratioM;
	private ButtonGroup grupo;
	private JButton buttonConsultar;
	private JButton buttonAtualizar;
	private JButton buttonRemover;

	/**
	 * Create the panel.
	 */
	public TelaCliente() {
		setLayout(new MigLayout("", "[][grow][15.00][200px]", "[][][10px][][][][][][10px][]"));

		JLabel labelCliente = new JLabel("Clientes");
		labelCliente.setForeground(new Color(0, 102, 102));
		labelCliente.setFont(new Font("Tahoma", Font.BOLD, 22));
		add(labelCliente, "cell 0 1 4 1,alignx center");

		JLabel labelNome = new JLabel("Nome");
		add(labelNome, "cell 0 3,alignx left");

		fieldNome = new JTextField();
		add(fieldNome, "cell 1 3 3 1,growx");
		fieldNome.setColumns(10);

		JLabel labelCPF = new JLabel("CPF");
		add(labelCPF, "cell 0 4,alignx left");

		fieldCPF = new JFormattedTextField();
		try {
			fieldCPF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(fieldCPF, "cell 1 4,growx");
		fieldCPF.setColumns(10);

		JLabel labelNascimento = new JLabel("Data Nascimento");
		add(labelNascimento, "flowx,cell 3 4");

		fieldDataNasc = new JFormattedTextField();
		try {
			fieldDataNasc.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(fieldDataNasc, "cell 3 4,growx");
		fieldDataNasc.setColumns(10);

		JLabel lblProfissao = new JLabel("Profiss\u00E3o");
		add(lblProfissao, "cell 0 5");

		comboBoxProfissao = new JComboBox<String>();
		comboBoxProfissao.addItem("");
		comboBoxProfissao.addItem("Advogado");
		comboBoxProfissao.addItem("Dentista");
		comboBoxProfissao.addItem("Estudante");
		comboBoxProfissao.addItem("Nutricionista");
		comboBoxProfissao.addItem("Professor");
		comboBoxProfissao.addItem("Programador");

		add(comboBoxProfissao, "cell 1 5,growx");

		JLabel labelEndereco = new JLabel("Endere\u00E7o");
		add(labelEndereco, "cell 0 6,alignx left");

		fieldEndereco = new JTextField();
		add(fieldEndereco, "cell 1 6 3 1,growx");
		fieldEndereco.setColumns(10);

		JLabel labelEmail = new JLabel("E-mail");
		add(labelEmail, "cell 0 7,alignx left");

		fieldEmail = new JTextField();
		add(fieldEmail, "cell 1 7,growx");
		fieldEmail.setColumns(10);

		JLabel labelTelefone = new JLabel("Telefone");
		add(labelTelefone, "flowx,cell 3 7");

		fieldTelefone = new JFormattedTextField();
		try {
			fieldTelefone.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)#########")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(fieldTelefone, "cell 3 7,growx");
		fieldTelefone.setColumns(10);

		JLabel labelGenero = new JLabel("G\u00EAnero");
		add(labelGenero, "flowx,cell 3 5");

		grupo = new ButtonGroup();

		ratioF = new JRadioButton("F");
		ratioF.setActionCommand("F");
		add(ratioF, "cell 3 5");

		ratioM = new JRadioButton("M");
		ratioM.setActionCommand("M");
		add(ratioM, "cell 3 5");

		grupo.add(ratioF);
		grupo.add(ratioM);

		buttonCadastrar = new JButton("Cadastrar");
		buttonCadastrar.setForeground(Color.WHITE);
		buttonCadastrar.setBackground(new Color(0, 102, 102));
		add(buttonCadastrar, "flowx,cell 0 9 4 1,alignx right");

		buttonConsultar = new JButton("Consultar");
		buttonConsultar.setForeground(Color.WHITE);
		buttonConsultar.setBackground(new Color(0, 102, 102));
		add(buttonConsultar, "cell 0 9");

		buttonAtualizar = new JButton("Atualizar");
		buttonAtualizar.setForeground(Color.WHITE);
		buttonAtualizar.setBackground(new Color(0, 102, 102));
		add(buttonAtualizar, "cell 0 9,alignx right");

		buttonRemover = new JButton("Remover");
		buttonRemover.setForeground(Color.WHITE);
		buttonRemover.setBackground(new Color(0, 102, 102));
		add(buttonRemover, "cell 0 9 4 1,alignx right");

		buttonLimparCad = new JButton("Limpar");
		buttonLimparCad.setForeground(Color.WHITE);
		buttonLimparCad.setBackground(new Color(0, 102, 102));
		add(buttonLimparCad, "cell 0 9");
	}

	public JTextField getFieldNome() {
		return fieldNome;
	}

	public void setFieldNome(JTextField fieldNome) {
		this.fieldNome = fieldNome;
	}

	public JTextField getFieldCPF() {
		return fieldCPF;
	}

	public void setFieldCPF(JFormattedTextField fieldCPF) {
		this.fieldCPF = fieldCPF;
	}

	public JTextField getFieldEndereco() {
		return fieldEndereco;
	}

	public void setFieldEndereco(JTextField fieldEndereco) {
		this.fieldEndereco = fieldEndereco;
	}

	public JTextField getFieldEmail() {
		return fieldEmail;
	}

	public void setFieldEmail(JTextField fieldEmail) {
		this.fieldEmail = fieldEmail;
	}

	public JTextField getFieldTelefone() {
		return fieldTelefone;
	}

	public void setFieldTelefone(JFormattedTextField fieldTelefone) {
		this.fieldTelefone = fieldTelefone;
	}

	public JTextField getFieldDataNasc() {
		return fieldDataNasc;
	}

	public void setFieldDataNasc(JFormattedTextField fieldDataNasc) {
		this.fieldDataNasc = fieldDataNasc;
	}

	public JComboBox<String> getComboBoxProfissao() {
		return comboBoxProfissao;
	}

	public void setComboBoxProfissao(JComboBox<String> comboBoxProfissao) {
		this.comboBoxProfissao = comboBoxProfissao;
	}

	public JButton getButtonCadastrar() {
		return buttonCadastrar;
	}

	public void setButtonCadastrar(JButton buttonCadastrar) {
		this.buttonCadastrar = buttonCadastrar;
	}

	public JButton getButtonLimparCad() {
		return buttonLimparCad;
	}

	public void setButtonLimparCad(JButton buttonLimparCad) {
		this.buttonLimparCad = buttonLimparCad;
	}

	public JRadioButton getRatioF() {
		return ratioF;
	}

	public void setRatioF(JRadioButton ratioF) {
		this.ratioF = ratioF;
	}

	public JRadioButton getRatioM() {
		return ratioM;
	}

	public void setRatioM(JRadioButton ratioM) {
		this.ratioM = ratioM;
	}

	public ButtonGroup getGrupo() {
		return grupo;
	}

	public void setGrupo(ButtonGroup grupo) {
		this.grupo = grupo;
	}

	public JButton getButtonConsultar() {
		return buttonConsultar;
	}

	public void setButtonConsultar(JButton buttonConsultar) {
		this.buttonConsultar = buttonConsultar;
	}

	public JButton getButtonAtualizar() {
		return buttonAtualizar;
	}

	public void setButtonAtualizar(JButton buttonAtualizar) {
		this.buttonAtualizar = buttonAtualizar;
	}

	public JButton getButtonRemover() {
		return buttonRemover;
	}

	public void setButtonRemover(JButton buttonRemover) {
		this.buttonRemover = buttonRemover;
	}
}
