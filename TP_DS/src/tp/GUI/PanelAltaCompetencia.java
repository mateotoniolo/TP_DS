package tp.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class AltaCompetencia {

	private JFrame frmAltaCompetencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaCompetencia window = new AltaCompetencia();
					window.frmAltaCompetencia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AltaCompetencia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAltaCompetencia = new JFrame();
		frmAltaCompetencia.setTitle("ALTA COMPETENCIA");
		frmAltaCompetencia.setBounds(100, 100, 450, 300);
		frmAltaCompetencia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
