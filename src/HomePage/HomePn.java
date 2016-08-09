package HomePage;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class HomePn extends JPanel {


	BufferedImage back;
	
	
	public HomePn() {
		try {
			back = ImageIO.read(new File(".\\UI\\back3.jpg"));
		} catch (IOException e) {
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
		paintChildren(g);
	}
			
	public void paintx(Graphics g)
	{
		Graphics2D g2d=(Graphics2D)g;
		g2d.addRenderingHints( new RenderingHints( RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON ));
		g2d.drawImage(back,0,0,getWidth(),getHeight(),this);
		g2d.setColor(Color.white);
		g2d.setFont(new Font("Lucida Calligraphy",Font.ITALIC,70));
		g2d.drawString("MGPS", 80, 150);
		g2d.setColor(new Color(255,255,255,100));
		g2d.setStroke(new BasicStroke(5));
		g2d.drawLine(10, 10, getX()+getWidth()-10, 10);
		g2d.drawLine(10, 10, 10, getY()+getHeight()-10);
		g2d.drawLine(10, getY()+getHeight()-10, getX()+getWidth()-10, getY()+getHeight()-10);
		g2d.drawLine(getX()+getWidth()-10, 10, getX()+getWidth()-10, getY()+getHeight()-10);
	}
}
