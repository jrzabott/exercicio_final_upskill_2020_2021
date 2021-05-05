package t4j.app.exception;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class MesInvalidoException extends IllegalArgumentException {
  
    public MesInvalidoException() {
        super("Mês é inválido!!");
    }

    public MesInvalidoException(String mensagem) {
        super(mensagem);
    }
}
