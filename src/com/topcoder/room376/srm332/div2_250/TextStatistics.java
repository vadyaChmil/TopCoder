package com.topcoder.room376.srm332.div2_250;

public class TextStatistics {

	public double averageLength(String text) {
		int characters = 0;
		int words = 0;
		boolean isChar = false;
		for (char character : text.toCharArray()) {
			if (character >= 'A' & character <= 'Z' || character >= 'a' & character <= 'z') {
				characters++;
				isChar = true;
			} else if (isChar) {
				isChar = false;
				words++;
			}
		}
		if (characters == 0) {
			return 0.0;
		}
		if (characters == text.length() || isChar == true) {
			words++;
		}
		return characters / (double) words;
	}

}