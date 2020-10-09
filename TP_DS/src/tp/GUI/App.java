package tp.GUI;


import java.awt.Dimension;

import java.awt.Toolkit;



import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;







public class App extends JFrame {
	
	JPanel actual = null;
	
	public void cambiarPanel(JPanel p) {
		//Invoca este metodo cada vez que se necesita cambiar el panel
		Dimension d = this.getSize();
		this.remove(actual);
		this.actual = p;
		this.add(this.actual);
		this.pack();
		this.revalidate();
		this.repaint();
		this.setSize(d);
		}
	
	private App() {
		this.setTitle("App");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(1300,750));
		this.setLocationRelativeTo(null);		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainApplication.class.getResource("/img/medal.png")));
		
		//Aca en realidad se inicializa con el PANEL HOME por ahora le asigno el panel de alta pq es el que tenemos
		this.actual = new JPanel();
		PanelAltaCompetencia home =new PanelAltaCompetencia(this); 
		this.cambiarPanel(home);
	}
	

	public static void main (String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				new App().setVisible(true);
				
			}
		});

	}
	
	
}
