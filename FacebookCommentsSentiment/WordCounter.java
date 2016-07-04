package naivebayes;
/*
 * How many times a given word is mentioned in a sentence with positive, negative or neutral sentiment. 
 * */
public class WordCounter {
	private String name;
	private int positiveCount=1;
	private int negativeCount=1;
	private int neutralCount=1;
	
	public WordCounter(String word, String category){
		name=word;
		setCountByCategory(category, 2);
	}

	public int getCountByCategory(String category){
		if (category.equals("positive")){
			return positiveCount;
		}else if (category.equals("negative")){
			return negativeCount;
		}else{
			return neutralCount;
		}
	}
	
	public void setCountByCategory(String category, int count){
		if (category.equals("positive")){
			positiveCount=count;
		}else if (category.equals("negative")){
			negativeCount=count;
		}else{
			neutralCount=count;
		}
	}
}
