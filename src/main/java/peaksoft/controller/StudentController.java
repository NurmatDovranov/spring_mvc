package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Student;
import peaksoft.service.CourseService;
import peaksoft.service.StudentService;

import java.util.List;


@Controller
public class StudentController {

    private final StudentService studentService;

    private final CourseService courseService;

    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }


    @GetMapping("/getStudents")
    public String getAllStudent(@RequestParam("courseId")Long id, Model model){
        model.addAttribute("courseName", courseService.getCourseById(id).getCourseName());
        List<Student> students = courseService.getCourseById(id).getStudents();
        model.addAttribute("students", students);
        model.addAttribute("courseName", courseService.getCourseById(id));
        return "students/students";
    }

    @GetMapping("/addStudent")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "students/addStudent";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@RequestParam("courseId") Long id, @ModelAttribute("student") Student student) {
        courseService.getCourseById(id).getStudents().add(student);
        student.setCourse(courseService.getCourseById(id));
        studentService.addStudent(student);
        return "redirect/getStudents?courseId";
    }

    @GetMapping("/updateStudent")
    public String updateStudent(@RequestParam("studentId") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "students/updateStudent";
    }

    @PostMapping("saveUpdateStudent")
    public String saveUpdateStudent(@RequestParam("courseId") Long id, @ModelAttribute Student student) {
        student.setCourse(courseService.getCourseById(id));
        studentService.updateStudent(student);
        return "redirect:/getStudents?courseId";
    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") Long id, @RequestParam("courseId") Long courseId){
        studentService.deleteStudent(studentService.getStudentById(id));
        return "redirect:/getStudents?courseId="+courseId;
    }

}
