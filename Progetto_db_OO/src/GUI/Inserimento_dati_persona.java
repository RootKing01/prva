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
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;

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
    ErroreInserimento errore = new ErroreInserimento(this);
    private Persona_creata persona_creata;
    
	
	
	
	public Inserimento_dati_persona() {
		
         persona = this; 
        
		 
		
		setTitle("Inserimento Persona");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 617);
		contentPane_provincia = new JPanel();
		contentPane_provincia.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_provincia);
		contentPane_provincia.setLayout(null);
		
		JLabel labelNome = new JLabel("Nome: ");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNome.setBounds(31, 79, 178, 29);
		contentPane_provincia.add(labelNome);
		
		JLabel labelCognome = new JLabel("Cognome :");
		labelCognome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCognome.setBounds(31, 104, 178, 29);
		contentPane_provincia.add(labelCognome);
		
		JLabel labelDataNascita = new JLabel("Data di nascita:");
		labelDataNascita.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelDataNascita.setBounds(31, 129, 178, 29);
		contentPane_provincia.add(labelDataNascita);
		
		JLabel labelComuneNascita = new JLabel("Comune di nascita: ");
		labelComuneNascita.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelComuneNascita.setBounds(31, 169, 178, 39);
		contentPane_provincia.add(labelComuneNascita);
		
		JLabel labelComuneResidenza = new JLabel("Comune di residenza: ");
		labelComuneResidenza.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelComuneResidenza.setBounds(31, 205, 208, 34);
		contentPane_provincia.add(labelComuneResidenza);
		
		JLabel labelVia = new JLabel("Via: ");
		labelVia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelVia.setBounds(31, 224, 178, 38);
		contentPane_provincia.add(labelVia);
		
		JLabel labelNumeroCivico = new JLabel("Numero civico: ");
		labelNumeroCivico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNumeroCivico.setBounds(31, 250, 178, 39);
		contentPane_provincia.add(labelNumeroCivico);
		
		JLabel label_CAP = new JLabel("CAP:");
		label_CAP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_CAP.setBounds(31, 273, 178, 39);
		contentPane_provincia.add(label_CAP);
		
		JLabel labelSesso = new JLabel("Identit\u00E0 di genere:");
		labelSesso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelSesso.setBounds(31, 300, 178, 39);
		contentPane_provincia.add(labelSesso);
		
		JLabel labelProvincia = new JLabel("Provincia di nascita: ");
		labelProvincia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelProvincia.setBounds(31, 339, 184, 34);
		contentPane_provincia.add(labelProvincia);
		
		JLabel labelManagerOTesserato = new JLabel("Manager o tesserato?");
		labelManagerOTesserato.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelManagerOTesserato.setVerticalAlignment(SwingConstants.TOP);
		labelManagerOTesserato.setBounds(26, 383, 213, 39);
		contentPane_provincia.add(labelManagerOTesserato);
		
	    textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(249, 87, 358, 20);
		contentPane_provincia.add(textFieldNome);
		
		textFieldCognome = new JTextField();
		textFieldCognome.setColumns(10);
		textFieldCognome.setBounds(249, 112, 358, 20);
		contentPane_provincia.add(textFieldCognome);
		
		textFieldDataNascita_anno = new JTextField();
		textFieldDataNascita_anno.setColumns(10);
		textFieldDataNascita_anno.setBounds(281, 137, 76, 20);
		contentPane_provincia.add(textFieldDataNascita_anno);
		
		textFieldDataNascita_giorno = new JTextField();
		textFieldDataNascita_giorno.setBounds(520, 137, 76, 20);
		contentPane_provincia.add(textFieldDataNascita_giorno);
		textFieldDataNascita_giorno.setColumns(10);
		
		textFieldDataNascita_mese = new JTextField();
		textFieldDataNascita_mese.setBounds(395, 137, 76, 20);
		contentPane_provincia.add(textFieldDataNascita_mese);
		textFieldDataNascita_mese.setColumns(10);
	
		
		textFieldComuneNascita = new JTextField();
		textFieldComuneNascita.setColumns(10);
		textFieldComuneNascita.setBounds(249, 182, 358, 20);
		contentPane_provincia.add(textFieldComuneNascita);
		
		textFieldComuneResidenza = new JTextField();
		textFieldComuneResidenza.setColumns(10);
		textFieldComuneResidenza.setBounds(249, 216, 358, 20);
		contentPane_provincia.add(textFieldComuneResidenza);
		
		textFieldVia = new JTextField();
		textFieldVia.setColumns(10);
		textFieldVia.setBounds(249, 237, 358, 20);
		contentPane_provincia.add(textFieldVia);
		
		textFieldNumeroCivico = new JTextField();
		textFieldNumeroCivico.setColumns(10);
		textFieldNumeroCivico.setBounds(249, 263, 358, 20);
		contentPane_provincia.add(textFieldNumeroCivico);
		
		textFieldCAP = new JTextField();
		textFieldCAP.setColumns(10);
		textFieldCAP.setBounds(249, 286, 358, 20);
		contentPane_provincia.add(textFieldCAP);
		
		JComboBox comboBoxSesso = new JComboBox();
		comboBoxSesso.setBounds(253, 312, 46, 22);
		contentPane_provincia.add(comboBoxSesso);
		comboBoxSesso.addItem("M");
		comboBoxSesso.addItem("F");
		
		JComboBox comboBoxManagerOtesserato = new JComboBox();
		comboBoxManagerOtesserato.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxManagerOtesserato.setBounds(249, 380, 101, 34);
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
		bottoneAnnulla.setBounds(76, 473, 187, 60);
		contentPane_provincia.add(bottoneAnnulla);
		
		textFieldProvincia = new JTextField();
		textFieldProvincia.setBounds(249, 350, 86, 20);
		contentPane_provincia.add(textFieldProvincia);
		textFieldProvincia.setColumns(10);
		
		
	
		
		
		JButton bottoneAvanti = new JButton("Avanti");
		bottoneAvanti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean flag; 
				String codiceFiscale = null; 
				
				
			
				try {
					
					flag = driver.controlloDati( textFieldNome		, textFieldCognome,		
							textFieldDataNascita_anno , textFieldDataNascita_mese		, textFieldDataNascita_giorno,
							textFieldComuneNascita ,    textFieldComuneResidenza	    ,  
							textFieldCAP 			, textFieldProvincia	);
					
					if(flag)
					{	
						codiceFiscale = driver.creazioneCodiceFiscale(textFieldDataNascita_giorno, textFieldDataNascita_anno, textFieldComuneResidenza, textFieldComuneNascita, textFieldCognome, comboBoxManagerOtesserato, textFieldCAP);
					}
					else
					{
						// non è andato a buon fine 
					}
					
					Date data_nascita = new Date( Integer.parseInt(textFieldDataNascita_anno.toString().trim() ), Integer.parseInt(textFieldDataNascita_mese.toString().trim()) ,  Integer.parseInt(textFieldDataNascita_giorno.toString().trim()) );
					
					persona_creata = new Persona_creata( codiceFiscale,  textFieldNome.toString(), textFieldCognome.toString(), textFieldComuneNascita.toString(), textFieldComuneResidenza.toString(),
																textFieldVia.toString(), textFieldProvincia.toString(),  Integer.parseInt(textFieldNumeroCivico.toString().trim()), Integer.parseInt(textFieldCAP.toString().trim()), data_nascita , comboBoxSesso.toString(),
																comboBoxManagerOtesserato.getSelectedItem().toString() ); 
									
				
					
					persona_tesserata tesserato = new persona_tesserata(persona_creata);
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
		
		
		
		bottoneAvanti.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bottoneAvanti.setBounds(617, 474, 187, 60);
		contentPane_provincia.add(bottoneAvanti);
		
		JLabel lblNewLabel = new JLabel("Anno");
		lblNewLabel.setBounds(249, 140, 46, 14);
		contentPane_provincia.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mese");
		lblNewLabel_1.setBounds(367, 140, 46, 14);
		contentPane_provincia.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Giorno");
		lblNewLabel_2.setBounds(478, 140, 46, 14);
		contentPane_provincia.add(lblNewLabel_2);
		
			
	}
}
