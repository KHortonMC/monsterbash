package monsterbash.Board;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import monsterbash.Cards.GameCard;
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

    public MonsterBash() {
        board = new MonsterBoard();

    }

    public void runGame() {


    }

    public static void handleButton(Object clickedObject) {
        if (clickedObject instanceof GameCard) {
            ((GameCard) clickedObject).toggleSelected();
        }

    }
}
