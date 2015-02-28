import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class SonochromaticMap {

	public String name;
	public HashMap<Color, String> map;
	
	public SonochromaticMap(String filename) {
		map = new HashMap<Color, String> ();
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(fis);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] values = line.split(",");
			
			int r = Integer.parseInt(values[0]);
			int g = Integer.parseInt(values[1]);
			int b = Integer.parseInt(values[2]);
			Color c = new Color(r,g,b);
			String note = values[3];
			
			map.put(c, note);
		}
	}
	
	
	
}
