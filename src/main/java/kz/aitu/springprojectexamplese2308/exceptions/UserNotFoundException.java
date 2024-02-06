package kz.aitu.springprojectexamplese2308.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int id) {
        super("user with id=" + id + " was not found");
    }
}
