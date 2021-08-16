package modelo;

public class Cliente {
	
	private String cpf;
	private String nome;
	private char genero;
	private String profissao;
	private String endereco;
	private String email;
	private String telefone;
	private String dataNascimento;

	public Cliente() {

	}

	public Cliente(String cpf, String nome, char genero, String profissao, String endereco, String email,
			String telefone, String dataNascimento) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.genero = genero;
		this.profissao = profissao;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
