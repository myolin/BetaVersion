//$$ TODO: Class needs commented -- one Javadoc /** */ comment above each class & method.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainFrame extends JFrame{

	private CardLayout cardLayout = new CardLayout();
	private ButtonListener listener = new ButtonListener();	
	private ArrayList<JPanel> panelArray = new ArrayList<JPanel>();
	private ArrayList<JButton> nextButtons = new ArrayList<JButton>();	
	private static final int numOfQuestions = 6;	
	BirdReader reader = new BirdReader();
	private ArrayList<Bird> birdArray;	
	private JPanel cardPanel;
	private JLabel scoreLabel;
	
				
	public MainFrame(){
		
		this.setSize(500,500);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		cardPanel = new JPanel();
		cardPanel.setLayout(cardLayout);
		
		init();
		
		this.add(cardPanel,BorderLayout.CENTER);
		
		this.pack();		
	}
	
	private void init(){
		birdArray = reader.getBirdArray();
		for(int i=0; i<numOfQuestions; i++){
			QuestionDisplay temp = new QuestionDisplay(birdArray);			
			panelArray.add(temp);
			JButton nextButton = new JButton("Go to Question " + (i+2));
			nextButtons.add(nextButton);
			nextButton.addActionListener(listener);
			temp.add(nextButton, BorderLayout.NORTH);			
			scoreLabel = new JLabel("Your score:");
			this.add(scoreLabel, BorderLayout.NORTH);
		}
		
		
		
		for(int i=0; i<panelArray.size(); i++){
			cardPanel.add(panelArray.get(i));
		}			
		
		
		
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(nextButtons.get(0))){
				cardLayout.next(cardPanel);
			}else if(e.getSource().equals(nextButtons.get(1))){
				cardLayout.next(cardPanel);
			}else if(e.getSource().equals(nextButtons.get(2))){
				cardLayout.next(cardPanel);
			}else if(e.getSource().equals(nextButtons.get(3))){
				cardLayout.next(cardPanel);
			}else if(e.getSource().equals(nextButtons.get(4))){
				cardLayout.next(cardPanel);
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
