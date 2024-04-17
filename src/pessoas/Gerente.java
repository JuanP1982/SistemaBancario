package pessoas;

public class Gerente extends Funcionario {
	private int agencia;

	public Gerente(String nome, String senha, String email, String cargo, int agencia) {
		super(nome, senha, email, "Gerente");
		this.agencia = agencia;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}


}
