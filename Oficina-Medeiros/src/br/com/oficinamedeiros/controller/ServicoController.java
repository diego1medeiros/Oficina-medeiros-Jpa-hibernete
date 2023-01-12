package br.com.oficinamedeiros.controller;

import java.awt.Font;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.com.oficinamedeiros.Vo.ServicoVo;
import br.com.oficinamedeiros.entity1.Servico;
import br.com.oficinamedeiros.service.ServicoServiceImpl;
import br.com.oficinamedeiros.util.Utils;

public class ServicoController {
	private static final String FORMATO_DIA_MES_ANO = "dd-MM-yyyy";
	private JTable table;
	private ServicoServiceImpl servicoServiceImpl = new ServicoServiceImpl();

	public List<Servico> buscarDadosDosServicos(Servico servico) {
		return servicoServiceImpl.buscarDadosDosServicos(servico);
	}

	
	public Servico atualizarStatusServico(Servico servico) {
		return servicoServiceImpl.atualizarStatusServico(servico);
	}

	public Servico cadastrarServico(Servico servico) {
		return servicoServiceImpl.cadastrarServico(servico);
	}

	public Servico removerServico(Servico servico) {
		return servicoServiceImpl.removerServico(servico);
	}

	public List<Servico> buscaDadosdosServicos() {
		return servicoServiceImpl.buscaDadosdosServicos();
	}

	public Servico editarServico(Servico servico) {
		return servicoServiceImpl.editarServico(servico);
	}

	public List<Servico> buscarServicosPorNomeFuncionario(String nomeFuncionario) {
		return servicoServiceImpl.buscarServicosPorNomeFuncionario(nomeFuncionario);
	}

	public List<ServicoVo> buscaQdtDosServicosPorFuncionarios() {
		return servicoServiceImpl.buscaQdtDosServicosPorFuncionarios();
	}

	public List<ServicoVo> relatorioValorTotalDeServicos(Servico servico) {
		return servicoServiceImpl.relatorioValorTotalDeServicos(servico);
	}

	public JTable criarTabela() {

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));

		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "FUNCIONARIO", "CLIENTE", "MODELO", "DATA DO SERVICO", "DATA DO SERVICO", "VALOR",
						"STATUS", "PAGAMENTO", "DESCRI\u00C7\u00C3O", "OBSERVA\u00C7\u00C3O", "ID_SERVICO",
						"ID_CLIENTE", "ID_VEICULO", "ID_FUNCIONARIO" }));
		table.getColumnModel().getColumn(10).setPreferredWidth(0);
		table.getColumnModel().getColumn(10).setMinWidth(0);
		table.getColumnModel().getColumn(10).setMaxWidth(0);
		table.getColumnModel().getColumn(11).setPreferredWidth(0);
		table.getColumnModel().getColumn(11).setMinWidth(0);
		table.getColumnModel().getColumn(11).setMaxWidth(0);
		table.getColumnModel().getColumn(12).setPreferredWidth(0);
		table.getColumnModel().getColumn(12).setMinWidth(0);
		table.getColumnModel().getColumn(12).setMaxWidth(0);
		table.getColumnModel().getColumn(13).setPreferredWidth(0);
		table.getColumnModel().getColumn(13).setMinWidth(0);
		table.getColumnModel().getColumn(13).setMaxWidth(0);

		return table;
	}

	public void carregarTable() {

		List<Servico> listaServicos = buscaDadosdosServicos();
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		for (Servico servico : listaServicos) {

			modelo.addRow(new Object[] { servico.getFuncionario().getNome(), servico.getCliente().getNome(),
					servico.getVeiculo().getModelo(), Utils.formatarData(servico.getData(), FORMATO_DIA_MES_ANO),
					Utils.formatarData(servico.getDataEntrega(), FORMATO_DIA_MES_ANO), servico.getValor(),
					servico.getStatus(),Utils.formatoPagamento(servico.getPago()), servico.getDescricao(), servico.getObservacoes(),
					servico.getIdServico(), servico.getCliente().getIdCliente(), servico.getVeiculo().getIdVeiculo(),
					servico.getFuncionario().getIdFuncionario() });
		}
	}

	public void carregarPesquisaServicoTabela(Servico servico1) {

		List<Servico> listaServicos = buscarDadosDosServicos(servico1);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		for (Servico servico : listaServicos) {
			modelo.addRow(new Object[] { servico.getFuncionario().getNome(), servico.getCliente().getNome(),
					servico.getVeiculo().getModelo(), Utils.formatarData(servico.getData(), FORMATO_DIA_MES_ANO),
					Utils.formatarData(servico.getDataEntrega(), FORMATO_DIA_MES_ANO), servico.getValor(),
					servico.getStatus(), servico.getPago(), servico.getDescricao(), servico.getObservacoes(),
					servico.getIdServico(), servico.getCliente().getIdCliente(), servico.getVeiculo().getIdVeiculo(),
					servico.getFuncionario().getIdFuncionario() });
		}
		if (!listaServicos.isEmpty()) {
			JOptionPane.showMessageDialog(null, " SERVIÇO  ENCONTRADO!!!");
		} else {
			JOptionPane.showMessageDialog(null, " SERVIÇO NÃO ENCONTRADO!!!");
		}

	}

	public void carregarPesquisaFuncionarioServicoTabela(String nomeFuncionario) {
		List<Servico> listaServicos = buscarServicosPorNomeFuncionario(nomeFuncionario);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		for (Servico servico : listaServicos) {
			modelo.addRow(new Object[] { servico.getFuncionario().getNome(), servico.getCliente().getNome(),
					servico.getVeiculo().getModelo(), Utils.formatarData(servico.getData(), FORMATO_DIA_MES_ANO),
					Utils.formatarData(servico.getDataEntrega(), FORMATO_DIA_MES_ANO), servico.getValor(),
					servico.getStatus(), servico.getPago(), servico.getDescricao(), servico.getObservacoes(),
					servico.getIdServico(), servico.getCliente().getIdCliente(), servico.getVeiculo().getIdVeiculo(),
					servico.getFuncionario().getIdFuncionario() });
		}
		if (!listaServicos.isEmpty()) {
			JOptionPane.showMessageDialog(null, " SERVIÇO  ENCONTRADO!!!");
		} else {
			JOptionPane.showMessageDialog(null, " SERVIÇO NÃO ENCONTRADO!!!");
		}
	}

	public JTable carregarTabelaRelario() {
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));

		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "FUNCIONARIO", "QTD DE SERVI\u00C7OS" }));

		return table;
	}

	public void carregarTabelaQtdDeServicosPorFuncionario() {
		List<ServicoVo> listaServicos = buscaQdtDosServicosPorFuncionarios();
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		for (ServicoVo servicoVo : listaServicos) {
			modelo.addRow(new Object[] { servicoVo.getNomeFuncionario(), servicoVo.getQtdeServico() });
		}
	}

	public JTable criarTabelaServico() {

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));

		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "COD", "FUNCIONARIO", "CLIENTE", "MODELO", "DATA DO SERVICO", "DATA DO SERVICO", "VALOR",
						"STATUS", "PAGAMENTO", "DESCRI\u00C7\u00C3O", "OBSERVA\u00C7\u00C3O"}));

		return table;
	}

	public void carregarPesquisaValorTotalServicoTabela1(Servico servico) {

		List<ServicoVo> listaServicos = relatorioValorTotalDeServicos(servico);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		for (ServicoVo servicoVo : listaServicos) {
			modelo.addRow(
					new Object[] { servicoVo.getQtdeServico(), servicoVo.getNomeFuncionario(), servicoVo.getNomeCliente(),
							servicoVo.getModelo(), Utils.formatarData(servicoVo.getDataServico(), FORMATO_DIA_MES_ANO),
							Utils.formatarData(servicoVo.getDataEntrega(), FORMATO_DIA_MES_ANO), servicoVo.getValor(),
							servicoVo.getStatus(), Utils.formatoPagamento(servicoVo.getPago()), servicoVo.getDescricao(),
							servicoVo.getObservacoes(),servicoVo.getValorTotal() });
			
		}
		if (!listaServicos.isEmpty()) {
			JOptionPane.showMessageDialog(null, " SERVIÇO  ENCONTRADO!!!");
		} else {
			JOptionPane.showMessageDialog(null, " SERVIÇO NÃO ENCONTRADO!!!");
		}

	}

	public List<Servico> relatorioValorTotalDeServicos1(Servico servico) {
		return servicoServiceImpl.relatorioValorTotalDeServicos1(servico);
	}

	public void carregarPesquisaValorTotalServicoTabela11(Servico servico1) {

		List<Servico> listaServicos = relatorioValorTotalDeServicos1(servico1);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		for (Servico servico : listaServicos) {
			modelo.addRow(new Object[] { servico.getIdServico(), servico.getFuncionario().getNome(),
					servico.getCliente().getNome(), servico.getVeiculo().getModelo(),
					Utils.formatarData(servico.getData(), FORMATO_DIA_MES_ANO),
					Utils.formatarData(servico.getDataEntrega(), FORMATO_DIA_MES_ANO), servico.getValor(),
					servico.getStatus(), Utils.formatoPagamento(servico.getPago()), servico.getDescricao(),
					servico.getObservacoes() });
		}
		if (!listaServicos.isEmpty()) {
			JOptionPane.showMessageDialog(null, " SERVIÇO  ENCONTRADO!!!");
		} else {
			JOptionPane.showMessageDialog(null, " SERVIÇO NÃO ENCONTRADO!!!");
		}

	}

}
