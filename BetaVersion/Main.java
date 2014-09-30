import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main {

	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	private JButton next1;
	private JButton next2;
	private JButton next3;
	private JButton next4;
	private JButton next5;
	private JFrame frame;
	private CardLayout cardLayout = new CardLayout();
	private ButtonListener listener = new ButtonListener();
		
	public Main(){
		frame = new JFrame();
		frame.setLayout(cardLayout);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init();
		frame.pack();
		System.out.println("hehe");
		frame.setVisible(true);
	}
	
	public void init(){
							
		//panel1
		panel1 = new QuestionDisplay();
		next1 = new JButton("Go to Question 2");
		next1.addActionListener(listener);
		panel1.add(next1, BorderLayout.NORTH);
		
		//panel2
		
		panel2 = new QuestionDisplay();
		next2 = new JButton("Go to Question 3");
		next2.addActionListener(listener);
		panel2.add(next2, BorderLayout.NORTH);
		
		//panel3
		panel3 = new QuestionDisplay();
		next3 = new JButton("Go to Question 4");
		next3.addActionListener(listener);
		panel3.add(next3, BorderLayout.NORTH);	
		
		//panel4
		panel4 = new QuestionDisplay();
		next4 = new JButton("Go to Question 5");
		next4.addActionListener(listener);
		panel4.add(next4, BorderLayout.NORTH);
		
		//panel5
		panel5 = new QuestionDisplay();
		next5 = new JButton("Go to Question 6");
		next5.addActionListener(listener);
		panel5.add(next5, BorderLayout.NORTH);
		
		//panel6
		panel6 = new QuestionDisplay();
				
		//add
		frame.add("Panel1", panel1);
		frame.add("Panel2", panel2);
		frame.add("Panel3", panel3);
		frame.add("Panel4", panel4);
		frame.add("Panel5", panel5);
		frame.add("Panel6", panel6);
		
		
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(next1)){
				cardLayout.show(frame.getContentPane(), "Panel2");
			}else if(e.getSource().equals(next2)){
				cardLayout.show(frame.getContentPane(), "Panel3");
			}else if(e.getSource().equals(next3)){
				cardLayout.show(frame.getContentPane(), "Panel4");
			}else if(e.getSource().equals(next4)){
				cardLayout.show(frame.getContentPane(), "Panel5");	
			}else if(e.getSource().equals(next5)){
				cardLayout.show(frame.getContentPane(), "Panel6");
			}	
		}
	}	
	
	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				Main gui = new Main();		
				
		}
			
		});
		
	}
	
	
}
