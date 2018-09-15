package a2;
import java.util.Scanner;

public class HandEvaluator {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		double winCount = 0;
		double lossCount = 0;
		//double tieCount = 0;
		
		// while input is being put in
		while (s.hasNext()) {
		
		int numberOpponents = s.nextInt();
		
		// if number of opponents is 0, then print 0
		if (numberOpponents == 0) {
			System.out.println(0);
		}
		
		int Rank1 = s.nextInt();
		String Suit1 = s.next();
		Card.Suit SuitEnum1 = stringToSuit(Suit1);
		Card card1 = new CardImpl(Rank1, SuitEnum1);
		
		int Rank2 = s.nextInt();
		String Suit2 = s.next();
		Card.Suit SuitEnum2 = stringToSuit(Suit2);
		Card card2 = new CardImpl(Rank2, SuitEnum2);
		
		int Rank3 = s.nextInt();
		String Suit3 = s.next();
		Card.Suit SuitEnum3 = stringToSuit(Suit3);
		Card card3 = new CardImpl(Rank3, SuitEnum3);
		
		int Rank4 = s.nextInt();
		String Suit4 = s.next();
		Card.Suit SuitEnum4 = stringToSuit(Suit4);
		Card card4 = new CardImpl(Rank4, SuitEnum4);
		
		int Rank5 = s.nextInt();
		String Suit5 = s.next();
		Card.Suit SuitEnum5 = stringToSuit(Suit5);
		Card card5 = new CardImpl(Rank5, SuitEnum5);
		
		// create an array of these cards
		Card[] handArray = {card1, card2, card3, card4, card5}; 
		PokerHand hand = new PokerHandImpl(handArray);
		
		
		
		for (int i = 0; i < 10000; i++) {
			// create new shuffled deck of cards
			DeckImpl shuffledDeck = new DeckImpl();
			
			
			// remove hand cards from deck 
			shuffledDeck.findAndRemove(card1);
			shuffledDeck.findAndRemove(card2);
			shuffledDeck.findAndRemove(card3);
			shuffledDeck.findAndRemove(card4);
			shuffledDeck.findAndRemove(card5);
			
			// deal poker hand to each player
			for (int j = 0; j < numberOpponents; j++) {
			if (shuffledDeck.hasHand()) {
				PokerHand opponentHand = shuffledDeck.dealHand();
				
				// compare specified hand to opponentHand
				if (hand.compareTo(opponentHand) == 1) {
					winCount++;
				} else if (hand.compareTo(opponentHand) == -1) {
					lossCount++;
				} //else {
					//tieCount++;
				//}
				
				}
			}
		}
		
		double percentage_as_double = 100 * ((winCount * 1.0)/(winCount + lossCount /*+ tieCount*/));
		int percentage_as_an_int = (int)(percentage_as_double + 0.5);
		System.out.println(percentage_as_an_int);
		
		}
		
		
		s.close();
		
	}
	public static Card.Suit stringToSuit(String letter) {
		if (letter.equals("S")) {
			return Card.Suit.SPADES;
		} else if (letter.equals("H")) {
			return Card.Suit.HEARTS;
		} else if (letter.equals("D")) {
			return Card.Suit.DIAMONDS;
		} else {
			return Card.Suit.CLUBS;
		}
	}
	

}
