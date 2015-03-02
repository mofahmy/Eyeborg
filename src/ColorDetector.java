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
				
				int[] rgb = getRGB(pixel);
				
			    //System.out.println("Pixel (" + x + "," + y + ") - Color: " + c.toString());
			}
		}
		
		return dominant;
	}
	
	public static int getHue(int pixel) {
		int[] rgb = getRGB(pixel);
		Color c = new Color(rgb[0], rgb[1], rgb[2]);
		int hue = (int) ((getHSB(c))[0] * 360);
		return hue;
	}
	
	// Extract red, green, blue values from TYPE_INT_ARGB pixel
	public static int[] getRGB(int pixel) {
		int r = (pixel >> 16) & 0xff;
	    int g = (pixel >> 8) & 0xff;
	    int b = (pixel) & 0xff;
	    
	    int[] rgb = { r, g, b};
	    return rgb;
	}
	
	// Given an array containing color RGB information, return the color's HSB information
	private static double[] getHSB(Color c) {
		float[] hsb_float = Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), null);
		double[] hsb = { (double) hsb_float[0], (double) hsb_float[1], (double) hsb_float[2] };
		//System.out.println("Calculated hue: " + hsb[0]);
		return hsb;
	}
}
