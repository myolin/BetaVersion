import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame2 extends JFrame implements ActionListener {
	
	private JPanel mainPanel;
	private CardLayout cardLayout = new CardLayout();
	private static final int numOfQuestions = 6;	
	private ArrayList<JPanel> panelArray = new ArrayList<JPanel>();
	private ArrayList<JButton> nextButtons = new ArrayList<JButton>();	
	private JLabel scoreLabel;
	
	public MainFrame2(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,1000);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		mainPanel = new JPanel();
		mainPanel.setLayout(cardLayout);
		
		init();
		
		this.add(mainPanel, BorderLayout.CENTER);
		
		this.pack();		
	}
	
	private void init(){
		for(int i=0; i<numOfQuestions; i++){
			QuestionDisplay2 temp = new QuestionDisplay2();
			panelArray.add(temp);
			JButton nextButton = new JButton("Go to Question " + (i+2));
			nextButton.addActionListener(this);
			nextButtons.add(nextButton);			
			temp.add(nextButton, BorderLayout.SOUTH);			
			scoreLabel = new JLabel("Your score:");
			this.add(scoreLabel, BorderLayout.NORTH);
			}
						
			for(int i=0; i<panelArray.size(); i++){
				mainPanel.add(panelArray.get(i));
			}		
	}
			
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		for(int i=0; i<numOfQuestions; i++){
			if(source == nextButtons.get(i)){
				cardLayout.next(mainPanel);				
			}
		
		}
	}
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				MainFrame2 gui = new MainFrame2();
				gui.setVisible(true);
			}
		});
	}
}
