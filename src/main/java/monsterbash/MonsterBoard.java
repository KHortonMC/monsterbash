package monsterbash;

import javafx.scene.canvas.GraphicsContext;
import monsterbash.gameobject.GameObject;
import monsterbash.graphics.Vector2;

public class MonsterBoard extends GameObject {

    MonsterCard[] draftCards = new MonsterCard[5];

    public MonsterBoard() {
        this.setVisible(false); // TODO, make this true and draw a board
        this.setActive(true);
    }

    public void update() {
        for (int i = 0; i < draftCards.length; i++) {
            if (draftCards[i] == null) {
                draftCards[i] = MonsterDeck.draw();
                draftCards[i].setVisible(true);
                draftCards[i].setActive(true);
            }

            draftCards[i].setRotation(90);
            Vector2 drawPos = new Vector2(750, 50 + ((MonsterBash.cardWidth) * i));
            draftCards[i].setPosition(drawPos);
        }
    }

    public void draw(GraphicsContext gc) {
        super.draw(gc);
        // TODO: draw the board
    }
}
