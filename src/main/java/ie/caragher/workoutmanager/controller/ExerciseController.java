package ie.caragher.workoutmanager.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ie.caragher.workoutmanager.entity.Exercise;
import ie.caragher.workoutmanager.service.ExerciseService;

@Controller
@SessionAttributes("theExercise")
@RequestMapping("/manage")
public class ExerciseController {

    private ExerciseService exerciseService;

    public ExerciseController(ExerciseService theExerciseService) {
        exerciseService = theExerciseService;
    }

    @GetMapping("/selectWorkout")
    public String selectWorkout(Model theModel) {
        List<String> theWorkouts = exerciseService.getDistinctWorkoutNames();
        theModel.addAttribute("workouts", theWorkouts);
        return "manage/workouts";
    }

    @PostMapping("/selectExercise")
    public String selectExercise(@RequestParam String theWorkoutName, Model theModel) {
        String[] exerciseAndWorkout = {theWorkoutName, ""};
        List<String> theExercises = exerciseService.getExerciseNamesByWorkoutName(theWorkoutName);
        theModel.addAttribute("exercises", theExercises);
        theModel.addAttribute("theExercise", exerciseAndWorkout);
        return "manage/exercises";
    }

    @SuppressWarnings("null")
    @PostMapping("/addExercise")
    public String addExercise(@RequestParam String theExerciseName, Model theModel) {
        String[] exerciseAndWorkout = (String[]) theModel.getAttribute("theExercise");
        exerciseAndWorkout[1] = theExerciseName;
        Exercise theExercise = new Exercise();
        theModel.addAttribute("exercise", theExercise);
        theModel.addAttribute("theExercise", exerciseAndWorkout);
        return "manage/add";
    }

    @SuppressWarnings("null")
    @PostMapping("/saveExercise")
    public String saveExercise(@ModelAttribute("exercise") Exercise theExercise, Model theModel, SessionStatus status) {
        String[] exerciseAndWorkout = (String[]) theModel.getAttribute("theExercise");
        theExercise.setWorkoutName(exerciseAndWorkout[0]);
        theExercise.setExerciseName(exerciseAndWorkout[1]);
        theExercise.setDate(LocalDate.now());
        System.out.println("\n\nSAVE EXERCISE\n" + theExercise + "\n\n\n");
        exerciseService.save(theExercise);
        status.setComplete();
        return "redirect:/manage/addExercise";
    }

}
