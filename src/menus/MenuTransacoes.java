package menus;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import contas.Conta;
import enums.TransacoesEnum;
import extratos.Extrato;
import extratos.ExtratoDepositos;
import extratos.ExtratoSaques;
import extratos.ExtratoTransferencias;
import io.InOutUtils;
import pessoas.Usuarios;

public class MenuTransacoes {
	Scanner sc = new Scanner(System.in);
	static Menulogin login = new Menulogin();

	static Map<String, String> TransfMap = new HashMap<>();

	public void saque(String cpf, List<Extrato> extrato) throws IOException {
		ExtratoSaques exSaque = new ExtratoSaques(null, null, 0, null, "Saque");
		Usuarios cliente = login.usuarios.get(cpf);

		System.out.println("Bem vindo ao menu de saque!");
		System.out.println("Seu saldo é: " + cliente.getConta().getSaldo());
		System.out.println("Quanto deseja sacar?");
		double valor = sc.nextDouble();
		cliente.getConta().saque(valor);
		exSaque.setarValores(valor, cpf, LocalDateTime.now());
		extrato.add(exSaque);
		login.usuarios.put(cpf, cliente);

		InOutUtils.escritorExtrato("../SistemaBancario/arquivos/extrato.txt", exSaque, extrato);
		InOutUtils.escritorConta("../SistemaBancario/arquivos/contas.txt", (Conta) cliente.getConta(), login.contas);

		System.out.println("Seu saldo é: " + cliente.getConta().getSaldo());
		System.out.println("1- Continuar | 2- Sair");
		int escolha = sc.nextInt();
		switch (escolha) {
		case 1:
			this.saque(cpf, extrato);
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

	public void deposito(String cpf, List<Extrato> extrato) throws IOException {
		ExtratoDepositos exDeposito = new ExtratoDepositos(null, null, 0, null, null);
		Usuarios cliente = login.usuarios.get(cpf);
		login.usuarios.get(cpf);

		System.out.println("Bem vindo ao menu de Depositos!");
		System.out.println("Seu saldo é: " + cliente.getConta().getSaldo());
		System.out.println("Quanto deseja depositar?");
		double valor = sc.nextDouble();
		cliente.getConta().deposito(valor);

		exDeposito.setarValores(valor, cpf, LocalDateTime.now());
		extrato.add(exDeposito);
		System.out.println("Seu saldo é: " + cliente.getConta().getSaldo());

		InOutUtils.escritorExtrato("../SistemaBancario/arquivos/extrato.txt", exDeposito, extrato);
		InOutUtils.escritorConta("../SistemaBancario/arquivos/contas.txt", (Conta) cliente.getConta(), login.contas);
		System.out.println("1- Continuar | 2- Sair");
		int escolha = sc.nextInt();
		switch (escolha) {
		case 1:
			this.deposito(cpf, extrato);
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

	public void transacao(String cpf, Map<String, Usuarios> usuarios, List<Extrato> extrato) throws IOException {
		ExtratoTransferencias exTransf = new ExtratoTransferencias(null, null, 0, null, null, null);
		Usuarios cliente = usuarios.get(cpf);
		usuarios.get(cpf);

		double valor;
		String cpf2;

		System.out.println("Bem vindo ao menu de Transação||Transferencia!");
		System.out.println("Seu saldo é: " + String.format("%.2f", cliente.getConta().getSaldo()));
		System.out.println("Escreva o CPF de quem deseja transferir!");
		cpf2 = sc.next();
		System.out.println("Quanto deseja transferir?");
		valor = sc.nextDouble();
		cliente.getConta().transacaoEnviar(valor);
		exTransf.setarValores(valor, cpf, LocalDateTime.now(), cpf2);
		usuarios.get(cpf2).getConta().transacaoReceber(valor);

		InOutUtils.escritorConta("../SistemaBancario/arquivos/contas.txt", (Conta) cliente.getConta(), login.contas);
		System.out.println(String.format("%.2f", cliente.getConta().getSaldo()));
		System.out.println(
				usuarios.get(cpf2).getNome() + String.format("%.2f", usuarios.get(cpf2).getConta().getSaldo()));
		InOutUtils.escritorExtrato("../SistemaBancario/arquivos/extrato.txt", exTransf, extrato);
	}

	public void extrato(String cpf, Map<String, Usuarios> usuarios, List<Extrato> extratos) throws IOException {
		Usuarios cliente = usuarios.get(cpf);
		usuarios.get(cpf);
		int escolha = 0;
		System.out.println(extratos);
		System.out.println("        Bem-vindo ao menu de extrato");
		System.out.println("        Qual extrato você que ver?\n        " + " 1- Saques\n        "
				+ " 2- Depositos\n        " + " 3- Transferências\n        " + " 4- Sair");
		escolha = sc.nextInt();

		switch (escolha) {
		case 1:
			System.out.println("Extratos de Saques:");
			for (Extrato extrato : extratos) {
				if (extrato.getCpfTitular().equals(cpf)
						&& extrato.getTipo().equalsIgnoreCase(TransacoesEnum.Saques.name())) {
					System.out.println("Tipo: " + extrato.getTipo());
					System.out.println("Valor: " + extrato.getValor());

				}
			}
			break;
		case 2:
			System.out.println("Extratos de Depositos:");
			for (Extrato extrato : extratos) {
				if (extrato.getCpfTitular().equals(cpf)
						&& extrato.getTipo().equalsIgnoreCase(TransacoesEnum.Depositos.name())) {
					System.out.println("Tipo: " + extrato.getTipo());
					System.out.println("Valor: " + extrato.getValor());

				}
			}
			break;
		case 3:
			for (Extrato extrato : extratos) {
				if (extrato.getCpfTitular().equals(cpf)
						&& extrato.getTipo().equalsIgnoreCase(TransacoesEnum.Transferencias.name())) {
					System.out.println("Tipo: " + extrato.getTipo());
					System.out.println("Valor: " + extrato.getValor());
				}
			}
			break;
		}

		System.out.println("1- Continuar | 2- Sair");
		int escolha2 = sc.nextInt();
		switch (escolha2) {
		case 1:
			this.extrato(cpf, usuarios, extratos);
		case 2:
			if (usuarios.get(cpf).getTipo().equalsIgnoreCase("Cliente")) {
				login.menuCliente(cpf);
			} else if (usuarios.get(cpf).getTipo().equalsIgnoreCase("Gerente")) {
				login.menuGerente(cpf);
			} else if (usuarios.get(cpf).getTipo().equalsIgnoreCase("Diretor")) {
				login.menuDiretor(cpf);
			} else if (usuarios.get(cpf).getTipo().equalsIgnoreCase("Presidente")) {
				login.menuPresidente(cpf);
			}
		}
	}

	public void Seguro(String cpf, Map<String, Usuarios> usuarios) throws IOException {
		Menulogin login = new Menulogin();
		Usuarios cliente = usuarios.get(cpf);
		usuarios.get(cpf);

		System.out.println("Bem vindo ao menu de Seguros!");
		System.out.println("Seu saldo é: " + cliente.getConta().getSaldo());
		System.out.println("Nosso Seguro conta com um taxa de debito de 20% do valor atual da conta");
		System.out.println("e com um retorno para o segurado de '5 MIL REAIS");
		System.out.println("Gostaria de fazer um seguro ?");
		System.out.println("Digite 1 para SIM ou 2 para NÃO !");
		double valorcon = 5000 * 0.20;
		double novoSaldo = cliente.getConta().getSaldo() - valorcon;
		int escolha = sc.nextInt();
		if (escolha == 1) {
			if (cliente.getConta().getSaldo() >= valorcon) {
                cliente.getConta().setSaldo(novoSaldo);
                System.out.println("Seguro contratado com sucesso!");
            } else {
                System.out.println("Saldo insuficiente para adesão de plano.");
            }
        } else if (escolha == 2) {
            System.out.println("Operação cancelada.");
        } else {
            System.out.println("Opção inválida.");
        }


		InOutUtils.escritorConta("../SistemaBancario/arquivos/contas.txt", (Conta) cliente.getConta(), login.contas);
		System.out.println(usuarios.get(cpf).getNome() + " " + usuarios.get(cpf).getConta().getSaldo());
	}
}
