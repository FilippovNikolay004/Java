package Exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) { super(message); }
    public ProductNotFoundException() { super("product not found"); }
}