package monsterbash;

import monsterbash.Board.MonsterBash;
import monsterbash.gameobject.GameObject;
import monsterbash.graphics.Vector2;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    static Canvas canvas = null;
    static Group root = null;
    static Vector2 screenDelta = null;
    public static double getWindowWidth() { return Main.canvas.getWidth(); }
    public static double getWindowHeight() { return Main.canvas.getHeight(); }
    public static Vector2 getScreenDelta() { return Main.screenDelta; }
    public static Group getRoot() { return root; }
    MonsterBash monsterBash;

    // this start method came from online documents about JavaFX
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("gametemplate.fxml"));
        primaryStage.setTitle("Monster Bash!");

        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Create a Group to hold the Canvas
        Main.root = new Group();
        Main.root.getChildren().add(canvas);

        // chatGPT used for a text area
        TextArea textArea = new TextArea();
        textArea.setOpacity(0);
        textArea.setOnKeyPressed(this::handleKeyPress);
        textArea.setOnKeyReleased(this::handleKeyRelease);
        Main.root.getChildren().add(textArea);

        // Set up the Scene
        Scene scene = new Scene(root, MonsterBash.boardWidth, MonsterBash.boardHeight);
        primaryStage.setScene(scene);
        primaryStage.show();

        monsterBash = new MonsterBash();

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                update(); // Update game logic
                draw(gc); // Draw the frame
            }
        };
        gameLoop.start();
    }

    private void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) {
            case LEFT:
                screenDelta.setX(-2);
                break;
            case RIGHT:
                screenDelta.setX(2);
                break;
            case UP:
                screenDelta.setY(-2);
                break;
            case DOWN:
                screenDelta.setY(2);
                break;
            case SPACE:
            default:
                break;
        }
    }

    private void handleKeyRelease(KeyEvent event) {
        switch (event.getCode()) {
            case LEFT:
                screenDelta.setX(0);
                break;
            case RIGHT:
                screenDelta.setX(0);
                break;
            case UP:
                screenDelta.setY(0);
                break;
            case DOWN:
                screenDelta.setY(0);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        // Create a Canvas for drawing
        Main.canvas = new Canvas(MonsterBash.boardWidth, MonsterBash.boardHeight);
        Main.screenDelta = new Vector2(0,0);
        launch(args);
    }

    private void update() {
        monsterBash.runGame();
        GameObject.updateAll();
    }

    private void draw(GraphicsContext gc) {
        // clear the draw pane
        gc.setFill(Color.DARKBLUE);
        gc.fillRect(0, 0, Main.getWindowWidth(), Main.getWindowHeight());

        GameObject.drawAll(gc);
    }
}