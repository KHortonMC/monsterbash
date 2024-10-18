package monsterbash.Board;

import javafx.scene.canvas.GraphicsContext;
import monsterbash.Cards.ManaCard;
import monsterbash.Cards.ManaDeck;
import monsterbash.Cards.MonsterCard;
import monsterbash.Cards.MonsterDeck;
import monsterbash.gameobject.GameObject;
import monsterbash.graphics.Rect;
import monsterbash.graphics.Vector2;

public class MonsterBoard extends GameObject {
    static Rect playerMonsterArea = new Rect(MonsterBash.boardWidth*0.1, MonsterBash.boardHeight * 0.55, MonsterBash.boardWidth * 0.7, MonsterBash.boardHeight*0.2);
    static Rect enemyMonsterArea = new Rect(MonsterBash.boardWidth*0.1, MonsterBash.boardHeight * 0.22, MonsterBash.boardWidth * 0.7, MonsterBash.boardHeight*0.2);
    static Rect playerManaArea = new Rect(MonsterBash.boardWidth*0.05, MonsterBash.boardHeight * 0.78, MonsterBash.boardWidth * 0.7, MonsterBash.boardHeight*0.2);
    static Rect enemyManaArea = new Rect(MonsterBash.boardWidth*0.05, MonsterBash.boardHeight * 0.0, MonsterBash.boardWidth * 0.7, MonsterBash.boardHeight*0.2);
    static Rect draftMonsterArea = new Rect(MonsterBash.boardWidth*0.85, MonsterBash.boardHeight * 0.1, MonsterBash.boardWidth * 0.2, MonsterBash.boardHeight*0.8);

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

    public boolean drawPlayerMana() {
        for (int i = 0; i < playerMana.length; i++) {
            if (playerMana[i] == null) {
                playerMana[i] = (ManaCard) manaDeck.drawCard();

                playerMana[i].setRotation(0);
                Vector2 drawPos = new Vector2(playerManaArea.getX() + ((MonsterCard.cardWidth) * i) + i * 5, playerManaArea.getY());
                playerMana[i].setPosition(drawPos);
                return true;
            }
        }
        return false;
    }

    public void discardPlayerMana() {
        for (int i = 0; i < playerMana.length; i++) {
            if (playerMana[i] != null && playerMana[i].isSelected()) {
                manaDeck.discardCard(playerMana[i]);
                playerMana[i] = null;
            }
        }
    }

    public boolean drawEnemyMana() {
        for (int i = 0; i < enemyMana.length; i++) {
            if (enemyMana[i] == null) {
                enemyMana[i] = (ManaCard) manaDeck.drawCard();

                enemyMana[i].setRotation(180);
                Vector2 drawPos = new Vector2(enemyManaArea.getX() + ((MonsterCard.cardWidth) * i) + i * 5, enemyManaArea.getY());
                enemyMana[i].setPosition(drawPos);
                return true;
            }
        }
        return false;
    }

    public boolean drawDraftMonster() {
        // draft monsters is always full
        for (int i = 0; i < draftMonsters.length; i++) {
            if (draftMonsters[i] == null) {
                draftMonsters[i] = (MonsterCard) monsterDeck.drawCard();

                draftMonsters[i].setRotation(90);
                Vector2 drawPos = new Vector2(draftMonsterArea.getX(), draftMonsterArea.getY() + ((MonsterCard.cardWidth) * i) + i * 5);
                draftMonsters[i].setPosition(drawPos);
                return true;
            }
        }
        return false;
    }

    public boolean draftPlayerMonsters() {
        boolean retValue = false;
        for (int i = 0; i < playerMonsters.length; i++) {
            if (playerMonsters[i] == null) {
                // find a monster that's selected
                for (int j = 0; j < draftMonsters.length; j++) {
                    if (draftMonsters[j] != null && draftMonsters[j].isSelected()) {
                        playerMonsters[i] = draftMonsters[j];
                        draftMonsters[j] = null;

                        playerMonsters[i].setRotation(0);
                        Vector2 drawPos = new Vector2(playerMonsterArea.getX() + ((MonsterCard.cardWidth) * i)+ i*5, playerMonsterArea.getY());
                        playerMonsters[i].setPosition(drawPos);
                        retValue = true;
                    }
                }
            }
        }
        return retValue;
    }

    void updateEnemyMonsters() {
        for (int i = 0; i < enemyMonsters.length; i++) {
            if (enemyMonsters[i] == null) {
                enemyMonsters[i] = (MonsterCard) monsterDeck.drawCard();
            }

            enemyMonsters[i].setRotation(180);
            Vector2 drawPos = new Vector2(enemyMonsterArea.getX() + ((MonsterCard.cardWidth) * i)+ i*5, enemyMonsterArea.getY());
            enemyMonsters[i].setPosition(drawPos);
        }
    }

    public void update() {
    }

    public void draw(GraphicsContext gc) {
        super.draw(gc);
        // TODO: draw the board
    }
}
