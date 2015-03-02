import java.awt.Color;

import org.jfugue.MicrotoneNotation;
import org.jfugue.Player;

public class SonochromaticPlayer {
	
	public static final float minFrequency = (float) 363.797; // Slightly below F#4
	public static final float maxFrequency = (float) 717.591; // Slightly below F#5
	
	// Value to increment frequency for every degree we go up in the color wheel
	private static final float increment = (maxFrequency - minFrequency) / ((float) 360); 
	
	private MicrotoneNotation microtoneMap;
	private Player player;
	
	private double[] map; // Map of color hue to audio frequency
	
	public SonochromaticPlayer() {
		player = new Player();
		
		microtoneMap = new MicrotoneNotation();
		for (int hue = 0; hue < 360; hue++) {
			double frequency = minFrequency + (hue * increment);
			microtoneMap.put("M" + Integer.toString(hue), frequency);
			System.out.println("Addint microtone - Hue: " + hue + " Frequency: " + frequency);
		}
	}
	
	// Play the frequency associated with a particular hue
	public void play(int hue) {
		//player.play(microtoneMap.getMusicString("M" + Integer.toString(hue)));
		player.play("I[Warm] " + microtoneMap.getMusicString("M" + Integer.toString(hue))); // Warm, Crystal
		//player.play("I[Rock_Organ] Db4minHa64d64");
	}
	
	public double getHueFrequency(int hue) {
		double frequency = minFrequency + (hue * increment);
		return frequency;
	}
	
	
}
