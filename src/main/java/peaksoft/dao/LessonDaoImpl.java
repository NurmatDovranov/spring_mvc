package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Lesson;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LessonDaoImpl implements LessonDao{

    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = manager.createQuery("from Lesson", Lesson.class).getResultList();
        return lessons;
    }

    @Override
    public void addLesson(Lesson lesson) {
        manager.persist(lesson);

    }

    @Override
    public Lesson getLessonById(Long id) {
        return manager.find(Lesson.class, id);
    }

    @Override
    public void updateLesson(Lesson lesson) {
    manager.merge(lesson);
    }

    @Override
    public void deleteLesson(Lesson lesson) {
        manager.remove(manager.contains(lesson) ? lesson : manager.merge(lesson));
    }
}
