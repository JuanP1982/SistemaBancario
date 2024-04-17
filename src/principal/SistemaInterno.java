package principal;

import menus.Menulogin;

public class SistemaInterno {

	public static void main(String[] args) {
		Menulogin menulogin = new Menulogin();
		
		
		menulogin.menuPrincipal();

	}

//	private static boolean souCliente(String cpf, String senha) {
//		for (Cliente cliente : clientes) {
//			if (cliente.getCpf().equals(cpf) && cliente.getSenha().equals(senha)) {
//				return true;
//			} 
//		} return false;
//	}
//	
//	private static boolean souFuncionario (String cpf, String senha) {
//		for (Funcionario funcionario : funcionarios) {
//			if (funcionario.getCpf().equals(senha) && funcionario.getSenha().equals(senha)) {
//				return funcionario;
//			}
//		} return false;
//	}
}
