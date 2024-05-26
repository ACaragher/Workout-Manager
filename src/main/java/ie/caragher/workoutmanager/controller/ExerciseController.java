package ie.caragher.workoutmanager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ie.caragher.workoutmanager.entity.Exercise;
import ie.caragher.workoutmanager.service.ExerciseService;

@Controller
@RequestMapping("/exercises")
public class ExerciseController {

    private ExerciseService exerciseService;

    public ExerciseController(ExerciseService theExerciseService) {
        exerciseService = theExerciseService;
        
    }

    @GetMapping("/list")
    public String listExercises(Model theModel) {
        List<Exercise> theExercises = exerciseService.findAll();
        theModel.addAttribute("exercises", theExercises);

        return "list-exercises";
    }

}
