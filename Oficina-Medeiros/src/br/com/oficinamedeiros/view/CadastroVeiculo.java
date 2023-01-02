package br.com.oficinamedeiros.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.com.oficinamedeiros.controller.ClienteController;
import br.com.oficinamedeiros.controller.VeiculoController;
import br.com.oficinamedeiros.entity1.Cliente;
import br.com.oficinamedeiros.entity1.Veiculo;
import br.com.oficinamedeiros.exception.OficinaException;

import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CadastroVeiculo {

	private JComboBox textTipo;
	private JComboBox marcaCarros;
	private JComboBox<Cliente> clientes;
	private VeiculoController veiculoController = new VeiculoController();
	private Veiculo veiculo = new Veiculo();
	JFrame frmOficinaMedeiros;
	private JTextField textModelo;
	private JTextField textAno;
	private JTable table;
	private int acaoBotao;
	private DefaultTableModel modelo;
	private JButton btnSave;
	private JTextField textld;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroVeiculo window = new CadastroVeiculo();
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
	public CadastroVeiculo() {
		initialize();
		veiculoController.carregarTabela();
		limparDados();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOficinaMedeiros = new JFrame();
		frmOficinaMedeiros.getContentPane().setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.getContentPane().setLayout(null);
		frmOficinaMedeiros.setExtendedState(frmOficinaMedeiros.MAXIMIZED_BOTH);

		JLabel lblNewLabel = new JLabel("CADASTRO DE VEICULOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(488, 43, 370, 31);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.desktop);
		separator.setBounds(0, 114, 1363, 14);
		frmOficinaMedeiros.getContentPane().add(separator);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		lblNewLabel_1.setBounds(1116, 119, 157, 156);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("TIPO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(359, 211, 112, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("MODELO");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(740, 211, 68, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_3);

		textModelo = new JTextField();
		textModelo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textModelo.setEnabled(false);
		textModelo.setBounds(818, 210, 191, 20);
		frmOficinaMedeiros.getContentPane().add(textModelo);
		textModelo.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("MARCA ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setBounds(347, 252, 80, 20);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("ANO");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_5.setBounds(740, 255, 46, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_5);

		textAno = new JTextField();
		textAno.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textAno.setEnabled(false);
		textAno.setBounds(818, 254, 191, 20);
		frmOficinaMedeiros.getContentPane().add(textAno);
		textAno.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.desktop);
		separator_1.setBounds(-18, 290, 1474, 2);
		frmOficinaMedeiros.getContentPane().add(separator_1);

		table = veiculoController.criarJTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 384, 1363, 313);
		frmOficinaMedeiros.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		marcaCarros = new JComboBox();
		marcaCarros.setBackground(Color.WHITE);
		marcaCarros.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		marcaCarros.setEnabled(false);
		marcaCarros.setModel(new DefaultComboBoxModel(
				new String[] { "", "Volkswagen", "Chevrolet", "Fiat", "Hyundai", "Toyota", "Jeep", "Caoa Chery",
						"Renault", "Nissan", "Honda", "Peugeot", "Ford", "Citroen", "Mitsubishi", "Audi", "BWM",
						"Volvo", "Mercedes-Benz", "JAC Motors", "Kia", "Land Rover", "Suzuki", "RAM", "Porsche" }));
		marcaCarros.setBounds(435, 253, 219, 22);
		frmOficinaMedeiros.getContentPane().add(marcaCarros);

		textld = new JTextField();
		textld.setBounds(110, 9, 0, 20);
		frmOficinaMedeiros.getContentPane().add(textld);
		textld.setColumns(10);

		textTipo = new JComboBox();
		textTipo.setBackground(Color.WHITE);
		textTipo.setEnabled(false);
		textTipo.setModel(
				new DefaultComboBoxModel(new String[] { "", "Carro", "\u00D4nibus", "Caminh\u00E3o", "Moto" }));
		textTipo.setBounds(435, 209, 219, 22);
		frmOficinaMedeiros.getContentPane().add(textTipo);

		ClienteController clienteController = new ClienteController();
		List<Cliente> listaClientes = clienteController.buscarDadosDosClientes();

		clientes = new JComboBox(listaClientes.toArray());
		clientes.setEditable(true);
		clientes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		clientes.setEnabled(false);
		clientes.setBounds(534, 161, 338, 22);
		frmOficinaMedeiros.getContentPane().add(clientes);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				selecionarItem();
			}
		});

		JButton btnNew = new JButton("NOVO");
		btnNew.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Actions-document-new-icon.png"));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoBotao = 1;
				limparDados();
				habiltarFuncoes();
			}
		});
		btnNew.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnNew.setBackground(SystemColor.activeCaption);
		btnNew.setBounds(96, 314, 93, 41);
		frmOficinaMedeiros.getContentPane().add(btnNew);

		btnSave = new JButton("SALVAR");
		btnSave.setEnabled(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		btnSave.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Actions-document-save-icon.png"));
		btnSave.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnSave.setBackground(SystemColor.activeCaption);
		btnSave.setBounds(269, 314, 101, 41);
		frmOficinaMedeiros.getContentPane().add(btnSave);

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoBotao = 2;
				habiltarFuncoes();
			}
		});
		btnEditar.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Programming-Edit-Property-icon.png"));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnEditar.setBackground(SystemColor.activeCaption);
		btnEditar.setBounds(450, 314, 101, 41);
		frmOficinaMedeiros.getContentPane().add(btnEditar);

		JButton btnDelete = new JButton("EXCLUIR");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDelete.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\delete-file-icon (1).png"));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnDelete.setBackground(SystemColor.activeCaption);
		btnDelete.setBounds(631, 314, 107, 41);
		frmOficinaMedeiros.getContentPane().add(btnDelete);

		JButton btnCancel = new JButton("CANCELAR");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparDados();
				desabilitaFuncoes();
			}
		});
		btnCancel.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Status-dialog-error-icon.png"));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnCancel.setBackground(SystemColor.activeCaption);
		btnCancel.setBounds(818, 314, 113, 41);
		frmOficinaMedeiros.getContentPane().add(btnCancel);

		JButton btnNext = new JButton("PROXIMO");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastrarServico servico = new CadastrarServico();
				servico.frmOficinaMedeiros.setVisible(true);
				CadastroVeiculo telaVeiculo = new CadastroVeiculo();
				telaVeiculo.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();

			}
		});
		btnNext.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Arrow-Next-icon.png"));
		btnNext.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnNext.setBackground(SystemColor.activeCaption);
		btnNext.setBounds(1011, 314, 109, 41);
		frmOficinaMedeiros.getContentPane().add(btnNext);

		JLabel lblNewLabel_6 = new JLabel("CLIENTE");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_6.setBounds(428, 161, 114, 22);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_6);

		JButton btnNewButton = new JButton("MENU");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuPrincipal menu = new MenuPrincipal();
				menu.frmOficinaMedeiros.setVisible(true);
				CadastroVeiculo window = new CadastroVeiculo();
				window.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Very-Basic-Menu-icon.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnNewButton.setBounds(1200, 314, 95, 41);
		frmOficinaMedeiros.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		lblNewLabel_7.setBounds(64, 139, 191, 136);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_7);

		frmOficinaMedeiros.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.setTitle("OFICINA MEDEIROS");
		frmOficinaMedeiros
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\diego\\Downloads\\worm-gear-icon.png"));
		frmOficinaMedeiros.setBounds(100, 100, 1379, 736);
		frmOficinaMedeiros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void save() {

		if (iscamposPreenchidos()) {
			if (acaoBotao == 1) {
				veiculoController.cadastrarVeiculo(
						veiculo = new Veiculo( textTipo.getSelectedItem().toString(),
								textModelo.getText(), marcaCarros.getSelectedItem().toString(), textAno.getText(),
								(Cliente) clientes.getSelectedItem()));

				veiculoController.carregarTabela();
				JOptionPane.showMessageDialog(null, " VEICULO CADASTRADO !!!");
				limparDados();
				desabilitaFuncoes();

			} else if (acaoBotao == 2) {

				
				veiculoController.editarVeiculo(
						veiculo = new Veiculo(veiculo.getIdVeiculo(), textTipo.getSelectedItem().toString(),
								textModelo.getText(), marcaCarros.getSelectedItem().toString(), textAno.getText(),
								(Cliente) clientes.getSelectedItem()));
				veiculoController.carregarTabela();
				JOptionPane.showMessageDialog(null, "VEICULO ATUALIZADO!!!");
			}
		}
	}

	public void delete() {

		switch (JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE EXCLUIR VEICULO ?", "", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE)) {

		case 0:

			modelo.removeRow(table.getSelectedRow());
			veiculoController.removerVeiculo(veiculo);
			veiculoController.carregarTabela();
			JOptionPane.showMessageDialog(null, "VEICULO FUI EXCLUIDO!!!");
			break;

		case 1:

			JOptionPane.showMessageDialog(null, "VEICULO NÃO FUI EXCLUIDO!!!");
			break;
		}
	}

	public void limparDados() {

		clientes.setSelectedItem("");
		textModelo.setText("");
		textAno.setText("");
		marcaCarros.setSelectedItem("");
	}

	public void desabilitaFuncoes() {

		marcaCarros.setEnabled(false);
		textModelo.setEnabled(false);
		textTipo.setEnabled(false);
		textAno.setEnabled(false);
		btnSave.setEnabled(false);
		clientes.setEnabled(false);
	}

	public void habiltarFuncoes() {

		textModelo.setEnabled(true);
		textTipo.setEnabled(true);
		textAno.setEnabled(true);
		marcaCarros.setEnabled(true);
		btnSave.setEnabled(true);
		clientes.setEnabled(true);

	}

	public void selecionarItem() {

		modelo = (DefaultTableModel) table.getModel();
		clientes.setSelectedItem(modelo.getValueAt(table.getSelectedRow(), 0).toString());
		textTipo.setSelectedItem(modelo.getValueAt(table.getSelectedRow(), 1).toString());
		marcaCarros.setSelectedItem(modelo.getValueAt(table.getSelectedRow(), 3).toString());
		textModelo.setText(modelo.getValueAt(table.getSelectedRow(), 2).toString());
		textAno.setText(modelo.getValueAt(table.getSelectedRow(), 4).toString());
		textld.setText(modelo.getValueAt(table.getSelectedRow(), 5).toString());
		veiculo.setIdVeiculo(Long.parseLong(textld.getText()));
		veiculo.getCliente().setIdCliente((Long) modelo.getValueAt(table.getSelectedRow(), 6));
	}

	public boolean iscamposPreenchidos() {

		if (isClienteValido() && isTipoValido() && isModeloValido() && isMarcaValido() && isAnoValido()) {
			return true;
		}
		return false;
	}

	public boolean isTipoValido() {
		try {
			if (!textTipo.getSelectedItem().equals("")) {
				return true;
			} else {
				throw new OficinaException(" CAMPO DO TIPO DO CARRO VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO TIPO DO CARRO VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isModeloValido() {
		try {
			if (!textModelo.getText().equals("")) {
				return true;
			} else {
				throw new OficinaException(" CAMPO DO MODELO DO CARRO VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO MODELO DO CARRO VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isAnoValido() {
		try {
			if (!textAno.getText().equals("")) {
				return true;
			} else {
				throw new OficinaException(" CAMPO DO ANO DO CARRO VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO ANO DO CARRO VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isMarcaValido() {
		try {
			if (!marcaCarros.getSelectedItem().equals("")) {
				return true;
			} else {
				throw new OficinaException("CAMPO DO MARCA DO CARRO VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO MARCA DO CARRO VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isClienteValido() {
		try {
			if (!clientes.getSelectedItem().equals("")) {
				return true;
			} else {
				throw new OficinaException(" CAMPO DO CLIENTE DO CARRO VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO CLIENTE DO CARRO VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

}
