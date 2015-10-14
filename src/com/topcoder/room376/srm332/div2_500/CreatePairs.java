package com.topcoder.room376.srm332.div2_500;

import java.util.Arrays;

public class CreatePairs {

	public int maximalSum(int[] data) {
		int[] negativeValues = null;
		int[] positiveValues = data;
		Arrays.sort(data);
		for (int index = data.length - 1; index >= 0; index--) {
			if (data[index] <= 0) {
				negativeValues = new int[index + 1];
				positiveValues = new int[data.length - index - 1];
				System.arraycopy(data, index + 1, positiveValues, 0, positiveValues.length);
				System.arraycopy(data, 0, negativeValues, 0, negativeValues.length);
				break;
			}
		}
		int maximalSum = 0;
		for (int index = positiveValues.length - 1; index >= 0; index--) {
			if (positiveValues[index] == 1) {
				maximalSum += positiveValues[index];
				continue;
			}
			if (index > 0 && positiveValues[index - 1] > 1) {
				maximalSum += positiveValues[index] * positiveValues[index - 1];
				index--;
			} else {
				maximalSum += positiveValues[index];
			}
		}
		if (negativeValues == null) {
			return maximalSum;
		}
		for (int index = 0; index < negativeValues.length; index++) {
			if (index < negativeValues.length - 1) {
				maximalSum += negativeValues[index] * negativeValues[index + 1];
				index++;
			} else {
				maximalSum += negativeValues[index];
			}
		}
		return maximalSum;
	}

}
