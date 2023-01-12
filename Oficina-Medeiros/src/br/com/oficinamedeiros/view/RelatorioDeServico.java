package br.com.oficinamedeiros.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import br.com.oficinamedeiros.Vo.ServicoVo;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import br.com.oficinamedeiros.controller.ServicoController;
import br.com.oficinamedeiros.entity1.Servico;
import br.com.oficinamedeiros.util.RelatorioUtil;
import br.com.oficinamedeiros.util.Utils;
import net.sf.jasperreports.engine.JRException;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RelatorioDeServico {
	private static final String FORMATO_DIA_MES_ANO = "dd-MM-yyyy";
	private ServicoController servicoController = new ServicoController();
	private Servico servico = new Servico();
	JFrame frmOficinaMedeiros;
	private JTable table = new JTable();
	private JDateChooser dataServico;
	private JDateChooser dataEntrega;
	private JTextField textId;
	private int pagamento;
	private JComboBox comboBoxPago;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioDeServico window = new RelatorioDeServico();
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
	public RelatorioDeServico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOficinaMedeiros = new JFrame();
		frmOficinaMedeiros.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\diego\\Downloads\\worm-gear-icon.png"));
		frmOficinaMedeiros.getContentPane().setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.setTitle("OFICINA MEDEIROS");
		frmOficinaMedeiros.setBounds(100, 100, 1380, 736);
		frmOficinaMedeiros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOficinaMedeiros.setLocationRelativeTo(null);
		frmOficinaMedeiros.getContentPane().setLayout(null);
		frmOficinaMedeiros.setExtendedState(frmOficinaMedeiros.MAXIMIZED_BOTH);

		JLabel lblNewLabel = new JLabel("RELATORIO FINANCEIRO DOS SERVI\u00C7OS\r\n");
		lblNewLabel.setBounds(415, 46, 534, 36);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 93, 1368, 13);
		separator.setToolTipText("224");
		separator.setBackground(SystemColor.desktop);
		frmOficinaMedeiros.getContentPane().add(separator);

		JLabel lblNewLabel_4 = new JLabel("DATA DO INICIO");
		lblNewLabel_4.setBounds(430, 139, 122, 14);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("DATA DO FIM");
		lblNewLabel_4_1.setBounds(706, 139, 122, 14);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_4_1);

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setBounds(1150, 117, 157, 128);
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_10);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 417, 1187, -31);
		separator_2.setBackground(SystemColor.desktop);
		frmOficinaMedeiros.getContentPane().add(separator_2);

		dataServico = new JDateChooser();
		dataServico.setBounds(537, 133, 129, 20);
		dataServico.setDateFormatString("dd/MM/yyyy");
		frmOficinaMedeiros.getContentPane().add(dataServico);

		dataEntrega = new JDateChooser();
		dataEntrega.setBounds(792, 133, 141, 20);
		dataEntrega.setDateFormatString("dd/MM/yyyy");
		frmOficinaMedeiros.getContentPane().add(dataEntrega);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 273, 1368, 352);
		frmOficinaMedeiros.getContentPane().add(scrollPane);
		table = servicoController.criarTabelaServico();
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("PESQUISAR");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarValorTotalDosServicos();
				limparDados();
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\pesquisar-icon.png"));
		btnNewButton.setBounds(430, 182, 122, 38);
		frmOficinaMedeiros.getContentPane().add(btnNewButton);

		JButton btnNewButton_2 = new JButton("MENU");
		btnNewButton_2.setBounds(640, 181, 104, 41);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RelatorioDeServico window = new RelatorioDeServico();
				window.frmOficinaMedeiros.setVisible(false);
				MenuRelatorios window1 = new MenuRelatorios();
				window1.frmOficinaMedeiros.setVisible(true);
				frmOficinaMedeiros.dispose();

			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Very-Basic-Menu-icon.png"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_2);

		textId = new JTextField();
		textId.setBounds(139, 11, -6, 20);
		frmOficinaMedeiros.getContentPane().add(textId);
		textId.setColumns(10);

		JButton btnNewButton3 = new JButton("IMPRIMIR");
		btnNewButton3.setBackground(SystemColor.activeCaption);
		btnNewButton3.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Printer-icon.png"));
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					RelatorioUtil.criarRelatorio(
							"C:/Users/diego/git/Oficina-medeiros-Jpa-hibernete/Oficina-Medeiros/relatorio/valorTotalServicos.jrxml",
							servicoController.relatorioValorTotalDeServicos(servico));
				} catch (JRException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 7));
		btnNewButton3.setBounds(817, 182, 127, 41);
		frmOficinaMedeiros.getContentPane().add(btnNewButton3);

		JLabel lblNewLabel_1 = new JLabel("BUSCAR DADOS ENTRE O PERIODO IMFORMADO PELO USUARIO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(448, 93, 463, 30);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PAGO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2.setBounds(946, 140, 46, 14);
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_2);
		
		comboBoxPago = new JComboBox();
		comboBoxPago.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		comboBoxPago.setModel(new DefaultComboBoxModel(new String[] {"SIM", "N\u00C3O", "TODOS"}));
		comboBoxPago.setBounds(1002, 136, 76, 22);
		frmOficinaMedeiros.getContentPane().add(comboBoxPago);
	}

	public void desabilitarFuncoes() {
		dataServico.setEnabled(false);
		dataEntrega.setEnabled(false);
		
	}

	public void limparDados() {

		dataServico.setCalendar(null);
		dataEntrega.setCalendar(null);
		comboBoxPago.setSelectedItem("");
	}
	public void pesquisarValorTotalDosServicos() {

		servicoController.carregarPesquisaValorTotalServicoTabela1(
				servico = new Servico(dataServico.getDate(),
						dataEntrega.getDate(),Utils.formatarServicoPago(comboBoxPago.getSelectedIndex())));

	}
}
