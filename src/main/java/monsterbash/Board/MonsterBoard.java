package monsterbash.Board;

import javafx.scene.canvas.GraphicsContext;
import monsterbash.Cards.*;
import monsterbash.gameobject.GameObject;
import monsterbash.graphics.Rect;

import java.util.Random;

public class MonsterBoard extends GameObject {
    static Rect playerMonsterArea = new Rect(MonsterBash.boardWidth*0.1, MonsterBash.boardHeight * 0.55, MonsterBash.boardWidth * 0.7, MonsterBash.boardHeight*0.2);
    static Rect enemyMonsterArea = new Rect(MonsterBash.boardWidth*0.1, MonsterBash.boardHeight * 0.22, MonsterBash.boardWidth * 0.7, MonsterBash.boardHeight*0.2);
    static Rect playerManaArea = new Rect(MonsterBash.boardWidth*0.05, MonsterBash.boardHeight * 0.78, MonsterBash.boardWidth * 0.7, MonsterBash.boardHeight*0.2);
    static Rect enemyManaArea = new Rect(MonsterBash.boardWidth*0.05, MonsterBash.boardHeight * 0.0, MonsterBash.boardWidth * 0.7, MonsterBash.boardHeight*0.2);
    static Rect draftMonsterArea = new Rect(MonsterBash.boardWidth*0.85, MonsterBash.boardHeight * 0.1, MonsterBash.boardWidth * 0.2, MonsterBash.boardHeight*0.8);

    ManaHand playerMana;
    ManaHand enemyMana;

    MonsterHand playerMonsters;
    MonsterHand enemyMonsters;
    CardHand draftHand;

    MonsterDeck monsterDeck;
    ManaDeck manaDeck;
    Random random;

    public MonsterBoard() {
        this.setVisible(false); // TODO, make this true and draw a board
        this.setActive(true);

        random = new Random();

        monsterDeck = new MonsterDeck();
        monsterDeck.buildDeck();
        monsterDeck.shuffle();

        manaDeck = new ManaDeck();
        manaDeck.buildDeck();
        manaDeck.shuffle();

        playerMana = new ManaHand(manaDeck, 7, playerManaArea, 0);
        enemyMana = new ManaHand(manaDeck, 7, enemyManaArea, 180);
        draftHand = new CardHand(monsterDeck, 5, draftMonsterArea, 90);
        playerMonsters = new MonsterHand(monsterDeck, draftHand, 5, playerMonsterArea, 0);
        enemyMonsters = new MonsterHand(monsterDeck, draftHand,5, enemyMonsterArea, 180);
    }

    public void drawPlayerMana() { playerMana.drawCard(); }
    public void discardPlayerMana() { playerMana.discardCard(); }
    public void drawEnemyMana() { enemyMana.drawCard(); }
    public void discardEnemyMana() { enemyMana.discardCard(); }
    public GameCard drawDraftMonster() { return draftHand.drawCard(); }
    public void draftPlayerMonsters() { playerMonsters.draftMonsters(); }

    public void selectEnemyMana() {
        MonsterCard card = (MonsterCard) draftHand.selectCard(random.nextInt(5));
        if (card != null) {
            if (enemyMana.selectCardValue(card.getStats().cost)) {
                if (enemyMonsters.draftMonsters() != null) {
                    discardEnemyMana();
                }
            }
        }
        draftHand.deselectAll();
        enemyMana.deselectAll();
        enemyMonsters.deselectAll();
    }

    public void fillDraftMonsters() {
        GameCard card;
        do {
            card = drawDraftMonster();
        } while (card != null);
    }

    public void update() {
        super.update();
    }

    public void draw(GraphicsContext gc) {
        super.draw(gc);
        // TODO: draw the board
    }
}
