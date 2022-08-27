package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TaskDaoImpl implements TaskDao{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Task> getAllTasks() {
        return null;
    }

    @Override
    public void addTask(Task task) {

    }

    @Override
    public Task getTaskById(Long id) {
        return null;
    }

    @Override
    public void updateTask(Task task) {

    }

    @Override
    public void deleteTask(Task task) {

    }
}
