package fer.or.ucl_winners.exeption;

public class PersonNotFoundExeption extends RuntimeException{
    public PersonNotFoundExeption(String message) {
        super(message);
    }
}
