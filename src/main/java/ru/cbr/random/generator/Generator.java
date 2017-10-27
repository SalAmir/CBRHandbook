package ru.cbr.random.generator;

import java.util.Random;

public class Generator {
	
	private static String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGRHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-=.,/';:?><~*/-+";
	
	public static String getRandomString(int min, int max) {
	    Random random = new Random();
	    int length = random.nextInt(max - min + 1) + min;
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < length; i++) {
	        sb.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
	    }
	    return sb.toString();
	}
	
	public static String getRandomString(int max) {
		allowedChars = "0123456789";
	    Random random = new Random();
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < max; i++) {
	        sb.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
	    }
	    return sb.toString();
	}
}
