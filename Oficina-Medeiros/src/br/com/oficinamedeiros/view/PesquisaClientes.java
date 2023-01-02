package br.com.oficinamedeiros.view;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import br.com.oficinamedeiros.controller.ClienteController;
import br.com.oficinamedeiros.entity1.Cliente;
import br.com.oficinamedeiros.exception.OficinaException;
import br.com.oficinamedeiros.util.RelatorioUtil;
import br.com.oficinamedeiros.util.Utils;
import net.sf.jasperreports.engine.JRException;

import java.awt.SystemColor;
import java.text.ParseException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;

public class PesquisaClientes {

	private ClienteController clienteController = new ClienteController();
	private Cliente cliente = new Cliente();
	private DefaultTableModel modelo;
	private JTable table = new JTable();
	private JFormattedTextField textTelefone;
	private JFormattedTextField textCpf;
	JFrame frmOficinaMedeiros;
	private JTextField textEmail;
	private JTextField textEndereco;
	private JTextField textNome;
	private JButton btnSalvar;
	private JTextField textld;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaClientes window = new PesquisaClientes();
					window.frmOficinaMedeiros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws ParseException
	 */
	public PesquisaClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ParseException
	 */
	private void initialize() {
		frmOficinaMedeiros = new JFrame();
		frmOficinaMedeiros.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		frmOficinaMedeiros.setFont(null);
		frmOficinaMedeiros.getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		frmOficinaMedeiros
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\diego\\Downloads\\worm-gear-icon.png"));
		frmOficinaMedeiros.setTitle("OFICINA MEDEIROS");
		frmOficinaMedeiros.getContentPane().setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.setBounds(100, 100, 1382, 736);
		frmOficinaMedeiros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOficinaMedeiros.setExtendedState(frmOficinaMedeiros.MAXIMIZED_BOTH);
		frmOficinaMedeiros.getContentPane().setLayout(null);
		frmOficinaMedeiros.setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("PESQUISAR  CLIENTE");
		lblNewLabel.setBounds(478, 26, 409, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("CLIENTE");
		lblNewLabel_1.setBounds(33, 90, 70, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("CPF");
		lblNewLabel_4.setBounds(652, 90, 65, 14);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_4);

		try {
			textCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			textTelefone = new JFormattedTextField(new MaskFormatter("##-#########"));

		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		textCpf.setBounds(747, 89, 168, 20);
		textCpf.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frmOficinaMedeiros.getContentPane().add(textCpf);

		textEmail = new JTextField();
		textEmail.setBounds(138, 129, 378, 20);
		textEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textEmail.setColumns(10);
		frmOficinaMedeiros.getContentPane().add(textEmail);

		JLabel lblNewLabel_5 = new JLabel("EMAIL");
		lblNewLabel_5.setBounds(33, 130, 65, 14);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_5);

		textTelefone.setBounds(747, 129, 168, 20);
		textTelefone.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frmOficinaMedeiros.getContentPane().add(textTelefone);

		JLabel lblNewLabel_2_1 = new JLabel("TELEFONE");
		lblNewLabel_2_1.setBounds(644, 130, 93, 14);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_2_1);

		JLabel lblNewLabel_6 = new JLabel("ENDERE\u00C7O");
		lblNewLabel_6.setBounds(33, 167, 93, 14);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_6);

		textEndereco = new JTextField();
		textEndereco.setBounds(140, 166, 376, 20);
		textEndereco.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textEndereco.setColumns(10);
		frmOficinaMedeiros.getContentPane().add(textEndereco);

		textNome = new JTextField();
		textNome.setBounds(137, 89, 379, 20);
		textNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frmOficinaMedeiros.getContentPane().add(textNome);
		textNome.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(1104, 73, 192, 128);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 282, 1376, 415);
		frmOficinaMedeiros.getContentPane().add(scrollPane);

		table = clienteController.criarTabela();
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				selecionarItem();
			}
		});

		JButton btnPesquisa = new JButton("PESQUISAR");
		btnPesquisa.setBounds(73, 230, 111, 41);
		btnPesquisa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PesquisarClientesBancoDados();
				limparDados();
			}
		});
		btnPesquisa.setBackground(SystemColor.activeCaption);
		btnPesquisa.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\search-icon (1).png"));
		frmOficinaMedeiros.getContentPane().add(btnPesquisa);

		btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(257, 230, 105, 41);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				save();
			}
		});
		btnSalvar.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Actions-document-save-icon.png"));
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnSalvar.setEnabled(false);
		btnSalvar.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.getContentPane().add(btnSalvar);

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(435, 230, 105, 41);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				habilitarFuncoes();
			}
		});
		btnEditar.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Programming-Edit-Property-icon.png"));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnEditar.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.getContentPane().add(btnEditar);

		JButton btnNewButton_1 = new JButton("EXCLUIR");
		btnNewButton_1.setBounds(613, 230, 111, 41);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();

			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\delete-file-icon (1).png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("CANCELAR");
		btnNewButton_1_1.setBounds(797, 230, 117, 41);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				limparDados();
				desabilitarFuncoes();
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Status-dialog-error-icon.png"));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnNewButton_1_1.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_1_1);

		JButton btnNewButton_2 = new JButton("MENU");
		btnNewButton_2.setBounds(987, 230, 99, 41);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuPesquisa window = new MenuPesquisa();
				window.frmOficinaMedeiros.setVisible(true);
				PesquisaClientes telaPesquisa = new PesquisaClientes();
				telaPesquisa.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Very-Basic-Menu-icon.png"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_2);

		textld = new JTextField();
		textld.setBackground(SystemColor.activeCaption);
		textld.setBounds(115, 16, -1, 20);
		frmOficinaMedeiros.getContentPane().add(textld);
		textld.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 203, 1366, 16);
		frmOficinaMedeiros.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(0, 59, 1654, 16);
		frmOficinaMedeiros.getContentPane().add(separator_1);

		JButton btnNewButton = new JButton("IMPRIMIR");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Printer-icon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					RelatorioUtil.criarRelatorio("C:/dev/worspace/Oficina-Medeiros/resources/relatorio/relatorioClientes.jrxml",
							clienteController.buscarDadosDosClientes(cliente));
				} catch (JRException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 7));
		btnNewButton.setBounds(1159, 230, 127, 41);
		frmOficinaMedeiros.getContentPane().add(btnNewButton);

	}

	public void limparDados() {

		textNome.setText("");
		textCpf.setText("");
		textTelefone.setText("");
		textEmail.setText("");
		textEndereco.setText("");
	}

	public void desabilitarFuncoes() {

		textNome.setEnabled(false);
		textCpf.setEnabled(false);
		textTelefone.setEnabled(false);
		textEmail.setEnabled(false);
		textEndereco.setEnabled(false);
		btnSalvar.setEnabled(false);
	}

	public void habilitarFuncoes() {

		btnSalvar.setEnabled(true);
		textNome.setEnabled(true);
		textCpf.setEnabled(true);
		textTelefone.setEnabled(true);
		textEmail.setEnabled(true);
		textEndereco.setEnabled(true);

	}

	public void selecionarItem() {

		modelo = (DefaultTableModel) table.getModel();
		textNome.setText(modelo.getValueAt(table.getSelectedRow(), 0).toString());
		textCpf.setText(modelo.getValueAt(table.getSelectedRow(), 1).toString());
		textTelefone.setText(modelo.getValueAt(table.getSelectedRow(), 2).toString());
		textEmail.setText(modelo.getValueAt(table.getSelectedRow(), 3).toString());
		textEndereco.setText(modelo.getValueAt(table.getSelectedRow(), 4).toString());
		textld.setText(modelo.getValueAt(table.getSelectedRow(), 5).toString());
		cliente.setIdCliente(Long.parseLong(textld.getText()));
	}

	public void editarTabela() {

		modelo = (DefaultTableModel) table.getModel();
		modelo.setValueAt(textNome.getText(), table.getSelectedRow(), 0);
		modelo.setValueAt(textCpf.getText(), table.getSelectedRow(), 1);
		modelo.setValueAt(textTelefone.getText(), table.getSelectedRow(), 2);
		modelo.setValueAt(textEmail.getText(), table.getSelectedRow(), 3);
		modelo.setValueAt(textEndereco.getText(), table.getSelectedRow(), 4);
	}

	public void save() {
		if (iscamposPreenchidos()) {
			clienteController.editarCliente(cliente = new Cliente(textNome.getText(), textCpf.getText(),
					textTelefone.getText(), textEmail.getText(), textEndereco.getText(), cliente.getIdCliente()));
			limparDados();
			desabilitarFuncoes();
			clienteController.carregarTabela();
			JOptionPane.showMessageDialog(null, "CLIENTE ATUALIZADO!!!");
		}
	}

	public void delete() {

		switch (JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE EXCLUIR CLIENTE ?", "", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE)) {
		case 0:

			modelo.removeRow(table.getSelectedRow());
			clienteController.removerCliente(cliente);

			JOptionPane.showMessageDialog(null, "CLIENTE FUI EXCLUIDO !!!");
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "CLIENTE NÃO FUI EXCLUIDO !!!");
			break;
		}
	}

	public boolean iscamposPreenchidos() {

		if (isNomeValido() && isCpfValido() && isTelefoneValido() && isEmailValido() && isEnderecoValido()) {
			return true;
		}
		return false;
	}

	public boolean isCpfValido() {
		try {
			if (Utils.isCpfValido(textCpf.getText())) {
				return true;
			}
			throw new OficinaException(" CAMPO DO CPF VAZIO !!!");
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO CPF VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isTelefoneValido() {
		try {
			if (Utils.isTelefoneValido(textTelefone.getText())) {
				return true;
			}
			throw new OficinaException("CAMPO DO TELEFONE VAZIO  !!!");
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, "CAMPO DO TELEFONE VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isEmailValido() {
		try {
			if (Utils.isEmailValido(textEmail.getText())) {
				return true;
			}
			throw new OficinaException(" CAMPO DO EMAIL VAZIO !!!");
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO EMAIL VAZIO  !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isNomeValido() {
		try {
			if (!textNome.getText().equals("")) {
				return true;
			} else {
				throw new OficinaException(" CAMPO DO NOME VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO NOME VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isEnderecoValido() {
		try {
			if (!textEndereco.getText().equals("")) {
				return true;
			} else {
				throw new OficinaException(" CAMPO DO ENDEREÇO VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO ENDEREÇO VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	private void PesquisarClientesBancoDados() {

		clienteController
				.carregarTabelaComBuscarDeDadosDosClientes(cliente = new Cliente(textNome.getText(), textCpf.getText(),
						textTelefone.getText(), textEmail.getText(), textEndereco.getText(), cliente.getIdCliente()));

	}
}
