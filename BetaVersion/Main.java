import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Main extends JFrame implements ActionListener{
		
	Container pane;
	JButton exitButton;
	JButton testButton;
	BirdReader reader = new BirdReader();
	ArrayList<Bird> birdArray = reader.getBirdArray();	
	
	public Main(){
		 pane = getContentPane();
		 setSize(500,500);
		 add(new QuestionDisplay());

		 southPanel();	 
		 
		 pack();
		 
	}
	
	public void southPanel(){
		JPanel southPanel = new JPanel(new GridLayout(1,2));
		exitButton = new JButton("EXIT");
		southPanel.add(exitButton, BorderLayout.SOUTH);		
		exitButton.addActionListener(this);
		
		testButton = new JButton("Test");	
		southPanel.add(testButton, BorderLayout.SOUTH);
		testButton.addActionListener(this);
		
		this.add(southPanel, BorderLayout.SOUTH);
		
		
	}
	
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		QuestionDisplay d = new QuestionDisplay();
		if(source == exitButton){
			System.exit(0);
		}
		if(source == testButton){			
			boolean result = d.getResult();
			if(result){
				JOptionPane.showMessageDialog(this, "Correct");
			}else{
				JOptionPane.showMessageDialog(this, "Incorrect");
			}
			}
	}
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				Main frame = new Main();
				frame.setVisible(true);
			}
		});
	}
}