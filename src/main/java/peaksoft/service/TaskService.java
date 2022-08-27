package peaksoft.service;

import peaksoft.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    void addTask(Task task);
    Task getTaskById(Long id);
    void updateTask(Task task);
    void deleteTask(Task task);
}
