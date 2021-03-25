package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Driver;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ErroreCodiceFiscale extends JDialog {

	private final JPanel errore_codice_fiscale = new JPanel();

     Inserimento_dati_persona persona;
     Driver d; 
	
	
	/**
	 * Create the dialog.
	 */
	public ErroreCodiceFiscale() {

	     this.d = d; 
	     
		setTitle("ERRORE VODICE FISCALE");
		setBounds(100, 100, 999, 432);
		getContentPane().setLayout(new BorderLayout());
		errore_codice_fiscale.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(errore_codice_fiscale, BorderLayout.CENTER);
		errore_codice_fiscale.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IL CODICE FISCALE DEVE ESSERE DI 16 CARATTERI");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(60, 123, 840, 171);
		errore_codice_fiscale.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ATTENZIONE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(373, 11, 286, 64);
		errore_codice_fiscale.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ERRORE:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(408, 86, 405, 64);
		errore_codice_fiscale.add(lblNewLabel_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton tornaAdati = new JButton("OK");
				tornaAdati.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						errore_codice_fiscale.setVisible(false); 
//						persona.setVisible(true);  // err
					}
				});
				tornaAdati.setActionCommand("OK");
				buttonPane.add(tornaAdati);
				getRootPane().setDefaultButton(tornaAdati);
			}
		}
	}
}
