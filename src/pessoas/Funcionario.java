package pessoas;

public abstract class Funcionario {
	protected String nome;
	protected String senha;
	protected String email;
	protected String cargo;
	public Funcionario(String nome, String senha, String email, String cargo) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.cargo = cargo;
	}
	
	public String getNome() {
		return nome;
	}
	public String getSenha() {
		return senha;
	}
	public String getEmail() {
		return email;
	}
	public String getCargo() {
		return cargo;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


}
