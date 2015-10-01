package com.topcoder.room516.beijing2008.div1_250;

public class WaterEqualizer {

	public double minTime(int[] waterVolumes) {
		long allConsist = 0;
		for (int waterVolum : waterVolumes) {
			allConsist += waterVolum;
		}
		long averageConsist = allConsist / waterVolumes.length;

		long displacedWater = 0;
		for (int waterVolum : waterVolumes) {
			displacedWater += Math.abs(averageConsist - waterVolum);
		}
		return displacedWater / 2.0;
	}
}
