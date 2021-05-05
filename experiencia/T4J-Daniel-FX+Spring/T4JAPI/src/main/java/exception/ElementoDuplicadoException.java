package exception;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class ElementoDuplicadoException extends IllegalStateException {

    public ElementoDuplicadoException(String string) {
        super(string);
    }
}
