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
    Button drawButton = null;
    Button attackButton = null;

    public MonsterBash() {
        board = new MonsterBoard();
        setupNewGame();

        drawButton = new Button("Draw");
        drawButton.setLayoutX(boardWidth * 0.8);
        drawButton.setLayoutY(boardHeight * 0.9);
        drawButton.setOnAction(e -> {
            drawMana(drawButton);
        });
        Main.getRoot().getChildren().add(drawButton);

        draftButton = new Button("Draft Monster");
        draftButton.setLayoutX(boardWidth * 0.8);
        draftButton.setLayoutY(boardHeight * 0.9);
        draftButton.setOnAction(e -> {
            draftMonsters(draftButton);
        });
        draftButton.setVisible(false);
        Main.getRoot().getChildren().add(draftButton);

        attackButton = new Button("Attack!");
        attackButton.setLayoutX(boardWidth * 0.8);
        attackButton.setLayoutY(boardHeight * 0.9);
        attackButton.setOnAction(e -> {
            attackMonsters(attackButton);
        });
        attackButton.setVisible(false);
        Main.getRoot().getChildren().add(attackButton);
    }

    public void setupNewGame() {
        for (int i = 0; i < 5; i++) {
            board.drawPlayerMana();
            board.drawEnemyMana();
            board.drawDraftMonster();
        }
    }

    public void drawMana(Button button) {
        board.drawPlayerMana();
        drawButton.setVisible(false);
        draftButton.setVisible(true);
    }

    public void draftMonsters(Button button) {
        board.draftPlayerMonsters();
        board.discardPlayerMana();
        draftButton.setVisible(false);
        attackButton.setVisible(true);
    }

    public void attackMonsters(Button button) {
        //TODO: Some attack logic
        attackButton.setVisible(false);
        drawButton.setVisible(true);
        doEnemyTurn();
    }

    public void doEnemyTurn() {
        for (int i = 0; i < 5; i++) {
            board.drawDraftMonster();
        }
        board.drawEnemyMana();
        board.selectEnemyMana();
        board.draftEnemyMonsters();
        // TODO: attack logic
        for (int i = 0; i < 5; i++) {
            board.drawDraftMonster();
        }
    }

    public void runGame() {}

    public static void handleButton(Object clickedObject) {
        if (clickedObject instanceof GameCard) {
            ((GameCard) clickedObject).toggleSelected();
        }
    }
}
