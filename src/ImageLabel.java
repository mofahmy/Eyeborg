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

import org.jfugue.MicrotoneNotation;
import org.jfugue.Pattern;
import org.jfugue.Player;


public class ImageLabel extends JLabel implements MouseListener, MouseMotionListener  {
	
	private BufferedImage img;
	private BufferedImage subImg;
	private SonochromaticPlayer player;
	private EyeborgGUI parent;
	
	public int currentMouseX;
	public int currentMouseY;
	
	public ImageLabel(String pathToImage, EyeborgGUI parent) {
		this.parent = parent;
		
		img = loadImage("resource/schoolOfAthens.jpg");
		ImageIcon icon = new ImageIcon(img);
		this.setIcon(icon);
		this.setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		initializeSoundPlayer();
	}
	
	private void initializeSoundPlayer() {
		player = new SonochromaticPlayer();
	}
	
	private BufferedImage loadImage(String pathToImage) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(pathToImage));
		} catch (IOException e) {
		}
		
		return img;
	}
	
	public BufferedImage getCurrentSubImage() {
		return subImg;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		 //System.out.println("Mouse dragged (" + e.getX() + ',' + e.getY() + ')');
		 
		 /*int x = Math.max(e.getX() - 5, 0);
		 int y = Math.max(e.getY() - 5, 0);
		 
		 int w = (x + 5) < img.getWidth() ? 5 : img.getWidth() - x;
		 int h = (y + 5) < img.getHeight() ? 5 : img.getHeight() - x;
		 
		 subImg = img.getSubimage(x, y, w, h);
		 ColorDetector.getDominantColor(subImg);*/
		currentMouseX = e.getX();
		currentMouseY = e.getY();
		
		int pixel = img.getRGB(e.getX(), e.getY());
		int[] rgb = ColorDetector.getRGB(pixel);
		int hue = ColorDetector.getHue(pixel);
		double frequency = player.getHueFrequency(hue);
		
		System.out.println(rgb[0]);
		
		parent.updateInfo(rgb[0], rgb[1], rgb[2], frequency);
		player.play(hue);
		
		//System.out.println("Mouse dragged (" + e.getX() + ',' + e.getY() + ')');
		System.out.println("Hue: " + hue);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		currentMouseX = e.getX();
		currentMouseY = e.getY();
		//System.out.println("Mouse moved (" + e.getX() + ',' + e.getY() + ')');
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
