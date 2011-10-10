import java.util.*;
import java.lang.StringBuffer;
class Lab4
{
	public static void main(String[] args)
	{
		String s = "String, which we want to decompose"; 
		int a =0;
		int max=0;
		int min=s.length();
		StringTokenizer st = new StringTokenizer(s, " "); 
		while(st.hasMoreTokens())
		{ 
			a=st.nextToken().length();
			max = a > max ? a : max ;
			min = a < min ? a : min ;
		}
	System.out.println("Min: "+min+" Max: "+max);
	}
	
} 
