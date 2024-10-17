package monsterbash;

import javafx.scene.canvas.GraphicsContext;
import monsterbash.gameobject.GameObject;
import monsterbash.graphics.Vector2;

public class MonsterBoard extends GameObject {

    MonsterCard[] draftMonsters = new MonsterCard[5];
    MonsterCard[] playerMonsters = new MonsterCard[5];
    MonsterCard[] enemyMonsters = new MonsterCard[5];

    ManaCard[] playerMana = new ManaCard[7];
    ManaCard[] enemyMana = new ManaCard[7];

    MonsterDeck monsterDeck = null;
    ManaDeck manaDeck = null;

    public MonsterBoard() {
        this.setVisible(false); // TODO, make this true and draw a board
        this.setActive(true);

        monsterDeck = new MonsterDeck();
        monsterDeck.buildDeck();

        manaDeck = new ManaDeck();
        manaDeck.buildDeck();
    }

    void updatePlayerMana() {
        for (int i = 0; i < playerMana.length; i++) {
            if (playerMana[i] == null) {
                playerMana[i] = (ManaCard) manaDeck.draw();
                playerMana[i].setVisible(true);
                playerMana[i].setActive(true);
            }
            Vector2 drawPos = new Vector2(850, 20 + ((MonsterBash.cardWidth) * i));
            playerMana[i].setPosition(drawPos);
        }
    }

    void updateEnemyMana() {
        for (int i = 0; i < enemyMana.length; i++) {
            if (enemyMana[i] == null) {
                enemyMana[i] = (ManaCard) manaDeck.draw();
                enemyMana[i].setVisible(true);
                enemyMana[i].setActive(true);
            }
            enemyMana[i].setRotation(180);
            Vector2 drawPos = new Vector2(50, 20 + ((MonsterBash.cardWidth) * i));
            enemyMana[i].setPosition(drawPos);
        }
    }

    void updateDraftMonsters() {
        for (int i = 0; i < draftMonsters.length; i++) {
            if (draftMonsters[i] == null) {
                draftMonsters[i] = (MonsterCard) monsterDeck.draw();
                draftMonsters[i].setVisible(true);
                draftMonsters[i].setActive(true);
            }

            draftMonsters[i].setRotation(90);
            Vector2 drawPos = new Vector2(750, 50 + ((MonsterBash.cardWidth) * i));
            draftMonsters[i].setPosition(drawPos);
        }
    }

    void updatePlayerMonsters() {
        for (int i = 0; i < playerMonsters.length; i++) {
            if (playerMonsters[i] == null) {
                playerMonsters[i] = (MonsterCard) monsterDeck.draw();
                playerMonsters[i].setVisible(true);
                playerMonsters[i].setActive(true);
            }

            playerMonsters[i].setRotation(0);
            Vector2 drawPos = new Vector2(50 + ((MonsterBash.cardWidth) * i), 350);
            playerMonsters[i].setPosition(drawPos);
        }
    }

    void updateEnemyMonsters() {
        for (int i = 0; i < enemyMonsters.length; i++) {
            if (enemyMonsters[i] == null) {
                enemyMonsters[i] = (MonsterCard) monsterDeck.draw();
                enemyMonsters[i].setVisible(true);
                enemyMonsters[i].setActive(true);
            }

            enemyMonsters[i].setRotation(180);
            Vector2 drawPos = new Vector2(150 + ((MonsterBash.cardWidth) * i), 150);
            enemyMonsters[i].setPosition(drawPos);
        }
    }

    public void update() {
        updateDraftMonsters();
        updatePlayerMonsters();
        updateEnemyMonsters();
        updatePlayerMana();
        updateEnemyMana();
    }

    public void draw(GraphicsContext gc) {
        super.draw(gc);
        // TODO: draw the board
    }
}
