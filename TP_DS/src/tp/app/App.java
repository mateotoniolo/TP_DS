package tp.app;

import java.awt.EventQueue;

import tp.GUI.mainApplication;

public class App {
	
public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainApplication window = new mainApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
}
}
