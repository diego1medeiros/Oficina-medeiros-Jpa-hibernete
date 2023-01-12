package br.com.oficinamedeiros.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import br.com.oficinamedeiros.controller.FuncionarioController;
import br.com.oficinamedeiros.entity1.Funcionario;
import br.com.oficinamedeiros.exception.OficinaException;
import br.com.oficinamedeiros.util.RelatorioUtil;
import br.com.oficinamedeiros.util.Utils;
import net.sf.jasperreports.engine.JRException;

public class PesquisaFuncionarios {

	private FuncionarioController funcionarioController = new FuncionarioController();
	private Funcionario funcionario = new Funcionario();
	private JFormattedTextField textTelefone;
	private JFormattedTextField textCpf;
	private JTextField textNome;
	private JTextField textFuncao;
	private JTextField textEmail;
	private JTextField textEndereco;
	private JTextField textLogin;
	private JPasswordField textSenha;
	private JButton btnSalvar;
	private JButton btnEditar;
	private JTable table;
	private DefaultTableModel modelo;
	private JTextField textId;
	JFrame frmOficinaMedeiros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaFuncionarios window = new PesquisaFuncionarios();
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
	public PesquisaFuncionarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ParseException
	 */
	private void initialize()  {
		frmOficinaMedeiros = new JFrame();
		frmOficinaMedeiros.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\diego\\Downloads\\worm-gear-icon.png"));
		frmOficinaMedeiros.setTitle("OFICINA MEDEIROS");
		frmOficinaMedeiros.getContentPane().setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.setBounds(100, 100, 1378, 736);
		frmOficinaMedeiros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOficinaMedeiros.getContentPane().setLayout(null);
		frmOficinaMedeiros.setExtendedState(frmOficinaMedeiros.MAXIMIZED_BOTH);

		JLabel lblNewLabel = new JLabel("PESQUISAR FUNCIONARIOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setBounds(528, 17, 305, 29);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		lblNewLabel_1.setBounds(1118, 17, 146, 141);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_1);

		JLabel lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNome.setBounds(577, 105, 104, 14);
		frmOficinaMedeiros.getContentPane().add(lblNome);

		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.desktop);
		separator.setBounds(10, 57, 1364, 14);
		frmOficinaMedeiros.getContentPane().add(separator);

		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textNome.setEnabled(true);
		textNome.setBounds(647, 103, 348, 20);
		frmOficinaMedeiros.getContentPane().add(textNome);
		textNome.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("FUNC\u00C3O");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(10, 105, 65, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_3);

		textFuncao = new JTextField();
		textFuncao.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textFuncao.setBounds(123, 103, 322, 20);
		frmOficinaMedeiros.getContentPane().add(textFuncao);
		textFuncao.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("CPF");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setBounds(10, 147, 65, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_4);

		try {
			textCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			textTelefone = new JFormattedTextField(new MaskFormatter("##-#########"));

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		textCpf.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textCpf.setBounds(123, 145, 194, 20);
		frmOficinaMedeiros.getContentPane().add(textCpf);

		JLabel lblNewLabel_2 = new JLabel("TELEFONE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(327, 147, 93, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_2);

		textTelefone.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textTelefone.setBounds(397, 145, 146, 20);
		frmOficinaMedeiros.getContentPane().add(textTelefone);

		JLabel lblNewLabel_5 = new JLabel("EMAIL");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_5.setBounds(573, 147, 65, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_5);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textEmail.setBounds(647, 145, 348, 20);
		frmOficinaMedeiros.getContentPane().add(textEmail);
		textEmail.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("ENDERE\u00C7O");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_6.setBounds(10, 191, 93, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_6);

		textEndereco = new JTextField();
		textEndereco.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textEndereco.setBounds(123, 189, 211, 20);
		frmOficinaMedeiros.getContentPane().add(textEndereco);
		textEndereco.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("LOGIN");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_7.setBounds(341, 191, 46, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("SENHA");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_8.setBounds(577, 191, 46, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_8);

		textLogin = new JTextField();
		textLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textLogin.setBounds(397, 189, 146, 20);
		frmOficinaMedeiros.getContentPane().add(textLogin);
		textLogin.setColumns(10);

		textSenha = new JPasswordField();
		textSenha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textSenha.setEnabled(false);
		textSenha.setBounds(646, 189, 152, 20);
		frmOficinaMedeiros.getContentPane().add(textSenha);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(0, 287, 1362, 410);
		frmOficinaMedeiros.getContentPane().add(scrollPane);

		table = funcionarioController.criarTabela();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				selecionarItem();
			}
		});
		btnSalvar = new JButton("SALVAR");
		btnSalvar.setEnabled(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		btnSalvar.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Actions-document-save-icon.png"));
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnSalvar.setBackground(SystemColor.activeCaption);
		btnSalvar.setBounds(261, 232, 101, 44);
		frmOficinaMedeiros.getContentPane().add(btnSalvar);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.activeCaptionText);
		separator_1.setBounds(0, 216, 1362, 8);
		frmOficinaMedeiros.getContentPane().add(separator_1);

		btnEditar = new JButton("EDITAR");
		btnEditar.setBackground(SystemColor.activeCaption);
		btnEditar.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Programming-Edit-Property-icon.png"));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarFuncoes();
			}
		});

		btnEditar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnEditar.setBounds(438, 232, 101, 44);
		frmOficinaMedeiros.getContentPane().add(btnEditar);

		JButton btnNewButton = new JButton("EXCLUIR");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\delete-file-icon (1).png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				limparDados();
				bloquearFuncoes();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(615, 232, 107, 44);
		frmOficinaMedeiros.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("CANCELAR");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Status-dialog-error-icon.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparDados();
				bloquearFuncoes();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setBounds(798, 232, 113, 44);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("MENU");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Very-Basic-Menu-icon.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuPesquisa window = new MenuPesquisa();
				window.frmOficinaMedeiros.setVisible(true);
				PesquisaFuncionarios telaPesquisa = new PesquisaFuncionarios();
				telaPesquisa.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setBounds(987, 232, 95, 44);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_2);

		textId = new JTextField();
		textId.setBounds(106, 18, -3, 20);
		frmOficinaMedeiros.getContentPane().add(textId);
		textId.setColumns(10);

		JButton btnNewButton_3 = new JButton("PESQUISAR");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarFuncionariosBancoDados();
				limparDados();
			}
		});
		btnNewButton_3.setBackground(SystemColor.activeCaption);
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\pesquisar-icon.png"));
		btnNewButton_3.setBounds(76, 232, 109, 44);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_3);
		
		JButton btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.setBackground(SystemColor.activeCaption);
		btnImprimir.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Printer-icon.png"));
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					RelatorioUtil.criarRelatorio("C:/Users/diego/git/Oficina-medeiros-Jpa-hibernete/Oficina-Medeiros/relatorio/relatorioFuncionario.jrxml",
							funcionarioController.buscarDadosDosFuncionarios(funcionario));
				} catch (JRException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnImprimir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 7));
		btnImprimir.setBounds(1158, 235, 127, 41);
		frmOficinaMedeiros.getContentPane().add(btnImprimir);

	}

	public void save() {
		if (iscamposPreenchidos()) {
			editaTabela();
			funcionarioController.editarFuncionario(funcionario = new Funcionario(funcionario.getIdFuncionario(),
					textFuncao.getText(), textNome.getText(), textCpf.getText(), textTelefone.getText(),
					textEmail.getText(), textEndereco.getText(), textLogin.getText(), textSenha.getText()));

			JOptionPane.showMessageDialog(null, "FUNCIONRIO ATUALIZADO!!!");
		}
	}

	public void delete() {

		switch (JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE EXCLUIR ?", "", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE)) {

		case 0:
			modelo.removeRow(table.getSelectedRow());
			funcionarioController.removerFuncionario(funcionario);

			JOptionPane.showMessageDialog(null, "FUNCIONARIO FUI EXCLUIDO!!!");
			break;

		case 1:
			JOptionPane.showMessageDialog(null, "FUNCIONRIO N�O FUI EXCLUIDO!!!");
			break;
		}
	}
	
	public boolean iscamposPreenchidos() {

		if (isFuncaoValido() && isNomeValido() && isCpfValido() && isTelefoneValido() && isEmailValido()
				&& isEnderecoValido() && isLoginValido() && isSenhaValido()) {
			return true;
		}
		return false;
	}

	public boolean iscamposPreenchidosNaPesquisa() {

		if (isFuncaoValido() || isNomeValido() || isCpfValido() || isTelefoneValido() || isEmailValido()
				|| isEnderecoValido() || isLoginValido() || isSenhaValido()) {
		
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
				throw new OficinaException(" CAMPO DO ENDERE�O VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO ENDERE�O VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isSenhaValido() {
		try {
			if (!textSenha.getText().equals("")) {
				return true;
			} else {
				throw new OficinaException(" CAMPO DO SENHA VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO SENHA VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isLoginValido() {
		try {
			if (!textLogin.getText().equals("")) {
				return true;
			} else {
				throw new OficinaException(" CAMPO DO LOGIN VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO LOGIN VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isFuncaoValido() {
		try {
			if (!textFuncao.getText().equals("")) {
				return true;
			} else {
				throw new OficinaException(" CAMPO DO FUN��O VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO FUN��O VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public void editaTabela() {

		modelo = (DefaultTableModel) table.getModel();
		modelo.setValueAt(textFuncao.getText(), table.getSelectedRow(), 0);
		modelo.setValueAt(textNome.getText(), table.getSelectedRow(), 1);
		modelo.setValueAt(textCpf.getText(), table.getSelectedRow(), 2);
		modelo.setValueAt(textTelefone.getText(), table.getSelectedRow(), 3);
		modelo.setValueAt(textEmail.getText(), table.getSelectedRow(), 4);
		modelo.setValueAt(textEndereco.getText(), table.getSelectedRow(), 5);
		modelo.setValueAt(textLogin.getText(), table.getSelectedRow(), 6);
		modelo.setValueAt(textSenha.getText(), table.getSelectedRow(), 7);

	}

	public void selecionarItem() {

		modelo = (DefaultTableModel) table.getModel();
		textFuncao.setText(modelo.getValueAt(table.getSelectedRow(), 0).toString());
		textNome.setText(modelo.getValueAt(table.getSelectedRow(), 1).toString());
		textCpf.setText(modelo.getValueAt(table.getSelectedRow(), 2).toString());
		textTelefone.setText(modelo.getValueAt(table.getSelectedRow(), 3).toString());
		textEmail.setText(modelo.getValueAt(table.getSelectedRow(), 4).toString());
		textEndereco.setText(modelo.getValueAt(table.getSelectedRow(), 5).toString());
		textLogin.setText(modelo.getValueAt(table.getSelectedRow(), 6).toString());
		textSenha.setText(modelo.getValueAt(table.getSelectedRow(), 7).toString());
		textId.setText(modelo.getValueAt(table.getSelectedRow(), 8).toString());
		funcionario.setIdFuncionario(Long.parseLong(textId.getText()));
	}

	public void habilitarFuncoes() {

		btnSalvar.setEnabled(true);
		textNome.setEnabled(true);
		textCpf.setEnabled(true);
		textTelefone.setEnabled(true);
		textEmail.setEnabled(true);
		textFuncao.setEnabled(true);
		textLogin.setEnabled(true);
		textSenha.setEnabled(true);
		textEndereco.setEnabled(true);
		btnEditar.setEnabled(true);
		btnSalvar.setEnabled(true);
	}

	public void bloquearFuncoes() {

		btnSalvar.setEnabled(false);
		textNome.setEnabled(false);
		textCpf.setEnabled(false);
		textTelefone.setEnabled(false);
		textEmail.setEnabled(false);
		textFuncao.setEnabled(false);
		textLogin.setEnabled(false);
		textSenha.setEnabled(false);
		textEndereco.setEnabled(false);
	}

	public void limparDados() {

		textNome.setText("");
		textCpf.setText("");
		textTelefone.setText("");
		textEmail.setText("");
		textFuncao.setText("");
		textLogin.setText("");
		textSenha.setText("");
		textEndereco.setText("");
	}

	

	public void carregarLinhaTabela() {

		modelo = (DefaultTableModel) table.getModel();
		modelo.addRow(new String[] { funcionario.getFuncao(), funcionario.getNome(), funcionario.getCpf(),
				funcionario.getTelefone(), funcionario.getEmail(), funcionario.getEndereco(), funcionario.getLogin(),
				funcionario.getSenha(), funcionario.getIdFuncionario().toString() });
	}

	private void pesquisarFuncionariosBancoDados() {
		
			funcionarioController
					.carregarPesquisaFuncionarioTabela(funcionario = new Funcionario(funcionario.getIdFuncionario(),
							textFuncao.getText(), textNome.getText(), textCpf.getText(), textTelefone.getText(),
							textEmail.getText(), textEndereco.getText(), textLogin.getText(), textSenha.getText()));
		
	}
}
