package demoGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerGrafica1;

import java.awt.Point;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.JInternalFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Dialog.ModalExclusionType;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame {

	
	private JPanel contentPane;
	private final JPasswordField passwordField = new JPasswordField();
	
	public ControllerGrafica1 controller;
	

	/**
	 * Create the frame.
	 */
	public LoginFrame(ControllerGrafica1 controller) {
		
		this.controller = controller;
		
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setFont(new Font("Arial", Font.PLAIN, 20));
		setType(Type.POPUP);
		setResizable(false);
		setAlwaysOnTop(true);
		setBackground(UIManager.getColor("CheckBox.highlight"));
		setTitle("LOGIN/USER");
		setLocation(new Point(0, 476));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Lenovo\\Pictures\\Camera Roll\\albero1.jfif"));
		setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 352, 464);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBox.highlight"));
		contentPane.setLocation(new Point(100, 200));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lableLogin = new JLabel("LOGIN");
		lableLogin.setBounds(93, 10, 153, 90);
		lableLogin.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		lableLogin.setForeground(UIManager.getColor("CheckBox.foreground"));
		lableLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lableLogin.setBackground(Color.BLACK);
		contentPane.add(lableLogin);
		
		JLabel lblNome = new JLabel("Email");
		lblNome.setBounds(10, 108, 129, 84);
		lblNome.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblNome.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setForeground(Color.BLACK);
		lblNome.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		lblNome.setBackground(Color.BLACK);
		contentPane.add(lblNome);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 192, 129, 84);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		lblPassword.setBackground(Color.BLACK);
		contentPane.add(lblPassword);
		
		JFormattedTextField emaliTA = new JFormattedTextField();
		emaliTA.setBounds(156, 128, 153, 49);
		emaliTA.setDragEnabled(true);
		emaliTA.setToolTipText("Inserire Email");
		emaliTA.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		contentPane.add(emaliTA);
		passwordField.setBounds(156, 215, 153, 49);
		contentPane.add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 95, 296, 27);
		contentPane.add(separator);
		
		JButton bottoneLogin = new JButton("commit");
		bottoneLogin.setFont(new Font("Sitka Small", Font.PLAIN, 20));
		bottoneLogin.setBounds(156, 336, 153, 50);
		contentPane.add(bottoneLogin);
		bottoneLogin.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.controlloCredenziali(emaliTA.getText(), passwordField.getText());
				
			}
		});
		
		
		
	}
}
