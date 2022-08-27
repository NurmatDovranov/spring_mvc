package peaksoft.dao;

import org.springframework.stereotype.Repository;

import peaksoft.entity.Instructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class InstructorDaoImpl implements InstructorDao{


    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Instructor> getAllInstructor() {
        List<Instructor> instructors = manager.createQuery("from Instructor", Instructor.class).getResultList();
        return instructors;
    }

    @Override
    public void addInstructor(Instructor instructor) {
        manager.persist(instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return manager.find(Instructor.class, id);
    }

    @Override
    public void updateInstructor(Instructor instructor) {
        manager.merge(instructor);
    }

    @Override
    public void deleteInstructor(Instructor instructor) {
        manager.remove(manager.contains(instructor) ? instructor : manager.merge(instructor));
    }
}
