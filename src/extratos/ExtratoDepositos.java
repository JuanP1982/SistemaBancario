package extratos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class ExtratoDepositos extends Extrato {

	public ExtratoDepositos(String idTransacao, String cpfTitular, double valor, LocalDateTime data, String tipo) {
		super(idTransacao, cpfTitular, valor, data, "Depositos");
		
	}

	public void setarValores(double valor, String cpf, LocalDateTime localDateTime) {
		setCpfTitular(cpf);
		setValor(valor);
		setData(localDateTime);
	}
	
	@Override
	public String toString() {
		return "Depositos;" + cpfTitular + ";" + valor + ";" + data + ";" + idTransacao + ";";

	}

}
