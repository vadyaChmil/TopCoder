package com.topcoder.room379.srm334.div1_500;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ExtendedHappyNumbers {

	long[] valueInDegree;

	public long calcTheSum(int A, int B, int K) {
		long happiness = 0;
		Set<Integer> raises = new TreeSet<>();
		valueInDegree = countValueInDegree(K);

		for (int integer = A; integer <= B; integer++) {
			int raise = integer;
			raises.add(raise);
			while (true) {
				raise = raiseInteger(raise);
				if (!raises.add(raise)) {
					Iterator<Integer> iterator = raises.iterator();
					happiness += iterator.next();
					raises.clear();
					break;
				}
			}
		}
		return happiness;
	}

	private long[] countValueInDegree(int K) {
		long[] valueInDegree = new long[10];
		for (int index = 0; index < valueInDegree.length; index++) {
			valueInDegree[index] = (int) Math.pow(index, K);
		}
		return valueInDegree;
	}

	private int raiseInteger(int raise) {
		int result = 0;
		while (true) {
			if (raise < 10) {
				result += valueInDegree[raise];
				break;
			}
			int index = raise % 10;
			if (index != 0) {
				result += valueInDegree[index];
			}
			raise = raise / 10;
		}
		return result;
	}
}