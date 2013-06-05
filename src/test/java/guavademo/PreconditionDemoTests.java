package guavademo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class PreconditionDemoTests {
	
	private PreconditionDemo demo;
	
	@Before
	public void setUp() {
		demo = new PreconditionDemo();
	}

	@Test(expected = NullPointerException.class)
	public void testAddNullScoreJava() {
		demo.addScoreOldJavaWay(null);
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddNullScoreGuava() {
		demo.addScore(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddNegativeScoreJava() {
		demo.addScoreOldJavaWay(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddNegativeScoreGuava() {
		demo.addScore(-1);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testHighestOfNoScoresFailes() {
		demo.getHighestScore();
	}
	
	@Test
	public void testHighestScores() {
		try {
			demo.getHighestScore();
			fail("No IllegalStateException was thrown!");
		} catch (IllegalStateException e) {
			assertEquals("No scores are entered", e.getMessage());
		}
		
		try {
			demo.addScore(12);
			fail("No IllegalArgumentException!");
		} catch(IllegalArgumentException e) {
			assertEquals("Score must be between 0 and 10", e.getMessage());
		}
		demo.addScore(5);
		demo.addScore(7);
		assertEquals(7, demo.getHighestScore().intValue());
	}

}
