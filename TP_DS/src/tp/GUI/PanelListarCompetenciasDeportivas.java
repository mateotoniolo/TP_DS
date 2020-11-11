package tp.GUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import tp.enums.EstadoCompetencia;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class PanelListarCompetenciasDeportivas extends JPanel {

	private Component btnConfirmar;
	private JTable tablaCompetencias;
	private JTextField txtNombre;
	private JTable table;

	public PanelListarCompetenciasDeportivas(MainApplication m) {
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
		
		setBackground(Color.WHITE);
		m.setTitle("BUSCAR COMPETENCIA");
		setBounds(100, 50, 1280, 720);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 230));
		panel.setBackground(new Color(153, 204, 255));
		add(panel, BorderLayout.NORTH);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		txtNombre = new JTextField();
		txtNombre.setPreferredSize(new Dimension(13, 30));
		txtNombre.setColumns(10);
		
		JLabel lblModalidad = new JLabel("Modalidad");
		lblModalidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JComboBox boxModalidad = new JComboBox();
		boxModalidad.setPreferredSize(new Dimension(33, 30));
		boxModalidad.setModel(new DefaultComboBoxModel(new String[] {"---Seleccionar---"}));
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JComboBox boxDeporte = new JComboBox();
		boxDeporte.setPreferredSize(new Dimension(33, 30));
		boxDeporte.setModel(new DefaultComboBoxModel(new String[] {"---Seleccionar---"}));
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setPreferredSize(new Dimension(33, 30));
		comboBox.setModel(new DefaultComboBoxModel(EstadoCompetencia.values()));
		
		JSplitPane paneBuscarSalir = new JSplitPane();
		paneBuscarSalir.setDividerSize(0);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(209)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(boxModalidad, 0, 391, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(boxDeporte, Alignment.TRAILING, 0, 467, Short.MAX_VALUE)
								.addComponent(lblNombre, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
								.addComponent(lblDeporte))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEstado)
								.addComponent(lblModalidad)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(paneBuscarSalir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)))))
					.addGap(210))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNombre)
						.addComponent(lblModalidad))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(boxModalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEstado)
						.addComponent(lblDeporte))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(boxDeporte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(paneBuscarSalir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
		JButton btnBuscar = new JButton("Buscar");
		paneBuscarSalir.setLeftComponent(btnBuscar);
		
		JButton btnSalir = new JButton("Salir");
		paneBuscarSalir.setRightComponent(btnSalir);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollTablaCompetencias = new JScrollPane();
		add(scrollTablaCompetencias, BorderLayout.CENTER);
		
		tablaCompetencias = new JTable();
		scrollTablaCompetencias.setViewportView(tablaCompetencias);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(200, 10));
		panel_1.setBackground(Color.WHITE);
		add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(200, 10));
		panel_2.setBackground(Color.WHITE);
		add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setPreferredSize(new Dimension(10, 50));
		add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		table = new JTable();
		table.setBackground(Color.BLUE);
		table.setShowVerticalLines(true);
		table.setRowHeight(20);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"<", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ">"},
			},
			new String[] {
				"<", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ">"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setMinWidth(20);
		table.getColumnModel().getColumn(1).setMaxWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setMinWidth(20);
		table.getColumnModel().getColumn(2).setMaxWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setMinWidth(20);
		table.getColumnModel().getColumn(3).setMaxWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setMinWidth(20);
		table.getColumnModel().getColumn(4).setMaxWidth(20);
		table.getColumnModel().getColumn(5).setPreferredWidth(20);
		table.getColumnModel().getColumn(5).setMinWidth(20);
		table.getColumnModel().getColumn(5).setMaxWidth(0);
		table.getColumnModel().getColumn(6).setPreferredWidth(20);
		table.getColumnModel().getColumn(6).setMinWidth(20);
		table.getColumnModel().getColumn(6).setMaxWidth(20);
		table.getColumnModel().getColumn(7).setPreferredWidth(20);
		table.getColumnModel().getColumn(7).setMinWidth(20);
		table.getColumnModel().getColumn(7).setMaxWidth(20);
		table.getColumnModel().getColumn(8).setPreferredWidth(20);
		table.getColumnModel().getColumn(8).setMinWidth(20);
		table.getColumnModel().getColumn(8).setMaxWidth(20);
		table.getColumnModel().getColumn(9).setPreferredWidth(20);
		table.getColumnModel().getColumn(9).setMinWidth(20);
		table.getColumnModel().getColumn(9).setMaxWidth(20);
		table.getColumnModel().getColumn(10).setPreferredWidth(20);
		table.getColumnModel().getColumn(10).setMinWidth(20);
		table.getColumnModel().getColumn(10).setMaxWidth(20);
		table.getColumnModel().getColumn(11).setPreferredWidth(30);
		table.getColumnModel().getColumn(11).setMinWidth(30);
		table.getColumnModel().getColumn(11).setMaxWidth(30);
		panel_3.add(table);
		
		JSplitPane paneDetallesNuevaCompetencia = new JSplitPane();
		paneDetallesNuevaCompetencia.setDividerSize(0);
		panel_3.add(paneDetallesNuevaCompetencia);
		
		JButton btnDetalles = new JButton("Detalles");
		paneDetallesNuevaCompetencia.setLeftComponent(btnDetalles);
		
		JButton btnNuevaCompetencia = new JButton("Nueva Competencia");
		paneDetallesNuevaCompetencia.setRightComponent(btnNuevaCompetencia);
		
		
		
		
		
		

	}
}
