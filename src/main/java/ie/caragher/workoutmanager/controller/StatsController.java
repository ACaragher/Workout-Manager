package ie.caragher.workoutmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ie.caragher.workoutmanager.service.ExerciseService;

@Controller
@RequestMapping("/stats")
public class StatsController {

    @SuppressWarnings("unused")
    private ExerciseService exerciseService;

    public StatsController(ExerciseService theExerciseService) {
        exerciseService = theExerciseService;
    }

    @GetMapping("/stats-home")
    public String displayStats(Model theModel) {
        return "stats/stats-home";
    }


}