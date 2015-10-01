package com.topcoder.room380.srm334.div2_250;

import java.util.Arrays;

public class SupermarketDiscount {

	public int minAmount(int[] goods) {
		Arrays.sort(goods);
		int totalMoney = totalMoney(goods);

		if (totalMoney < 50) {
			return totalMoney;
		} else if (totalMoney < 100) {
			return totalMoney - 10;
		} else {
			if (goods[1] > 50) {
				return totalMoney - 30;
			} else if (goods[2] > 50) {
				return totalMoney - 20;
			} else {
				return totalMoney - 10;
			}
		}
	}

	private int totalMoney(int[] goods) {
		int totalMoney = 0;
		for (int good : goods) {
			totalMoney += good;
		}
		return totalMoney;
	}
}