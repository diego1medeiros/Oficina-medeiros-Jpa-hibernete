package br.com.oficinamedeiros.service;

import java.util.List;

import br.com.oficinamedeiros.entity1.Veiculo;


public interface VeiculoService {
	
	
	public List<Veiculo> buscarDadosDosVeiculos(Veiculo veiculo);
	
	public Veiculo cadastrarVeiculo(Veiculo veiculo);
	
	public Veiculo editarVeiculo( Veiculo veiculo);
	
	public List<Veiculo> buscarDadosDosVeiculos();
	
	public Veiculo removerVeiculo(Veiculo veiculo);
	
	public List<Veiculo> buscarVeiculos(String  nomeCliente); 
	
	public Veiculo buscarVeiculoPorId(Long id) ;
	
	public Veiculo excluirBonusVeiculoPorId(Long id);
}
