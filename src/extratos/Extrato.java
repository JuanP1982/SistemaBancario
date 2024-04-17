package extratos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Extrato {
	protected String idTransacao;
	protected String cpfTitular;
	protected double valor;
	protected LocalDateTime data;
	protected String tipo;
	
	public Extrato(String idTransacao, String cpfTitular, double valor, LocalDateTime data, String tipo) {
		super();
		this.cpfTitular = cpfTitular;
		this.valor = valor;
		this.data = data;
		this.tipo = tipo;
		this.idTransacao = idTransacao;
	}
	
	public String getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(String idTransacao) {
		this.idTransacao = idTransacao;
	}

	public String getCpfTitular() {
		return cpfTitular;
	}

	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	 public void pegarValores(double valor, String cpf, LocalDateTime localDateTime) {
	        this.valor = valor;
	        this.cpfTitular = cpf;
	        this.data = localDateTime;
	    }
	@Override
	public String toString() {
		return tipo + ";" + cpfTitular + ";" + valor + ";" + data + ";";
	}


	
	
}
