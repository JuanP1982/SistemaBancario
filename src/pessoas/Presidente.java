package pessoas;

import enums.FuncionariosEnum;

public class Presidente extends Funcionario {

	public Presidente(String nome, String senha, String cpf, String cargo, String tipo) {
		super(nome, senha, cpf, "presidente", tipo);
	}
}
