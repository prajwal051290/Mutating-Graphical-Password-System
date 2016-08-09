package User;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class UserFrame extends JFrame {

	private UserPn contentPane;
	Toolkit tk=Toolkit.getDefaultToolkit();
	final Dimension scrnsize = tk.getScreenSize();

	public UserFrame(String usr) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, scrnsize.width,scrnsize.height);
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("Mutating Graphical Password System");
		setEnabled(true);
		contentPane = new UserPn(usr);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
	}
}
