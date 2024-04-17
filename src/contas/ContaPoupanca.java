package contas;

public class ContaPoupanca extends Conta {
	private String tipo = "Poupança";

	public ContaPoupanca(String cpfTitular, double saldo, int agencia, String tipo) {
		super(cpfTitular, saldo, agencia);
		this.tipo = tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "Sua conta é:" + tipo + "\n Seu saldo é: " + saldo + "]";
	}
	
}
