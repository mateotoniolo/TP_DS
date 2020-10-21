package tp.app;

import java.awt.EventQueue;

import tp.DAO.DataBase;
import tp.GUI.MainApplication;

public class App {
	
public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataBase.leerJson();
					DataBase.inicializarTablas();
					MainApplication mainApplication = new MainApplication();
					mainApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
}
}
