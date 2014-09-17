import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.*;
import java.util.*;

public class QuestionDisplay extends JPanel {

	BirdReader reader = new BirdReader();
	ArrayList<Bird> birdArray = reader.getBirdArray();	
	ArrayList<JRadioButton> radioList;
	Random rand = new Random();
	Question question = new Question(birdArray, 3);
	
	public QuestionDisplay(){
		
		
		
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
		
		JRadioButton choice1 = new JRadioButton(question.getCorrectBirdName());
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
	}
	
	public boolean getResult(){
		boolean isSelected = false;
		int index = -1;
		for(int i=0; i<radioList.size(); i++){
			if(radioList.get(i).isSelected()){
				index = i;
				isSelected = true;
			}
		}
		boolean nameEqual = false;
		if(radioList.get(index).getText().equalsIgnoreCase(question.getCorrectBirdName())){
			nameEqual = true;
		}
		
		if(isSelected && nameEqual){
			return true;
		}else{
			return false;
		}
	}
	
	
}
