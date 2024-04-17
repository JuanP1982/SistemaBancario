package extratos;

import java.time.LocalDate;

public class ExtratoTransferencias {
	private String transferencias;
	private LocalDate data;
	
	public ExtratoTransferencias(String transferencias, LocalDate data) {
		super();
		this.transferencias = transferencias;
		this.data = data;
	}

	public String getTransferencias() {
		return transferencias;
	}

	public void setTransferencias(String transferencias) {
		this.transferencias = transferencias;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
}
