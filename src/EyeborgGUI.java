import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class EyeborgGUI extends JFrame {
	
	private String[] mappings = { "Harbisson", "Newton", "Castel", "Field", "Jameson", "Semann", "Rimington", "Bishop", "Helmholtz", "Scriabin", "Klein", "Aeppli", "Belmont", "Zieverink" };
	
	public EyeborgGUI() {
		createGUI();
	}
	
	private void createGUI() {
		setTitle("Eyeborg");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JPanel imagePanel = new JPanel(); // Will hold the primary image
		JPanel controlPanel = new JPanel();
		
		imagePanel.setPreferredSize(new Dimension(1100,700));
		imagePanel.setLayout(new FlowLayout());
		imagePanel.add(new ImageLabel("resource/SchoolOfAthens.jpg"));
		
		controlPanel.setPreferredSize(new Dimension(200, 700));
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));
		
		JLabel dominantColorLabel = new JLabel("Dominant Color");
		JPanel dominantColorPanel = new JPanel();
		//dominantColorPanel.setPreferredSize(new Dimension(controlPanel.WIDTH - 10, 50));
		dominantColorPanel.setMaximumSize(new Dimension(50, 50));
		dominantColorPanel.setBackground(Color.GRAY);
		
		JComboBox mappingBox = new JComboBox(mappings);
		mappingBox.setMaximumSize(new Dimension(controlPanel.WIDTH - 10, 10));
		
		controlPanel.add(dominantColorLabel);
		controlPanel.add(dominantColorPanel);
		controlPanel.add(mappingBox);
		
		//imagePanel.setBackground(Color.DARK_GRAY);
		//controlPanel.setBackground(Color.GRAY);
		add(imagePanel);
		add(controlPanel);
		
		setSize(imagePanel.WIDTH + 200, imagePanel.HEIGHT);
		setVisible(true);
		
		pack();
	}

}
