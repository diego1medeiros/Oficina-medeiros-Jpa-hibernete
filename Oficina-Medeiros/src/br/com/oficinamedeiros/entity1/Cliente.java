package br.com.oficinamedeiros.entity1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"CLIENTE\"")
public class Cliente extends Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"ID_CLIENTE\"")
	private Long idCliente;
	
	
	
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Cliente(String nome) {

	}

	public Cliente(String nome, String cpf, String telefone, String email, String endereco) {
		super(nome, cpf, telefone, email, endereco);
	}

	public Cliente() {
	}

	public Cliente(String nome, String cpf, String telefone, String email, String endereco, Long idCliente) {
		super(nome, cpf, telefone, email, endereco);
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return this.getNome();
	}
}
