package problem1.business_logic;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TextDemoTest {

	private TextDemo tekstDemo;

	@Before
	public void setUp() throws Exception {
		tekstDemo = new TextDemo();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void method_readText() {
		String ucitaniTekst;
		try {
			upisiTekst("tekst.txt", "Ovo je neki tekst koji se nalazi u fajlu. Ovaj tekst treba ucitati i ispisati na ekranu.\n");
			ucitaniTekst = tekstDemo.readText("tekst.txt");
			String ocekivaniTekst = "Ovo je neki tekst koji se nalazi u fajlu. Ovaj tekst treba ucitati i ispisati na ekranu.\n";
			assertEquals("The text read is not the same as the file content", ocekivaniTekst, ucitaniTekst);
			
			// delete the file
			File file = new File("tekst.txt");
			file.delete();
		} catch (IOException e) {
			fail("Error reading contents of the file tekst.txt");
		}
	}
	
	@Test
	public void method_writeText() {
		String testTekst = "Ovo je neki tekst koji treba upisati u fajl.\n";
		try {
			tekstDemo.writeText("tekst2.txt", testTekst);
			String ucitaniTekst = ucitajTekst("tekst2.txt");
			assertEquals("The file content is not the same as the text passsed as the method argument", testTekst, ucitaniTekst);	
			
			// delete the file
			File file = new File("tekst2.txt");
			file.delete();			
		} catch (IOException e) {
			fail("Error writing to the file tekst2.txt");
		}
	}	
	
	private String ucitajTekst(String nazivFajla) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(nazivFajla));
		boolean kraj = false;
		String tekst = "";
		while (!kraj) {
			String pom = in.readLine();
			if (pom == null)
				kraj = true;
			else
				tekst = tekst + pom + "\n";
		}
		in.close();
		return tekst;
	}

	private void upisiTekst(String nazivFajla, String tekst) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(nazivFajla));
		out.write(tekst);
		out.close();
	}

}