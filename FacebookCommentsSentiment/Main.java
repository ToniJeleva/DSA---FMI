package naivebayes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import facebook4j.FacebookException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Parser parser = new Parser();

		File file = new File("C:\\Users\\4525s\\Desktop\\bd project\\training1.csv");
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		    String line;
		    while ((line = br.readLine()) != null) {
		    	String[] temp = line.replace(".", "").replace("\"", "").split(",");
		    	if(temp[0].equals("0")){
		    		parser.parseForLearning(temp[5], "negative");
		    	}else if (temp[0].equals("2")){
		    		parser.parseForLearning(temp[5], "neutral");
		    	}else{
		    		parser.parseForLearning(temp[5], "positive");
		    	}
		    }
		    
		    FacebookIntegration facebook = new FacebookIntegration(parser);
		    try {
				facebook.evaluateFacebookPostes();
			} catch (FacebookException e) {
				e.printStackTrace();
			}
		  
		
	}
}
