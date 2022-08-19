package africa.semicolon.toDoApp.data.models;

import africa.semicolon.toDoApp.data.models.enums.Status;
import africa.semicolon.toDoApp.data.models.enums.TaskNature;

import java.time.LocalDateTime;

public class Task {
    private String task;
    private LocalDateTime createdAt;
    private Status currentStatus;
    private TaskNature taskNature;

}