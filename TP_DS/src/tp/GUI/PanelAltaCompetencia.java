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
	private Optional<Integer> cantSets = null;
	private ModalidadDePuntuacion puntuacion;
	private Double tantosXAusencia;
	private Boolean empate;
	private Double puntosPartidoGanado;
	private Double puntosPresentarse;
	private Double puntosEmpate;
	private Integer id_usuario = 6;
	
	//Aqui se definen los componentes del Panel
	private JTextField txtNombre;
	private JTextField txtCantidadSets;
	private JTextField txtTantosAusencia;
	private JTextField txtPuntosPartidoGanado;
	private JTextField txtPuntosEmpate;
	private JTextField txtPuntosPresentarse;
	private JRadioButton rdbtnSets;
	private JRadioButton rdbtnPuntuacion;
	private JRadioButton rdbtnPuntuacionFinal;
	private JButton btnConfirmar; 
	private JButton btnModificarLugar;
	private JTable tableLugares;
	private boolean ingresoNombre = false;
	private boolean ingresoDeporte = false;
	private boolean ingresoModalidad = false;
	private boolean ingresoCantidadSets = false;
	private boolean ingresoTantosXAusencia = false;

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
				nombreCompetencia = txtNombre.getText();
				
				ingresoNombre = (txtNombre.getText().length()>0);
				if(ingresoNombre && ingresoDeporte && ingresoModalidad) {
					if(rdbtnSets.isSelected() && ingresoCantidadSets) {
						btnConfirmar.setEnabled(true);
					}
					if(modalidadCompetencia == tp.enums.Modalidad.LIGA && ingresoTantosXAusencia) {
						btnConfirmar.setEnabled(true);
					}
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
		JComboBox<String> boxDeporte = new JComboBox<String>();
		DeporteDAO deporteDao = new DeporteDAO();
		boxDeporte.setModel(new DefaultComboBoxModel<String>()); //Pide a la BD todos los nombre de los deportes y los asigna al ComboBox
		boxDeporte.addItem("----Seleccionar----");
		for(String s : deporteDao.getNombres()) {
			boxDeporte.addItem(s);
		}
		boxDeporte.setBounds(10, 96, 232, 30);
		add(boxDeporte);
		ingresoDeporte = false;
		boxDeporte.addActionListener( a -> {
			deporteCompetencia = (String) boxDeporte.getSelectedItem();
			this.tableModel.vaciarTabla(); //En caso de cambiar de deporte vacía la tabla
			this.tableLugares.updateUI();
			btnModificarLugar.setEnabled(false);
			
			ingresoDeporte = ( boxDeporte.getSelectedItem() != "----Seleccionar----" );
			if(ingresoNombre && ingresoDeporte && ingresoModalidad) {
				if(rdbtnSets.isSelected() && ingresoCantidadSets) {
					btnConfirmar.setEnabled(true);
				}
				if(modalidadCompetencia == tp.enums.Modalidad.LIGA && ingresoTantosXAusencia) {
					btnConfirmar.setEnabled(true);
				}
			} else {
				btnConfirmar.setEnabled(false);
			}
		});
		
		
		JLabel lblModalidad = new JLabel("Modalidad *");
		lblModalidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblModalidad.setBounds(254, 69, 115, 22);
		add(lblModalidad);
		//JBox modalidad
		JComboBox<Modalidad> boxModalidad = new JComboBox<Modalidad>();
		boxModalidad.setModel(new DefaultComboBoxModel(new String[] {"----Seleccionar----", "Liga", "Eliminacion Simple", "Eliminacion Doble"}));
		boxModalidad.setBounds(254, 96, 270, 30);
		add(boxModalidad);
		boxModalidad.addActionListener( a -> {
			switch((String)boxModalidad.getSelectedItem()) {
			case "Liga": modalidadCompetencia = tp.enums.Modalidad.LIGA;
				break;
			case "Eliminacion Simple": modalidadCompetencia = tp.enums.Modalidad.ELIMINACION_DIRECTA;
				break;
			case "Eliminacion Doble": modalidadCompetencia = tp.enums.Modalidad.ELIMINACION_DOBLE;
			}
			
			ingresoModalidad = ( boxModalidad.getSelectedItem() != "----Seleccionar----" ); //  <-- es buena practica?
			if(ingresoNombre && ingresoDeporte && ingresoModalidad) {
				if(rdbtnSets.isSelected() && ingresoCantidadSets) {
					btnConfirmar.setEnabled(true);
				}
				if(modalidadCompetencia == tp.enums.Modalidad.LIGA && ingresoTantosXAusencia) {
					btnConfirmar.setEnabled(true);
				}
			} else {
				btnConfirmar.setEnabled(false);
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
		
		txtCantidadSets.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Character c = e.getKeyChar();
				if(!c.isDigit(c)) {
					txtCantidadSets.setText(txtCantidadSets.getText().substring(0, txtCantidadSets.getText().length()-1));
				} else cantSets = Optional.of(Integer.parseInt(txtCantidadSets.getText()));
				
				ingresoCantidadSets = (cantSets != null);
				if(ingresoNombre && ingresoDeporte && ingresoModalidad) {
					if(rdbtnSets.isSelected() && ingresoCantidadSets) {
						btnConfirmar.setEnabled(true);
					} 
					if(modalidadCompetencia == tp.enums.Modalidad.LIGA && ingresoTantosXAusencia) {
						btnConfirmar.setEnabled(true);
					}
				} else {
					btnConfirmar.setEnabled(false);
				}
			} 
		});

		
		txtTantosAusencia = new JTextField();
		txtTantosAusencia.setEnabled(false);
		txtTantosAusencia.setBounds(478, 311, 40, 26);
		add(txtTantosAusencia);
		txtTantosAusencia.setColumns(10);
		
		//ignora el ingreso de caracteres no numericos
		txtTantosAusencia.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Character c = e.getKeyChar();
				if(!c.isDigit(c)) {
					txtTantosAusencia.setText(txtTantosAusencia.getText().substring(0, txtTantosAusencia.getText().length()-1));
				} else tantosXAusencia = Double.parseDouble(txtTantosAusencia.getText());
				
				
				ingresoTantosXAusencia = ( tantosXAusencia != null );
				if(ingresoNombre && ingresoDeporte && ingresoModalidad) {
					if(rdbtnSets.isSelected() && ingresoCantidadSets) {
						btnConfirmar.setEnabled(true);
					}
					if(modalidadCompetencia == tp.enums.Modalidad.LIGA && ingresoTantosXAusencia) {
						btnConfirmar.setEnabled(true);
					}
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
				if(!c.isDigit(c)) {
					txtPuntosPartidoGanado.setText(txtPuntosPartidoGanado.getText().substring(0, txtPuntosPartidoGanado.getText().length()-1));
				} else puntosPartidoGanado = Double.parseDouble(txtPuntosPartidoGanado.getText());
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
				if(!c.isDigit(c)) {
					txtPuntosEmpate.setText(txtPuntosEmpate.getText().substring(0, txtPuntosEmpate.getText().length()-1));
				} else puntosEmpate = Double.parseDouble(txtPuntosEmpate.getText());
			} 
		});
		
		JRadioButton rdbtnEmpate = new JRadioButton("Empate");
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
				if(!c.isDigit(c)) {
					txtPuntosPresentarse.setText(txtPuntosPresentarse.getText().substring(0, txtPuntosPresentarse.getText().length()-1));
				} else puntosPresentarse = Double.parseDouble(txtPuntosPresentarse.getText());
			} 
		});
		
		boxModalidad.addActionListener( a -> {// habilita las entradas de puntuacion
			if(boxModalidad.getSelectedItem()=="Liga" ) {
				txtPuntosPartidoGanado.setEnabled(true);
				txtPuntosPresentarse.setEnabled(true);
				rdbtnEmpate.setEnabled(true);
				this.txtTantosAusencia.setEnabled(true);
			} else {
				txtPuntosPartidoGanado.setEnabled(false);
				txtPuntosPartidoGanado.setText("");
				txtPuntosPresentarse.setEnabled(false);
				txtPuntosPresentarse.setText("");
				this.txtTantosAusencia.setEnabled(false);
				rdbtnEmpate.setEnabled(false);
			}
		});
		
		rdbtnSets = new JRadioButton("Sets");
		rdbtnSets.setSelected(true);
		rdbtnSets.setFont(new Font("SansSerif", Font.PLAIN, 18));
		rdbtnSets.setBounds(10, 260, 115, 18);
		add(rdbtnSets);
		
		rdbtnPuntuacion = new JRadioButton("Puntuacion");
		rdbtnPuntuacion.setFont(new Font("SansSerif", Font.PLAIN, 18));
		rdbtnPuntuacion.setBounds(291, 260, 115, 18);
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
		});
		
		rdbtnPuntuacion.addActionListener( a -> {
			rdbtnSets.setSelected(false);
			rdbtnPuntuacionFinal.setSelected(false);
			txtCantidadSets.setEnabled(false);
			txtCantidadSets.setText("");
		});
		
		rdbtnPuntuacionFinal.addActionListener( a -> {
			rdbtnSets.setSelected(false);
			rdbtnPuntuacion.setSelected(false);
			txtCantidadSets.setEnabled(false);
			txtCantidadSets.setText("");
			txtTantosAusencia.setText("");
		});
		
		
		JSplitPane splitLugar = new JSplitPane();
		
		JSplitPane splitCancelarConfirmar = new JSplitPane();
		splitCancelarConfirmar.setDividerSize(0);
		splitCancelarConfirmar.setBounds(1026, 684, 232, 30);
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
		txtReglamento.addKeyListener(new java.awt.event.KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				txtReglamento.setText(txtReglamento.getText().toUpperCase());
				reglamentoCompetencia = txtReglamento.getText();
			}
		});
		

		
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
		
		JLabel lblCantidadTantos = new JLabel("Tantos por ausencia *");
		lblCantidadTantos.setToolTipText("");
		lblCantidadTantos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidadTantos.setBounds(276, 311, 190, 26);
		add(lblCantidadTantos);
		btnAgregarLugar.addActionListener( a -> {
			DialogAltaLugar dialogAltaLugar = new DialogAltaLugar(this);
		});
		
		
		//por ultimo se da de alta la competencia con sus datos

		btnConfirmar.addActionListener( a -> {
			switch(modalidadCompetencia) {
			case LIGA:
				CompetenciaLiga competencia = new CompetenciaLiga(00, nombreCompetencia, modalidadCompetencia,
						null, null, cantSets, reglamentoCompetencia, EstadoCompetencia.CREADA,
						puntuacion, tantosXAusencia, null,
						id_deporte, null);
			case ELIMINACION_DIRECTA:
				CompetenciaEliminacionSimple competencia1 = new CompetenciaEliminacionSimple(00, nombreCompetencia, modalidadCompetencia,
						null, null, cantSets, reglamentoCompetencia, estadoCompetencia,
						puntuacion, tantosXAusencia, null, id_deporte);
			case ELIMINACION_DOBLE:
				CompetenciaEliminacionDoble competencia2 = new CompetenciaEliminacionDoble(00, nombreCompetencia, modalidadCompetencia, null,
						null, cantSets, reglamentoCompetencia, estadoCompetencia, puntuacion, tantosXAusencia, null, id_deporte);
			}
		});
		
	}

	public String getDeporteCompetencia() {
		return deporteCompetencia;
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
	
	private void ingresoIvalido(KeyEvent e, String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}


}
