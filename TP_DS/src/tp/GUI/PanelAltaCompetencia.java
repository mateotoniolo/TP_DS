package tp.GUI;

import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import tp.DAO.*;
import tp.clases.*;
import tp.enums.*;


public class PanelAltaCompetencia extends JPanel {
	
	public enum Modalidad { LIGA, ELIMINACIONSIMPLE, ELIMINACIONDOBLE };

	//Aqui se definen los atributos de la competencia
	private String deporteCompetencia;
	private Integer id_deporte;
	private String nombreCompetencia;
	private tp.enums.Modalidad modalidadCompetencia;
	private String reglamentoCompetencia;
	private EstadoCompetencia estadoCompetencia;
	private Integer cantSets = null;
	private ModalidadDePuntuacion puntuacion;
	private Double tantosXAusencia;
	private Boolean empate;
	private Double puntosPartidoGanado;
	private Double puntosPresentarse;
	private Double puntosEmpate;
	private Integer id_usuario = 6;
	private Competencia competencia;
	
	//DAOs
	private CompetenciaDAO competenciaDao = new CompetenciaDAO();
	private DeporteDAO deporteDao = new DeporteDAO();
	
	//Aqui se definen los componentes del Panel
	private JTextField txtNombre;
	private JTextField txtCantidadSets;
	private JTextField txtTantosAusencia;
	private JTextField txtPuntosPartidoGanado;
	private JTextField txtPuntosEmpate;
	private JTextField txtPuntosPresentarse;
	private JComboBox<Modalidad> boxModalidad;
	private JComboBox<String> boxDeporte;
	private JRadioButton rdbtnSets;
	private JRadioButton rdbtnPuntuacion;
	private JRadioButton rdbtnPuntuacionFinal;
	private JRadioButton rdbtnEmpate;
	private JButton btnConfirmar; 
	private JButton btnModificarLugar;
	private JTable tableLugares;
	private boolean ingresoNombre = false;
	private boolean ingresoDeporte = false;
	private boolean ingresoModalidad = false;
	private boolean ingresoCantidadSets = false;
	private boolean ingresoTantosXAusencia = false;
	private boolean ingresoPuntosEmpate = false;

	//Define el Table model
	AltaCompetenciaTM tableModel  = new AltaCompetenciaTM();

	public PanelAltaCompetencia(MainApplication m) {
		initialize(m);
	}

	private void initialize(MainApplication m) {
		
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
		
		setBackground(new Color(153, 204, 255));
		m.setTitle("ALTA COMPETENCIA");
		setBounds(100, 50, 1280, 720);
		setLayout(null);

		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
//		btnConfirmar.setEnabled(true);
		btnConfirmar.setBackground(new Color(102, 102, 255));
		
		JLabel lblNombre = new JLabel("Nombre *");
		lblNombre.setBounds(10, 11, 152, 21);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNombre);
		
		//Campo de texto de nombre
		txtNombre = new JTextField();
		txtNombre.setMinimumSize(new Dimension(15, 28));
		txtNombre.setPreferredSize(new Dimension(15, 30));
		txtNombre.setBounds(10, 31, 514, 30);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				txtNombre.setText(txtNombre.getText().toUpperCase());

				int code=e.getKeyCode();
				if(code==KeyEvent.VK_BACK_SPACE) {
					txtNombre.setText(txtNombre.getText());
				}
				
//				TODO validaciones
				ingresoNombre = (txtNombre.getText() != "");
				ingresoDeporte = (boxDeporte.getSelectedItem() != "----Seleccionar----");
				ingresoModalidad = ( boxModalidad.getSelectedItem() != "----Seleccionar----" );
				ingresoCantidadSets = (txtCantidadSets.getText() != "");
				ingresoPuntosEmpate = (txtPuntosEmpate.getText() != "");
				ingresoTantosXAusencia = ( txtTantosAusencia.getText() != "" );
				
				if(ingresoNombre && ingresoDeporte && ingresoModalidad) {
					if(rdbtnSets.isSelected()) {
						if(ingresoCantidadSets) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
					if(boxModalidad.getSelectedItem() == "Liga") {
						if(ingresoTantosXAusencia) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
					if(rdbtnEmpate.isSelected()) {
						if(ingresoPuntosEmpate) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
				} else {
					btnConfirmar.setEnabled(false);
				}
			}
		});
		
		JLabel lblDeporte = new JLabel("Deporte *");
		lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDeporte.setBounds(10, 69, 115, 25);
		add(lblDeporte);
		//JBox de deporte
		boxDeporte = new JComboBox<String>();
		DeporteDAO deporteDao = new DeporteDAO();
		boxDeporte.setModel(new DefaultComboBoxModel<String>()); //Pide a la BD todos los nombre de los deportes y los asigna al ComboBox
		boxDeporte.addItem("----Seleccionar----");
		for(String s : deporteDao.getNombres()) {
			boxDeporte.addItem(s);
		}
		boxDeporte.setBounds(10, 96, 232, 30);
		add(boxDeporte);
		boxDeporte.addActionListener( a -> {
			this.tableModel.vaciarTabla(); //En caso de cambiar de deporte vacía la tabla
			this.tableLugares.updateUI();
			btnModificarLugar.setEnabled(false);
			
//			TODO validaciones
			ingresoNombre = (txtNombre.getText() != "");
			ingresoDeporte = (boxDeporte.getSelectedItem() != "----Seleccionar----");
			ingresoModalidad = ( boxModalidad.getSelectedItem() != "----Seleccionar----" );
			ingresoCantidadSets = (txtCantidadSets.getText() != "");
			ingresoPuntosEmpate = (txtPuntosEmpate.getText() != "");
			ingresoTantosXAusencia = ( txtTantosAusencia.getText() != "" );
			
			if(ingresoNombre && ingresoDeporte && ingresoModalidad) {
				if(rdbtnSets.isSelected()) {
					if(ingresoCantidadSets) btnConfirmar.setEnabled(true);
					else btnConfirmar.setEnabled(false);
				} else btnConfirmar.setEnabled(true);
				
				if(boxModalidad.getSelectedItem() == "Liga") {
					if(ingresoTantosXAusencia) btnConfirmar.setEnabled(true);
					else btnConfirmar.setEnabled(false);
				} else btnConfirmar.setEnabled(true);
				
				if(rdbtnEmpate.isSelected()) {
					if(ingresoPuntosEmpate) btnConfirmar.setEnabled(true);
					else btnConfirmar.setEnabled(false);
				} else btnConfirmar.setEnabled(true);
				
			} else {
				btnConfirmar.setEnabled(false);
			}
		});
		
		
		JLabel lblModalidad = new JLabel("Modalidad *");
		lblModalidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblModalidad.setBounds(254, 69, 115, 22);
		add(lblModalidad);
		
		//JBox modalidad
		boxModalidad = new JComboBox<Modalidad>();
		boxModalidad.setModel(new DefaultComboBoxModel(new String[] {"----Seleccionar----", "Liga", "Eliminacion Simple", "Eliminacion Doble"}));
		boxModalidad.setBounds(254, 96, 270, 30);
		add(boxModalidad);
		
		boxModalidad.addActionListener( a -> {// habilita las entradas de puntuacion
			if(boxModalidad.getSelectedItem()=="Liga") {

				btnConfirmar.setEnabled(false);
				txtPuntosPartidoGanado.setEnabled(true);
				txtPuntosPresentarse.setEnabled(true);
				rdbtnEmpate.setEnabled(true);
				txtTantosAusencia.setEnabled(true);
			} else {
				txtPuntosPartidoGanado.setEnabled(false);
				txtPuntosPartidoGanado.setText("");
				txtPuntosPresentarse.setEnabled(false);
				txtPuntosPresentarse.setText("");
				txtTantosAusencia.setEnabled(true);
				txtTantosAusencia.setText("");
				rdbtnEmpate.setEnabled(false);
				rdbtnEmpate.setSelected(false);
				txtPuntosEmpate.setText("");
				txtPuntosEmpate.setEnabled(false);
				
//				TODO validaciones
				ingresoNombre = (txtNombre.getText() != "");
				ingresoDeporte = (boxDeporte.getSelectedItem() != "----Seleccionar----");
				ingresoModalidad = ( boxModalidad.getSelectedItem() != "----Seleccionar----" );
				ingresoCantidadSets = (txtCantidadSets.getText() != "");
				ingresoPuntosEmpate = (txtPuntosEmpate.getText() != "");
				ingresoTantosXAusencia = ( txtTantosAusencia.getText() != "" );
				
				if(ingresoNombre && ingresoDeporte && ingresoModalidad) {
					if(rdbtnSets.isSelected()) {
						if(ingresoCantidadSets) {
							btnConfirmar.setEnabled(true);
						}
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
					if(rdbtnEmpate.isSelected()) {
						if(ingresoPuntosEmpate) {	
							btnConfirmar.setEnabled(true);
						}
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
				} else {
					btnConfirmar.setEnabled(false);
				}
			}
		});
		
		JLabel lblFormaPuntuacion = new JLabel("Forma de Puntuaci\u00F3n");
		lblFormaPuntuacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFormaPuntuacion.setBounds(10, 224, 190, 30);
		add(lblFormaPuntuacion);

		
		JLabel lblCantidadSets = new JLabel("Cantidad de Sets ");
		lblCantidadSets.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidadSets.setBounds(10, 307, 152, 30);
		add(lblCantidadSets);
		//Indica cantidad de sets
		txtCantidadSets = new JTextField();
		txtCantidadSets.setBounds(174, 311, 40, 26);
		add(txtCantidadSets);
		txtCantidadSets.setColumns(10);
		txtCantidadSets.setEnabled(false);
		
		txtCantidadSets.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Character c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					txtCantidadSets.setText(reparse(txtCantidadSets.getText()));
				}
				
				int code=e.getKeyCode();
				if(code==KeyEvent.VK_BACK_SPACE) {
					txtCantidadSets.setText(txtCantidadSets.getText());
				}
				
//				TODO validaciones
				ingresoNombre = (txtNombre.getText() != "");
				ingresoDeporte = (boxDeporte.getSelectedItem() != "----Seleccionar----");
				ingresoModalidad = ( boxModalidad.getSelectedItem() != "----Seleccionar----" );
				ingresoCantidadSets = (txtCantidadSets.getText() != "");
				ingresoPuntosEmpate = (txtPuntosEmpate.getText() != "");
				ingresoTantosXAusencia = ( txtTantosAusencia.getText() != "" );
				
				if(ingresoNombre && ingresoDeporte && ingresoModalidad) {
					if(rdbtnSets.isSelected()) {
						if(ingresoCantidadSets) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
					if(boxModalidad.getSelectedItem() == "Liga") {
						if(ingresoTantosXAusencia) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
					if(rdbtnEmpate.isSelected()) {
						if(ingresoPuntosEmpate) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
				} else {
					btnConfirmar.setEnabled(false);
				}
			}
		});

		
		txtTantosAusencia = new JTextField();
		txtTantosAusencia.setEnabled(false);
		txtTantosAusencia.setBounds(456, 311, 40, 26);
		add(txtTantosAusencia);
		txtTantosAusencia.setColumns(10);
		
		//ignora el ingreso de caracteres no numericos
		txtTantosAusencia.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Character c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					txtTantosAusencia.setText(reparse(txtTantosAusencia.getText()));
				}
				
				int code=e.getKeyCode();
				if(code==KeyEvent.VK_BACK_SPACE) {
					txtTantosAusencia.setText(txtTantosAusencia.getText());
				}
				
//				TODO validaciones
				ingresoNombre = (txtNombre.getText() != "");
				ingresoDeporte = (boxDeporte.getSelectedItem() != "----Seleccionar----");
				ingresoModalidad = ( boxModalidad.getSelectedItem() != "----Seleccionar----" );
				ingresoCantidadSets = (txtCantidadSets.getText() != "");
				ingresoPuntosEmpate = (txtPuntosEmpate.getText() != "");
				ingresoTantosXAusencia = ( txtTantosAusencia.getText() != "");
				
				if(ingresoNombre && ingresoDeporte && ingresoModalidad) {
					if(rdbtnSets.isSelected()) {
						if(ingresoCantidadSets) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
					
					if(ingresoTantosXAusencia) {
						btnConfirmar.setEnabled(true);
					}
					else btnConfirmar.setEnabled(false);
					
					if(rdbtnEmpate.isSelected()) {
						if(ingresoPuntosEmpate) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
				} else {
					btnConfirmar.setEnabled(false);
				}
			}
		});
		
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
		
		//ignora el ingreso de caracteres no numericos
		txtPuntosPartidoGanado.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Character c = e.getKeyChar();
				if(!Character.isDigit(c)) { // TODO Falta Capturar la exception cuando esta vacio
					txtPuntosPartidoGanado.setText(reparse(txtPuntosPartidoGanado.getText()));
				}
				
				int code=e.getKeyCode();
				if(code==KeyEvent.VK_BACK_SPACE) {
					txtPuntosPartidoGanado.setText(txtPuntosPartidoGanado.getText());
				}
			}
		});
		
		JLabel lblPuntosEmpate = new JLabel("Puntos por Empate");
		lblPuntosEmpate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPuntosEmpate.setBounds(560, 155, 165, 24);
		add(lblPuntosEmpate);
		
		
		txtPuntosEmpate = new JTextField();
		txtPuntosEmpate.setEnabled(false);
		txtPuntosEmpate.setBounds(724, 156, 40, 26);
		add(txtPuntosEmpate);
		txtPuntosEmpate.setColumns(10);
		
		//ignora el ingreso de caracteres no numericos
		txtPuntosEmpate.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Character c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					txtPuntosEmpate.setText(reparse(txtPuntosEmpate.getText()));
				}
				
				int code=e.getKeyCode();
				if(code==KeyEvent.VK_BACK_SPACE) {
					txtPuntosEmpate.setText(txtPuntosEmpate.getText());
				}
				
//				TODO validaciones
				ingresoNombre = (txtNombre.getText() != "");
				ingresoDeporte = (boxDeporte.getSelectedItem() != "----Seleccionar----");
				ingresoModalidad = ( boxModalidad.getSelectedItem() != "----Seleccionar----" );
				ingresoCantidadSets = (txtCantidadSets.getText() != "");
				ingresoPuntosEmpate = (txtPuntosEmpate.getText() != "");
				ingresoTantosXAusencia = ( txtTantosAusencia.getText() != "" );
				
				if(ingresoNombre && ingresoDeporte && ingresoModalidad) {
					if(rdbtnSets.isSelected()) {
						if(ingresoCantidadSets) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
					if(boxModalidad.getSelectedItem() == "Liga") {
						if(ingresoTantosXAusencia) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
					if(rdbtnEmpate.isSelected()) {
						if(ingresoPuntosEmpate) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
				} else {
					btnConfirmar.setEnabled(false);
				}
				
			} 
		});
		
		rdbtnEmpate = new JRadioButton("Empate");
		rdbtnEmpate.setFont(new Font("SansSerif", Font.PLAIN, 16));
		rdbtnEmpate.setEnabled(false);
		rdbtnEmpate.setBounds(559, 130, 89, 23);
		add(rdbtnEmpate);
		
		rdbtnEmpate.addActionListener( a -> {
			if (rdbtnEmpate.isSelected()) {
				txtPuntosEmpate.setEnabled(true);
				empate = true;
			} else {
				txtPuntosEmpate.setEnabled(false);
				txtPuntosEmpate.setText("");
				empate = false;
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
		
		//ignora el ingreso de caracteres no numericos
		txtPuntosPresentarse.addKeyListener(new java.awt.event.KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				Character c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					txtPuntosPresentarse.setText(reparse(txtPuntosPresentarse.getText()));
				}
				
				int code=e.getKeyCode();
				if(code==KeyEvent.VK_BACK_SPACE) {
					txtPuntosPresentarse.setText(reparse(txtPuntosPresentarse.getText()));
				}
			} 
		});
		
		rdbtnSets = new JRadioButton("Sets");
		rdbtnSets.setFont(new Font("SansSerif", Font.PLAIN, 18));
		rdbtnSets.setBounds(10, 260, 115, 18);
		add(rdbtnSets);
		
		rdbtnPuntuacion = new JRadioButton("Puntuacion");
		rdbtnPuntuacion.setFont(new Font("SansSerif", Font.PLAIN, 18));
		rdbtnPuntuacion.setBounds(291, 260, 115, 18);
		rdbtnPuntuacion.setSelected(true);
		add(rdbtnPuntuacion);
		
		rdbtnPuntuacionFinal = new JRadioButton("Puntuacion Final");
		rdbtnPuntuacionFinal.setFont(new Font("SansSerif", Font.PLAIN, 18));
		rdbtnPuntuacionFinal.setBounds(560, 260, 175, 18);
		add(rdbtnPuntuacionFinal);
		
		rdbtnSets.addActionListener( a -> {
			rdbtnPuntuacion.setSelected(false);
			rdbtnPuntuacionFinal.setSelected(false);
			txtCantidadSets.setEnabled(true);
			txtTantosAusencia.setText("");
			
			if(!rdbtnPuntuacion.isSelected() && !rdbtnPuntuacionFinal.isSelected()) {
				rdbtnSets.setSelected(true);
			}
		});
		
		rdbtnPuntuacion.addActionListener( a -> {
			rdbtnSets.setSelected(false);
			rdbtnPuntuacionFinal.setSelected(false);
			txtCantidadSets.setEnabled(false);
			txtCantidadSets.setText("");
			
			if(!rdbtnSets.isSelected() && !rdbtnPuntuacionFinal.isSelected()) {
				rdbtnPuntuacion.setSelected(true);
			}
		});
		
		rdbtnPuntuacionFinal.addActionListener( a -> {
			rdbtnSets.setSelected(false);
			rdbtnPuntuacion.setSelected(false);
			txtCantidadSets.setEnabled(false);
			txtCantidadSets.setText("");
			txtTantosAusencia.setText("");
			
			if(!rdbtnSets.isSelected() && !rdbtnPuntuacion.isSelected()) {
				rdbtnPuntuacionFinal.setSelected(true);
			}
		});
		
		
//		JSplitPane splitLugar = new JSplitPane();
//		JOptionPane.showMessageDialog(null, msg);
		
		JSplitPane splitCancelarConfirmar = new JSplitPane();
		splitCancelarConfirmar.setDividerSize(0);
		splitCancelarConfirmar.setBounds(1026, 667, 232, 30);
		add(splitCancelarConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener( a -> {
			m.cambiarPanel(new PanelHome(m));
		});
		splitCancelarConfirmar.setRightComponent(btnConfirmar);
		splitCancelarConfirmar.setLeftComponent(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(204, 204, 204));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(802, 11, 456, 562);
		add(scrollPane);
		
		tableLugares = new JTable();	
		tableLugares.setModel(tableModel);	//tableModel se define arriba en los atributos
		tableLugares.getColumnModel().getColumn(0).setResizable(false);
		tableLugares.getColumnModel().getColumn(0).setPreferredWidth(25);
		tableLugares.getColumnModel().getColumn(1).setResizable(false);
		tableLugares.getColumnModel().getColumn(1).setPreferredWidth(150);
		scrollPane.setViewportView(tableLugares);
		
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
		
		btnModificarLugar = new JButton("Modificar Lugar");
		btnModificarLugar.setEnabled(false);
		splitPane.setLeftComponent(btnModificarLugar);
		
		JButton btnAgregarLugar = new JButton("Agregar Lugar");
		splitPane.setRightComponent(btnAgregarLugar);
		
		JLabel lblCantidadTantos = new JLabel("Tantos por ausencia");
		lblCantidadTantos.setToolTipText("");
		lblCantidadTantos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidadTantos.setBounds(276, 311, 190, 26);
		add(lblCantidadTantos);
		
		btnAgregarLugar.addActionListener( a -> {
			DialogAltaLugar dialogAltaLugar = new DialogAltaLugar(this);
		});
		
		
		//Al confirmar, se asignan todos los valores ingresados
		btnConfirmar.addActionListener( a -> {
			nombreCompetencia = txtNombre.getText();
			deporteCompetencia = (String) boxDeporte.getSelectedItem();
			try {
				cantSets = Integer.parseInt(txtCantidadSets.getText());
			}
			catch(Exception e) {
				cantSets = null;
			}
			try {
			tantosXAusencia = Double.parseDouble(txtTantosAusencia.getText());
			}
			catch(Exception e) {
				tantosXAusencia = null;
			}
			try {
			puntosPartidoGanado = Double.parseDouble(txtPuntosPartidoGanado.getText());
			}
			catch(Exception e) {
				puntosPartidoGanado = null;
			}
			try {
			puntosEmpate = Double.parseDouble(txtPuntosEmpate.getText());
			} 
			catch(Exception e) {
				puntosEmpate = null;
			}
			try {
			puntosPresentarse = Double.parseDouble(txtPuntosPresentarse.getText());
			}
			catch(Exception e) {
				puntosPresentarse = null;
			}
			reglamentoCompetencia = txtReglamento.getText();
			
			//Set de modalidad de competencia
			switch((String)boxModalidad.getSelectedItem()) {
			case "Liga": modalidadCompetencia = tp.enums.Modalidad.LIGA;
				break;
			case "Eliminacion Simple": modalidadCompetencia = tp.enums.Modalidad.ELIMINACION_DIRECTA;
				break;
			case "Eliminacion Doble": modalidadCompetencia = tp.enums.Modalidad.ELIMINACION_DOBLE;
			}
			//Set de Modalidad de Puntuacion
			if(rdbtnSets.isSelected()) {
				this.puntuacion = ModalidadDePuntuacion.SETS;
			}else if(rdbtnPuntuacion.isSelected()) {
				this.puntuacion = ModalidadDePuntuacion.PUNTUACION;
				this.cantSets = 0;
			}else if(rdbtnPuntuacionFinal.isSelected()) {
				this.puntuacion = ModalidadDePuntuacion.PUNTUACION_FINAL;
				this.cantSets = 0;
			}
			//Set de idDeporte
			id_deporte = deporteDao.getIDbyNombre(this.boxDeporte.getSelectedItem().toString());
			
			switch(modalidadCompetencia) {
			case LIGA:
				 competencia = new CompetenciaLiga(nombreCompetencia, modalidadCompetencia,
						null, null, cantSets, reglamentoCompetencia, 
						puntuacion, tantosXAusencia,this.id_usuario,
						id_deporte, null,this.tableModel.getData());
				 break;
			case ELIMINACION_DIRECTA:
				 competencia = new CompetenciaEliminacionSimple( nombreCompetencia, modalidadCompetencia,
						null, null, cantSets, reglamentoCompetencia, estadoCompetencia,
						puntuacion, tantosXAusencia, this.id_usuario, id_deporte, this.tableModel.getData());
				 break;
			case ELIMINACION_DOBLE:
				 competencia = new CompetenciaEliminacionDoble( nombreCompetencia, modalidadCompetencia, null,
						null, cantSets, reglamentoCompetencia, estadoCompetencia, puntuacion, tantosXAusencia, this.id_usuario, id_deporte, this.tableModel.getData());
				 	break;
			}
			
//			System.out.println("Nombre: "+nombreCompetencia);
//			System.out.println("Deporte: "+deporteCompetencia);
//			System.out.println(modalidadCompetencia);
//			System.out.println("Sets: "+cantSets);
//			System.out.println("Ausencia: "+tantosXAusencia);
//			System.out.println("Puntos Ganado: "+puntosPartidoGanado);
//			System.out.println("Puntos Empate: "+puntosEmpate);
//			System.out.println("Puntos Presentarse: "+puntosPresentarse);
//			System.out.println("Reglamento: "+reglamentoCompetencia);
			
			this.competenciaDao.Save(competencia);
		});
		
	}
	
	public String reparse(String str) {
		String aux="";
		for(int i=0; i<str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) aux+=str.charAt(i);
		}
		return aux;
	} 

	public String getDeporteCompetencia() {
		return this.boxDeporte.getSelectedItem().toString();
	}

	public void setDeporteCompetencia(String deporteCompetencia) {
		this.deporteCompetencia = deporteCompetencia;
	}

	public Integer getId_deporte() {
		return id_deporte;
	}

	public void setId_deporte(Integer id_deporte) {
		this.id_deporte = id_deporte;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public void addItemTM(ItemLugar item) { // este metodo agrega el item para la tabla 
		this.tableModel.addItemTM(item);
		this.tableLugares.updateUI();
	}
}
