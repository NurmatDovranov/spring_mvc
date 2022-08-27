package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.dao.TaskDao;
import peaksoft.entity.Task;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskDao taskDao;

    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskDao.getAllTasks();
    }

    @Override
    public void addTask(Task task) {
    taskDao.addTask(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskDao.getTaskById(id);
    }

    @Override
    public void updateTask(Task task) {
    taskDao.updateTask(task);
    }

    @Override
    public void deleteTask(Task task) {
    taskDao.deleteTask(task);
    }
}
