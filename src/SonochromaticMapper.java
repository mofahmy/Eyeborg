public class SonochromaticMapper {
	
	public static final float minFrequency = (float) 363.797; // Slightly below F#4
	public static final float maxFrequency = (float) 717.591; // Slightly below F#5
	
	// Value to increment frequency for every degree we go up in the color wheel
	public static float increment = (maxFrequency - minFrequency) / ((float) 360); 
	
	public static double getFrequencyFromHue(float h) {
		double frequency = minFrequency + (h * increment);
		return frequency;
	}
	
}
