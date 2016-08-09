package User;

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

import Misc.CustButton;

public class UserPn extends JPanel {

	BufferedImage back;
	static String usrname;
	CustButton home,del,chgname,chgpass,logout;
	static UsrHome h;
	static ChgUsr cu;
	static UserDel delpn;
	static LogoutPn lgPn;
	static ChgPassPn passpn;
	int w;
	
	public UserPn(String usr) {
		try {
			back = ImageIO.read(new File(".\\UI\\Back3.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		setOpaque(false);
		
		
		home=new CustButton("Home");
		home.setVisible(true);
		home.setBounds(40, 200, 200, 40);
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showHome();
			}
		});
		add(home);
		
		
		chgname=new CustButton("Change Username");
		chgname.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showChgName();
			}
		});
		chgname.setVisible(true);
		chgname.setBounds(40, 280, 200, 40);
		add(chgname);
		
		
		chgpass=new CustButton("Change Password");
		chgpass.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showChgPass();
			}
		});
		chgpass.setVisible(true);
		chgpass.setBounds(40, 360, 200, 40);
		add(chgpass);
		
		
		del=new CustButton("Delete Account");
		del.setVisible(true);
		del.setBounds(40, 440, 200, 40);
		del.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showDel();
			}
		});
		add(del);
		
		
		logout=new CustButton("Logout");
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				logout();
			}
		});
		logout.setVisible(true);
		logout.setBounds(40, 520, 200, 40);
		add(logout);
		
		
		usrname=usr;
		
		
		h=new UsrHome(usrname);
		h.setBounds(250, 150, 1200, 800);
		h.setVisible(true);
		add(h);
		
		
		cu=new ChgUsr(usrname);
		
		delpn=new UserDel(usrname);
		
		lgPn=new LogoutPn();
		
		passpn=new ChgPassPn(usrname);
		
		setFocusable(false);
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
		g2d.setFont(new Font("Lucida Calligraphy", Font.ITALIC,80 ));
		g2d.setColor(new Color(255,255,255,100));
		g2d.drawString("M G P S", 30, 110);
		g2d.setColor(new Color(255,255,255,50));
		g2d.setStroke(new BasicStroke(5));
		g2d.drawLine(20, 20, getX()+getWidth()-20, 20);
		g2d.drawLine(20, 20, 20, getY()+getHeight()-20);
		g2d.drawLine(20, getY()+getHeight()-20, getX()+getWidth()-20, getY()+getHeight()-20);
		g2d.drawLine(getX()+getWidth()-20, 20, getX()+getWidth()-20, getY()+getHeight()-20);
		g2d.setColor(new Color(255,255,255,100));
		g2d.setStroke(new BasicStroke(4));
		g2d.drawLine(250, 150, 250, getHeight()-30);
		g2d.drawLine(30, 150, getWidth()-30, 150);
		g2d.setFont(new Font("Lucida Calligraphy", Font.ITALIC,40 ));
		w = g.getFontMetrics().stringWidth(usrname) + 60;
		g2d.drawString(usrname, getWidth()-w, 120);
	}
	
	public static void showHome()
	{
		disableAll();
		h.setVisible(true);
	}
	
	public void showDel()
	{
		disableAll();
		delpn=new UserDel(usrname);
		delpn.setBounds(250, 150, 1200, 800);
		delpn.setVisible(true);
		add(delpn);
	}
	
	public void showChgName()
	{
		disableAll();
		cu=new ChgUsr(usrname);
		cu.setBounds(250, 150, 1200, 800);
		cu.setVisible(true);
		add(cu);
	}
	
	public void showChgPass()
	{
		disableAll();
		passpn=new ChgPassPn(usrname);
		passpn.setBounds(250, 150, 1200, 800);
		passpn.setVisible(true);
		add(passpn);
	}
	
	public void setUsr(String usr)
	{
		usrname=usr;
		repaint();
		h.setUsr(usr);
	}
	
	
	public void logout()
	{
		disableAll();
		lgPn=new LogoutPn();
		lgPn.setBounds(250, 150, 1200, 800);
		lgPn.setVisible(true);
		add(lgPn);
	}

	
	public static void disableAll()
	{
		h.setVisible(false);
		delpn.setVisible(false);
		cu.setVisible(false);
		lgPn.setVisible(false);
		passpn.setVisible(false);
	}
}
