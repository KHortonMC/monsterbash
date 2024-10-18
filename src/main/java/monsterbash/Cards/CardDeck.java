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
        retVal.setActive(true);
        retVal.setVisible(true);
        return retVal;
    }

    public void discardCard(GameCard card) {
        cardDeck.addLast(card);
        card.setActive(false);
        card.setVisible(false);
    }
}
