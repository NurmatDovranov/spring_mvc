package peaksoft.service;

import peaksoft.entity.Instructor;

import java.util.List;

public interface InstructorService {

    List<Instructor> getAllInstructor();

    void addInstructor(Instructor instructor);

    Instructor getInstructorById(Long id);

    void updateInstructor(Instructor instructor);

    void deleteInstructor(Instructor instructor);
}
