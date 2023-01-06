package pawtropolis.gdr.game.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class InputController {

	private InputController() {
	}

	public static String readString() {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader inputReader = new BufferedReader(input);
		try {
			return inputReader.readLine();
		} catch (IOException e) {
			System.err.println("Error while reading user input");
			return "";
		}
	}

	public static String readStringWithPrompt(String prompt, boolean newLine) {
		System.out.print(prompt);
		if (newLine) {
			System.out.print("\n");
		}
		return readString();
	}

	public static String readStringWithPrompt(String prompt) {
		return readStringWithPrompt(prompt, false);
	}
}
