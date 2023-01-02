package br.com.oficinamedeiros.service;

import java.util.List;
import br.com.oficinamedeiros.dao.VeiculoDAO;
import br.com.oficinamedeiros.entity1.Veiculo;


public class VeiculoServiceImpl implements VeiculoService {

	VeiculoDAO veiculoDAO = new VeiculoDAO();
	
	
	@Override
	public Veiculo cadastrarVeiculo(Veiculo veiculo) {
		return veiculoDAO.cadastrarVeiculo(veiculo);
	}

	@Override
	public Veiculo editarVeiculo(Veiculo veiculo) {
		return veiculoDAO.editarVeiculo(veiculo);
	}

	@Override
	public List<Veiculo> buscarDadosDosVeiculos() {
		return veiculoDAO.buscarDadosDosVeiculos();
	}

	@Override
	public Veiculo removerVeiculo(Veiculo veiculo) {
		return veiculoDAO.removerVeiculo(veiculo);
	}

	@Override
	public List<Veiculo> buscarDadosDosVeiculos(Veiculo veiculo) {
		return veiculoDAO.buscarDadosDosVeiculos(veiculo);
	}

	@Override
	public List<Veiculo> buscarVeiculos(String nomeCliente) {
		return veiculoDAO.buscarVeiculos(nomeCliente);
	}

	@Override
	public Veiculo buscarVeiculoPorId(Long id) {
		return veiculoDAO.buscarVeiculoPorId(id);
	}

	@Override
	public Veiculo excluirBonusVeiculoPorId(Long id) {
		return veiculoDAO.excluirBonusVeiculoPorId(id);
	}

	
	

}
