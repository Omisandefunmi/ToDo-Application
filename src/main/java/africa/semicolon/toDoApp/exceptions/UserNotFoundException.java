package africa.semicolon.toDoApp.exceptions;

public class UserNotFoundException extends ToDoAppException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
