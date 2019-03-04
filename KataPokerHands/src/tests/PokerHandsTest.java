package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import poker.Card;
import poker.PokerHands;

class PokerHandsTest {

	PokerHands pk = new PokerHands();

	@Test
	public void TestHighCardWhiteHandWins() {
		Card answer = new Card();
		answer.setValue(14);
		answer.setHand("White");
		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card blackcard1 = new Card(2, 'H');
		Card blackcard2 = new Card(3, 'D');
		Card blackcard3 = new Card(5, 'S');
		Card blackcard4 = new Card(9, 'C');
		Card blackcard5 = new Card(13, 'D');

		Card whitecard1 = new Card(2, 'C');
		Card whitecard2 = new Card(3, 'H');
		Card whitecard3 = new Card(4, 'S');
		Card whitecard4 = new Card(8, 'C');
		Card whitecard5 = new Card(14, 'H');

		
		list1.add(blackcard1);
		list1.add(blackcard2);
		list1.add(blackcard3);
		list1.add(blackcard4);
		list1.add(blackcard5);

		list2.add(whitecard1);
		list2.add(whitecard2);
		list2.add(whitecard3);
		list2.add(whitecard4);
		list2.add(whitecard5);
		assertEquals(14, pk.checkHighCards(list1, list2).getValue());
		assertEquals("White", pk.checkHighCards(list1, list2).getHand());

	}

	@Test
	public void TestHighCardBlackHandWins() { 
		Card answer = new Card();
		answer.setValue(14);
		answer.setHand("Black");

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card blackcard1 = new Card(2, 'H');
		Card blackcard2 = new Card(3, 'D');
		Card blackcard3 = new Card(5, 'S');
		Card blackcard4 = new Card(14, 'C');
		Card blackcard5 = new Card(13, 'D');

		Card whitecard1 = new Card(2, 'C');
		Card whitecard2 = new Card(3, 'H');
		Card whitecard3 = new Card(4, 'S');
		Card whitecard4 = new Card(8, 'C');
		Card whitecard5 = new Card(13, 'H');

		

		list1.add(blackcard1);
		list1.add(blackcard2);
		list1.add(blackcard3);
		list1.add(blackcard4);
		list1.add(blackcard5);
		
		list2.add(whitecard1);
		list2.add(whitecard2);
		list2.add(whitecard3);
		list2.add(whitecard4);
		list2.add(whitecard5);
		
		
		assertEquals(14, pk.checkHighCards(list1, list2).getValue());
		assertEquals("Black", pk.checkHighCards(list1, list2).getHand());

	}

	@Test
	public void TestHighCardWhiteHandsButFirstMaxIsEqual() { // The first max for the two hands is equal so the 2nd
																// highest value is chosen

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();
		Card answer = new Card();
		answer.setValue(10);
		answer.setHand("White");
		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(3, 'D');
		Card whitecard3 = new Card(5, 'S');
		Card whitecard4 = new Card(8, 'C');
		Card whitecard5 = new Card(8, 'D');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(3, 'H');
		Card blackcard3 = new Card(4, 'S');
		Card blackcard4 = new Card(8, 'C');
		Card blackcard5 = new Card(10, 'H');

		 
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkHighCards(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkHighCards(list1, list2).getHand());

	}

	@Test
	public void TestHighCardWhiteHandsButFirsTwotMaxIsEqual() { // Same as above, but the first two max values are
																// equal.

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();
		
		Card answer = new Card();
		answer.setValue(5);
		answer.setHand("Black");
		
		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(3, 'D');
		Card whitecard3 = new Card(5, 'S');
		Card whitecard4 = new Card(14, 'C');
		Card whitecard5 = new Card(13, 'D');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(3, 'H');
		Card blackcard3 = new Card(4, 'S');
		Card blackcard4 = new Card(13, 'C');
		Card blackcard5 = new Card(14, 'H');

		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getHand(), pk.checkHighCards(list1, list2).getHand());
		assertEquals(answer.getValue(), pk.checkHighCards(list1, list2).getValue());


	}

	@Test
	public void TestHighCardTie() {
		Card answer = new Card();
		answer.setValue(0);
		

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card whitecard1 = new Card(1, 'H');
		Card whitecard2 = new Card(2, 'D');
		Card whitecard3 = new Card(3, 'S');
		Card whitecard4 = new Card(4, 'C');
		Card whitecard5 = new Card(5, 'D');

		Card blackcard1 = new Card(1, 'C');
		Card blackcard2 = new Card(2, 'H');
		Card blackcard3 = new Card(3, 'S');
		Card blackcard4 = new Card(4, 'C');
		Card blackcard5 = new Card(5, 'H');

		list2.add(whitecard1);
		list2.add(whitecard2);
		list2.add(whitecard3);
		list2.add(whitecard4);
		list2.add(whitecard5);

		list1.add(blackcard1);
		list1.add(blackcard2);
		list1.add(blackcard3);
		list1.add(blackcard4);
		list1.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkHighCards(list1, list2).getValue()
				);

	}

	@Test
	public void Test3OfAKindWhiteHandWinsBothExist() { 
		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card answer = new Card(2,"Black");
		
		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(2, 'D');
		Card whitecard3 = new Card(2, 'S');
		Card whitecard4 = new Card(9, 'C');
		Card whitecard5 = new Card(13, 'D');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(3, 'H');
		Card blackcard3 = new Card(5, 'S');
		Card blackcard4 = new Card(9, 'C');
		Card blackcard5 = new Card(13, 'H');

		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkThreeOfAKind(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkThreeOfAKind(list1, list2).getHand());


	}

	@Test
	public void Test3OfAKindOneHandOnlyExists() { 
		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card answer = new Card(3,"Black");
		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(3, 'D');
		Card whitecard3 = new Card(3, 'S');
		Card whitecard4 = new Card(3, 'C');
		Card whitecard5 = new Card(13, 'D');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(5, 'H');
		Card blackcard3 = new Card(2, 'S');
		Card blackcard4 = new Card(8, 'C');
		Card blackcard5 = new Card(13, 'H');

		
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkThreeOfAKind(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkThreeOfAKind(list1, list2).getHand());

	}

	@Test
	public void Test3OfAKindBothHandsDoesntExist() { 
		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card answer = new Card(-1,'H');
		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(3, 'D');
		Card whitecard3 = new Card(2, 'S');
		Card whitecard4 = new Card(3, 'C');
		Card whitecard5 = new Card(13, 'D');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(5, 'H');
		Card blackcard3 = new Card(2, 'S');
		Card blackcard4 = new Card(8, 'C');
		Card blackcard5 = new Card(13, 'H');

		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkThreeOfAKind(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkThreeOfAKind(list1, list2).getHand());


	}

	@Test
	public void Test3OfAKindTie() { 
		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card answer = new Card(0,"White");
		
		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(3, 'D');
		Card whitecard3 = new Card(3, 'S');
		Card whitecard4 = new Card(3, 'C');
		Card whitecard5 = new Card(13, 'D');

		Card blackcard1 = new Card(3, 'C');
		Card blackcard2 = new Card(3, 'H');
		Card blackcard3 = new Card(3, 'S');
		Card blackcard4 = new Card(8, 'C');
		Card blackcard5 = new Card(13, 'H');

		
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkThreeOfAKind(list1, list2).getValue());
		


	}

	@Test
	public void TestStraightOneHandHasIt() { 

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card answer = new Card(5,"Black");
		Card whitecard1 = new Card(1, 'H');
		Card whitecard2 = new Card(2, 'D');
		Card whitecard3 = new Card(3, 'S');
		Card whitecard4 = new Card(4, 'C');
		Card whitecard5 = new Card(5, 'D');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(5, 'H');
		Card blackcard3 = new Card(2, 'S');
		Card blackcard4 = new Card(8, 'C');
		Card blackcard5 = new Card(13, 'H');

		
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkStraight(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkStraight(list1, list2).getHand());


	}

	@Test
	public void TestStraightBothHandsHaveIt() { 
		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card answer = new Card(8,"White");
		Card whitecard1 = new Card(1, 'H');
		Card whitecard2 = new Card(2, 'D');
		Card whitecard3 = new Card(3, 'S');
		Card whitecard4 = new Card(4, 'C');
		Card whitecard5 = new Card(5, 'D');

		Card blackcard1 = new Card(4, 'C');
		Card blackcard2 = new Card(5, 'H');
		Card blackcard3 = new Card(6, 'S');
		Card blackcard4 = new Card(7, 'C');
		Card blackcard5 = new Card(8, 'H');

		
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkStraight(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkStraight(list1, list2).getHand());


	}

	@Test
	public void TestStraightNoHandsHaveit() { 
		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card whitecard1 = new Card(1, 'H');
		Card whitecard2 = new Card(5, 'D');
		Card whitecard3 = new Card(3, 'S');
		Card whitecard4 = new Card(4, 'C');
		Card whitecard5 = new Card(5, 'D');

		Card blackcard1 = new Card(4, 'C');
		Card blackcard2 = new Card(7, 'H');
		Card blackcard3 = new Card(6, 'S');
		Card blackcard4 = new Card(7, 'C');
		Card blackcard5 = new Card(8, 'H');

		int answer = -1; //  
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer, pk.checkStraight(list1, list2).getValue());

	}

	@Test
	public void TestStraightTie() { 
		
		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card answer = new Card(0,'H');
		Card whitecard1 = new Card(1, 'H');
		Card whitecard2 = new Card(2, 'D');
		Card whitecard3 = new Card(3, 'S');
		Card whitecard4 = new Card(4, 'C');
		Card whitecard5 = new Card(5, 'D');

		Card blackcard1 = new Card(1, 'C');
		Card blackcard2 = new Card(2, 'H');
		Card blackcard3 = new Card(3, 'S');
		Card blackcard4 = new Card(4, 'C');
		Card blackcard5 = new Card(5, 'H');

	
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkStraight(list1, list2).getValue());

	}

	@Test
	public void TestFlushOneHandHasit() {

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card answer = new Card(6,"Black");
		Card whitecard1 = new Card(1, 'H');
		Card whitecard2 = new Card(6, 'H');
		Card whitecard3 = new Card(3, 'H');
		Card whitecard4 = new Card(4, 'H');
		Card whitecard5 = new Card(5, 'H');

		Card blackcard1 = new Card(4, 'C');
		Card blackcard2 = new Card(7, 'H');
		Card blackcard3 = new Card(6, 'S');
		Card blackcard4 = new Card(7, 'C');
		Card blackcard5 = new Card(8, 'H');

		
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkFlush(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkFlush(list1, list2).getHand());


	}

	@Test
	public void TestFlushBothHandsHaveIt() { 

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card answer = new Card(7,"White");
		Card whitecard1 = new Card(1, 'H');
		Card whitecard2 = new Card(5, 'H');
		Card whitecard3 = new Card(3, 'H');
		Card whitecard4 = new Card(4, 'H');
		Card whitecard5 = new Card(7, 'H');

		Card blackcard1 = new Card(4, 'C');
		Card blackcard2 = new Card(7, 'C');
		Card blackcard3 = new Card(6, 'C');
		Card blackcard4 = new Card(7, 'C');
		Card blackcard5 = new Card(5, 'C');

		 
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkFlush(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkFlush(list1, list2).getHand());


	}

	@Test
	public void TestFlushNoHandsHaveIt() { 

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();
		Card answer = new Card(-1,'H');
		Card whitecard1 = new Card(1, 'H');
		Card whitecard2 = new Card(5, 'C');
		Card whitecard3 = new Card(3, 'H');
		Card whitecard4 = new Card(4, 'H');
		Card whitecard5 = new Card(5, 'H');

		Card blackcard1 = new Card(4, 'C');
		Card blackcard2 = new Card(7, 'H');
		Card blackcard3 = new Card(6, 'C');
		Card blackcard4 = new Card(7, 'C');
		Card blackcard5 = new Card(8, 'C');

		
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkFlush(list1, list2).getValue());

	}

	@Test
	public void TestFlushTie() { 

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card answer = new Card(0,'H');
		
		Card whitecard1 = new Card(1, 'H');
		Card whitecard2 = new Card(5, 'H');
		Card whitecard3 = new Card(3, 'H');
		Card whitecard4 = new Card(4, 'H');
		Card whitecard5 = new Card(5, 'H');

		Card blackcard1 = new Card(1, 'H');
		Card blackcard2 = new Card(5, 'H');
		Card blackcard3 = new Card(3, 'H');
		Card blackcard4 = new Card(4, 'H');
		Card blackcard5 = new Card(5, 'H');

		
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkFlush(list1, list2).getValue());

	}

	@Test
	public void Test4OfAKindOneHandHasIt() { 

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();
		
		Card answer = new Card(1,"Black");

		Card whitecard1 = new Card(1, 'H');
		Card whitecard2 = new Card(1, 'C');
		Card whitecard3 = new Card(1, 'H');
		Card whitecard4 = new Card(1, 'C');
		Card whitecard5 = new Card(5, 'H');

		Card blackcard1 = new Card(4, 'C');
		Card blackcard2 = new Card(7, 'H');
		Card blackcard3 = new Card(6, 'C');
		Card blackcard4 = new Card(7, 'C');
		Card blackcard5 = new Card(8, 'C');

		
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkFourOfAKind(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkFourOfAKind(list1, list2).getHand());


	}

	@Test
	public void Test4OfAKindBothHandsHaveIt() { 

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card answer = new Card(4,"White");
		Card whitecard1 = new Card(1, 'H');
		Card whitecard2 = new Card(1, 'C');
		Card whitecard3 = new Card(1, 'H');
		Card whitecard4 = new Card(1, 'C');
		Card whitecard5 = new Card(5, 'H');

		Card blackcard1 = new Card(4, 'C');
		Card blackcard2 = new Card(4, 'H');
		Card blackcard3 = new Card(4, 'C');
		Card blackcard4 = new Card(4, 'C');
		Card blackcard5 = new Card(7, 'C');

		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkFourOfAKind(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkFourOfAKind(list1, list2).getHand());

	}

	@Test
	public void Test4OfAKindNoHandsHaveIt() { 

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card answer = new Card(-1,'H');
		Card whitecard1 = new Card(1, 'H');
		Card whitecard2 = new Card(2, 'C');
		Card whitecard3 = new Card(1, 'H');
		Card whitecard4 = new Card(1, 'C');
		Card whitecard5 = new Card(5, 'H');

		Card blackcard1 = new Card(4, 'C');
		Card blackcard2 = new Card(2, 'H');
		Card blackcard3 = new Card(4, 'C');
		Card blackcard4 = new Card(4, 'C');
		Card blackcard5 = new Card(7, 'C');

		
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkFourOfAKind(list1, list2).getValue());

	}

	@Test
	public void TestStraightFlushOneHandHasIt() { 

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		
		Card answer = new Card(5,"Black");
		Card whitecard1 = new Card(1, 'H');
		Card whitecard2 = new Card(2, 'H');
		Card whitecard3 = new Card(3, 'H');
		Card whitecard4 = new Card(4, 'H');
		Card whitecard5 = new Card(5, 'H');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(3, 'H');
		Card blackcard3 = new Card(4, 'C');
		Card blackcard4 = new Card(5, 'C');
		Card blackcard5 = new Card(6, 'C');

		 
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkStraightFlush(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkStraightFlush(list1, list2).getHand());

	}

	@Test
	public void TestStraightFlushBothHandsHaveIt() { 

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card answer = new Card(6,"White");
		Card whitecard1 = new Card(1, 'H');
		Card whitecard2 = new Card(2, 'H');
		Card whitecard3 = new Card(3, 'H');
		Card whitecard4 = new Card(4, 'H');
		Card whitecard5 = new Card(5, 'H');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(3, 'C');
		Card blackcard3 = new Card(4, 'C');
		Card blackcard4 = new Card(5, 'C');
		Card blackcard5 = new Card(6, 'C');

		
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkStraightFlush(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkStraightFlush(list1, list2).getHand());


	}

	@Test
	public void TestStraightFlushNoHandsHaveItButHaveStraight() { 
		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card answer = new Card(-1,'H');
		Card whitecard1 = new Card(1, 'H');
		Card whitecard2 = new Card(2, 'H');
		Card whitecard3 = new Card(3, 'H');
		Card whitecard4 = new Card(4, 'C');
		Card whitecard5 = new Card(5, 'H');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(3, 'H');
		Card blackcard3 = new Card(4, 'C');
		Card blackcard4 = new Card(5, 'C');
		Card blackcard5 = new Card(6, 'C');


		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkStraightFlush(list1, list2).getValue());
		


	}

	@Test
	public void TestStraightFlushTie() { 

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card whitecard1 = new Card(1, 'H');
		Card whitecard2 = new Card(2, 'H');
		Card whitecard3 = new Card(3, 'H');
		Card whitecard4 = new Card(4, 'H');
		Card whitecard5 = new Card(5, 'H');

		Card blackcard1 = new Card(1, 'C');
		Card blackcard2 = new Card(2, 'C');
		Card blackcard3 = new Card(3, 'C');
		Card blackcard4 = new Card(4, 'C');
		Card blackcard5 = new Card(5, 'C');

		int answer = 0; //  
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer, pk.checkStraightFlush(list1, list2).getValue());

	}

	@Test
	public void TestPairOneHandHasIt() { 
		Card c = new Card(2,"Black");
		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(2, 'H');
		Card whitecard3 = new Card(3, 'H');
		Card whitecard4 = new Card(4, 'C');
		Card whitecard5 = new Card(5, 'H');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(3, 'H');
		Card blackcard3 = new Card(4, 'C');
		Card blackcard4 = new Card(5, 'C');
		Card blackcard5 = new Card(6, 'C');

		int answer = 2; //  
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(c.getValue(), pk.checkPair(list1, list2).getValue());
		assertEquals(c.getHand(), pk.checkPair(list1, list2).getHand());

	}

	@Test
	public void TestPairBothHandsHaveItBlackHandWinner() { 
		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();
		Card answer = new Card(3,"White");
		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(2, 'H');
		Card whitecard3 = new Card(3, 'H');
		Card whitecard4 = new Card(4, 'C');
		Card whitecard5 = new Card(5, 'H');

		Card blackcard1 = new Card(3, 'C');
		Card blackcard2 = new Card(3, 'H');
		Card blackcard3 = new Card(4, 'C');
		Card blackcard4 = new Card(5, 'C');
		Card blackcard5 = new Card(6, 'C');
 
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkPair(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkPair(list1, list2).getHand());

	}

	@Test
	public void TestPairBothHandsHaveItButEqualPairSoNextHighCardIsChecked() { 
		Card answer = new Card(6,"White");
		
		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(2, 'H');
		Card whitecard3 = new Card(3, 'H');
		Card whitecard4 = new Card(4, 'C');
		Card whitecard5 = new Card(5, 'H');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(2, 'H');
		Card blackcard3 = new Card(4, 'C');
		Card blackcard4 = new Card(5, 'C');
		Card blackcard5 = new Card(6, 'C');

		 
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkPair(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkPair(list1, list2).getHand());

	}

	@Test
	public void TestPairBothHandsHaveItButEqualPairSoNextHighCardIsCheckedButItsEqualSoSecondCardIsChecked() { 
		
		Card answer = new Card(5,"White");
		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(2, 'H');
		Card whitecard3 = new Card(3, 'H');
		Card whitecard4 = new Card(4, 'C');
		Card whitecard5 = new Card(6, 'H');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(2, 'H');
		Card blackcard3 = new Card(4, 'C');
		Card blackcard4 = new Card(5, 'C');
		Card blackcard5 = new Card(6, 'C');

	
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkPair(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkPair(list1, list2).getHand());

	}

	@Test
	public void TestPairNoHandHasIt() {

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();
		Card answer = new Card(-1,'H');
		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(1, 'H');
		Card whitecard3 = new Card(3, 'H');
		Card whitecard4 = new Card(4, 'C');
		Card whitecard5 = new Card(5, 'H');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(3, 'H');
		Card blackcard3 = new Card(4, 'C');
		Card blackcard4 = new Card(5, 'C');
		Card blackcard5 = new Card(6, 'C');
 
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkPair(list1, list2).getValue());
		

	}

	@Test
	public void TestPairTie() { 

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card answer = new Card(0,'H');
		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(2, 'H');
		Card whitecard3 = new Card(3, 'H');
		Card whitecard4 = new Card(4, 'C');
		Card whitecard5 = new Card(5, 'H');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(2, 'H');
		Card blackcard3 = new Card(3, 'C');
		Card blackcard4 = new Card(4, 'C');
		Card blackcard5 = new Card(5, 'C');

		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkPair(list1, list2).getValue());
		
	}

	@Test
	public void TestTwoPairsNoHandHasIt() { 

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();
		Card answer = new Card(-1,'H');
		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(2, 'H');
		Card whitecard3 = new Card(3, 'H');
		Card whitecard4 = new Card(4, 'C');
		Card whitecard5 = new Card(5, 'H');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(2, 'H');
		Card blackcard3 = new Card(2, 'C');
		Card blackcard4 = new Card(5, 'C');
		Card blackcard5 = new Card(6, 'C');

	
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkTwoPair(list1, list2).getValue());

	}

	@Test
	public void TestTwoPairsOneHandHasIt() { 
		Card answer = new Card(3,"Black");
		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(2, 'H');
		Card whitecard3 = new Card(3, 'H');
		Card whitecard4 = new Card(3, 'C');
		Card whitecard5 = new Card(5, 'H');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(2, 'H');
		Card blackcard3 = new Card(2, 'C');
		Card blackcard4 = new Card(5, 'C');
		Card blackcard5 = new Card(6, 'C');

	 
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkTwoPair(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkTwoPair(list1, list2).getHand());

	}

	@Test
	public void TestTwoPairsBothHandsHaveItButFirstPairIsEqual() { 

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card answer = new Card(5,"White");
		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(2, 'H');
		Card whitecard3 = new Card(3, 'H');
		Card whitecard4 = new Card(3, 'C');
		Card whitecard5 = new Card(5, 'H');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(2, 'H');
		Card blackcard3 = new Card(5, 'C');
		Card blackcard4 = new Card(5, 'C');
		Card blackcard5 = new Card(6, 'C');

	
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkTwoPair(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkTwoPair(list1, list2).getHand());
	}

	@Test
	public void TestTwoPairsBothHandsHaveItButSameExactTwoPairs() { 
		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();
Card answer = new Card(7,"Black");
		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(2, 'H');
		Card whitecard3 = new Card(5, 'H');
		Card whitecard4 = new Card(5, 'C');
		Card whitecard5 = new Card(7, 'H');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(2, 'H');
		Card blackcard3 = new Card(5, 'C');
		Card blackcard4 = new Card(5, 'C');
		Card blackcard5 = new Card(6, 'C');

	
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkTwoPair(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkTwoPair(list1, list2).getHand());

	}

	@Test
	public void TestTwoPairTie() { 

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(2, 'H');
		Card whitecard3 = new Card(3, 'H');
		Card whitecard4 = new Card(3, 'C');
		Card whitecard5 = new Card(5, 'H');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(2, 'H');
		Card blackcard3 = new Card(3, 'C');
		Card blackcard4 = new Card(3, 'C');
		Card blackcard5 = new Card(5, 'C');

		int answer = 0; 
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer, pk.checkTwoPair(list1, list2).getValue());

	}

	@Test
	public void TestFullHouseOneHandHasIt() { 

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card answer = new Card(2,"Black");
		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(2, 'H');
		Card whitecard3 = new Card(2, 'H');
		Card whitecard4 = new Card(3, 'C');
		Card whitecard5 = new Card(3, 'H');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(2, 'H');
		Card blackcard3 = new Card(5, 'C');
		Card blackcard4 = new Card(5, 'C');
		Card blackcard5 = new Card(6, 'C');

	 
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkFullHouse(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkFullHouse(list1, list2).getHand());

	}

	@Test
	public void TestFullHouseBothHandHaveItHighest3OfAKindChosen() { 
		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		Card answer = new Card(3,"White");
		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(2, 'H');
		Card whitecard3 = new Card(2, 'H');
		Card whitecard4 = new Card(3, 'C');
		Card whitecard5 = new Card(3, 'H');

		Card blackcard1 = new Card(3, 'C');
		Card blackcard2 = new Card(3, 'H');
		Card blackcard3 = new Card(3, 'C');
		Card blackcard4 = new Card(6, 'C');
		Card blackcard5 = new Card(6, 'C');

		
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkFullHouse(list1, list2).getValue());
		assertEquals(answer.getHand(), pk.checkFullHouse(list1, list2).getHand());


	}

	@Test
	public void TestFullHouseNoHandHasIt() { 

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		
		Card answer = new Card(-1,'H');
		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(2, 'H');
		Card whitecard3 = new Card(2, 'H');
		Card whitecard4 = new Card(4, 'C');
		Card whitecard5 = new Card(7, 'H');

		Card blackcard1 = new Card(3, 'C');
		Card blackcard2 = new Card(3, 'H');
		Card blackcard3 = new Card(3, 'C');
		Card blackcard4 = new Card(4, 'C');
		Card blackcard5 = new Card(6, 'C');

	 
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkFullHouse(list1, list2).getValue());

	}

	@Test
	public void TestFullHouseTie() {
		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();
		
		Card answer = new Card(0,'H');

		Card whitecard1 = new Card(2, 'H');
		Card whitecard2 = new Card(2, 'H');
		Card whitecard3 = new Card(2, 'H');
		Card whitecard4 = new Card(3, 'C');
		Card whitecard5 = new Card(3, 'H');

		Card blackcard1 = new Card(2, 'C');
		Card blackcard2 = new Card(2, 'H');
		Card blackcard3 = new Card(2, 'C');
		Card blackcard4 = new Card(3, 'C');
		Card blackcard5 = new Card(3, 'C');

 
		list1.add(whitecard1);
		list1.add(whitecard2);
		list1.add(whitecard3);
		list1.add(whitecard4);
		list1.add(whitecard5);

		list2.add(blackcard1);
		list2.add(blackcard2);
		list2.add(blackcard3);
		list2.add(blackcard4);
		list2.add(blackcard5);
		assertEquals(answer.getValue(), pk.checkFullHouse(list1, list2).getValue());

	}

}