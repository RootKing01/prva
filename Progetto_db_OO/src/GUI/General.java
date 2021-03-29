package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Driver;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class General extends JFrame {

	
	Driver driver = new Driver(); 
	General general;
	
	private JPanel contentPane;


	
////////////////////////////////////////////****FRAME****//////////////////////////////////////
	public General(Driver d) {
		driver = d; 
		general = this; 
		setBackground(Color.DARK_GRAY);
		setTitle("Operazioni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 506);
		contentPane = new JPanel(); 
	
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Inserisci");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
	        general.setVisible(false);
			Inserimento_dati_persona persona = new Inserimento_dati_persona(); 
			persona.setVisible(true);
			
			    
				
			}
		});
		btnNewButton.setBounds(281, 103, 131, 47);
		contentPane.add(btnNewButton);
		
	}
}
