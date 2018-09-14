package a2;

// ONLY getCards, contains(c), AND isStraight() IS FINISHED
// RETURNS ORDERED BY RANK ARRAY OF CARDS 
// NO CLONE? IS THAT FINE
public class PokerHandImpl implements PokerHand {
	
	Card[] hand;
	
	
	public PokerHandImpl(Card[] cards) {
		this.hand = orderByRank(cards);
		
	}
	
	// DONE
	// returns an array of the five cards in the hand
	public Card[] getCards() {
		return hand;
	}
	
	// DONE
	// returns an array of cards ordered by rank
	public Card[] orderByRank(Card[] hand) {
		for (int i = 0; i < hand.length; i++) {
			for (int j = i + 1; j < hand.length; j++) {
				if (hand[i].getRank() > hand[j].getRank()) {
					Card tmp = hand[i];
					hand[i] = hand[j];
					hand[j] = tmp;
				}
			}
		}
		return hand;
	}
	
	// DONE
	// returns true if one of the cards in the hand
	// matches in both rank and suit of the 
	// card passed in as a parameter
	public boolean contains(Card c) {
		
		for (int i = 0; i < hand.length; i++) {
			Card current = new CardImpl(hand[i].getRank(), hand[i].getSuit());
			if (current.equals(c)) {
				return true;
			} else {
				continue;
			}
		}
		return false;
	}
	
	// returns true if the hand is a one pair hand
	public boolean isOnePair() {
		return true;
		}
	
	// returns true is the hand is a two pair hand
	public boolean isTwoPair() {
		return true;
		}
	
	// returns true if the had is a three of a kind
		public boolean isThreeOfAKind() {
		return true;
		}
	
	// DONE
	// returns true if the hand is a straight (if it is a straight flush, should also return true for this)
	
	public boolean isStraight() {
		boolean issStraight = false;
			
			if (hand[hand.length - 1].getRank() == 14 && hand[0].getRank() == 2 && hand[1].getRank() == 3 && hand[2].getRank() == 4 && hand[3].getRank() == 5) {
				issStraight = true;
				return issStraight;
			
		}
		for (int i = 0; i < hand.length; i++) {
			
				if (i + 1 == hand.length || hand[i].getRank() == (hand[i + 1].getRank() - 1)) {
					issStraight = true;
					
				} else {
					issStraight = false;
					return issStraight;
				}
			
		}
		return issStraight;
	}
	
	// returns true if the hand is a flush (if it is a straight flush, should also return true for this)
		public boolean isFlush() {
		return true;
		}
	
	// returns true if the hand is a full house
		public boolean isFullHouse() {
		return true;
		}
	
	// returns true if the hand is a four of a kind
		public boolean isFourOfAKind() {
		return true;
		}
	
	// returns true if the hand is a straight flush (both straight and flush)
		public boolean isStraightFlush() {
		return true;
		}
	
	// returns the hand value
		public int getHandTypeValue() {
		return 3;
		}
	
	// returns the hand rank
		public int getHandRank() {
		return 3;
		}
	
	// returns -1 if hand value is smaller than hand passed in as other
	// returns 1 if hand value is larger than hand passed in as other
	// if hand values are equal, then: 
	// returns -1 if hand rank is smaller than hand passed in as other 
	// returns 1 if hand rank is larger than hand passed in as other
	// if hand values and hand ranks are equal, then: 
	// returns 0
		public int compareTo(PokerHand other) {
		return -1;
		}
	
	// returns pair?
		//private int find_pair_starting_at(int index) {
		//return 3;
		//}
	
}
