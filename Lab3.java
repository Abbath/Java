/**
 *      Lab3.java
 *@author Dan Lizanets
 *      ця програма створена випадково
 *      
 */
import java.util.Random;

public class Lab3 {
public static int fac(int a){
 int res;
       
       if (a==0)
           return 1; 
       else
       {
           res = a*fac(a-1);
           return res;
       }
}	
	public static void main (String args[]) {
		int n =4;
		int a[] = new int[n];
		double sum=0;
		Random randomGenerator = new Random();
		for (int i = 0; i <n ; i++)
		{
			a[i] = randomGenerator.nextInt(4);
		}
		for (int i = 0; i < n; i++)
		{
			int b=fac(i);
		System.out.println("Answer = "+b+" "+a[i]);
			if((int)a[i]<b && (int)a[i]>i+1){
			sum*=a[i];
			}
		}
		System.out.println("Answer = "+ sum);

		sum=1.0/sum;
		System.out.println("Answer = "+ sum);
		
	}
}

