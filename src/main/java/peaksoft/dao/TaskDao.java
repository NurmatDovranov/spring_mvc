package peaksoft.dao;

import peaksoft.entity.Course;
import peaksoft.entity.Task;

import java.util.List;

public interface TaskDao {

    List<Task> getAllTasks();
    void addTask(Task task);
    Task getTaskById(Long id);
    void updateTask(Task task);
    void deleteTask(Task task);
}
