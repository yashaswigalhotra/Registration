
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
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
import java.util.*;
import java.awt.event.*;  
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.RowFilter;
import java.io.IOException;
import java.sql.*; 
import java.io.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel; 

public class searchpage extends JFrame implements ActionListener{
private DefaultTableModel dtm;
private JTable j;
 //private TableRowSorter sorter;
JButton btn1, btn2,btn3,btn4; 
JLabel l1,l3;
JTextField tf1,tf3;
Image img = Toolkit.getDefaultToolkit().getImage("cc.png"); 

searchpage() throws IOException{
	setVisible(true);
	
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
		
	
	
	
   Object[] tblHead = { "Name","Email-ID","Address","Purpose of visit","Person to meet","Phone No:" }; 
		
		dtm  =new DefaultTableModel();
		dtm.setColumnIdentifiers(tblHead);
		
        
         j = new JTable(); 
        j.setBounds(290, 450, 100, 100); 
		JScrollPane scrol = new JScrollPane(j);
        scrol.setBounds(70, 390, 1000, 200);
		
		j.setModel(dtm);
		
		
	
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	setLayout(null);
	setTitle("Search Visitor");  

	btn1 = new JButton("Search");
	btn1.addActionListener(this);
	btn1.setActionCommand("search");	
	btn2 = new JButton("Back");
	btn1.setBounds(300, 300, 150, 30);  
	btn2.setBounds(100, 300, 150, 30);
	btn2.addActionListener(this);
	btn2.setActionCommand("back");
	btn3 = new JButton("Fetch Database");
	btn3.addActionListener(this);
	btn3.setBounds(300, 250, 150, 30);  
	btn3.setActionCommand("fetch");
	
	btn4 = new JButton("New Search");
	btn4.addActionListener(this);
	btn4.setBounds(500, 300, 150, 30);  
	btn4.setActionCommand("new");
	
	add(btn1);  
	add(btn2);
	add(btn3);
	add(btn4);
	
	l1 = new JLabel("Name:");  
	
    l3 = new JLabel("Enter Database Name [DDmonth.txt]");
	tf1 = new JTextField();  
	
    tf3 = new JTextField();
	l1.setBounds(100, 125, 100, 30);  
	
	l3.setBounds(400, 125, 300, 30); 
	tf1.setBounds(150, 125, 200, 30);  
	
	tf3.setBounds(625, 125, 200, 30); 
	add(l1);
	
	add(l3);
	add(tf1);
	
	add(tf3);
	add(scrol);
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
		
		else if(cmd.equals("fetch"))
		{
			
			String fname= tf3.getText();
			String path= "C:\\Users\\Ashrit\\Desktop\\PS Project\\test\\Database\\";
			String filePath = path.concat(fname);
            
			
			
			File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            // get the first line
            // get the columns name from the first line
            // set columns name to the jtable model
            String firstLine = br.readLine().trim();
            String[] columnsName = firstLine.split(":");
            DefaultTableModel model1 = dtm;
            model1.setColumnIdentifiers(columnsName);
            
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines
            // set data to jtable model
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(";");
                model1.addRow(dataRow);
            }
            
            
            } 
			catch (Exception ex1) 
		    {
            
            }
        } 
		
		
		else if(cmd.equals("search"))
		{
		String value = tf1.getText().toUpperCase();	
		TableRowSorter<DefaultTableModel> tr= new TableRowSorter<DefaultTableModel>(dtm);
        j.setRowSorter(tr);
		
		tr.setRowFilter(RowFilter.regexFilter(value));
			
		}
		
		else if(cmd.equals("new"))
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
	
	
	
	

public static void main(String args[])  
{  
try
{
new searchpage();  
}    
catch(Exception e)
{
  System.out.println(e);
}
}  
}
  
