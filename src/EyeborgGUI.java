import javax.swing.*;

import java.awt.*;

public class EyeborgGUI extends JFrame {
	
	private JPanel imagePanel;
	private JPanel infoPanel;
	private JLabel infoLabel;
	
	public EyeborgGUI() {
		createGUI();
	}
	
	private void createGUI() {
		setTitle("Eyeborg");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		imagePanel = new JPanel(); // Will hold the primary image
		infoPanel = createInfoPanel();
		
		imagePanel.setPreferredSize(new Dimension(1100,700));
		imagePanel.setLayout(new FlowLayout());
		imagePanel.add(new ImageLabel(this, "resource/SchoolOfAthens.jpg"));
		
		add(imagePanel, BorderLayout.CENTER);
		add(infoPanel, BorderLayout.PAGE_END);
		
		setSize(imagePanel.WIDTH, imagePanel.HEIGHT + 200);
		setVisible(true);
		
		pack();
	}
	
	
	private JPanel createInfoPanel() {
		JPanel infoPanel = new JPanel();
		
		String info = String.format("Click and drag your mouse along the image to hear its colors.");
		infoLabel = new JLabel(info);
		
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setVerticalAlignment(SwingConstants.CENTER);
		
		infoPanel.add(infoLabel);
		
		return infoPanel;
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
	
	public void updateInfo(int r, int g, int b, double frequency) {
		Color bgColor = new Color(r,g,b);
		Color textColor;
		
		int threshold = 170;
		if(r < threshold && g < threshold && b < threshold) {
			  textColor = Color.WHITE;
		} else {
			  textColor = Color.BLACK;
		}
		
		infoPanel.setBackground(bgColor);
		infoLabel.setForeground(textColor);
		
		String newInfo = String.format("Red: %03d Green: %03d Blue: %03d %5s Frequency: %03.3f Hz", r, g, b, " ", frequency);
		infoLabel.setText(newInfo);
	}
	

}
