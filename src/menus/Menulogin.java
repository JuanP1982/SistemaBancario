package menus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import enums.AgenciaEnum;
import enums.ContaBancariaEnum;
import extratos.Extrato;
import io.InOutUtils;
import pessoas.Cliente;
import pessoas.Diretor;
import pessoas.Funcionario;
import pessoas.Gerente;
import pessoas.Presidente;
import pessoas.Usuarios;
import relatorios.Relatorios;

public class Menulogin {
	static Map<String, Conta> contas = new LinkedHashMap<>();
	public static Map<String, Usuarios> usuarios = new HashMap<>();
	static List<Extrato> extrato = new ArrayList<>();

	Scanner sc = new Scanner(System.in);
	MenuTransacoes transacoes = new MenuTransacoes();
	Relatorios relatorios = new Relatorios();
	String caminhoArquivo = "../SistemaBancario/arquivos/clientes.txt";
	String caminhoConta = "../SistemaBancario/arquivos/contas.txt";
	String caminhoExtrato = "../SistemaBancario/arquivos/extrato.txt";

	int escolha = 0;
	String corAzul = "\u001B[34m";
	String corVerde = "\u001B[32m";
	String corVermelha = "\u001B[31m";
	String resetCor = "\u001B[0m";

	public void menuPrincipal() throws IOException {
		InOutUtils.leitorPessoas(caminhoArquivo, usuarios);
		InOutUtils.leitorContas(caminhoConta, contas, usuarios);
		InOutUtils.leitorExtrato(caminhoExtrato, extrato);
		Scanner sc = new Scanner(System.in);
		System.out.println(corVerde + "   /\\   " + "                                      " + "   /\\   ");
		System.out.println("  /  \\" + "                                        " + "  /  \\");
		System.out.println(" /    \\" + "                                     " + "   /    \\");
		System.out.println("/______\\---Bem vindo ao banco da Residência--" + "-" + "/______\\");
		System.out.println("|  _   |" + "                                     " + " |   _  |");
		System.out.println("|_|_|__|" + "                                     " + " |__|_|_|" + resetCor);
		while (escolha != 3) {
			System.out.println("                Escolha um número:\n" + "                1- Registrar-se\n"
					+ "                2- Login\n" + "                3- Sair");
			escolha = sc.nextInt();
			switch (escolha) {
			case 1:
				this.registro();
				break;
			case 2:
				this.login();
				break;
			case 3:
				break;
			}
		}
	}

	public void registro() throws IOException {
		Cliente cliente = new Cliente(null, null, null, null);
		System.out.println("Digite o seu nome: ");
		cliente.setNome(sc.next());

		System.out.println("Digite sua senha: ");
		cliente.setSenha(sc.next());

		System.out.println("Digite seu cpf: ");
		String cpf = sc.next();
		if (usuarios.containsKey(cpf)) {
			System.out.println(corVermelha + "XXXXXXXXXXXXXXX CPF já existente XXXXXXXXXXXXXXXX" + resetCor);
			System.exit(0);
		}
		cliente.setCpf(cpf);
		cliente.setTipo("Cliente");

		System.out.println("Qual tipo de conta deseja criar?\n1- Conta Corrente\n2- Conta Poupanca");
		int tipoconta = sc.nextInt();

		if (tipoconta == 1) {
			System.out.println(
					"  /\\   /\\                                                                                     /\\   /\\");
			System.out.println(
					" /  \\ /  \\                                                                                   /  \\ /  \\");
			System.out.println(
					"|    V    |  Agradecemos o seu registro no Banco ResidenciaSeu saldo inicial é : R$ 1000    |    V    |");
			System.out.println(
					" \\       /                       Seu saldo inicial é : R$ 1000                               \\       /");
			System.out.println(
					"  \\     /                                                                                     \\     /");
			System.out.println(
					"   \\   /                                                                                       \\   /");
			System.out.println(
					"    \\ /                                                                                         \\ /");
			ContaCorrente Corrente = new ContaCorrente(cpf, 1000, 1, ContaBancariaEnum.ContaCorrente.name());
			cliente.setConta(Corrente);
			usuarios.put(cliente.getCpf(), cliente);
			contas.put(cpf, Corrente);
			InOutUtils.escritorConta(caminhoConta, Corrente, contas);
		}

		else if (tipoconta == 2) {

			System.out.println(
					"  /\\   /\\                                                                                     /\\   /\\");
			System.out.println(
					" /  \\ /  \\                                                                                   /  \\ /  \\");
			System.out.println(
					"|    V    |  Agradecemos o seu registro no Banco ResidenciaSeu saldo inicial é : R$ 1000    |    V    |");
			System.out.println(
					" \\       /                       Seu saldo inicial é : R$ 1000                               \\       /");
			System.out.println(
					"  \\     /                                                                                     \\     /");
			System.out.println(
					"   \\   /                                                                                       \\   /");
			System.out.println(
					"    \\ /                                                                                         \\ /");
			ContaPoupanca Poupanca = new ContaPoupanca(cliente.getCpf(), 1000, 2,
					ContaBancariaEnum.ContaPoupanca.name());
			cliente.setConta(Poupanca);
			cliente.getConta().setSaldo(1000);
			usuarios.put(cpf, cliente);
			contas.put(cpf, Poupanca);
			InOutUtils.escritorConta(caminhoConta, Poupanca, contas);
		} else {
			System.out.println(corVermelha + "XXXXXXXXXXXXXXX Inválido XXXXXXXXXXXXXXXX" + resetCor);
		}

		InOutUtils.escritorClientes(caminhoArquivo, cliente);

	}

	public void login() throws IOException {
		String cpf;
		String senha;

		Scanner sc = new Scanner(System.in);
		System.out.println("----------------Login----------------");
		System.out.println("Digite seu cpf (Apenas números): ");
		cpf = sc.next();

		System.out.println("Digite sua senha: ");
		senha = sc.next();

		if (usuarios.containsKey(cpf) && usuarios.get(cpf).getSenha().equals(senha)
				&& usuarios.get(cpf).getTipo().equalsIgnoreCase("Cliente")) {
			this.menuCliente(cpf);
		} else if (usuarios.containsKey(cpf) && usuarios.get(cpf).getSenha().equals(senha)) {
			Funcionario funcionario = (Funcionario) usuarios.get(cpf);
			if (funcionario instanceof Gerente) {
				this.menuGerente(cpf);

			} else if (funcionario instanceof Diretor) {

				this.menuDiretor(cpf);

			} else if (funcionario instanceof Presidente) {
				this.menuPresidente(cpf);
			} else {
				System.out.println(corVermelha + "XXXXXXXXXXXXXXX CPF ou senha inválidos XXXXXXXXXXXXXXXX" + resetCor);
			}
		}
	}

	public void menuCliente(String cpf) throws IOException {
		Usuarios cliente = (Cliente) usuarios.get(cpf);
		System.out.println("      Bem Vindo " + cliente.getNome());
		if (cliente.getConta().getTipo().equalsIgnoreCase(ContaBancariaEnum.ContaCorrente.name())) {
			System.out.println("      Digite a ação que deseja efetuar\n        " + "1- Saque\n        "
			+ "2- Deposito\n        " + "3- Transação\n        " + "4- Simulador rendimento\n        "
			+ "5- Extrato\n        " + "6- Seguro de vida\n         " + "9- Sair");
		} else if (cliente.getConta().getTipo().equalsIgnoreCase(ContaBancariaEnum.ContaPoupanca.name())) {
			System.out.println("        Digite a ação que deseja efetuar\n        " + "1- Saque\n        "
					+ "2- Deposito\n        " + "3- Transação\n        " + "4- Simulador rendimento\n        "
					+ "5- Extrato\n        " + "6- Seguro de vida\n        " + "9- Sair");
		}
		int escolha = sc.nextInt();
		System.out.println("Bem Vindo " + cliente.getNome());
		switch (escolha) {

		case 1:
			transacoes.saque(cpf, extrato);
			break;
		case 2:
			transacoes.deposito(cpf, extrato);
			break;
		case 3:
			transacoes.transferencia(cpf, usuarios, extrato);
			break;
		case 4:
			ContaPoupanca.calcularRendimento(cpf, usuarios);
			break;
		case 5:
			transacoes.extrato(cpf, usuarios, extrato);
			break;
		case 6:
			transacoes.Seguro(cpf, usuarios);
			break;
		case 9:
			menuPrincipal();
			break;
		}
	}

	public void menuGerente(String cpf) throws IOException {
		List<Usuarios> listaClientes = InOutUtils.getListaCliente();
		Funcionario gerente = (Gerente) usuarios.get(cpf);
		System.out.println("Bem Vindo " + gerente.getNome());
		System.out.println("Informações da conta:\n " + gerente.getCargo());
		System.out.println("Informações da conta:\n " + AgenciaEnum.SANTANDER.name());
		System.out.println(
				"        Digite a ação que deseja efetuar:\n        " + " 1- Saque\n        " + " 2- Deposito\n        "
						+ " 3- Transação\n        " + " 4- Simular Rendimento\n        " + " 5- Extrato\n        "
						+ " 6- Criar conta\n        " + " 7- Relatorios de Contas\n        " + " 9- Sair");

		int escolha = sc.nextInt();

		switch (escolha) {

		case 1:
			transacoes.saque(cpf, extrato);
			break;
		case 2:
			transacoes.deposito(cpf, extrato);
			break;
		case 3:
			transacoes.transferencia(cpf, usuarios, extrato);
			break;
		case 4:
			ContaPoupanca.calcularRendimento(cpf, usuarios);
			break;
		case 5:
			transacoes.extrato(cpf, usuarios, extrato);
			break;
		case 6:
			System.out.println("Qual tipo de conta deseja criar?");
			int tipoconta = sc.nextInt();
			if (tipoconta == 1) {
				ContaCorrente Corrente = new ContaCorrente(cpf, 1000, 1, ContaBancariaEnum.ContaCorrente.name());
				gerente.setConta(Corrente);
				contas.put(cpf, Corrente);
				InOutUtils.escritorConta(caminhoConta, Corrente, contas);
			}

			else if (tipoconta == 2) {
				ContaPoupanca Poupanca = new ContaPoupanca(gerente.getCpf(), 1000, 2,
						ContaBancariaEnum.ContaPoupanca.name());
				gerente.setConta(Poupanca);
				gerente.getConta().setSaldo(1000);
				contas.put(cpf, Poupanca);
				InOutUtils.escritorConta(caminhoConta, Poupanca, contas);
			} else {
				System.out.println(corVermelha + "XXXXXXXXXXXXXXX Inválido XXXXXXXXXXXXXXXX" + resetCor);
			}
			break;
		case 7:

			relatorios.clientesAgencia(cpf, usuarios, contas);
			break;
		case 8:
			relatorios.totalTributacao(cpf, usuarios);
			break;
		case 9:
			menuPrincipal();
			break;
		}
	}

	public void menuDiretor(String cpf) throws IOException {
		List<Usuarios> listaClientes = InOutUtils.getListaCliente();
		Funcionario diretor = (Funcionario) usuarios.get(cpf);
		MenuTransacoes menuT = new MenuTransacoes();
		System.out.println("Bem Vindo " + diretor.getNome());
		System.out.println("Cargo de :" + diretor.getCargo());
		System.out.println(
				"        Digite a ação que deseja efetuar\n        " + " 1- Saque\n        " + " 2- Deposito\n        "
						+ " 3- Transação\n        " + " 4- Simular Rendimento\n        " + " 5- Extrato\n        "
						+ " 6- Criar conta\n       " + "  7- Relatorio de contas\n       " + "  9- Sair");
		int escolha = sc.nextInt();

		switch (escolha) {

		case 1:
			transacoes.saque(cpf, extrato);
			break;
		case 2:
			transacoes.deposito(cpf, extrato);
			break;
		case 3:
			transacoes.transferencia(cpf, usuarios, extrato);
			break;
		case 4:
			ContaPoupanca.calcularRendimento(cpf, usuarios);
			break;
		case 5:
			menuT.extrato(cpf, usuarios, extrato);
			break;
		case 6:
			System.out.println("Qual tipo de conta deseja criar?");
			int tipoconta = sc.nextInt();
			if (tipoconta == 1) {
				ContaCorrente Corrente = new ContaCorrente(cpf, 1000, 1, ContaBancariaEnum.ContaCorrente.name());
				diretor.setConta(Corrente);
				contas.put(cpf, Corrente);
				InOutUtils.escritorConta(caminhoConta, Corrente, contas);
			}

			else if (tipoconta == 2) {
				ContaPoupanca Poupanca = new ContaPoupanca(diretor.getCpf(), 1000, 2,
						ContaBancariaEnum.ContaPoupanca.name());
				diretor.setConta(Poupanca);
				diretor.getConta().setSaldo(1000);
				contas.put(cpf, Poupanca);
				InOutUtils.escritorConta(caminhoConta, Poupanca, contas);
			} else {
				System.out.println(corVermelha + "XXXXXXXXXXXXXXX Inválido XXXXXXXXXXXXXXXX" + resetCor);
			}
			break;
		case 7:
			relatorios.clientesOrganiza(listaClientes);
			break;
		case 9:
			menuPrincipal();
			break;
		}
	}

	public void menuPresidente(String cpf) throws IOException {
		MenuTransacoes menuT = new MenuTransacoes();
		List<Usuarios> listaClientes = InOutUtils.getListaCliente();
		Funcionario presidente = (Funcionario) usuarios.get(cpf);
		System.out.println("Bem Vindo " + presidente.getNome());
		System.out.println("Cargo de : " + presidente.getCargo());
		System.out.println("Sua Agência é : " + AgenciaEnum.SANTANDER.getAgencia());
		visualizarNumeroClientes();
		System.out.println("        Digite a ação que deseja efetuar\n        " + " 1- Saque\n        "
				+ " 2- Deposito\n        " + " 3- Transação\n        " + " 4- Simular Rendimento\n        "
				+ " 5- Extrato\n        " + " 6- Relatorios de Contas\n       " + " 7- Relatorio valor capital\n       "
				+ " 8- Seguro de Vida\n       " + " 9- Total tributacao\n      " + "10- Sair\n      ");
		int escolha = sc.nextInt();

		switch (escolha) {

		case 1:
			transacoes.saque(cpf, extrato);
			break;
		case 2:
			transacoes.deposito(cpf, extrato);
			break;
		case 3:
			transacoes.transferencia(cpf, usuarios, extrato);
			break;
		case 4:
			ContaPoupanca.calcularRendimento(cpf, usuarios);
			break;
		case 5:
			transacoes.extrato(cpf, usuarios, extrato);
			break;
		case 6:
			relatorios.clientesOrganiza(listaClientes);
			break;
		case 7:
			relatorios.totalDeCapital(cpf, usuarios, contas);
			break;
		case 8:
			transacoes.Seguro(cpf, usuarios);
			break;
		case 9:
			relatorios.totalTributacao(cpf, usuarios);
			break;
		case 10:
			menuPrincipal();
			break;
		}
	}

	public int getNumeroClientes() {
		return usuarios.size();
	}

	public void visualizarNumeroClientes() {
		int numeroClientes = getNumeroClientes();
		System.out.println("Número de Clientes: " + numeroClientes);
	}
}