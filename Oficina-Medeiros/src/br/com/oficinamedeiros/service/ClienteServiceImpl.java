package br.com.oficinamedeiros.service;

import java.util.List;

import br.com.oficinamedeiros.dao.ClienteDAO;
import br.com.oficinamedeiros.entity1.BonusCliente;
import br.com.oficinamedeiros.entity1.Cliente;
import br.com.oficinamedeiros.entity1.Veiculo;


public class ClienteServiceImpl implements ClienteService {

	private ClienteDAO clienteDAO = new ClienteDAO();

	@Override
	public Cliente cadastrarCliente(Cliente cliente) {
		return clienteDAO.cadastrarCliente(cliente);

	}

	@Override
	public Cliente editarCliente(Cliente cliente) {
		return clienteDAO.editarCliente(cliente);
	}

	@Override
	public Cliente removerCliente(Cliente cliente) {
		return clienteDAO.removerCliente(cliente);
	}

	@Override
	public List<Cliente> buscarDadosDosClientes() {
		return clienteDAO.buscarDadosDosClientes();
	}

	@Override
	public List<Cliente> buscarDadosDosClientes(Cliente cliente) {
		return clienteDAO.buscarDadosDosClientes(cliente);
	}

	@Override
	public BonusCliente cadastrarBonusCliente(BonusCliente bonusCliente , Cliente cliente, Veiculo veiculo) {
		return clienteDAO.cadastrarBonusCliente(bonusCliente, cliente, veiculo);
	}

	@Override
	public List<BonusCliente> buscarBonusDosClientes() {
		return clienteDAO.buscarBonusDosClientes();
	}

	@Override
	public BonusCliente removerBonus(BonusCliente bonusCliente) {
		return clienteDAO.removerBonus(bonusCliente);
	}

}
