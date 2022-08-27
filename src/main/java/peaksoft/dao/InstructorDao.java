package peaksoft.dao;


import peaksoft.entity.Instructor;

import java.util.List;

public interface InstructorDao {

    List<Instructor> getAllInstructor();
    void addInstructor(Instructor instructor);
    Instructor getInstructorById(Long id);
    void updateInstructor(Instructor instructor);
    void deleteInstructor(Instructor instructor);
}
