import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ImageLabel extends JLabel implements MouseListener, MouseMotionListener  {
	
	private BufferedImage img;
	
	public ImageLabel(String pathToImage) {
		img = loadImage("src/schoolOfAthens.jpg");
		ImageIcon icon = new ImageIcon(img);
		
		this.setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
		this.setIcon(icon);
		addMouseListener(this);
		addMouseMotionListener(this);
		
	}
	
	private BufferedImage loadImage(String pathToImage) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(pathToImage));
		} catch (IOException e) {
		}
		
		return img;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		 System.out.println("Mouse dragged (" + e.getX() + ',' + e.getY() + ')');
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("Mouse moved (" + e.getX() + ',' + e.getY() + ')');
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicked (" + e.getX() + ',' + e.getY() + ')');
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Mouse Released (" + e.getX() + ',' + e.getY() + ')');
	}
}
