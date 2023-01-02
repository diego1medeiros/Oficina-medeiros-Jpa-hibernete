package br.com.oficinamedeiros.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.oficinamedeiros.controller.ClienteController;
import br.com.oficinamedeiros.controller.VeiculoController;
import br.com.oficinamedeiros.entity1.Cliente;
import br.com.oficinamedeiros.entity1.Veiculo;
import br.com.oficinamedeiros.exception.OficinaException;
import br.com.oficinamedeiros.util.RelatorioUtil;
import net.sf.jasperreports.engine.JRException;

import java.awt.Color;

public class PesquisaVeiculos {

	private VeiculoController veiculoController = new VeiculoController();
	private Veiculo veiculo = new Veiculo();
	private Cliente cliente = new Cliente();
	private JComboBox marcaCarros = new JComboBox();
	JFrame frmOficinaMedeiros;
	private JTextField textModelo;
	private JTextField textAno;
	private JTable table = new JTable();
	private DefaultTableModel modelo;
	private JButton btnSave;
	private JTextField textld;
	private JTextField textCliente;
	private JComboBox textTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaVeiculos window = new PesquisaVeiculos();
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
	public PesquisaVeiculos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOficinaMedeiros = new JFrame();
		frmOficinaMedeiros.getContentPane().setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.getContentPane().setLayout(null);
		frmOficinaMedeiros.setExtendedState(frmOficinaMedeiros.MAXIMIZED_BOTH);

		JLabel lblNewLabel = new JLabel("PESQUISAR VEICULOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(513, 17, 338, 31);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.desktop);
		separator.setBounds(-15, 59, 1393, 14);
		frmOficinaMedeiros.getContentPane().add(separator);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		lblNewLabel_1.setBounds(1160, 59, 157, 156);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("TIPO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(415, 120, 112, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("MODELO");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(762, 120, 68, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_3);

		textModelo = new JTextField();
		textModelo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textModelo.setBounds(842, 119, 191, 20);
		frmOficinaMedeiros.getContentPane().add(textModelo);
		textModelo.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("MARCA ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setBounds(404, 159, 80, 20);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("ANO");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_5.setBounds(784, 162, 46, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_5);

		textAno = new JTextField();
		textAno.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textAno.setBounds(842, 161, 191, 20);
		frmOficinaMedeiros.getContentPane().add(textAno);
		textAno.setColumns(10);
		marcaCarros.setEditable(true);
		marcaCarros.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		marcaCarros.setModel(new DefaultComboBoxModel(
				new String[] { "", "Volkswagen", "Chevrolet", "Fiat", "Hyundai", "Toyota", "Jeep", "Caoa Chery",
						"Renault", "Nissan", "Honda", "Peugeot", "Ford", "Citroen", "Mitsubishi", "Audi", "BWM",
						"Volvo", "Mercedes-Benz", "JAC Motors", "Kia", "Land Rover", "Suzuki", "RAM", "Porsche" }));
		marcaCarros.setBounds(482, 160, 201, 22);
		frmOficinaMedeiros.getContentPane().add(marcaCarros);

		textTipo = new JComboBox();
		textTipo.setBackground(Color.WHITE);
		textTipo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textTipo.setModel(
				new DefaultComboBoxModel(new String[] { "", "Carro", "\u00D4nibus", "Caminh\u00E3o", "Moto" }));
		textTipo.setBounds(482, 118, 201, 22);
		frmOficinaMedeiros.getContentPane().add(textTipo);

		table = veiculoController.criarJTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 309, 1378, 388);
		frmOficinaMedeiros.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(SystemColor.desktop);
		separator_2.setBounds(0, 223, 1378, 9);
		frmOficinaMedeiros.getContentPane().add(separator_2);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				selecionarItem();
			}
		});

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
		btnSave.setBounds(258, 241, 105, 41);
		frmOficinaMedeiros.getContentPane().add(btnSave);

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habiltarFuncoes();
			}
		});
		btnEditar.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Programming-Edit-Property-icon.png"));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnEditar.setBackground(SystemColor.activeCaption);
		btnEditar.setBounds(436, 241, 105, 41);
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
		btnDelete.setBounds(614, 241, 112, 41);
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
		btnCancel.setBounds(799, 241, 119, 41);
		frmOficinaMedeiros.getContentPane().add(btnCancel);

		JLabel lblNewLabel_6 = new JLabel("CLIENTE");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_6.setBounds(465, 71, 114, 22);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_6);

		JButton btnNewButton = new JButton("MENU");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuPesquisa menu = new MenuPesquisa();
				menu.frmOficinaMedeiros.setVisible(true);
				PesquisaVeiculos window = new PesquisaVeiculos();
				window.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Very-Basic-Menu-icon.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnNewButton.setBounds(991, 241, 99, 41);
		frmOficinaMedeiros.getContentPane().add(btnNewButton);

		textld = new JTextField();
		textld.setBounds(110, 9, 0, 20);
		frmOficinaMedeiros.getContentPane().add(textld);
		textld.setColumns(10);

		JButton btnNewButton_1 = new JButton("PESQUISAR");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarVeiculosBancoDados();
				limparDados();
			}
		});
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\pesquisar-icon.png"));
		btnNewButton_1.setBounds(73, 243, 112, 39);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_1);

		textCliente = new JTextField();
		textCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textCliente.setBounds(549, 74, 350, 20);
		frmOficinaMedeiros.getContentPane().add(textCliente);
		textCliente.setColumns(10);

		frmOficinaMedeiros.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.setTitle("OFICINA MEDEIROS");
		frmOficinaMedeiros
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\diego\\Downloads\\worm-gear-icon.png"));
		frmOficinaMedeiros.setBounds(100, 100, 1380, 736);
		frmOficinaMedeiros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnNewButton3 = new JButton("IMPRIMIR");
		btnNewButton3.setBackground(SystemColor.activeCaption);
		btnNewButton3.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Printer-icon.png"));
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					RelatorioUtil.criarRelatorio(
							"C:/dev/worspace/Oficina-Medeiros/resources/relatorio/relatorioVeiculos.jrxml",
							veiculoController.buscarDadosDosVeiculos(veiculo));
				} catch (JRException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 7));
		btnNewButton3.setBounds(1163, 241, 127, 41);
		frmOficinaMedeiros.getContentPane().add(btnNewButton3);

	}

	public void save() {
		if (iscamposPreenchidos()) {
			editarTabela();
			veiculoController.editarVeiculo(veiculo = new Veiculo(veiculo.getIdVeiculo(),
					textTipo.getSelectedItem().toString(), textModelo.getText(),
					marcaCarros.getSelectedItem().toString(), textAno.getText(), cliente));
			JOptionPane.showMessageDialog(null, "VEICULO ATUALIZADO!!!");
		}
	}

	public void delete() {

		switch (JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE EXCLUIR VEICULO ?", "", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE)) {

		case 0:

			modelo.removeRow(table.getSelectedRow());
			veiculoController.removerVeiculo(veiculo);

			JOptionPane.showMessageDialog(null, "VEICULO FUI EXCLUIDO!!!");
			break;

		case 1:

			JOptionPane.showMessageDialog(null, "VEICULO NÃO FUI EXCLUIDO!!!");
			break;
		}
	}

	public void limparDados() {
		textCliente.setText("");
		textModelo.setText("");
		textTipo.setSelectedItem("");
		textAno.setText("");
		marcaCarros.setSelectedItem("");
	}

	public void desabilitaFuncoes() {

		textModelo.setEnabled(false);
		textTipo.setEnabled(false);
		textAno.setEnabled(false);
		btnSave.setEnabled(false);
		textCliente.setEnabled(false);
		marcaCarros.setEnabled(false);
	}

	public void habiltarFuncoes() {

		textModelo.setEnabled(true);
		textTipo.setEnabled(true);
		textAno.setEnabled(true);
		btnSave.setEnabled(true);
		textCliente.setEnabled(false);
		marcaCarros.setEnabled(true);
	}

	public void selecionarItem() {

		modelo = (DefaultTableModel) table.getModel();

		textCliente.setText(modelo.getValueAt(table.getSelectedRow(), 0).toString());
		textTipo.setSelectedItem(modelo.getValueAt(table.getSelectedRow(), 1).toString());
		marcaCarros.setSelectedItem(modelo.getValueAt(table.getSelectedRow(), 3).toString());
		textModelo.setText(modelo.getValueAt(table.getSelectedRow(), 2).toString());
		textAno.setText(modelo.getValueAt(table.getSelectedRow(), 4).toString());
		textld.setText(modelo.getValueAt(table.getSelectedRow(), 5).toString());
		veiculo.setIdVeiculo(Long.parseLong(textld.getText()));
		veiculo.getCliente().setIdCliente((Long) modelo.getValueAt(table.getSelectedRow(), 6));
	}

	public void editarTabela() {

		modelo = (DefaultTableModel) table.getModel();
		modelo.setValueAt(textCliente.getText(), table.getSelectedRow(), 0);
		modelo.setValueAt(textTipo.getSelectedItem(), table.getSelectedRow(), 1);
		modelo.setValueAt(textModelo.getText(), table.getSelectedRow(), 2);
		modelo.setValueAt(marcaCarros.getSelectedItem(), table.getSelectedRow(), 3);
		modelo.setValueAt(textAno.getText(), table.getSelectedRow(), 4);

		JButton btnNewButton = new JButton("IMPRIMIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RelatorioUtil relatorios = new RelatorioUtil();
				try {
					relatorios.criarRelatorio(
							"C:/dev/worspace/Oficina-Medeiros/resources/relatorio/Cherry_Landscape.jrxml",
							veiculoController.buscarDadosDosVeiculos(veiculo));
				} catch (JRException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBounds(1159, 230, 127, 41);
		frmOficinaMedeiros.getContentPane().add(btnNewButton);
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
			if (!textCliente.getText().equals("")) {
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

	private void pesquisarVeiculosBancoDados() {

		cliente.setNome(textCliente.getText());
		veiculoController.carregarPesquisaVeiculosTabela(
				veiculo = new Veiculo(veiculo.getIdVeiculo(), textTipo.getSelectedItem().toString(),
						textModelo.getText(), marcaCarros.getSelectedItem().toString(), textAno.getText(), cliente));

	}
}
