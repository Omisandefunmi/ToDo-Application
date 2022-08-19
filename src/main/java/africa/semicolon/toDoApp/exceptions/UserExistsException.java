package africa.semicolon.toDoApp.exceptions;

public class UserExistsException extends ToDoAppException{
    public UserExistsException(String message) {
        super(message);
    }
}
