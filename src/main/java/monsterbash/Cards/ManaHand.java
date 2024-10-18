package monsterbash.Cards;

import monsterbash.graphics.Rect;

public class ManaHand extends CardHand {
    public ManaHand(CardDeck deck, int handSize, Rect bounding, double rotation) {
        super(deck, handSize, bounding, rotation);
    }

    public boolean selectCardValue(int targetValue) {
        int curValue = 0;
        for (GameCard c : hand) {
            if (c instanceof ManaCard mc) {
                mc.setSelected(true);
                // TODO run logic
                curValue++;
                if (curValue >= targetValue) return true;
            }
        }
        return false;
    }

}
