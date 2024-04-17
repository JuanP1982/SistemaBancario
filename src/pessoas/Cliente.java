package pessoas;

import contas.Conta;
import contas.ContaPoupanca;
import enums.ContaBancariaEnum;

public class Cliente extends Usuarios{
	private Conta conta;
	
	

	public Cliente(String nome, String senha, String cpf, String tipo) {
		super(nome, senha, cpf, tipo);
		this.conta = conta;
	}


	@Override
	public String toString() {
		return "Cliente;" + nome + ";" + senha + ";" + cpf + ";";
	}
	
	
}

	
