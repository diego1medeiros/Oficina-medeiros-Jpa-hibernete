package br.com.oficinamedeiros.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JTable;

import br.com.oficinamedeiros.controller.ServicoController;
import br.com.oficinamedeiros.util.RelatorioUtil;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class TelaServicosPorFuncionarios {

	JFrame frmOficinaMedeiros;
	private JTable table = new JTable();
	private ServicoController servicoController = new ServicoController();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaServicosPorFuncionarios window = new TelaServicosPorFuncionarios();
					window.frmOficinaMedeiros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaServicosPorFuncionarios() {
		initialize();
		servicoController.carregarTabelaQtdDeServicosPorFuncionario();

	}

	private void initialize() {
		frmOficinaMedeiros = new JFrame();
		frmOficinaMedeiros
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\diego\\Downloads\\worm-gear-icon.png"));
		frmOficinaMedeiros.setTitle("OFICINA MEDEIROS");
		frmOficinaMedeiros.getContentPane().setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.setBounds(100, 100, 1378, 736);
		frmOficinaMedeiros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOficinaMedeiros.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(369, 135, 628, 254);
		frmOficinaMedeiros.getContentPane().add(scrollPane);

		table = new JTable();
		table = servicoController.carregarTabelaRelario();
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("RELATORIO DE SERVI\u00C7OS POR FUNCIONARIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setBounds(443, 51, 480, 50);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("IMPRIMIR");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Printer-icon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					RelatorioUtil.criarRelatorio(
							"C:/dev/worspace/Oficina-Medeiros/relatorio/teste.jrxml",
							servicoController.buscaQdtDosServicosPorFuncionarios());
				} catch (JRException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		btnNewButton.setBounds(1159, 230, 135, 41);
		frmOficinaMedeiros.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("DOWNLOAD");
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String pathJasper = "C:\\dev\\worspace\\Oficina-Medeiros\\relatorio\\teste.jasper";
					String saida = "C:\\dev\\worspace\\Oficina-Medeiros\\relatorio\\teste.pdf";
				
				    RelatorioUtil.gerarArquivoPdf(pathJasper, servicoController.buscaQdtDosServicosPorFuncionarios(),
					saida);
					JOptionPane.showMessageDialog(null, "ARQUIVO PDF COM SUCESSO!!!");

				} catch (JRException e1) {

					e1.printStackTrace();
				} catch (FileNotFoundException e1) {

					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_1.setBounds(1159, 299, 127, 32);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("MENU");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Very-Basic-Menu-icon.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaServicosPorFuncionarios window = new TelaServicosPorFuncionarios();
				window.frmOficinaMedeiros.setVisible(false);
				MenuRelatorios window1 = new MenuRelatorios();
				window1.frmOficinaMedeiros.setVisible(true);
				frmOficinaMedeiros.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setBounds(1159, 156, 127, 41);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		lblNewLabel_1.setBounds(1070, 342, 187, 134);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\r\n");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		lblNewLabel_2.setBounds(64, 74, 187, 182);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_2);
		frmOficinaMedeiros.setExtendedState(frmOficinaMedeiros.MAXIMIZED_BOTH);
	}
}
