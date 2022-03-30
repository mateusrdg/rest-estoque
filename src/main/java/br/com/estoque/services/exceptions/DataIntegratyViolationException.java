package br.com.estoque.services.exceptions;

public class DataIntegratyViolationException extends RuntimeException{

    public DataIntegratyViolationException(String msg) {
        super(msg);
    }
}
