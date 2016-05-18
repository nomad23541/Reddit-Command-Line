package com.chrisreading.cmdreddit.view;

import java.util.Scanner;

import com.chrisreading.cmdreddit.Main;

/**
 * Abstract view class for all views
 */
public abstract class View {

	/** Scanner to use */
	protected Scanner scanner;
	
	/** Reference to the main class */
	protected Main main;
	
	public View(Main main) {
		this.main = main;
		this.scanner = main.getScanner();
	}
	
	/**
	 * Set the main class
	 * @param main
	 */
	public void setMain(Main main) {
		this.main = main;
	}
}
