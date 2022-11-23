package my.home.lesson18.part1;

public class EmptyListException extends Throwable {
    public EmptyListException(String message) {
        super(message);
    }
    public EmptyListException() {
        super();
    }
    public EmptyListException(Exception e) {
        super(e);
    }
    public EmptyListException(String message,Exception e) {
        super(message,e);
    }
}
