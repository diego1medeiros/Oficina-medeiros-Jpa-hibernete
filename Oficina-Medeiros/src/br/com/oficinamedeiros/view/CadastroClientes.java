package br.com.oficinamedeiros.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import br.com.oficinamedeiros.controller.ClienteController;
import br.com.oficinamedeiros.entity1.Cliente;
import br.com.oficinamedeiros.exception.OficinaException;
import br.com.oficinamedeiros.util.RelatorioUtil;
import br.com.oficinamedeiros.util.Utils;
import net.sf.jasperreports.engine.JRException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class CadastroClientes {
	private ClienteController clienteController = new ClienteController();
	private Cliente cliente = new Cliente();
	private DefaultTableModel modelo;
	JFrame frmOficinaMedeiros;
	private JTextField textNome;
	private JTextField textEndereco;
	private JTextField textEmail;
	private JTable table;
	private int acaoBotao;
	private JFormattedTextField textCpf;
	private JFormattedTextField textTelefone;
	private JButton btnSave;
	private JButton btnEditar;
	private JButton btnDelete;
	private JTextField textId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroClientes telaCliente = new CadastroClientes();
					telaCliente.frmOficinaMedeiros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastroClientes() {
		initialize();
		clienteController.carregarTabela();
	}

	
	private void initialize() {
		frmOficinaMedeiros = new JFrame();
		frmOficinaMedeiros.getContentPane().setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.setLocationRelativeTo(null);
		frmOficinaMedeiros.getContentPane().setLayout(null);
		frmOficinaMedeiros.setExtendedState(frmOficinaMedeiros.MAXIMIZED_BOTH);

		JLabel lblNewLabel = new JLabel("CADASTRO DE CLIENTES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(453, 45, 384, 29);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.desktop);
		separator.setBounds(0, 97, 1372, 2);
		frmOficinaMedeiros.getContentPane().add(separator);

		JLabel lblNewLabel_1 = new JLabel("NOME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(37, 122, 58, 17);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_1);

		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textNome.setEnabled(false);
		textNome.setBounds(118, 122, 346, 20);
		frmOficinaMedeiros.getContentPane().add(textNome);
		textNome.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("CPF");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setBounds(514, 128, 65, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_4);

		try {
			textCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			textTelefone = new JFormattedTextField(new MaskFormatter("##-#########"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		textCpf.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textCpf.setEnabled(false);
		textCpf.setBounds(604, 123, 168, 20);
		frmOficinaMedeiros.getContentPane().add(textCpf);

		JLabel lblNewLabel_2_1 = new JLabel("TELEFONE");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2_1.setBounds(503, 186, 93, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_2_1);

		textTelefone.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textTelefone.setEnabled(false);
		textTelefone.setBounds(604, 185, 161, 20);
		frmOficinaMedeiros.getContentPane().add(textTelefone);

		JLabel lblNewLabel_6 = new JLabel("ENDERE\u00C7O");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_6.setBounds(25, 225, 93, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_6);

		textEndereco = new JTextField();
		textEndereco.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textEndereco.setEnabled(false);
		textEndereco.setColumns(10);
		textEndereco.setBounds(121, 224, 343, 20);
		frmOficinaMedeiros.getContentPane().add(textEndereco);

		JLabel lblNewLabel_5 = new JLabel("EMAIL");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_5.setBounds(37, 174, 65, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_5);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textEmail.setEnabled(false);
		textEmail.setColumns(10);
		textEmail.setBounds(119, 172, 345, 20);
		frmOficinaMedeiros.getContentPane().add(textEmail);
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		lblNewLabel_2.setBounds(1023, 107, 167, 137);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_2);

		table = clienteController.criarTabela();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 358, 1372, 339);
		frmOficinaMedeiros.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);

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
		btnSave.setBackground(SystemColor.activeCaption);
		btnSave.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Actions-document-save-icon.png"));
		btnSave.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnSave.setBounds(246, 288, 105, 41);
		frmOficinaMedeiros.getContentPane().add(btnSave);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.desktop);
		separator_1.setBounds(0, 255, 1372, 2);
		frmOficinaMedeiros.getContentPane().add(separator_1);

		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoBotao = 2;
				habilitarFuncoes();
			}
		});
		btnEditar.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Programming-Edit-Property-icon.png"));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnEditar.setBackground(SystemColor.activeCaption);
		btnEditar.setBounds(413, 288, 105, 41);
		frmOficinaMedeiros.getContentPane().add(btnEditar);

		JButton btnNew = new JButton("NOVO");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoBotao = 1;
				limparDados();
				habilitarFuncoes();
			}
		});
		btnNew.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Actions-document-new-icon.png"));
		btnNew.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnNew.setBackground(SystemColor.activeCaption);
		btnNew.setBounds(91, 288, 93, 41);
		frmOficinaMedeiros.getContentPane().add(btnNew);

		btnDelete = new JButton("EXCLUIR");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				limparDados();
				desabilitarFuncoes();
			}

		});
		btnDelete.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\delete-file-icon (1).png"));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnDelete.setBackground(SystemColor.activeCaption);
		btnDelete.setBounds(580, 288, 111, 41);
		frmOficinaMedeiros.getContentPane().add(btnDelete);

		JButton btnCancel = new JButton("CANCELAR");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparDados();
				desabilitarFuncoes();
			}
		});
		btnCancel.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Status-dialog-error-icon.png"));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnCancel.setBackground(SystemColor.activeCaption);
		btnCancel.setBounds(753, 288, 118, 41);
		frmOficinaMedeiros.getContentPane().add(btnCancel);

		JButton btnNext = new JButton("PROXIMO");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastroVeiculo telaVeiculo = new CadastroVeiculo();
				telaVeiculo.frmOficinaMedeiros.setVisible(true);
				CadastroClientes telaCliente = null;
				telaCliente = new CadastroClientes();
				telaCliente.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();

			}
		});
		btnNext.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Arrow-Next-icon.png"));
		btnNext.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnNext.setBackground(SystemColor.activeCaption);
		btnNext.setBounds(933, 288, 111, 41);
		frmOficinaMedeiros.getContentPane().add(btnNext);

		JButton btnNewButton_2 = new JButton("MENU");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuPrincipal menu = new MenuPrincipal();
				menu.frmOficinaMedeiros.setVisible(true);
				CadastroClientes window = null;
				window = new CadastroClientes();
				window.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Very-Basic-Menu-icon.png"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setBounds(1106, 288, 100, 41);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_2);

		textId = new JTextField();
		textId.setBounds(0, 0, 1, 0);
		frmOficinaMedeiros.getContentPane().add(textId);
		textId.setColumns(10);
		frmOficinaMedeiros
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\diego\\Downloads\\worm-gear-icon.png"));
		frmOficinaMedeiros.setTitle("Oficina Medeiros");
		frmOficinaMedeiros.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.setBounds(100, 100, 1382, 736);
		frmOficinaMedeiros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void save() {

		if (iscamposPreenchidos()) {
			if (acaoBotao == 1) {
				clienteController.cadastrarCliente(cliente = new Cliente(textNome.getText(), textCpf.getText(),
						textTelefone.getText(), textEmail.getText(), textEndereco.getText()));
				clienteController.carregarTabela();

				JOptionPane.showMessageDialog(null, "CLIENTE CADASTRADO !!!");
				limparDados();
				desabilitarFuncoes();

			} else if (acaoBotao == 2) {

				clienteController.editarCliente(cliente = new Cliente(textNome.getText(), textCpf.getText(),
						textTelefone.getText(), textEmail.getText(), textEndereco.getText(), cliente.getIdCliente()));
				limparDados();
				desabilitarFuncoes();
				clienteController.carregarTabela();
				JOptionPane.showMessageDialog(null, "CLIENTE ATUALIZADO!!!");
			}
		}
	}

	public void delete() {

		switch (JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE EXCLUIR CLIENTE ?", "", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE)) {
		case 0:
			clienteController.removerCliente(cliente);
			clienteController.carregarTabela();
			JOptionPane.showMessageDialog(null, "CLIENTE FUI EXCLUIDO !!!");
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "CLIENTE NÃO FUI EXCLUIDO !!!");
			break;
		}
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
		btnSave.setEnabled(false);
	}

	public void habilitarFuncoes() {

		btnSave.setEnabled(true);
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
		textId.setText(modelo.getValueAt(table.getSelectedRow(), 5).toString());
		cliente.setIdCliente(Long.parseLong(textId.getText()));
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
}
