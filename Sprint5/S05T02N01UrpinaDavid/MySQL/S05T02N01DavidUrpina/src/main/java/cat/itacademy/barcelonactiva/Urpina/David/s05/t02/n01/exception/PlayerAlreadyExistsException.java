package cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.exception;

public class PlayerAlreadyExistsException extends RuntimeException{
    public PlayerAlreadyExistsException(String msg){
        super(msg);
    }
}
