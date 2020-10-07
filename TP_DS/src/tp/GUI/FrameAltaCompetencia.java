package tp.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ComponentOrientation;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;

public class FrameAltaCompetencia {

	private JFrame frmAltaCompetencia;
	private JTextField txtNombre;
	private JTextField txtCantidadSets;
	private JTextField txtCantidadTantos;
	private JTextField txtPuntosPartidoGanado;
	private JTextField txtPuntosEmpate;
	private JTextField txtPuntosPresentarse;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAltaCompetencia window = new FrameAltaCompetencia();
					window.frmAltaCompetencia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrameAltaCompetencia() {
		initialize();
	}

	private void initialize() {
		frmAltaCompetencia = new JFrame();
		frmAltaCompetencia.getContentPane().setBackground(new Color(153, 204, 255));
		frmAltaCompetencia.setBackground(new Color(153, 204, 255));
		frmAltaCompetencia.setTitle("ALTA COMPETENCIA");
		frmAltaCompetencia.setBounds(100, 100, 651, 500);
		frmAltaCompetencia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAltaCompetencia.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre *");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(10, 11, 75, 14);
		frmAltaCompetencia.getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10, 36, 86, 20);
		frmAltaCompetencia.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDeporte = new JLabel("Deporte *");
		lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeporte.setBounds(10, 67, 75, 14);
		frmAltaCompetencia.getContentPane().add(lblDeporte);
		
		JComboBox boxDeporte = new JComboBox();
		boxDeporte.setBounds(10, 92, 28, 22);
		frmAltaCompetencia.getContentPane().add(boxDeporte);
		
		JLabel lblModalidad = new JLabel("Modalidad *");
		lblModalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModalidad.setBounds(10, 125, 86, 14);
		frmAltaCompetencia.getContentPane().add(lblModalidad);
		
		JComboBox boxModalidad = new JComboBox();
		boxModalidad.setBounds(10, 150, 28, 22);
		frmAltaCompetencia.getContentPane().add(boxModalidad);
		
		JLabel lblFormaPuntuacion = new JLabel("Forma de Puntuaci\u00F3n *");
		lblFormaPuntuacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFormaPuntuacion.setBounds(10, 183, 144, 14);
		frmAltaCompetencia.getContentPane().add(lblFormaPuntuacion);
		
		JComboBox boxFormaPuntuacion = new JComboBox();
		boxFormaPuntuacion.setBounds(10, 208, 28, 22);
		frmAltaCompetencia.getContentPane().add(boxFormaPuntuacion);
		
		JLabel lblCantidadSets = new JLabel("Cantidad de Sets *");
		lblCantidadSets.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidadSets.setBounds(10, 241, 123, 14);
		frmAltaCompetencia.getContentPane().add(lblCantidadSets);
		
		txtCantidadSets = new JTextField();
		txtCantidadSets.setBounds(225, 240, 40, 20);
		frmAltaCompetencia.getContentPane().add(txtCantidadSets);
		txtCantidadSets.setColumns(10);
		
		JLabel lblCantidadTantos = new JLabel("Cantidad de tantos por ausencia *");
		lblCantidadTantos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidadTantos.setBounds(10, 280, 224, 19);
		frmAltaCompetencia.getContentPane().add(lblCantidadTantos);
		
		txtCantidadTantos = new JTextField();
		txtCantidadTantos.setBounds(225, 281, 40, 20);
		frmAltaCompetencia.getContentPane().add(txtCantidadTantos);
		txtCantidadTantos.setColumns(10);
		
		JLabel lblReglamento = new JLabel("Reglamento");
		lblReglamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReglamento.setBounds(10, 305, 75, 20);
		frmAltaCompetencia.getContentPane().add(lblReglamento);
		
		JLabel lblPuntosPartidoGanado = new JLabel("Puntos por Partido Ganado");
		lblPuntosPartidoGanado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPuntosPartidoGanado.setBounds(171, 39, 174, 17);
		frmAltaCompetencia.getContentPane().add(lblPuntosPartidoGanado);
		
		txtPuntosPartidoGanado = new JTextField();
		txtPuntosPartidoGanado.setBounds(343, 39, 40, 20);
		frmAltaCompetencia.getContentPane().add(txtPuntosPartidoGanado);
		txtPuntosPartidoGanado.setColumns(10);
		
		JRadioButton rdbtnEmpate = new JRadioButton("Empate");
		rdbtnEmpate.setBounds(181, 65, 75, 23);
		frmAltaCompetencia.getContentPane().add(rdbtnEmpate);
		
		JLabel lblPuntosEmpate = new JLabel("Puntos por Empate");
		lblPuntosEmpate.setEnabled(false);
		lblPuntosEmpate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPuntosEmpate.setBounds(171, 96, 123, 20);
		frmAltaCompetencia.getContentPane().add(lblPuntosEmpate);
		
		txtPuntosEmpate = new JTextField();
		txtPuntosEmpate.setEnabled(false);
		txtPuntosEmpate.setBounds(343, 93, 40, 20);
		frmAltaCompetencia.getContentPane().add(txtPuntosEmpate);
		txtPuntosEmpate.setColumns(10);
		
		JLabel lblPuntosPresentarse = new JLabel("Puntos por Presentarse");
		lblPuntosPresentarse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPuntosPresentarse.setBounds(171, 136, 150, 17);
		frmAltaCompetencia.getContentPane().add(lblPuntosPresentarse);
		
		txtPuntosPresentarse = new JTextField();
		txtPuntosPresentarse.setBounds(343, 133, 40, 20);
		frmAltaCompetencia.getContentPane().add(txtPuntosPresentarse);
		txtPuntosPresentarse.setColumns(10);
		
		JSplitPane splitLugar = new JSplitPane();
		splitLugar.setDividerSize(0);
		splitLugar.setBounds(405, 265, 208, 25);
		frmAltaCompetencia.getContentPane().add(splitLugar);
		
		JButton btnModificarLugar = new JButton("Modificar Lugar");
		btnModificarLugar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnModificarLugar.setEnabled(false);
		splitLugar.setLeftComponent(btnModificarLugar);
		
		JButton btnAgregarLugar = new JButton("Agregar Lugar");
		btnAgregarLugar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		splitLugar.setRightComponent(btnAgregarLugar);
		
		JSplitPane splitCancelarConfirmar = new JSplitPane();
		splitCancelarConfirmar.setDividerSize(0);
		splitCancelarConfirmar.setBounds(417, 425, 208, 25);
		frmAltaCompetencia.getContentPane().add(splitCancelarConfirmar);
		
		JButton btnCancelar = new JButton("Confirmar");
		btnCancelar.setEnabled(false);
		btnCancelar.setBackground(new Color(102, 102, 255));
		splitCancelarConfirmar.setRightComponent(btnCancelar);
		
		JButton btnConfirmar = new JButton("Cancelar");
		splitCancelarConfirmar.setLeftComponent(btnConfirmar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(405, 67, 208, 188);
		frmAltaCompetencia.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Lugar", "Disponibilidad"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 336, 397, 114);
		frmAltaCompetencia.getContentPane().add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setMaximumSize(new Dimension(100, 100));
		scrollPane_1.setViewportView(textArea);
	}
}
