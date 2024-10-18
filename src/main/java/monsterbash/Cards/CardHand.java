package monsterbash.Cards;

import monsterbash.graphics.Rect;
import monsterbash.graphics.Vector2;

public class CardHand {
    GameCard[] hand = null;
    Rect bounding = null;
    double rotation = 0;
    CardDeck deck = null;

    public CardHand(CardDeck deck, int handSize, Rect bounding, double rotation) {
        this.deck = deck;
        this.bounding = bounding;
        this.rotation = rotation;
        this.hand = new GameCard[handSize];
    }

    public GameCard drawCard() {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == null) {
                hand[i] = deck.drawCard();
                hand[i].setRotation(rotation);
                Vector2 drawPos = null;
                if (rotation == 90 || rotation == 270) {
                    drawPos = new Vector2(bounding.getX(), bounding.getY() + ((GameCard.cardWidth) * i) + i * 5);
                } else {
                    drawPos = new Vector2(bounding.getX() + ((GameCard.cardWidth) * i) + i * 5, bounding.getY());
                }
                hand[i].setPosition(drawPos);
                return hand[i];
            }
        }
        return null;
    }

    public void discardCard() {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null && hand[i].isSelected()) {
                deck.discardCard(hand[i]);
                hand[i] = null;
            }
        }
    }

    public void selectCard(int i) {
        if (hand[i] != null) {
            hand[i].setSelected(true);
        }
    }
}