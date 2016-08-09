package Login;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Error.ErrorPn;
import FileHandling.FileOp;
import HomePage.Home;
import Misc.CustButton;
import Misc.MGPSSymbol;
import Welcome.Welcome;

public class LoginPanel extends JPanel {

	
	BufferedImage back;
	JTextField txtPass,txtUsr;
	String password="",passwordval[]=new String[64];
	int length=0;
	Grid gridPn;
	ErrorPn errpn;
	Thread th;
	static Welcome wel=new Welcome("Successful Login");
	
	
	public LoginPanel() {
		setLayout(null);
		
		gridPn = new Grid();
		gridPn.setBounds(250, 220, 320, 320);
		add(gridPn);
		try {
			back = ImageIO.read(new File(".\\UI\\back3.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		gridPn.setDone(50);
		th=new Thread(gridPn);
		th.start();
		txtPass=new JTextField();
		txtPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				procPass(e);
			}
		});
		txtPass.setOpaque(false);
		txtPass.setForeground(Color.BLACK);
		txtPass.setFont(new Font("Arial Black", Font.BOLD, 14));
		txtPass.setColumns(10);
		txtPass.setBackground(Color.BLACK);
		txtPass.setBorder(new EmptyBorder(2, 4, 2, 4));
		txtPass.setBounds(830,400, 250, 30);
		add(txtPass);
		
		
		txtUsr=new JTextField();
		txtUsr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				errpn.setUsrErr("");
			}
		});
		txtUsr.setOpaque(false);
		txtUsr.setForeground(Color.BLACK);
		txtUsr.setFont(new Font("Arial Black", Font.BOLD, 14));
		txtUsr.setColumns(10);
		txtUsr.setBackground(Color.BLACK);
		txtUsr.setBorder(new EmptyBorder(2, 4, 2, 4));
		txtUsr.setBounds(830,300, 250, 30);
		add(txtUsr);
		
		
		errpn = new ErrorPn(5,20,5,120);
		errpn.setBounds(txtUsr.getX()+txtUsr.getWidth()+5, txtUsr.getY(), 500, 400);
		add(errpn);
		
		
		CustButton btnCancel = new CustButton("CANCEL");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				procCancel();
			}
		});
		btnCancel.setBounds(520, 650, 136, 39);
		add(btnCancel);
		
		
		CustButton btnOK = new CustButton("O K");
		btnOK.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				if(!procOK())
					return;
			}
		});
		btnOK.setBounds(700, 650, 136, 39);
		add(btnOK);
		
		MGPSSymbol bckAnim=new MGPSSymbol();
		bckAnim.setBounds(950, 600, 500, 500);
		add(bckAnim);
		
		
		wel.setVisible(false);
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
		g2d.setColor(new Color(255,255,255,50));
		g2d.fillRect(txtPass.getX(),txtPass.getY(), txtPass.getWidth(), txtPass.getHeight());
		g2d.fillRect(txtUsr.getX(),txtUsr.getY(), txtUsr.getWidth(), txtUsr.getHeight());
		g2d.setColor(new Color(255,255,255,100));
		g2d.setStroke(new BasicStroke(5));
		g2d.drawLine(20, 20, getX()+getWidth()-20, 20);
		g2d.drawLine(20, 20, 20, getY()+getHeight()-20);
		g2d.drawLine(20, getY()+getHeight()-20, getX()+getWidth()-20, getY()+getHeight()-20);
		g2d.drawLine(getX()+getWidth()-20, 20, getX()+getWidth()-20, getY()+getHeight()-20);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Arial Bold", Font.BOLD,20 ));
		g2d.drawString("USERNAME : ",txtUsr.getX()-150,txtUsr.getY()+23);
		g2d.drawString("PASSWORD : ",txtPass.getX()-150,txtPass.getY()+23);
		g2d.setFont(new Font("Lucida Calligraphy",Font.ITALIC,15));
		g2d.setColor(Color.RED);
		g2d.setFont(new Font("Lucida Calligraphy", Font.ITALIC,80 ));
		g2d.setColor(new Color(0,0,0,100));
		g2d.drawString("Login", (getX()+getWidth())/2-150, 100);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Arial Bold", Font.BOLD,30 ));
		g2d.drawString("GRID", gridPn.getX()+20, gridPn.getY()-5);
		g2d.drawLine(gridPn.getX()-10, gridPn.getY()-10, gridPn.getX()+15, gridPn.getY()-10);
		g2d.drawLine(gridPn.getX()+100, gridPn.getY()-10, gridPn.getX()+gridPn.getWidth()+10, gridPn.getY()-10);
		g2d.drawLine(gridPn.getX()-10, gridPn.getY()-10, gridPn.getX()-10, gridPn.getY()+gridPn.getHeight()+10);
		g2d.drawLine(gridPn.getX()-10, gridPn.getY()+gridPn.getHeight()+10, gridPn.getX()+gridPn.getWidth()+10, gridPn.getY()+gridPn.getHeight()+10);
		g2d.drawLine(gridPn.getX()+gridPn.getWidth()+10, gridPn.getY()-10, gridPn.getX()+gridPn.getWidth()+10, gridPn.getY()+gridPn.getHeight()+10);
	}
	
	
	public void procPass(KeyEvent e)
	{
		if(e.getKeyChar()==KeyEvent.VK_BACK_SPACE)
		{
			if(password.length()==0)
				return;
			else if(password.length()==1 || password.length()==2)
			{
				password="";
				txtPass.setText("");
				length=0;
			}
			else if(password.length()%2==0)
			{
				password=txtPass.getText().substring(0, txtPass.getText().length()-1);
				txtPass.setText(password);
				length--;
			}
			else if(password.length()%2==1)
			{
				password=txtPass.getText().substring(0, txtPass.getText().length());
				txtPass.setText(password);
			}
			gridPn.setDone(0);
			errpn.setPassErr("");
		}
		else
		{
			if((password.length()%2)==0)
			{
				char c=e.getKeyChar();
				if(Character.isLetter(c))
				{
					if(Character.isLowerCase(c))
						c=Character.toUpperCase(c);
					password=password + c;
					errpn.setPassErr("");
				}
				else
				{
					errpn.setPassErr("Enter appropriate grid value");
				}
				txtPass.setText(password);
			}
			
			else if((password.length()%2)==1)
			{
				if(Character.isDigit(e.getKeyChar()))
				{
					String passcode=gridPn.isThere(password.substring(password.length()-1, password.length()) + e.getKeyChar());
					if(!passcode.equals(""))
					{
						password=password + e.getKeyChar();
						gridPn.setDone(0);
						errpn.setPassErr("");
						passwordval[length]=passcode;
						length++;
					}
					else
					{	
						password=password.substring(0,password.length()-1);
						txtPass.setText(password);
						errpn.setPassErr("Enter appropriate grid value");
					}
				}
				else
				{
					txtPass.setText(password);
					errpn.setPassErr("Enter appropriate grid value");
				}
			}
		}
	}
	
	
	public boolean procOK()
	{
		if(txtUsr.getText().equals(""))
		{
			errpn.setUsrErr("Enter a Username");
			return false;
		}
		if(txtPass.getText().equals(""))
		{
			errpn.setPassErr("Enter a Passsword");
			return false;
		}
		FileOp f=new FileOp();
		String pass=new String();
		for(int i=0;i<length;i++)
			pass=pass+passwordval[i];
		int res=f.compare(txtUsr.getText(),pass);
		if(res==-1)
		{
			errpn.setUsrErr("");
			errpn.setPassErr("Wrong Password");
			return false;
		}
		if(res==-2)
		{
			errpn.setPassErr("");
			errpn.setUsrErr("No such Username exists");
			return false;
		}
		gridPn.setDone(-200);
		Home.disableHome();
		Home.disableLogin();
		Home.disableSignUp();
		wel.setVisible(true);
		wel.setNamex(txtUsr.getText(),2);
		return true;
	}
	
	public void procCancel()
	{
		gridPn.setDone(-200);
		Home.enableHome();
	}
	
	
	public static void disableWel()
	{
		wel.setEnabled(false);
		wel.setVisible(false);
	}
}