package enums;

public enum AgenciaEnum {
	 SANTANDER("1"), BANCODOBRASIL("2");
	
	private final String agencia;
	
	private  AgenciaEnum(String agencia) {
		this.agencia = agencia;
	}
	
	
	public String getAgencia() {
		return agencia;
	}
}
