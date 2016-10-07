package egetkode;

public class Dice {

	private int value;
	
	//Konstruktør
	public Dice(int a) {
		value = a;
	}
	
	//Getter
	public int getValue() {
		return value;
	}
	
	//Setter
	public void setValue(int a) {
		if (a > 0 && a < 7) {
			value = a;
		}
		else
			value = 1;
	}
	
	//Tilfældig værdi
	public void rollDice() {
		value = (int) (Math.random() * 6) + 1;
	}
}
