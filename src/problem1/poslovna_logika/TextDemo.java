package problem1.poslovna_logika;

import java.io.*;

public class TextDemo {
	
	public String readText(String fileName) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			boolean end = false;
			String text = "";
			while (!end) {
				String pom = in.readLine();
				if (pom == null)
					end = true;
				else
					text = text + pom + "\n";
			}
			in.close();
			return text;
		} catch (Exception e) {
			return null;
		}
	}

	public void writeText(String fileName, String text) {
		try {
			PrintWriter out = new PrintWriter(new FileWriter(fileName));
			out.write(text);
			out.close();
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
}