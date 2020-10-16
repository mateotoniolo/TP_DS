package tp.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

public class DialogSeguridad extends JDialog {
	
	public final JPanel contentPanel = new JPanel();
	
	public DialogSeguridad(String nombreCompetencia) {
		inizializate(nombreCompetencia);
	}
	public void inizializate(String nombreCompetencia) {
		
		setResizable(false);
		setBounds(100, 100, 350, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCuidad = new JLabel("CUIDADO");
			lblCuidad.setBounds(126, 11, 97, 25);
			lblCuidad.setFont(new Font("Tahoma", Font.BOLD, 20));
			contentPanel.add(lblCuidad);
		}
		{
			JLabel imgAlerta = new JLabel("");
			imgAlerta.setBounds(0, 35, 72, 103);
			imgAlerta.setIcon(new ImageIcon(DialogSeguridad.class.getResource("/img/pregunta1.png")));
			contentPanel.add(imgAlerta);
		}
		
		JTextPane txtpnEstas = new JTextPane();
		txtpnEstas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnEstas.setText("\u00BFEst\u00E1 seguro que desea crear\r\nla nueva competencia "+nombreCompetencia+"?");
		txtpnEstas.setBounds(82, 62, 236, 50);
		contentPanel.add(txtpnEstas);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.setAlignmentY(Component.TOP_ALIGNMENT);
				btnAceptar.setAlignmentX(Component.CENTER_ALIGNMENT);
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
				
				btnAceptar.addActionListener( a -> {
					dispose();
				});
				
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setAlignmentY(Component.TOP_ALIGNMENT);
				btnCancelar.setAlignmentX(Component.CENTER_ALIGNMENT);
				btnCancelar.setActionCommand("OK");
				buttonPane.add(btnCancelar);
				getRootPane().setDefaultButton(btnCancelar);
				
				btnAceptar.addActionListener( a -> {
					dispose();
				});
			}
			
		}
	}
}
