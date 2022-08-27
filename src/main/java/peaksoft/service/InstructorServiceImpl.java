package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.InstructorDao;
import peaksoft.entity.Instructor;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService{

    private InstructorDao instructorDao;
    @Autowired
    public InstructorServiceImpl(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }

    @Override
    public List<Instructor> getAllInstructor() {
        return instructorDao.getAllInstructor();
    }

    @Override
    public void addInstructor(Instructor instructor) {
    instructorDao.addInstructor(instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorDao.getInstructorById(id);
    }

    @Override
    public void updateInstructor(Instructor instructor) {
    instructorDao.updateInstructor(instructor);
    }

    @Override
    public void deleteInstructor(Instructor instructor) {
        instructorDao.deleteInstructor(instructor);
    }
}
