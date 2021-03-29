package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Driver;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.ComponentOrientation;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Inserimento_dati_persona extends JFrame {

	private JPanel contentPane_provincia;
	private JTextField textField_CF;
	private JTextField textField_Nome;
	private JTextField textField_Cognome;
	private JTextField textField_DataNascita;
	private JTextField textField_ComuneNascita;
	private JTextField textField_ComuneResidenza;
	private JTextField textField_Via;
	private JTextField textField_NumeroCivico;
	private JTextField textField_CAP;
	
	
	
    
     Inserimento_dati_persona persona; 
     private JTextField textField_provincia;
	
	
	
	public Inserimento_dati_persona() {
		
         persona = this; 
		
		
		setTitle("Inserimento Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 617);
		contentPane_provincia = new JPanel();
		contentPane_provincia.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_provincia);
		contentPane_provincia.setLayout(null);
		
		JLabel lblNewLabel_CF = new JLabel("Codice fiscale:");
		lblNewLabel_CF.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_CF.setBounds(31, 49, 178, 34);
		contentPane_provincia.add(lblNewLabel_CF);
		
		JLabel lblNewLabel_nome = new JLabel("Nome: ");
		lblNewLabel_nome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_nome.setBounds(31, 79, 178, 29);
		contentPane_provincia.add(lblNewLabel_nome);
		
		JLabel lblNewLabel_cognome = new JLabel("Cognome :");
		lblNewLabel_cognome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_cognome.setBounds(31, 104, 178, 29);
		contentPane_provincia.add(lblNewLabel_cognome);
		
		JLabel lblNewLabel_dataNascita = new JLabel("Data di nascita:");
		lblNewLabel_dataNascita.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_dataNascita.setBounds(31, 129, 178, 29);
		contentPane_provincia.add(lblNewLabel_dataNascita);
		
		JLabel lblNewLabel_comuneNascita = new JLabel("Comune di nascita: ");
		lblNewLabel_comuneNascita.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_comuneNascita.setBounds(31, 151, 178, 39);
		contentPane_provincia.add(lblNewLabel_comuneNascita);
		
		JLabel lblNewLabel_comuneResidenza = new JLabel("Comune di residenza: ");
		lblNewLabel_comuneResidenza.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_comuneResidenza.setBounds(31, 180, 178, 34);
		contentPane_provincia.add(lblNewLabel_comuneResidenza);
		
		JLabel lblNewLabel_via = new JLabel("Via: ");
		lblNewLabel_via.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_via.setBounds(31, 201, 178, 38);
		contentPane_provincia.add(lblNewLabel_via);
		
		JLabel lblNewLabel_numeroCivico = new JLabel("Numero civico: ");
		lblNewLabel_numeroCivico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_numeroCivico.setBounds(31, 225, 178, 39);
		contentPane_provincia.add(lblNewLabel_numeroCivico);
		
		JLabel lblNewLabel_cap = new JLabel("CAP:");
		lblNewLabel_cap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_cap.setBounds(31, 250, 178, 39);
		contentPane_provincia.add(lblNewLabel_cap);
		
		JLabel lblNewLabel_sesso = new JLabel("Identit\u00E0 sessuale:");
		lblNewLabel_sesso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_sesso.setBounds(31, 275, 178, 39);
		contentPane_provincia.add(lblNewLabel_sesso);
		
		JLabel lblNewLabel_provincia = new JLabel("Provincia di nascita: ");
		lblNewLabel_provincia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_provincia.setBounds(31, 305, 184, 34);
		contentPane_provincia.add(lblNewLabel_provincia);
		
		JLabel lblNewLabel_managerOsportivo = new JLabel("Manager o tesserato?");
		lblNewLabel_managerOsportivo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_managerOsportivo.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_managerOsportivo.setBounds(31, 339, 213, 39);
		contentPane_provincia.add(lblNewLabel_managerOsportivo);
		
		JLabel lblNewLabel_12 = new JLabel("(true=tesserato, false=manager)");
		lblNewLabel_12.setBounds(31, 365, 162, 14);
		contentPane_provincia.add(lblNewLabel_12);
		
		textField_CF = new JTextField();
		textField_CF.setBounds(249, 60, 358, 20);
		contentPane_provincia.add(textField_CF);
		textField_CF.setColumns(10);
		
		textField_Nome = new JTextField();
		textField_Nome.setColumns(10);
		textField_Nome.setBounds(249, 87, 358, 20);
		contentPane_provincia.add(textField_Nome);
		
		textField_Cognome = new JTextField();
		textField_Cognome.setColumns(10);
		textField_Cognome.setBounds(249, 112, 358, 20);
		contentPane_provincia.add(textField_Cognome);
		
		textField_DataNascita = new JTextField();
		textField_DataNascita.setColumns(10);
		textField_DataNascita.setBounds(249, 137, 358, 20);
		contentPane_provincia.add(textField_DataNascita);
		
		textField_ComuneNascita = new JTextField();
		textField_ComuneNascita.setColumns(10);
		textField_ComuneNascita.setBounds(249, 164, 358, 20);
		contentPane_provincia.add(textField_ComuneNascita);
		
		textField_ComuneResidenza = new JTextField();
		textField_ComuneResidenza.setColumns(10);
		textField_ComuneResidenza.setBounds(249, 191, 358, 20);
		contentPane_provincia.add(textField_ComuneResidenza);
		
		textField_Via = new JTextField();
		textField_Via.setColumns(10);
		textField_Via.setBounds(249, 214, 358, 20);
		contentPane_provincia.add(textField_Via);
		
		textField_NumeroCivico = new JTextField();
		textField_NumeroCivico.setColumns(10);
		textField_NumeroCivico.setBounds(249, 238, 358, 20);
		contentPane_provincia.add(textField_NumeroCivico);
		
		textField_CAP = new JTextField();
		textField_CAP.setColumns(10);
		textField_CAP.setBounds(249, 263, 358, 20);
		contentPane_provincia.add(textField_CAP);
		
		JComboBox sesso = new JComboBox();
		sesso.setBounds(249, 287, 46, 22);
		contentPane_provincia.add(sesso);
		sesso.addItem("M");
		sesso.addItem("F");
		
		JComboBox ManagerOtesserato = new JComboBox();
		ManagerOtesserato.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ManagerOtesserato.setBounds(249, 344, 101, 34);
		contentPane_provincia.add(ManagerOtesserato);
		ManagerOtesserato.addItem("Manager");
		ManagerOtesserato.addItem("Tesserato");
		
		JButton bottone_procedi = new JButton("Procedi all'inserimento");
		bottone_procedi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				boolean sos = true;
			     Driver driver = new Driver(); 

	
           driver.controlloDati(textField_CF, textField_Nome, textField_Cognome, textField_DataNascita,  sesso.getSelectedIndex(), textField_ComuneNascita, textField_provincia, ManagerOtesserato.getSelectedIndex(), persona);      
			     
// 	  !
//	System.out.println(ManagerOtesserato.getSelectedIndex().toString());
//	if(driver.controlloDati( textField_CF, textField_Nome, textField_Cognome, textField_DataNascita,
//								 sesso.getSelectedIndex(), textField_ComuneNascita, textField_provincia,
//								 ManagerOtesserato.getSelectedIndex(), persona) != true) {
//		
//		    while(driver.controlloDati( textField_CF, textField_Nome, textField_Cognome, textField_DataNascita,
//								 sesso.getSelectedIndex(), textField_ComuneNascita, textField_provincia,
//								 ManagerOtesserato.getSelectedIndex(), persona) ) {
//			
//		}
//	}
//	else {
//		
//		
//		  
//	  }
//		 System.out.println("Sei nel matrix");
//										
//						
//				
//						
//
//			persona.setVisible(false);
//			Inserimento_persona_tesserata tesserato = new Inserimento_persona_tesserata(); 
//			tesserato.setVisible(true);
//						
//  	}
			}
	});
		bottone_procedi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bottone_procedi.setBounds(693, 463, 162, 60);
		contentPane_provincia.add(bottone_procedi);
		
		JButton bottone_annulla = new JButton("Annulla inserimento");
		bottone_annulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		bottone_annulla.setBounds(31, 463, 162, 60);
		contentPane_provincia.add(bottone_annulla);
		
		textField_provincia = new JTextField();
		textField_provincia.setBounds(249, 316, 86, 20);
		contentPane_provincia.add(textField_provincia);
		textField_provincia.setColumns(10);
		
	}
}
