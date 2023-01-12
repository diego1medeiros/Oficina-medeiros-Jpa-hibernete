package br.com.oficinamedeiros.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.w3c.dom.events.EventTarget;

import br.com.oficinamedeiros.controller.ClienteController;
import br.com.oficinamedeiros.controller.VeiculoController;
import br.com.oficinamedeiros.entity1.BonusCliente;
import br.com.oficinamedeiros.entity1.BonusClienteId;
import br.com.oficinamedeiros.entity1.Cliente;
import br.com.oficinamedeiros.entity1.Veiculo;
import br.com.ofinamedeiros.enumeradores.BonusParaCliente;

import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class BonusParaClientes {

	JFrame frmOficinaMedeiros;
	private VeiculoController veiculoController = new VeiculoController();
	private ClienteController clienteController = new ClienteController();
	private JComboBox comboBoxClientes;
	private JLabel lblNewLabel_1;
	private JComboBox<Veiculo> comboBoxVeiculos;
	private JComboBox comboBoxBonus;
	private JTable table = new JTable();
	private BonusCliente bonusCliente = new BonusCliente();
	private JTextField textFieldCliente;
	private JTextField textFieldVeiculo;

	private JButton btnExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BonusParaClientes window = new BonusParaClientes();
					window.frmOficinaMedeiros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BonusParaClientes() {
		initialize();
		clienteController.carregarTabelaBonus();

	}

	private void initialize() {
		frmOficinaMedeiros = new JFrame();
		frmOficinaMedeiros
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\diego\\Downloads\\worm-gear-icon.png"));
		frmOficinaMedeiros.setTitle("OFICINA MEDEIROS");
		frmOficinaMedeiros.getContentPane().setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.setBounds(100, 100, 1381, 736);
		frmOficinaMedeiros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOficinaMedeiros.getContentPane().setLayout(null);
		frmOficinaMedeiros.setExtendedState(frmOficinaMedeiros.MAXIMIZED_BOTH);
		JLabel lblNewLabel = new JLabel("CLIENTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(419, 78, 75, 17);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel);
		table = clienteController.tabelaDeBonus();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(421, 284, 523, 413);
		frmOficinaMedeiros.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				selecionarLinha();
			}
		});

		comboBoxClientes = new JComboBox(clienteController.buscarDadosDosClientes().toArray());
		comboBoxClientes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));

		comboBoxClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List<Veiculo> listaVeiculos = veiculoController
						.buscarVeiculos(comboBoxClientes.getSelectedItem().toString());
				comboBoxVeiculos.removeAllItems();
				for (Veiculo veiculo : listaVeiculos) {
					comboBoxVeiculos.addItem(veiculo);
				}
			}
		});

		comboBoxClientes.setSelectedItem("");
		comboBoxClientes.setBounds(535, 76, 295, 22);
		frmOficinaMedeiros.getContentPane().add(comboBoxClientes);

		lblNewLabel_1 = new JLabel("VEICULOS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(418, 132, 76, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_1);
		comboBoxVeiculos = new JComboBox();
		comboBoxVeiculos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		comboBoxVeiculos.setBounds(535, 129, 156, 22);
		frmOficinaMedeiros.getContentPane().add(comboBoxVeiculos);

		comboBoxBonus = new JComboBox(BonusParaCliente.getDescricaoComboBox());
		comboBoxBonus.setEditable(true);
		comboBoxBonus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		comboBoxBonus.setBounds(535, 187, 295, 22);
		frmOficinaMedeiros.getContentPane().add(comboBoxBonus);

		JButton btnNewSalvar = new JButton("CADASTRAR");
		btnNewSalvar.setBackground(SystemColor.activeCaption);
		btnNewSalvar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewSalvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Cliente cliente = (Cliente) comboBoxClientes.getSelectedItem();
				Veiculo veiculo = (Veiculo) comboBoxVeiculos.getSelectedItem();
				bonusCliente.setDescricaoBonus(comboBoxBonus.getSelectedItem().toString());
				clienteController.cadastrarBonusCliente(bonusCliente, cliente, veiculo);
				clienteController.carregarTabelaBonus();
			}
		});
		btnNewSalvar.setBounds(465, 238, 114, 23);
		frmOficinaMedeiros.getContentPane().add(btnNewSalvar);
		JLabel lblNewLabel_3 = new JLabel("BONUS");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setBounds(437, 189, 76, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("CADASTRAR BONUS PARA CLIENTES");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_4.setBounds(477, 11, 411, 40);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		lblNewLabel_5.setBounds(10, 65, 212, 176);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		lblNewLabel_5_1.setBounds(1199, 65, 212, 176);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_5_1);

		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.desktop);
		separator.setBounds(0, 52, 1365, 15);
		frmOficinaMedeiros.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.desktop);
		separator_1.setBounds(-18, 284, 1383, 17);
		frmOficinaMedeiros.getContentPane().add(separator_1);

	    btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
				
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnExcluir.setBackground(SystemColor.activeCaption);
		btnExcluir.setBounds(634, 238, 114, 23);
		frmOficinaMedeiros.getContentPane().add(btnExcluir);

		textFieldCliente = new JTextField();
		textFieldCliente.setBounds(20, 252, -5, 20);
		frmOficinaMedeiros.getContentPane().add(textFieldCliente);
		textFieldCliente.setColumns(10);

		textFieldVeiculo = new JTextField();
		textFieldVeiculo.setBounds(227, 252, -5, 20);
		frmOficinaMedeiros.getContentPane().add(textFieldVeiculo);
		textFieldVeiculo.setColumns(10);
		
		JButton btnNewButton = new JButton("MENU");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BonusParaClientes window = new BonusParaClientes();
				window.frmOficinaMedeiros.setVisible(false);
				MenuPrincipal menu = new MenuPrincipal();
				menu.frmOficinaMedeiros.setVisible(true);
				frmOficinaMedeiros.dispose();
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBounds(788, 238, 100, 23);
		frmOficinaMedeiros.getContentPane().add(btnNewButton);

	}

	public void selecionarLinha() {

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		comboBoxClientes.setSelectedItem(modelo.getValueAt(table.getSelectedRow(), 0).toString());
		comboBoxVeiculos.setSelectedItem(modelo.getValueAt(table.getSelectedRow(), 1).toString());
		bonusCliente.setDescricaoBonus(modelo.getValueAt(table.getSelectedRow(), 2).toString());
	    bonusCliente.setBonusClienteId(new BonusClienteId());
		bonusCliente.getBonusClienteId().setIdCliente((Long) modelo.getValueAt(table.getSelectedRow(), 3));
		bonusCliente.getBonusClienteId().setIdVeiculo((Long) modelo.getValueAt(table.getSelectedRow(), 4));
		btnExcluir.setEnabled(true);
	}

	public void limpaDados() {
		comboBoxClientes.setSelectedItem("");
		comboBoxVeiculos.setSelectedItem("");
		comboBoxBonus.setSelectedItem("");
	}

	public void excluir() {

		switch (JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE EXCLUIR O BONUS DO CLIENTE ?", "",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
		case 0:
			clienteController.removerBonus(bonusCliente);
            clienteController.carregarTabelaBonus();
            btnExcluir.setEnabled(false);
			JOptionPane.showMessageDialog(null, "BONUS FUI EXCLUIDO !!!");
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "BONUS NÃO FUI EXCLUIDO !!!");
			break;
		}
	}
}
