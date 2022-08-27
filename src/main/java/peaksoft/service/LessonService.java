package peaksoft.service;

import peaksoft.entity.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getAllLessons();
    void addLesson(Lesson lesson);
    Lesson getLessonById(Long id);
    void updateLesson(Lesson lesson);
    void deleteLesson(Lesson lesson);
}
