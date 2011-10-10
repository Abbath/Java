import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
/**
 * 
 * @author varg
 * @version 1.0
 */
public class PWDJava extends JFrame implements ActionListener
	{
	private static final long serialVersionUID = 2398722125005049113L;
		private JLabel jLabel;
		private JFileChooser jFileChooser;
		private JTextField jTextField;
		public PWDJava ()
			{
				this.setTitle("PWDJava");
				this.setSize(800, 600);
				this.setVisible(true);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				jLabel = new JLabel("Виведення шляху");
				jLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 25));
				this.add(jLabel, BorderLayout.NORTH);
				

				jTextField = new JTextField(100);
				jTextField.setFont(new Font("DejaVu Sans Mono", Font.ITALIC, 20));
				this.add(jTextField, BorderLayout.SOUTH);
				
				jFileChooser = new JFileChooser();
				this.add(jFileChooser, BorderLayout.CENTER);
				jFileChooser.addActionListener(this);
				jFileChooser.setApproveButtonText("Показати абсолютну адресу");
				jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			}
		@Override
		public void actionPerformed(ActionEvent e)
			{
				if (JFileChooser.APPROVE_SELECTION.equals(e.getActionCommand()))
				{
					File file = jFileChooser.getSelectedFile();
					jTextField.setText(file.getPath());
				}
				if (JFileChooser.CANCEL_SELECTION.equals(e.getActionCommand()))
					{
						jFileChooser.setVisible(false);
						jFileChooser = null;
						System.exit(0);
					}
			}
		public static void main(String[] args)
			{
				SwingUtilities.invokeLater(new Runnable ()
				{
					public void run()
						{
							new PWDJava();
						}
				});			
			}
	}
