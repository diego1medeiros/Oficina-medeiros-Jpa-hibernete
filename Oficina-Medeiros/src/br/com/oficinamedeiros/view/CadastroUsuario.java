package br.com.oficinamedeiros.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroUsuario {

	JFrame frmOficinaMedeiros;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario telaUsuario = new CadastroUsuario();
					telaUsuario.frmOficinaMedeiros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOficinaMedeiros = new JFrame();
		frmOficinaMedeiros.setTitle("Oficina Medeiros");
		frmOficinaMedeiros.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\diego\\Downloads\\worm-gear-icon.png"));
		frmOficinaMedeiros.getContentPane().setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.setBounds(100, 100, 483, 524);
		frmOficinaMedeiros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOficinaMedeiros.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE USUARIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(101, 30, 258, 22);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		lblNewLabel_1.setBounds(329, 41, 136, 128);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(66, 78, 83, 32);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(66, 108, 265, 20);
		frmOficinaMedeiros.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Senha");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(66, 226, 73, 22);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Login");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setBounds(66, 169, 73, 31);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 200, 265, 20);
		frmOficinaMedeiros.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(66, 251, 265, 20);
		frmOficinaMedeiros.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_5.setBounds(66, 128, 46, 30);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(67, 153, 265, 20);
		frmOficinaMedeiros.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogaNoSistema telaLoga = new LogaNoSistema();
				telaLoga.frmOficinaMedeiros.setVisible(true);
				CadastroUsuario telaUsuario = new CadastroUsuario();
				telaUsuario.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Actions-document-save-icon.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(155, 375, 108, 41);
		frmOficinaMedeiros.getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 78, 465, 8);
		frmOficinaMedeiros.getContentPane().add(separator);
		
		JLabel lblNewLabel_6 = new JLabel("Confirma Senha");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_6.setBounds(66, 282, 164, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_6);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(67, 302, 264, 20);
		frmOficinaMedeiros.getContentPane().add(passwordField_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 336, 478, 8);
		frmOficinaMedeiros.getContentPane().add(separator_1);
	}
}
