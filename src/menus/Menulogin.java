package menus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import enums.ContaBancariaEnum;
import pessoas.Cliente;
import pessoas.Diretor;
import pessoas.Funcionario;
import pessoas.Gerente;
import pessoas.Presidente;

public class Menulogin {
	Map<String, Cliente> clientes = new HashMap<>();
	Map<String, Funcionario> funcionarios = new HashMap<>();
	int escolha = 0;

	public void menuPrincipal() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bem vindo ao banco da Residência");
		while (escolha != 3) {
			System.out.println("Escolha um número:\n 1- Registrar-se\n 2- Login\n 3- Sair");
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
			if (escolha == 2) {
				break;
			}
		}

	}

	public void registro() {
		Scanner sc = new Scanner(System.in);
		Cliente cliente = new Cliente();
		System.out.println("Digite o seu nome: ");
		cliente.setNome(sc.next());

		System.out.println("Digite sua senha: ");
		cliente.setSenha(sc.next());

		System.out.println("Digite seu email: ");
		cliente.setEmail(sc.next());

		System.out.println("Digite seu cpf: ");
		String cpf = sc.next();
		
		System.out.println("Qual tipo de conta deseja criar? (1- Conta Corrente  | Conta Poupanca)");
		int tipoconta = sc.nextInt();
		if(tipoconta == 1) {
			cliente.setTipoConta(ContaBancariaEnum.ContaCorrente);
			System.out.println("Agradecemos o seu registro no Banco Residencia\nSeu saldo inicial é : R$ 1000");
			clientes.put(cpf, cliente);

		}else if (tipoconta == 2) {
			cliente.setTipoConta(ContaBancariaEnum.CONTAPOUPANCA);
			System.out.println("Agradecemos o seu registro no Banco Residencia\nSeu saldo inicial é : R$ 1000");
			clientes.put(cpf, cliente);

		}else {
			System.out.println("Inválido!");
		}
		
		

	}

	public void login() {
		String cpf;
		String senha;
		
		
		Scanner sc = new Scanner(System.in);
		
		Cliente cliente1 = new Cliente("Juan", "Costa", "juanpedrovsc@gmail.com", ContaBancariaEnum.CONTAPOUPANCA);
		
		clientes.put("17723135726", cliente1);
		
		System.out.println("-".repeat(10) + "Login" + "-".repeat(10));
		System.out.println("Digite seu cpf (Apenas números) : ");
		cpf = sc.next();

		System.out.println("Digite sua senha: ");
		senha = sc.next();

		if (clientes.containsKey(cpf) && clientes.get(cpf).getSenha().equals(senha)) {
			this.menuCliente(cpf);
		} else if (funcionarios.containsKey(cpf) && funcionarios.get(cpf).getSenha().equals(senha)) {
			Funcionario funcionario = funcionarios.get(cpf);
			if (funcionario instanceof Gerente) {
				System.out.println("-".repeat(10) + "Menu do Gerente" + "-".repeat(10));
			
			} else if (funcionario instanceof Diretor) {
				System.out.println("-".repeat(10) + "Menu do Diretor" + "-".repeat(10));

			} else if (funcionario instanceof Presidente) {
				System.out.println("-".repeat(10) + "Menu do Presidente" + "-".repeat(10));
			} else {
				System.out.println("Cpf ou senha inválidos!");
			}
		}
	}
	
	public void menuCliente(String cpf) {
		Cliente cliente = clientes.get(cpf);
		System.out.println("Bem Vindo " + cliente.getNome());
		System.out.println("Informações da conta:\n " + cliente.getTipoConta().toString());
	}
}
