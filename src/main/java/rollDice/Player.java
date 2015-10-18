package rollDice;

import java.util.ArrayList;

public class Player {

	public Object roll(ArrayList<Dice> allTheDice) {
		for(Dice dice : allTheDice) {
			dice.roll();
		}
		return null;
	}

}
