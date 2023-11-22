package exceptions;

public class NoSuchGraphTypeException extends Throwable {

    public NoSuchGraphTypeException() {
        super("No such graph type");
    }
}
