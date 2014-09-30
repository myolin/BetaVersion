import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.*;
import java.util.*;

public class QuestionDisplay extends JPanel implements ActionListener {

	private BirdReader reader = new BirdReader();
	private ArrayList<Bird> birdArray = reader.getBirdArray();	
	private ArrayList<JRadioButton> radioList;
	private Random rand = new Random();
	private Question question;
	private JRadioButton choice1;
	private JButton testButton;
	private JButton exitButton;
	
	public QuestionDisplay(){		
		question = new Question(birdArray, 3);
		
		this.setLayout(new BorderLayout());
		try {
			BufferedImage myImage = ImageIO.read(new File("resources/imagesources/thumb_" + question.getCorrectBirdUrl()));
	        JLabel picLabel = new JLabel(new ImageIcon(myImage));
	        this.add(picLabel, BorderLayout.CENTER);
		}
		 catch (IOException ex) 
		{
			ex.printStackTrace();
			System.err.println("Sorry, we couldn't load your image file.");			
		}	
		
		choice1 = new JRadioButton(question.getCorrectBirdName());
		JRadioButton choice2 = new JRadioButton(question.getInocrrectBirdNames().get(0));
		JRadioButton choice3 = new JRadioButton(question.getInocrrectBirdNames().get(1));
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(choice1);
		radioGroup.add(choice2);
		radioGroup.add(choice3);
		
		radioList = new ArrayList<JRadioButton>();			
		radioList.add(choice1);
		radioList.add(choice2);
		radioList.add(choice3);
		
		Collections.shuffle(radioList);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3,1));		
		for(JRadioButton button: radioList){
			panel2.add(button);
		}
		this.add(panel2, BorderLayout.EAST);
		
		JPanel panel3 = new JPanel(new GridLayout(1,2));		
		testButton = new JButton("Check Answer");
		testButton.addActionListener(this);
		panel3.add(testButton);
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		panel3.add(exitButton);
		
		this.add(panel3, BorderLayout.SOUTH);
		
	}	
	
	public ArrayList<JRadioButton> getRadioList(){
		return radioList;
	}
	
	public String correctBird(){
		return question.getCorrectBirdName();
	}
	
	public String correctBirdURL(){
		return question.getCorrectBirdUrl();
	}
	
	public int index(){
		return radioList.indexOf(choice1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == exitButton){
			System.exit(0);
		}	
		else if (source == testButton) {
			if (choice1.isSelected()) {
				JOptionPane.showMessageDialog(this, "Correct");				
			}else{
				JOptionPane.showMessageDialog(this, "Incorrect");
			}
		}
		
	}
	
	
	
	
}
