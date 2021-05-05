package exception;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class ContextoInvalidoException extends RuntimeException {

    public ContextoInvalidoException(String string) {
        super(string);
    }
}
