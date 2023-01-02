package br.com.oficinamedeiros.entity1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "\"FUNCIONARIO\"")
public class Funcionario extends Pessoa  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"ID_FUNCIONARIO\"")
	private Long idFuncionario;
	@Column(name ="\"FUNCAO\"")
	private String funcao;
	@Column(name = "\"LOGIN\"")
	private String login;
	@Column(name = "\"SENHA\"")
	private String senha;
	

	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public String getFuncao() {
		return funcao;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return this.getNome();

	}

	public Funcionario(Long idFuncionario,String funcao,String nome, String cpf, String telefone, String email, String endereco, String login, String senha ) {
		super(nome, cpf, telefone, email, endereco);
		
		this.funcao = funcao;
		this.login = login;
		this.senha = senha;
		this.idFuncionario = idFuncionario;
	}
   public Funcionario () {
	
}

public Funcionario( String funcao,String nome, String cpf, String telefone, String email, String endereco, String login,
		String senha) {
	super(nome, cpf, telefone, email, endereco);
	
	this.funcao = funcao;
	this.login = login;
	this.senha = senha;
}
   
   
   
}
