package com.topcoder.room380.srm334.div2_500;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		String[] cells =
			{"A1", "B3", "A5", "C6", "E5", "F3",
			"D2", "F1", "E3", "F5", "D4", "B5",
			"A3", "B1", "C3", "A2", "C1", "E2",
			"F4", "E6", "C5", "A6", "B4", "D5",
			"F6", "E4", "D6", "C4", "B6", "A4",
			"B2", "D1", "F2", "D3", "E1", "C2"};
		System.out.println(new KnightTour().checkTour(cells));
	}

}
