import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent.*;
import java.awt.event.ActionListener.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * The TourFrame class does ...
 * 
 * @author zinsidaung13
 */
@SuppressWarnings("serial")
public class TourFrame extends JFrame implements ActionListener {
	private static final int NUM_BIRDS_IN_TOUR = 3;
	ArrayList<Bird> tourBirdList;

	private JButton nextButton;
	private JButton menuButton;
	private JPanel southPanel;
	JLabel picLabel;
	JLabel nameLabel;
	private int currentBirdIndex;
	private BirdReader reader;

	/**
	 * Creates a new TourFrame.
	 */
	public TourFrame() {
		super();
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		reader = new BirdReader();
		ArrayList<Bird> allBirdList = reader.getBirdArray();
		Collections.shuffle(allBirdList);

		// copy some birds into the tour bird list
		tourBirdList = new ArrayList<Bird>();
		for (int i = 0; i < NUM_BIRDS_IN_TOUR; i++) {
			tourBirdList.add(allBirdList.get(i));
		}

		currentBirdIndex = 0;

		nameLabel = new JLabel("bird name goes here", SwingConstants.CENTER);
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		this.add(nameLabel, BorderLayout.NORTH);

		updateBird();

		southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout());
		nextButton = new JButton("NEXT");
		nextButton.addActionListener(this);
		menuButton = new JButton("Menu");
		menuButton.addActionListener(this);
		southPanel.add(nextButton);
		southPanel.add(menuButton);
		this.add(southPanel, BorderLayout.SOUTH);
		this.setVisible(true);

	}

	/**
	 * 
	 */
	private void updateBird() {
		updateBirdImage();
		updateBirdName();
	}

	/**
	 * 
	 */
	private void updateBirdImage() {
		Bird currentBird = tourBirdList.get(currentBirdIndex);
		String currentBirdURL = currentBird.getURL();
		try {
			if (picLabel != null) { // if we already added a picLabel to the
									// frame, we need to get rid of it.
				this.remove(picLabel);
			}

			BufferedImage myImage = ImageIO.read(new File(
					"resources/imagesources/thumb_" + currentBirdURL));
			picLabel = new JLabel(new ImageIcon(myImage));

			this.add(picLabel, BorderLayout.CENTER);
		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("Sorry, we couldn't load your image file.");
		}
	}

	/**
	 * 
	 */
	private void updateBirdName() {
		Bird currentBird = tourBirdList.get(currentBirdIndex);
		String currentBirdName = currentBird.getName();
		nameLabel.setText(currentBirdName);
	}

	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == nextButton) {
			currentBirdIndex++;
			if (currentBirdIndex > NUM_BIRDS_IN_TOUR - 1) {
				currentBirdIndex = 0;
			}
			updateBird();
			this.validate();
		} else if (source == menuButton) {
			WelcomePageFrame gui = new WelcomePageFrame();
			gui.setVisible(true);
			this.dispose();
		}
	}

}
