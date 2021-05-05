package t4j.app.exception;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class ElementoDuplicadoException extends RuntimeException {

    public ElementoDuplicadoException(String string) {
        super(string);
    }
}
