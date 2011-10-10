
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
public class Lab6  extends JFrame implements ActionListener
{
	JTextArea ta;
	JLabel jl;
	JScrollPane sp;
	JPanel jp;
	JFileChooser jfj0,jfj1;
	JButton jb;
	Lab6 () 
	{
		this.setTitle("mv");
		this.setSize(1024,768);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		jl = new JLabel("Переміщення файлу");
		jp = new JPanel(new BorderLayout());
	       	jb = new JButton("Перемістити");	
		jfj0 = new JFileChooser();	
	
		jfj1 = new JFileChooser();
		jb.addActionListener(this);
			//	jfj0.showOpenDialog(null);
		//	( ( JButton ) ( ( JPanel ) jfj0.getComponent( 5 ) ).getAccessibleContext().getAccessibleChild( 5 ).getAccessibleContext().getAccessibleChild( 2 ) ).setVisible( false );

	jp.add(jfj0, BorderLayout.WEST);
	jp.add(jfj1, BorderLayout.EAST);
		this.add(jl, BorderLayout.NORTH);
		this.add(jp,BorderLayout.CENTER);
		this.add(jb,BorderLayout.SOUTH);
		}
	public void actionPerformed(ActionEvent ae)
	{
		try {
		char j=0;
		//ta.setText("");
		File d = jfj0.getSelectedFile();
		File cd = jfj1.getCurrentDirectory();
	//	File d0 = jfj0.getSelectedFile();
		File cd0 = jfj0.getCurrentDirectory();
		String a=d.getName();
		String b=cd.getAbsolutePath();
	//	String a0=d0.getName();
		String b0=cd0.getAbsolutePath();

		FileInputStream fis = new FileInputStream(b0 +File.separator+ a);
	FileOutputStream fos = new FileOutputStream( b +File.separator+ a);
		for (int i=0;i<d.length() ;i++ )
		       fos.write(fis.read());
		d.delete();
		}
		catch(FileNotFoundException fnfe){
		System.out.println(fnfe);
		}
		catch(IOException ioe){
		System.out.println(ioe);
		}
	}
	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Lab6();
			}});
		
	}
}

