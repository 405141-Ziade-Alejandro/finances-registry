package ar.Ziade.personal_finance.exceptions;

public class AccountAlreadyExistException extends RuntimeException {
    public AccountAlreadyExistException(String name) {
        super("Account already exists with name: " + name);
    }
}
