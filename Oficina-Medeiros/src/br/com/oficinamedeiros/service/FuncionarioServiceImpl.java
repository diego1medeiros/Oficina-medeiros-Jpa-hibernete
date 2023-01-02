package br.com.oficinamedeiros.service;

import java.util.List;

import br.com.oficinamedeiros.dao.FuncionarioDAO;
import br.com.oficinamedeiros.entity1.Funcionario;


public class FuncionarioServiceImpl implements FuncionarioService {

	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

	@Override
	public Funcionario cadastraFuncionario (Funcionario funcionario) {
		return funcionarioDAO.cadastraFuncionario (funcionario);
	}

	@Override
	public Funcionario editarFuncionario(Funcionario funcionario) {
		return funcionarioDAO.editarFuncionario(funcionario);
	}

	@Override
	public Funcionario removerFuncionario(Funcionario funcionario) {
		return funcionarioDAO.removerFuncionario(funcionario);
	}

	@Override
	public List<Funcionario>buscarDadosDoFuncionarios() {
		return funcionarioDAO.buscarDadosDoFuncionarios();
	}

	@Override
	public List<Funcionario> buscarDadosDosFuncionarios(Funcionario funcionario) {
		return funcionarioDAO.buscarDadosDosFuncionarios(funcionario);
	}

	
	
}
