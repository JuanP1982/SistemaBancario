package extratos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExtratoTransferencias extends Extrato {
	private String idTransacao;
	private String cpfTransferencia;

	
	
	public ExtratoTransferencias() {
		super();
	}

	public ExtratoTransferencias(String idTransacao, String cpfTitular, double valor, LocalDateTime data, String tipo,
			String cpfTtransferencias) {
		super(idTransacao, cpfTitular, valor, data, "Transferencias");
		this.cpfTransferencia = cpfTransferencia;
		this.idTransacao = idTransacao;
	}

	public String getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(String idTransacao) {
		this.idTransacao = idTransacao;
	}

	public void setarValores(double valor, String cpf, LocalDateTime localDateTime, String cpf2) {
		setCpfTitular(cpf);
		setValor(valor * -1);
		setData(localDateTime);
		setCpfTransferencia(cpf2);
	}

	public String getCpfTransferencia() {
		return cpfTransferencia;
	}

	public void setCpfTransferencia(String cpfTransferencia) {
		this.cpfTransferencia = cpfTransferencia;
	}

	@Override
	public String toString() {
		return "Transferencias;" + cpfTitular + ";" + valor + ";" + data + ";" + idTransacao + ";"
				+ cpfTransferencia + ";";
	}

}
