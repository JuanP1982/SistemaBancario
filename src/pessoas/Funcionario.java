package pessoas;

import contas.Conta;
import contas.ContaPoupanca;
import enums.FuncionariosEnum;

public abstract class Funcionario extends Usuarios{
	protected String cargo;
	protected Conta conta;


	public Funcionario(String nome, String senha, String cpf, String cargo, String tipo) {
		super(nome, senha, cpf, tipo);
		this.cargo = cargo;
		this.conta = conta;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	
}
