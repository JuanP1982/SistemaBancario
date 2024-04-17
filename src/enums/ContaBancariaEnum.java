package enums;

public enum ContaBancariaEnum {
	ContaCorrente("Conta Corrente"), CONTAPOUPANCA("Conta Poupanca");

	private String tipoConta;

	private ContaBancariaEnum(String tipoConta) {
    this.tipoConta = tipoConta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

}
