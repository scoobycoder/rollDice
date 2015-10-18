package rollDice;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.mockito.Mockito.when;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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
		when(dice.roll()).thenReturn(6);
		
		assertThat(underTest.roll(dice), is(6));
	}

}
