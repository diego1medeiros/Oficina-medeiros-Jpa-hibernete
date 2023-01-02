package br.com.oficinamedeiros.controller;

import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.oficinamedeiros.entity1.Veiculo;
import br.com.oficinamedeiros.service.VeiculoServiceImpl;

public class VeiculoController {

	private JTable table;
	private VeiculoServiceImpl veiculoServiceImpl = new VeiculoServiceImpl();

	public List<Veiculo> buscarDadosDosVeiculos(Veiculo veiculo) {
		return veiculoServiceImpl.buscarDadosDosVeiculos(veiculo);
	}

	public Veiculo cadastrarVeiculo(Veiculo veiculo) {
		return veiculoServiceImpl.cadastrarVeiculo(veiculo);
	}

	public Veiculo editarVeiculo(Veiculo veiculo) {
		return veiculoServiceImpl.editarVeiculo(veiculo);
	}

	public List<Veiculo> buscarDadosDosVeiculos() {
		return veiculoServiceImpl.buscarDadosDosVeiculos();
	}

	public Veiculo removerVeiculo(Veiculo veiculo) {
		return veiculoServiceImpl.removerVeiculo(veiculo);
	}

	public List<Veiculo> buscarVeiculos(String nomeCliente) {
		return veiculoServiceImpl.buscarVeiculos(nomeCliente);
	}

	public Veiculo buscarVeiculoPorId(Long id) {
		return veiculoServiceImpl.buscarVeiculoPorId(id);
	}
	
	public Veiculo excluirBonusVeiculoPorId(Long id) {
		return veiculoServiceImpl.excluirBonusVeiculoPorId(id);
	}

	public JTable criarJTable() {

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "CLIENTE", "TIPO", "MODELO", "MARCA", "ANO", "ID_VEICULO", "ID_CLIENTE" }));
		table.getColumnModel().getColumn(5).setPreferredWidth(0);
		table.getColumnModel().getColumn(5).setMinWidth(0);
		table.getColumnModel().getColumn(5).setMaxWidth(0);
		table.getColumnModel().getColumn(6).setPreferredWidth(0);
		table.getColumnModel().getColumn(6).setMinWidth(0);
		table.getColumnModel().getColumn(6).setMaxWidth(0);

		return table;

	}

	public void carregarTabela() {
		List<Veiculo> listaVeiculos = buscarDadosDosVeiculos();
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		for (Veiculo veiculo : listaVeiculos) {
			modelo.addRow(new Object[] { veiculo.getCliente().getNome(), veiculo.getTipo(), veiculo.getModelo(),
					veiculo.getMarca(), veiculo.getAno(), veiculo.getIdVeiculo(),
					veiculo.getCliente().getIdCliente() });
		}
	}

	public void carregarPesquisaVeiculosTabela(Veiculo veiculo1) {
		List<Veiculo> listaVeiculos = buscarDadosDosVeiculos(veiculo1);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		for (Veiculo veiculo : listaVeiculos) {
			modelo.addRow(new Object[] { veiculo.getCliente().getNome(), veiculo.getTipo(), veiculo.getModelo(),
					veiculo.getMarca(), veiculo.getAno(), veiculo.getIdVeiculo(),
					veiculo.getCliente().getIdCliente() });
		}
		if (!listaVeiculos.isEmpty()) {
			JOptionPane.showMessageDialog(null, " VEICULO  ENCONTRADO");
		} else {
			JOptionPane.showMessageDialog(null, " VEICULO NÃO ENCONTRADO");
		}
	}

	public void carregarVeiculosTabela(String nomeCliente) {
		List<Veiculo> listaVeiculos = buscarVeiculos(nomeCliente);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		for (Veiculo veiculo : listaVeiculos) {
			modelo.addRow(new Object[] { veiculo.getCliente().getNome(), veiculo.getTipo(), veiculo.getModelo(),
					veiculo.getMarca(), veiculo.getAno(), veiculo.getIdVeiculo(),
					veiculo.getCliente().getIdCliente() });
		}
		if (!listaVeiculos.isEmpty()) {
			JOptionPane.showMessageDialog(null, " VEICULO  ENCONTRADO");
		} else {
			JOptionPane.showMessageDialog(null, " VEICULO NÃO ENCONTRADO");
		}

	}
}