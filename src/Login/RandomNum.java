package Login;
import java.util.Random;

public class RandomNum {

	String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String numeric="123456789";
	String[] alphaNumeric=new String[64];

	
	public String[] generateRandom()
	{
		int i=0,j=0,flag=1;
		String temp=new String("\0");
				
		Random r=new Random();
		
		alphaNumeric[i]=Character.toString(alpha.charAt(r.nextInt(alpha.length())));
		alphaNumeric[i]=alphaNumeric[i].concat(Character.toString(numeric.charAt(r.nextInt(numeric.length()))));

		while(i!=63)
		{
			flag=1;
			temp=Character.toString(alpha.charAt(r.nextInt(alpha.length())));
			temp=temp.concat(Character.toString(numeric.charAt(r.nextInt(numeric.length()))));
	
			for(j=0;j<=i;j++)
			{
				if(alphaNumeric[j].compareTo(temp)==0)
				{
					flag=0;
					break;
				}
			}
			
			if(flag==1)
				alphaNumeric[++i]=temp;
		}
		return alphaNumeric;
	}
}
	
