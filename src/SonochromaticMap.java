import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class SonochromaticMap {

	public String name;
	public HashMap<Color, String> map;
	
	public SonochromaticMap(String filename) {
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(fis);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.println("File line: " + line);
		}
	}
	
}
