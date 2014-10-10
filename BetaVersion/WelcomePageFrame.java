
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent.*;
import java.awt.event.ActionListener.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.ImageIcon.*;


public class WelcomePageFrame extends JFrame implements ActionListener {
	
	private JButton quiz1;
	private JButton quiz2;
	private JButton getaTour;
	private JButton exit;
	private JLabel image;
	private JPanel southPanel;
	private JPanel centerPanel;
	

	public WelcomePageFrame() {
		super();
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel southPanel = new JPanel();
		
		quiz1 = new JButton("Quiz 1");
		quiz1.addActionListener(this);
		quiz2 = new JButton("Quiz 2");
		quiz2.addActionListener(this);
		getaTour = new JButton("Tour");
		getaTour.addActionListener(this);		
		exit = new JButton("Quit");
		exit.addActionListener(this);
		southPanel.setLayout(new FlowLayout());
		southPanel.add(quiz1);
		southPanel.add(quiz2);
		southPanel.add(getaTour);
		southPanel.add(exit);
		
		this.add(southPanel, BorderLayout.SOUTH);
		
		JPanel centerPanel = new JPanel();
		ImageIcon backgroundImage = new ImageIcon(new File("resources/example2.jpg").getPath());
		JLabel image = new JLabel("",backgroundImage,SwingConstants.CENTER);
        centerPanel.add(image, BorderLayout.CENTER);
        this.add(centerPanel);
		
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(){
				WelcomePageFrame gui = new WelcomePageFrame();
				gui.setVisible(true);				
			}
		});
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == quiz1) {
			MainFrame gui = new MainFrame();
			gui.setVisible(true);
			this.dispose();
		}else if(source == quiz2){
			MainFrame2 gui = new MainFrame2();
			gui.setVisible(true);
			this.dispose();
		}else if (source == getaTour) {
			TourFrame gui = new TourFrame();
			this.dispose();
		}else if (source == exit){
			System.exit(0);
		}
		
	}
	
	
}
