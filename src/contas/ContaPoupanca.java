package contas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(String cpfTitular, double saldo, int agencia, String tipo) {
		super(cpfTitular, saldo, agencia, tipo);
	}

	  public static void calcularRendimento() {
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
          Scanner sc = new Scanner(System.in);


          double valor;
          String dataInicio;
          String dataFim;

          double taxaJurosDiaria = 0.000986;

          System.out.println("Informe o valor");
          valor = sc.nextDouble();
          System.out.println("Informe o dia inicial");
          dataInicio = sc.next();
          System.out.println("Informe o dia final");
          dataFim = sc.next();
          
         LocalDate dataInicial = LocalDate.parse(dataInicio, formatter);
         LocalDate datafinal = LocalDate.parse(dataFim, formatter);

          long dias = ChronoUnit.DAYS.between(dataInicial, datafinal);
           valor = valor * taxaJurosDiaria * dias;
           System.out.println(valor);
	}

	@Override
	public String toString() {
		return "ContaPoupanca;" + cpfTitular + ";" + saldo + ";"
				+ agencia + ";" + tipo +";";
	}
	

	
}
