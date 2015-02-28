import javax.swing.*;

import java.awt.*;

public class EyeborgGUI extends JFrame {
	
	//private String[] mappings = { "Harbisson", "Newton", "Castel", "Field", "Jameson", "Semann", "Rimington", "Bishop", "Helmholtz", "Scriabin", "Klein", "Aeppli", "Belmont", "Zieverink" };
	
	public EyeborgGUI() {
		createGUI();
	}
	
	private void createGUI() {
		setTitle("Eyeborg");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel imagePanel = new JPanel(); // Will hold the primary image
		JPanel infoPanel = createInfoPanel();
		
		imagePanel.setPreferredSize(new Dimension(1100,700));
		imagePanel.setLayout(new FlowLayout());
		imagePanel.add(new ImageLabel("resource/SchoolOfAthens.jpg"));
		
		//infoPanel.setPreferredSize(new Dimension(200, 700));
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.LINE_AXIS));
		
		
		//JComboBox mappingBox = new JComboBox(mappings);
		//mappingBox.setMaximumSize(new Dimension(controlPanel.WIDTH - 10, 10));
		//controlPanel.add(mappingBox);
		
		//imagePanel.setBackground(Color.DARK_GRAY);
		//controlPanel.setBackground(Color.GRAY);
		add(imagePanel, BorderLayout.CENTER);
		add(infoPanel, BorderLayout.PAGE_END);
		
		infoPanel.setBackground(Color.RED);
		setSize(imagePanel.WIDTH, imagePanel.HEIGHT + 200);
		setVisible(true);
		
		pack();
	}
	
	
	private JPanel createInfoPanel() {
		JPanel controlPanel = new JPanel();
		
		controlPanel.setLayout(new BorderLayout());

		JPanel dominantColorPanel = createDominantColorPanel();
		JPanel subImagePanel = createSubImagePanel();
		
		controlPanel.add(dominantColorPanel, BorderLayout.LINE_START);
		controlPanel.add(subImagePanel, BorderLayout.CENTER);
		
		return controlPanel;
	}
	
	// Create dominant color panel and components
	private JPanel createDominantColorPanel() {
		JPanel dominantColorPanel = new JPanel();
		dominantColorPanel.setLayout(new BoxLayout(dominantColorPanel, BoxLayout.PAGE_AXIS));
		
		JLabel dominantColorTitleLabel = new JLabel("Dominant Color");
		JLabel dominantColorLabel = new JLabel();
		
		dominantColorLabel.setBounds(10, 10, 100, 100);
		
		dominantColorLabel.setMinimumSize(new Dimension(100, 100));
		dominantColorLabel.setPreferredSize(new Dimension(100, 100));
		dominantColorLabel.setMaximumSize(new Dimension(100, 100));
		
		dominantColorPanel.add(dominantColorTitleLabel);
		dominantColorPanel.add(dominantColorLabel);
		
		dominantColorPanel.setBackground(Color.GRAY);
		return dominantColorPanel;
	}
	
	private JPanel createSubImagePanel() {
		JPanel subImagePanel = new JPanel();
		subImagePanel.setLayout(new BoxLayout(subImagePanel, BoxLayout.PAGE_AXIS));
		
		JLabel subImageTitleLabel = new JLabel("Subimage");
		JLabel subImageLabel = new JLabel();
		
		subImageLabel.setMinimumSize(new Dimension(100, 100));
		subImageLabel.setPreferredSize(new Dimension(100, 100));
		subImageLabel.setMaximumSize(new Dimension(100, 100));
		
		subImagePanel.add(subImageTitleLabel);
		subImagePanel.add(subImageLabel);
		
		subImagePanel.setBackground(Color.DARK_GRAY);
		return subImagePanel;
	}
	

}
