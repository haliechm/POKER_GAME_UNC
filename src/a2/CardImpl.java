package a2;

public class CardImpl implements Card {
	
	int rank;
	Card.Suit suite;

	public CardImpl(int rank, Card.Suit suite) {
		this.rank = rank;
		this.suite = suite;
		
	}
	
	// returns rank value of card (2 - 14)
	// jack through king?
	public int getRank() {
		return rank;
	}
	
	// returns suit of playing card (enumerated: spades, clubs, hearts, or diamonds)
	public Card.Suit getSuit() {
		return suite;
	}
	
	// returns Rank of Suit (rank is written at "Two" or "Five" + "of" + Suit in string form)
	// need capital letters
	// rank is still in number form
	public String toString() {
		return (numToString(getRank()) + " of " + getSuit());
	}
	
	// returns true if other card has same rank and suit values
	public boolean equals(Card other) {
		return ((getRank() == other.getRank()) && (getSuit() == other.getSuit()));
	}
	
	private String numToString(int numb) {
		if (numb == 2) {
			return "Two";
		} else if (numb == 3) {
			return "Three";
		} else if (numb == 4) {
			return "Four";
		} else if (numb == 5) {
			return "Five";
		} else if (numb == 6) {
			return "Six";
		} else if (numb == 7) {
			return "Seven";
		} else if (numb == 8) {
			return "Eight";
		} else if (numb == 9) {
			return "Nine";
		} else if (numb == 10) {
			return "Ten";
		} else if (numb == 11) {
			return "Jack";
		} else if (numb == 12) {
			return "Queen";
		} else if (numb == 13) {
			return "King";
		} else if (numb == 14) {
			return "Ace";
		} else {
			// not going to happen
			return "NO CARD";
		}
	}

	 
}
