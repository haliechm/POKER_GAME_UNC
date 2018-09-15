package a2;

// NEED TWOPAIR,HANDVALUE, HANDRANK, COMPARETO
// ONEPAIR IS MESSED UP
public class PokerHandImpl implements PokerHand {
	
	Card[] hand;
	
public PokerHandImpl(Card[] cards) {
	Card [] handClone = cards.clone();
	hand = new Card[cards.length];
	for (int i = 0; i < cards.length; i++) {
		for (int j = i + 1; j < hand.length; j++) {
			if (cards[i].getRank() > cards[j].getRank()) {
				Card tmp = cards[i];
				cards[i] = cards[j];
				cards[j] = tmp;
			}
		}
	}
	hand = cards;
}
		
	// RETURNS AN ARRAY OF THE FIVE CARDS IN THE HAND (use to make an array of the cards passed in)
	public Card[] getCards() {
		return hand;
	}
	
	// RETURNS TRUE IF OTHER CARD MATCHES ANY CARD IN HAND (in both suit and rank)
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
	
	// RETURNS TRUE IS HAND IS ONE PAIR
	public boolean isOnePair() {
		boolean isOnePair = false;
		// 1
		if (hand[0].getRank() == hand[1].getRank()
				&& hand[0].getRank() != hand[2].getRank()
				&& hand[0].getRank() != hand[3].getRank()
				&& hand[0].getRank() != hand[4].getRank()
				) {
			isOnePair = true;
			return isOnePair;
		}
		// 2
		if (hand[1].getRank() == hand[2].getRank()
				&& hand[1].getRank() != hand[0].getRank()
				&& hand[1].getRank() != hand[3].getRank()
				&& hand[1].getRank() != hand[4].getRank()
				) {
			isOnePair = true;
			return isOnePair;
		}
		// 3
		if (hand[2].getRank() == hand[3].getRank()
				&& hand[2].getRank() != hand[0].getRank()
				&& hand[2].getRank() != hand[1].getRank()
				&& hand[2].getRank() != hand[4].getRank()
				) {
			isOnePair = true;
			return isOnePair;
		}
		// 4
		if (hand[3].getRank() == hand[4].getRank()
				&& hand[3].getRank() != hand[0].getRank()
				&& hand[3].getRank() != hand[1].getRank()
				&& hand[3].getRank() != hand[2].getRank()
				) {
			isOnePair = true;
			return isOnePair;
		}
		return isOnePair;
		}
	
	// returns true is the hand is a two pair hand
	public boolean isTwoPair() {
		return true;
		}
	
	// RETURNS TRUE IS THREE OF A KIND
		boolean isThreeOfAKind = false;
		
		public boolean isThreeOfAKind() {
			if (hand[0].getRank() == hand[1].getRank() 
					&& hand[0].getRank() == hand[2].getRank()
					&& hand[0].getRank() != hand[3].getRank()
					&& hand[0].getRank() != hand[4].getRank()
					&& hand[3].getRank() != hand[4].getRank()
					) {
					isThreeOfAKind = true;
					return isThreeOfAKind;
				} else if (hand[2].getRank() == hand[3].getRank() 
						&& hand[2].getRank() == hand[4].getRank()
						&& hand[2].getRank() != hand[0].getRank()
						&& hand[2].getRank() != hand[1].getRank()
						&& hand[0].getRank() != hand[1].getRank()
						) {
						isThreeOfAKind = true;
						return isThreeOfAKind;
				} else if (hand[1].getRank() == hand[2].getRank()
						&& hand[1].getRank() == hand[3].getRank()
						&& hand[1].getRank() != hand[0].getRank()
						&& hand[1].getRank() != hand[4].getRank()
						&& hand[0].getRank() != hand[4].getRank()
						) {
						isThreeOfAKind = true;
						return isThreeOfAKind;
				}
				return isThreeOfAKind;
		}
	
	// RETURNS TRUE IF HAND IS A STRAIGHT (including ace-5)
	public boolean isStraight() {
		boolean isStraight = false;
		if (hand[hand.length - 1].getRank() == 14 
				&& hand[0].getRank() == 2 
				&& hand[1].getRank() == 3 
				&& hand[2].getRank() == 4 
				&& hand[3].getRank() == 5) {
				isStraight = true;
				return isStraight;
			
		}
		for (int i = 0; i < hand.length; i++) {
			
				if (i + 1 == hand.length || 
					hand[i].getRank() == (hand[i + 1].getRank() - 1)) {
					isStraight = true;
					
				} else {
					isStraight = false;
					return isStraight;
				}
			
		}
		return isStraight;
	}
	
	// RETURNS TRUE IF ALL CARDS ARE THE SAME SUIT (FLUSH)
	public boolean isFlush() {
			boolean isFlush = false; 
			Card.Suit wantSuit = hand[0].getSuit();
			for (int i = 1; i < hand.length; i++) {
				if (hand[i].getSuit() == wantSuit) {
					isFlush = true;
				} else {
					isFlush = false; 
					return isFlush;
				}
			}
			return isFlush;
		}
	
	// returns true if the hand is a full house
		public boolean isFullHouse() {
			boolean isFullHouse = false;
			// 1 
			if (hand[0].getRank() == hand[1].getRank()
					&& hand[0].getRank() == hand[2].getRank()
					&&hand[0].getRank() != hand[3].getRank()
					&& hand[0].getRank() != hand[4].getRank()
					&& hand[3].getRank() == hand[4].getRank()
					) {
				isFullHouse = true;
				return isFullHouse;
			}
			// 2
			if (hand[2].getRank() == hand[3].getRank()
					&& hand[2].getRank() == hand[4].getRank()
					&&hand[2].getRank() != hand[0].getRank()
					&& hand[2].getRank() != hand[1].getRank()
					&& hand[0].getRank() == hand[1].getRank()
					) {
				isFullHouse = true;
				return isFullHouse;
			} 
			return isFullHouse;
			
		}
	
	// RETURNS TRUE IF THE HAND IS FOUR OF A KIND
		boolean isFourOfAKind = false;
		public boolean isFourOfAKind() {
			if (hand[0].getRank() == hand[1].getRank() 
				&& hand[0].getRank() == hand[2].getRank() 
				&& hand[0].getRank() == hand[3].getRank()
				&& hand[0].getRank() != hand[4].getRank()
				) {
				isFourOfAKind = true;
				return isFourOfAKind;
			} else if (hand[1].getRank() == hand[2].getRank() 
					&& hand[1].getRank() == hand[3].getRank() 
					&& hand[1].getRank() == hand[4].getRank()
					&& hand[1].getRank() != hand[0].getRank()
					) {
					isFourOfAKind = true;
					return isFourOfAKind;
			}
			return isFourOfAKind;
		}

	// RETURNS TRUE IF THE HAND IS A STRAIGHT FLUSH
		public boolean isStraightFlush() {
			if (isStraight() && isFlush()) {
				return true;
			} else {
				return false;
			}
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
