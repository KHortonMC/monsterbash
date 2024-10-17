package monsterbash;

public class MonsterBash {
    public static final double cardWidth = 100;
    public static final double cardHeight = 150;
    public static final int fontSize = 10;

    static MonsterBoard board = null;

    public static void setupGame() {
        board = new MonsterBoard();
    }
}
