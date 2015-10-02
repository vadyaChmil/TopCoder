package com.topcoder.room376.srm332.div2_250;

public class TextStatistics {

	public double averageLength(String text) {
		String[] words = text.split(" ");
		int totalCharacter = 0;
		for (String word : words) {
			for (char character : word.toCharArray()) {
				if (character >= 'A' & character <= 'Z' || character >= 'a' & character <= 'z') {
					totalCharacter++;
				}
			}
		}
		return totalCharacter / words.length;
	}
	
}
