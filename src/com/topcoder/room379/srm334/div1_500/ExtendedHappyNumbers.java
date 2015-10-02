package com.topcoder.room379.srm334.div1_500;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExtendedHappyNumbers {

	public long calcTheSum(int A, int B, int K) {
		long happiness = 0;
		List<Integer> raises = new ArrayList<>();

		for (int integer = A; integer <= B; integer++) {
			int raise = integer;
			raises.add(raise);
			while (true) {
				raise = raiseInteger(raise, K);
				if (raises.contains(raise)) {
					happiness += smallestNumber(raises);
					raises.clear();
					break;
				}
				raises.add(raise);
			}
		}
		return happiness;
	}

	private int smallestNumber(List<Integer> raises) {
		Collections.sort(raises, new Comparator<Integer>() {
			public int compare(Integer element1, Integer element2) {
				return element1 - element2;
			}
		});
		return raises.get(0);
	}

	private int raiseInteger(int A, int K) {
		int result = 0;
		StringBuilder raiseString = new StringBuilder();
		raiseString.append(A);
		int[] digits = new int[raiseString.length()];
		for (int index = 0; index < digits.length; index++) {
			if (raiseString.charAt(index) == '0') {
				continue;
			}
			int digit = Integer.parseInt(String.valueOf(raiseString.charAt(index)));
			result += Math.pow(digit, K);
		}
		return result;
	}

}
