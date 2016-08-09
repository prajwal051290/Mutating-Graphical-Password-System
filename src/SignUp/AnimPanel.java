package SignUp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class AnimPanel extends JPanel implements Runnable{

	
	public static int lines[][]=new int[64][64],count=0;
	int currct=0,ct;
	Thread th;
	BtPanel temp;
	boolean done=false;
	
	
	public AnimPanel(BtPanel a) {
		setVisible(false);
		//setBounds(510,79, 382,407);
		setBorder(null);
		setOpaque(false);
		setLayout(null);
		temp=a;
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
		g2d.setColor(new Color(255,255,255,50));
		g2d.fillRect(0,10,getWidth()-15,getHeight()-30);
		g2d.setColor(new Color(0,0,0));
		g2d.setFont(new Font("Arial Bold", Font.BOLD,20 ));
		g2d.drawString("PASSWORD GRID", 20,33);
		g2d.drawString("1     2     3     4     5     6     7    8", 45,55);
		int i,y=80;
		char ch='a';
		for(i=1;i<=8;i++)
		{
			g2d.drawString("" + ch++, 22,y);
			y+=40;
		}
		g2d.setStroke(new BasicStroke(5));
		g2d.drawLine(10, 25, 15, 25);
		g2d.drawLine(195, 25, getWidth()-25, 25);		
		g2d.drawLine(10, 25, 10, getHeight()-30);
		g2d.drawLine(10, getHeight()-30, getWidth()-25, getHeight()-30);
		g2d.drawLine(getWidth()-25,25,getWidth()-25,getHeight()-30);
		int x=40,j=1;
		y=60;
		g2d.setColor(new Color(255,255,255,100));
		for(i=0;i<64;i++)
		{
			g2d.fillRect(x, y, 28, 28);
			x+=40;
			j++;
			if(((i+1)%8)==0)
			{
				x=40;
				y+=40;
				j=1;
			}
		}
		g2d.setStroke(new BasicStroke(5));
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Arial", Font.BOLD, 16));
		for(i=0;i<currct;i++)
		{
			g2d.drawLine(lines[i][0],lines[i][1],lines[i+1][0],lines[i+1][1]);
			g2d.setColor(Color.WHITE);
			g2d.fillRect(lines[i][0]-16,lines[i][1]-16,35,35);
			g2d.fillRect(lines[i+1][0]-16,lines[i+1][1]-16,35,35);
			g2d.setColor(Color.BLACK);
			g2d.drawString("" + (i+1),lines[i][0]-3,lines[i][1]+3);
			g2d.drawString("" + (i+2),lines[i+1][0]-3,lines[i+1][1]+3);
		}
		g2d.setColor(Color.WHITE);
		g2d.drawLine(lines[i][0],lines[i][1],lines[i+1][0],lines[i+1][1]);
		g2d.fillRect(lines[i][0]-16,lines[i][1]-16,35,35);
		g2d.fillRect(lines[i+1][0]-16,lines[i+1][1]-16,35,35);
		g2d.setColor(Color.BLACK);
		g2d.drawString("" + (i+1),lines[i][0]-3,lines[i][1]+3);
		g2d.drawString("" + (i+2),lines[i+1][0]-3,lines[i+1][1]+3);
	}

	
	public static void setlines(int l[][],int c)
	{
		lines=l;
		count=c;
	}


	public void run() {
		done=false;
		drawIt();
		setVisible(false);
		temp.setVisible(true);
		temp.repaint();
	}
	
	
	public void drawIt()
	{
		for(int k=0;k<count;k++)
		{
			currct=k;
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		done=true;
		repaint();
		SignUp.contentEnable();
	}
}
