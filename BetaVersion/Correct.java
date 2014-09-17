import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Correct extends JButton implements ActionListener{
	
	
	
	public Correct(){
		
	}
	
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		QuestionDisplay d = new QuestionDisplay();
		if(source == testButton){
		
		boolean result = d.getResult();
		if(result == true){
			JOptionPane.showMessageDialog(this, "Correct");
		}else{
			JOptionPane.showMessageDialog(this, "Incorrect");
		}
		}
	}
	

}
