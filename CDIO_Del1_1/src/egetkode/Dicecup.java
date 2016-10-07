package egetkode;

import egetkode.Dice;

public class Dicecup {
	
	private Dice Dice1 = new Dice(0);
	private Dice Dice2 = new Dice(0);
	private int sum;
	
	public Dicecup() {
		Dice1.setValue(1);
		Dice2.setValue(1);
	}
	
	public Dice getDice1() {
		return Dice1;
	}
	
	public Dice getDice2() {
		return Dice2;
	}
	
	public void rollDices() {		
		Dice1.rollDice();
		Dice2.rollDice();
		sum = Dice1.getValue() + Dice2.getValue();
	}
	
	public boolean equal() {
		
		if (Dice1.getValue() == Dice2.getValue())
			return true;
		else
			return false;
	}
	
	public int getSum() {
		return sum;
	}
}
