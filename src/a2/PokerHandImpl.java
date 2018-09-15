package a2;

// COMPARETO
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
	
	// RETURNS TRUE IS HAND IS ONE PAIR (and other three are all different)
	int theOnePairRank = 0;
	public boolean isOnePair() {
		boolean isOnePair = false;
		// 1
		if (hand[0].getRank() == hand[1].getRank()
				&& hand[0].getRank() != hand[2].getRank()
				&& hand[0].getRank() != hand[3].getRank()
				&& hand[0].getRank() != hand[4].getRank()
				&& hand[2].getRank() != hand[3].getRank()
				&& hand[2].getRank() != hand[4].getRank()
				&& hand[3].getRank() != hand[4].getRank()
				) {
			isOnePair = true;
			theOnePairRank = hand[0].getRank();
			return isOnePair;
		}
		// 2
		if (hand[1].getRank() == hand[2].getRank()
				&& hand[1].getRank() != hand[0].getRank()
				&& hand[1].getRank() != hand[3].getRank()
				&& hand[1].getRank() != hand[4].getRank()
				&& hand[0].getRank() != hand[3].getRank()
				&& hand[0].getRank() != hand[4].getRank()
				&& hand[3].getRank() != hand[4].getRank()
				) {
			isOnePair = true;
			theOnePairRank = hand[1].getRank();
			return isOnePair;
		}
		// 3
		if (hand[2].getRank() == hand[3].getRank()
				&& hand[2].getRank() != hand[0].getRank()
				&& hand[2].getRank() != hand[1].getRank()
				&& hand[2].getRank() != hand[4].getRank()
				&& hand[0].getRank() != hand[1].getRank()
				&& hand[0].getRank() != hand[4].getRank()
				&& hand[1].getRank() != hand[4].getRank()
				) {
			isOnePair = true;
			theOnePairRank = hand[2].getRank();
			return isOnePair;
		}
		// 4
		if (hand[3].getRank() == hand[4].getRank()
				&& hand[3].getRank() != hand[0].getRank()
				&& hand[3].getRank() != hand[1].getRank()
				&& hand[3].getRank() != hand[2].getRank()
				&& hand[0].getRank() != hand[1].getRank()
				&& hand[0].getRank() != hand[2].getRank()
				&& hand[1].getRank() != hand[2].getRank()
				) {
			isOnePair = true;
			theOnePairRank = hand[3].getRank();
			return isOnePair;
		}
		return isOnePair;
		}
	
	// RETURNS TRUE IF THE HAND IS A TWO PAIR HAND
	int theTwoPairRank = 0;
	public boolean isTwoPair() {
		boolean isTwoPair = false; 
		// 1
		if (hand[0].getRank() == hand[1].getRank()
			&& hand[2].getRank() == hand[3].getRank()
			&& hand[0].getRank() != hand[2].getRank()
			&& hand[0].getRank() != hand[3].getRank()
			&& hand[0].getRank() != hand[4].getRank()
			&& hand[2].getRank() != hand[4].getRank()
			) {
				isTwoPair = true;
				theTwoPairRank = hand[2].getRank();
				return isTwoPair;
			}
		// 2
		if (hand[1].getRank() == hand[2].getRank()
				&& hand[3].getRank() == hand[4].getRank()
				&& hand[1].getRank() != hand[3].getRank()
				&& hand[1].getRank() != hand[4].getRank()
				&& hand[1].getRank() != hand[0].getRank()
				&& hand[3].getRank() != hand[0].getRank()
				) {
					isTwoPair = true;
					theTwoPairRank = hand[3].getRank();
					return isTwoPair;
		}
		// 3
		if (hand[0].getRank() == hand[1].getRank()
				&& hand[3].getRank() == hand[4].getRank()
				&& hand[0].getRank() != hand[3].getRank()
				&& hand[0].getRank() != hand[4].getRank()
				&& hand[0].getRank() != hand[2].getRank()
				&& hand[3].getRank() != hand[2].getRank()
				) {
					isTwoPair = true;
					theTwoPairRank = hand[3].getRank();
					return isTwoPair;
				}
		return isTwoPair;
		}
	
	// RETURNS TRUE IS THREE OF A KIND (three of same rank, and other two are different)
		boolean isThreeOfAKind = false;
		int theThreeKindRank = 0; 
		
		public boolean isThreeOfAKind() {
			if (hand[0].getRank() == hand[1].getRank() 
					&& hand[0].getRank() == hand[2].getRank()
					&& hand[0].getRank() != hand[3].getRank()
					&& hand[0].getRank() != hand[4].getRank()
					&& hand[3].getRank() != hand[4].getRank()
					) {
					isThreeOfAKind = true;
					theThreeKindRank = hand[0].getRank();
					return isThreeOfAKind;
				} else if (hand[2].getRank() == hand[3].getRank() 
						&& hand[2].getRank() == hand[4].getRank()
						&& hand[2].getRank() != hand[0].getRank()
						&& hand[2].getRank() != hand[1].getRank()
						&& hand[0].getRank() != hand[1].getRank()
						) {
						isThreeOfAKind = true;
						theThreeKindRank = hand[2].getRank();
						return isThreeOfAKind;
				} else if (hand[1].getRank() == hand[2].getRank()
						&& hand[1].getRank() == hand[3].getRank()
						&& hand[1].getRank() != hand[0].getRank()
						&& hand[1].getRank() != hand[4].getRank()
						&& hand[0].getRank() != hand[4].getRank()
						) {
						isThreeOfAKind = true;
						theThreeKindRank = hand[1].getRank();
						return isThreeOfAKind;
				}
				return isThreeOfAKind;
		}
	
	// RETURNS TRUE IF HAND IS A STRAIGHT (including ace-5)
	int theIsStraightRank = 0;
	public boolean isStraight() {
		boolean isStraight = false;
		if (hand[hand.length - 1].getRank() == 14 
				&& hand[0].getRank() == 2 
				&& hand[1].getRank() == 3 
				&& hand[2].getRank() == 4 
				&& hand[3].getRank() == 5) {
				isStraight = true;
				//theIsStraightRank = 5;
				return isStraight;
			
		}
		for (int i = 0; i < hand.length; i++) {
			
				if (i + 1 == hand.length || 
					hand[i].getRank() == (hand[i + 1].getRank() - 1)) {
					isStraight = true;
					//theIsStraightRank = hand[i].getRank();
					
				} else {
					isStraight = false;
					return isStraight;
				}
			
		}
		if (hand[4].getRank() == 14) {
			theIsStraightRank = 5;
		} else {
		theIsStraightRank = hand[4].getRank();
		}
		return isStraight;
	}
	
	// RETURNS TRUE IF ALL CARDS ARE THE SAME SUIT (FLUSH)
	int theIsFlushRank = 0;
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
			theIsFlushRank = hand[4].getRank();
			return isFlush;
		}
	
	// RETURNS TRUE IF THE HAND IS A FULL HOUSE (3 same rank, 2 diff same rank)
	int theIsFullHouseRank = 0;
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
				theIsFullHouseRank = hand[0].getRank();
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
				theIsFullHouseRank = hand[2].getRank();
				return isFullHouse;
			} 
			return isFullHouse;
			
		}
	
	// RETURNS TRUE IF THE HAND IS FOUR OF A KIND (four of same rank)
		boolean isFourOfAKind = false;
		int theIsFourKindRank = 0;
		public boolean isFourOfAKind() {
			if (hand[0].getRank() == hand[1].getRank() 
				&& hand[0].getRank() == hand[2].getRank() 
				&& hand[0].getRank() == hand[3].getRank()
				&& hand[0].getRank() != hand[4].getRank()
				) {
				isFourOfAKind = true;
				theIsFourKindRank = hand[0].getRank();
				return isFourOfAKind;
			} else if (hand[1].getRank() == hand[2].getRank() 
					&& hand[1].getRank() == hand[3].getRank() 
					&& hand[1].getRank() == hand[4].getRank()
					&& hand[1].getRank() != hand[0].getRank()
					) {
					isFourOfAKind = true;
					theIsFourKindRank = hand[1].getRank();
					return isFourOfAKind;
			}
			return isFourOfAKind;
		}

	// RETURNS TRUE IF THE HAND IS A STRAIGHT FLUSH
		int theIsStraightFlushRank = 0;
		public boolean isStraightFlush() {
			if (isStraight() && isFlush()) {
				
				if (hand[4].getRank() == 14) {
					theIsStraightFlushRank = 5;
				} else {
				theIsStraightFlushRank = hand[4].getRank();
				}
				return true;
			} else {
				return false;
			}
		}
	
	// RETURNS THE HAND VALUE
		public int getHandTypeValue() {
		int handValue = 1;
		if (isOnePair()) {
			handValue = 2;
			return handValue;
		}
		if (isTwoPair()) {
			handValue = 3;
			return handValue;
		}
		if (isThreeOfAKind()) {
			handValue = 4;
			return handValue;
		}
		if (isStraight()) {
			handValue = 5;
			return handValue;
		}
		if (isFlush()) {
			handValue = 6;
			return handValue;
		}
		if (isFullHouse()) {
			handValue = 7;
			return handValue;
		}
		if (isFourOfAKind()) {
			handValue = 8;
			return handValue;
		}
		if (isStraightFlush()) {
			handValue = 9;
			return handValue;
		}
		
		// only happens if hand is not any of the above types
		return handValue;
			
		}
	
	// RETURNS THE HAND RANK
		public int getHandRank() {
			int handRank = 0;
			
			if (isOnePair()) {
				handRank = theOnePairRank;
				return handRank;
			}
			
			if (isTwoPair()) {
				handRank = theTwoPairRank;
				return handRank;
			}
			
			if (isThreeOfAKind()) {
				handRank = theThreeKindRank;
				return handRank;
			}
			
			if (isStraight()) {
				handRank = theIsStraightRank;
				return handRank;
			}
			
			if (isFlush()) {
				handRank = theIsFlushRank;
				return handRank;
			}
			
			if (isFullHouse()) {
				handRank = theIsFullHouseRank;
				return handRank;
			}
			
			if (isFourOfAKind()) {
				handRank = theIsFourKindRank;
				return handRank;
			}
			
			if (isStraightFlush()) {
				handRank = theIsStraightFlushRank;
				return handRank;
			}
			
			// only happens if hand is not any of the above types
			handRank = hand[4].getRank();
			return handRank;
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
