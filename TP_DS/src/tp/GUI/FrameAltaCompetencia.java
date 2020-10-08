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
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import tp.GUI.FrameAltaCompetencia.Modalidad;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import java.awt.Canvas;
import javax.swing.JInternalFrame;
import javax.swing.JSeparator;

public class FrameAltaCompetencia extends JFrame {
	
	public enum Modalidad { LIGA, ELIMINACIONSIMPLE, ELIMINACIONDOBLE };

	private JFrame frmAltaCompetencia;
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
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		frmAltaCompetencia = new JFrame();
		frmAltaCompetencia.getContentPane().setBackground(new Color(153, 204, 255));
		frmAltaCompetencia.setBackground(new Color(153, 204, 255));
		frmAltaCompetencia.setTitle("ALTA COMPETENCIA");
		frmAltaCompetencia.setBounds(100, 100, 800, 520);
		frmAltaCompetencia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAltaCompetencia.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre *");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(10, 11, 75, 14);
		frmAltaCompetencia.getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setMinimumSize(new Dimension(15, 28));
		txtNombre.setPreferredSize(new Dimension(15, 30));
		txtNombre.setBounds(10, 31, 395, 26);
		frmAltaCompetencia.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.addActionListener( a -> {
			nombreCompetencia = txtNombre.getText(); 
		});

		
		JLabel lblDeporte = new JLabel("Deporte *");
		lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeporte.setBounds(10, 60, 75, 20);
		frmAltaCompetencia.getContentPane().add(lblDeporte);
		
		JComboBox boxDeporte = new JComboBox();
		boxDeporte.setModel(new DefaultComboBoxModel(new String[] {"", "Basketball", "Football", "Tennis"}));
		boxDeporte.setBounds(10, 79, 195, 26);
		frmAltaCompetencia.getContentPane().add(boxDeporte);
		ingresoDeporte = false;
		boxDeporte.addActionListener( a -> {
			deporteCompetencia = (String) boxDeporte.getSelectedItem();
		});
		
		JLabel lblModalidad = new JLabel("Modalidad *");
		lblModalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModalidad.setBounds(210, 63, 86, 14);
		frmAltaCompetencia.getContentPane().add(lblModalidad);
		
		JComboBox<Modalidad> boxModalidad = new JComboBox<Modalidad>();
		boxModalidad.setModel(new DefaultComboBoxModel(new String[] {"", "Liga", "Eliminacion Simple", "Eliminacion Doble"}));
		boxModalidad.setBounds(210, 79, 195, 26);
		frmAltaCompetencia.getContentPane().add(boxModalidad);
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
		lblFormaPuntuacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFormaPuntuacion.setBounds(10, 196, 144, 14);
		frmAltaCompetencia.getContentPane().add(lblFormaPuntuacion);
		
		JLabel lblCantidadSets = new JLabel("Cantidad de Sets *");
		lblCantidadSets.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidadSets.setBounds(227, 214, 123, 14);
		frmAltaCompetencia.getContentPane().add(lblCantidadSets);
		
		txtCantidadSets = new JTextField();
		txtCantidadSets.setEnabled(false);
		txtCantidadSets.setBounds(365, 208, 40, 26);
		frmAltaCompetencia.getContentPane().add(txtCantidadSets);
		txtCantidadSets.setColumns(10);
		
		JLabel lblCantidadTantos = new JLabel("Tantos por ausencia *");
		lblCantidadTantos.setToolTipText("");
		lblCantidadTantos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidadTantos.setBounds(227, 235, 144, 26);
		frmAltaCompetencia.getContentPane().add(lblCantidadTantos);
		
		txtTantosAusencia = new JTextField();
		txtTantosAusencia.setEnabled(false);
		txtTantosAusencia.setBounds(365, 235, 40, 26);
		frmAltaCompetencia.getContentPane().add(txtTantosAusencia);
		txtTantosAusencia.setColumns(10);
		
		JLabel lblReglamento = new JLabel("Reglamento");
		lblReglamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReglamento.setBounds(10, 311, 75, 20);
		frmAltaCompetencia.getContentPane().add(lblReglamento);
		
		JLabel lblPuntosPartidoGanado = new JLabel("Puntos por Partido Ganado");
		lblPuntosPartidoGanado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPuntosPartidoGanado.setBounds(10, 120, 166, 17);
		frmAltaCompetencia.getContentPane().add(lblPuntosPartidoGanado);
		
		txtPuntosPartidoGanado = new JTextField();
		txtPuntosPartidoGanado.setEnabled(false);
		txtPuntosPartidoGanado.setBounds(165, 115, 40, 26);
		frmAltaCompetencia.getContentPane().add(txtPuntosPartidoGanado);
		txtPuntosPartidoGanado.setColumns(10);
		
		JLabel lblPuntosEmpate = new JLabel("Puntos por Empate");
		lblPuntosEmpate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPuntosEmpate.setBounds(210, 150, 123, 20);
		frmAltaCompetencia.getContentPane().add(lblPuntosEmpate);
		
		txtPuntosEmpate = new JTextField();
		txtPuntosEmpate.setEnabled(false);
		txtPuntosEmpate.setBounds(365, 147, 40, 26);
		frmAltaCompetencia.getContentPane().add(txtPuntosEmpate);
		txtPuntosEmpate.setColumns(10);
		
		JRadioButton rdbtnEmpate = new JRadioButton("Empate");
		rdbtnEmpate.setEnabled(false);
		rdbtnEmpate.setBounds(10, 149, 75, 23);
		frmAltaCompetencia.getContentPane().add(rdbtnEmpate);
		
		rdbtnEmpate.addActionListener( a -> {
			if (rdbtnEmpate.isSelected()) {
				txtPuntosEmpate.setEnabled(true);
			} else {
				txtPuntosEmpate.setEnabled(false);
				txtPuntosEmpate.setText("");
			}
		});
		
		JLabel lblPuntosPresentarse = new JLabel("Puntos por Presentarse");
		lblPuntosPresentarse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPuntosPresentarse.setBounds(210, 120, 150, 17);
		frmAltaCompetencia.getContentPane().add(lblPuntosPresentarse);
		
		txtPuntosPresentarse = new JTextField();
		txtPuntosPresentarse.setEnabled(false);
		txtPuntosPresentarse.setBounds(365, 117, 40, 26);
		frmAltaCompetencia.getContentPane().add(txtPuntosPresentarse);
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
		rdbtnSets.setBounds(10, 214, 115, 18);
		frmAltaCompetencia.getContentPane().add(rdbtnSets);
		
		JRadioButton rdbtnPuntuacion = new JRadioButton("Puntuacion");
		rdbtnPuntuacion.setBounds(10, 239, 115, 18);
		frmAltaCompetencia.getContentPane().add(rdbtnPuntuacion);
		
		JRadioButton rdbtnPuntuacionFinal = new JRadioButton("Puntuacion Final");
		rdbtnPuntuacionFinal.setBounds(10, 264, 115, 18);
		frmAltaCompetencia.getContentPane().add(rdbtnPuntuacionFinal);
		
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
		splitLugar.setDividerSize(0);
		splitLugar.setBounds(559, 301, 219, 30);
		frmAltaCompetencia.getContentPane().add(splitLugar);
		
		JButton btnModificarLugar = new JButton("Modificar Lugar");
		btnModificarLugar.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnModificarLugar.setEnabled(false);
		splitLugar.setLeftComponent(btnModificarLugar);
		
		JButton btnAgregarLugar = new JButton("Agregar Lugar");
		btnAgregarLugar.setFont(new Font("SansSerif", Font.PLAIN, 11));
		splitLugar.setRightComponent(btnAgregarLugar);
		
		JSplitPane splitCancelarConfirmar = new JSplitPane();
		splitCancelarConfirmar.setDividerSize(0);
		splitCancelarConfirmar.setBounds(570, 450, 208, 25);
		frmAltaCompetencia.getContentPane().add(splitCancelarConfirmar);
		
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
//			new MainApplication().setVisible(true);
			System.exit(0);
		});
		splitCancelarConfirmar.setRightComponent(btnConfirmar);
		splitCancelarConfirmar.setLeftComponent(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(204, 204, 204));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(417, 31, 361, 270);
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
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(15);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 336, 768, 114);
		frmAltaCompetencia.getContentPane().add(scrollPane_1);
		
		JTextArea txtReglamento = new JTextArea();
		txtReglamento.setMaximumSize(new Dimension(100, 100));
		scrollPane_1.setViewportView(txtReglamento);
		

		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 182, 395, 14);
		frmAltaCompetencia.getContentPane().add(separator);

		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 294, 395, 14);
		frmAltaCompetencia.getContentPane().add(separator_1);
		

	}
}
