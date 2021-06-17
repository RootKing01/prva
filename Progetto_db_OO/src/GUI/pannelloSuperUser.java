package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Driver;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextArea;
import java.awt.TextArea;

public class pannelloSuperUser extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane1;
	
	
	private JTextField textFieldNome;
	private JTextField textField_nome;
	private JTextField textField_1_cognome;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pannelloSuperUser frame = new pannelloSuperUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public pannelloSuperUser( ) 
	{
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////
		contentPane = set();
		
		contentPane.setVisible( true );
		
		
		JLabel lblNewLabel = new JLabel("BENVENUTO");
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(275, 23, 326, 84);
		contentPane.add(lblNewLabel);
		
		JButton bottone_Inserisci_utente = new JButton("INSERISCI UTENTE");
		bottone_Inserisci_utente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
				aggiungi();
				
			}
		});
		bottone_Inserisci_utente.setBounds(322, 232, 258, 58);
		contentPane.add( bottone_Inserisci_utente );
		
		JButton bottone_modifica_utente = new JButton("MODIFICA UTENTE");
		bottone_modifica_utente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				modifica();
				
			}
		});
		bottone_modifica_utente.setBounds(322, 314, 258, 63);
		contentPane.add( bottone_modifica_utente );
		
		JButton bottone_elimina_utente = new JButton("ELIMINA UTENTE");
		bottone_elimina_utente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				elimina();
				
			}
		});
		bottone_elimina_utente.setBounds(322, 401, 258, 63);
		contentPane.add( bottone_elimina_utente );
		
		JButton bottone_ricerca_utente = new JButton("RICERCA UTENTE");
		bottone_ricerca_utente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				ricerca();
				
			}
		});
		bottone_ricerca_utente.setBounds(322, 144, 258, 63);
		contentPane.add(bottone_ricerca_utente);
	}


	private void elimina()
	{
		
	}
	
	private void modifica()
	{
				
	}
	
	private void aggiungi()
	{
		
	}
	
	private JPanel set()
	{
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 957, 595); // RISOLUZIONE HD
		JPanel pannello = new JPanel();
		pannello.setBackground(Color.DARK_GRAY);
		pannello.setBorder(new EmptyBorder(5, 5, 5, 5));
		pannello.setLayout(null);
		setContentPane( pannello );
	
		return pannello;
	}
	
	private void ricerca()
	{
		
		contentPane.setVisible( false );
        contentPane = set();
		
		setTitle("Inserimento Persona");
		
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 949, 556);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Inserisci nome dell'utente da ricercare:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_3.setBounds(10, 55, 403, 36);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Inserisci cognome dell'utente da ricercare:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_3_1.setBounds(10, 102, 448, 36);
		panel.add(lblNewLabel_3_1);
		
		textField_nome = new JTextField();
		textField_nome.setBounds(504, 68, 267, 20);
		panel.add(textField_nome);
		textField_nome.setColumns(10);
		
		textField_1_cognome = new JTextField();
		textField_1_cognome.setColumns(10);
		textField_1_cognome.setBounds(504, 115, 267, 20);
		panel.add(textField_1_cognome);
		
		TextArea textArea_risultato_ricerca = new TextArea();   
		textArea_risultato_ricerca.setEditable(false);
		textArea_risultato_ricerca.setBounds(121, 170, 687, 293);
		panel.add(textArea_risultato_ricerca);
		
		
		JButton bottoneRicerca = new JButton("Ricerca");
		bottoneRicerca.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				ArrayList<String> utenti_trovati;
				Driver ricerca_utente_database = new Driver(); 
				utenti_trovati = ricerca_utente_database.ricerca_utente( textField_nome.getText().toString(), textField_1_cognome.getText().toString() ); 
				
				for( String s : utenti_trovati )
				{
					textArea_risultato_ricerca.setText( textArea_risultato_ricerca.getText() +"\n" + s ); 
				}
				
			
			}
		});
		bottoneRicerca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bottoneRicerca.setBounds(752, 483, 176, 46);
		panel.add(bottoneRicerca);
		
		JButton bottone_indietro = new JButton("Indietro");
		bottone_indietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		bottone_indietro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bottone_indietro.setBounds(10, 483, 176, 46);
		panel.add(bottone_indietro);
		
		
		
		
		
		
		
		
	}
}
