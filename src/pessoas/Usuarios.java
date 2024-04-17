package pessoas;

import contas.Conta;

public abstract class Usuarios implements Comparable<Usuarios> {
	protected String nome;
	protected String senha;
	protected String cpf;
	protected Conta conta;
	protected String tipo;
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Usuarios(String nome, String senha, String cpf, String tipo) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
		this.conta = conta;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	 public int compareTo(Usuarios outroUsuario) {
		return this.nome.compareTo(outroUsuario.nome);  
	    }
	
}
