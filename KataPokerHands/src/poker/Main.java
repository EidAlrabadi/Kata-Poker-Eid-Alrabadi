package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	Card c = new Card();
	PokerHands Pk = new PokerHands();
	Scanner in = new Scanner(System.in);
	System.out.print("Please input the two hands: ");
	String userInput = in.nextLine();
	ArrayList<Card> cards = c.generateCards(userInput);
	ArrayList<Card> firstHand = new ArrayList<>(Arrays.asList(cards.get(0),cards.get(1),cards.get(2),cards.get(3),cards.get(4)));
	ArrayList<Card> secondHand = new ArrayList<>(Arrays.asList(cards.get(5),cards.get(6),cards.get(7),cards.get(8),cards.get(9)));
	System.out.println(Pk.playPoker(firstHand,secondHand));
	in.close();
	
	
	
   
	
	

	
	
	
	}

}
