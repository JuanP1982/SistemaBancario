package contas;

public class ContaCorrente extends Conta {

	public ContaCorrente(String cpfTitular, double saldo, int agencia, String tipo) {
		super(cpfTitular, saldo, agencia, tipo);
	}

	@Override
	public String toString() {
		return "ContaCorrente;" + cpfTitular + ";" + saldo + ";" + agencia + ";" + tipo +";"+ total + ";";
	}

}
