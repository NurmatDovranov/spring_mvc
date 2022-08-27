package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.dao.LessonDao;
import peaksoft.entity.Lesson;

import java.util.List;
@Service
public class LessonServiceImpl implements LessonService{

    private final LessonDao lessonDao;

    public LessonServiceImpl(LessonDao lessonDao) {
        this.lessonDao = lessonDao;
    }

    @Override
    public List<Lesson> getAllLessons() {
        return lessonDao.getAllLessons();
    }

    @Override
    public void addLesson(Lesson lesson) {
    lessonDao.addLesson(lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonDao.getLessonById(id);
    }

    @Override
    public void updateLesson(Lesson lesson) {
    lessonDao.updateLesson(lesson);
    }

    @Override
    public void deleteLesson(Lesson lesson) {
    lessonDao.deleteLesson(lesson);
    }
}
