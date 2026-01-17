package LLD2.StockBrokerSystem.exceptions;

public class InsufficientStockException extends RuntimeException{
    public InsufficientStockException(String message)
    {
        super(message);
    }
}
