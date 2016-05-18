package com.chrisreading.cmdreddit.view;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.chrisreading.cmdreddit.Main;
import com.github.jreddit.entity.User;

/**
 * Presents the login screen to the user
 */
public class LoginView extends View {
	
	/** User to tie to */
	private User user;
	/** If user is now connected */
	private boolean connected = false;
	
	private String username, password;
	
	public LoginView(Main main) {
		super(main);
		
		do {
			System.out.println("Username: ");
			username = scanner.next();
			System.out.println("Password: "); 
			password = scanner.next();
			
			System.out.println("Logging in...");
			
			user = new User(main.getRestClient(), username, password);
			
			try {
				user.connect();
				connected = true;
			} catch (IOException | ParseException e) {
				System.out.println("Error while logging in.");
			}
		} while(!connected);
	}
	
	/**
	 * Returns the user
	 * @return
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * If user is now logged in
	 * @return
	 */
	public boolean isConnected() {
		return connected;
	}

}
