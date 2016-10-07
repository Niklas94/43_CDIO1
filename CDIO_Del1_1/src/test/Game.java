package test;
import java.util.Scanner;

import egetkode.*;

public class Game {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		boolean finish = false; 
		boolean gameOn = true;
		Scanner keyboard = new Scanner(System.in); 
		System.out.println("Dice game" + System.lineSeparator() + "Two players have to roll with 2 dices. The first player to reach 40 points wins the game." + System.lineSeparator() + "Enter Player 1's name:");
		String name1 = keyboard.nextLine();
		System.out.println("Enter Player 2's name:");
		String name2 = keyboard.nextLine();
		Player player1 = new Player(name1);
		Player player2 = new Player(name2);
		Dicecup cup = new Dicecup();
		System.out.println("");

		while (gameOn) {
			while (Player.findWinner() == false) {

				player1.useDicecup(cup, finish);

				if (Player.findWinner() == true)
					break;

				player2.useDicecup(cup, finish);

				if (Player.findWinner() == true)
					break;
			}

			System.out.println("Do you want to play again? (y/n)");
			String again = keyboard.nextLine();
			char n = again.charAt(0);
			if (n != 'n') {
				player1.setPoints(0);
				player2.setPoints(0);
				Player.setWinner(false);
			} 
			else {
				gameOn = false;
				keyboard.close();
				break;
			}
		}
	}
}