package User;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Misc.CustButton;
import Misc.Hash;
import SignUp.AnimPanel;
import SignUp.BtPanel;


public class ChgPassPn extends JPanel{
	
	int p=0,q=0;
	CustButton[] Btarr=new CustButton[64];
	private final JTextField txtPass = new JTextField();
	BtPanel btPan;
	Hash h;
	int i,lines[][]=new int[64][2];
	String Password=new String(""),err=new String("");
	String usrname=null;
	private int count=0;
	AnimPanel animPan;
	
	public ChgPassPn(String usr)
	{
		usrname=usr;
		
		setLayout(null);
		
		setOpaque(false);
		
		btPan = new BtPanel();
		btPan.setBorder(null);
		btPan.setBackground(new Color(102, 102, 204));
		btPan.setBounds(200, 50, 390, 410);
		btPan.setOpaque(false);
		add(btPan);
		btPan.setLayout(null);
		
		
		animPan = new AnimPanel(btPan);
		animPan.setBounds(200, 50, 390, 410);
		add(animPan);
		
		txtPass.setEditable(false);
		txtPass.setFont(new Font("Arial Black", Font.BOLD, 14));
		txtPass.setBackground(new Color(0, 0, 0));
		txtPass.setForeground(new Color(0, 0, 0));
		txtPass.setBounds(btPan.getX()+300, btPan.getY()+btPan.getHeight()-10, 275, 30);
		txtPass.setColumns(10);
		txtPass.setBorder(new EmptyBorder(2, 4, 2, 4));
		txtPass.setOpaque(false);
		add(txtPass);
		
		
		setButton();
		
		
		CustButton btnCancel = new CustButton("CANCEL");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserPn.showHome();
			}
		});
		btnCancel.setBounds(txtPass.getX()-100, txtPass.getY()+txtPass.getHeight()+5, 140, 40);
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
		btnOK.setBounds(btnCancel.getX()+200, btnCancel.getY(), 140, 40);
		add(btnOK);
		
		
		CustButton btClr = new CustButton("CLEAR");
		btClr.setBounds(btPan.getX()+btPan.getWidth()+125, btPan.getY()+(btPan.getHeight()/2)-100, 150, 40);
		btClr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				clearButtons();
			}
		});
		add(btClr);
		
		
		CustButton btShowPass = new CustButton("SHOW PASSWORD ");
		btShowPass.setBounds(btPan.getX()+btPan.getWidth()+100, btPan.getY()+(btPan.getHeight()/2), 200, 40);
		btShowPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				startAnim();
			}
		});
		add(btShowPass);
		
		
		btClick();


		h=new Hash();
		
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
		g2d.setStroke(new BasicStroke(4));
		g2d.setColor(new Color(0,0,0));
		g2d.setFont(new Font("Arial Bold", Font.BOLD,20 ));
		g2d.drawString("ENTERED PASSWORD IS : ",txtPass.getX()-270,txtPass.getY()+25);
		g2d.setFont(new Font("Lucida Calligraphy", Font.ITALIC,60 ));
		g2d.setColor(new Color(255,255,255,50));
		g2d.fillRect(txtPass.getX(),txtPass.getY(), txtPass.getWidth(), txtPass.getHeight());
		g2d.setFont(new Font("Lucida Calligraphy", Font.ITALIC,40 ));
		g2d.setColor(new Color(255,255,255,100));
		g2d.drawString("Change Password", 10, 50);
		g2d.setColor(Color.RED);
		g2d.setFont(new Font("Lucida Calligraphy", Font.ITALIC,20 ));
		g2d.drawString(err, txtPass.getX()+txtPass.getWidth()+10, txtPass.getY()+18);
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
	
	
	public void clearButtons()
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
		err="";
		err="";
		repaint();
	}
	
	public void clickProc(int x)
	{
		err="";
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
		if(Password.length()==0)
		{
			err="Select a Password";
			repaint(txtPass.getX()+txtPass.getWidth()+10, txtPass.getY()-20,300,50);
			return false;
		}
		else if(Password.length()<10)
		{ 
			err="Select a larger Password";
			repaint(txtPass.getX()+txtPass.getWidth()+10, txtPass.getY()-20,300,50);
			return false;
		}
		else
		{
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
		err="";
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
	
	
	public void procOK()
	{
		clearButtons();
		h.delUsr(usrname);
		h.setPass(Password);
		h.addUsrName(usrname);
		setVisible(false);
		UserPn.showHome();
	}
}