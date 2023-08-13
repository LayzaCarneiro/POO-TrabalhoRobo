package exception;

public class MovimentoInvalidoException extends Exception {
  public String toString(){
    return "ATENÇÃO! O movimento foi inválido.";
  }
}
