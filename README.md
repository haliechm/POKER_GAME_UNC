# Assignment 2

## Basic objects

This assignment will require you to create a few basic classes that implement an interface. The interfaces
are provided in the skeleton code in this repository and represent a standard playing card, a standard deck of 52 cards, 
and a poker hand (i.e., a collection of 5 cards that can be categorized by the rank/suit relationships of the cards).

## Novice: CardImpl as implementation of Card

Your implementation of the Card interface should be called CardImpl. 

The Card interface includes the following methods:
* int getRank()
  * Returns the "rank" of a playing card. Each card should have a rank between 2 and 14. The rank value of the face cards (i.e., Jack, Queen, King, and Ace) should be 11, 12, 13, and 14.
* Card.Suit getSuit()
  * Returns the "suit" of a playing card (i.e., spades, hearts, diamonds, or clubs). Each card should have a suit that is one of the enumerated symbols defined in the Card.Suit enumeration.
* String toString()
  * Returns a string representation of the card. This should be in the form of "Rank of Suit" where "Rank" is the word representation of each rank. The non-face card ranks should be in the form of their English word equivalent with an initial capital letter (i.e., "Two", "Three", etc.). The face card ranks should be in the form of their names with an initial capital letter (i.e., "Jack", "Queen", "King", "Ace"). The string representation of the suit should be one of "Spades", "Hearts", "Diamonds", or "Clubs". For example, a card with rank value 12 and suit value Card.HEARTS should produce the string: "Queen of Hearts".
* boolean equals(Card other)
  * Returns true if the card passed in as _other_ has the same rank and suit values.
  
CardImpl should provide a constructor with the following declaration:
```
public CardImpl(int rank, Card.Suit suite)
```

## Adept: PokerHandImpl as implementation of PokerHand

Your implementation of the PokerHand interface should be called PokerHandImpl.

A poker hand is a collection of 5 cards which have a _hand value_ and a _hand rank_ depending on the relationship between the ranks and suits of the cards. Below is a description of each kind of poker hand and its corresponding hand value and hand rank.

* High card
  * A hand that is not recognized as any of the other hand types. This hand should have a hand value of 1 and a hand rank that corresponds to the highest ranked card in the hand.
* One Pair
  * A hand that contains exactly two cards of different suits with the same rank and three cards other cards that do not match each other or the paired cards in rank. Hand value should be 2 and hand rank should be the rank of the paired cards.
* Two Pair
  * A hand that contains exactly two different pairs (i.e., two cards that match in rank, another two cards that match a different rank, and a fifth card that does not match in rank with either of the two pairs). The hand value of two pair is 3 and the hand rank is the rank of the higher of the two pairs.
* Three of a Kind
  * A hand that contains exactly three cards that match in rank and two additional cards that do not match that rank or each other. Hand value should be 4 and hand rank should be the rank of the three cards that match.
* Straight
  * A hand that contains five cards of consecutive rank. The hand value of a straight is 5 and the hand rank is the rank of highest card in the sequence. Note, there is a special straight called "the wheel" which is comprised of the sequence: Ace, 2, 3, 4, 5. In this case, although the ace has a rank value of 14, it acts as if its rank was 1. In the case of the wheel, hand rank should be 5.
* Flush
  * A hand with any five cards that match in suit. The hand value of a flush is 6 and the hand rank is the rank of the highest ranked card in the hand.
* Full House
  * A hand with three cards that match in rank as in a three of a kind with the other two cards in the hand also matching in rank as in a pair. The hand value of a full house is 7 and the hand rank is the rank of the three cards that match.
* Four of a Kind
  * A hand that contains fours cards that all match in rank with an arbitrary fifth card. The hand value should be 8 and the hand rank is the rank of the four matching cards.
* Straight Flush
  * A hand that is both a straight and a flush. The hand value should be 9 and the hand rank is the rank of the highest card in the hand.

The PokerHand interface defines the following methods that should be implemented by your PokrHandImpl class:

* Card[] getCards()
  * Returns as an array the five cards in the hand.
* boolean contains(Card c)
  * Returns true if one of the cards in the hand matches in rank and suit the card passed in as a parameter.
* boolean isOnePair()
  * Indicates whether the hand is a one pair hand.
* boolean isTwoPair()
  * Indicates whether the hand is a two pair hand.
* boolean isThreeOfAKind()
  * Indicates whether the hand is a three of a kind.
* boolean isStraight()
  * Indicates whether the hand is a straight. Note, a hand that is a straight flush should return true for this method.
* boolean isFlush()
  * Indicates whether the hand is a flush. Note, a hand that is a straight flush should return true for this method.
* boolean isFullHouse()
  * Indicates whether the hand is a full house.
* boolean isFourOfAKind()
  * Indicates whether the hand is a four of a kind.
* boolean isStraightFlush()
  * Indicates whether the hand is a straight flush (i.e., both a straight and a flush). 
* int getHandTypeValue()
  * Returns the hand value of the hand as described above.
* int getHandRank()
  * Returns the hand rank of the hand as described above.
* int compareTo(PokerHand other)
  * Compares a hand with the hand passed in as _other_. Returns -1 if the hand value is smaller and 1 if the hand value is larger than the hand passed in as _other_. If the hand values are equal, then returns -1 if the hand rank is smaller or 1 if the hand rank is larger. If both hand value and hand rank are the same, returns 0.


