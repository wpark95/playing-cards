package com.tlglearning.cards.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Deck implements Iterable<Card> {

  private final List<Card> cards;

  private Random defaultRng;

  public Deck() {
    Suit[] suits = Suit.values();
    Rank[] ranks = Rank.values();
    cards = new ArrayList<>(suits.length * ranks.length);
    for (Suit suit : suits) {
      for (Rank rank : ranks) {
        Card card = new Card(rank, suit);
        cards.add(card);
      }
    }
  }

  public void shuffle() {
    if (defaultRng == null) {
      defaultRng = new Random();
    }
    shuffle(defaultRng);
  }

  public void shuffle(Random rng) {
    Collections.shuffle(cards, rng);
  }

  public void sort() {
    sort(null);
  }

  public void sort(Comparator<Card> comparator) {
    cards.sort(comparator);
  }

  @Override
  public Iterator<Card> iterator() {
    return Collections.unmodifiableList(cards).iterator();
  }

  @Override
  public String toString() {
    return cards.toString();
  }

  public int size() {
    return cards.size();
  }

}
