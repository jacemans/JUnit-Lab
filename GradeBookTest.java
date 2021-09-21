import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	
	GradeBook g1;
	GradeBook g2;

	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g1.addScore(80);
		g1.addScore(85);
		
		g2 = new GradeBook(5);
		g2.addScore(74);
		g2.addScore(90);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(g1.addScore(95));
		assertTrue(g1.addScore(65));
		assertTrue(g1.addScore(60));
		
		assertEquals("80.0 85.0 95.0 65.0 60.0", g1.toString());

		assertTrue(g2.addScore(100));
		assertTrue(g2.addScore(60));
		assertTrue(g2.addScore(70));
		
		assertEquals("74.0 90.0 100.0 60.0 70.0", g2.toString());
	}

	@Test
	void testSum() {
		assertEquals(165, g1.sum());
		assertEquals(164, g2.sum());

		assertTrue(g1.addScore(10));
		assertTrue(g2.addScore(20));

		assertEquals(175, g1.sum());
		assertEquals(184, g2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(80, g1.minimum());
		assertEquals(74, g2.minimum());

		assertTrue(g1.addScore(50));
		assertTrue(g2.addScore(55));

		assertEquals(50, g1.minimum());
		assertEquals(55, g2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(g1.sum() - g1.minimum(), g1.finalScore());
		assertEquals(g2.sum() - g2.minimum(), g2.finalScore());

		assertTrue(g1.addScore(90));
		assertTrue(g2.addScore(95));

		assertEquals(g1.sum() - g1.minimum(), g1.finalScore());
		assertEquals(g2.sum() - g2.minimum(), g2.finalScore());
	}

	@Test
	void testGetScoresSize() {
		assertEquals(2, g1.getScoresSize());
		assertEquals(2, g2.getScoresSize());

		assertTrue(g1.addScore(30));
		assertTrue(g2.addScore(54));
		assertTrue(g2.addScore(32));

		assertEquals(3, g1.getScoresSize());
		assertEquals(4, g2.getScoresSize());
	}

	@Test
	void testToString() {
		assertEquals("80.0 85.0", g1.toString());
		assertEquals("74.0 90.0", g2.toString());
		
		assertTrue(g1.addScore(45));
		assertTrue(g2.addScore(40));
		
		assertEquals("80.0 85.0 45.0", g1.toString());
		assertEquals("74.0 90.0 40.0", g2.toString());
	}

}
