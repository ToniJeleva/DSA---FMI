package naivebayes;

import java.security.acl.Group;

import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Photo;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;


public class FacebookIntegration {
	
	private Facebook facebook;
	private Parser parser;
	
	public FacebookIntegration(Parser parser){
		this.parser=parser;
		facebook = new FacebookFactory().getInstance();
		facebook.setOAuthAppId("", "");
		String accessTokenString = "EAACEdEose0cBAFWkajR9TfGXJCp3pIcdvKDBfFvZBpy3YVnwIxAL4u5dvo8SNr0Fr2MrvZAVBJhGI2z5hA5OeaelZBRZAd5WuR49RHZBl5YzKZAjbdHSvIhs83mlBFlfMaDxrB6hwtAZAov6pRKrKlMkaffvSTbtJVze7zQi35GWQZDZD";
		AccessToken at = new AccessToken(accessTokenString);
		facebook.setOAuthAccessToken(at);
	}
	
	public void evaluateFacebookPostes() throws FacebookException { // Get user's posts 
		ResponseList<Post> results = facebook.getPosts(); 
		
		for(Post post : results){
			PagableList<Comment> comments = post.getComments();
			int positivePostCount=0;
			int negativePostCount=0;
			int neutralPostCount=0;
			
			for (Comment comment : comments) {
				String commentMessage=comment.getMessage();
				String result=parser.parseForTesting(commentMessage);
				if(result.equals("positive")){
					positivePostCount++;
				}else if(result.equals("negative")){
					negativePostCount++;
				}else{
					neutralPostCount++;
				}
			}
			
			System.out.printf("The Post %s has %d positive comments, %d negative comments, %d neutral comments.%n", post.getName(), positivePostCount, negativePostCount, neutralPostCount);
		}
		 
	}
	

}
