package contas;

public abstract class Conta {
	protected String cpfTitular;
	protected double saldo;
	protected int agencia;
	protected String tipo;
	protected double total;
	

	public Conta(String cpfTitular, double saldo, int agencia, String tipo) {
		super();
		this.cpfTitular = cpfTitular;
		this.saldo = saldo;
		this.agencia = agencia;
		this.tipo = tipo;
		
	}
	

	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
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
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	
	public void transacaoEnviar(Double enviar) {
        this.saldo -= (enviar - 0.20);
        this.total += 0.20;
   }

    public void transacaoReceber(Double receber) {
        this.saldo += receber;
   }
	
	
	@Override
	public String toString() {
		return tipo +";" + cpfTitular + ";" + saldo + ";" + agencia +";"+ total +";";
	}

	public void saque(Double sacar) {
		 this.saldo -= sacar -(-0.1) ;
		 this.total += 0.10;
	}
	
	public void deposito(Double deposito) {
        this.saldo += deposito - (-0.1);
        this.total += 0.10;
	}
}
