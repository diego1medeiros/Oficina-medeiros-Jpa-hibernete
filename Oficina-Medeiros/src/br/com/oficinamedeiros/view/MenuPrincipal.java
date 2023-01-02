package br.com.oficinamedeiros.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.Choice;
import java.awt.ScrollPane;
import java.awt.Point;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.SwingConstants;

public class MenuPrincipal {

	JFrame frmOficinaMedeiros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
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
	public MenuPrincipal() {
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

		JButton btnNewButton = new JButton("CADASTRO DE FUNCIONARIOS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastroFuncionario telaFuncionario = new CadastroFuncionario();
				telaFuncionario.frmOficinaMedeiros.setVisible(true);
				MenuPrincipal telamenu = new MenuPrincipal();
				telamenu.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();

			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(488, 97, 387, 36);
		frmOficinaMedeiros.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("CADASTRO DE CLIENTES");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastroClientes window = new CadastroClientes();
				window.frmOficinaMedeiros.setVisible(true);
				MenuPrincipal menu = new MenuPrincipal();
				menu.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();
			}
		});
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBounds(488, 155, 387, 36);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("MENU PRINCIPAL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(542, 11, 333, 45);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		lblNewLabel_1.setBounds(1004, 11, 158, 133);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(361, 67, 641, 2);
		frmOficinaMedeiros.getContentPane().add(separator);

		JButton btnNewButton_1_1 = new JButton("CADASTRO DE SERVI\u00C7O");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastrarServico servico = new CadastrarServico();
				servico.frmOficinaMedeiros.setVisible(true);
				MenuPrincipal window = new MenuPrincipal();
				window.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1_1.setBounds(488, 277, 387, 36);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_1_1);

		JButton btnCadastroDeVeiculos = new JButton("CADASTRO DE VEICULOS");
		btnCadastroDeVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastroVeiculo window = new CadastroVeiculo();
				window.frmOficinaMedeiros.setVisible(true);
				MenuPrincipal menu = new MenuPrincipal();
				menu.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();
			}
		});
		btnCadastroDeVeiculos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnCadastroDeVeiculos.setBackground(SystemColor.activeCaption);
		btnCadastroDeVeiculos.setBounds(488, 219, 387, 36);
		frmOficinaMedeiros.getContentPane().add(btnCadastroDeVeiculos);

		JButton btnNewButton_1_1_1 = new JButton("MENU DE PESQUISA");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPesquisa window = new MenuPesquisa();
				window.frmOficinaMedeiros.setVisible(true);
				MenuPrincipal menu = new MenuPrincipal();
				menu.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();

			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1_1_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1_1_1.setBounds(488, 334, 387, 36);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_1_1_1);

		JButton btnServiosPorFuncionario = new JButton("SERVI\u00C7OS POR FUNCIONARIO");
		btnServiosPorFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MostrarServicosFuncionario telaServico = new MostrarServicosFuncionario();
				telaServico.frmOficinaMedeiros.setVisible(true);
				MenuPrincipal window = new MenuPrincipal();
				window.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();

			}
		});
		btnServiosPorFuncionario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnServiosPorFuncionario.setBackground(SystemColor.activeCaption);
		btnServiosPorFuncionario.setBounds(488, 392, 387, 36);
		frmOficinaMedeiros.getContentPane().add(btnServiosPorFuncionario);

		JLabel lblNewLabel_1_1 = new JLabel("\r\n");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		lblNewLabel_1_1.setBounds(210, 11, 158, 133);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_1_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(361, 68, 29, 497);
		frmOficinaMedeiros.getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(361, 564, 641, 16);
		frmOficinaMedeiros.getContentPane().add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(994, 210, -30, -90);
		frmOficinaMedeiros.getContentPane().add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.BLACK);
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(1001, 67, 38, 498);
		frmOficinaMedeiros.getContentPane().add(separator_4);
		
		JButton btnBonusParaClientes = new JButton("BONUS PARA CLIENTES");
		btnBonusParaClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BonusParaClientes window = new BonusParaClientes();
				window.frmOficinaMedeiros.setVisible(true);
				MenuPrincipal menu = new MenuPrincipal();
				menu.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();
			}
		});
		btnBonusParaClientes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnBonusParaClientes.setBackground(SystemColor.activeCaption);
		btnBonusParaClientes.setBounds(488, 444, 387, 36);
		frmOficinaMedeiros.getContentPane().add(btnBonusParaClientes);
		
		JButton btnMenuRelatorio = new JButton(" RELATORIOS");
		btnMenuRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuRelatorios window = new MenuRelatorios();
				window.frmOficinaMedeiros.setVisible(true);
				MenuPrincipal window1 = new MenuPrincipal();
				window1.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();
			}
		});
		btnMenuRelatorio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnMenuRelatorio.setBackground(SystemColor.activeCaption);
		btnMenuRelatorio.setBounds(488, 502, 387, 36);
		frmOficinaMedeiros.getContentPane().add(btnMenuRelatorio);
		frmOficinaMedeiros.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.setBounds(100, 100, 1380, 736);
		frmOficinaMedeiros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
