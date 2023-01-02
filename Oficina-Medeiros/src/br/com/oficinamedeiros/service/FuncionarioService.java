package br.com.oficinamedeiros.service;

import java.util.List;

import br.com.oficinamedeiros.entity1.Funcionario;



public interface FuncionarioService {

	public List<Funcionario> buscarDadosDosFuncionarios(Funcionario funcionario); 

	public Funcionario cadastraFuncionario (Funcionario funcionario) ;
	
	public Funcionario editarFuncionario(Funcionario funcionario);
	
	public Funcionario removerFuncionario(Funcionario funcionario);
	
	public List<Funcionario> buscarDadosDoFuncionarios(); 
}
