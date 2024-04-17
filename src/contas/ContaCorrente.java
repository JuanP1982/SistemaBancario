package contas;

public class ContaCorrente extends Conta {
	private String tipo;

	public ContaCorrente(String cpfTitular, double saldo, int agencia, String tipo) {
		super(cpfTitular, saldo, agencia);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
