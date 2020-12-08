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

public class starter extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					starter frame = new starter();
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
	public starter() {
		setResizable(false);
		setTitle("Finestra 1");
		setLocation(new Point(200, 400));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Lenovo\\Pictures\\Camera Roll\\albero1.jfif"));
		setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 580, 480);
		contentPane = new JPanel();
		contentPane.setLocation(new Point(100, 200));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lableUno = new JLabel("login");
		lableUno.setSize(493, 321);
		lableUno.setLocation(new Point(5, 5));
		contentPane.add(lableUno);
	}

}
