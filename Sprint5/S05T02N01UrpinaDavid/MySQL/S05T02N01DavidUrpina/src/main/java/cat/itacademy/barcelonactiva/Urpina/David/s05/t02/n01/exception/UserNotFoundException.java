package cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException (String msg){
        super(msg);
    }
}
