package t4j.app.exception;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class DiaInvalidoException extends IllegalArgumentException {

    public DiaInvalidoException() {
        super("Dia é inválido!!");
    }

    public DiaInvalidoException(String mensagem) {
        super(mensagem);
    }
}

