package monsterbash.Cards;

import monsterbash.graphics.Rect;
import monsterbash.graphics.Vector2;

public class MonsterHand extends CardHand {
    CardHand draftable = null;
    public MonsterHand(CardDeck deck, CardHand draftable, int handSize, Rect bounding, double rotation) {
        super(deck, handSize, bounding, rotation);
        this.draftable = draftable;
    }

    public GameCard draftMonsters() {
        GameCard card = null;
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == null) { // found a free spot in the hand
                for (int j = 0; j < draftable.hand.length; j++) {
                    if (draftable.hand[j] != null && draftable.hand[j].isSelected()) {
                        hand[i] = draftable.hand[j];
                        draftable.hand[j] = null;

                        hand[i].setRotation(this.rotation);
                        Vector2 drawPos = new Vector2(bounding.getX() + ((MonsterCard.cardWidth) * i) + i * 5, bounding.getY());
                        hand[i].setPosition(drawPos);
                        card = hand[i];
                    }
                }
            }
        }
        return card;
    }

}
