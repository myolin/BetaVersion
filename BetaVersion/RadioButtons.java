import java.util.*;

import javax.swing.*;

public class RadioButtons {

	private JRadioButton choice1, choice2, choice3;
	BirdReader reader;
	ArrayList<Bird> birdArray;
	private String randomName;
	private String randomURL;
	
	Random rand = new Random();
		
	public RadioButtons(){
		
		birdArray = reader.getBirdArray();
		randomURL = reader.getRandomBirdURL();
		randomName = reader.getRandomBirdName();
		
		choice1 = new JRadioButton(randomName);
		birdArray.remove(randomName);
		
		String x = birdArray.get(rand.nextInt(birdArray.size())).getName();
		choice2 = new JRadioButton(x);
		birdArray.remove(x);
		
		String y = birdArray.get(rand.nextInt(birdArray.size())).getName();		
		choice2 = new JRadioButton(y);		
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(choice1);
		radioGroup.add(choice2);
		radioGroup.add(choice3);				
	}
	
	public ArrayList<JRadioButton> getRadioArray(){
		ArrayList<JRadioButton> radioList = new ArrayList<JRadioButton>();			
		radioList.add(choice1);
		radioList.add(choice2);
		radioList.add(choice3);
		return radioList;
	}
}
