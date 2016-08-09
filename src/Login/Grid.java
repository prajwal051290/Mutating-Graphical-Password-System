package Login;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Grid extends JPanel implements Runnable{

	
	String[] temp=new String[64];
	String[][] rand=new String[8][8],randtemp=new String[8][8];
	RandomNum r=new RandomNum();
	int effectx1=0,effecty1=0,effectx2=0,effecty2=0;
	int done=50;
	boolean stop=false;
	
	public Grid() {
		
		stop=false;
		setOpaque(false);
		temp=r.generateRandom();
		setStr();
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
				rand[i][j]=randtemp[i][j];
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
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(3));
		g2d.drawLine(1, 1, getWidth()-1, 1);
		g2d.drawLine(1, 1, 1, getHeight()-1);
		g2d.drawLine(1,getHeight()-2, getWidth()-2, getHeight()-2);
		g2d.drawLine(getWidth()-2, 1, getWidth()-2, getHeight()-2);
		g2d.setStroke(new BasicStroke(1));
		g2d.setFont(new Font("Arial",Font.BOLD,15));
		int cellSize=320/8;
		int x,y; 
		x=y=cellSize/2;
		for(int i=1;i<8;i++)
		{
			g2d.drawLine(1, cellSize*i, getWidth()-1, cellSize*i);
			g2d.drawLine(cellSize*i, 1, cellSize*i, getHeight()-1);
		}
		g2d.setPaint(new GradientPaint(effectx1, effecty1,Color.WHITE,effectx2,effecty2,Color.BLACK));
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				g2d.drawString("" + rand[i][j], x-(8*rand[i][j].length()/2), y+10);
				x+=40;
			}
			x=cellSize/2;
			y+=40;
		}
	}



	public void run() {
		do
		{	
			while((done--)>=0)
			{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			effectDraw();
			done=50;
		}while(!stop);
	}
	
	public void effectDraw()
	{
		int i,k=0;
		temp=r.generateRandom();
		setStr();
		for(i=0;i<getWidth();i++)
		{
			effectx1=effecty1=i;
			effectx2=effectx1+20;
			effecty2=i;
			repaint();
			for(int j=0;j<8;j++)
			{
				rand[j][k]=randtemp[j][k];
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i%50==0)
				k++;
		}
		effectx1=effecty1=0;
		effectx2=effecty2=0;
	}
	
	
	public void setStr()
	{
		int k=0;
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
				randtemp[i][j]=temp[k++];
		}
	}
	
	
	public void setDone(int x)
	{
		done=x;
		if(x==-200)
			stop=true;
	}
	
	
	public String isThere(String s)
	{
		char c='a';
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
				if(rand[i][j].equals(s))
					return "" + c + (j+1) ;
			c++;
		}
		return "";
	}
}

