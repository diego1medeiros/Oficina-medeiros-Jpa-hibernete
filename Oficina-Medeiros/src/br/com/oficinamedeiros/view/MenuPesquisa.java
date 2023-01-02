package br.com.oficinamedeiros.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class MenuPesquisa {

	JFrame frmOficinaMedeiros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPesquisa window = new MenuPesquisa();
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
	public MenuPesquisa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOficinaMedeiros = new JFrame();
		frmOficinaMedeiros.setTitle("Oficina Medeiros");
		frmOficinaMedeiros
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\diego\\Downloads\\worm-gear-icon.png"));
		frmOficinaMedeiros.getContentPane().setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.getContentPane().setLayout(null);
		frmOficinaMedeiros.setExtendedState(frmOficinaMedeiros.MAXIMIZED_BOTH);
		JButton btnNewButton = new JButton("PESQUISA DE FUNCIONARIO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PesquisaFuncionarios window = new PesquisaFuncionarios();
				window.frmOficinaMedeiros.setVisible(true);
				MenuPesquisa menu = new MenuPesquisa();
				menu.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();

			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(491, 97, 387, 36);
		frmOficinaMedeiros.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("PESQUISA DE CLIENTES");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PesquisaClientes window = new PesquisaClientes();
				window.frmOficinaMedeiros.setVisible(true);
				MenuPesquisa telaMenu = new MenuPesquisa();
				telaMenu.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();
			}
		});
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBounds(491, 155, 387, 36);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("MENU PESQUISAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(588, 11, 333, 45);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		lblNewLabel_1.setBounds(234, 0, 158, 133);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(364, 67, 641, 2);
		frmOficinaMedeiros.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(361, 68, 29, 391);
		frmOficinaMedeiros.getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(361, 458, 641, 26);
		frmOficinaMedeiros.getContentPane().add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(994, 210, -30, -90);
		frmOficinaMedeiros.getContentPane().add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.BLACK);
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(1001, 67, 38, 392);
		frmOficinaMedeiros.getContentPane().add(separator_4);

		JButton btnNewButton_1_1 = new JButton("PEQUISA DE SERVI\u00C7O");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PesquisaServicos window = new PesquisaServicos();
				window.frmOficinaMedeiros.setVisible(true);
				MenuPesquisa menu = new MenuPesquisa();
				menu.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1_1.setBounds(491, 277, 387, 36);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_1_1);

		JButton btnCadastroDeVeiculos = new JButton("PESQUISA DE VEICULOS");
		btnCadastroDeVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PesquisaVeiculos window = new PesquisaVeiculos();
				window.frmOficinaMedeiros.setVisible(true);
				MenuPesquisa menu = new MenuPesquisa();
				menu.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();
			}
		});
		btnCadastroDeVeiculos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnCadastroDeVeiculos.setBackground(SystemColor.activeCaption);
		btnCadastroDeVeiculos.setBounds(491, 219, 387, 36);
		frmOficinaMedeiros.getContentPane().add(btnCadastroDeVeiculos);

		JButton btnNewButton_1_1_1 = new JButton("MENU PRINCIPAL");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPesquisa window = new MenuPesquisa();
				window.frmOficinaMedeiros.setVisible(false);
				MenuPrincipal menu = new MenuPrincipal();
				menu.frmOficinaMedeiros.setVisible(true);
				frmOficinaMedeiros.dispose();

			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1_1_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1_1_1.setBounds(491, 334, 387, 36);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_1_1_1);
		frmOficinaMedeiros.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.setBounds(100, 100, 1385, 736);
		frmOficinaMedeiros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
