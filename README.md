# Assignment 2

## Basic objects

This assignment will require you to create a few basic classes that implement an interface. The interfaces
are provided in the skeleton code in this repository and represent a standard playing card, a standard deck of 52 cards, 
and a poker hand (i.e., a collection of 5 cards that can be categorized by the rank/suit relationships of the cards).

# Novice: CardImpl as implementation of Card

Your implementation of the Card interface should be called CardImpl. 

The Card interface includes the following methods:
* int getRank()
  * Returns the "rank" of a playing card. Each card should have a rank between 2 and 14. The rank value of the face cards (i.e., Jack, Queen, King, and Ace) should be 11, 12, 13, and 14.
* Card.Suit getSuit()
  * Returns the "suit" of a playing card. Each card should have a suit that is one of the enumerated symbols defined in the Card.Suit enumeration.
* String toString()
  * Returns a string representation of the card. This should be in the form of "Rank of Suit" where "Rank" is the word representation of each rank. The non-face card ranks should be in the form of their English word equivalent with an initial capital letter (i.e., "Two", "Three", etc.). The face card ranks should be in the form of their names with an initial capital letter (i.e., "Jack", "Queen", "King", "Ace"). The string representation of the suit should be one of "Spades", "Hearts", "Diamonds", or "Clubs". For example, a card with rank value 12 and suit value Card.HEARTS should produce the string: "Queen of Hearts".
* boolean equals(Card other)
  * Returns true if the card passed in as _other_ has the same rank and suit values.
  
CardImpl should provide a constructor with the following declaration:
```
public CardImpl(int rank, Card.Suit suite)
```

# Adept: PokerHandImpl as implementation of PokerHand

Your implementation of the PokerHand interface should be called PokerHandImpl.

A poker hand is a collection of 5 cards which have a _hand value_ and a _hand rank_ depending on the relationship between the ranks and suits of the cards. Below is a description of each kind of poker hand and its corresponding hand value and hand rank.

* High card
  * A hand that is not recognized as any of the other hand types. This hand should have a hand value of 1 and a hand rank that corresponds to the highest ranked card in the hand.
* One Pair
  * A hand that contains exactly two cards of different suits with the same rank and three cards that do not match each other or the paired cards in rank. Hand value should be 2
* Two Pair
  * A hand that contains exactly two different pairs (i.e., two cards that match in rank, another two cards that match a different rank, and a fifth card that does not match in rank with either of the two pairs).
* Three of a Kind
  * A hand that contains exactly three cards that match in rank and two additional cards that do not match that rank or each other.
* Straight
  * A hand that contains five cards of consecutive rank. Note, there is a special 
