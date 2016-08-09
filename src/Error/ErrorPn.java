package Error;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class ErrorPn extends JPanel {

	
	String errUsr=new String();
	String errPass=new String();
	int length=-1,usrPosx,usrPosy,passPosx,passPosy; 
	
	
	public ErrorPn(int x1,int y1,int x2,int y2)
	{
		errPass="";
		errUsr="";
		usrPosx=x1;
		usrPosy=y1;
		passPosx=x2;
		passPosy=y2;
		setOpaque(false);
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
		g2d.setColor(new Color(0,0,0,0));
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(Color.RED);
		g2d.setFont(new Font("Lucida Calligraphy",Font.ITALIC,20));
		g2d.drawString(errUsr, usrPosx, usrPosy);
		g2d.drawString(errPass, passPosx, passPosy);
		g2d.setFont(new Font("Lucida Calligraphy",Font.ITALIC,15));
		if(length>0 && length<=5)
			g2d.drawString("Strength : Weak", passPosx, passPosy);
		else if(length>=6 && length<=8)
		{
			g2d.setColor(Color.YELLOW);
			g2d.drawString("Strength : Good", passPosx, passPosy);
		}
		else if(length>=9)
		{
			g2d.setColor(Color.GREEN);
			g2d.drawString("Strength : Strong", passPosx, passPosy);
		}
	}

	
	public void setUsrErr(String str)
	{
		errUsr=str.toString();
		repaint();
	}
	
	public void setPassErr(String str)
	{
		errPass=str.toString();
		repaint();
	}
	
	public void setLength(int l)
	{
		length=l;
		repaint();
	}
}
