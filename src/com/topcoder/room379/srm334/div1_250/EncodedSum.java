package com.topcoder.room379.srm334.div1_250;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EncodedSum {

	public long maximumSum(String[] numbers) {
		Map<Character, Integer> mapCharacters = new HashMap<Character, Integer>();
		for (String number : numbers) {
			int size = number.length();
			char[] letters = number.toCharArray();
			for (int index = 0; index < size; index++) {
				if (!mapCharacters.containsKey(letters[index])) {
					mapCharacters.put(letters[index], (int) (Math.pow(10, size - index - 1)));
				} else {
					int temporary = mapCharacters.get(letters[index]) + (int) (Math.pow(10, size - index - 1));
					mapCharacters.put(letters[index], temporary);
				}
			}
		}
		
		List<Character> listCharacters = new ArrayList<>(mapCharacters.keySet());
		Collections.sort(listCharacters, new Comparator<Character>() {
			public int compare(Character element1, Character element2) {
				return mapCharacters.get(element2) - mapCharacters.get(element1);
			}
		});
		
		if (listCharacters.size() == 10) {
			for (int index = 8; index > 0; index--) {
				char endChar = listCharacters.get(9);
				for (String word : numbers) {
					if (endChar == word.charAt(0)) {
						Collections.swap(listCharacters, index, 9);
						break;
					}
				}
			}
		}
		
		Map<Character, Integer> sortedMapCharacters = new LinkedHashMap<Character, Integer>();
		for (int index = 0; index < listCharacters.size(); index++) {
			sortedMapCharacters.put(listCharacters.get(index), 9 - index);
		}

		long maximumSum = 0;
		for (String number : numbers) {
			String temporary = "";
			int size = number.length();
			char[] letters = number.toCharArray();
			for (int index = 0; index < size; index++) {
				temporary += sortedMapCharacters.get(letters[index]);
			}
			number = temporary;
			maximumSum += Long.parseLong(number);
		}
		return maximumSum;
	}
}
