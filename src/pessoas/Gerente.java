package pessoas;

import contas.Conta;
import enums.FuncionariosEnum;

public class Gerente extends Funcionario {
	private int agencia;
	private Conta conta;

	public Gerente(String nome, String senha, String cpf, String cargo, int agencia, String tipo) {
		super(nome, senha, cpf, "Gerente", tipo);
		this.agencia = agencia;
		this.conta = conta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}


	@Override
	public String toString() {
		return "Gerente;" + nome + ";" + senha + ";" + cpf + ";"+ cargo +";" + agencia + ";";
	}

}
