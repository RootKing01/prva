package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextArea;

public class Errore_Inserimento_Dati extends JDialog {

	private final JPanel contentPanel = new JPanel();




	public Errore_Inserimento_Dati( String [] stringa_di_controllo ) 
	{
		
		//setLocation(500, 500);
        setLocationRelativeTo( null );
		
		setTitle("Errore Inserimento Dati");

		contentPanel.setBounds( WIDTH - WIDTH/2, HEIGHT - HEIGHT/2, 500, 500 );
		setBounds(200, 200, 781, 524);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		contentPanel.setLayout(null);
		{
			
			TextArea textArea = new TextArea();
			textArea.setText("\n\n");
			
			for( int i = 0; i < stringa_di_controllo.length; i++ )
			{
				if( !(stringa_di_controllo[i] == null) )
				{
					textArea.setText( "\t\t" + textArea.getText() + stringa_di_controllo[i] + "\n" );	
				}
				
					
			}
			
			textArea.setEditable(false);
			textArea.setBounds(0, 0, 765, 452);
			contentPanel.add(textArea);
		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}

			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
