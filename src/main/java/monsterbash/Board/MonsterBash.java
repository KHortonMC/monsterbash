package monsterbash.Board;

import javafx.scene.control.Button;
import monsterbash.Cards.GameCard;
import monsterbash.Main;

public class MonsterBash {
    public static double boardWidth = 800;
    public static double boardHeight = 600;

    public static final int fontSize = 10;

    MonsterBoard board;
    Button draftButton = null;
    Button drawButton = null;
    Button attackButton = null;

    public MonsterBash() {
        board = new MonsterBoard();
        setupNewGame();

        drawButton = new Button("Draw");
        drawButton.setLayoutX(boardWidth * 0.8);
        drawButton.setLayoutY(boardHeight * 0.9);
        drawButton.setOnAction(e -> drawMana());
        Main.getRoot().getChildren().add(drawButton);

        draftButton = new Button("Draft Monster");
        draftButton.setLayoutX(boardWidth * 0.8);
        draftButton.setLayoutY(boardHeight * 0.9);
        draftButton.setOnAction(e -> draftMonsters());
        draftButton.setVisible(false);
        Main.getRoot().getChildren().add(draftButton);

        attackButton = new Button("Attack!");
        attackButton.setLayoutX(boardWidth * 0.8);
        attackButton.setLayoutY(boardHeight * 0.9);
        attackButton.setOnAction(e -> attackMonsters());
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

    public void drawMana() {
        board.drawPlayerMana();
        drawButton.setVisible(false);
        draftButton.setVisible(true);
    }

    public void draftMonsters() {
        board.draftPlayerMonsters();
        board.discardPlayerMana();
        draftButton.setVisible(false);
        attackButton.setVisible(true);
    }

    public void attackMonsters() {
        //TODO: Some attack logic
        attackButton.setVisible(false);
        drawButton.setVisible(true);
        doEnemyTurn();
    }

    public void doEnemyTurn() {
        board.fillDraftMonsters();
        board.drawEnemyMana();
        board.selectEnemyMana();
        // TODO: attack logic
        board.fillDraftMonsters();
    }

    public void runGame() {}

    public static void handleButton(Object clickedObject) {
        if (clickedObject instanceof GameCard) {
            ((GameCard) clickedObject).toggleSelected();
        }
    }
}
