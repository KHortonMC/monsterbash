package monsterbash.Board;

public class MonsterBash {
    public static double boardWidth = 800;
    public static double boardHeight = 600;

    public static final int fontSize = 10;

    static MonsterBoard board = null;

    public static void setupGame() {
        board = new MonsterBoard();
    }
}
