package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader console = new BufferedReader(new InputStreamReader(
				System.in));
		FrontBookkeeper61778 bkeeper = new FrontBookkeeper61778();
		String text = "";
		while (!text.equals("exit")) {
			try {
				text = console.readLine();
				bkeeper.updateFront(text);
				System.err.println(bkeeper.updateFront(text));
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
