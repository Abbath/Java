
/**
 *      Lab2.java
 *@author Kostya Kryvchenkoff
 *@version 0.3     
 * */
 class MyException extends Exception{
	 private String msg;
	 MyException(){msg=null;}
	 MyException(String s){msg=s;}
	 public String toString(){
	return "It happened ("+msg+")";
		 }

	  }
class Printed
{
	private double price;
	Printed(){};
	Printed(double pr)
	{
		price=pr;
	}
	public double getPrice ()
	{
		return price;
	}
	public void setPrice(double p)
	{
		price=p;
	}
}
class Book extends Printed
{
	private int numofpages ;
	public int getNumofpages()
	{
		return numofpages;
	}
	Book(int nop,double pr)
	{
		super(pr);
		numofpages=nop;
	}
	Book(int nop)
	{
		super(0);
		numofpages=nop;
	}
}
class Magazine extends Printed
{
	int month ;
	Magazine(int a,double pr)
	{
		super(pr);
		month = a;
	}
}
class TextBook extends Book{
	private double formnum;
	public double getFormnum()
	{
		return formnum;
	}
	TextBook(double fn,int nop,double pr)
	{
		super(nop,pr);
		formnum=fn;
	}
	TextBook(double fn,int nop)
	{
		super(nop);
		formnum=fn;
	}
	public void About ()
	{
		System.out.println	( "Клас = "+this.getFormnum()+"%"+
							"\nЦіна = "+this.getPrice()+" грн."+
							"\nСторінок = "+this.getNumofpages()+" days."
							);
	}
} 
public class Lab2 
{
	public static void main (String args[])
	{
		try 
		{
			if(args.length!=3) throw new MyException("No way!");
			TextBook Text = new TextBook(Double.parseDouble(args[0]),Integer.parseInt(args[1]),Double.parseDouble(args[2]));
			Text.About();

		}
		catch (MyException ose)
		{
			System.out.println("Ololo: "+ose);
			ose.printStackTrace();
		}
	}
}

