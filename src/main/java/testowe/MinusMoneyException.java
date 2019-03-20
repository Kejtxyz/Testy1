package testowe;

public class MinusMoneyException extends RuntimeException {
    // tworzymy nowa klase do obslugi wyjatkow
    // dziedziczymy po Runtime Exception

    public MinusMoneyException(String message){
        super(message);
    }

}
