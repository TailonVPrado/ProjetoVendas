package Exception;
public class DescricaoInvalidaException extends Exception{
    public DescricaoInvalidaException() {
        super("Descrição vazia ou inválida. Verifique!");
    }    
}
