package problem1.business_logic;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TextDemoTest {

	private TextDemo textDemo;

	@Before
	public void setUp() throws Exception {
		textDemo = new TextDemo();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void metoda_ucitajTekst() throws IOException {
		try {
			String readText = textDemo.readText("text.txt");
			String expectedText = "This is some text in a file. This text should be read and displayed on the screen.\n";
			assertEquals("Nije ucitan ocekivani tekst", expectedText, readText);
		} catch (IOException e) {
			fail("Error while reading from file text.txt");
		}
	}

	@Test
	public void metoda_upisiTekst() throws IOException {
		try {
			String testText = "This is some text that should be written into a file.\n";
			textDemo.writeText("text2.txt", testText);
			String readTekst = textDemo.readText("text2.txt");
			assertEquals("Nije upisan ocekivani tekst", testText, readTekst);
		} catch (IOException e) {
			fail("Error while writing to file text2.txt");
		}
	}

}