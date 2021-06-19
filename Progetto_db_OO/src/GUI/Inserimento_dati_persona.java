package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassiDatabase.Persona_creata;
import Controller.Driver;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.ComponentOrientation;

import javax.print.attribute.DateTimeSyntax;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;
import javax.swing.JPasswordField;

public class Inserimento_dati_persona extends JFrame {

	private JPanel contentPane_provincia;
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	private JTextField textFieldDataNascita_anno;
	private JTextField textFieldDataNascita_mese;
	private JTextField textFieldDataNascita_giorno;
	private JTextField textFieldComuneNascita;
	private JTextField textFieldComuneResidenza;
	private JTextField textFieldVia;
	private JTextField textFieldNumeroCivico;
	private JTextField textFieldCAP;
	
	
	
    Inserimento_dati_persona persona; 
    private JTextField textFieldProvincia;
   
	Driver driver = new Driver(); 
    
	Errore_Inserimento_Dati errore;  
    private Persona_creata persona_creata;
    private JPasswordField inserimento_password;
    private JPasswordField controllo_password;
    
	
	
	
	public Inserimento_dati_persona() {
		
		
		
        persona = this; 
        
		setLocation(500, 500); 
		
		setTitle("Inserimento Persona");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 617);
		contentPane_provincia = new JPanel();
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
		bottoneAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
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
			public void mouseClicked(MouseEvent e) {
				
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
						
//					int anno = Integer.parseInt( textFieldDataNascita_anno.getText() ); 
//					int mese = Integer.parseInt( textFieldDataNascita_mese.getText()); 
//					int giorno = Integer.parseInt( textFieldDataNascita_giorno.getText() ); 
					
					String Data_finale = textFieldDataNascita_anno.getText()+"-"+textFieldDataNascita_mese.getText()+"-"+textFieldDataNascita_giorno.getText();
					
					//Date data_nascita = new Date(anno, mese, giorno); 
					 
					LocalDate data = LocalDate.parse(Data_finale); 
					
					 
					
					/*
						long timeInMilliSeconds = data.getTime();
				    	java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
				    */ 
				     
				    System.out.println("Ho appena eseguito i controlli e creato il codice fiscale\n");
				    
				    boolean manager_o_tesserato = false; 
				    
				    if( comboBoxManagerOtesserato.getSelectedItem().toString().equals("Manager")) 
				    {
				    	
				    }
				    else
				    {
				    	manager_o_tesserato = true; 
				    }
					
					String myPass=String.valueOf(inserimento_password.getPassword());
					
					if(controllo_password.equals(myPass));
						
						
	                persona_creata = new Persona_creata(	codiceFiscale, textFieldNome.getText(), textFieldCognome.getText(), data , textFieldComuneNascita.getText(),
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
                
				int count = e.getClickCount(); 
				if(count >= 2)
			       errore.setVisible(false);
				
//					}
//				}
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(579, 507, 187, 60);
		contentPane_provincia.add(btnNewButton);
			
	}
}
