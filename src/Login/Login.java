package Login;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private LoginPanel contentPane;


	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Mutating Graphical Password System");
		setBounds(100, 100, 450, 300);
		contentPane = new LoginPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

}
