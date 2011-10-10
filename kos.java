
/**
 *      Lab2.java
 *@author Kostya Kryvchenkoff
 *@version 0.3     
 * 
 */
class Printed//Class printed
{
	private double price;//This is price
	Printed(){};//Empty constructor
	Printed(double pr)
	{
		price=pr;
	}
	public double getPrice ()//Getter for price(price is private)
	{
		return price;
	}
	public void setPrice(double p)//And setter
	{
		price=p;
	}
}
class Book extends Printed//Class book 
{
	private int numofpages ;//How many pages does our book have
	public int getNumofpages()//Getter for it
	{
		return numofpages;
	}
	Book(int nop,double pr)//Constructor1
	{
		super(pr);//At first we use parent class constructor
		numofpages=nop;
	}
	Book(int nop)//And second
	{
		super(0);
		numofpages=nop;
	}
}
class Magazine extends Printed//Class magazine
{
	int month ;//Date of publication
	Magazine(int a,double pr)//Constructor
	{
		super(pr);
		month = a;
	}
}
class TextBook extends Book{//Class text book(which students use)
	private int formnum;//Form in which0 student study to use this book
	public int getFormnum()
	{
		return formnum;
	}
	TextBook(int fn,int nop,double pr)
	{
		super(nop,pr);
		formnum=fn;
	}
	TextBook(int fn,int nop)
	{
		super(nop);
		formnum=fn;
	}
	public void About ()//Output of class fieds
	{
		System.out.println	( "Клас = "+this.getFormnum()+
							"\nЦіна = "+this.getPrice()+" грн."+
							"\nСторінок = "+this.getNumofpages()+" pages."
							);
	}
} 
public class kos 
{
	public static void main (String args[])
	{
			TextBook Text = new TextBook(Double.parseInt(args[0]),Integer.parseInt(args[1]),Double.parseDouble(args[2]));
			Text.About();

	}
}

