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
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import br.com.oficinamedeiros.controller.FuncionarioController;
import br.com.oficinamedeiros.controller.ServicoController;
import br.com.oficinamedeiros.entity1.Funcionario;
import br.com.oficinamedeiros.entity1.Servico;
import br.com.oficinamedeiros.exception.OficinaException;
import br.com.oficinamedeiros.util.Utils;
import br.com.ofinamedeiros.enumeradores.StatusServicos;

public class MostrarServicosFuncionario {
	private int index;
	private ServicoController servicoController = new ServicoController();
	private Servico servico = new Servico();
	private JComboBox<Funcionario> funcionarios;
	private DefaultTableModel modelo;
	JFrame frmOficinaMedeiros;
	private JTextField valor;
	private JTable table = new JTable();
	private int pagamento;
	private JEditorPane descricao;
	private JDateChooser dataServico;
	private JDateChooser dataEntrega;
	private JEditorPane observacao;
	private Date dataServicoFormatada;
	private Date dataEntregaFormatada;
	private JTextField textId;
	private JTextField textCliente;
	private JTextField textModelo;
	private JTextField textStatus;
	private JButton btnAvancar;
	private JButton buttonVoltar;
	private JTextField textPago;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarServicosFuncionario telaServico = new MostrarServicosFuncionario();
					telaServico.frmOficinaMedeiros.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MostrarServicosFuncionario() {
		initialize();
		funcionarios.setSelectedItem("");
		textStatus = new JTextField();
		textStatus.setEnabled(false);
		textStatus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textStatus.setBounds(1014, 144, 281, 20);
		frmOficinaMedeiros.getContentPane().add(textStatus);
		textStatus.setColumns(10);
		
		textPago = new JTextField();
		textPago.setEnabled(false);
		textPago.setBounds(846, 144, 86, 20);
		frmOficinaMedeiros.getContentPane().add(textPago);
		textPago.setColumns(10);

	}

	private void initialize() {
		frmOficinaMedeiros = new JFrame();
		frmOficinaMedeiros.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\diego\\Downloads\\worm-gear-icon.png"));
		frmOficinaMedeiros.getContentPane().setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.setTitle("OFICINA MEDEIROS");
		frmOficinaMedeiros.setBounds(100, 100, 1378, 736);
		frmOficinaMedeiros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOficinaMedeiros.setLocationRelativeTo(null);
		frmOficinaMedeiros.getContentPane().setLayout(null);
		frmOficinaMedeiros.setExtendedState(frmOficinaMedeiros.MAXIMIZED_BOTH);

		JLabel lblNewLabel = new JLabel("SERVI\u00C7OS");
		lblNewLabel.setBounds(540, 27, 281, 36);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 74, 1362, 13);
		separator.setToolTipText("224");
		separator.setBackground(SystemColor.desktop);
		frmOficinaMedeiros.getContentPane().add(separator);

		JLabel lblNewLabel_1 = new JLabel("\tFUNCIONARIO");
		lblNewLabel_1.setBounds(27, 98, 96, 21);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_1);

		FuncionarioController funcionarioController = new FuncionarioController();
		List<Funcionario> listaFuncionarios = funcionarioController.buscarDadosDoFuncionarios();
		funcionarios = new JComboBox(listaFuncionarios.toArray());
		funcionarios.setBounds(157, 98, 281, 22);
		funcionarios.setEditable(true);
		funcionarios.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frmOficinaMedeiros.getContentPane().add(funcionarios);

		JLabel lblNewLabel_3 = new JLabel("CLIENTE");
		lblNewLabel_3.setBounds(461, 102, 69, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_9 = new JLabel("MODELO");
		lblNewLabel_9.setBounds(856, 102, 69, 14);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_9);

		JLabel lblNewLabel_4 = new JLabel("DATA DO SERVICO");
		lblNewLabel_4.setBounds(27, 146, 122, 14);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("DATA DA ENTREGA");
		lblNewLabel_4_1.setBounds(286, 146, 122, 14);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_4_1);

		JLabel lblNewLabel_5 = new JLabel("VALOR R$");
		lblNewLabel_5.setBounds(561, 146, 82, 14);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_5);

		valor = new JTextField();
		valor.setBounds(633, 144, 104, 20);
		valor.setEnabled(false);
		valor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frmOficinaMedeiros.getContentPane().add(valor);
		valor.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("PAGO");
		lblNewLabel_6.setBounds(792, 146, 69, 14);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("DESCRI\u00C7\u00C3O\r\n");
		lblNewLabel_7.setBounds(27, 200, 96, 30);
		lblNewLabel_7.setLabelFor(frmOficinaMedeiros);
		lblNewLabel_7.setToolTipText("");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("OBSERVA\u00C7\u00D5ES");
		lblNewLabel_8.setBounds(483, 227, 99, 14);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_8);

		descricao = new JEditorPane();
		descricao.setBounds(158, 183, 296, 102);
		descricao.setEnabled(false);
		descricao.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frmOficinaMedeiros.getContentPane().add(descricao);

		observacao = new JEditorPane();
		observacao.setBounds(582, 183, 279, 102);
		observacao.setEnabled(false);
		observacao.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frmOficinaMedeiros.getContentPane().add(observacao);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 301, 1362, 13);
		separator_1.setBackground(SystemColor.desktop);
		frmOficinaMedeiros.getContentPane().add(separator_1);

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setBounds(857, 173, 157, 128);
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_10);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 364, 1362, 22);
		separator_2.setBackground(SystemColor.desktop);
		frmOficinaMedeiros.getContentPane().add(separator_2);

		dataServico = new JDateChooser();
		dataServico.setBounds(157, 146, 129, 20);
		dataServico.setEnabled(false);
		dataServico.getCalendarButton().setEnabled(false);
		dataServico.setDateFormatString("dd/MM/yyyy");
		frmOficinaMedeiros.getContentPane().add(dataServico);

		dataEntrega = new JDateChooser();
		dataEntrega.setBounds(410, 146, 141, 20);
		dataEntrega.setEnabled(false);
		dataEntrega.getCalendarButton().setEnabled(false);
		dataEntrega.setDateFormatString("dd/MM/yyyy");
		frmOficinaMedeiros.getContentPane().add(dataEntrega);

		JLabel lblNewLabel_11 = new JLabel("STATUS");
		lblNewLabel_11.setBounds(943, 147, 61, 14);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_11);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 364, 1362, 333);
		frmOficinaMedeiros.getContentPane().add(scrollPane);
		table = servicoController.criarTabela();
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				selecionarItem();
			}
		});

		JButton btnNewButton = new JButton("PESQUISAR");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarServicosBancoDados();

			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\pesquisar-icon.png"));
		btnNewButton.setBounds(378, 315, 122, 38);
		frmOficinaMedeiros.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("DO SERVI\u00C7O");
		lblNewLabel_2.setBounds(27, 227, 82, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_2);

		JButton btnNewButton_2 = new JButton("MENU");
		btnNewButton_2.setBounds(878, 312, 104, 41);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MostrarServicosFuncionario telaServico = new MostrarServicosFuncionario();
				telaServico.frmOficinaMedeiros.setVisible(false);
				MenuPrincipal window = new MenuPrincipal();
				window.frmOficinaMedeiros.setVisible(true);
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

		buttonVoltar = new JButton("");
		buttonVoltar.setEnabled(false);
		buttonVoltar.setBackground(SystemColor.activeCaption);
		buttonVoltar.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Actions-go-previous-icon.png"));
		buttonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<String> lista = Arrays.asList(getDescricaoComboBox());
				index--;
				if(index>=0) {
				textStatus.setText(String.valueOf(lista.get(index)));
				modelo.setValueAt(textStatus.getText(), table.getSelectedRow(), 6);

				servicoController.atualizarStatusServico(servico = new Servico(Long.parseLong(textId.getText()),
						textStatus.getText(), observacao.getText()));
				observacao.setEnabled(false);
				textStatus.setEnabled(false);
				buttonVoltar.setEnabled(false);
				btnAvancar.setEnabled(false);

				}else {
					observacao.setEnabled(false);
					textStatus.setEnabled(false);
					buttonVoltar.setEnabled(false);
					btnAvancar.setEnabled(false);
					JOptionPane.showMessageDialog(null, "VOCÊ ESTAR NO PRIMEIRO STATUS DO SERVIÇO!!!");
				}

			}
		});
		buttonVoltar.setBounds(1014, 167, 65, 41);
		frmOficinaMedeiros.getContentPane().add(buttonVoltar);

		btnAvancar = new JButton("");
		btnAvancar.setEnabled(false);
		btnAvancar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		btnAvancar.setToolTipText("");
		btnAvancar.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Actions-go-next-icon.png"));
		btnAvancar.setBackground(SystemColor.activeCaption);
		btnAvancar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				List<String> lista = Arrays.asList(getDescricaoComboBox());
				index++;
				if(index<=6) {
				textStatus.setText(String.valueOf(lista.get(index)));
				modelo.setValueAt(textStatus.getText(), table.getSelectedRow(), 6);

				servicoController.atualizarStatusServico(servico = new Servico(Long.parseLong(textId.getText()),
						textStatus.getText(), observacao.getText()));
				observacao.setEnabled(false);
				textStatus.setEnabled(false);
				btnAvancar.setEnabled(false);
				buttonVoltar.setEnabled(false);

				}else {
					observacao.setEnabled(false);
					textStatus.setEnabled(false);
					buttonVoltar.setEnabled(false);
					btnAvancar.setEnabled(false);

					JOptionPane.showMessageDialog(null, "VOCÊ ESTAR NO PRIMEIRO STATUS DO SERVIÇO!!!");
	
				}

			}
		});
		btnAvancar.setBounds(1230, 167, 65, 41);
		frmOficinaMedeiros.getContentPane().add(btnAvancar);

		textCliente = new JTextField();
		textCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textCliente.setEnabled(false);
		textCliente.setBounds(533, 99, 313, 20);
		frmOficinaMedeiros.getContentPane().add(textCliente);
		textCliente.setColumns(10);

		textModelo = new JTextField();
		textModelo.setEnabled(false);
		textModelo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textModelo.setBounds(915, 99, 250, 20);
		frmOficinaMedeiros.getContentPane().add(textModelo);
		textModelo.setColumns(10);
	}

	public void selecionarItem() {

		try {
			modelo = (DefaultTableModel) table.getModel();
			funcionarios.setSelectedItem(modelo.getValueAt(table.getSelectedRow(), 0).toString());
			textCliente.setText(modelo.getValueAt(table.getSelectedRow(), 1).toString());
			textModelo.setText(modelo.getValueAt(table.getSelectedRow(), 2).toString());
			dataServico.setDate(new SimpleDateFormat("dd-MM-yyyy").parse(modelo.getValueAt(table.getSelectedRow(), 3).toString()));
			dataEntrega.setDate(new SimpleDateFormat("dd-MM-yyyy").parse(modelo.getValueAt(table.getSelectedRow(), 4).toString()));
			valor.setText(modelo.getValueAt(table.getSelectedRow(), 5).toString());
			textStatus.setText(modelo.getValueAt(table.getSelectedRow(), 6).toString());
			textPago.setText(Utils.formatoPagamento(modelo.getValueAt(table.getSelectedRow(), 7)));
			descricao.setText(modelo.getValueAt(table.getSelectedRow(), 8).toString());
			observacao.setText(modelo.getValueAt(table.getSelectedRow(), 9).toString());
			textId.setText(modelo.getValueAt(table.getSelectedRow(), 10).toString());
			servico.setIdServico(Long.parseLong(textId.getText()));
			servico.getCliente().setIdCliente((Long) modelo.getValueAt(table.getSelectedRow(), 11));
			servico.getVeiculo().setIdVeiculo((Long) modelo.getValueAt(table.getSelectedRow(), 12));
			servico.getFuncionario().setIdFuncionario((Long) modelo.getValueAt(table.getSelectedRow(), 13));
			textStatus.setEnabled(true);
			observacao.setEnabled(true);
			btnAvancar.setEnabled(true);
			buttonVoltar.setEnabled(true);
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}

	public Date getDataServicoFormatada() {
		return dataServicoFormatada;
	}

	public Date setDataServicoFormatada(Date dataServicoFormatada) {
		this.dataServicoFormatada = dataServicoFormatada;
		return dataServicoFormatada;
	}

	public Date getDataEntregaFormatada() {
		return dataEntregaFormatada;
	}

	public Date setDataEntregaFormatada(Date dataEntregaFormatada) {
		this.dataEntregaFormatada = dataEntregaFormatada;
		return dataEntregaFormatada;
	}
	
	public static String[] getDescricaoComboBox() {
		String[] listaRetorno = new String[6];
		int i = 0;
		for (StatusServicos s : StatusServicos.values()) {
			listaRetorno[i] = s.getDescricao();
			i++;
		}
		return listaRetorno;
	}

	public boolean pesquisarServicosBancoDados() {

		try {
			if (!funcionarios.getSelectedItem().equals("")) {
				servicoController.carregarPesquisaFuncionarioServicoTabela( funcionarios.getSelectedItem().toString());
				return true;
			} else {
				throw new OficinaException("NENHUM FUNCIONARIO SELECIONADO!!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, "NENHUM FUNCIONARIO SELECIONADO!!!");
		}
		return false;
	}

	public int getPagamento() {
		return pagamento;
	}

	public void setPagamento(int pagamento) {
		this.pagamento = pagamento;
	}
	

}
