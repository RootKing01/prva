package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassiDAO.PersonaDAOpostgre;
import ClassiDAO.TesseratoDAO;
import ClassiDatabase.Comune;
import ClassiDatabase.Persona_creata;
import ClassiDatabase.Tesserato;
import Controller.Driver;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class persona_tesserata extends JFrame {

	
//	public static void main(String[] args) throws SQLException, IOException 
//	{
//	    
//		persona_tesserata tesserato = new persona_tesserata(); 
//		tesserato.setVisible(true);
//
//	}
//	
	
	
	private JPanel contentPane;
	private JTextField textField_codiecFiscale_tesserato;
	private JTextField textField_codiceFiscale_manager;
	private JTextField textField_password;
	
	private Tesserato persona_tesserata;
	private persona_tesserata tesserato;
	



	public persona_tesserata( Persona_creata persona, JFrame dati_persona) throws NumberFormatException, SQLException {
		
		tesserato = this;
		setLocation(500, 500); 
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_codiecFiscale_tesserato = new JTextField();
		textField_codiecFiscale_tesserato.setEditable(false);
		textField_codiecFiscale_tesserato.setBounds(351, 58, 421, 59);
		contentPane.add(textField_codiecFiscale_tesserato);
		textField_codiecFiscale_tesserato.setColumns(10);
		
		textField_codiecFiscale_tesserato.setText(persona.getCodiceFiscale());
		
		JLabel lblNewLabel = new JLabel("Il suo codice fiscale risulta essere: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 60, 295, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Se in possesso, inserire il codice fiscale ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 137, 322, 77);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("del proprio manager:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(10, 166, 279, 48);
		contentPane.add(lblNewLabel_2);
		
		textField_codiceFiscale_manager = new JTextField();
		textField_codiceFiscale_manager.setBounds(351, 149, 428, 59);
		contentPane.add(textField_codiceFiscale_manager);
		textField_codiceFiscale_manager.setColumns(10);
		
		
		JComboBox comboBox_gettoni_nazionale = new JComboBox();
		comboBox_gettoni_nazionale.setBounds(351, 251, 208, 37);
		contentPane.add(comboBox_gettoni_nazionale);
		for(int i = 0; i < 11 ; i++) {
			comboBox_gettoni_nazionale.addItem(i);
		}
		
		
		JLabel lblNewLabel_3 = new JLabel("Indica il numero di gettoni nazionale:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(10, 251, 285, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Seleziona il codice della federazione sportiva");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(10, 322, 341, 37);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("presso la quale sei tesserato:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(20, 343, 285, 31);
		contentPane.add(lblNewLabel_5);
		
		String [] codici_federazioni_sportive = { "AECI" ,"ACI", "FIDAL", "FIBA", "FIBS", "FIB", "FIDS", "FIDASC", "FIGC", "FICK", "FIC", "FCI", "FICR", "FGI", "FIG", "FIGH", "FIGS", "FIH", "FISR", "FIJLKAM", "FMSI", "FMI", "FIM", "FIN", "FIP", "FIPAV", "FIPM", "FIPSAS", "FIPE", "FPI", "FIR", "FIS", "FISW", "FISG", "FISE", "FISI", "FITA", "FIT", "FITET", "UITS", "FITAV", "FITARCO", "FITRI", "FIV" };
		JComboBox comboBox_codiceFederazioneSposrtiva = new JComboBox(codici_federazioni_sportive);
		comboBox_codiceFederazioneSposrtiva.setBounds(353, 325, 206, 37);
		contentPane.add(comboBox_codiceFederazioneSposrtiva);
		
		JButton btnNewButton = new JButton("Avanti");
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
		
			public void mouseClicked(MouseEvent e) {
					
							
				if(textField_codiceFiscale_manager.getText().toString().equals(""))	
				{
				     persona_tesserata = new Tesserato(	persona.getCodiceFiscale(), persona.getNome(), persona.getCognome(),
													    persona.getComuneNascita(), persona.getComuneResidenza(), persona.getVia(),
													    persona.getProvinciaNascita(), persona.getNumeroCivico(), persona.getCAP(),
													    persona.getSesso().toString(), persona.getDataNascita(), null,
													    comboBox_codiceFederazioneSposrtiva.getSelectedItem().toString(),
													    Integer.parseInt( comboBox_gettoni_nazionale.getSelectedItem().toString()),
														persona.getPassword() 
													
													);		
		
				}
				else
				{
					
					
					persona_tesserata = new Tesserato(	persona.getCodiceFiscale(), persona.getNome(), persona.getCognome(),
						    persona.getComuneNascita(), persona.getComuneResidenza(), persona.getVia(),
						    persona.getProvinciaNascita(), persona.getNumeroCivico(), persona.getCAP(),
						    persona.getSesso().toString(), persona.getDataNascita(), textField_codiceFiscale_manager.getText().toString(),
						    comboBox_codiceFederazioneSposrtiva.getSelectedItem().toString(),
						    Integer.parseInt( comboBox_gettoni_nazionale.getSelectedItem().toString()), 
						    persona.getPassword() 
						    
							);
					
				}
					
			      	tesserato.setVisible(false);
			      	dati_persona.setVisible(false);
			      	Driver driver = new Driver(); 
			      	try {
						driver.inserimento_persone_tesserate_database(persona, persona_tesserata);
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
			}
		
		
		
		});
		btnNewButton.setBounds(709, 419, 161, 48);
		contentPane.add(btnNewButton);
		
		int gettoni_nazionale = Integer.parseInt( (String) comboBox_gettoni_nazionale.getSelectedItem().toString()); 
		
		System.out.println("Sono in tesserato e provo a procedere con la creazione di un tesserato\n");
		
		
		
		
		System.out.println("Ho eseguito la creazione della persona tesserata\n");
		
		/*
		(  persona.getCodiceFiscale(), persona.getNome(), persona.getCognome(), persona.getComuneNascita(), persona.getComuneResidenza(),
											persona.getVia(), persona.getProvinciaNascita(), persona.getNumeroCivico(), persona.getCAP(), persona.getSesso(), persona.getDataNascita(), textField_codiceFiscale_manager.toString() , comboBox_codiceFederazioneSposrtiva.getSelectedItem().toString(),
											gettoni_nazionale 
										);
		
		*/
	}
}
