package tp.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.Color;

import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.FlowLayout;

public class MainApplication extends JFrame {

	public JFrame frameMain;
	private PanelAltaCompetencia panelAltaCompetencia;

	public MainApplication() {
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
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
		}
		
		frameMain = new JFrame();
		frameMain.setIconImage(Toolkit.getDefaultToolkit().getImage(MainApplication.class.getResource("/img/medal.png")));
		ImageIcon imgCup = new ImageIcon("img/cup.png");
		frameMain.setExtendedState(Frame.MAXIMIZED_BOTH);
		frameMain.getContentPane().setBackground(Color.WHITE);
		frameMain.setBounds(100, 100, 1280, 751);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.getContentPane().setLayout(new BorderLayout(0, 0));
		frameMain.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setForeground(new Color(153, 204, 255));
		panel.setPreferredSize(new Dimension(10, 180));
		frameMain.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNombre = new JLabel("Torneos y Competencias");
		lblNombre.setPreferredSize(new Dimension(200, 14));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 45));
		panel.add(lblNombre);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MainApplication.class.getResource("/img/cup.png")));
		panel.add(lblNewLabel_1, BorderLayout.EAST);
		
		
		JTextPane txtDescripcion = new JTextPane();
		txtDescripcion.setEditable(false);
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDescripcion.setPreferredSize(new Dimension(7, 50));
		txtDescripcion.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque pretium "
				+ "mauris vitae libero consequat elementum. Nam quis ante viverra, interdum eros eu, pellentesque "
				+ "nisi. Phasellus et arcu ornare, volutpat sapien ac, ultricies lectus. Integer dignissim in "
				+ "orci sagittis cursus. Donec finibus vel lorem in consectetur. Morbi nec est ex. Donec auctor "
				+ "magna in tempor ullamcorper. Donec sagittis tortor eros, eget gravida nisl semper non. "
				+ "Pellentesque lobortis neque dolor, eu elementum elit porta sit amet. Curabitur vehicula "
				+ "malesuada justo, a accumsan leo egestas id. Aliquam at quam eget tortor iaculis scelerisque "
				+ "sit amet quis lectus. Nullam purus ante, tristique a rutrum at, auctor vitae est. Nullam "
				+ "tincidunt urna quis pharetra volutpat. Vivamus pharetra, massa at pulvinar sollicitudin, ligula "
				+ "eros hendrerit nibh, id varius leo erat convallis odio. Mauris ultrices metus sodales arcu "
				+ "varius malesuada.");
		frameMain.getContentPane().add(txtDescripcion, BorderLayout.SOUTH);
		
		JPanel panelUser = new JPanel();
		panelUser.setPreferredSize(new Dimension(200, 10));
		frameMain.getContentPane().add(panelUser, BorderLayout.EAST);
		
		JTextPane txtpnUsuario = new JTextPane();
		txtpnUsuario.setEditable(false);
		txtpnUsuario.setFont(new Font("Dialog", Font.ITALIC, 16));
		txtpnUsuario.setText("Usuario: ...\r\nCorreoElectronico: ...\r\n");
		panelUser.setLayout(new BorderLayout(0, 0));
		panelUser.add(txtpnUsuario, BorderLayout.CENTER);
		
		JButton btnModificarParticipante = new JButton("Modificar");
		btnModificarParticipante.setBackground(new Color(102, 102, 255));
		btnModificarParticipante.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelUser.add(btnModificarParticipante, BorderLayout.SOUTH);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesion.setForeground(new Color(0, 0, 0));
		btnCerrarSesion.setBackground(new Color(255, 102, 102));
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelUser.add(btnCerrarSesion, BorderLayout.NORTH);
		
		JPanel panelLugaresCompetenciasImagen = new JPanel();
		frameMain.getContentPane().add(panelLugaresCompetenciasImagen, BorderLayout.CENTER);
		panelLugaresCompetenciasImagen.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setToolTipText("");
		panelLugaresCompetenciasImagen.add(splitPane, BorderLayout.NORTH);
		
		JButton btnLugares = new JButton("Lugares");
		btnLugares.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnLugares.setForeground(new Color(255, 255, 255));
		btnLugares.setBackground(new Color(51, 51, 51));
		splitPane.setRightComponent(btnLugares);
		
		JButton btnCompetencias = new JButton("Competencias");
		btnCompetencias.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnCompetencias.setForeground(new Color(255, 255, 255));
		btnCompetencias.addActionListener( a -> {
			frameMain.setContentPane(panelAltaCompetencia = new PanelAltaCompetencia(frameMain));
			frameMain.revalidate();
			frameMain.repaint();
		});
		btnCompetencias.setBackground(new Color(51, 51, 51));
		splitPane.setLeftComponent(btnCompetencias);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204));
		panelLugaresCompetenciasImagen.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainApplication.class.getResource("/img/sports.png")));
		lblNewLabel.setBounds(32, 6, 1026, 361);
		panel_1.add(lblNewLabel);
	}
}
