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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class General extends JFrame {

	
	Driver driver = new Driver(); 
	General general;
	
	private JPanel contentPane;
	JFrame frame = new JFrame();
	private JTextField textField_accesso_codiceFiscale;
	private JPasswordField passwordField_per_accesso;

	
////////////////////////////////////////////****FRAME****//////////////////////////////////////
	public General(Driver d) 
	{
		
		 
		/*
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  		frame.getContentPane().add(contentPane); // or whatever...
			frame.pack();
			frame.setLocationRelativeTo(null);  // *** this will center your app ***
			frame.setVisible(true);	
		*/
		
		contentPane = new JPanel();
		driver = d; 
		general = this; 
		
		setBackground(Color.DARK_GRAY);
		setTitle("Operazioni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 506);
		
		
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bottoneInserisci = new JButton("Registrati ora!");
		bottoneInserisci.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bottoneInserisci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
	        general.setVisible(false);
			Inserimento_dati_persona persona = new Inserimento_dati_persona(); 
			persona.setVisible(true);
			
			    
				
			}
		});
		bottoneInserisci.setBounds(534, 374, 182, 48);
		contentPane.add(bottoneInserisci);
		
		textField_accesso_codiceFiscale = new JTextField();
		textField_accesso_codiceFiscale.setBounds(524, 147, 235, 20);
		contentPane.add(textField_accesso_codiceFiscale);
		textField_accesso_codiceFiscale.setColumns(10);
		
		passwordField_per_accesso = new JPasswordField();
		passwordField_per_accesso.setBounds(524, 202, 204, 20);
		contentPane.add(passwordField_per_accesso);
		

		JButton btnNewButton = new JButton("Accedi");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				boolean codiceFiscale_giusto_o_sbagliato = false;
				boolean password_giusta_o_sbagliata = false;
				   
				codiceFiscale_giusto_o_sbagliato = driver.confrontoCodiceFiscaleDataBase( textField_accesso_codiceFiscale );
				password_giusta_o_sbagliata = driver.controlloPasswordDataBase( passwordField_per_accesso );
				
				
				
			}
		});
		btnNewButton.setBounds(627, 268, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Inserisci il codice fiscale\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(294, 135, 316, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblInserisciLaPassword = new JLabel("Inserisci la password\r\n\r\n");
		lblInserisciLaPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInserisciLaPassword.setBounds(326, 191, 316, 35);
		contentPane.add(lblInserisciLaPassword);
		
		JLabel lblNewLabel_1 = new JLabel("Non ancora iscritto?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(347, 364, 226, 64);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SMARTSPORT 2.0");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(134, 0, 494, 79);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Vincioking\\Desktop\\nr.png"));
		lblNewLabel_3.setBounds(-91, 27, 534, 382);
		contentPane.add(lblNewLabel_3);
		
	}
}
