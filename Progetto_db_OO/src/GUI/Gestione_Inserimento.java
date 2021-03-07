package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Driver;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gestione_Inserimento extends JFrame {

	private JPanel contentPane;

	Driver driver = new Driver(); 
	
   static	Gestione_Inserimento frame_inserimento = new Gestione_Inserimento(); 
	
 
 
 
 
 
	public Gestione_Inserimento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 984, 687);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton = new JButton("Inserisci Manager");
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
							
				Inserimento_Manager dati_persona_manager = new Inserimento_Manager(); 
				driver.funzione_finestra_visibile(frame_inserimento, dati_persona_manager);					
			
			}
		});
		
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(326, 78, 283, 212);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Inserisci Tesserato");
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(326, 339, 283, 212);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Indietro\r\n");
		btnNewButton_2.setBounds(53, 570, 89, 40);
		contentPane.add(btnNewButton_2);
	}

	public Color getContentPaneBackground() {
		return contentPane.getBackground();
	}
	public void setContentPaneBackground(Color background) {
		contentPane.setBackground(background);
	}
}
