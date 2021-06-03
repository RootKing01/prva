package Controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextArea;

public class Errore_Inserimento_Dati extends JDialog {

	private final JPanel contentPanel = new JPanel();




	public Errore_Inserimento_Dati( String [] stringa_di_controllo ) {

		setTitle("Errore Inserimento Dati");

		setBounds(100, 100, 788, 348);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		contentPanel.setLayout(null);
		{
			TextArea textArea = new TextArea();
			for( int i = 0; i < stringa_di_controllo.length; i++ )
			{
				textArea.setText( textArea.getText() + stringa_di_controllo[i] + "\n" );	
			}
			
			textArea.setEditable(false);
			textArea.setBounds(0, 0, 772, 276);
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
