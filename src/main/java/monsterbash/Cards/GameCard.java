package monsterbash.Cards;

import javafx.scene.canvas.GraphicsContext;
import monsterbash.Board.MonsterBash;
import monsterbash.Main;
import monsterbash.gameobject.GameObject;
import monsterbash.graphics.Rect;

import javafx.scene.control.Button;
import monsterbash.graphics.Vector2;

public abstract class GameCard extends GameObject {
    public static final double cardWidth = MonsterBash.boardWidth /10;
    public static final double cardHeight = cardWidth * 1.5;

    double rotation = 0;
    public void setRotation(double rotation) {this.rotation = rotation;}
    public double getRotation() {return rotation;}

    double scale = 1;
    public void setScale(double scale) {this.scale = scale;}
    public double getScale() {return scale;}

    abstract void fillContents(GraphicsContext gc);

    Button transparentButton = null;

    static Vector2 verticalPadding = new Vector2(0, 20);
    static Vector2 horizontalPadding = new Vector2(20, 0);
    @Override
    public void setPosition(Vector2 position) {

        super.setPosition(position);
        transparentButton.setLayoutX(position.getX());
        transparentButton.setLayoutY(position.getY());
    }

    protected GameCard() {
        setBounding(new Rect(0, 0, cardWidth, cardHeight));
        transparentButton = new Button();
        transparentButton.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        transparentButton.setPrefWidth(cardWidth);
        transparentButton.setPrefHeight(cardHeight);
        scale = 1.0;

        transparentButton.setOnAction(e -> {
            MonsterBash.handleButton(this);
        });

        Main.getRoot().getChildren().add(transparentButton);
    }


    boolean selected = false;
    public void toggleSelected() {
        selected = !selected;
        if (isSelected()) {
            if (getRotation() == 180) {
                setPosition(this.getPosition().add(verticalPadding));
            }
            if (getRotation() == 90) {
                setPosition(this.getPosition().subtract(horizontalPadding));
            }

            if (getRotation() == 270) {
                setPosition(this.getPosition().add(horizontalPadding));
            }

            if (getRotation() == 0) {
                setPosition(this.getPosition().subtract(verticalPadding));
            }
        } else {
            if (getRotation() == 180) {
                setPosition(this.getPosition().subtract(verticalPadding));
            }
            if (getRotation() == 90) {
                setPosition(this.getPosition().add(horizontalPadding));
            }

            if (getRotation() == 270) {
                setPosition(this.getPosition().subtract(horizontalPadding));
            }

            if (getRotation() == 0) {
                setPosition(this.getPosition().add(verticalPadding));
            }
        }

    }
    public boolean isSelected() {return selected;}

    public void draw(GraphicsContext gc) {
        super.draw(gc);

        gc.save();

        // move to our screen location
        gc.translate(this.getPosition().getX(), this.getPosition().getY());

        // move to our card's center, then rotate, then return to our origin
        gc.translate(GameCard.cardWidth / 2.0, GameCard.cardHeight / 2.0);
        gc.rotate(this.rotation);
        gc.translate(-GameCard.cardWidth / 2.0, -GameCard.cardHeight / 2.0);

        gc.scale(this.scale, this.scale);
        // this is where our inherited types will fill in the contents
        fillContents(gc);

        gc.restore();
    }
}
