package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Task;
import peaksoft.service.LessonService;
import peaksoft.service.TaskService;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;
    private final LessonService lessonService;

    @Autowired
    public TaskController(TaskService taskService, LessonService lessonService) {
        this.taskService = taskService;
        this.lessonService = lessonService;
    }

    @GetMapping("/getTasks")
    public String getAllTask(@RequestParam("lessonId") Long id, Model model) {
        model.addAttribute("lessonName", lessonService.getLessonById(id).getLessonName());
        List<Task> tasks = lessonService.getLessonById(id).getTasks();
        model.addAttribute("tasks", tasks);
        model.addAttribute("lessonName", lessonService.getLessonById(id));
        return "tasks/tasks";
    }

    @GetMapping("/addTasks")
    public String addTask(Model model){
        model.addAttribute("task", new Task());
        return "tasks/addTask";
    }

    @PostMapping("/saveTask")
    public String saveTask(@RequestParam("lessonId") Long id, @ModelAttribute("task") Task task) {
        lessonService.getLessonById(id).getTasks().add(task);
        task.setLesson(lessonService.getLessonById(id));
        taskService.addTask(task);
        return "redirect/getTasks?lessonId";
    }

    @GetMapping("/updateTask")
    public String updateTask(@RequestParam("taskId") Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "tasks/updateTask";
    }

    @PostMapping("saveUpdateTask")
    public String saveUpdateTask(@RequestParam("lessonId") Long id, @ModelAttribute Task task) {
        task.setLesson(lessonService.getLessonById(id));
        taskService.updateTask(task);
        return "redirect:/getTasks?lessonId";
    }

    @RequestMapping("/deleteTask")
    public String deleteTask(@RequestParam("taskId") Long id, @RequestParam("lessonId") Long lessonId){
        taskService.deleteTask(taskService.getTaskById(id));
        return "redirect:/getTasks?lessonId="+lessonId;
    }
}
