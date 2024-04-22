package pessoas;

import enums.FuncionariosEnum;

public class Diretor extends Funcionario {

	
	
	public Diretor() {
		super();
	}

	public Diretor(String nome, String senha, String cpf, String cargo,String tipo) {
		super(nome, senha, cpf, "Diretor", tipo);

	}

	@Override
	public String toString() {
		return "Diretor;" + nome + ";" + senha + ";" + cpf + ";" + tipo + ";";
	}
	
}
