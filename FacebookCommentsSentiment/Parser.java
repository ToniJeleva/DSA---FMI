package naivebayes;

public class Parser {
	
	private NaiveBayes classifier;
	
	public Parser(){
		classifier=new NaiveBayes();
	}
	
	public void parseForLearning(String text, String category){
		String[] divided = text.split(" ");
		classifier.learn(divided, category);
	}
	
	public String parseForTesting(String text){
		String[] divided = text.split(" ");
		return classifier.test(divided);
	}

}
