package extratos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class ExtratoSaques extends Extrato {
	   private String idTransacao;
	
	   
	   
	   public ExtratoSaques() {
		super();
	}

	public ExtratoSaques(String idTransacao, String cpfTitular, double valor, LocalDateTime data, String tipo) {
		super(idTransacao, cpfTitular, valor * -1, data, "Saques");
		this.idTransacao = idTransacao;
	}

	public void setarValores(double valor, String cpf, LocalDateTime localDateTime) {
		setCpfTitular(cpf);
		setValor(valor * -1);
		setData(localDateTime);
	}

	public String getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(String idTransacao) {
		this.idTransacao = idTransacao;
	}

	@Override
	public String toString() {
		return "Saques;" + cpfTitular + ";" + valor + ";" + data + ";" + idTransacao + ";";

	}

}
