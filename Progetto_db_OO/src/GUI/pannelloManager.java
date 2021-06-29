package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassiDAO.TesseratoDAO;
import Controller.Driver;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;

public class pannelloManager extends JFrame 
{

	private JPanel contentPane;
	private Driver driver = new Driver(); 
	private JTextField textField_codiceFiscale;
	private JTextField textField_codiceFiscale_tesserato;


	// esci aggiungi_ed_elimina_contratti recap_manager  tesserato_che_porta_magior_guadagno
	// sorgenti di intoito per il tesserato 
	
	public pannelloManager( String codiceFiscaleManager ) 
	{
		
		schermata_base(codiceFiscaleManager);
		//modifica_contratto();
		//eliminaManagerDaTesserato();
		//aggiungiManagerAtesserato(codiceFiscaleManager);
		//recap_tesserati(codiceFiscaleManager);
		
	}
	
	private void schermata_base(String codiceFiscaleManager)
	{
			
		contentPane = set();
		
		JLabel lblNewLabel = new JLabel("BENVENUTO");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(278, 11, 257, 44);
		contentPane.add(lblNewLabel);
		
		JButton bottone_recap = new JButton("RECAP TESSERATI");
		bottone_recap.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				recap_tesserati(codiceFiscaleManager);
			}
		});
		bottone_recap.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bottone_recap.setBounds(303, 112, 299, 54);
		contentPane.add(bottone_recap);
		
		JButton bottone_ASSOCIA_TESSERATO = new JButton("ASSOCIA TESSERATO");
		bottone_ASSOCIA_TESSERATO.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				aggiungiManagerAtesserato(codiceFiscaleManager);
			}
		});
		bottone_ASSOCIA_TESSERATO.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bottone_ASSOCIA_TESSERATO.setBounds(303, 214, 299, 54);
		contentPane.add(bottone_ASSOCIA_TESSERATO);
		
		
		JButton bottone_dissocia_tesserato = new JButton("DISSOCIA TESSERATO");
		bottone_dissocia_tesserato.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				eliminaManagerDaTesserato( codiceFiscaleManager );
			}
		});
		bottone_dissocia_tesserato.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bottone_dissocia_tesserato.setBounds(303, 316, 299, 54);
		contentPane.add(bottone_dissocia_tesserato);
		
		
		JButton bottone_esci = new JButton("ESCI");
		bottone_esci.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				esci();
			}
		});
		bottone_esci.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bottone_esci.setBounds(303, 422, 299, 54);
		contentPane.add(bottone_esci);
		
	}
	
	private JPanel set()
	{
		
		//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 617); 
		JPanel pannello = new JPanel();
		pannello.setBackground(Color.DARK_GRAY);
		pannello.setBorder(new EmptyBorder(5, 5, 5, 5));
		pannello.setLayout(null);
		setContentPane( pannello );		
		//
		
		return pannello;
	}
	
	private void recap_tesserati( String codiceFiscaleManager ) 
	{
		
		contentPane.setVisible( false );
		contentPane = set();
		
		
		JLabel lblNewLabel_8 = new JLabel("RECAP CONTRATTI");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_8.setBounds(260, 0, 323, 44);
		contentPane.add(lblNewLabel_8);
		
		
		JLabel numero_tesserati = new JLabel("New label");
		numero_tesserati.setForeground(Color.WHITE);
		numero_tesserati.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numero_tesserati.setBounds(301, 446, 247, 26);
		contentPane.add(numero_tesserati);
		
		
		TextArea area_recap_totale = new TextArea();
		area_recap_totale.setBackground(new Color(255, 255, 255));
		area_recap_totale.setEditable(false);
		area_recap_totale.setBounds(25, 57, 821, 383);
		contentPane.add(area_recap_totale);
		
		
		JButton bottone_indietro = new JButton("INDIETRO");
		bottone_indietro.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				schermata_base( codiceFiscaleManager );
			}
		});
		bottone_indietro.setFont(new Font("Tahoma", Font.PLAIN, 30));
		bottone_indietro.setBounds(25, 480, 183, 56);
		contentPane.add(bottone_indietro);
	
		
		
		int numero_tesserati_manager = 0; 
		int count = 1;
		
		try
		{
			
			
			numero_tesserati_manager = driver.tutti_i_tesserati_manager( codiceFiscaleManager ).size();	
			
			// label
			numero_tesserati.setText( "NUMERO TESSERATI GESTITI:\t" + numero_tesserati_manager);
			
			
			// text area
			area_recap_totale.setText( area_recap_totale.getText() + 
										"Codice fiscale\t\tCodice fiscale manager\tGettone nazionale\t"+
										"Codice fiderazione sportiva\tCodice contratto\t\tData inizio\t"+
										"Data fine\tRemunerazione contratto\t\tParcella manager\t"+
										"Partiva IVA sponsor\tPartita IVA club\n");
			
			
			ArrayList<String> contratti_manager = driver.recupero_contratti_manager(codiceFiscaleManager);
				
			for( String e : contratti_manager )
			{
				
				area_recap_totale.setText( area_recap_totale.getText() + "\n"+ count + "# "+ e);
				
				count++;
				
			}
		
		}
		catch (SQLException e1) 
		{
		
			e1.printStackTrace();
		}
	
		
		
		
	}
	
	private void modifica_contratto()
	{
		contentPane.setVisible( false );

		contentPane = set();
	}
	
	private void aggiungiManagerAtesserato(String codiceFiscaleManager) 
	{ 
		contentPane.setVisible( false );
		
		contentPane = set();
		
		JLabel lblNewLabel_6 = new JLabel("ASSOCIA TESSERATO");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_6.setBounds(228, 11, 361, 55);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Inserisci il codice fiscale del tesserato da associare:\r\n");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(10, 124, 473, 45);
		contentPane.add(lblNewLabel_7);
		
		textField_codiceFiscale_tesserato = new JTextField();
		textField_codiceFiscale_tesserato.setBounds(545, 136, 297, 29);
		contentPane.add(textField_codiceFiscale_tesserato);
		textField_codiceFiscale_tesserato.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("ASSOCIA");
		btnNewButton_2.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
			   ConfermaPasswordTesserato conferma_password = new ConfermaPasswordTesserato(textField_codiceFiscale_tesserato, codiceFiscaleManager);
			   conferma_password.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_2.setBounds(620, 428, 211, 45);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("INDIETRO");
		btnNewButton_3.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				contentPane.setVisible( false );
			    schermata_base(codiceFiscaleManager);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_3.setBounds(32, 428, 211, 45);
		contentPane.add(btnNewButton_3);
		
	}
	
	private void eliminaManagerDaTesserato(String codiceFiscaleManager) 
	{
		contentPane.setVisible( false );

		contentPane = set();
		
		JLabel lblNewLabel_1 = new JLabel("RIMUOVI TESSERATO");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(257, 11, 334, 51);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Inserisci codice fiscale del tesserato:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(25, 116, 334, 43);
		contentPane.add(lblNewLabel_2);
		
		textField_codiceFiscale = new JTextField();
		textField_codiceFiscale.setBounds(464, 116, 294, 35);
		contentPane.add(textField_codiceFiscale);
		textField_codiceFiscale.setColumns(10);
		
		JButton btnNewButton = new JButton("PROCEDI");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				try 
				{
					
					driver.cancellaMangerByCodiceFiscale( textField_codiceFiscale.getText() );
					
				} 
				catch (SQLException e1) 
				{
					
					e1.printStackTrace();
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(582, 409, 232, 51);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("INDIETRO");
		btnNewButton_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				contentPane.setVisible( false );
			    schermata_base(codiceFiscaleManager);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.setBounds(25, 409, 232, 51);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Immettendo il codice fiscale del tesserato con il quale si \u00E8 \r\n");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(0, 170, 876, 111);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("associati, e cliccando su procedi ,\r\nverr\u00E0 eliminata  la correlazione");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(20, 219, 866, 106);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("tra il manager (tu, appunto) e il tesserato inserito");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(41, 292, 808, 62);
		contentPane.add(lblNewLabel_5);
	
	}
	
	private void esci()
	{
		
		contentPane.setVisible( false );
		
		General schermata_generale = new General();
		schermata_generale.setVisible( true );
		
	}
}
