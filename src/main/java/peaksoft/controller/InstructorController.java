package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Instructor;
import peaksoft.service.InstructorService;

import java.util.List;

@Controller
public class InstructorController {
    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/getAllInstructors")
    public String getInstructors(Model model) {
        List<Instructor> instructors = instructorService.getAllInstructor();
        model.addAttribute("instructors", instructors);
        return "instructor/instructors";
    }

    @GetMapping("/addInstructor")
    public String addInstructor(Model model){
        model.addAttribute("instructor",new Instructor());
        return "instructor/addInstructor";
    }

    @PostMapping("/saveInstructor")
    public String saveInstructor(@ModelAttribute("instructor")Instructor instructor){
        instructorService.addInstructor(instructor);
        return "redirect:/getAllInstructors";
    }

    @GetMapping("/updateInstructor")
    public String updateInstructor(@RequestParam("instructorId")Long id, Model model){
        Instructor instructor = instructorService.getInstructorById(id);
        model.addAttribute("instructor",instructor);
        return "instructor/updateInstructor";
    }

    @PostMapping("/saveUpdateInstructor")
    public String saveUpdateInstructor(@ModelAttribute("instructor")Instructor instructor){
        instructorService.updateInstructor(instructor);
        return "redirect:/getAllInstructors";
    }

    @RequestMapping("/deleteInstructor")
    public String deleteInstructor(@RequestParam("instructorId")Long id){
        instructorService.deleteInstructor(instructorService.getInstructorById(id));
        return "redirect:/getAllInstructors";
    }
}
