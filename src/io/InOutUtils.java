package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import enums.ClientesEnum;
import enums.ContaBancariaEnum;
import enums.FuncionariosEnum;
import enums.TransacoesEnum;
import extratos.Extrato;
import extratos.ExtratoDepositos;
import extratos.ExtratoSaques;
import extratos.ExtratoTransferencias;
import pessoas.Cliente;
import pessoas.Diretor;
import pessoas.Funcionario;
import pessoas.Gerente;
import pessoas.Presidente;
import pessoas.Usuarios;

public class InOutUtils {
	private static int contador = 0;
	private static List<Usuarios> listaCliente;

	public static void escritorConta(String path, Conta conta, Map<String, Conta> contas) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		for (Conta contaPercorre : contas.values()) {
			writer.append(contaPercorre.toString() + "\n");
		}
		writer.close();
	}

	public static void escritorExtrato(String path, Extrato extrato, List<Extrato> extratoMap) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
			extrato.setIdTransacao(Integer.toString(contador));
			writer.write(extrato.toString());
			writer.newLine();
			contador++;
		} catch (IOException e) {
			System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
		}

	}

	public static void escritorClientes(String path, Cliente cliente) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
			writer.write(cliente.toString());
			writer.newLine();
		} catch (IOException e) {
			System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
		}

	}

	public static Map<String, Conta> leitorContas(String path, Map<String, Conta> contas,
			Map<String, Usuarios> usuarios) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		List<Conta> listaContas = new ArrayList<>();
		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				String[] contasV = linha.split(";");
				if (contasV[0].equalsIgnoreCase(ContaBancariaEnum.ContaPoupanca.name())) {
					ContaPoupanca conta = new ContaPoupanca(contasV[1], Double.parseDouble(contasV[2]),
							Integer.parseInt(contasV[3]), (contasV[4]));
					usuarios.get(contasV[1]).setConta(conta);
					Usuarios c = usuarios.get(contasV[1]);
					c.setConta(conta);
					contas.put(contasV[1], conta);

				} else if (contasV[0].equalsIgnoreCase(ContaBancariaEnum.ContaCorrente.name())) {

					ContaCorrente conta = new ContaCorrente(contasV[1], Double.parseDouble(contasV[2]),
							Integer.parseInt(contasV[3]), (contasV[4]));
					usuarios.get(contasV[1]).setConta(conta);
					Usuarios c = usuarios.get(contasV[1]);
					c.setConta(conta);
					contas.put(contasV[1], conta);
				}
			} else
				break;
		}
		buffRead.close();
		return contas;
	}

	public static Map<String, Usuarios> leitorPessoas(String path, Map<String, Usuarios> usuarios) throws IOException {
		listaCliente = new ArrayList<>();
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				String[] pessoas = linha.split(";");
				Funcionario f;
				if (pessoas[0].equalsIgnoreCase(FuncionariosEnum.GERENTE.name())) {
					f = new Gerente((pessoas[1]), (pessoas[2]), (pessoas[3]), (pessoas[4]),
							Integer.parseInt(pessoas[5]), pessoas[0]);
					usuarios.put(pessoas[3], f);
					listaCliente.add(f);
				} else if (pessoas[0].equalsIgnoreCase(FuncionariosEnum.DIRETOR.name())) {
					f = new Diretor((pessoas[1]), (pessoas[2]), (pessoas[3]), (pessoas[4]), pessoas[0]);
					usuarios.put(pessoas[3], f);
					listaCliente.add(f);
//						System.out.println("É Diretor");
				} else if (pessoas[0].equalsIgnoreCase(FuncionariosEnum.PRESIDENTE.name())) {
					f = new Presidente((pessoas[1]), (pessoas[2]), (pessoas[3]), (pessoas[4]), pessoas[0]);
					usuarios.put(pessoas[3], f);
					listaCliente.add(f);
//						System.out.println("É Presidente");
				} else {
					Cliente c = new Cliente((pessoas[1]), (pessoas[2]), (pessoas[3]), (pessoas[0]));
					listaCliente.add(c);
					usuarios.put(pessoas[3], c);

				}
			} else {
				break;
			}

		}
		buffRead.close();
		return usuarios;
	}

	public static List<Extrato> leitorExtrato(String path, List<Extrato> extrato) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		LocalDateTime teste;
		String linha = "";
		List<Extrato> listaExtrato = new ArrayList<>();
		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				String[] extratoV = linha.split(";");
				Extrato extratos;
				if (extratoV[0].equalsIgnoreCase(TransacoesEnum.Saques.name())) {
					extratos = new ExtratoSaques(Integer.toString(contador), extratoV[1],
							(Double.parseDouble(extratoV[2]) * -1), LocalDateTime.parse(extratoV[3]), extratoV[0]);
					extrato.add(extratos);
					listaExtrato.add(extratos);
				} else if (extratoV[0].equalsIgnoreCase(TransacoesEnum.Depositos.name())) {
					extratos = new ExtratoDepositos(Integer.toString(contador), extratoV[1],
							Double.parseDouble(extratoV[2]), LocalDateTime.parse(extratoV[3]), extratoV[0]);
					extrato.add(extratos);
					listaExtrato.add(extratos);
				} else if (extratoV[0].equalsIgnoreCase(TransacoesEnum.Transferencias.name())) {
					extratos = new ExtratoTransferencias(Integer.toString(contador), extratoV[1],
							Double.parseDouble(extratoV[2]), LocalDateTime.parse(extratoV[3]), extratoV[0],
							extratoV[5]);
					extrato.add(extratos);
					listaExtrato.add(extratos);

				}
			} else
				break;
			contador++;
		}
		buffRead.close();
		return listaExtrato;
	}

	public static List<Usuarios> getListaCliente() {
		return listaCliente;
	}
}
