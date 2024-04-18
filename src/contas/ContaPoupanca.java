package contas;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import customexceptions.ValorNegativoException;
import menus.Menulogin;
import pessoas.Usuarios;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(String cpfTitular, double saldo, int agencia, String tipo) {
		super(cpfTitular, saldo, agencia, tipo);
	}

	public static void calcularRendimento(String cpf, Map<String, Usuarios> usuarios) throws IOException {
        Scanner sc = new Scanner(System.in);
        Menulogin login = new Menulogin();
        double valor;
        long dias;
        double taxaJurosDiaria = 0.000986;
        int escolha = 0;
        
        try {
        	
        
        System.out.println("Informe o valor do investimento:");
        valor = sc.nextDouble();
        if (valor < 0) {
        	throw new ValorNegativoException("O valor do investimento não pode ser negativo!");
        }
        
        System.out.println("Informe o número de dias do investimento:");
        dias = sc.nextLong();
        double rendimento = (valor * taxaJurosDiaria) * dias + valor;
        System.out.println("O valor do seu rendimento é " + rendimento + " com taxa de " + "0.000986" + " por dia");
        System.out.println("Deseja calcular novamente o rendimento?");
        System.out.println("1- Continuar | 2- Sair");
		int escolha1 = sc.nextInt();
		switch (escolha1) {
		case 1:
			calcularRendimento(cpf, usuarios);
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
		} } catch (InputMismatchException e) {
	        // Lidar com a exceção de valor negativo ou zero
	        System.err.println("Você não pode digitar letras!");
	        // Chamar o método deposito() novamente se necessário
	        
	    } catch (ValorNegativoException e) {
	        System.err.println("Você não pode informar um valor negativo!");
	        
	    }
	}

	@Override
	public String toString() {
		return "ContaPoupanca;" + cpfTitular + ";" + saldo + ";"
				+ agencia + ";" + tipo + ";" + total +";";
	}
	
}