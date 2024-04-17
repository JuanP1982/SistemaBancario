package pessoas;

import contas.Conta;
import contas.ContaPoupanca;
import enums.ContaBancariaEnum;

public class Cliente {
	private String nome;
	private String senha;
	private String email;
	private ContaBancariaEnum tipoConta;
	

	public ContaBancariaEnum getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(ContaBancariaEnum tipoConta) {
		this.tipoConta = tipoConta;
	}


	public Cliente() {
		super();
	}

	public Cliente(String nome, String senha, String email, ContaBancariaEnum tipoConta) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.tipoConta = tipoConta;
	}

	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public String getEmail() {
		return email;
	}
	
	

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", senha=" + senha + ", email=" + email + "]";
	}
	

		
}
