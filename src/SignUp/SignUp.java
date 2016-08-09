package SignUp;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;


public class SignUp extends JFrame {
	
	
	private static SignUpPanel contentPane;
	
	
	public SignUp() { 
		
		setBackground(new Color(0, 0, 0));
		setFont(new Font("Arial", Font.PLAIN, 18));
		setForeground(new Color(33, 66, 109));
		setTitle("Mutating Graphical Password System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 714);

		contentPane=new SignUpPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public static void contentEnable()
	{
		contentPane.setEnabled(true);
	}
}
