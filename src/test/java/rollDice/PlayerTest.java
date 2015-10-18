package rollDice;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PlayerTest {

	private ClassPathXmlApplicationContext applicationContext;
	private Player underTest;

	@Mock
	Dice dice;
	private ArrayList<Dice> allTheDice;

	@Before
	public void setup() {
		applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		underTest = (Player) applicationContext.getBean("player");
		MockitoAnnotations.initMocks(this);
		allTheDice = new ArrayList<Dice>();
	}

	@Test
	public void playerCanRollDice() {
		allTheDice.add(dice);
		underTest.roll(allTheDice);

		verify(dice, times(1)).roll();
	}
	
	@Test
	public void playerCanRollTwoDiceAtOnce() {
		addDiceForRolling(2);
		underTest.roll(allTheDice);
		
		verify(dice, times(2)).roll();
	}
	
	@Test
	public void playerCanSumTheValueOfDiceWhenTheDiceComeUpSnakeEyes() {
		rollDiceWithModifier(2, 0);
		
		assertThat(underTest.calculateScore(), is(2));
	}
	
	@Test
	public void playerCanAddModifierToRoll() {
		rollDiceWithModifier(2, 3);
		
		assertThat(underTest.calculateScore(), is(5));
	}
	
	@Test
	public void playerWillNotAdjustScoreBelowOneWithHighNegativeModifier() {
		rollDiceWithModifier(1, -5);
		
		assertThat(underTest.calculateScore(), is(1));
	}

	private void rollDiceWithModifier(int numberOfDice, int modifier) {
		when(dice.roll()).thenReturn(1);
		addDiceForRolling(numberOfDice);
		underTest.roll(allTheDice);
		underTest.addModifier(modifier);
	}
	
	private void addDiceForRolling(int numberOfDice) {
		for(int i = 0; i < numberOfDice; i++)
			allTheDice.add(dice);
	}

}
