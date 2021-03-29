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
	private JTextField textFieldCF;
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	private JTextField textFieldDataNascita;
	private JTextField textFieldComuneNascita;
	private JTextField textFieldComuneResidenza;
	private JTextField textFieldVia;
	private JTextField textFieldNumeroCivico;
	private JTextField textFieldCAP;
	
	
	
    Inserimento_dati_persona persona; 
    private JTextField textFieldProvincia;
	
	
	
	public Inserimento_dati_persona() {
		
         persona = this; 
		
		
		setTitle("Inserimento Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 617);
		contentPane_provincia = new JPanel();
		contentPane_provincia.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_provincia);
		contentPane_provincia.setLayout(null);
		
		JLabel labelCodiceFiscale = new JLabel("Codice fiscale:");
		labelCodiceFiscale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCodiceFiscale.setBounds(31, 49, 178, 34);
		contentPane_provincia.add(labelCodiceFiscale);
		
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
		labelComuneNascita.setBounds(31, 151, 178, 39);
		contentPane_provincia.add(labelComuneNascita);
		
		JLabel labelComuneResidenza = new JLabel("Comune di residenza: ");
		labelComuneResidenza.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelComuneResidenza.setBounds(31, 180, 178, 34);
		contentPane_provincia.add(labelComuneResidenza);
		
		JLabel labelVia = new JLabel("Via: ");
		labelVia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelVia.setBounds(31, 201, 178, 38);
		contentPane_provincia.add(labelVia);
		
		JLabel labelNumeroCivico = new JLabel("Numero civico: ");
		labelNumeroCivico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNumeroCivico.setBounds(31, 225, 178, 39);
		contentPane_provincia.add(labelNumeroCivico);
		
		JLabel label_CAP = new JLabel("CAP:");
		label_CAP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_CAP.setBounds(31, 250, 178, 39);
		contentPane_provincia.add(label_CAP);
		
		JLabel labelSesso = new JLabel("Identit\u00E0 sessuale:");
		labelSesso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelSesso.setBounds(31, 275, 178, 39);
		contentPane_provincia.add(labelSesso);
		
		JLabel labelProvincia = new JLabel("Provincia di nascita: ");
		labelProvincia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelProvincia.setBounds(31, 305, 184, 34);
		contentPane_provincia.add(labelProvincia);
		
		JLabel labelManagerOTesserato = new JLabel("Manager o tesserato?");
		labelManagerOTesserato.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelManagerOTesserato.setVerticalAlignment(SwingConstants.TOP);
		labelManagerOTesserato.setBounds(31, 347, 213, 39);
		contentPane_provincia.add(labelManagerOTesserato);
		
		textFieldCF = new JTextField();
		textFieldCF.setBounds(249, 60, 358, 20);
		contentPane_provincia.add(textFieldCF);
		textFieldCF.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(249, 87, 358, 20);
		contentPane_provincia.add(textFieldNome);
		
		textFieldCognome = new JTextField();
		textFieldCognome.setColumns(10);
		textFieldCognome.setBounds(249, 112, 358, 20);
		contentPane_provincia.add(textFieldCognome);
		
		textFieldDataNascita = new JTextField();
		textFieldDataNascita.setColumns(10);
		textFieldDataNascita.setBounds(249, 137, 358, 20);
		contentPane_provincia.add(textFieldDataNascita);
		
		textFieldComuneNascita = new JTextField();
		textFieldComuneNascita.setColumns(10);
		textFieldComuneNascita.setBounds(249, 164, 358, 20);
		contentPane_provincia.add(textFieldComuneNascita);
		
		textFieldComuneResidenza = new JTextField();
		textFieldComuneResidenza.setColumns(10);
		textFieldComuneResidenza.setBounds(249, 191, 358, 20);
		contentPane_provincia.add(textFieldComuneResidenza);
		
		textFieldVia = new JTextField();
		textFieldVia.setColumns(10);
		textFieldVia.setBounds(249, 214, 358, 20);
		contentPane_provincia.add(textFieldVia);
		
		textFieldNumeroCivico = new JTextField();
		textFieldNumeroCivico.setColumns(10);
		textFieldNumeroCivico.setBounds(249, 238, 358, 20);
		contentPane_provincia.add(textFieldNumeroCivico);
		
		textFieldCAP = new JTextField();
		textFieldCAP.setColumns(10);
		textFieldCAP.setBounds(249, 263, 358, 20);
		contentPane_provincia.add(textFieldCAP);
		
		JComboBox comboBoxSesso = new JComboBox();
		comboBoxSesso.setBounds(249, 287, 46, 22);
		contentPane_provincia.add(comboBoxSesso);
		comboBoxSesso.addItem("M");
		comboBoxSesso.addItem("F");
		
		JComboBox comboBoxManagerOtesserato = new JComboBox();
		comboBoxManagerOtesserato.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxManagerOtesserato.setBounds(249, 344, 101, 34);
		contentPane_provincia.add(comboBoxManagerOtesserato);
		comboBoxManagerOtesserato.addItem("Manager");
		comboBoxManagerOtesserato.addItem("Tesserato");
		
		JButton bottoneAnnulla = new JButton("Annulla inserimento");
		bottoneAnnulla.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bottoneAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		bottoneAnnulla.setBounds(31, 463, 178, 60);
		contentPane_provincia.add(bottoneAnnulla);
		
		textFieldProvincia = new JTextField();
		textFieldProvincia.setBounds(249, 316, 86, 20);
		contentPane_provincia.add(textFieldProvincia);
		textFieldProvincia.setColumns(10);
		
		JButton bottoneAvanti = new JButton("Avanti");
		bottoneAvanti.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bottoneAvanti.setBounds(588, 463, 178, 60);
		contentPane_provincia.add(bottoneAvanti);
		
	}
}
