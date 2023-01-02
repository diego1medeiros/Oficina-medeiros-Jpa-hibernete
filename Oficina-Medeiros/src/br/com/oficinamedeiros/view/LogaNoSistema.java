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
import br.com.oficinamedeiros.controller.FuncionarioController;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class LogaNoSistema {

	JFrame frmOficinaMedeiros;
	private JTextField textLogin;
	private JPasswordField passwordFieldSenha;
	private FuncionarioController funcionarioController = new FuncionarioController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogaNoSistema telaLoga = new LogaNoSistema();
					telaLoga.frmOficinaMedeiros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogaNoSistema() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOficinaMedeiros = new JFrame();
		frmOficinaMedeiros.getContentPane().setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.setTitle("Oficina Medeiros");
		frmOficinaMedeiros
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\diego\\Downloads\\worm-gear-icon.png"));
		frmOficinaMedeiros.setBounds(100, 100, 1381, 736);
		frmOficinaMedeiros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOficinaMedeiros.getContentPane().setLayout(null);
		frmOficinaMedeiros.setExtendedState(frmOficinaMedeiros.MAXIMIZED_BOTH);

		JLabel lblNewLabel = new JLabel("Loga no Sistema");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(588, 22, 247, 33);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		lblNewLabel_1.setBounds(951, -2, 139, 128);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(421, 78, 518, 2);
		frmOficinaMedeiros.getContentPane().add(separator);

		JLabel lblNewLabel_3 = new JLabel("LOGIN");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_3.setBounds(651, 106, 87, 20);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_3);

		textLogin = new JTextField();
		textLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textLogin.setBounds(530, 137, 305, 20);
		frmOficinaMedeiros.getContentPane().add(textLogin);
		textLogin.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("SENHA");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_4.setBounds(651, 180, 87, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_4);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		passwordFieldSenha.setBounds(530, 205, 305, 20);
		frmOficinaMedeiros.getContentPane().add(passwordFieldSenha);

		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (funcionarioController.isLoginSenhaValida(textLogin.getText(), passwordFieldSenha.getText())) {

					textLogin.setText(null);
					passwordFieldSenha.setText(null);

					JOptionPane.showMessageDialog(null, "Login ou Senha Valido");

				

				} else {
					JOptionPane.showMessageDialog(null, "Login ou Senha invalido", "Login Erro",
							JOptionPane.ERROR_MESSAGE);

					textLogin.setText(null);
					passwordFieldSenha.setText(null);
				}
				
				MenuPrincipal telamenu = new MenuPrincipal();
				telamenu.frmOficinaMedeiros.setVisible(true);
				LogaNoSistema telaLoga = new LogaNoSistema();
				telaLoga.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();
			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Window-Enter-icon.png"));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(626, 301, 113, 33);
		frmOficinaMedeiros.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_5 = new JLabel("n\u00E2o tenho cadastro ?");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_5.setBounds(558, 364, 149, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_5);

		JButton btnNewButton_1 = new JButton("Cadastra se");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastroFuncionarioPeloLogin telaFuncionario = new CadastroFuncionarioPeloLogin();
				telaFuncionario.frmOficinaMedeiros.setVisible(true);
				LogaNoSistema telaLoga = new LogaNoSistema();
				telaLoga.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();
			}
		});
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_1.setBounds(717, 361, 103, 23);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(421, 288, 518, 2);
		frmOficinaMedeiros.getContentPane().add(separator_1);

		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\login-icon.png"));
		lblNewLabel_6.setBounds(271, 137, 139, 127);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_6);

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(421, 78, 54, 377);
		frmOficinaMedeiros.getContentPane().add(separator_2);

		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setBounds(934, 78, 54, 377);
		frmOficinaMedeiros.getContentPane().add(separator_2_1);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(423, 453, 514, 2);
		frmOficinaMedeiros.getContentPane().add(separator_3);
	}
}
