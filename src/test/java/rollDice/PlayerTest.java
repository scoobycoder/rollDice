package rollDice;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.mockito.Mockito.verify;

public class PlayerTest {

	private ClassPathXmlApplicationContext applicationContext;
	private Player underTest;

	@Mock
	Dice dice;

	@Before
	public void setup() {
		applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		underTest = (Player) applicationContext.getBean("player");
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void playerCanRollDice() {
		underTest.roll(dice);
		verify(dice).roll();
	}

}
