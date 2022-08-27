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

        List<Task> tasks = entityManager.createQuery("from Task", Task.class).getResultList();
        return tasks;
    }

    @Override
    public void addTask(Task task) {
    entityManager.persist(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    public void updateTask(Task task) {
    entityManager.merge(task);
    }

    @Override
    public void deleteTask(Task task) {
    entityManager.remove(entityManager.contains(task) ? task : entityManager.merge(task));
    }
}
