package gametemplate.gameobject;

public class MaxObjectsException extends Exception {
    public MaxObjectsException() {
        super("Maximum Objects Exceeded.");
    }

    public MaxObjectsException(String s) {
        super(s);
    }
}
