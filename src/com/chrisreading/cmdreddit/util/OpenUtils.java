package com.chrisreading.cmdreddit.util;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Utils for opening 
 */
public class OpenUtils {

	public static void openLink(URL url) {
		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.browse(url.toURI());
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
}
