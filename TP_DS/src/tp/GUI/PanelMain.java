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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelMain extends JPanel {
	
	private AltaCompetencia altaCompetencia;
	private Icon imgCup;
	
	public PanelMain(JFrame frame) {
		initialize(frame);
	}

	public void initialize(JFrame frame) {
		this.setPreferredSize(new Dimension(10, 200));
		this.setBackground(new Color(102, 204, 255));
		frame.getContentPane().add(this, BorderLayout.NORTH);
		this.setLayout(new BorderLayout(0, 0));
		JLabel lblNombre = new JLabel("TORNEOS Y COMPETENCIAS");
		lblNombre.setPreferredSize(new Dimension(200, 14));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 30));
		this.add(lblNombre, BorderLayout.CENTER);
		
		
		JLabel lblCup = new JLabel();
		lblCup.setIcon(imgCup);
		this.add(lblCup, BorderLayout.EAST);
		
		JTextPane txtDescripcion = new JTextPane();
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDescripcion.setPreferredSize(new Dimension(7, 150));
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
		frame.getContentPane().add(txtDescripcion, BorderLayout.SOUTH);
		
		JPanel panelUser = new JPanel();
		panelUser.setPreferredSize(new Dimension(200, 10));
		frame.getContentPane().add(panelUser, BorderLayout.EAST);
		
		JTextPane txtpnUsuario = new JTextPane();
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
		btnCerrarSesion.setBackground(new Color(255, 0, 0));
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelUser.add(btnCerrarSesion, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("<IMAGEN>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel.add(lblNewLabel, BorderLayout.CENTER);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setToolTipText("");
		panel.add(splitPane, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Lugares");
		btnNewButton.setBackground(new Color(0, 0, 0));
		splitPane.setRightComponent(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Competencias");
		btnNewButton_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
					altaCompetencia = new AltaCompetencia();
					frame.revalidate();
					frame.repaint();
			}
		});
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		splitPane.setLeftComponent(btnNewButton_1);
	}
	
}
