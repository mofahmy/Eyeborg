import javax.swing.*;

import java.awt.*;

public class JEyeborgGUI extends JFrame {
	
	private JPanel imagePanel;
	private JPanel infoPanel;
	private JLabel infoLabel;
	
	public JEyeborgGUI() {
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
		imagePanel.add(new ImageLabel(this, "resource/schoolOfAthens.jpg"));
		
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
