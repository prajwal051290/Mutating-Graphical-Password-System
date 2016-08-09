package User;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Misc.CustButton;
import Misc.Hash;

public class ChgUsr extends JPanel {
	
	String usrname,err=new String();
	CustButton ok,cancel;
	JTextField txtUsr;
	ChgUsr temp;
	Hash h=new Hash();
	

	public ChgUsr(String usr) {
		
		temp=this;
		
		usrname=usr;
		
		setOpaque(false);
		
		setLayout(null);
		
		
		txtUsr = new JTextField();
		txtUsr.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				setErr("");
			}
		});
		txtUsr.setOpaque(false);
		txtUsr.setForeground(Color.BLACK);
		txtUsr.setFont(new Font("Arial Black", Font.BOLD, 14));
		txtUsr.setColumns(10);
		txtUsr.setBackground(Color.BLACK);
		txtUsr.setBorder(new EmptyBorder(2, 4, 2, 4));
		add(txtUsr);
		txtUsr.setBounds( 600, 270, 275, 30);
		
		
		cancel = new CustButton("CANCEL");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				procCancel();
			}
		});
		cancel.setBounds(400, 350, 140, 40);
		add(cancel);
		
		
		ok = new CustButton("O K");
		ok.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				if(procOK())
				{
					setUsr();
				}
			}
		});
		ok.setBounds(600, 350, 140, 40);
		add(ok);
	}
	
	public void paintComponent(Graphics g)
	{
		paintx(g);
		paintChildren(g);	}
	
	public void paint(Graphics g)
	{
		paintx(g);
		paintChildren(g);
	}
	
	public void paintx(Graphics g)
	{
		Graphics2D g2d=(Graphics2D)g;
		g2d.addRenderingHints( new RenderingHints( RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON ));
		g2d.setFont(new Font("Lucida Calligraphy", Font.ITALIC,40 ));
		g2d.setColor(new Color(255,255,255,100));
		g2d.drawString("Change Username", getWidth()/2-("Change Username").length()*20+40, 50);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Arial Bold", Font.BOLD,20));
		g2d.drawString( "CURRENT USERNAME   : ", 300,200);
		g2d.drawString( "NEW USERNAME       : ", 300,300);
		g2d.setColor(Color.white);
		g2d.setFont(new Font("Lucida Calligraphy", Font.ITALIC,30 ));
		g2d.drawString( usrname, 600,200);
		g2d.setColor(new Color(255,255,255,50));
		g2d.fillRect(txtUsr.getX(),txtUsr.getY(), txtUsr.getWidth(), txtUsr.getHeight());
		g2d.setColor(Color.RED);
		g2d.setFont(new Font("Lucida Calligraphy", Font.ITALIC,20 ));
		g2d.drawString( err, txtUsr.getX()+txtUsr.getWidth()+10,txtUsr.getY()+18);
	}
	
	
	public void setErr(String error)
	{
		err=error;
		repaint(txtUsr.getX()+getWidth()+10,txtUsr.getY()-10,100,100);
	}
	
	
	public boolean procOK()
	{
		if(txtUsr.getText().length()==0)
		{
			setErr("Enter a valid username");
			return false;
		}
		else if(h.isThere(txtUsr.getText()))
		{
			setErr("Username already exists");
			return false;
		}
		return true;
	}
	
	
	public void setUsr()
	{
		h.delUsr(usrname);
		h.addUsrName(txtUsr.getText());
		usrname=txtUsr.getText();
		UserPn temp=(UserPn)getParent();
		temp.setUsr(usrname);
		UserPn.showHome();
	}
	
	
	public void procCancel()
	{
		UserPn.showHome();
	}
}
