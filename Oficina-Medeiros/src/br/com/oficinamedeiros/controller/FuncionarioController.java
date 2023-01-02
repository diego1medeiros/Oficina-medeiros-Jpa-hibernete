package br.com.oficinamedeiros.controller;

import java.awt.Font;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.oficinamedeiros.entity1.Funcionario;
import br.com.oficinamedeiros.service.FuncionarioServiceImpl;

public class FuncionarioController {

	private JTable table;
	private FuncionarioServiceImpl funcionarioServiceImpl = new FuncionarioServiceImpl();
	
	public List<Funcionario> buscarDadosDosFuncionarios(Funcionario funcionario) {
		return funcionarioServiceImpl.buscarDadosDosFuncionarios(funcionario);
	}
	public Funcionario cadastraFuncionario (Funcionario funcionario) {
		
		
		return funcionarioServiceImpl.cadastraFuncionario (funcionario);
	}
	
	public Funcionario editarFuncionario(Funcionario funcionario) {
		return funcionarioServiceImpl.editarFuncionario(funcionario);
	}
	
	public Funcionario removerFuncionario(Funcionario funcionario) {
		return funcionarioServiceImpl.removerFuncionario(funcionario);
	}
	
	public List<Funcionario> buscarDadosDoFuncionarios() {
		return funcionarioServiceImpl.buscarDadosDoFuncionarios();
	}


	public boolean isLoginSenhaValida(String login, String senha) {
		List<Funcionario> listaFuncionarios = buscarDadosDoFuncionarios();
		for (Funcionario funcionario : listaFuncionarios) {
			if (login.equals(funcionario.getLogin()) && senha.equals(funcionario.getSenha())) {
				return true;
			}
		}
		return false;
	}

	public JTable criarTabela() {

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Fun\u00E7\u00E3o", "Nome", "Cpf",
				"Telefone", "Email", "Endere\u00E7o", "Login", "Senha", "Id_funcionario" }));
		table.getColumnModel().getColumn(8).setPreferredWidth(0);
		table.getColumnModel().getColumn(8).setMinWidth(0);
		table.getColumnModel().getColumn(8).setMaxWidth(0);
		return table;
	}

	public void carregarTable() {

		List<Funcionario> listaFuncionarios = buscarDadosDoFuncionarios() ;
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		for (Funcionario funcionario : listaFuncionarios) {
			modelo.addRow(new Object[] { funcionario.getFuncao(), funcionario.getNome(), funcionario.getCpf(),
					 funcionario.getTelefone(),funcionario.getEmail(), funcionario.getEndereco(),
					funcionario.getLogin(), funcionario.getSenha(), funcionario.getIdFuncionario() });
		}
	}

	public void carregarPesquisaFuncionarioTabela(Funcionario funcionario1) {

		List<Funcionario> listaFuncionarios =  buscarDadosDosFuncionarios(funcionario1);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		for (Funcionario funcionario : listaFuncionarios) {
			modelo.addRow(new Object[] { funcionario.getFuncao(), funcionario.getNome(), funcionario.getCpf(),
					funcionario.getEmail(), funcionario.getTelefone(), funcionario.getEndereco(),
					funcionario.getLogin(), funcionario.getSenha(), funcionario.getIdFuncionario() });
		}
		if (!listaFuncionarios.isEmpty()) {
			JOptionPane.showMessageDialog(null, " FUNCIONARIO  ENCONTRADO");
		} else {
			JOptionPane.showMessageDialog(null, " FUNCIONARIO NÃO ENCONTRADO");
		}
	}

}
