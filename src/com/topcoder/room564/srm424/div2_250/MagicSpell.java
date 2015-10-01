package com.topcoder.room564.srm424.div2_250;

public class MagicSpell {

	public String fixTheSpell(String spell) {
		String temporary = "";
		char[] charSpell = spell.toCharArray();

		for (int index = 0; index < charSpell.length; index++) {
			char target = charSpell[index];
			if (target == 'A' || target == 'Z') {
				temporary += target;
				charSpell[index] = '_';
			}
		}

		for (int index = 0; index < temporary.length(); index++) {
			for (int i = charSpell.length - 1; i >= 0; i--) {
				if (charSpell[i] == '_') {
					charSpell[i] = temporary.charAt(index);
					break;
				}
			}
		}
		return new String(charSpell);
	}
}