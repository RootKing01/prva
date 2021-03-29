package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Inserimento_persona_tesserata extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodiceFiscaleMenagerAssociato;

	
	/**
	 * Create the frame.
	 */
	public Inserimento_persona_tesserata() {
		setTitle("Dati Tesserato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldCodiceFiscaleMenagerAssociato = new JTextField();
		textFieldCodiceFiscaleMenagerAssociato.setBackground(new Color(255, 255, 255));
		textFieldCodiceFiscaleMenagerAssociato.setText("caio");
		textFieldCodiceFiscaleMenagerAssociato.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textFieldCodiceFiscaleMenagerAssociato.setBounds(98, 79, 389, 43);
		contentPane.add(textFieldCodiceFiscaleMenagerAssociato);
		textFieldCodiceFiscaleMenagerAssociato.setColumns(10);
		
		JLabel labelCodiceFiscaleMenagerAssociato = new JLabel("Codice fiscale del manager associato*: ");
		labelCodiceFiscaleMenagerAssociato.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelCodiceFiscaleMenagerAssociato.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCodiceFiscaleMenagerAssociato.setBounds(98, 26, 441, 38);
		contentPane.add(labelCodiceFiscaleMenagerAssociato);
		
		JLabel labelGettoniNazionale = new JLabel("Gettoni nazionale:");
		labelGettoniNazionale.setHorizontalAlignment(SwingConstants.RIGHT);
		labelGettoniNazionale.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelGettoniNazionale.setBounds(98, 133, 215, 71);
		contentPane.add(labelGettoniNazionale);
		
		JComboBox comboBoxGettoniNazionale = new JComboBox();
		comboBoxGettoniNazionale.setFont(new Font("Tahoma", Font.PLAIN, 26));
		comboBoxGettoniNazionale.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8"}));
		comboBoxGettoniNazionale.setBounds(349, 141, 78, 43);
		contentPane.add(comboBoxGettoniNazionale);
		
		JLabel labelCodiceFederazioneSportiva = new JLabel("Codice Federazione Sportiva: ");
		labelCodiceFederazioneSportiva.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCodiceFederazioneSportiva.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelCodiceFederazioneSportiva.setBounds(66, 195, 370, 94);
		contentPane.add(labelCodiceFederazioneSportiva);
		
		JComboBox comboBoxCodiceFederazioneSportiva = new JComboBox();
		comboBoxCodiceFederazioneSportiva.setBounds(461, 216, 78, 43);
		contentPane.add(comboBoxCodiceFederazioneSportiva);
		
		JButton bottoneAvanti = new JButton("Avanti");
		bottoneAvanti.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bottoneAvanti.setBounds(475, 326, 178, 60);
		contentPane.add(bottoneAvanti);
		
		JButton bottoneAnnulla = new JButton("Annulla");
		bottoneAnnulla.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bottoneAnnulla.setBounds(36, 326, 178, 60);
		contentPane.add(bottoneAnnulla);
	}
}
