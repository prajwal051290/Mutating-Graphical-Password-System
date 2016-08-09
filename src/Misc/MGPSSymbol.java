package Misc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class MGPSSymbol extends JPanel{

	int x,y;
	public MGPSSymbol() {
		setOpaque(false);
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2d=(Graphics2D)g;
		g2d.addRenderingHints( new RenderingHints( RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON ));
		g2d.setColor(new Color(255,255,255,50));
		g2d.setFont(new Font("Lucida Calligraphy", Font.BOLD, 120));
		g2d.drawString("MGPS", 0, 130);
	}
}
