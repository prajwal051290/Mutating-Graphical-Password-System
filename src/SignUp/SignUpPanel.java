package SignUp;

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
import HomePage.Home;
import Misc.MGPSSymbol;
import Misc.CustButton;
import Misc.Hash;
import Welcome.Welcome;


public class SignUpPanel extends JPanel{
	
	BufferedImage back;
	JTextField txt;
	int p=0,q=0;
	CustButton[] Btarr=new CustButton[64];
	private final JTextField txtPass = new JTextField();
	private JTextField txtUsr;
	BtPanel btPan;
	Hash h;
	int i,lines[][]=new int[64][2];
	String Password=new String("");
	String usr=null;
	private int count=0;
	ErrorPn errpanel;
	AnimPanel animPan;
	static Welcome wel;

	

	
	public SignUpPanel()
	{
		try {
			back = ImageIO.read(new File(".\\UI\\Back3.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		btPan = new BtPanel();
		btPan.setBorder(null);
		btPan.setBackground(new Color(102, 102, 204));
		btPan.setBounds(510, 100, 382, 407);
		btPan.setOpaque(false);
		add(btPan);
		btPan.setLayout(null);
		
		
		animPan = new AnimPanel(btPan);
		animPan.setBounds(510, 100, 382, 407);
		add(animPan);
		
		txtPass.setEditable(false);
		txtPass.setFont(new Font("Arial Black", Font.BOLD, 14));
		txtPass.setBackground(new Color(0, 0, 0));
		txtPass.setForeground(new Color(0, 0, 0));
		txtPass.setBounds(700, btPan.getY()+btPan.getHeight()+50, 275, 31);
		txtPass.setColumns(10);
		txtPass.setBorder(new EmptyBorder(2, 4, 2, 4));
		txtPass.setOpaque(false);
		add(txtPass);
		
		
		setButton();
		
		
		CustButton btnCancel = new CustButton("CANCEL");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Home.enableHome();
			}
		});
		btnCancel.setBounds(520, txtPass.getY()+txtPass.getHeight()+20, 140, 40);
		add(btnCancel);
		
		
		CustButton btnOK = new CustButton("O K");
		btnOK.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				if(procPass())
				{
					procOK();
				}
			}
		});
		btnOK.setBounds(700, btnCancel.getY(), 140, 40);
		add(btnOK);
		
		
		CustButton btClr = new CustButton("CLEAR");
		btClr.setBounds(1020, 350, 150, 40);
		btClr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				clearButtons(false);
			}
		});
		add(btClr);
		
		
		CustButton btShowPass = new CustButton("SHOW PASSWORD ");
		btShowPass.setBounds(1000, 250, 200, 40);
		btShowPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				startAnim();
			}
		});
		add(btShowPass);
		
		
		txtUsr = new JTextField();
		txtUsr.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				setUsrErr();
			}
		});
		txtUsr.setOpaque(false);
		txtUsr.setForeground(Color.BLACK);
		txtUsr.setFont(new Font("Arial Black", Font.BOLD, 14));
		txtUsr.setColumns(10);
		txtUsr.setBackground(Color.BLACK);
		txtUsr.setBorder(new EmptyBorder(2, 4, 2, 4));
		txtUsr.setBounds(txtPass.getX(), txtPass.getY()-50, 275, 30);
		add(txtUsr);
		
		
		btClick();
		
		
		errpanel = new ErrorPn(5,20,5,70);
		errpanel.setBounds(txtUsr.getX()+txtPass.getWidth()+10, txtUsr.getY(), 300, 200);
		add(errpanel);
		
		
		MGPSSymbol bckAnim=new MGPSSymbol();
		bckAnim.setBounds(950, 600, 500, 500);
		add(bckAnim);

		
		h=new Hash();
		
		wel=new Welcome("Successful Sign Up");
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
		g2d.setStroke(new BasicStroke(5));
		g2d.drawLine(20, 20, getX()+getWidth()-20, 20);
		g2d.drawLine(20, 20, 20, getY()+getHeight()-20);
		g2d.drawLine(20, getY()+getHeight()-20, getX()+getWidth()-20, getY()+getHeight()-20);
		g2d.drawLine(getX()+getWidth()-20, 20, getX()+getWidth()-20, getY()+getHeight()-20);
		g2d.setStroke(new BasicStroke(4));
		g2d.setColor(new Color(0,0,0));
		g2d.setFont(new Font("Arial Bold", Font.BOLD,20 ));
		g2d.drawString("ENTERED PASSWORD IS : ",txtPass.getX()-270,txtPass.getY()+25);
		g2d.drawString("USERNAME : ",txtPass.getX()-270,txtUsr.getY()+20);
		g2d.setFont(new Font("Lucida Calligraphy", Font.ITALIC,60 ));
		g2d.drawString("WELCOME,", 50, 300);
		g2d.setFont(new Font("Arial Bold", Font.BOLD,60 ));
		g2d.setColor(Color.WHITE);
		g2d.drawString("User", 120, 380);
		g2d.setColor(new Color(255,255,255,50));
		g2d.fillRect(txtPass.getX(),txtPass.getY(), txtPass.getWidth(), txtPass.getHeight());
		g2d.fillRect(txtUsr.getX(),txtUsr.getY(), txtUsr.getWidth(), txtUsr.getHeight());
		g2d.setFont(new Font("Lucida Calligraphy", Font.ITALIC,80 ));
		g2d.setColor(new Color(0,0,0,100));
		g2d.drawString("Sign Up", (getX()+getWidth())/2-200, 100);
	}
	
	public void setButton()
	{
		int i,x=40,y=60,j=1;
		char c='a';
		for(i=0;i<64;i++)
		{
			
			Btarr[i] = new CustButton("" + c + j);
			btPan.add(Btarr[i]);
			Btarr[i].setBounds(x, y, 28, 28);
			x+=40;
			j++;
			if(((i+1)%8)==0)
			{
				x=40;
				y+=40;
				c++;
				j=1;
			}
		}
		CustButton.setPanel(btPan);
	}
	
	public void btClick()
	{
		for(i=0;i<64;i++)
		{
			Btarr[i].addMouseListener(new MouseAdapter() {
				int x=i;
				public void mousePressed(MouseEvent e) {
					clickProc(x);
				}	
			});
		}
	}
	
	
	public void clearButtons(boolean clrUsrName)
	{
		int i,x=40,y=60,j=1;
		for(i=0;i<64;i++)
		{
				Btarr[i].clear();
				Btarr[i].setEnabled(true);
				Btarr[i].removeMouseMotionListener(Btarr[i]);
				Btarr[i].setBounds(x, y, 28, 28);
				x+=40;
				j++;
				if(((i+1)%8)==0)
				{
					x=40;
					y+=40;
					j=1;
				}
		}
		txtPass.setText("");
		count=0;
		btPan.setClear();
		Password="";
		errpanel.setUsrErr("");
		errpanel.setPassErr("");
		if(clrUsrName)
			txtUsr.setText("");
		errpanel.setLength(-1);
	}
	
	public void clickProc(int x)
	{
		errpanel.setPassErr("");
		errpanel.setLength(count+1);
		Password=Password+Btarr[x].getName();
		if(!txtPass.getText().equals(""))
			txtPass.setText(txtPass.getText() + "--->" + Btarr[x].getName());
		else
			txtPass.setText(Btarr[x].getName());
		
		if(count==0)
		{
			btPan.setListener(Btarr[x].getX()+14, Btarr[x].getY()+14);
			for(i=0;i<64;i++)
			{
				Btarr[i].addMouseMotionListener(Btarr[i]);
			}
			lines[0][0]=Btarr[x].getX()+14;
			lines[0][1]=Btarr[x].getY()+14;
		}
		else
		{
			lines[count][0]=Btarr[x].getX()+14;
			lines[count][1]=Btarr[x].getY()+14;
			btPan.setlines(lines, count);
		}
		count++;
	}

	public boolean procPass()
	{
		errpanel.setLength(-1);
		if(txtUsr.getText().length()==0)
		{
			errpanel.setUsrErr("Enter a valid username");
			errpanel.setPassErr("");
			return false;
		}
		else if(h.isThere(txtUsr.getText()))
		{
			errpanel.setUsrErr("Username already exists");
			errpanel.setPassErr("");
			return false;
		}
		else if(Password.length()==0)
		{
			errpanel.setUsrErr("");
			errpanel.setPassErr("Select a Password");
			return false;
		}
		else if(Password.length()<10)
		{ 
			errpanel.setUsrErr("");
			errpanel.setPassErr("Select a larger Password");
			return false;
		}
		else
		{
			h.createHash(txtUsr.getText(),Password);
			usr=txtUsr.getText();
		}
		repaint();
		return true;
	}
	
	public void addButton()
	{
		int i;
		for(i=0;i<64;i++)
		{
			btPan.add(Btarr[i]);
		}
	}
	
	public void setUsrErr()
	{
		errpanel.setUsrErr("");
	}
	
	
	public synchronized void startAnim()
	{
		BtPanel.setAnim(true);
		btPan.setVisible(false);
		btPan.anim();
		animPan.setVisible(true);
		Thread th=new Thread(animPan);
		th.start();
	}
	
	public static void disableWel()
	{
		wel.setEnabled(false);
		wel.setVisible(false);
	}
	
	
	public void procOK()
	{
		wel.setNamex(usr,1);
		wel.setVisible(true);
		clearButtons(true);
		Home.disableHome();
		Home.disableLogin();
		Home.disableSignUp();
	}
}