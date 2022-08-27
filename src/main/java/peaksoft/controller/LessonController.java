package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Lesson;
import peaksoft.service.CourseService;
import peaksoft.service.LessonService;

import java.util.List;

@Controller
public class LessonController {
    private final LessonService lessonService;
    private final CourseService courseService;

    @Autowired
    public LessonController(LessonService lessonService, CourseService courseService) {
        this.lessonService = lessonService;
        this.courseService = courseService;
    }

    @GetMapping("/getLessons")
    public String getAllLesson(@RequestParam("courseId") Long id, Model model) {
        model.addAttribute("courseName", courseService.getCourseById(id).getCourseName());
        List<Lesson> lessons = courseService.getCourseById(id).getLessons();
        model.addAttribute("lessons", lessons);
        model.addAttribute("courseName", courseService.getCourseById(id));
        return "lessons/lessons";
    }

    @GetMapping("/addLesson")
    public String addLesson(Model model){
        model.addAttribute("lesson", new Lesson());
        return "lessons/addLesson";
    }

    @PostMapping("/saveLesson")
    public String saveLesson(@RequestParam("courseId") Long id, @ModelAttribute("lesson") Lesson lesson) {
        courseService.getCourseById(id).getLessons().add(lesson);
        lesson.setCourse(courseService.getCourseById(id));
        lessonService.addLesson(lesson);
        return "redirect/getLessons?courseId";
    }

    @GetMapping("/updateLesson")
    public String updateLesson(@RequestParam("lessonId") Long id, Model model) {
        Lesson lesson = lessonService.getLessonById(id);
        model.addAttribute("lesson", lesson);
        return "lessons/updateLesson";
    }

    @PostMapping("saveUpdateLesson")
    public String saveUpdateLesson(@RequestParam("courseId") Long id, @ModelAttribute Lesson lesson) {
        lesson.setCourse(courseService.getCourseById(id));
        lessonService.updateLesson(lesson);
        return "redirect:/getLessons?courseId";
    }

    @RequestMapping("/deleteLesson")
    public String deleteLesson(@RequestParam("lessonId") Long id, @RequestParam("courseId") Long courseId){
        lessonService.deleteLesson(lessonService.getLessonById(id));
        return "redirect:/getLesson?courseId="+courseId;
    }
}
