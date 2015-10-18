package rollDice;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
		allTheDice.add(dice);
		allTheDice.add(dice);
		underTest.roll(allTheDice);
		
		verify(dice, times(2)).roll();
	}

}
