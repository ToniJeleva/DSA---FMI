package naivebayes;

import java.util.HashMap;
/* 
 * My version of Naive Bayes algorithm for sentiment analysis. 
 * */

public class NaiveBayes {
	
	private HashMap<String, Integer> categoryCount;
	private HashMap<String, WordCounter> wordMatcher;
	
	public NaiveBayes(){
		categoryCount = new HashMap<String, Integer>();
		categoryCount.put("positive", 1);
		categoryCount.put("negative", 1);
		categoryCount.put("neutral", 1);
		wordMatcher = new HashMap<String, WordCounter>();
	}
	
	public void learn(String [] words, String category){
		int currentCategoryCount = categoryCount.get(category);
		categoryCount.put(category, ++currentCategoryCount);
		
		WordCounter currentWordCounter;
		int temp;
		for (String word : words) {
			if (wordMatcher.containsKey(word)) {
				currentWordCounter=wordMatcher.get(word);
				temp=currentWordCounter.getCountByCategory(category);
				currentWordCounter.setCountByCategory(category,++temp);
				wordMatcher.put(word,currentWordCounter);

			}else{
				wordMatcher.put(word, new WordCounter(word, category));
			}
		}
	}
	
	public String test(String[] words){
		double positiveProbability=1;
		double negativeProbability=1;
		double neutralProbability=1;
		
		for(String word : words){
			if(wordMatcher.containsKey(word)){
			positiveProbability*=(double)wordMatcher.get(word).getCountByCategory("positive")/(double)categoryCount.get("positive");
			negativeProbability*=(double)wordMatcher.get(word).getCountByCategory("negative")/(double)categoryCount.get("negative");
			neutralProbability*=(double)wordMatcher.get(word).getCountByCategory("neutral")/(double)categoryCount.get("neutral");
			}
		}
		
		//System.out.println("Positive probability is: "+positiveProbability);
		//System.out.println("Negative probability is: "+negativeProbability);
		//System.out.println("Neutral probability is: "+neutralProbability);
		
		if (positiveProbability>negativeProbability && positiveProbability>neutralProbability){
			
			return "positive";
		}else if(negativeProbability>positiveProbability && negativeProbability>neutralProbability){
			
			return "negative";
		}else if (neutralProbability>positiveProbability && neutralProbability>negativeProbability){
			
			return "neutral";
		}
	
		return "empty";
		
	}

}
