package com.topcoder.room380.srm334.div2_500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnightTour {
	String valid = "Valid";
	String inValid = "inValid";
	List<String> chessPiece = new ArrayList<>(Arrays.asList(
			"A1", "A2", "A3", "A4", "A5", "A6",
			"B1", "B2", "B3", "B4", "B5", "B6",
			"C1", "C2", "C3", "C4", "C5", "C6",
			"D1", "D2", "D3", "D4", "D5", "D6",
			"E1", "E2", "E3", "E4", "E5", "E6",
			"F1", "F2", "F3", "F4", "F5", "F6"));

	public String checkTour(String[] cells) throws InterruptedException {
		String result = null;
		if (!checkCorrectMove(cells[cells.length - 1], cells[0])) {
			result = inValid;
			return result;
		}
		String firstPosition = cells[0];
		for (int move = 0; move < cells.length; move++) {
			// last move
			if (move == cells.length - 1) {
				String positionFrom = cells[move];
				String positionTo = firstPosition;
				if (checkCorrectMove(positionFrom, positionTo) & removeSquare(positionFrom)) {
					result = valid;
					break;
				} else {
					result = inValid;
					break;
				}
			}
			// all moves
			String positionFrom = cells[move];
			String positionTo = cells[move + 1];
			if (checkCorrectMove(positionFrom, positionTo) & removeSquare(positionFrom)) {
				result = valid;
			} else {
				result = inValid;
				break;
			}
		}
		if (!chessPiece.isEmpty()) {
			result = inValid;
			return result;
		}
		return result;
	}

	private boolean checkCorrectMove(String positionFrom, String positionTo) {
		char stringFrom = positionFrom.substring(0, 1).charAt(0);
		int intFrom = Integer.valueOf(positionFrom.substring(1));
		char stringTo = positionTo.substring(0, 1).charAt(0);
		int intTo = Integer.valueOf(positionTo.substring(1));
		if (stringFrom == stringTo || intFrom == intTo) {
			return false;
		}
		int moveHorizontal = Math.abs(stringFrom - stringTo);
		int moveVertical = Math.abs(intFrom - intTo);
		if (moveHorizontal + moveVertical > 3) {
			return false;
		} else {
			return true;
		}
	}

	private boolean removeSquare(String position) {
		if (!chessPiece.contains(position)) {
			return true;
		}
		chessPiece.remove(position);
		return true;
	}
}