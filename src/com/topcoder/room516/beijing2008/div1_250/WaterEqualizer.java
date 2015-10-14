package com.topcoder.room516.beijing2008.div1_250;

public class WaterEqualizer {

	public double minTime(int[] waterVolumes) {
		double allConsist = 0;
		for (int waterVolum : waterVolumes) {
			allConsist += waterVolum;
		}
		double averageConsist = allConsist / waterVolumes.length;

		double displacedWater = 0;
		for (int waterVolum : waterVolumes) {
			displacedWater += Math.abs(averageConsist - waterVolum);
		}
		return displacedWater / 2.0;
	}
}
