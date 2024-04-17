package relatorios;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import contas.Conta;
import enums.AgenciaEnum;
import pessoas.Gerente;
import pessoas.Usuarios;

public class Relatorios {
	
	public void clientesAgencia(String cpf, Map<String, Usuarios> usuarios, Map<String, Conta> contas) {
		Gerente gerente = (Gerente) usuarios.get(cpf);
		int contador = 0;
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
	}
	public void clientesOrganiza(List<Usuarios> listaClientes) {
		Collections.sort(listaClientes);
		for(Usuarios cliente: listaClientes) {
			System.out.println("Nome:" + cliente.getNome() + " Cpf:" + cliente.getCpf() + " Agencia:" + cliente.getConta().getAgencia());
		}
	}
}