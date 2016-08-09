package Misc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


public class Hash {

	String usrStr,passStr;
	FileOutputStream f;
	byte[] newpass=new byte [20];
	
	public void createHash(String s1,String s2)
	{
		usrStr=s1;
		passStr=s2;
		try {
			f=new FileOutputStream(".\\a.txt",true);
			MessageDigest sha=MessageDigest.getInstance("SHA1");
			byte[] digest=sha.digest(usrStr.getBytes());
			f.write(digest);
			digest=sha.digest(passStr.getBytes());
			f.write(digest);
			f.close();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean isThere(String usr)
	{
		FileInputStream f1=null;
		int size=0;
		byte[] b=new byte[20];
		byte[] digest=null;
		try {
			f1=new FileInputStream(".\\a.txt");
			MessageDigest sha = MessageDigest.getInstance("SHA1");
			digest=sha.digest(usr.getBytes());
		} catch (FileNotFoundException e1) {
			return false;
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(size!=-1)
		{
			try {
				size=f1.read(b);
				boolean blnResult = Arrays.equals(b,digest);
				if(blnResult)
				{
					f1.close();
					return true;
				}
				size=f1.read(b);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			f1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public void delUsr(String usr)
	{
		FileInputStream f1=null;
		FileOutputStream temp=null;
		File delFile;
		int size=0;
		byte[] digest=null;
		byte[] b=new byte[20]; 
		try {
			f1=new FileInputStream(".\\a.txt");
			temp=new FileOutputStream(".\\temp.txt");
			MessageDigest sha=MessageDigest.getInstance("SHA1");
			digest=sha.digest(usr.getBytes());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(size!=-1)
		{
			try {
				size=f1.read(b);
				boolean blnResult = Arrays.equals(b,digest);
				if(blnResult)
				{
					size=f1.read(b);
					newpass=b.clone();
					continue;
				}
				temp.write(b);
				size=f1.read(b);
				temp.write(b);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			f1.close();
			temp.close();
			f1=new FileInputStream(".\\temp.txt");
			delFile=new File(".\\a.txt");
			delFile.delete();
			f=new FileOutputStream(".\\a.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(size!=-1)
		{
			try {
				size=f1.read(b);
				f.write(b);
				size=f1.read(b);
				f.write(b);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		delFile=new File(".\\temp.txt");
		delFile.delete();
		try {
			f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void addUsrName(String usr)
	{
		try {
			f=new FileOutputStream(".\\a.txt",true);
			MessageDigest sha=MessageDigest.getInstance("SHA1");
			byte[] digest=sha.digest(usr.getBytes());
			f.write(digest);
			f.write(newpass);
			f.close();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void setPass(String pass)
	{
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA1");
			newpass=sha.digest(pass.getBytes());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
