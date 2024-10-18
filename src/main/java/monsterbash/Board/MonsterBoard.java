package monsterbash.Board;

import javafx.scene.canvas.GraphicsContext;
import monsterbash.Cards.*;
import monsterbash.gameobject.GameObject;
import monsterbash.graphics.Rect;

public class MonsterBoard extends GameObject {
    static Rect playerMonsterArea = new Rect(MonsterBash.boardWidth*0.1, MonsterBash.boardHeight * 0.55, MonsterBash.boardWidth * 0.7, MonsterBash.boardHeight*0.2);
    static Rect enemyMonsterArea = new Rect(MonsterBash.boardWidth*0.1, MonsterBash.boardHeight * 0.22, MonsterBash.boardWidth * 0.7, MonsterBash.boardHeight*0.2);
    static Rect playerManaArea = new Rect(MonsterBash.boardWidth*0.05, MonsterBash.boardHeight * 0.78, MonsterBash.boardWidth * 0.7, MonsterBash.boardHeight*0.2);
    static Rect enemyManaArea = new Rect(MonsterBash.boardWidth*0.05, MonsterBash.boardHeight * 0.0, MonsterBash.boardWidth * 0.7, MonsterBash.boardHeight*0.2);
    static Rect draftMonsterArea = new Rect(MonsterBash.boardWidth*0.85, MonsterBash.boardHeight * 0.1, MonsterBash.boardWidth * 0.2, MonsterBash.boardHeight*0.8);

    CardHand playerMana = null;
    CardHand enemyMana = null;

    MonsterHand playerMonsters = null;
    MonsterHand enemyMonsters = null;
    CardHand draftHand = null;

    MonsterDeck monsterDeck = null;
    ManaDeck manaDeck = null;

    public MonsterBoard() {
        this.setVisible(false); // TODO, make this true and draw a board
        this.setActive(true);

        monsterDeck = new MonsterDeck();
        monsterDeck.buildDeck();

        manaDeck = new ManaDeck();
        manaDeck.buildDeck();

        playerMana = new CardHand(manaDeck, 7, playerManaArea, 0);
        enemyMana = new CardHand(manaDeck, 7, enemyManaArea, 180);
        draftHand = new CardHand(monsterDeck, 5, draftMonsterArea, 90);
        playerMonsters = new MonsterHand(monsterDeck, draftHand, 5, playerMonsterArea, 0);
        enemyMonsters = new MonsterHand(monsterDeck, draftHand,5, enemyMonsterArea, 180);
    }

    public GameCard drawPlayerMana() { return playerMana.drawCard(); }
    public void discardPlayerMana() { playerMana.discardCard(); }
    public GameCard drawEnemyMana() { return enemyMana.drawCard(); }
    public void discardEnemyMana() { enemyMana.discardCard(); }
    public GameCard drawDraftMonster() { return draftHand.drawCard(); }

    public GameCard draftPlayerMonsters() { return playerMonsters.draftMonsters(); }

    public void update() {
    }

    public void draw(GraphicsContext gc) {
        super.draw(gc);
        // TODO: draw the board
    }
}
