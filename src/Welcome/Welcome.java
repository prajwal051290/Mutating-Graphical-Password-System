package Welcome;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class Welcome extends JFrame {

	private WelcomePanel contentPane;
	Toolkit tk=Toolkit.getDefaultToolkit();
	final Dimension scrnsize = tk.getScreenSize();

	public Welcome(String a) {
		setResizable(false);
		setBounds(scrnsize.width/2-300,scrnsize.height/2-300,500,400 );
		setTitle("Mutating Graphical Password System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new WelcomePanel(a);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public void setNamex(String user,int x)
	{
		contentPane.setNamex(user,x);
	}
}
