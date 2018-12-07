package problem1.business_logic;

import java.io.*;

public class TextDemo {

	public String readText(String fileName) throws IOException {

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

	}

	public void writeText(String fileName, String text) throws IOException {

		PrintWriter out = new PrintWriter(new FileWriter(fileName));
		out.write(text);
		out.close();
	}
}