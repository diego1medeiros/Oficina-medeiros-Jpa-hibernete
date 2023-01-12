package br.com.oficinamedeiros.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.text.ParseException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import br.com.oficinamedeiros.controller.FuncionarioController;
import br.com.oficinamedeiros.entity1.Funcionario;
import br.com.oficinamedeiros.exception.OficinaException;
import br.com.oficinamedeiros.util.Utils;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class CadastroFuncionarioPeloLogin {

	JFrame frmOficinaMedeiros;
	private FuncionarioController funcionarioController = new FuncionarioController();
	private Funcionario funcionario = new Funcionario();
	private JFormattedTextField textTelefone;
	private JFormattedTextField textCpf;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textEndereco;
	private JTextField textLogin;
	private JPasswordField textSenha;
	private JButton btnSalvar;
	private JTable table;
	private int acaoBotao;
	private DefaultTableModel modelo;
	private JTextField textId;
	private JComboBox funcao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionarioPeloLogin telaFuncionario = new CadastroFuncionarioPeloLogin();
					telaFuncionario.frmOficinaMedeiros.setVisible(true);
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
	public CadastroFuncionarioPeloLogin()  {
		initialize();
		funcionarioController.carregarTable();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ParseException
	 */
	private void initialize() {
		frmOficinaMedeiros = new JFrame();
		frmOficinaMedeiros.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\diego\\Downloads\\worm-gear-icon.png"));
		frmOficinaMedeiros.setTitle("OFICINA MEDEIROS");
		frmOficinaMedeiros.getContentPane().setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.setBounds(100, 100, 1381, 736);
		frmOficinaMedeiros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOficinaMedeiros.getContentPane().setLayout(null);
		frmOficinaMedeiros.setExtendedState(frmOficinaMedeiros.MAXIMIZED_BOTH);

		JLabel lblNewLabel = new JLabel("CADASTRO DE FUNCIONARIOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(493, 54, 455, 29);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		lblNewLabel_1.setBounds(1076, 151, 146, 141);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_1);

		JLabel lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNome.setBounds(558, 176, 104, 14);
		frmOficinaMedeiros.getContentPane().add(lblNome);

		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.desktop);
		separator.setBounds(0, 126, 1365, 14);
		frmOficinaMedeiros.getContentPane().add(separator);

		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textNome.setBounds(613, 174, 414, 20);
		frmOficinaMedeiros.getContentPane().add(textNome);
		textNome.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("FUNC\u00C3O");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(40, 176, 65, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("CPF");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setBounds(65, 218, 65, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_4);

		try {
			textCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			textTelefone = new JFormattedTextField(new MaskFormatter("##-#########"));
		} catch (ParseException e2) {

			e2.printStackTrace();
		}
		textCpf.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textCpf.setBounds(115, 216, 168, 20);
		frmOficinaMedeiros.getContentPane().add(textCpf);

		JLabel lblNewLabel_2 = new JLabel("TELEFONE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(293, 218, 93, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_2);

		textTelefone.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textTelefone.setBounds(370, 216, 164, 20);
		frmOficinaMedeiros.getContentPane().add(textTelefone);

		JLabel lblNewLabel_5 = new JLabel("EMAIL");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_5.setBounds(558, 218, 65, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_5);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textEmail.setBounds(613, 216, 414, 20);
		frmOficinaMedeiros.getContentPane().add(textEmail);
		textEmail.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("ENDERE\u00C7O");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_6.setBounds(26, 262, 93, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_6);

		textEndereco = new JTextField();
		textEndereco.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textEndereco.setBounds(115, 256, 211, 20);
		frmOficinaMedeiros.getContentPane().add(textEndereco);
		textEndereco.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("LOGIN");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_7.setBounds(340, 262, 46, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("SENHA");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_8.setBounds(557, 262, 46, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_8);

		textLogin = new JTextField();
		textLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textLogin.setBounds(398, 260, 136, 20);
		frmOficinaMedeiros.getContentPane().add(textLogin);
		textLogin.setColumns(10);

		textSenha = new JPasswordField();
		textSenha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textSenha.setBounds(613, 260, 152, 20);
		frmOficinaMedeiros.getContentPane().add(textSenha);

		table = funcionarioController.criarTabela();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				selecionarItem();
			}
		});
		btnSalvar = new JButton("CADASTRAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		btnSalvar.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Actions-document-save-icon.png"));
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnSalvar.setBackground(SystemColor.activeCaption);
		btnSalvar.setBounds(383, 357, 126, 41);
		frmOficinaMedeiros.getContentPane().add(btnSalvar);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.activeCaptionText);
		separator_1.setBounds(0, 326, 1365, 20);
		frmOficinaMedeiros.getContentPane().add(separator_1);

		JButton btnNewButton_1 = new JButton("CANCELAR");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Status-dialog-error-icon.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparDados();
			
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setBounds(870, 357, 112, 41);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_1);

		textId = new JTextField();
		textId.setBounds(106, 18, -3, 20);
		frmOficinaMedeiros.getContentPane().add(textId);
		textId.setColumns(10);
		
	    funcao = new JComboBox();
		funcao.setModel(new DefaultComboBoxModel(new String[] {"", "Mec\u00E2nico", "Gerente", "Atendente"}));
		funcao.setBounds(100, 173, 304, 22);
		frmOficinaMedeiros.getContentPane().add(funcao);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBackground(Color.BLACK);
		separator_1_1.setBounds(-194, 437, 1559, 20);
		frmOficinaMedeiros.getContentPane().add(separator_1_1);
	}

	public void cadastrar() {

		if(iscamposPreenchidos()) {
				funcionarioController.cadastraFuncionario(funcionario = new Funcionario(
						funcao.getSelectedItem().toString(), textNome.getText(), textCpf.getText(), textTelefone.getText(),
						textEmail.getText(), textEndereco.getText(), textLogin.getText(), textSenha.getText()));

				funcionarioController.carregarTable();

				JOptionPane.showMessageDialog(null, "FUNCIONARIO CADASTRADO !!!");
				limparDados();
			

				CadastroFuncionarioPeloLogin telaFuncionario = new CadastroFuncionarioPeloLogin();
				telaFuncionario.frmOficinaMedeiros.setVisible(false);
				LogaNoSistema telaLoga = new LogaNoSistema();
				telaLoga.frmOficinaMedeiros.setVisible(true);
				frmOficinaMedeiros.dispose();
		
		}

	}

	public void delete() {

		switch (JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE EXCLUIR ?", "", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE)) {

		case 0:
			//modelo.removeRow(table.getSelectedRow());
			funcionarioController.removerFuncionario(funcionario);
			funcionarioController.carregarTable();
			JOptionPane.showMessageDialog(null, "FUNCIONARIO FUI EXCLUIDO!!!");
			break;

		case 1:
			JOptionPane.showMessageDialog(null, "FUNCIONRIO NÃO FUI EXCLUIDO!!!");
			break;
		}
	}

	public void selecionarItem() {

		modelo = (DefaultTableModel) table.getModel();
		funcao.setSelectedItem(modelo.getValueAt(table.getSelectedRow(), 0).toString());
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

	

	public void limparDados() {

		textNome.setText("");
		textCpf.setText("");
		textTelefone.setText("");
		textEmail.setText("");
		funcao.setSelectedItem("");
		textLogin.setText("");
		textSenha.setText("");
		textEndereco.setText("");
	}

	public boolean iscamposPreenchidos() {

		if (isFuncaoValido() && isNomeValido() && isCpfValido() && isTelefoneValido() && isEmailValido()
				&& isEnderecoValido() && isLoginValido() && isSenhaValido()) {
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
			if (!funcao.getSelectedItem().equals("")) {
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
}
