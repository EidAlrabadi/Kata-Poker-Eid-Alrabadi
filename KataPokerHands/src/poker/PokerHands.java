package poker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokerHands extends Card {

	public List<Card> sortCards(List<Card> cards) {
		Collections.sort(cards, new compareCards()); // sorting the cards in ascending order.
		return cards;

	}

	/**
	 * 
	 * @param c1 the first card
	 * @param c2 the second card
	 * 
	 *           This is a method that checks two hands of 5 playing cards, and
	 *           finds the greatest value in each hand.
	 * 
	 * 
	 * @return the high in each hand
	 */
	public Card checkHighCards(ArrayList<Card> list1, ArrayList<Card> list2) {
		
		ArrayList<Card> list1Copy = new ArrayList<Card>(list1);
		ArrayList<Card> list2Copy = new ArrayList<Card>(list2);
		Card num1 = Collections.max(list1Copy, new compareCards()); // finds the max from the first hand
		Card num2 = Collections.max(list2Copy, new compareCards()); // finds the max from the second hand
		

		list1Copy.remove(num1); // removes the card it found
		num1.setHand("Black");
		list2Copy.remove(num2); // removes the card it found
		num2.setHand("White");
		while (num1.getValue() == num2.getValue()) { // if both max values are equal look for the next max.
			if (list1Copy.size() == 0) {
				
				return new Card(0,"H"); // a return of 0 implies a tie.
			}
			num1 = Collections.max(list1Copy, new compareCards()); // finds the max from the first hand
			num2 = Collections.max(list2Copy, new compareCards());
			list1Copy.remove(num1);
			num1.setHand("Black");
			list2Copy.remove(num2);
			num2.setHand("White");
		}

		if (num1.getValue() > num2.getValue()) {
			 
			return num1;

		}
		 

		return num2;

	}

	/**
	 * 
	 * @param list1
	 * @param list2 checks two lists that contain 5 cards, and returns the larger of
	 *              the two 3 of a kind values if it exists.
	 * @return
	 */
	public Card checkFourOfAKind(ArrayList<Card> list1, ArrayList<Card> list2) {

		ArrayList<Card> list1Copy = new ArrayList<Card>(list1);
		ArrayList<Card> list2Copy = new ArrayList<Card>(list2);

		Collections.sort(list1Copy, new compareCards()); // Sort the list
		Collections.sort(list2Copy, new compareCards());
		int firstListValue = 0;
		int secondListValue = 0;

		if (list1Copy.get(0).getValue() == list1Copy.get(1).getValue()
				&& list1Copy.get(0).getValue() == list1Copy.get(2).getValue()
				&& list1Copy.get(0).getValue() == list1Copy.get(3).getValue()) {
			firstListValue = list1Copy.get(0).getValue(); // List is sorted so all values are being compared. We know
															// there
															// are 5 elements,
															// so comparing their values is hard coded.
		}

		else if (list1Copy.get(1).getValue() == list1Copy.get(2).getValue()
				&& list1Copy.get(1).getValue() == list1Copy.get(3).getValue()
				&& list1Copy.get(1).getValue() == list1Copy.get(4).getValue()) {
			firstListValue = list1Copy.get(1).getValue();
		}

		if (list2Copy.get(0).getValue() == list2Copy.get(1).getValue()
				&& list2Copy.get(0).getValue() == list2Copy.get(2).getValue()
				&& list2Copy.get(0).getValue() == list2Copy.get(3).getValue()) {
			secondListValue = list2Copy.get(0).getValue(); // List is sorted so all values are being compared. We know
															// there
															// are 5 elements,
															// so comparing their values is hard coded.
		}

		else if (list2Copy.get(1).getValue() == list2Copy.get(2).getValue()
				&& list2Copy.get(1).getValue() == list2Copy.get(3).getValue()
				&& list2Copy.get(1).getValue() == list2Copy.get(4).getValue()) {
			secondListValue = list2Copy.get(1).getValue();
		}

		if (firstListValue > secondListValue) {
			return new Card(firstListValue,"Black");
		} else if (firstListValue < secondListValue) {
			return new Card(secondListValue,"White");
		}

		return new Card(-1,'H'); // return -1 if 3 of a kind doesn't exist.

	}

	public Card checkStraight(ArrayList<Card> list1, ArrayList<Card> list2) {
		ArrayList<Card> list1Copy = new ArrayList<Card>(list1);
		ArrayList<Card> list2Copy = new ArrayList<Card>(list2);
		int firstValue = 0;
		int secondValue = 0;

		Collections.sort(list1Copy, new compareCards());
		Collections.sort(list2Copy, new compareCards());

		for (int i = 0; i < list1.size() - 1; i++) {
			if (list1.get(i).getValue() + 1 != list1.get(i + 1).getValue()) {
				// Not sequential
				firstValue = -1; // Straight doesn't exist.
			}

			if (list2.get(i).getValue() + 1 != list2.get(i + 1).getValue()) {
				// Not sequential
				secondValue = -1; // Straight doesn't exist.
			}
		}

		if (firstValue != -1) {
			firstValue = list1.get(4).getValue();
		}

		if (secondValue != -1) {
			secondValue = list2.get(4).getValue();
		}

		if (firstValue > secondValue) {
			return new Card (firstValue,"Black");
		} else if (firstValue < secondValue) {
			return new Card (secondValue,"White");
		} else if (firstValue > 0 && secondValue > 0 && firstValue == secondValue) {
			return new Card(0,'H'); // tie
		}

		return new Card(-1,'H');

	}

	public Card checkFlush(ArrayList<Card> list1, ArrayList<Card> list2) {
		ArrayList<Card> list1Copy = new ArrayList<Card>(list1);
		ArrayList<Card> list2Copy = new ArrayList<Card>(list2);

		Collections.sort(list1Copy, new compareCards());
		Collections.sort(list2Copy, new compareCards());
		;
		int firstValue = 0; // result of list1
		int secondValue = 0; // result of list1 (-1 if flush doesn't exist)

		char firstSuite = list1Copy.get(0).getSuite();
		char secondSuite = list1Copy.get(1).getSuite();
		char thirdSuite = list1Copy.get(2).getSuite();
		char fourthSuite = list1Copy.get(3).getSuite();
		char fifthSuite = list1Copy.get(4).getSuite();

		if (firstSuite == secondSuite && firstSuite == thirdSuite && firstSuite == fourthSuite
				&& firstSuite == fifthSuite) {
			firstValue = list1Copy.get(4).getValue();
		}

		char firstSuite2 = list2Copy.get(0).getSuite();
		char secondSuite2 = list2Copy.get(1).getSuite();
		char thirdSuite2 = list2Copy.get(2).getSuite();
		char fourthSuite2 = list2Copy.get(3).getSuite();
		char fifthSuite2 = list2Copy.get(4).getSuite();

		if (firstSuite2 == secondSuite2 && firstSuite2 == thirdSuite2 && firstSuite2 == fourthSuite2
				&& firstSuite2 == fifthSuite2) {
			secondValue = list2Copy.get(4).getValue();
		}

		if (firstValue > secondValue) {
			return new Card(firstValue,"Black");
		}

		if (firstValue < secondValue) {
			return new Card(secondValue,"White");
		} else if (firstValue > 0 && secondValue > 0) { //two flushes we use rules for highcard
			Card ret = checkHighCards(list1Copy,list2Copy);
			return ret;
		}

		return new Card(-1,'H');
	}

	public Card checkThreeOfAKind (ArrayList<Card> list1, ArrayList<Card> list2) {
		Collections.sort(list1, new compareCards()); // Sort the list
		Collections.sort(list2, new compareCards());
		int firstListValue = -1;
		int secondListValue = -1;

		if (list1.get(0).getValue() == list1.get(1).getValue() && list1.get(0).getValue() == list1.get(2).getValue()) {
			firstListValue = list1.get(0).getValue(); // List is sorted so all values are being compared. We know there
														// are 5 elements,
														// so comparing their values is hard coded.
		}

		if (list1.get(1).getValue() == list1.get(2).getValue() && list1.get(1).getValue() == list1.get(3).getValue()) {
			firstListValue = list1.get(1).getValue();
		}

		if (list1.get(2).getValue() == list1.get(3).getValue() && list1.get(3).getValue() == list1.get(4).getValue()) {
			firstListValue = list1.get(2).getValue();
		}

		if (list2.get(0).getValue() == list2.get(1).getValue() && list2.get(0).getValue() == list2.get(2).getValue()) {
			secondListValue = list2.get(0).getValue(); // List is sorted so all values are being compared. We know there
														// are 5 elements,
														// so comparing their values is hard coded.
		}

		if (list2.get(1).getValue() == list2.get(2).getValue() && list2.get(1).getValue() == list2.get(3).getValue()) {
			secondListValue = list2.get(1).getValue();
		}

		if (list2.get(2).getValue() == list2.get(3).getValue() && list2.get(3).getValue() == list2.get(4).getValue()) {
			secondListValue = list2.get(2).getValue();
		}

		if (firstListValue > secondListValue) {
			return new Card(firstListValue,"Black");
		} else if (firstListValue < secondListValue) {
			return new Card(secondListValue,"White");
		} else if (firstListValue > -1 && secondListValue > -1 && firstListValue == secondListValue) {
			return new Card(0,'H'); // tie
		}

		return new Card(-1,'H'); // return -1 if 3 of a kind doesn't exist.
		
		

	}

	public Card checkStraightFlush(ArrayList<Card> list1, ArrayList<Card> list2) {

		int firstValue = 0;
		int secondValue = 0;

		ArrayList<Card> list1Copy = new ArrayList<Card>(list1);
		ArrayList<Card> list2Copy = new ArrayList<Card>(list2);

		Collections.sort(list1Copy, new compareCards());
		Collections.sort(list2Copy, new compareCards());

		for (int i = 0; i < list1.size() - 1; i++) {
			if (list1.get(i).getValue() + 1 != list1.get(i + 1).getValue()
					|| list1.get(i).getSuite() != list1.get(i + 1).getSuite()) { // checks suite value
				// Not sequential
				firstValue = -1; // Straight doesn't exist.

			}

			if (list2.get(i).getValue() + 1 != list2.get(i + 1).getValue()
					|| list2.get(i).getSuite() != list2.get(i + 1).getSuite()) {
				// Not sequential
				secondValue = -1; // Straight doesn't exist.
			}

		}

		if (firstValue != -1) {
			firstValue = list1.get(4).getValue();
		}

		if (secondValue != -1) {
			secondValue = list2.get(4).getValue();
		}

		if (firstValue > secondValue) {
			return new Card(firstValue,"Black");
		} else if (firstValue < secondValue) {
			return new Card(secondValue,"White");
		} else if (firstValue > 0 && secondValue > 0 && firstValue == secondValue) {
			return new Card(0,'H'); // tie
		}

		return new Card(-1,'H');
	}

	public Card checkPair(ArrayList<Card> list1, ArrayList<Card> list2) {

		ArrayList<Card> list1Copy = new ArrayList<Card>(list1);
		ArrayList<Card> list2Copy = new ArrayList<Card>(list2);

		ArrayList<Card> firstSet = findHighestPair(list1Copy,"Black");
		ArrayList<Card> secondSet = findHighestPair(list2Copy,"White");

		
		if(firstSet.size() == 0 && secondSet.size() ==0) {
			
			return new Card(-1,'H');
		}
		if (firstSet.size() == 0 && secondSet.size() == 0) {
			return new Card(0,'H'); // no two pair exists.
		} else if (firstSet.size() == 2 && secondSet.size() == 0) { //two pair exists in firstSet but not second
			return new Card(firstSet.get(0).getValue(),"Black");
		} else if (firstSet.size() == 0 && secondSet.size() == 2) { //two pair exists in secondSet but not first
			return new Card(secondSet.get(0).getValue(),"White");
		}

		int firstPair = firstSet.get(0).getValue();
		int secondPair = secondSet.get(0).getValue();

		if (firstPair > secondPair) {
			return new Card(firstPair,"Black");
		} else if (firstPair < secondPair) {
			return new Card (secondPair,"White");
		}

		if (firstPair == -1 && secondPair == -1) { // the values didn't change so no pair exists so we return -1.
			return new Card(-1,'H');
		}

		int count = 0;

		while (count < 2) {

			Card highestCardFirstHand = Collections.max(list1Copy, new compareCards()); // finds the highest card.
			Card highestCardSecondHand = Collections.max(list2Copy, new compareCards()); // finds the highest card 2nd
																							// hand

			if (highestCardFirstHand.getValue() > highestCardSecondHand.getValue()) { // returns the highest card value.
				return new Card(highestCardFirstHand.getValue(),"Black");

			} else if (highestCardFirstHand.getValue() < highestCardSecondHand.getValue()) {
				return new Card(highestCardSecondHand.getValue(),"White");

			}

			list1Copy.remove(highestCardFirstHand); // removes the card since they're of equal value as the highest card
			list2Copy.remove(highestCardSecondHand);
			count++;

		}

		if (count == 2) {
			return new Card(0,'H'); // tie exists;
		}

		return new Card(-1,'H');

	}

	public Card checkTwoPair(ArrayList<Card> list1, ArrayList<Card> list2) {

		ArrayList<Card> list1Copy = new ArrayList<Card>(list1);
		ArrayList<Card> list2Copy = new ArrayList<Card>(list2);

		ArrayList<Card> firstHandHighestPairs = findFourPair(list1Copy,"Black"); // returns all two pairs
		ArrayList<Card> secondHandHighestPairs = findFourPair(list2Copy,"White"); // finds the first highest pair 2nd hand

		if (firstHandHighestPairs.size() != 4 && secondHandHighestPairs.size() != 4) { // no two pair exists
			return new Card(-1,'H');
		}
		if (firstHandHighestPairs.size() == 4 && secondHandHighestPairs.size() != 4) { // First hand 2 pair exists, none
																						// in second hand.
			return new Card(firstHandHighestPairs.get(3).getValue(),"Black"); // the 3rd value will have the highest card since
															// they were added in descending order
		}

		else if (firstHandHighestPairs.size() != 4 && secondHandHighestPairs.size() == 4) { // Second hand 2 pair
																							// exists, first hand it
																							// doesn't
			return new Card(secondHandHighestPairs.get(3).getValue(),"White");

		} else { // two pair exists in both hands.

			Card highestCardFirstHand = firstHandHighestPairs.get(3);
			Card highestCardSecondHand = secondHandHighestPairs.get(3);

			if (highestCardFirstHand.getValue() > highestCardSecondHand.getValue()) {
				return new Card(highestCardFirstHand.getValue(),"Black");
			} else if (highestCardFirstHand.getValue() < highestCardSecondHand.getValue()) {
				return new Card(highestCardSecondHand.getValue(),"White");

			}

			highestCardFirstHand = firstHandHighestPairs.get(1); // If the code passes to here that means the pairs up
																	// there
																	// are of equal value so we check the other pair and
																	// return
			highestCardSecondHand = secondHandHighestPairs.get(1);

			if (highestCardFirstHand.getValue() > highestCardSecondHand.getValue()) {
				return new Card(highestCardFirstHand.getValue(),"Black");
			} else if (highestCardFirstHand.getValue() < highestCardSecondHand.getValue()) {
				return new Card(highestCardSecondHand.getValue(),"White");

			}

			// if the code continues to pass we check the last value to see which is higher.

			list1Copy.removeAll(firstHandHighestPairs);
			list2Copy.removeAll(secondHandHighestPairs);

			int firstHandHighestCard = list1Copy.get(0).getValue();
			int secondHandHighestCard = list2Copy.get(0).getValue();

			if (firstHandHighestCard > secondHandHighestCard) {
				return new Card(firstHandHighestCard,"Black");
			}

			if (firstHandHighestCard == secondHandHighestCard) {
				return new Card(0,'H');
			}

			return new Card(secondHandHighestCard,"White");
		}

	}

	public Card checkFullHouse(ArrayList<Card> list1, ArrayList<Card> list2) {
		ArrayList<Card> list1Copy = new ArrayList<Card>(list1);
		ArrayList<Card> list2Copy = new ArrayList<Card>(list2);

		ArrayList<Card> list1ThreeOfAKind = new ArrayList<Card>();
		ArrayList<Card> list2ThreeOfAKind = new ArrayList<Card>();
		boolean fullHouseExistsFirstHand = false;
		boolean fullHouseExistsSecondHand = false;
		for (int i = 0; i < list1.size() - 2; i++) {
			Card firstCardFirstHand = list1Copy.get(i);
			Card firstCardSecondHand = list2Copy.get(i);

			Card secondCardFirstHand = list1Copy.get(i + 1);
			Card secondCardSecondHand = list2Copy.get(i + 1);

			Card thirdCardFirstHand = list1Copy.get(i + 2);
			Card thirdCardSecondHand = list2Copy.get(i + 2);

			if (firstCardFirstHand.getValue() == secondCardFirstHand.getValue()
					&& firstCardFirstHand.getValue() == thirdCardFirstHand.getValue()) {
				list1ThreeOfAKind.add(firstCardFirstHand);
				list1ThreeOfAKind.add(secondCardFirstHand); // if all 3 are the same value it's 3 of a kind so it's
															// added to the array of 3 of a king.
				list1ThreeOfAKind.add(thirdCardFirstHand);

			}

			if (firstCardSecondHand.getValue() == secondCardSecondHand.getValue()
					&& firstCardSecondHand.getValue() == thirdCardSecondHand.getValue()) {
				list2ThreeOfAKind.add(firstCardSecondHand);
				list2ThreeOfAKind.add(secondCardSecondHand);
				list2ThreeOfAKind.add(thirdCardSecondHand);

			}

		}

		if (list1ThreeOfAKind.size() == 0 && list2ThreeOfAKind.size() == 0) {
			return new Card(-1,'H'); // no 3 of a kind exists. so no point checking for two pair.
		}

		list1Copy.removeAll(list1ThreeOfAKind); // remove the 3 of a kind if it exists to check for pairs.
		list2Copy.removeAll(list2ThreeOfAKind);

		if (list1Copy.size() == 2 && list1Copy.get(0).getValue() == list1Copy.get(1).getValue()) { // 3 of a kin
			fullHouseExistsFirstHand = true;

		}

		if (list2Copy.size() == 2 && list2Copy.get(0).getValue() == list2Copy.get(1).getValue()) {
			fullHouseExistsSecondHand = true;
		}

		if (!fullHouseExistsFirstHand && !fullHouseExistsSecondHand) {
			return new Card(-1,'H');
		}
		if (fullHouseExistsFirstHand && !fullHouseExistsSecondHand) {
			return new Card(list1ThreeOfAKind.get(0).getValue(),"Black");
		} else if (!fullHouseExistsFirstHand && fullHouseExistsSecondHand) {
			return new Card(list2ThreeOfAKind.get(0).getValue(),"White");
		}

		int firstHandHigh = list1ThreeOfAKind.get(0).getValue();
		int secondHandHigh = list2ThreeOfAKind.get(0).getValue();

		if (firstHandHigh > secondHandHigh) {
			return new Card (firstHandHigh,"Black");
		} else if (firstHandHigh < secondHandHigh) {
			return new Card(secondHandHigh,"White");
		} else if (firstHandHigh == secondHandHigh) {
			return new Card(0,'H');
		}

		return new Card(-1,'H');

	}

	/**
	 * Method that takes in a list of cards, and returns an arraylist with the two
	 * cards that form the pair.
	 * 
	 * @param list
	 * @return
	 */

	public ArrayList<Card> findHighestPair(ArrayList<Card> list, String s) {
		ArrayList<Card> ret = new ArrayList<Card>();
		Card c1 = new Card(0, s);
		Card c2 = new Card(0, s); // initializing cards
		for (int i = 0; i < list.size() - 1; i++) {

			int firstElement = list.get(i).getValue();
			int secondElement = list.get(i + 1).getValue();
			if (firstElement == secondElement) {
				if (firstElement > c1.getValue()) {// pair exists
					c1 = list.get(i);
					c2 = list.get(i);
				}
			}

		}

		if (c1.getValue() > 0) {
			ret.add(c1);
			ret.add(c2);
		}

		return ret; // return an arraylist of the pair if empty arraylist non exist.

	}

	public String playPoker(ArrayList<Card> firstHand, ArrayList<Card> secondHand) {
		
		 

		Card straightFlush = checkStraightFlush(firstHand, secondHand);
		if (straightFlush.getValue() > 0) {
			return (straightFlush.getHand() + " wins. - with straight flush");
		} else if (straightFlush.getValue() == 0) {
			return ("Tie");
		}
		
		

		Card fourOfAKind = checkFourOfAKind(firstHand, secondHand);
		if (fourOfAKind.getValue() > 0) {
		  return (fourOfAKind.getHand() + " wins. - with Four of a Kind ");
		} else if (fourOfAKind.getValue() == 0) {
			return ("Tie");
		}
		
		Card fullHouse = checkFullHouse(firstHand, secondHand);
		if (fullHouse.getValue() > 0) {
			return (fullHouse.getHand() + " wins. - with full house");
		} else if (fullHouse.getValue() == 0) {
			return ("Tie");
		}
	
		Card flush = checkFlush(firstHand, secondHand);
		if (flush.getValue() > 0) {
			return (flush.getHand() + " wins. - with Flush ");
		} else if (flush.getValue() == 0) {
			return ("Tie");
		}
		
		Card straight = checkStraight(firstHand, secondHand);
		if (straight.getValue() > 0) {
			return (straight.getHand() + " wins. - with Straight ");
		} else if (straight.getValue() == 0) {
			return ("Tie");
		}
	
		Card threeOfAKind = checkThreeOfAKind(firstHand, secondHand);
		if (threeOfAKind.getValue() > 0) {
			return (threeOfAKind.getHand() + " wins. - with Three of a Kind ");
		} else if (threeOfAKind.getValue() == 0) {
			return ("Tie");
		}
		
		Card twoPair = checkTwoPair(firstHand, secondHand);
		if (twoPair.getValue() > 0) {
			return (twoPair.getHand() + " wins. - with two pair ");
		} else if (twoPair.getValue() == 0) {
			return ("Tie");
		}

		Card pair = checkPair(firstHand, secondHand);
		if (pair.getValue() > 0) {
			return (pair.getHand() + " wins. - with pair ");
		} else if (pair.getValue() == 0) {
			return ("Tie");
		}
		
		Card c = checkHighCards(firstHand, secondHand);
		int highCard = c.getValue();
		String hand = c.getHand();
		if (highCard > 0) {
			if (highCard == 14) {
				return (hand + " wins. -  with high card Ace");
			} else if (highCard == 13) {
				return (hand + " wins. - with highcard King");
			} else if (highCard == 12) {
				return (hand + " wins. - with highcard Queen");
			} else if (highCard == 11) {
				return (hand + " wins. - with Jack");
			} else if (highCard > 0) {
				return (hand + " wins. - with high card " + highCard);
			}
			;
		} else if (highCard == 0) {
			return ("Tie");
		}

		return "Error";
	}

	public ArrayList<Card> findFourPair(ArrayList<Card> list, String s) {
		ArrayList<Card> ret = new ArrayList<Card>();
		Collections.sort(list, new compareCards());

		for (int i = 0; i < list.size() - 1; i++) {
			Card c1 = list.get(i);
			Card c2 = list.get(i + 1);

			if (c1.getValue() == c2.getValue()) {
				ret.add(c1);
				ret.add(c2);
				i += 1;

			}

		}

		return ret;
	}
	
	 

	public static class compareCards implements Comparator<Card> {
		@Override
		public int compare(Card c1, Card c2) {
			int v1 = c1.getValue(); // get digit value of the first card
			int v2 = c2.getValue(); // get digit value of the second card
			return v1 - v2;

		}
	}

}
