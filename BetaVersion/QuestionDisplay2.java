import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.*;
import java.util.*;

public class QuestionDisplay2 extends JPanel implements ActionListener {

	private BirdReader reader = new BirdReader();
	private ArrayList<Bird> birdArray = reader.getBirdArray();	
	private Question question;
	private ArrayList<BufferedImage> birdImages = new ArrayList<BufferedImage>();	
	private ArrayList<JButton> imageButtons = new ArrayList<JButton>();
	private JButton b1, b2, b3, b4, b5, b6;
	private int score = 0;
	
		
	public QuestionDisplay2(){
		question = new Question(birdArray, 6);
		this.setLayout(new BorderLayout());
		
	
					
		ArrayList<String> incorrectBirdUrlArray = question.getIncorrectBirdUrls();
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,3));
		
		JLabel questionLabel = new JLabel("Which image is the bird \"" + question.getCorrectBirdName() + "\"");
		this.add(questionLabel, BorderLayout.NORTH);
					
		try {
			birdImages.add(ImageIO.read(new File("resources/photos/thumb_" + question.getCorrectBirdUrl())));
			for(int i=0; i<incorrectBirdUrlArray.size(); i++){
				birdImages.add(ImageIO.read(new File("resources/photos/thumb_" + incorrectBirdUrlArray.get(i))));
			}				    
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Sorry, we couldn't load your image files.");		
		}
		
		b1 = new JButton(new ImageIcon(birdImages.get(0)));
		b2 = new JButton(new ImageIcon(birdImages.get(1)));
		b3 = new JButton(new ImageIcon(birdImages.get(2)));
		b4 = new JButton(new ImageIcon(birdImages.get(3)));
		b5 = new JButton(new ImageIcon(birdImages.get(4)));
		b6 = new JButton(new ImageIcon(birdImages.get(5)));
					
		imageButtons.add(b1);
		imageButtons.add(b2);
		imageButtons.add(b3);
		imageButtons.add(b4);
		imageButtons.add(b5);
		imageButtons.add(b6);
		
			
		/*for(int i=0; i<incorrectBirdUrlArray.size()+1; i++){
			imageButtons.add(new JButton(new ImageIcon(birdImages.get(i))));			
		}*/	
		
		Collections.shuffle(imageButtons);
		
		for(int i=0; i<incorrectBirdUrlArray.size()+1; i++){
			imageButtons.get(i).addActionListener(this);
			panel.add(imageButtons.get(i));
		}
								
		this.add(panel, BorderLayout.CENTER);
		
	}	
	
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		if(source == b1){
			JOptionPane.showMessageDialog(null, "Correct");
			for(JButton btn: imageButtons){
				btn.setEnabled(false);
			}		
			score+=1;
		}else{
			JOptionPane.showMessageDialog(null, "InCorrect");
			for(JButton btn: imageButtons){
				btn.setEnabled(false);
			}
		}
		
	}
	
	public Bird getBird() {
		return question.getCorrectBird();
	}
	
	
}
