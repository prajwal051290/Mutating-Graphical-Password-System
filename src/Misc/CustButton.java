package Misc;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.MalformedURLException;

import javax.swing.JButton;

import SignUp.BtPanel;


public class CustButton extends  JButton implements MouseListener,MouseMotionListener{

	private boolean isPressed=false;
	String Name=new String(""),ct="";
	int x,y,temp=0;
	int translucency=100;
	public static int count=0; 
	public static java.applet.AudioClip clip1,clip2;
	public static BtPanel p;
	int w,h;
	
	public CustButton(String str)
	{
		setVisible(true);
		Name=str;
		addMouseListener(this);
	}
	
	public static void audioInit()
	{
		  try {
			clip1=java.applet.Applet.newAudioClip(new java.net.URL( "file:.\\Sounds\\Button2.wav"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		setContentAreaFilled(false);
		g2d.setColor(new Color(255,255,255,translucency));
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Arial", Font.BOLD, 16));
	    h = g.getFontMetrics().getDescent();
		if(!Character.isDigit(Name.charAt(1)))
		{
			w = g.getFontMetrics().stringWidth(Name) / 2;
			g2d.drawString(Name,getWidth()/2-w,getHeight()/2+h);
		}
		else if(!ct.equals(""))
		{
			w = g.getFontMetrics().stringWidth(ct) / 2;
			g2d.drawString(ct,getWidth()/2-w,getHeight()/2+h);
			if(temp>1)
			{
				g2d.setFont(new Font("Arial", Font.PLAIN, 8));
				g2d.drawString(""+temp,4,8);
			}
		}
	}
	
	public void mouseClicked(java.awt.event.MouseEvent e) {
	}

	public void mouseEntered(java.awt.event.MouseEvent e) {
		if(isPressed)
			return;
		if(!Character.isDigit(Name.charAt(1)))
			setBounds(getX()-5,getY()-5,getWidth()+10,getHeight()+10);
		else
			setBounds(getX()-3,getY()-3,35,35);
		translucency=150;
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public void mouseExited(java.awt.event.MouseEvent e) {
		if(isPressed)
			return;
		if(!Character.isDigit(Name.charAt(1)))
			setBounds(getX()+5,getY()+5,getWidth()-10,getHeight()-10);
		else
			setBounds(getX()+3,getY()+3,28,28);
		translucency=100;
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	public void mousePressed(java.awt.event.MouseEvent e) {
		isPressed=true;
		if(!Character.isDigit(Name.charAt(1)));
		else
		{
			count++;
			ct=""+count;
			temp++;
		}
		translucency=250;
		clip1.stop();
	    clip1.play();
	    repaint();
	}

	public void mouseReleased(java.awt.event.MouseEvent e) {
		if(!Character.isDigit(Name.charAt(1)))
		{
			isPressed=false;
			translucency=100;
			//setBounds(getX()+5,getY()+5,getWidth()-10,getHeight()-10);
		}
	}
	
	public String getName()
	{
		return Name;
	}
	
	public static int getCount()
	{
		return count;
	}
	
	public void clear()
	{
		isPressed=false;
		translucency=100;
		removeMouseMotionListener(this);
		repaint();
		count=0;
		ct="";
		temp=0;
	}

	public void mouseDragged(MouseEvent e1) {
	}

	public void mouseMoved(MouseEvent e) {
		if(count==0)
			return;
		p.setXY(e.getX()+getX(),e.getY()+getY());
		p.repaint();
	}
	
	public static void setPanel(BtPanel x)
	{
		p=x;
	}
}
