package User;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class UsrHome extends JPanel {
	
	String usrname;
	int w;

	public UsrHome(String usr) {
		usrname=usr;
	}
	
	
	public void paintComponent(Graphics g)
	{
		paintx(g);
	}
	
	public void paint(Graphics g)
	{
		paintx(g);
	}
	
	public void paintx(Graphics g)
	{
		Graphics2D g2d=(Graphics2D)g;
		g2d.addRenderingHints( new RenderingHints( RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON ));
		g2d.setFont(new Font("Lucida Calligraphy", Font.ITALIC,40 ));
		g2d.setColor(new Color(255,255,255,100));
		g2d.drawString("Home", 10, 50);
		g2d.setColor(new Color(0,0,0));
		g2d.setFont(new Font("Lucida Calligraphy", Font.ITALIC,70));
		w = g.getFontMetrics().stringWidth("Welcome To MGPS") / 2;
		g2d.drawString("Welcome To MGPS",getWidth()/2-w,200);
		g2d.setColor(new Color(255,255,255));
		g2d.setFont(new Font("Arial", Font.PLAIN,70));
		w = g.getFontMetrics().stringWidth(usrname) / 2;
		g2d.drawString(usrname,getWidth()/2-w,350);
	}
	
	
	public void setUsr(String usr)
	{
		usrname=usr;
	}

}
