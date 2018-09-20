package a2;
import java.util.Scanner;

public class HandEvaluator {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		double winCount = 0;
		double lossCount = 0;
		//double tieCount = 0;
		boolean betterThanHand = false;
		boolean lostHandAtLeastOnce = false;
		//boolean equalToHand = false;
		
		// while input is being put in
	while (s.hasNext()) {
		
		int numberOpponents = s.nextInt();
		
		// if number of opponents is 0, then print 0
		if (numberOpponents == 0) {
			break;
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
		
		lossCount = 0; 
		winCount = 0;
		for (int i = 0; i < 10000; i++) {
			lostHandAtLeastOnce = false;
			betterThanHand = false;
			
			// create deck
			DeckImpl ShuffledDeck = new DeckImpl();
			
			
			// remove five cards
			ShuffledDeck.findAndRemove(card1);
			ShuffledDeck.findAndRemove(card2);
			ShuffledDeck.findAndRemove(card3);
			ShuffledDeck.findAndRemove(card4);
			ShuffledDeck.findAndRemove(card5);
			
			// deal hand to each opponent
			
			for (int j = 0; j < numberOpponents; j++) {
				
					// create opponent's hand
					
					PokerHand opponentHand = ShuffledDeck.dealHand();
					
					// need to get rid of opponent's cards here?
					
				
					if (hand.compareTo(opponentHand) == 1) {
						betterThanHand = true;
						
					} else if (hand.compareTo(opponentHand) == -1) {
						lostHandAtLeastOnce = true;

					// never going to be equal to each other?
					//} else if (hand.compareTo(opponentHand) == 0) {
						//equalToHand = true;
						
				}	
			}
			
			// counting wins & losses
			if (lostHandAtLeastOnce) {
				lossCount++;
			} else if (betterThanHand) {
				winCount++;
			//} else if (equalToHand) {
				//tieCount++;
			}
			

		}
	
	
	
		
		double percentage_as_double = 100.0 * ((winCount * 1.0)/(winCount + lossCount));
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
