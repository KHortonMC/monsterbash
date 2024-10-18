package monsterbash.Cards;

import monsterbash.graphics.Rect;
import monsterbash.graphics.Vector2;

public class CardHand {
    GameCard[] hand;
    Rect bounding;
    double rotation;
    CardDeck deck;

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
                Vector2 drawPos;
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

    public GameCard selectCard(int i) {
        if (hand[i] != null) {
            hand[i].setSelected(true);
            return hand[i];
        }
        return null;
    }

    public void deselectAll() {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null) {
                hand[i].setSelected(false);
            }
        }
    }
}