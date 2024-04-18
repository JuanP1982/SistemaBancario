package contas;

import java.io.IOException;
import java.util.Scanner;

import menus.Menulogin;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(String cpfTitular, double saldo, int agencia, String tipo) {
		super(cpfTitular, saldo, agencia, tipo);
	}

	public static void calcularRendimento(String cpf) throws IOException {
        Scanner sc = new Scanner(System.in);
        Menulogin login = new Menulogin();
        double valor;
        long dias;
        double taxaJurosDiaria = 0.000986;
        int escolha = 0;

        System.out.println("Informe o valor do investimento:");
        valor = sc.nextDouble();
        System.out.println("Informe o número de dias do investimento:");
        dias = sc.nextLong();
        double rendimento = (valor * taxaJurosDiaria) * dias + valor;
        System.out.println("O valor do seu rendimento é " + rendimento + " com taxa de " + "0.000986" + " por dia");
        System.out.println("Deseja calcular novamente o rendimento?");
        System.out.println("1- Continuar | 2- Sair");
		int escolha1 = sc.nextInt();
		switch (escolha) {
		case 1:
			calcularRendimento(cpf);
		case 2:
			if (login.usuarios.get(cpf).getTipo().equalsIgnoreCase("Cliente")) {
				login.menuCliente(cpf);
			} else if (login.usuarios.get(cpf).getTipo().equalsIgnoreCase("Gerente")) {
				login.menuGerente(cpf);
			} else if (login.usuarios.get(cpf).getTipo().equalsIgnoreCase("Diretor")) {
				login.menuDiretor(cpf);
			} else if (login.usuarios.get(cpf).getTipo().equalsIgnoreCase("Presidente")) {
				login.menuPresidente(cpf);
			}
		}

	}

	@Override
	public String toString() {
		return "ContaPoupanca;" + cpfTitular + ";" + saldo + ";"
				+ agencia + ";" + tipo + ";" + total +";";
	}
	
}