import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import egetkode.Dicecup;
import egetkode.Player;

public class testuseDicecup {

	Player testPlayer;
	Dicecup cup;

	@Before
	public void setUp() throws Exception {
		testPlayer = new Player("Sammy");
		cup = new Dicecup();
	}

	@After
	public void tearDown() throws Exception {
		cup = null;
	}

	@Test
	public void testDices() {

		int sum2 = 0, sum3 = 0, sum3 = 0, sum4 = 0, sum5 = 0, sum6 = 0, sum7 = 0, sum8 = 0, sum9 = 0, sum10 = 0, sum11 = 0, sum12 = 0;
		int pair1 = 0, pair2 = 0, pair3 = 0, pair4 = 0, pair5 = 0, pair6 = 0;

		for (int i = 0; i < 10000; i++)
		{
			cup.rollDices(); //Roll dices
			int sum = cup.getSum(); //Get sum from cup.
			int roll1 = cup.getDice1().getValue(); //Value of Dice1
			int roll2 = cup.getDice2().getValue(); //Value of Dice2

			if (sum == 2) {
				sum2++;
				pair1++;
			}
			if (sum == 12) {
				sum12++;
				pair6++;
			}
			if (sum == 3)
				sum3++;
			if (sum == 11)
				sum11++;
			if (sum==10) {
				if (roll1 == 5)
					pair5++;
				sum10++;
			}
			if (sum == 4) {
				if (roll1 == 2)
					pair2++;
				sum4++;
			}
			if (sum == 9)
				sum9++;
			if (sum == 5)
				sum5++;
			if (sum == 8) {
				if (roll1 == 4)
					pair4++;
				sum8++;
			}
			if (sum == 6) {
				if (roll1 == 3)
					pair3++;
				sum6++;
			}
			if (sum == 7)
				sum7++;

		}
		assertEquals(277, sum2, 400);
		assertEquals(555, sum3, 400);
		assertEquals(833, sum4, 400);
		assertEquals(1111, sum5, 400);
		assertEquals(1388, sum6, 400);
		assertEquals(1666, sum7, 400);
		assertEquals(1388, sum8, 400);
		assertEquals(1111, sum9, 400);
		assertEquals(833, sum10, 400);
		assertEquals(555, sum11, 400);
		assertEquals(277, sum12, 400);
		
		//assertEquals(277, pair1, 400);
		assertEquals(10000, pair2, 400);
		assertEquals(10000, pair3, 400);
		assertEquals(10000, pair4, 400);
		assertEquals(10000, pair5, 400);
		//assertEquals(277, pair6, 400);

	}
}
