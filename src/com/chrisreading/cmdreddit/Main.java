package com.chrisreading.cmdreddit;

import java.util.Scanner;

import com.chrisreading.cmdreddit.util.Responses;
import com.chrisreading.cmdreddit.view.FrontPageView;
import com.chrisreading.cmdreddit.view.LoginView;
import com.chrisreading.cmdreddit.view.SubredditView;
import com.github.jreddit.entity.User;
import com.github.jreddit.utils.restclient.HttpRestClient;
import com.github.jreddit.utils.restclient.RestClient;

/**
 * Main class, everything is started here.
 */
public class Main {
	
	/** Scanner to read input */
	private Scanner scanner;
	
	/** Rest client to use to auth */
	private RestClient restClient;
	
	/** User to use (if avaliable) */
	private User user;
	
	public Main() {
		restClient = new HttpRestClient();
		restClient.setUserAgent("Command Line Reddit");
		
		scanner = new Scanner(System.in);
		
		System.out.println("-= Welcome to Command Line Reddit =-\n");
		System.out.println("Would you like to log in?");
		
		if(scanner.next().startsWith(Responses.RESP_POSITIVE)) {
			LoginView loginV = new LoginView(this);
			if(loginV.isConnected()) {
				user = loginV.getUser();
				System.out.println("Welcome " + user.getUsername() + "!\n");
				
				// TODO: add karma grabber
			}
			
			// now show front page view
			FrontPageView fpView = new FrontPageView(this);
		} else {
			// show /r/all
			SubredditView allV = new SubredditView(this, "all");
		}
	}
	
	/**
	 * Gets the user (if avaliable)
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * Gets the rest client being used
	 */
	public RestClient getRestClient() {
		return restClient;
	}
	
	/**
	 * Gets the scanner being used
	 */
	public Scanner getScanner() {
		return scanner;
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
