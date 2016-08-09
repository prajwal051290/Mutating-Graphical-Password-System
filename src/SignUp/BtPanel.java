package SignUp;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;


public class BtPanel extends JPanel implements MouseMotionListener {
	
	int fromX,fromY,toX,toY;
	boolean clear=true;
	static boolean animOn;
	int lines[][]=new int[64][64];
	int count=0;
	boolean isMouseIn=true;
	
	public BtPanel() {
		clear=true;
		fromX=toX=45;
		fromY=toY=65;
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
		g2d.setColor(new Color(255,255,255,50));
		g2d.fillRect(0,10,getWidth()-15,getHeight()-30);
		g2d.setColor(Color.BLACK);
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
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(5));
		for(i=0;i<count;i++)
		{
			g2d.drawLine(lines[i][0],lines[i][1],lines[i+1][0],lines[i+1][1]);
			fromX=lines[i+1][0];
			fromY=lines[i+1][1];
		}
		g2d.setColor(Color.WHITE);
		if(isMouseIn)
			g2d.drawLine(fromX,fromY, toX, toY);
	}
	
	public void setListener(int a,int b)
	{
		toX=fromX=a;//-getX();
		toY=fromY=b;//-getY();
		addMouseMotionListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()<=getWidth()-25 && e.getY()<=getHeight()-25 && e.getX()>=45 && e.getY()>=60)
			isMouseIn=true;
		else
			isMouseIn=false;
		toX=e.getX();
		toY=e.getY();
		repaint();
	}
	
	public void setXY(int a,int b)
	{
		toX=a;
		toY=b;
		if(!clear)
		repaint();
	}
	
	public void setClear()
	{
		clear=true;
		fromX=toX=45;
		fromY=toY=65;
		removeMouseMotionListener(this);
		count=0;
		repaint();
	}
	
	public void setlines(int l[][],int c)
	{
		lines=l;
		count=c;
		repaint();
	}
	
	
	public static boolean getAnim()
	{
		return animOn;
	}
	
	public static void setAnim(boolean a)
	{
		animOn=a;
	}
	
	public void anim()
	{
		AnimPanel.setlines(lines, count);
	}
}
