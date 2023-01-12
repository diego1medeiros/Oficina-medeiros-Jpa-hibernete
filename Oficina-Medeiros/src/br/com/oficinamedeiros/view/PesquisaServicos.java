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
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import br.com.oficinamedeiros.controller.ServicoController;
import br.com.oficinamedeiros.entity1.Cliente;
import br.com.oficinamedeiros.entity1.Funcionario;
import br.com.oficinamedeiros.entity1.Servico;
import br.com.oficinamedeiros.entity1.Veiculo;
import br.com.oficinamedeiros.exception.OficinaException;
import br.com.oficinamedeiros.util.RelatorioUtil;
import br.com.oficinamedeiros.util.Utils;
import net.sf.jasperreports.engine.JRException;

public class PesquisaServicos {
	private static final String FORMATO_DIA_MES_ANO = "dd-MM-yyyy";
	private ServicoController servicoController = new ServicoController();
	private Servico servico = new Servico();
	private Cliente cliente = new Cliente();
	private Veiculo veiculo = new Veiculo();
	private Funcionario funcionario = new Funcionario();
	private JButton btnSalvar;
	private DefaultTableModel modelo;
	JFrame frmOficinaMedeiros;
	private JTextField valor;
	private JTable table = new JTable();
	private int pagamento;
	private JEditorPane descricao;
	private JDateChooser dataServico;
	private JDateChooser dataEntrega;
	private JEditorPane observacao;
	private JTextField textId;
	private JTextField textFuncionario;
	private JTextField textCliente;
	private JTextField textModelos;
	private JTextField textStatus;
	private JTextField textPago;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaServicos window = new PesquisaServicos();
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
	public PesquisaServicos() {
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

		JLabel lblNewLabel = new JLabel("PESQUISAR SERVI\u00C7OS");
		lblNewLabel.setBounds(517, 46, 281, 36);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 93, 1368, 13);
		separator.setToolTipText("224");
		separator.setBackground(SystemColor.desktop);
		frmOficinaMedeiros.getContentPane().add(separator);

		JLabel lblNewLabel_1 = new JLabel("\tFUNCIONARIO");
		lblNewLabel_1.setBounds(43, 147, 96, 21);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("CLIENTE");
		lblNewLabel_3.setBounds(477, 151, 69, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_9 = new JLabel("MODELO");
		lblNewLabel_9.setBounds(872, 151, 69, 14);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_9);

		JLabel lblNewLabel_4 = new JLabel("DATA DO SERVICO");
		lblNewLabel_4.setBounds(43, 195, 122, 14);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("DATA DA ENTREGA");
		lblNewLabel_4_1.setBounds(302, 195, 122, 14);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_4_1);

		JLabel lblNewLabel_5 = new JLabel("VALOR R$");
		lblNewLabel_5.setBounds(577, 195, 82, 14);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_5);

		valor = new JTextField();
		valor.setBounds(649, 193, 104, 20);
		valor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frmOficinaMedeiros.getContentPane().add(valor);
		valor.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("PAGO");
		lblNewLabel_6.setBounds(812, 195, 89, 14);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("DESCRI\u00C7\u00C3O\r\n");
		lblNewLabel_7.setBounds(43, 249, 96, 30);
		lblNewLabel_7.setLabelFor(frmOficinaMedeiros);
		lblNewLabel_7.setToolTipText("");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("OBSERVA\u00C7\u00D5ES");
		lblNewLabel_8.setBounds(499, 276, 99, 14);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_8);

		descricao = new JEditorPane();
		descricao.setBounds(174, 232, 296, 102);
		descricao.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frmOficinaMedeiros.getContentPane().add(descricao);

		observacao = new JEditorPane();
		observacao.setBounds(598, 232, 279, 102);
		observacao.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frmOficinaMedeiros.getContentPane().add(observacao);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 341, 1368, 13);
		separator_1.setBackground(SystemColor.desktop);
		frmOficinaMedeiros.getContentPane().add(separator_1);

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setBounds(894, 206, 157, 128);
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_10);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 417, 1187, -31);
		separator_2.setBackground(SystemColor.desktop);
		frmOficinaMedeiros.getContentPane().add(separator_2);

		dataServico = new JDateChooser();
		dataServico.setBounds(173, 195, 129, 20);
		dataServico.setDateFormatString("dd/MM/yyyy");
		frmOficinaMedeiros.getContentPane().add(dataServico);

		dataEntrega = new JDateChooser();
		dataEntrega.setBounds(426, 195, 141, 20);
		dataEntrega.setDateFormatString("dd/MM/yyyy");
		frmOficinaMedeiros.getContentPane().add(dataEntrega);

		JLabel lblNewLabel_11 = new JLabel("STATUS");
		lblNewLabel_11.setBounds(965, 195, 61, 14);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_11);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 447, 1368, 253);
		frmOficinaMedeiros.getContentPane().add(scrollPane);
		table = servicoController.criarTabela();
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("PESQUISAR");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarServicosBancoDados();
				limparDados();
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\pesquisar-icon.png"));
		btnNewButton.setBounds(65, 359, 122, 38);
		frmOficinaMedeiros.getContentPane().add(btnNewButton);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				selecionarItem();
			}
		});

		btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(252, 356, 122, 41);
		btnSalvar.setEnabled(false);
		btnSalvar.setBackground(SystemColor.activeCaption);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				salvar();
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		btnSalvar.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Actions-document-save-icon.png"));
		frmOficinaMedeiros.getContentPane().add(btnSalvar);

		JLabel lblNewLabel_2 = new JLabel("DO SERVI\u00C7O");
		lblNewLabel_2.setBounds(43, 276, 82, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_2);

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(439, 356, 115, 41);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarFuncoes();
			}
		});
		btnEditar.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Programming-Edit-Property-icon.png"));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		btnEditar.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.getContentPane().add(btnEditar);

		JButton btnNewButton_1 = new JButton("EXCLUIR");
		btnNewButton_1.setBounds(619, 356, 122, 41);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				excluir();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\delete-file-icon (1).png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("CANCELAR");
		btnNewButton_1_1.setBounds(806, 356, 129, 41);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				limparDados();
				desabilitarFuncoes();
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Status-dialog-error-icon.png"));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		btnNewButton_1_1.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_1_1);

		JButton btnNewButton_2 = new JButton("MENU");
		btnNewButton_2.setBounds(1000, 356, 104, 41);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PesquisaServicos window = new PesquisaServicos();
				window.frmOficinaMedeiros.setVisible(false);
				MenuPesquisa menu = new MenuPesquisa();
				menu.frmOficinaMedeiros.setVisible(true);
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

		textFuncionario = new JTextField();
		textFuncionario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textFuncionario.setBounds(173, 148, 281, 20);
		frmOficinaMedeiros.getContentPane().add(textFuncionario);
		textFuncionario.setColumns(10);

		textCliente = new JTextField();
		textCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textCliente.setBounds(538, 148, 314, 20);
		frmOficinaMedeiros.getContentPane().add(textCliente);
		textCliente.setColumns(10);

		textModelos = new JTextField();
		textModelos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textModelos.setBounds(935, 148, 146, 20);
		frmOficinaMedeiros.getContentPane().add(textModelos);
		textModelos.setColumns(10);

		textStatus = new JTextField();
		textStatus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textStatus.setBounds(1024, 193, 282, 20);
		frmOficinaMedeiros.getContentPane().add(textStatus);
		textStatus.setColumns(10);
		
		textPago = new JTextField();
		textPago.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textPago.setBounds(853, 193, 86, 20);
		frmOficinaMedeiros.getContentPane().add(textPago);
		textPago.setColumns(10);
		
		JButton btnNewButton3 = new JButton("IMPRIMIR");
		btnNewButton3.setBackground(SystemColor.activeCaption);
		btnNewButton3.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Printer-icon.png"));
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					RelatorioUtil.criarRelatorio("C:/Users/diego/git/Oficina-medeiros-Jpa-hibernete/Oficina-Medeiros/relatorio/servicos.jrxml",
							servicoController.buscarServicosPorNomeFuncionario(servico.getFuncionario().getNome()));
				} catch (JRException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 7));
		btnNewButton3.setBounds(1169, 356, 127, 41);
		frmOficinaMedeiros.getContentPane().add(btnNewButton3);
	}

	public void salvar() {
		if (iscamposPreenchidos()) {
			servicoController.editarServico(servico = new Servico(servico.getIdServico(), dataServico.getDate(),
					descricao.getText(), dataEntrega.getDate(), Double.valueOf(valor.getText()), textStatus.getText(),
					pagamento, observacao.getText(), cliente, veiculo, funcionario));
		servicoController.carregarTable();
			limparDados();

			JOptionPane.showMessageDialog(null, "SERVIÇO ATUALIZADO !!!");
		}
	}

	public void excluir() {

		switch (JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE EXCLUIR SERVIÇO ?", "", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE)) {

		case 0:
			modelo.removeRow(table.getSelectedRow());
			servicoController.removerServico(servico);
			servicoController.carregarTable();

			JOptionPane.showMessageDialog(null, "SERVIÇO FUI EXCLUIDO!!!");
			break;

		case 1:

			JOptionPane.showMessageDialog(null, "SERVIÇO NÃO FUI EXCLUIDO!!!");
			break;
		}
	}

	public void selecionarItem() {

		try {
			modelo = (DefaultTableModel) table.getModel();
			textFuncionario.setText(modelo.getValueAt(table.getSelectedRow(), 0).toString());
			textCliente.setText(modelo.getValueAt(table.getSelectedRow(), 1).toString());
			textModelos.setText(modelo.getValueAt(table.getSelectedRow(), 2).toString());
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
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void habilitarFuncoes() {
		textPago.setEnabled(true);
		descricao.setEnabled(true);
		dataServico.setEnabled(true);
		dataEntrega.setEnabled(true);
		textStatus.setEnabled(true);
		observacao.setEnabled(true);
		btnSalvar.setEnabled(true);
		valor.setEnabled(true);
	}

	public void desabilitarFuncoes() {

		textPago.setEnabled(false);
		valor.setEnabled(false);
		descricao.setEnabled(false);
		dataServico.setEnabled(false);
		dataEntrega.setEnabled(false);
		textStatus.setEnabled(false);
		observacao.setEnabled(false);
		btnSalvar.setEnabled(false);
	}

	public void limparDados() {

		textPago.setText("");
		descricao.setText("");
		observacao.setText("");
		dataServico.setCalendar(null);
		dataEntrega.setCalendar(null);
		valor.setText("");
		textStatus.setText("");
		textFuncionario.setText("");
		textCliente.setText("");
		textModelos.setText("");
	}

	public boolean iscamposPreenchidos() {
		if (isfuncionarioValido() && isClienteValido() && isModeloValido() && isDataServicoValido()
				&& isDataEntregaValido() && isValorValido() && isStatusValido()
				&& isDescricaoValido()) {
			return true;
		} else {

		}
		return false;
	}

	public boolean isfuncionarioValido() {
		try {
			if (!textFuncionario.getText().equals("")) {
				return true;
			} else {
				throw new OficinaException(" CAMPO DO FUNCIONARIO VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO FUNCIONARIO VAZIO  !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isClienteValido() {
		try {
			if (!textCliente.getText().equals("")) {
				return true;
			} else {
				throw new OficinaException(" CAMPO DO CLIENTE VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO CLIENTE VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isModeloValido() {
		try {
			if (!textModelos.getText().equals("")) {
				return true;
			} else {
				throw new OficinaException(" CAMPO DO MODELO DO CARRO VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO MODELO DO CARRO VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isDescricaoValido() {
		try {
			if (!descricao.getText().equals("")) {
				return true;
			} else {
				throw new OficinaException(" CAMPO DO DESCRIÇÃO DO SERVIÇO VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO DESCRICÃO DO SERVIÇO VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isStatusValido() {
		try {
			if (!textStatus.getText().equals("")) {
				return true;
			} else {
				throw new OficinaException(" CAMPO DO STATUS DO SERVIÇO VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO STATUS DO SERVIÇO VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isDataEntregaValido() {
		try {
			if (dataEntrega.getCalendar() != null) {
				return true;
			} else {
				throw new OficinaException(" CAMPO DA DATA ENTREGA VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DA DATA ENTREGA VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isDataServicoValido() {
		try {
			if (dataServico.getCalendar() != null) {
				return true;
			} else {
				throw new OficinaException(" CAMPO DA DATA SERVIÇO VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DA DATA SERVIÇO VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isValorValido() {
		try {
			if (!valor.getText().equals("")) {
				return true;
			} else {
				throw new OficinaException(" CAMPO DO VALOR VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO VALOR VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isPagamentoValido() {
		try {
			if (textPago.getText().equals("") ) {
				return true;
			} else {
				throw new OficinaException(" CAMPO DO PAGAMENTO VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO PAGAMENTO VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public void pesquisarServicosBancoDados() {

		funcionario.setNome(textFuncionario.getText());
		cliente.setNome(textCliente.getText());
		veiculo.setModelo(textModelos.getText());
		servicoController.carregarPesquisaServicoTabela(servico = new Servico(servico.getIdServico(),
				dataServico.getDate(), descricao.getText(), dataEntrega.getDate(), textStatus.getText(), pagamento,
				observacao.getText(), cliente, veiculo, funcionario));

	}
}
