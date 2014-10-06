import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainFrame extends JFrame{

	/*private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	private JButton next1;
	private JButton next2;
	private JButton next3;
	private JButton next4;
	private JButton next5;	*/
	private CardLayout cardLayout = new CardLayout();
	private ButtonListener listener = new ButtonListener();
	
	private ArrayList<JPanel> panels = new ArrayList<JPanel>();
	private ArrayList<JButton> nextButtons = new ArrayList<JButton>();
	private ArrayList<String> birdUsed = new ArrayList<String>();
	private static final int numOfQuestions = 6;
	
	BirdReader reader = new BirdReader();
	ArrayList<Bird> birdArray;
		
	public MainFrame(){
		
		this.setLayout(cardLayout);
		this.setSize(500,500);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init();
		this.pack();
		
		/*System.out.println(birdUsed.get(0));
		System.out.println(birdUsed.get(1));
		System.out.println(birdUsed.get(2));
		System.out.println(birdUsed.get(3));
		System.out.println(birdUsed.get(4));
		System.out.println(birdUsed.get(5));*/		
	}
	
	private void init(){
		birdArray = reader.getBirdArray();
		for(int i=0; i<numOfQuestions; i++){
			QuestionDisplay temp = new QuestionDisplay(birdArray);
			panels.add(temp);
			JButton nextButton = new JButton("Go to Question " + (i+2));
			nextButtons.add(nextButton);
			nextButton.addActionListener(listener);
			temp.add(nextButton, BorderLayout.NORTH);
			String useBird = temp.correctBird();
			birdArray.remove(useBird);
			birdUsed.add(useBird);				
		}
		
	
		
		//for(int i=0; i<numOfQuestions; i++){
		//	this.add("Panel" + (i+2), panels.get(i));
		//}
		
	/*	for(int i=0; i<numOfQuestions; i++){
			QuestionDisplay questionPanel = new QuestionDisplay();
			while(birdUsed.contains(questionPanel.correctBird())){
				questionPanel = new QuestionDisplay();
			}
			JButton nextButton = new JButton("Go to Question" + (i+2));
			nextButton.addActionListener(listener);
			questionPanel.add(nextButton, BorderLayout.NORTH);
			panel.add(questionPanel);
			birdUsed.add(questionPanel.correctBird());
		}
		
		QuestionDisplay questionPanel = new QuestionDisplay();
		while(birdUsed.contains(questionPanel.correctBird())){
			questionPanel = new QuestionDisplay();
		}
		panel.add(questionPanel);
		
		for(int i=0; i<panel.size(); i++){
			frame.add("Panel"+(i+1), panel.get(i));
		}*/
		
							
	/*	//panel1
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
		panel6 = new QuestionDisplay();*/
				
		//add
		this.add("Panel1", panels.get(0));
		this.add("Panel2", panels.get(1));
		this.add("Panel3", panels.get(2));
		this.add("Panel4", panels.get(3));
		this.add("Panel5", panels.get(4));
		this.add("Panel6", panels.get(5));		
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(nextButtons.get(0))){
				cardLayout.show(getContentPane(), "Panel2");
			}else if(e.getSource().equals(nextButtons.get(1))){
				cardLayout.show(getContentPane(), "Panel3");
			}else if(e.getSource().equals(nextButtons.get(2))){
				cardLayout.show(getContentPane(), "Panel4");
			}else if(e.getSource().equals(nextButtons.get(3))){
				cardLayout.show(getContentPane(), "Panel5");	
			}else if(e.getSource().equals(nextButtons.get(4))){
				cardLayout.show(getContentPane(), "Panel6");
			}	
		}
	}	
	
	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				MainFrame gui = new MainFrame();		
				gui.setVisible(true);
				
		}
			
		});
		
	}
	
	
}
