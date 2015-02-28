import java.awt.Color;
import java.awt.image.BufferedImage;


public class ColorDetector {

	public static Color getDominantColor(BufferedImage img) {
		Color dominant = Color.BLACK;
		
		int width = img.getWidth();
		int height = img.getHeight();
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				
				// Retrieves RGBA color components of a pixel as a TYPE_INT_ARGB
				int pixel = img.getRGB(x, y);
				
				// Extract red, green, blue values from TYPE_INT_ARGB pixel
				int r = (pixel >> 16) & 0xff;
			    int g = (pixel >> 8) & 0xff;
			    int b = (pixel) & 0xff;
			    
			    Color c = new Color(r,g,b);
			    System.out.println("Pixel (" + x + "," + y + ") - Color: " + c.toString());
			}
		}
		
		return dominant;
	}
}
