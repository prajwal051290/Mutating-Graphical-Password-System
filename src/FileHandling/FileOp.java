package FileHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class FileOp {
	
	FileInputStream f;
	byte[] b=new byte[20]; 

	public int compare(String s, String p)
	{
		int flag=2,size=0;
		try {
			f=new FileInputStream(".\\a.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(size!=-1)
		{
			try {
				
				MessageDigest sha=MessageDigest.getInstance("SHA1");
				byte[] digest=sha.digest(s.getBytes());
				
				size=f.read(b);
				boolean blnResult = Arrays.equals(b,digest);
				
				if(blnResult)
				{
					digest=sha.digest(p.getBytes());
					size=f.read(b);
					blnResult = Arrays.equals(b,digest);
					
					if(blnResult)
					{
						flag=0;
						return 0;
					}
					flag=1;
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(flag==1)
			return -1;
		return -2;
	}
}


