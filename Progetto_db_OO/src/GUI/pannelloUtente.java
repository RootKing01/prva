package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassiDatabase.Contratto;
import ClassiDatabase.contratto_del_tesserato;
import Controller.Driver;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class pannelloUtente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_giorno_fine;
	private JTextField textField_mese_fine;
	private JTextField textField_anno_fine;
	private JTextField textField_remunerazione_contratto;
	private JTextField textField_parcella_manager;
	private JTextField textField_partitaIva;
	private JTextField textField_codiceFiscaleManger;
	private JTextField codiceFiscale_manager;

	

	public pannelloUtente( String codiceFiscale ) 
	{
		
		schermata_base( codiceFiscale );
		//recap_utente( codiceFiscale );
		//riepilogo_dati(codiceFiscale);
		
	}
	
	private void schermata_base(String codiceFiscale )
	{
		//contentPane.setVisible(true);
		contentPane = set();
		
		JLabel lblNewLabel = new JLabel("Benvenuto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(278, 11, 339, 69);
		contentPane.add(lblNewLabel);
		
		JButton bottone_riepilogo_dati = new JButton("RIEPILOGO DATI");
		bottone_riepilogo_dati.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				try 
				{
					riepilogo_dati( codiceFiscale );
					
				} catch (SQLException e1) 
				{
					
					e1.printStackTrace();
				}
					
				
			}
		});
		bottone_riepilogo_dati.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bottone_riepilogo_dati.setBounds(639, 488, 237, 61);
		contentPane.add(bottone_riepilogo_dati);
		
		JButton bottone_aggiungi_contratto = new JButton("AGGIUNGI CONTRATTO");
		bottone_aggiungi_contratto.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				inserisciContratto( codiceFiscale );
				
			}
		});
		bottone_aggiungi_contratto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bottone_aggiungi_contratto.setBounds(297, 91, 301, 61);
		contentPane.add(bottone_aggiungi_contratto);
		
		JButton bottone_aggiungi_manager = new JButton("AGGIUNGI MANAGER");
		bottone_aggiungi_manager.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				aggiungiManager( codiceFiscale );		
				
			}
		});
		bottone_aggiungi_manager.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bottone_aggiungi_manager.setBounds(297, 185, 301, 61);
		contentPane.add(bottone_aggiungi_manager);
		
		JButton bottone_esci = new JButton("ESCI");
		bottone_esci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				pannelloUtente.this.setVisible(false);
				General general = new General();
				general.setVisible(true);
			}
		});
		bottone_esci.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bottone_esci.setBounds(10, 488, 247, 61);
		contentPane.add(bottone_esci);
		
		
		JButton bottone_elimina_manager = new JButton("ELIMINA MANAGER");
		bottone_elimina_manager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				
				Driver driver = new Driver();
				
				try 
				{
					
					driver.cancellaMangerByCodiceFiscale( codiceFiscale );
					
				}
				catch (SQLException e1) 
				{
				
					e1.printStackTrace();
					
				}
			
				
			}
		});
		bottone_elimina_manager.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bottone_elimina_manager.setBounds(297, 281, 301, 61);
		contentPane.add(bottone_elimina_manager);
		
		JButton bottone_recap = new JButton("RECAP UTENTE");
		bottone_recap.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				try 
				{
					recap_utente( codiceFiscale );
					
				} catch (SQLException e1) 
				{
					
					e1.printStackTrace();
				}
			
			}
		});
		bottone_recap.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bottone_recap.setBounds(297, 376, 301, 61);
		contentPane.add( bottone_recap );

		
	}
	
	private void recap_utente( String codiceFiscale ) throws SQLException 
	{
		
		contentPane.setVisible( false );
		contentPane = set();
		
		TextArea textArea_recap_contratti_attivi = new TextArea();
		textArea_recap_contratti_attivi.setFont(null);
		textArea_recap_contratti_attivi.setBounds(10, 51, 866, 444);
		contentPane.add(textArea_recap_contratti_attivi);
		
		JLabel lblNewLabel_14 = new JLabel("RECAP CONTRATTI ATTIVI");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_14.setBounds(215, 0, 430, 45);
		contentPane.add(lblNewLabel_14);
		
		JButton bottone_indietro = new JButton("INDIETRO");
		bottone_indietro.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				contentPane.setVisible( false );
				schermata_base( codiceFiscale );
				
			}
		});
		bottone_indietro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bottone_indietro.setBounds(298, 516, 274, 51);
		contentPane.add(bottone_indietro);
		
		ArrayList<String> contratti_attivi = new ArrayList<>(); 
		
		Driver driver = new Driver();
		
		String contratti_attivi_momento = null; 
		
		
		contratti_attivi = driver.recap_contratti_utente_attivi( codiceFiscale );
		
		
		textArea_recap_contratti_attivi.setText("Codice fiscale\t\tCodice fiscale manager\tGettone nazionale\t"+
												"Codice fiderazione sportiva\tCodice contratto\t\tData inizio\t"+
												"Data fine\tRemunerazione contratto\t\tParcella manager\t"+
												"Partiva IVA sponsor\tPartita IVA club\n");
		
		for( String e : contratti_attivi  )
		{
			
			//System.out.println("ciao" + e.getCodiceFiscale() );
			
			textArea_recap_contratti_attivi.setText( textArea_recap_contratti_attivi.getText() + e);
			
			
			
			
		 /*
			if(e.isClubOsponsor() == true) 
			{
				textArea_recap_contratti_attivi.setText( textArea_recap_contratti_attivi.getText() + "\n" + e.getCodiceFiscale() +" " + e.getCodiceFiscaleManager() +" " + e.getGettoneNazionale() +" "+
						e.getCodiceFederazioneSportiva() +" "+ e.getCodiceContratto() + " " + e.getDataInizio() + " " + e.getDataFine() + " " + e.getRemunerazioneContratto() 
						+ " " + e.getParcellaManager() + " " + e.getPartitaIvaSponsor() );
				
			}
			
			else 
			{
				textArea_recap_contratti_attivi.setText( textArea_recap_contratti_attivi.getText() + "\n" + e.getCodiceFiscale() +" " + e.getCodiceFiscaleManager() + " " + e.getGettoneNazionale() + " "+
						e.getCodiceFederazioneSportiva() + " " + e.getCodiceContratto() + " " + e.getDataInizio() + " " + e.getDataFine() + " " + e.getRemunerazioneContratto() 
						+ " " + e.getParcellaManager() + " "  + e.getPartitaIvaClub());
			}
			
			*/
			
		}
		
		
	}
	
	private void riepilogo_dati( String codice_fiscale ) throws SQLException
	{
		contentPane.setVisible( false );
		contentPane = set();
		
		TextArea riepilogo_dati = new TextArea();
		riepilogo_dati.setEditable(false);
		riepilogo_dati.setFont(new Font("Monospaced", Font.PLAIN, 11));
		riepilogo_dati.setBounds(21, 46, 834, 452);
		contentPane.add(riepilogo_dati);
		
		JLabel lblNewLabel_13 = new JLabel("RIEPILOGO DATI");
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(285, 11, 293, 39);
		contentPane.add(lblNewLabel_13);
		
		JButton riepilogo_indietro = new JButton("INDIETRO");
		riepilogo_indietro.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
				contentPane.setVisible( false );
				schermata_base( codice_fiscale );
				
			}
		});
		riepilogo_indietro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		riepilogo_indietro.setBounds(289, 514, 233, 53);
		contentPane.add(riepilogo_indietro);

		
		Driver driver = new Driver(); 
		
		ArrayList <String> tutti_i_contratti;
		
		tutti_i_contratti = driver.recap_tutti_contratti_utente(codice_fiscale); 
		
		riepilogo_dati.setText( riepilogo_dati.getText() + "\n" + tutti_i_contratti );
		
		riepilogo_dati.setText( "Codice fiscale\t\tCodice fiscale manager\tGettone nazionale\t"+
								"Codice federazione sportiva\t\tCodice contratto\t\tData inizio\t\t"+
								"Data fine\tRemunerazione contratto\t\tParcella manager\t"+
								"Partiva IVA sponsor\tPartita IVA club\n");

		for( String e : tutti_i_contratti  )
       	{
			//System.out.println("ciao" + e.getCodiceFiscale() );

			riepilogo_dati.setText( riepilogo_dati.getText() + e);
		}

		
	}
	
	private void aggiungiManager( String codiceFiscale ) 
	{
		
		contentPane.setVisible( false );
		contentPane = set();
		
		JLabel lblNewLabel_16 = new JLabel("ASSOCIA MANAGER");
		lblNewLabel_16.setForeground(Color.WHITE);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setBounds(235, 57, 382, 55);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Inserisci il codice fiscale del manager");
		lblNewLabel_17.setForeground(Color.WHITE);
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_17.setBounds(10, 149, 442, 36);
		contentPane.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("da associare:");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setForeground(Color.WHITE);
		lblNewLabel_18.setBounds(95, 183, 233, 29);
		contentPane.add(lblNewLabel_18);
		
		codiceFiscale_manager = new JTextField();
		codiceFiscale_manager.setBounds(516, 168, 289, 31);
		contentPane.add(codiceFiscale_manager);
		codiceFiscale_manager.setColumns(10);
		
		JButton bottone_associa = new JButton("ASSOCIA");
		bottone_associa.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Driver driver = new Driver();
				
				try 
				{
					driver.aggiungiManagerAtesserato( codiceFiscale , codiceFiscale_manager.getText() );
					contentPane.setVisible( false );
					schermata_base( codiceFiscale );
				}
				 catch (SQLException e1) 
				{
				    e1.printStackTrace();
				}
				
			}
		});
		bottone_associa.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bottone_associa.setBounds(626, 463, 222, 55);
		contentPane.add(bottone_associa);
		
		JButton bottone_annulla = new JButton("ANNULLA");
		bottone_annulla.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bottone_annulla.setBounds(36, 463, 222, 55);
		contentPane.add(bottone_annulla);
		bottone_annulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				contentPane.setVisible(false);
				schermata_base( codiceFiscale );
			}
		});
		bottone_annulla.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bottone_annulla.setBounds(32, 508, 189, 50);
		contentPane.add( bottone_annulla );
		
		
	}
	
	private void inserisciContratto( String codiceFiscale) 
	{
		
		contentPane.setVisible( false );
		contentPane = set();
		
		JLabel lblNewLabel_1 = new JLabel("INSERISCI CONTRATTO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(228, 11, 434, 64);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Il codice fiscale da associare al contratto:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 141, 383, 37);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(434, 145, 253, 37);
		textField.setColumns(10);
		textField.setText(codiceFiscale); 
		contentPane.add(textField);
		
		JLabel lblNewLabel_3 = new JLabel("Data fine contratto:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 207, 211, 27);
		contentPane.add(lblNewLabel_3);
		
		textField_giorno_fine = new JTextField();
		textField_giorno_fine.setBounds(246, 206, 50, 37);
		contentPane.add(textField_giorno_fine);
		textField_giorno_fine.setColumns(10);
		
		textField_mese_fine = new JTextField();
		textField_mese_fine.setColumns(10);
		textField_mese_fine.setBounds(343, 206, 50, 37);
		contentPane.add(textField_mese_fine);
		
		textField_anno_fine = new JTextField();
		textField_anno_fine.setColumns(10);
		textField_anno_fine.setBounds(456, 206, 50, 37);
		contentPane.add(textField_anno_fine);
		
		JLabel lblNewLabel_4 = new JLabel("GG");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(209, 215, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("MM");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(306, 215, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("YYYY");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(403, 215, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Remunerazione contratto:");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(10, 276, 245, 27);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("(Per stagione sportiva)");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(10, 300, 181, 14);
		contentPane.add(lblNewLabel_8);
		
		textField_remunerazione_contratto = new JTextField();
		textField_remunerazione_contratto.setBounds(287, 278, 106, 31);
		contentPane.add(textField_remunerazione_contratto);
		textField_remunerazione_contratto.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Parcella manager:");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(10, 342, 181, 27);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("(Numero che rappresenta la parcentuale)");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(10, 368, 286, 14);
		contentPane.add(lblNewLabel_10);
		
		textField_parcella_manager = new JTextField();
		textField_parcella_manager.setBounds(287, 349, 106, 33);
		contentPane.add(textField_parcella_manager);
		textField_parcella_manager.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Club o societ\u00E0 sponsor?");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(10, 403, 245, 27);
		contentPane.add(lblNewLabel_11);
		
		JComboBox comboBoxClubOsponsor = new JComboBox();
		comboBoxClubOsponsor.setBounds(287, 409, 106, 22);
		contentPane.add(comboBoxClubOsponsor);
		comboBoxClubOsponsor.addItem("Sponsor"); 
		comboBoxClubOsponsor.addItem("Club"); 
		
		textField_partitaIva = new JTextField();
		textField_partitaIva.setBounds(287, 456, 189, 27);
		contentPane.add(textField_partitaIva);
		textField_partitaIva.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Partita Iva societ\u00E0:");
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_12.setBounds(10, 456, 211, 27);
		contentPane.add(lblNewLabel_12);
		
		JButton btnNewButton_5 = new JButton("INSERISCI");
		btnNewButton_5.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				Driver driver = new Driver();
				
				LocalDate dataInizio = LocalDate.now();
				
				/*
                int anno = Integer.parseInt( textField_anno_fine.getText() );
                int mese = Integer.parseInt( textField_mese_fine.getText() );
				int giorno = Integer.parseInt( textField_giorno_fine.getText() );
				LocalDate dataFine = new LocalDate( anno, mese, giorno );
				*/
				
				String data_finale = textField_anno_fine.getText()+"-"+textField_mese_fine.getText()+"-"+textField_giorno_fine.getText();
				LocalDate dataFine = LocalDate.parse( data_finale );
				
				boolean sponsorOclub; 
				
				float parcellamanager =  (Float.parseFloat(textField_parcella_manager.getText()) * Float.parseFloat(textField_remunerazione_contratto.getText())) / 100; 
				
				if( comboBoxClubOsponsor.getSelectedItem().toString().equals("Club") )
					sponsorOclub = false; 
				else
					sponsorOclub = true; 
				
				Contratto contratto = new Contratto( codiceFiscale, textField_partitaIva.getText(), Float.parseFloat(textField_remunerazione_contratto.getText()),
						                             parcellamanager, dataInizio, dataFine, sponsorOclub
													); 
				
				/*
				public Contratto( String codiceFiscale, String partitaIVA,
						float remunerazioneContratto, float parcellaManager, Date dataInizio, Date dataFine,
						boolean sponsorOcontratto); 
				*/
				
				try 
				{
					driver.inserisciContratto( contratto );
				} 
				catch (SQLException e1) 
				{
				    e1.printStackTrace();
				}
				
				contentPane.setVisible(false);
				schermata_base(codiceFiscale);
				
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_5.setBounds(679, 508, 181, 50);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("INDIETRO");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				contentPane.setVisible(false);
				schermata_base(codiceFiscale);
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_6.setBounds(32, 508, 189, 50);
		contentPane.add(btnNewButton_6);
		
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
}
