package demoGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setAlwaysOnTop(true);
		setResizable(false);
		setBackground(Color.BLACK);
		setTitle("LOGIN/USER");
		setLocation(new Point(200, 400));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Lenovo\\Pictures\\Camera Roll\\albero1.jfif"));
		setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 352, 362);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setLocation(new Point(100, 200));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lableLogin = new JLabel("LOGIN");
		lableLogin.setBounds(68, 0, 171, 61);
		lableLogin.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		lableLogin.setForeground(Color.WHITE);
		lableLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lableLogin.setBackground(Color.BLACK);
		contentPane.add(lableLogin);
		
		JLabel lblNome = new JLabel("Email");
		lblNome.setBounds(10, 79, 74, 66);
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		lblNome.setBackground(Color.BLACK);
		contentPane.add(lblNome);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 156, 113, 61);
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		lblPassword.setBackground(Color.BLACK);
		contentPane.add(lblPassword);
		
		JFormattedTextField formattedTextFieldEmailUser = new JFormattedTextField();
		formattedTextFieldEmailUser.setBounds(158, 91, 171, 47);
		formattedTextFieldEmailUser.setDragEnabled(true);
		formattedTextFieldEmailUser.setToolTipText("Inserire Email");
		formattedTextFieldEmailUser.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		contentPane.add(formattedTextFieldEmailUser);
		
		JFormattedTextField formattedTextFieldPasswordUser = new JFormattedTextField();
		formattedTextFieldPasswordUser.setBackground(Color.CYAN);
		formattedTextFieldPasswordUser.setToolTipText("Inserire Password");
		formattedTextFieldPasswordUser.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		formattedTextFieldPasswordUser.setDragEnabled(true);
		formattedTextFieldPasswordUser.setBounds(158, 165, 171, 47);
		contentPane.add(formattedTextFieldPasswordUser);
	}
}
