package tp.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

import tp.DAO.LugarDAO;

import java.awt.Color;
import javax.swing.JTextField;

public class DialogAltaLugar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;


	public DialogAltaLugar() {
		try {
//			DialogAltaLugar dialog = new DialogAltaLugar();
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setVisible(true);
			initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void initialize() {
		setTitle("Nuevo Lugar");
		getContentPane().setBackground(new Color(153, 204, 255));
		setBounds(100, 100, 450, 162);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 123);
		contentPanel.setBackground(new Color(153, 204, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		
		JLabel lblLugar = new JLabel("Disponibilidad *");
		lblLugar.setBounds(233, 16, 93, 17);
		contentPanel.add(lblLugar);
		lblLugar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox<String> boxLugar = new JComboBox<String>();
		boxLugar.setBounds(6, 35, 215, 26);
		contentPanel.add(boxLugar);
		
//		lugares
//		List<String> lugares = LugarDAO.getLugares();
//		System.out.println(lugares);
//		for(String l1 : lugares) {
//			boxLugar.addItem(l1);
//		}
		
		//		ingresoDeporte = false;
		//		boxDeporte.addActionListener( a -> {
		//			deporteCompetencia = (String) boxDeporte.getSelectedItem();
		//		});
		
		JLabel lblDisponibilidad = new JLabel("Lugar *");
		lblDisponibilidad.setBounds(6, 16, 47, 17);
		contentPanel.add(lblDisponibilidad);
		lblDisponibilidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				JSplitPane splitCancelarConfirmar = new JSplitPane();
				splitCancelarConfirmar.setBounds(248, 87, 180, 30);
				contentPanel.add(splitCancelarConfirmar);
				splitCancelarConfirmar.setDividerSize(0);
				
				JButton btnConfirmar = new JButton("Confirmar");
				btnConfirmar.setBackground(new Color(102, 102, 255));
				
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener( a -> {
//			new MainApplication().setVisible(true);
					System.exit(0);
				});
				splitCancelarConfirmar.setRightComponent(btnConfirmar);
				splitCancelarConfirmar.setLeftComponent(btnCancelar);
				
				textField = new JTextField();
				textField.setBounds(233, 34, 195, 28);
				contentPanel.add(textField);
				textField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 0, 0, 0);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
		}
		
	}
}
