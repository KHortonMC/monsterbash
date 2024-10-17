package monsterbash;

import java.util.LinkedList;

public class ManaDeck extends CardDeck {
    @Override
    public void buildDeck() {
        for (ManaCard.Suit suit : ManaCard.Suit.values()) {
            for (int value = 1; value < 14; value++) {
                ManaCard card = new ManaCard(value, suit);
                card.setVisible(false);
                cardDeck.add(card);
            }
        }
    }
}