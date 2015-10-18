package rollDice;

import java.util.ArrayList;

public class Player {
	
	private int modifier;
	private int rollValue;

	public void roll(ArrayList<Dice> allTheDice) {
		for(Dice dice : allTheDice) {
			this.rollValue += dice.roll();
		}
	}

	public int calculateScore() {
		return rollValue += modifier;
	}

	public void addModifier(int modifier) {
		this.modifier = modifier;
	}

}
