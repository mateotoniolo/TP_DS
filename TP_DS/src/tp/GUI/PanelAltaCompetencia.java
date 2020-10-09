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
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.ComponentOrientation;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.FocusTraversalPolicy;

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
import java.awt.Frame;

import javax.swing.table.DefaultTableModel;

import tp.clases.Competencia;
import tp.clases.CompetenciaEliminacionDoble;
import tp.clases.CompetenciaEliminacionSimple;
import tp.clases.CompetenciaLiga;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import tp.DAO.DataBase;
import tp.GUI.PanelAltaCompetencia.Modalidad;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import java.awt.Canvas;
import javax.swing.JInternalFrame;
import javax.swing.JSeparator;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class PanelAltaCompetencia extends JPanel {
	
	public enum Modalidad { LIGA, ELIMINACIONSIMPLE, ELIMINACIONDOBLE };

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtCantidadSets;
	private JTextField txtTantosAusencia;
	private JTextField txtPuntosPartidoGanado;
	private JTextField txtPuntosEmpate;
	private JTextField txtPuntosPresentarse;
	private JTable table;
	private Modalidad modalidadCompetencia;
	private String nombreCompetencia;
	private boolean ingresoNombre;
	private boolean ingresoDeporte;
	private String deporteCompetencia;
	private boolean ingresoModalidad;
	private boolean ingresoFormaPuntuacion;
	private boolean ingresoCantidadSets;
	private boolean ingresoCantidadTantos;

	public PanelAltaCompetencia(JFrame frame) {
		
		setBackground(new Color(153, 204, 255));
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre *");
		lblNombre.setBounds(10, 11, 152, 21);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNombre);
		
		
		txtNombre = new JTextField();
		txtNombre.setMinimumSize(new Dimension(15, 28));
		txtNombre.setPreferredSize(new Dimension(15, 30));
		txtNombre.setBounds(10, 31, 514, 30);
		add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.addActionListener( a -> {
			nombreCompetencia = txtNombre.getText(); 
		});

		
		JLabel lblDeporte = new JLabel("Deporte *");
		lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDeporte.setBounds(10, 69, 115, 25);
		add(lblDeporte);
		
		JComboBox boxDeporte = new JComboBox();
//		DataBase.leerJson();
//		DeporteDAO dd = new DeporteDAO();
//		boxDeporte.setModel(new DefaultComboBoxModel());
//		for(string s : dd.getNombres) {
//			boxDeporte.addItem(s);
//		}
		boxDeporte.setModel(new DefaultComboBoxModel(new String[] {"", "Basketball", "Football", "Tennis"}));
		boxDeporte.setBounds(10, 96, 232, 30);
		add(boxDeporte);
		ingresoDeporte = false;
//		boxDeporte.addActionListener( a -> {
//			deporteCompetencia = boxDeporte.getSelectedItem();
//		});
		
		JLabel lblModalidad = new JLabel("Modalidad *");
		lblModalidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblModalidad.setBounds(254, 69, 115, 22);
		add(lblModalidad);
		
		JComboBox<Modalidad> boxModalidad = new JComboBox<Modalidad>();
		boxModalidad.setModel(new DefaultComboBoxModel(new String[] {"", "Liga", "Eliminacion Simple", "Eliminacion Doble"}));
		boxModalidad.setBounds(254, 96, 270, 30);
		add(boxModalidad);
		boxModalidad.addActionListener( a -> {
			switch((String)boxModalidad.getSelectedItem()) {
			case "Liga": modalidadCompetencia = Modalidad.LIGA;
				break;
			case "Eliminacion Simple": modalidadCompetencia = Modalidad.ELIMINACIONSIMPLE;
				break;
			case "Eliminacion Doble": modalidadCompetencia = Modalidad.ELIMINACIONDOBLE;
			}
		});
		
		JLabel lblFormaPuntuacion = new JLabel("Forma de Puntuaci\u00F3n *");
		lblFormaPuntuacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFormaPuntuacion.setBounds(10, 224, 183, 30);
		add(lblFormaPuntuacion);
		
		JLabel lblCantidadSets = new JLabel("Cantidad de Sets *");
		lblCantidadSets.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidadSets.setBounds(10, 307, 152, 30);
		add(lblCantidadSets);
		
		txtCantidadSets = new JTextField();
		txtCantidadSets.setEnabled(false);
		txtCantidadSets.setBounds(174, 311, 40, 26);
		add(txtCantidadSets);
		txtCantidadSets.setColumns(10);
		
		JLabel lblCantidadTantos = new JLabel("Tantos por ausencia *");
		lblCantidadTantos.setToolTipText("");
		lblCantidadTantos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidadTantos.setBounds(291, 309, 175, 26);
		add(lblCantidadTantos);
		
		txtTantosAusencia = new JTextField();
		txtTantosAusencia.setEnabled(false);
		txtTantosAusencia.setBounds(478, 311, 40, 26);
		add(txtTantosAusencia);
		txtTantosAusencia.setColumns(10);
		
		JLabel lblReglamento = new JLabel("Reglamento");
		lblReglamento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblReglamento.setBounds(10, 387, 115, 30);
		add(lblReglamento);
		
		JLabel lblPuntosPartidoGanado = new JLabel("Puntos por Partido Ganado");
		lblPuntosPartidoGanado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPuntosPartidoGanado.setBounds(10, 156, 219, 21);
		add(lblPuntosPartidoGanado);
		
		txtPuntosPartidoGanado = new JTextField();
		txtPuntosPartidoGanado.setEnabled(false);
		txtPuntosPartidoGanado.setBounds(227, 155, 40, 26);
		add(txtPuntosPartidoGanado);
		txtPuntosPartidoGanado.setColumns(10);
		
		JLabel lblPuntosEmpate = new JLabel("Puntos por Empate");
		lblPuntosEmpate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPuntosEmpate.setBounds(560, 155, 152, 24);
		add(lblPuntosEmpate);
		
		txtPuntosEmpate = new JTextField();
		txtPuntosEmpate.setEnabled(false);
		txtPuntosEmpate.setBounds(724, 156, 40, 26);
		add(txtPuntosEmpate);
		txtPuntosEmpate.setColumns(10);
		
		JRadioButton rdbtnEmpate = new JRadioButton("Empate");
		rdbtnEmpate.setFont(new Font("SansSerif", Font.PLAIN, 16));
		rdbtnEmpate.setEnabled(false);
		rdbtnEmpate.setBounds(559, 130, 89, 23);
		add(rdbtnEmpate);
		
		rdbtnEmpate.addActionListener( a -> {
			if (rdbtnEmpate.isSelected()) {
				txtPuntosEmpate.setEnabled(true);
			} else {
				txtPuntosEmpate.setEnabled(false);
				txtPuntosEmpate.setText("");
			}
		});
		
		JLabel lblPuntosPresentarse = new JLabel("Puntos por Presentarse");
		lblPuntosPresentarse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPuntosPresentarse.setBounds(295, 158, 194, 19);
		add(lblPuntosPresentarse);
		
		txtPuntosPresentarse = new JTextField();
		txtPuntosPresentarse.setEnabled(false);
		txtPuntosPresentarse.setBounds(484, 156, 40, 26);
		add(txtPuntosPresentarse);
		txtPuntosPresentarse.setColumns(10);
		
		boxModalidad.addActionListener( a -> {
			if(boxModalidad.getSelectedItem()=="Liga") {
				txtPuntosPartidoGanado.setEnabled(true);
				txtPuntosPresentarse.setEnabled(true);
				rdbtnEmpate.setEnabled(true);
			} else {
				txtPuntosPartidoGanado.setEnabled(false);
				txtPuntosPartidoGanado.setText("");
				txtPuntosPresentarse.setEnabled(false);
				txtPuntosPresentarse.setText("");
				rdbtnEmpate.setEnabled(false);
			}
		});
		
		JRadioButton rdbtnSets = new JRadioButton("Sets");
		rdbtnSets.setFont(new Font("SansSerif", Font.PLAIN, 18));
		rdbtnSets.setBounds(10, 260, 115, 18);
		add(rdbtnSets);
		
		JRadioButton rdbtnPuntuacion = new JRadioButton("Puntuacion");
		rdbtnPuntuacion.setFont(new Font("SansSerif", Font.PLAIN, 18));
		rdbtnPuntuacion.setBounds(291, 260, 115, 18);
		add(rdbtnPuntuacion);
		
		JRadioButton rdbtnPuntuacionFinal = new JRadioButton("Puntuacion Final");
		rdbtnPuntuacionFinal.setFont(new Font("SansSerif", Font.PLAIN, 18));
		rdbtnPuntuacionFinal.setBounds(560, 260, 175, 18);
		add(rdbtnPuntuacionFinal);
		
		rdbtnSets.addActionListener( a -> {
			rdbtnPuntuacion.setSelected(false);
			rdbtnPuntuacionFinal.setSelected(false);
			txtCantidadSets.setEnabled(true);
			txtTantosAusencia.setEnabled(false);
			txtTantosAusencia.setText("");
		});
		
		rdbtnPuntuacion.addActionListener( a -> {
			rdbtnSets.setSelected(false);
			rdbtnPuntuacionFinal.setSelected(false);
			txtTantosAusencia.setEnabled(true);
			txtCantidadSets.setEnabled(false);
			txtCantidadSets.setText("");
		});
		
		rdbtnPuntuacionFinal.addActionListener( a -> {
			rdbtnSets.setSelected(false);
			rdbtnPuntuacion.setSelected(false);
			txtTantosAusencia.setEnabled(true);
			txtCantidadSets.setEnabled(false);
			txtTantosAusencia.setEnabled(false);
			txtCantidadSets.setText("");
			txtTantosAusencia.setText("");
		});
		
		
		JSplitPane splitLugar = new JSplitPane();
		
		JSplitPane splitCancelarConfirmar = new JSplitPane();
		splitCancelarConfirmar.setDividerSize(0);
		splitCancelarConfirmar.setBounds(1026, 684, 232, 30);
		add(splitCancelarConfirmar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.setBackground(new Color(102, 102, 255));
		
		txtNombre.addActionListener( a -> {
			ingresoNombre = (txtNombre.getText().length()!=0);
			if(ingresoNombre && ingresoDeporte && ingresoModalidad && ingresoFormaPuntuacion) {
				if(rdbtnSets.isSelected() && ingresoCantidadSets) {
					btnConfirmar.setEnabled(true);
				} else if(rdbtnPuntuacion.isSelected() && ingresoCantidadTantos) {
					btnConfirmar.setEnabled(true);
				}
			} else {
				btnConfirmar.setEnabled(false);
			}
		});
		
		boxDeporte.addActionListener( a -> {
			ingresoDeporte = (boxDeporte.getSelectedItem()!="");
			if(ingresoNombre && ingresoDeporte && ingresoModalidad && ingresoFormaPuntuacion) {
				if(rdbtnSets.isSelected() && ingresoCantidadSets) {
					btnConfirmar.setEnabled(true);
				} else if(rdbtnPuntuacion.isSelected() && ingresoCantidadTantos) {
					btnConfirmar.setEnabled(true);
				}
			} else {
				btnConfirmar.setEnabled(false);
			}
		});
		
		boxModalidad.addActionListener( a -> {
			ingresoModalidad = (boxModalidad.getSelectedItem() != "");
			if(ingresoNombre && ingresoDeporte && ingresoModalidad && ingresoFormaPuntuacion) {
				if(rdbtnSets.isSelected() && ingresoCantidadSets) {
					btnConfirmar.setEnabled(true);
				} else if(rdbtnPuntuacion.isSelected() && ingresoCantidadTantos) {
					btnConfirmar.setEnabled(true);
				}
			} else {
				btnConfirmar.setEnabled(false);
			}
		});
		
		txtCantidadSets.addActionListener( a -> {
			ingresoCantidadSets= (txtCantidadSets.getText() != "");
//			Double.valueOf(txtCantidadSets.getText())
			if(ingresoNombre && ingresoDeporte && ingresoModalidad && ingresoFormaPuntuacion) {
				if(rdbtnSets.isSelected() && ingresoCantidadSets) {
					btnConfirmar.setEnabled(true);
				} else if(rdbtnPuntuacion.isSelected() && ingresoCantidadTantos) {
					btnConfirmar.setEnabled(true);
				}
			} else {
				btnConfirmar.setEnabled(false);
			}
		});
		
		txtTantosAusencia.addActionListener( a -> {
			ingresoCantidadTantos= (txtTantosAusencia.getText() != "");
			ingresoCantidadTantos= true;
			if(ingresoNombre && ingresoDeporte && ingresoModalidad && ingresoFormaPuntuacion) {
				if(rdbtnSets.isSelected() && ingresoCantidadSets) {
					btnConfirmar.setEnabled(true);
				} else if(rdbtnPuntuacion.isSelected() && ingresoCantidadTantos) {
					btnConfirmar.setEnabled(true);
				}
			} else {
				btnConfirmar.setEnabled(false);
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener( a -> {
			System.exit(0);
		});
		splitCancelarConfirmar.setRightComponent(btnConfirmar);
		splitCancelarConfirmar.setLeftComponent(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(204, 204, 204));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(802, 11, 456, 562);
		add(scrollPane);
		
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
				Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 429, 768, 186);
		add(scrollPane_1);
		
		JTextArea txtReglamento = new JTextArea();
		txtReglamento.setMaximumSize(new Dimension(100, 100));
		scrollPane_1.setViewportView(txtReglamento);
		

		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 206, 768, 14);
		add(separator);

		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 362, 768, 14);
		add(separator_1);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		splitPane.setBounds(802, 585, 232, 30);
		add(splitPane);
		
		JButton btnModificarLugar = new JButton("Modificar Lugar");
		splitPane.setLeftComponent(btnModificarLugar);
		
		JButton btnAgregarLugar = new JButton("Agregar Lugar");
		splitPane.setRightComponent(btnAgregarLugar);
		
		
	}
}
