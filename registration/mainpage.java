import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.io.IOException;
import java.sql.*;  

public class mainpage extends JFrame implements ActionListener
{
     JButton btn1;
	 JButton btn2;
	 Image img = Toolkit.getDefaultToolkit().getImage("cc.png"); 

	mainpage() throws IOException
    {
	
    setVisible(true);
    setSize(1920,1080);
	
	this.setContentPane(new JPanel() 
		 {
			@Override
			public void paintComponent(Graphics g) 
			{
				super.paintComponent(g);
				g.drawImage(img,500,100,200,200, null);
			}
         });
      	
	
    setLayout(null);
    setTitle("Welcome Page");
        
		btn1 = new JButton("New visitor");
        btn1.setBounds(425, 340, 150, 30);
        btn1.addActionListener(this);
        btn1.setActionCommand("NayaVisitor");
        add(btn1);
		btn2 = new JButton("Search Visitor");
		btn2.setBounds(625, 340, 150, 30);
		btn2.addActionListener(this);
		btn2.setActionCommand("SearchKaro");
		add(btn2);
        
		

    }

   
    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();

        if(cmd.equals("NayaVisitor"))
        {
            dispose();
			try{
            new registration();
			}
			catch (Exception e1) 
			{
			}
		}
		else if (cmd.equals("SearchKaro"))
			{
            dispose();
			try{
            new searchpage();
			}
			catch (Exception e2) 
			{
			}
		}
			
    }

    public static void main(String[] args) 
    {
		
       
				try{
                new mainpage();
				}
				catch (Exception e3)
				{
					 System.out.println(e3);
				}
            
    }
}