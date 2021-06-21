package GUI;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JTextArea;
import java.awt.TextArea;



import ClassiDAO.PersonaDAOpostgre;
import ClassiDatabase.Persona_creata;
import Controller.Driver;



public class pannelloSuperUser extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane1;
	
	
	private JTextField textFieldNome;
	private JTextField textField_nome;
	private JTextField textField_1_cognome;
	private JTextField textField_cf_cancellazione;
	
	
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
		
		setTitle("Pannello SuperUser");
		pannello_per_superUser();
		//vista_utenti();
		
	}
		
	public void modificaUtente()
	{
		
	}
	
		//////////////////////////////////////////////////////////////////////////////////////
		// settaggi finestra 
		 
	   
		
		// visualizzazione pannello iniziale 
		
		
	//}


	
	private void pannello_per_superUser()
	{
		
		contentPane = set();
		contentPane.setVisible( true );
		
		JLabel lblNewLabel = new JLabel("BENVENUTO");
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(275, 23, 326, 84);
		contentPane.add(lblNewLabel);
		
		JButton bottone_Inserisci_utente = new JButton("INSERISCI UTENTE");
		bottone_Inserisci_utente.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bottone_Inserisci_utente.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
				aggiungi();
				
			}
		});
		bottone_Inserisci_utente.setBounds(322, 232, 258, 58);
		contentPane.add( bottone_Inserisci_utente );
		
		
		/*
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
		*/
		
		JButton bottone_elimina_utente = new JButton("ELIMINA UTENTE");
		bottone_elimina_utente.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bottone_elimina_utente.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				elimina();
				
			}
		});
		bottone_elimina_utente.setBounds(322, 400, 258, 63);
		contentPane.add( bottone_elimina_utente );
		
		JButton bottone_ricerca_utente = new JButton("RICERCA UTENTE");
		bottone_ricerca_utente.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bottone_ricerca_utente.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				ricerca();
				
			}
		});
		bottone_ricerca_utente.setBounds(322, 144, 258, 63);
		contentPane.add(bottone_ricerca_utente);	
		
		
		JButton btnNewButton_1 = new JButton("VISTA UTENTI");
		btnNewButton_1.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				vista_utenti();		
						
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.setBounds(322, 315, 258, 63);
		contentPane.add(btnNewButton_1);
		
	}
	
	private void vista_utenti()
	{
		
		contentPane.setVisible( false );
        contentPane= set();
		
		
		JLabel lblNewLabel_4 = new JLabel("VISTA UTENTI PRESENTI NEL DATABASE");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(152, 30, 614, 51);
		contentPane.add(lblNewLabel_4);
		
		TextArea textArea_risultato_ricerca = new TextArea();   
		textArea_risultato_ricerca.setEditable(false);
		textArea_risultato_ricerca.setBounds(10, 87, 866, 406);
		contentPane.add(textArea_risultato_ricerca);
		
		JButton btnNewButton_2 = new JButton("CERCA");
		btnNewButton_2.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				Driver vista_utenti = new Driver(); 
				
				try
				{
					   for( String s : vista_utenti.vista_utenti() )
						{
							textArea_risultato_ricerca.setText( ( textArea_risultato_ricerca.getText() + "\n" + s.toString() ) );
						}
				}
				catch (SQLException e1) 
				{
					
					e1.printStackTrace();
				}
				    				
				
			}
		});
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_2.setBounds(713, 499, 163, 57);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("INDIETRO");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				contentPane.setVisible( false );
				pannello_per_superUser();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_3.setBounds(10, 499, 163, 57);
		contentPane.add(btnNewButton_3);
		
	}
	
	private void elimina()
	{
		contentPane.setVisible( false ); 
		contentPane = set();
		
		JLabel lblEliminazioneUtente = new JLabel("Eliminazione utente");
		lblEliminazioneUtente.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminazioneUtente.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEliminazioneUtente.setForeground(Color.WHITE);
		lblEliminazioneUtente.setBounds(231, 11, 389, 87);
		contentPane.add( lblEliminazioneUtente );
		
		textField_cf_cancellazione = new JTextField();
		textField_cf_cancellazione.setBounds(439, 109, 335, 37);
		contentPane.add(textField_cf_cancellazione);
		textField_cf_cancellazione.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Inserisci il codice fiscale");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(56, 92, 335, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("dell'utente da eliminare:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(66, 131, 291, 37);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Cancella");
		btnNewButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
			 
				PersonaDAOpostgre persona_da_cancellare;
				
				try 
				{
					persona_da_cancellare = new PersonaDAOpostgre();
					persona_da_cancellare.deletePersonaByCodiceFiscale(textField_cf_cancellazione.getText().toString());
					
				}
				catch (SQLException e1)
				{
				
					e1.printStackTrace();
				} 
				contentPane.setVisible( false );
				pannello_per_superUser();
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(540, 281, 234, 66);
		contentPane.add(btnNewButton);
		
		
		JButton bottone_indietro = new JButton("Indietro");
		bottone_indietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				contentPane.setVisible( false );
				pannello_per_superUser();
			}
		});
		bottone_indietro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bottone_indietro.setBounds(44, 293, 222, 66);
		contentPane.add(bottone_indietro);
	}
	
	/*private void modifica()
	{
		//metodo che va sviluppato nel seguente modo: trova all'interno del database il dato errato inserito, 
		//modifica, nel caso di nome, cognome,  data di nascita e comune, vengono modificati quei valori, generato un nuovo 
		//codice fiscale e sostituito a quello precedentemente costruito. Nel caso di altri dati (maschio o femmina,
		//manager o tesserato) poiché in teoria non dovrebbe violare alcuna regola 
		contentPane.setVisible( false );
        contentPane= set();
		
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
				
				contentPane.setVisible( false );
				pannello_per_superUser();
				
			}
		});
		bottone_indietro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bottone_indietro.setBounds(10, 483, 176, 46);
		panel.add(bottone_indietro);
				
		
	} 
				
	*/	
		
		
	
	
	private void aggiungi()
	{
		
//		Inserimento_dati_persona n = new Inserimento_dati_persona();	
//		n.setVisible( true );
	///////////////////////////////////////////////////////////////////////////////////
		
		JPanel contentPane_provincia;
		JTextField textFieldNome;
		JTextField textFieldCognome;
		JTextField textFieldDataNascita_anno;
		JTextField textFieldDataNascita_mese;
		JTextField textFieldDataNascita_giorno;
		JTextField textFieldComuneNascita;
		JTextField textFieldComuneResidenza;
		JTextField textFieldVia;
		JTextField textFieldNumeroCivico;
		JTextField textFieldCAP;
		
		Driver driver = new Driver(); 
		
		
	    JFrame persona; 
	    JTextField textFieldProvincia;
	    Inserimento_dati_persona persona_da_inserire; 
	    
	  
	    JPasswordField inserimento_password;
	    JPasswordField controllo_password;
	    
	
	
			persona = this; 
	        
			setLocation(500, 500); 
			
			setTitle("Inserimento Persona");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 902, 617);
			contentPane_provincia = set();
			contentPane_provincia.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane_provincia);
			contentPane_provincia.setLayout(null);
			
			JLabel labelNome = new JLabel("Nome: ");
			labelNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelNome.setBounds(26, 11, 178, 29);
			contentPane_provincia.add(labelNome);
			
			JLabel labelCognome = new JLabel("Cognome :");
			labelCognome.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelCognome.setBounds(26, 51, 178, 29);
			contentPane_provincia.add(labelCognome);
			
			JLabel labelDataNascita = new JLabel("Data di nascita:");
			labelDataNascita.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelDataNascita.setBounds(26, 91, 178, 29);
			contentPane_provincia.add(labelDataNascita);
			
			JLabel labelComuneNascita = new JLabel("Comune di nascita: ");
			labelComuneNascita.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelComuneNascita.setBounds(26, 117, 178, 39);
			contentPane_provincia.add(labelComuneNascita);
			
			JLabel labelComuneResidenza = new JLabel("Comune di residenza: ");
			labelComuneResidenza.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelComuneResidenza.setBounds(26, 158, 208, 34);
			contentPane_provincia.add(labelComuneResidenza);
			
			JLabel labelVia = new JLabel("Via: ");
			labelVia.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelVia.setBounds(26, 191, 178, 38);
			contentPane_provincia.add(labelVia);
			
			JLabel labelNumeroCivico = new JLabel("Numero civico: ");
			labelNumeroCivico.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelNumeroCivico.setBounds(26, 235, 178, 39);
			contentPane_provincia.add(labelNumeroCivico);
			
			JLabel label_CAP = new JLabel("CAP:");
			label_CAP.setFont(new Font("Tahoma", Font.PLAIN, 20));
			label_CAP.setBounds(362, 235, 178, 39);
			contentPane_provincia.add(label_CAP);
			
			JLabel labelSesso = new JLabel("Identit\u00E0 di genere:");
			labelSesso.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelSesso.setBounds(26, 289, 178, 39);
			contentPane_provincia.add(labelSesso);
			
			JLabel labelProvincia = new JLabel("Provincia di nascita: ");
			labelProvincia.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelProvincia.setBounds(362, 291, 184, 34);
			contentPane_provincia.add(labelProvincia);
			
			JLabel labelManagerOTesserato = new JLabel("Manager o tesserato?");
			labelManagerOTesserato.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelManagerOTesserato.setVerticalAlignment(SwingConstants.TOP);
			labelManagerOTesserato.setBounds(21, 339, 213, 39);
			contentPane_provincia.add(labelManagerOTesserato);
			
			
			
			
		    textFieldNome = new JTextField();
			textFieldNome.setColumns(10);
			textFieldNome.setBounds(235, 19, 337, 20);
			contentPane_provincia.add(textFieldNome);
			
			textFieldCognome = new JTextField();
			textFieldCognome.setColumns(10);
			textFieldCognome.setBounds(235, 59, 337, 20);
			contentPane_provincia.add(textFieldCognome);
			
			textFieldDataNascita_anno = new JTextField();
			textFieldDataNascita_anno.setColumns(10);
			textFieldDataNascita_anno.setBounds(502, 99, 76, 20);
			contentPane_provincia.add(textFieldDataNascita_anno);
			
			textFieldDataNascita_giorno = new JTextField();
			textFieldDataNascita_giorno.setBounds(259, 99, 76, 20);
			contentPane_provincia.add(textFieldDataNascita_giorno);
			textFieldDataNascita_giorno.setColumns(10);
			
			textFieldDataNascita_mese = new JTextField();
			textFieldDataNascita_mese.setBounds(385, 99, 76, 20);
			contentPane_provincia.add(textFieldDataNascita_mese);
			textFieldDataNascita_mese.setColumns(10);
		
			textFieldComuneNascita = new JTextField();
			textFieldComuneNascita.setColumns(10);
			textFieldComuneNascita.setBounds(235, 130, 337, 20);
			contentPane_provincia.add(textFieldComuneNascita);
			
			textFieldComuneResidenza = new JTextField();
			textFieldComuneResidenza.setColumns(10);
			textFieldComuneResidenza.setBounds(235, 169, 337, 20);
			contentPane_provincia.add(textFieldComuneResidenza);
			
			textFieldVia = new JTextField();
			textFieldVia.setColumns(10);
			textFieldVia.setBounds(235, 204, 343, 20);
			contentPane_provincia.add(textFieldVia);
			
			textFieldNumeroCivico = new JTextField();
			textFieldNumeroCivico.setColumns(10);
			textFieldNumeroCivico.setBounds(235, 242, 46, 33);
			contentPane_provincia.add(textFieldNumeroCivico);
			
			textFieldCAP = new JTextField();
			textFieldCAP.setColumns(10);
			textFieldCAP.setBounds(579, 242, 46, 32);
			contentPane_provincia.add(textFieldCAP);
			
			JComboBox comboBoxSesso = new JComboBox();
			comboBoxSesso.setBounds(235, 289, 46, 22);
			contentPane_provincia.add(comboBoxSesso);
			comboBoxSesso.addItem("M");
			comboBoxSesso.addItem("F");
			
			JComboBox comboBoxManagerOtesserato = new JComboBox();
			comboBoxManagerOtesserato.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBoxManagerOtesserato.setBounds(235, 322, 88, 34);
			contentPane_provincia.add(comboBoxManagerOtesserato);
			comboBoxManagerOtesserato.addItem("Manager");
			comboBoxManagerOtesserato.addItem("Tesserato");
			
			JButton bottoneAnnulla = new JButton("Annulla inserimento");
			bottoneAnnulla.setFont(new Font("Tahoma", Font.PLAIN, 18));
			bottoneAnnulla.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseClicked(MouseEvent e) 
				{
					contentPane_provincia.setVisible( false );
					pannello_per_superUser();
					
				}
			});
			bottoneAnnulla.setBounds(26, 507, 187, 60);
			contentPane_provincia.add(bottoneAnnulla);
			
			textFieldProvincia = new JTextField();
			textFieldProvincia.setBounds(579, 283, 46, 29);
			contentPane_provincia.add(textFieldProvincia);
			textFieldProvincia.setColumns(10);
			
			
			
			JLabel lblNewLabel = new JLabel("Anno");
			lblNewLabel.setBounds(472, 102, 46, 14);
			contentPane_provincia.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Mese");
			lblNewLabel_1.setBounds(345, 102, 46, 14);
			contentPane_provincia.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Giorno");
			lblNewLabel_2.setBounds(214, 102, 46, 14);
			contentPane_provincia.add(lblNewLabel_2);
			
			JLabel creazione_password = new JLabel("Crea e inserisci una password:");
			creazione_password.setFont(new Font("Tahoma", Font.PLAIN, 20));
			creazione_password.setBounds(26, 389, 279, 29);
			contentPane_provincia.add(creazione_password);
			
			inserimento_password = new JPasswordField();
			inserimento_password.setBounds(345, 397, 198, 20);
			contentPane_provincia.add(inserimento_password);
			
			JLabel reinserimento_password = new JLabel("Reinserisci password:");
			reinserimento_password.setFont(new Font("Tahoma", Font.PLAIN, 20));
			reinserimento_password.setBounds(26, 439, 279, 39);
			contentPane_provincia.add(reinserimento_password);
			
			controllo_password = new JPasswordField();
			controllo_password.setBounds(345, 452, 198, 20);
			contentPane_provincia.add(controllo_password);
			
		
			contentPane_provincia.add(bottoneAnnulla);
			
			JButton btnNewButton = new JButton("Avanti");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) 
				{
					
					boolean flag; 
					String codiceFiscale = null; 
					
					
				
					try {
						
						flag = driver.controlloDati(	textFieldNome		, textFieldCognome,		
														textFieldDataNascita_anno , textFieldDataNascita_mese		, textFieldDataNascita_giorno,
														textFieldComuneNascita ,    textFieldComuneResidenza	    ,  
														textFieldCAP 			, textFieldProvincia, inserimento_password, controllo_password
													);
						
						if(flag)
						{	
							codiceFiscale = driver.creazioneCodiceFiscale(		textFieldCognome, textFieldNome, textFieldDataNascita_anno,
													 							textFieldDataNascita_mese, textFieldDataNascita_giorno,
																			 	comboBoxSesso, textFieldComuneNascita 
																		);
						}
						else
						{
							System.out.println("La creazione del codice fiscale non è andata a buon fine\n");
						}
							
//						int anno = Integer.parseInt( textFieldDataNascita_anno.getText() ); 
//						int mese = Integer.parseInt( textFieldDataNascita_mese.getText()); 
//						int giorno = Integer.parseInt( textFieldDataNascita_giorno.getText() ); 
						
						String Data_finale = textFieldDataNascita_anno.getText()+"-"+textFieldDataNascita_mese.getText()+"-"+textFieldDataNascita_giorno.getText();
						
						//Date data_nascita = new Date(anno, mese, giorno); 
						 
						LocalDate data = LocalDate.parse(Data_finale); 
						
						 
						
						
//							long timeInMilliSeconds = data.getTime();
//					    	java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
					     
					     
					    System.out.println("Ho appena eseguito i controlli e creato il codice fiscale\n");
					    
					    boolean manager_o_tesserato = false; 
					    
					    if( comboBoxManagerOtesserato.getSelectedItem().toString().equals("Manager")) 
					    {
					    	
					    }
					    else
					    {
					    	manager_o_tesserato = true; 
					    }
						
						String myPass = String.valueOf(inserimento_password.getPassword());
						
						controllo_password.equals(myPass);
							
						 
						 Persona_creata persona_creata = new Persona_creata(	codiceFiscale, textFieldNome.getText(), textFieldCognome.getText(), data , textFieldComuneNascita.getText(),
																textFieldComuneResidenza.getText(), textFieldVia.getText(),  Integer.parseInt( textFieldNumeroCivico.getText() ) ,
																Integer.parseInt( textFieldCAP.getText() ), comboBoxSesso.getSelectedItem().toString(),
																textFieldProvincia.getText(), manager_o_tesserato, myPass
															); 
						
						
		                System.out.println("\n\n\n\n\n\n"+comboBoxManagerOtesserato.getSelectedItem().toString() );				
						System.out.println("Adesso ho creato una nuova persona \n");
						
						persona_tesserata tesserato = new persona_tesserata( persona_creata , persona);
						
						System.out.println("Adesso vado in tesserato\n");
						
						tesserato.setVisible(true); 
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					} 
	                
//					int count = e.getClickCount(); 
//					if(count >= 2)
//				       errore.setVisible(false);
					
//						}
//					}
					
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton.setBounds(579, 507, 187, 60);
			contentPane_provincia.add(btnNewButton);
			
			
		
			
			
			
			
			
		}
		
	///////////////////////////////////////////////////////////////////////////////////
	
	
	private JPanel set()
	{
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 617); 
		JPanel pannello = new JPanel();
		pannello.setBackground(Color.DARK_GRAY);
		pannello.setBorder(new EmptyBorder(5, 5, 5, 5));
		pannello.setLayout(null);
		setContentPane( pannello );
		
		//
		
		
			
		////////////////////////////
		
	
		return pannello;
	}
	
	private void ricerca()
	{
		
		//Funziona solo con le inziaili di nome e cognome maiuscolo
		
		
		contentPane.setVisible( false );
        contentPane= set();
		
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
				
				contentPane.setVisible( false );
				pannello_per_superUser();
				
			}
		});
		bottone_indietro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bottone_indietro.setBounds(10, 483, 176, 46);
		panel.add(bottone_indietro);
				
		
	}
}
