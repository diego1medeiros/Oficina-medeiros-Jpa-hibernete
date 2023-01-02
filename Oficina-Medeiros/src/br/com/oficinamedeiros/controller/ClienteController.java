package br.com.oficinamedeiros.controller;

import java.awt.Font;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.oficinamedeiros.entity1.BonusCliente;
import br.com.oficinamedeiros.entity1.Cliente;
import br.com.oficinamedeiros.entity1.Veiculo;
import br.com.oficinamedeiros.service.ClienteServiceImpl;

public class ClienteController {
	private VeiculoController veiculoController = new VeiculoController();

	private JTable table = new JTable();
	private ClienteServiceImpl clienteServiceImpl = new ClienteServiceImpl();

	public Cliente cadastrarCliente(Cliente cliente) {
		return clienteServiceImpl.cadastrarCliente(cliente);
	}

	public Cliente editarCliente(Cliente cliente) {
		return clienteServiceImpl.editarCliente(cliente);
	}

	public List<Cliente> buscarDadosDosClientes() {
		return clienteServiceImpl.buscarDadosDosClientes();
	}

	public Cliente removerCliente(Cliente cliente) {
		return clienteServiceImpl.removerCliente(cliente);
	}

	public List<Cliente> buscarDadosDosClientes(Cliente cliente) {
		return clienteServiceImpl.buscarDadosDosClientes(cliente);
	}

	public BonusCliente cadastrarBonusCliente(BonusCliente bonusCliente, Cliente cliente, Veiculo veiculo) {
		return clienteServiceImpl.cadastrarBonusCliente(bonusCliente, cliente, veiculo);
	}

	public List<BonusCliente> buscarBonusDosClientes() {
		return clienteServiceImpl.buscarBonusDosClientes();
	}
	
	public BonusCliente removerBonus(BonusCliente bonusCliente) {
		return clienteServiceImpl.removerBonus(bonusCliente);
	}

	public JTable criarTabela() {

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Cpf", "Telefone", "Email", "Endere\u00E7o", "Id_Cliente" }));
		table.getColumnModel().getColumn(5).setPreferredWidth(0);
		table.getColumnModel().getColumn(5).setMinWidth(0);
		table.getColumnModel().getColumn(5).setMaxWidth(0);
		return table;
	}

	public Collection<?> carregarTabela() {

		List<Cliente> listaClientes = buscarDadosDosClientes();
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		for (Cliente cliente : listaClientes) {
			modelo.addRow(new Object[] { cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), cliente.getEmail(),
					cliente.getEndereco(), cliente.getIdCliente() });

		}
		return listaClientes;
	}

	public void carregarTabelaComBuscarDeDadosDosClientes(Cliente cliente1) {

		List<Cliente> listaClientes = buscarDadosDosClientes(cliente1);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		for (Cliente cliente : listaClientes) {
			modelo.addRow(new Object[] { cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), cliente.getEmail(),
					cliente.getEndereco(), cliente.getIdCliente() });
		}
		if (!listaClientes.isEmpty()) {
			JOptionPane.showMessageDialog(null, " CLIENTE  ENCONTRADO!!!!");
		} else {
			JOptionPane.showMessageDialog(null, " CLIENTE NÃO ENCONTRADO!!!!");
		}
	}

	public JTable tabelaDeBonus() {

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "CLIENTE", "VEICULO", "BONUS","id","id" }));
		table.getColumnModel().getColumn(3).setPreferredWidth(0);
		table.getColumnModel().getColumn(3).setMinWidth(0);
		table.getColumnModel().getColumn(3).setMaxWidth(0);
		table.getColumnModel().getColumn(4).setPreferredWidth(0);
		table.getColumnModel().getColumn(4).setMinWidth(0);
		table.getColumnModel().getColumn(4).setMaxWidth(0);
		return table;

	}

	public void carregarTabelaBonus() {

		List<BonusCliente> listaBonus = buscarBonusDosClientes();
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		for (BonusCliente bonus : listaBonus) {
			Veiculo veiculo = veiculoController.buscarVeiculoPorId(bonus.getBonusClienteId().getIdVeiculo());
			modelo.addRow(new Object[] {veiculo.getCliente().getNome(), veiculo.getModelo(),
					bonus.getDescricaoBonus(),bonus.getBonusClienteId().getIdCliente(),bonus.getBonusClienteId().getIdVeiculo() });
		}
	}
}
