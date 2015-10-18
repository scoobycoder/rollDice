package rollDice;

import java.util.ArrayList;

public class Player {

	public Object roll(ArrayList<Dice> allTheDice) {
		int rollValue = 0;
		for(Dice dice : allTheDice) {
			rollValue += dice.roll();
		}
		return rollValue;
	}

}
