package Welcome;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import HomePage.Home;
import Login.LoginPanel;
import Misc.CustButton;
import SignUp.SignUpPanel;
import User.UserFrame;

public class WelcomePanel extends JPanel {
	
	BufferedImage back;
	String name=null;
	int flag=0;
	String msg=null;
	int w;
	static UserFrame usr;

	public WelcomePanel(String a) {
		try {
			back = ImageIO.read(new File(".\\UI\\back3.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		CustButton btLogin = new CustButton("OK");
		btLogin.setBounds(200, 250, 100, 40);
		btLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				procLogout();
			}
		});
		add(btLogin);
		msg=a;
	}
	
	public void paintComponent(Graphics g)
	{
		paintx(g);
	}
	
	public void paint(Graphics g)
	{
		paintx(g);
		paintChildren(g);
	}
			
	public void paintx(Graphics g)
	{
		Graphics2D g2d=(Graphics2D)g;
		g2d.addRenderingHints( new RenderingHints( RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON ));
		g2d.drawImage(back,0,0,getWidth(),getHeight(),this);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Lucida Calligraphy",Font.ITALIC,45));
		w = g.getFontMetrics().stringWidth(msg) / 2;
		g2d.drawString(msg, getWidth()/2-w, 100);
		g2d.setFont(new Font("Lucida Calligraphy",Font.ITALIC,50));
		g2d.setColor(Color.WHITE);
		w = g.getFontMetrics().stringWidth(name) / 2;
		g2d.drawString(name, getWidth()/2-w, 200);
		g2d.setColor(new Color(255,255,255,100));
		g2d.setStroke(new BasicStroke(5));
		g2d.drawLine(10, 10, getX()+getWidth()-10, 10);
		g2d.drawLine(10, 10, 10, getY()+getHeight()-10);
		g2d.drawLine(10, getY()+getHeight()-10, getX()+getWidth()-10, getY()+getHeight()-10);
		g2d.drawLine(getX()+getWidth()-10, 10, getX()+getWidth()-10, getY()+getHeight()-10);
	}
	
	
	public void setNamex(String user,int x)
	{
		name=new String(user);
		flag=x;
	}
	
	public void procLogout()
	{
		if(flag==1)
			SignUpPanel.disableWel();
		else if(flag==2)
			LoginPanel.disableWel();
		usr=new UserFrame(name);
	}
	
	
	public static void disableUsr()
	{
		usr.setVisible(false);
		Home.disableLogin();
		Home.disableSignUp();
		Home.enableHome();
	}
	
}
