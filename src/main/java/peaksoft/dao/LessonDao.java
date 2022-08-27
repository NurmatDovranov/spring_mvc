package peaksoft.dao;

import peaksoft.entity.Lesson;


import java.util.List;

public interface LessonDao {

    List<Lesson> getAllLessons();
    void addLesson(Lesson lesson);
    Lesson getLessonById(Long id);
    void updateLesson(Lesson lesson);
    void deleteLesson(Lesson lesson);
}
