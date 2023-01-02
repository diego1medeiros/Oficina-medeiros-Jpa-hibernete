package br.com.oficinamedeiros.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JSeparator;
import br.com.oficinamedeiros.controller.ClienteController;
import br.com.oficinamedeiros.controller.FuncionarioController;
import br.com.oficinamedeiros.controller.ServicoController;
import br.com.oficinamedeiros.controller.VeiculoController;
import br.com.oficinamedeiros.entity1.Cliente;
import br.com.oficinamedeiros.entity1.Funcionario;
import br.com.oficinamedeiros.entity1.Servico;
import br.com.oficinamedeiros.entity1.Veiculo;
import br.com.oficinamedeiros.exception.OficinaException;
import br.com.oficinamedeiros.util.RelatorioUtil;
import br.com.ofinamedeiros.enumeradores.StatusServicos;
import net.sf.jasperreports.engine.JRException;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;

public class CadastrarServico {
	private static final String FORMATO_DIA_MES_ANO = "dd-MM-yyyy";
	private ServicoController servicoController = new ServicoController();
	private Servico servico = new Servico();
	private JComboBox<Veiculo> modelos;
	private JComboBox<Funcionario> funcionarios;
	private JComboBox<Cliente> clientes;
	private JCheckBox servicoPago;
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
	private int acaoBotao;
	private Date dataServicoFormatada;
	private Date dataEntregaFormatada;
	private JTextField textId;
	private JTextField textStatus;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarServico telaServico = new CadastrarServico();
					telaServico.frmOficinaMedeiros.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastrarServico() {
		initialize();
		servicoController.carregarTable();
		limparDados();
	}

	private void initialize() {
		frmOficinaMedeiros = new JFrame();
		frmOficinaMedeiros.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\diego\\Downloads\\worm-gear-icon.png"));
		frmOficinaMedeiros.getContentPane().setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.setTitle("OFICINA MEDEIROS");
		frmOficinaMedeiros.setBounds(100, 100, 1382, 736);
		frmOficinaMedeiros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOficinaMedeiros.setLocationRelativeTo(null);
		frmOficinaMedeiros.setExtendedState(frmOficinaMedeiros.MAXIMIZED_BOTH);
		frmOficinaMedeiros.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("CADASTRO DE SERVI\u00C7O");
		lblNewLabel.setBounds(503, 27, 281, 36);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 74, 1366, 13);
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
		funcionarios.setEnabled(false);
		funcionarios.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frmOficinaMedeiros.getContentPane().add(funcionarios);

		JLabel lblNewLabel_3 = new JLabel("CLIENTE");
		lblNewLabel_3.setBounds(461, 102, 69, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_3);

		ClienteController clienteController = new ClienteController();
		List<Cliente> listaClientes = clienteController.buscarDadosDosClientes();
		/*clientes = new JComboBox(listaClientes.toArray());
		clientes.setBounds(525, 98, 304, 22);
		clientes.setEditable(true);
		clientes.setEnabled(false);
		clientes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frmOficinaMedeiros.getContentPane().add(clientes);*/


		clientes = new JComboBox(clienteController.buscarDadosDosClientes().toArray());
		clientes.setEnabled(false);
		clientes.setEditable(true);
		clientes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));

		clientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VeiculoController veiculoController = new VeiculoController();
				List<Veiculo> listaVeiculos = veiculoController
						.buscarVeiculos(clientes.getSelectedItem().toString());
			//	modelos.removeAllItems();
				for (Veiculo veiculo : listaVeiculos) {
					modelos.addItem(veiculo);
				}
			}
		});
		
		clientes.setSelectedItem("");
		clientes.setBounds(525, 98, 304, 22);
		frmOficinaMedeiros.getContentPane().add(clientes);
		modelos = new JComboBox();
		modelos.setEnabled(false);
		modelos.setEditable(true);
		modelos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		modelos.setBounds(935, 98, 166, 22);
		frmOficinaMedeiros.getContentPane().add(modelos);
		
		JLabel lblNewLabel_9 = new JLabel("MODELO");
		lblNewLabel_9.setBounds(856, 102, 69, 14);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_9);

	/*	VeiculoController veiculoController = new VeiculoController();
		List<Veiculo> listaVeiculos = veiculoController.buscarDadosDosVeiculos();
		modelos = new JComboBox(listaVeiculos.toArray());
		modelos.setBounds(935, 98, 166, 22);
		modelos.setEditable(true);
		modelos.setEnabled(false);
		modelos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frmOficinaMedeiros.getContentPane().add(modelos);*/

		JLabel lblNewLabel_4 = new JLabel("DATA DO SERVICO");
		lblNewLabel_4.setBounds(27, 146, 122, 14);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("DATA DA ENTREGA");
		lblNewLabel_4_1.setBounds(286, 146, 122, 14);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_4_1);

		JLabel lblNewLabel_5 = new JLabel("VALOR R$");
		lblNewLabel_5.setBounds(604, 146, 82, 14);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_5);

		valor = new JTextField();
		valor.setBounds(680, 144, 104, 20);
		valor.setEnabled(false);
		valor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frmOficinaMedeiros.getContentPane().add(valor);
		valor.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("PAGO");
		lblNewLabel_6.setBounds(836, 146, 44, 14);
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
		separator_1.setBounds(0, 301, 1366, 13);
		separator_1.setBackground(SystemColor.desktop);
		frmOficinaMedeiros.getContentPane().add(separator_1);

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setBounds(857, 173, 157, 128);
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\worm-gear-icon (1).png"));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_10);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 364, 1356, 22);
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
		scrollPane.setBounds(0, 364, 1366, 333);
		frmOficinaMedeiros.getContentPane().add(scrollPane);
		table = servicoController.criarTabela();
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				selecionarItem();
			}
		});

		btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(210, 312, 122, 41);
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
		lblNewLabel_2.setBounds(27, 227, 82, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		frmOficinaMedeiros.getContentPane().add(lblNewLabel_2);

		JButton btnNew = new JButton("NOVO");
		btnNew.setBounds(53, 312, 104, 41);
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				acaoBotao = 0;
				limparDados();
				habilitarFuncoes();
			}
		});
		btnNew.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Actions-document-new-icon.png"));
		btnNew.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		btnNew.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.getContentPane().add(btnNew);

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(385, 312, 115, 41);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				acaoBotao = 1;
				habilitarFuncoes();
			}
		});
		btnEditar.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Programming-Edit-Property-icon.png"));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		btnEditar.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.getContentPane().add(btnEditar);

		JButton btnNewButton_1 = new JButton("EXCLUIR");
		btnNewButton_1.setBounds(553, 312, 122, 41);
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
		btnNewButton_1_1.setBounds(728, 312, 129, 41);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				limparDados();
				desabilitarFuncoes();
				modelos.removeAllItems();
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Status-dialog-error-icon.png"));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		btnNewButton_1_1.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_1_1);

		JButton btnNewButton_2 = new JButton("MENU");
		btnNewButton_2.setBounds(910, 312, 104, 41);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuPrincipal window = new MenuPrincipal();
				window.frmOficinaMedeiros.setVisible(true);
				CadastrarServico servico = new CadastrarServico();
				servico.frmOficinaMedeiros.setVisible(false);
				frmOficinaMedeiros.dispose();

			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\diego\\Downloads\\Very-Basic-Menu-icon.png"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_2);

		servicoPago = new JCheckBox("");
		servicoPago.setEnabled(false);
		servicoPago.setBounds(886, 141, 18, 23);
		servicoPago.setBackground(SystemColor.activeCaption);
		servicoPago.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		frmOficinaMedeiros.getContentPane().add(servicoPago);

		textId = new JTextField();
		textId.setBounds(139, 11, -6, 20);
		frmOficinaMedeiros.getContentPane().add(textId);
		textId.setColumns(10);

		textStatus = new JTextField(StatusServicos.SERVICO_EM_ORCAMENTO.getCodigo());
		textStatus.setEnabled(false);
		textStatus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textStatus.setBounds(1015, 144, 291, 20);
		frmOficinaMedeiros.getContentPane().add(textStatus);
		textStatus.setColumns(10);
		
		JButton btnNewButton = new JButton("O.S.");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RelatorioUtil.criarRelatorio(
							"C:/dev/worspace/Oficina-Medeiros/relatorio/ordemDeServico.jrxml",
							servicoController.buscarServicosPorNomeFuncionario(servico.getFuncionario().getNome()));
					System.out.println(servico.getFuncionario().getNome());
				} catch (JRException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(1224, 312, 89, 41);
		frmOficinaMedeiros.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("CONTRATO");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_3.setBackground(SystemColor.activeCaption);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					RelatorioUtil.criarRelatorio(
							"C:/dev/worspace/Oficina-Medeiros/relatorio/cartaDeServico.jrxml",
							servicoController.buscarServicosPorNomeFuncionario(servico.getFuncionario().getNome()));
					System.out.println(servico.getFuncionario().getNome());
				} catch (JRException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(1067, 312, 104, 41);
		frmOficinaMedeiros.getContentPane().add(btnNewButton_3);
		servicoPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkServicoPago();
			}
		});
	}

	public void salvar() {

		if (iscamposPreenchidos()) {
			if (acaoBotao == 0) {
				servicoController.cadastrarServico(servico = new Servico( dataServico.getDate(),
						descricao.getText(), dataEntrega.getDate(), Double.valueOf(valor.getText()),
						textStatus.getText(), pagamento, observacao.getText(), (Cliente) clientes.getSelectedItem(),
						(Veiculo) modelos.getSelectedItem(), (Funcionario) funcionarios.getSelectedItem()));

				servicoController.carregarTable();
				limparDados();
				desabilitarFuncoes();

				JOptionPane.showMessageDialog(null, "SERVI�O CADASTRADO !!!");

			} else if (acaoBotao == 1) {

				servicoController.editarServico(servico = new Servico(servico.getIdServico(), dataServico.getDate(),
						descricao.getText(), dataEntrega.getDate(), Double.valueOf(valor.getText()),
						textStatus.getText(), pagamento, observacao.getText(), (Cliente) clientes.getSelectedItem(),
						(Veiculo) modelos.getSelectedItem(), (Funcionario) funcionarios.getSelectedItem()));
				servicoController.carregarTable();
				limparDados();
				desabilitarFuncoes();
				JOptionPane.showMessageDialog(null, "SERVI�O ATUALIZADO !!!");

			}
		}
	}

	public void excluir() {

		switch (JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE EXCLUIR SERVICO ?", "", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE)) {

		case 0:

			modelo.removeRow(table.getSelectedRow());
			servicoController.removerServico(servico);
			servicoController.carregarTable();
			JOptionPane.showMessageDialog(null, "SERVICO FUI EXCLUIDO!!!");
			break;

		case 1:

			JOptionPane.showMessageDialog(null, "SERVI�O N�O FUI EXCLUIDO!!!");
			break;
		}
	}

	public void selecionarItem() {

		try {
			modelo = (DefaultTableModel) table.getModel();
			funcionarios.setSelectedItem(modelo.getValueAt(table.getSelectedRow(), 0).toString());
			clientes.setSelectedItem(modelo.getValueAt(table.getSelectedRow(), 1).toString());
			modelos.setSelectedItem(modelo.getValueAt(table.getSelectedRow(), 2).toString());
			dataServico.setDate(new SimpleDateFormat("dd-MM-yyyy").parse(modelo.getValueAt(table.getSelectedRow(), 3).toString()));
			dataEntrega.setDate(new SimpleDateFormat("dd-MM-yyyy").parse(modelo.getValueAt(table.getSelectedRow(), 4).toString()));
			valor.setText(modelo.getValueAt(table.getSelectedRow(), 5).toString());
			textStatus.setText(modelo.getValueAt(table.getSelectedRow(), 6).toString());
			servicoPago.setName(modelo.getValueAt(table.getSelectedRow(), 7).toString());
			descricao.setText(modelo.getValueAt(table.getSelectedRow(), 8).toString());
			observacao.setText(modelo.getValueAt(table.getSelectedRow(), 9).toString());
			textId.setText(modelo.getValueAt(table.getSelectedRow(), 10).toString());
			servico.setIdServico(Long.parseLong(textId.getText()));
			servico.getCliente().setIdCliente((Long) modelo.getValueAt(table.getSelectedRow(), 11));
			servico.getVeiculo().setIdVeiculo((Long) modelo.getValueAt(table.getSelectedRow(), 12));
			servico.getFuncionario().setIdFuncionario((Long) modelo.getValueAt(table.getSelectedRow(), 13));
            servico.getFuncionario().setNome(funcionarios.getSelectedItem().toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void habilitarFuncoes() {
		funcionarios.setEnabled(true);
		modelos.setEnabled(true);
		clientes.setEnabled(true);
		servicoPago.setEnabled(true);
		descricao.setEnabled(true);
		dataServico.setEnabled(true);
		dataEntrega.setEnabled(true);
		observacao.setEnabled(true);
		btnSalvar.setEnabled(true);
		valor.setEnabled(true);
	}

	public void desabilitarFuncoes() {
		textStatus.setEnabled(false);
		valor.setEnabled(false);
		funcionarios.setEnabled(false);
		modelos.setEnabled(false);
		clientes.setEnabled(false);
		servicoPago.setEnabled(false);
		descricao.setEnabled(false);
		dataServico.setEnabled(false);
		dataEntrega.setEnabled(false);
		textStatus.setEnabled(false);
		observacao.setEnabled(false);
		btnSalvar.setEnabled(false);
	}

	public void limparDados() {

		funcionarios.setSelectedItem("");
		modelos.setSelectedItem("");
		clientes.setSelectedItem("");
		servicoPago.setText("");
		descricao.setText("");
		observacao.setText("");
		dataServico.setCalendar(null);
		dataEntrega.setCalendar(null);
		servicoPago.setSelected(false);
		valor.setText("");

	}

	public boolean iscamposPreenchidos() {
		if (isfuncionarioValido() && isClienteValido() && isModeloValido() && isDataServicoValido()
				&& isDataEntregaValido() && isValorValido() && isPagamentoValido() && isStatusValido()
				&& isDescricaoValido()) {
			return true;
		} else {

		}
		return false;
	}

	public boolean isfuncionarioValido() {
		try {
			if (!funcionarios.getSelectedItem().equals("")) {
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
			if (!clientes.getSelectedItem().equals("")) {
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
			if (!modelos.getSelectedItem().equals("")) {
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
				throw new OficinaException(" CAMPO DO DESCRI��O DO SERVI�O VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO DESCRI��O DO SERVI�O VAZIO !!!");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isStatusValido() {
		try {
			if (!textStatus.getText().equals("")) {
				return true;
			} else {
				throw new OficinaException(" CAMPO DO STATUS DO SERVI�O VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DO STATUS DO SERVI�O VAZIO !!!");
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
				throw new OficinaException(" CAMPO DA DATA SERVICO VAZIO !!!");
			}
		} catch (OficinaException e) {
			JOptionPane.showMessageDialog(null, " CAMPO DA DATA SERVICO VAZIO !!!");
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
			if (servicoPago.getSelectedIcon() == null) {
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

	public boolean checkServicoPago() {

		if (servicoPago.getSelectedIcon() != null) {
			pagamento = 0;
			return true;
		} else {
			pagamento = 1;
		}
		return false;

	}
}
