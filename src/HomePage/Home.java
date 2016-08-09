package HomePage;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import Login.Login;
import Misc.CustButton;
import SignUp.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Home extends JFrame {

	private HomePn contentPane;
	static Home h;
	static Login l;
	static SignUp m;
	Toolkit tk=Toolkit.getDefaultToolkit();
	final Dimension scrnsize = tk.getScreenSize();

	public static void main(String[] args) {
		Toolkit tk=Toolkit.getDefaultToolkit();
		final Dimension scrnsize = tk.getScreenSize();
		try {
			h = new Home();
			h.setResizable(false);
			h.setBounds(scrnsize.width/2-200,scrnsize.height/2-200,400,400 );
			h.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		setTitle("Mutating Graphical Password System");
		contentPane = new HomePn();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		CustButton btLogin = new CustButton("Login");
		btLogin.setBounds(77, 215, 97, 36);
		btLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				loginClick();
			}
		});
		contentPane.add(btLogin);
		
		CustButton btSignUp = new CustButton("Sign Up");
		btSignUp.setBounds(233, 215, 97, 36);
		btSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				signUpClick();
			}
		});
		
		
		contentPane.add(btSignUp);
		CustButton.audioInit();
		
		m = new SignUp();
		l = new Login();
	}
	
	
	public void signUpClick()
	{
		disableHome();
		m = new SignUp();
		m.setBounds(0,0,scrnsize.width, scrnsize.height-40);
		m.setExtendedState(MAXIMIZED_BOTH);
		m.setVisible(true);
		m.setEnabled(true);
	}
	
	
	public void loginClick()
	{
		disableHome();
		l = new Login();
		l.setBounds(0,0,scrnsize.width, scrnsize.height-40);
		l.setExtendedState(MAXIMIZED_BOTH);
		l.setVisible(true);
		l.setEnabled(true);
	}
	
	
	public static void enableHome()
	{
		h.setVisible(true);
		h.setEnabled(true);
		h.repaint();
		disableSignUp();
		disableLogin();
	}
	
	
	public static void disableLogin()
	{
		l.setVisible(false);
		l.setEnabled(false);
	}
	
	
	public static void disableSignUp()
	{
		m.setVisible(false);
		m.setEnabled(false);
	}
	
	
	public static void disableHome()
	{
		h.setVisible(false);
		h.setEnabled(false);
	}
}
