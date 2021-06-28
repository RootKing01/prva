package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import Controller.Driver;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import java.awt.Window.Type;

public class ConfermaPasswordTesserato extends JDialog {


	private final JPanel contentPanel = new JPanel();
	private Driver driver = new Driver();
	private JPasswordField passwordField_password_tesserato;
	
	
	public ConfermaPasswordTesserato( JTextField codiceFiscale_tesserato, String codiceFiscaleManager ) 
	{
		setResizable(false);

		setBounds(100, 100, 928, 535);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("PASSWORD TESSERATO");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(257, 11, 395, 45);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Procedere con l'immissione della password");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(32, 120, 416, 25);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("dell'utente desiderato:");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_2.setBounds(42, 144, 350, 25);
			contentPanel.add(lblNewLabel_2);
		}
		
		passwordField_password_tesserato = new JPasswordField();
		passwordField_password_tesserato.setBounds(581, 126, 282, 25);
		contentPanel.add(passwordField_password_tesserato);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						
						boolean password_corretta = driver.controlloPasswordDataBase(passwordField_password_tesserato , codiceFiscale_tesserato );
						
						if( password_corretta )
						{
							try 
							{
								driver.aggiungiManagerAtesserato(codiceFiscale_tesserato.getText(),  codiceFiscaleManager);
								
							} 
							catch (SQLException e1) 
							{
								
								e1.printStackTrace();
								
							}
							
							
						}
						contentPanel.setVisible(false);
						// pannello Manager
						new pannelloManager( codiceFiscaleManager );
						// contentPanel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						contentPanel.setVisible(false);
//						pannelloManager pannello_manager = new pannelloManager();
//						pannello_manager.setVisible(true);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
