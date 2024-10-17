package monsterbash.Cards;

import java.util.LinkedList;

public abstract class CardDeck {
    LinkedList<GameCard> cardDeck = new LinkedList<>();

    public abstract void buildDeck();

    void shuffle() {
        // TODO: some shuffle logic
    }

    public GameCard drawCard() {
        GameCard retVal = cardDeck.getFirst();
        cardDeck.removeFirst();
        return retVal;
    }

    void discard(GameCard card) {
        cardDeck.addLast(card);
    }
}
