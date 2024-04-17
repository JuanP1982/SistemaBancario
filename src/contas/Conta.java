package contas;

public abstract class Conta {
	protected String cpfTitular;
	protected double saldo;
	protected int agencia;
	

	public Conta(String cpfTitular, double saldo, int agencia) {
		super();
		this.cpfTitular = cpfTitular;
		this.saldo = saldo;
		this.agencia = agencia;
	}

	public String getCpfTitular() {
		return cpfTitular;
	}

	public double getSaldo() {
		return saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	@Override
	public String toString() {
		return "Conta [cpfTitular=" + cpfTitular + ", saldo=" + saldo + ", agencia=" + agencia + "]";
	}

}
