package relatorios;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import contas.Conta;
import enums.AgenciaEnum;
import menus.Menulogin;
import pessoas.Gerente;
import pessoas.Usuarios;

public class Relatorios {
	
	Scanner sc = new Scanner(System.in);
	
	public void clientesAgencia(String cpf, Map<String, Usuarios> usuarios, Map<String, Conta> contas) throws IOException {
		Menulogin login = new Menulogin();
		Gerente gerente = (Gerente) usuarios.get(cpf);
		int contador = 0;
		Usuarios cliente = login.usuarios.get(cpf);
		login.usuarios.get(cpf);
		
		if(gerente.getAgencia() == 1) {
			for(Conta conta : contas.values()) {
				if(conta.getAgencia() == 1) {
					contador++;
				}
			}System.out.println("Número de clientes na agencia "+AgenciaEnum.SANTANDER.name()+": " +contador);
			
		}else if (gerente.getAgencia() == 2) {
			for(Conta conta : contas.values()) {
				if(conta.getAgencia() == 2) {
					contador++;
				}
			}System.out.println("Número de clientes na agencia "+AgenciaEnum.BANCODOBRASIL.name()+": " +contador);
			
		}	
		System.out.println("1- Continuar | 2- Sair");
		int escolha = sc.nextInt();
		switch (escolha) {
		case 1:
			this.clientesAgencia(cpf, usuarios, contas);
		case 2:
			 if (login.usuarios.get(cpf).getTipo().equalsIgnoreCase("Gerente")) {
				login.menuGerente(cpf);
			} else if (login.usuarios.get(cpf).getTipo().equalsIgnoreCase("Diretor")) {
				login.menuDiretor(cpf);
			} else if (login.usuarios.get(cpf).getTipo().equalsIgnoreCase("Presidente")) {
				login.menuPresidente(cpf);
			}
		}
	}
	public void clientesOrganiza(List<Usuarios> listaClientes, String cpf) throws IOException {
		Menulogin login = new Menulogin();
		Usuarios cliente1 = login.usuarios.get(cpf);
		login.usuarios.get(cpf);

		Collections.sort(listaClientes);
		for(Usuarios cliente: listaClientes) {
			System.out.println("Nome:" + cliente.getNome() + " Cpf:" + cliente.getCpf() + " Agencia:" + cliente.getConta().getAgencia());
		}
		System.out.println("1- Continuar | 2- Sair");
		int escolha = sc.nextInt();
		switch (escolha) {
		case 1:
			this.clientesOrganiza(listaClientes, cpf);;
		case 2:
			 if (login.usuarios.get(cpf).getTipo().equalsIgnoreCase("Gerente")) {
				login.menuGerente(cpf);
			} else if (login.usuarios.get(cpf).getTipo().equalsIgnoreCase("Diretor")) {
				login.menuDiretor(cpf);
			} else if (login.usuarios.get(cpf).getTipo().equalsIgnoreCase("Presidente")) {
				login.menuPresidente(cpf);
			}
		}
	}
	
	public void totalDeCapital(String cpf, Map<String, Usuarios> usuarios, Map<String, Conta> contas) throws IOException {
		Menulogin login = new Menulogin();
		Usuarios cliente1 = login.usuarios.get(cpf);
		login.usuarios.get(cpf);
		
		double total = 0;
        for(Usuarios usuario : usuarios.values()) {
            total += usuario.getConta().getSaldo();
        }

        System.out.println("O total de capital é: "+ total + "\nClientes: " + usuarios.size() );
        
        System.out.println("1- Continuar | 2- Sair");
		int escolha = sc.nextInt();
		switch (escolha) {
		case 1:
			this.totalDeCapital(cpf, usuarios, contas);
		case 2:
			 if (login.usuarios.get(cpf).getTipo().equalsIgnoreCase("Gerente")) {
				login.menuGerente(cpf);
			} else if (login.usuarios.get(cpf).getTipo().equalsIgnoreCase("Diretor")) {
				login.menuDiretor(cpf);
			} else if (login.usuarios.get(cpf).getTipo().equalsIgnoreCase("Presidente")) {
				login.menuPresidente(cpf);
			}
		}
    }
	
	public void totalTributacao(String cpf, Map<String, Usuarios> usuarios) throws IOException {
		Menulogin login = new Menulogin();
		Usuarios cliente1 = login.usuarios.get(cpf);
		login.usuarios.get(cpf);
		Usuarios cliente = usuarios.get(cpf);
		System.out.println("O total Tributado foi: " +cliente.getConta().getTotal());
		
		System.out.println("1- Continuar | 2- Sair");
		int escolha = sc.nextInt();
		switch (escolha) {
		case 1:
			this.totalTributacao(cpf, usuarios);
		case 2:
			 if (login.usuarios.get(cpf).getTipo().equalsIgnoreCase("Gerente")) {
				login.menuGerente(cpf);
			} else if (login.usuarios.get(cpf).getTipo().equalsIgnoreCase("Diretor")) {
				login.menuDiretor(cpf);
			} else if (login.usuarios.get(cpf).getTipo().equalsIgnoreCase("Presidente")) {
				login.menuPresidente(cpf);
			}
		}
	}	
}