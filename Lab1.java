/**
 *      Lab1.java
 *@author Dan Lizanets
 *      ця програма створена випадково
 *      
 */

public class Lab1 {
	
	public static void main (String args[]) {
		System.out.println("Welcome to HELL!");
		int abbath=100;
		short baloon=0100;
		long countdown=0x100;
		char devil='\u0410';
		boolean entity=false,frustration=false;
		double gender=0.01;
		frustration=!entity;
		countdown+=abbath;
		countdown+=(long)baloon;
		entity=countdown<abbath;
		countdown=abbath|baloon;
		countdown>>=2;
		countdown=1<2 ? 4 : 2 ;
	System.out.println( "V1= "+abbath+
						"\nV2= "+baloon+
						"\nV3= "+countdown+
						"\nV4= "+devil+
						"\nV5= "+entity+
						"\nV6= "+frustration+
						"\nV7= "+gender);
	}
}

