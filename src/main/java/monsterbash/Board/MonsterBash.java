package monsterbash.Board;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import monsterbash.Cards.GameCard;
import monsterbash.Main;
import monsterbash.gameobject.GameObject;

public class MonsterBash {
    public enum GameState {
        NONE,
        GAME
    }
    GameState gameState = GameState.NONE;

    public enum TurnState {
        DRAW_MANA,
        RECRUIT_MONSTER,
        MONSTER_ATTACK,
        MONSTER_DEFEND,
        RESOLVE_TURN
    }
    TurnState turnState = TurnState.DRAW_MANA;

    public enum PlayerTurnState {
        PLAYER,
        ENEMY
    }
    PlayerTurnState playerTurnState = PlayerTurnState.PLAYER;

    public static double boardWidth = 800;
    public static double boardHeight = 600;

    public static final int fontSize = 10;

    MonsterBoard board = null;
    Button draftButton = null;

    public MonsterBash() {
        board = new MonsterBoard();
        setupNewGame();
        draftButton = new Button("Draft Monster");
        draftButton.setLayoutX(boardWidth * 0.8);
        draftButton.setLayoutY(boardHeight * 0.9);
        draftButton.setOnAction(e -> {
            draftMonsters(draftButton);
        });
        Main.getRoot().getChildren().add(draftButton);
    }

    public void setupNewGame() {
        for (int i = 0; i < 5; i++) {
            board.drawPlayerMana();
            board.drawEnemyMana();
            board.drawDraftMonster();
        }
    }

    public void draftMonsters(Button button) {
        board.draftPlayerMonsters();
        board.discardPlayerMana();
    }

    public void runGame() {



    }

    public static void handleButton(Object clickedObject) {
        if (clickedObject instanceof GameCard) {
            ((GameCard) clickedObject).toggleSelected();
        }
    }
}
