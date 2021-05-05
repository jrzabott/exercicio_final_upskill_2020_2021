package exception;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class NoRollbackException extends RuntimeException {

    public NoRollbackException(String string) {
        super(string);
    }
}
