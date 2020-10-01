import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.io.IOException;
import java.sql.*; 
import java.io.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel; 
public class registration extends JFrame implements ActionListener  
{   private DefaultTableModel dtm;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8,l9;  
    JTextField tf1, tf2, tf5, tf6, tf7, tf8, tf9;  
    JButton btn1, btn2,btn3,btn4; 
    Image img = Toolkit.getDefaultToolkit().getImage("cc.png"); 
  
	
    registration() throws IOException  
       {  

	     this.setContentPane(new JPanel() 
		 {
			@Override
			public void paintComponent(Graphics g) 
			{
				super.paintComponent(g);
				g.drawImage(img,1080,0,150,150, null);
			}
         });
      	pack();
		
	 
  
        
       Object[] tblHead = { "Name","Email-ID","Purpose of visit","Person to meet","Phone No-","Address" }; 
		
		dtm  =new DefaultTableModel();
		dtm.setColumnIdentifiers(tblHead);
		
        
        JTable j = new JTable(); 
        j.setBounds(290, 450, 100, 100); 
		JScrollPane scrol = new JScrollPane(j);
        scrol.setBounds(70, 390, 1000, 200);
		
		j.setModel(dtm);
		setVisible(true);  
		setExtendedState(JFrame.MAXIMIZED_BOTH);	
        setLayout(null);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setTitle("Registration Form");  
        l1 = new JLabel("Registration Form:");  
        l1.setForeground(Color.blue);  
        l1.setFont(new Font("Serif", Font.BOLD, 20));  
        l2 = new JLabel("Name:");  
        l3 = new JLabel("Email-ID:");  
        l4 = new JLabel("Address:");  
        l6 = new JLabel("Purpose of visit:");  
        l7 = new JLabel("Person to meet:");  
        l8 = new JLabel("Phone No:");   
        l9 = new JLabel("  ");
		
		
		tf1 = new JTextField();  
        tf2 = new JTextField();  
        tf8 = new JTextField();  
        tf5 = new JTextField();  
        tf6 = new JTextField();  
        tf7 = new JTextField();  
        btn1 = new JButton("Submit");  
        btn2 = new JButton("Clear");
		btn3 = new JButton("Back");
	    btn4 = new JButton("Validate");
		
        l1.setBounds(200, 30, 400, 30);  
        l2.setBounds(180, 70, 200, 30);  
        l3.setBounds(180, 110, 200, 30);  
        l4.setBounds(180, 150, 200, 30);  
        l6.setBounds(180, 230, 200, 30);  
        l7.setBounds(180, 270, 200, 30);  
       l8.setBounds(180, 310, 200, 30);
		l9.setBounds(620, 310, 200, 30);
		
		
        tf1.setBounds(400, 70, 200, 30);  
        tf2.setBounds(400, 110, 200, 30);  
        tf8.setBounds(400, 150, 200, 30);  
        tf5.setBounds(400, 230, 200, 30);  
        tf6.setBounds(400, 270, 200, 30);  
        tf7.setBounds(400, 310, 200, 30); 
		btn1.setBounds(300, 350, 100, 30);  
        btn2.setBounds(180, 350, 100, 30); 
		btn3.setBounds(420, 350, 100, 30);
		btn4.setBounds(540, 350, 100, 30);
		btn3.addActionListener(this);
        btn3.setActionCommand("back");
		btn4.addActionListener(this);
        btn4.setActionCommand("validate");
		btn1.addActionListener(this);
		btn1.setActionCommand("okay");
		btn2.addActionListener(this);
		btn2.setActionCommand("clear");
		add(l1);  
        add(l2);  
        add(tf1);  
        add(l3);  
        add(tf2);  
        add(l4);  
        add(tf8);  
        add(l6);  
        add(tf5);  
        add(l7);  
        add(tf6);  
        add(btn1);  
        add(btn2);
		add(btn3);
		add(btn4);
	    add(scrol);
	l9.setForeground(Color.red);
      tf7.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent ke) {
            String value = tf7.getText();
            int l = value.length();
            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' && l<=9 ) {
               tf7.setEditable(true);
               l9.setText("");
            } 
			else if (l>9){
				tf7.setEditable(false);
				 l9.setText("* Max. Length is 10 Digits");
			}
			else {
               
               l9.setText("* Enter only numeric digits(0-9)");
            }
         }
      });
		add(l8);  
        add(tf7);
		add(l9);
		
    }   
	public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();

        if(cmd.equals("back"))
        {
            dispose();
			try{
            new mainpage();
			}
			catch (Exception e1) 
			{
			}
		}
		else if(cmd.equals("okay"))
			{
			
			Object [] row=new Object[6]; 
			  row[0] = tf1.getText().toUpperCase();
              row[1] = tf2.getText();
              row[2] = tf5.getText();
              row[3] = tf6.getText();
			  row[4] = tf7.getText();
			  row[5] = tf8.getText();
			 
			 dtm.addRow(row);
			 
			 tf1.setText("");
            tf2.setText("");
			tf5.setText("");
            tf6.setText("");
			tf7.setText("");
            tf8.setText("");
			l9.setText("");
			tf7.setEditable(true);
			
			}
			 else if(cmd.equals("clear"))
			{
			tf1.setText("");
            tf2.setText("");
			tf5.setText("");
            tf6.setText("");
			tf7.setText("");
            tf8.setText("");
			
			int rowCount = dtm.getRowCount();
		
			for (int i = rowCount - 1; i >= 0; i--) 
			   {
				dtm.removeRow(i);
			   }
			tf7.setEditable(true);
               l9.setText("");   
			   }
		else if(cmd.equals("validate"))
		{
			try{
            File file= new File("C:\\Users\\Ashrit\\Desktop\\PS Project\\test\\Database\\Data.xls");
			TableModel model = dtm;
			FileWriter out = new FileWriter(file);

        for(int i = 0; i < model.getColumnCount(); i++)
		{
            out.write(model.getColumnName(i) + ":"+"\t");
        }
        
		
       out.write("\n");

       for(int i=0; i< model.getRowCount(); i++) {
				for(int j=0; j < model.getColumnCount(); j++) 
			{
                out.write(model.getValueAt(i,j).toString()+";"+"\t");
            }
				out.write("\n");
        }
	   out.close();
		int rowCount = dtm.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) 
			   {
				dtm.removeRow(i);
			   }	
			
			}
			catch(IOException e11)
			{ System.out.println(e11); 
			}
        }
    }
	
	public static void main(String args[])  
    {  
    try{
	new registration();  
	}    
	catch(Exception e)
	{
	   System.out.println(e);
	}
    }  
}  
