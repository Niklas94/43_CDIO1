package egetkode;

import java.util.Scanner;

public class Player {

	//Variabler
	private String name; //Instans variabel
	private int points; //Instans variabel
	private static int number; //Klasse variabel
	private static boolean win; //Klasse variabel

	//Konstruktør
	/* 
	 * Constructor
	 * 
	 * */
	public Player(String n) {

		number++;

		if (n.length() < 15) {
			name = n;
			System.out.println("Name is: " + name);
		}
		else {
			name = ("Player " + number);
			System.out.println("Invalid name." + System.lineSeparator() + "Setting player name to: Player " + number);
		}
		points = 0;
	}

	public int getPoints() {
		return points;
	}

	//setter for den enkelte spiller
	public void setPoints(int a) {

		if (a > 0 && a < 40) {
			points = a;
		} 
		else
			points = 0;
	}

	public void updatePoints(Dicecup cup) {

		points += cup.getSum();
	}

	public void useDicecup(Dicecup a, boolean b) throws InterruptedException { //Spiller slår med raffelbæger.

		win = b;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println(this.getName() + ", press enter to roll with the dices.");
		keyboard.nextLine();
		
		do {
			a.rollDices();
			if (a.equal() && a.getDice1().getValue() == 1) {
				System.out.println(this.getName() + " rolled " + a.getDice1().getValue() + " and " + a.getDice2().getValue() + " for a total of: " + a.getSum());
				//Thread.sleep(800);
				this.setPoints(0);
				System.out.println(this.getName() + "'s points equal: " + this.getPoints());
				//Thread.sleep(800);
				System.out.println("");
				break;
			}
			else {
				if (this.getPoints() > 39 && a.equal()) {
					win = true;
					System.out.println(this.getName() + " rolled " + a.getDice1().getValue() + " and " + a.getDice2().getValue() + " for a total of: " + a.getSum());
					//Thread.sleep(800);
					System.out.println(this.getName() + "'s points equal: " + this.getPoints());
					//Thread.sleep(800);
					System.out.println("");
					System.out.println(this.getName() + " has won with " + this.getPoints() + " points.");
					break;
				}
				this.updatePoints(a);
			}
			System.out.println(this.getName() + " rolled " + a.getDice1().getValue() + " and " + a.getDice2().getValue() + " for a total of: " + a.getSum());
			//Thread.sleep(800);
			System.out.println(this.getName() + "'s points equal: " + this.getPoints());
			//Thread.sleep(800);
			System.out.println("");
		} while(a.equal());
	}

	public static boolean findWinner() {
		return win;
	}
	
	public static void setWinner(boolean a) {
		win = a;
	}

	public String getName() {
		return name;
	}

	public void setNumber(int a) {
		number = a;
	}

	public int getNumber() {
		return number;
	}
}
