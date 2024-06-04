package ie.caragher.workoutmanager.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        Exercise theExercise = new Exercise();
        theExercise.setWorkoutName(theWorkoutName);
        theExercise.setSet(1);
        List<String> theExercises = exerciseService.getExerciseNamesByWorkoutName(theWorkoutName);
        theModel.addAttribute("exercises", theExercises);
        theModel.addAttribute("theExercise", theExercise);
        return "manage/exercises";
    }

    @SuppressWarnings("null")
    @RequestMapping(value = "/addExercise", method={RequestMethod.POST, RequestMethod.GET})
    public String addExercise(@RequestParam String theExerciseName, Model theModel) {

        Exercise theExercise = (Exercise) theModel.getAttribute("theExercise");
        theExercise.setExerciseName(theExerciseName);
        List<Exercise> allExercises = exerciseService.findAllByExerciseName(theExerciseName);

        int i = 0;
        LocalDate firstDate = allExercises.get(0).getDate();
        List<Exercise> todayExercises = new ArrayList<>();
        while(i < allExercises.size() && firstDate.equals(LocalDate.now())) {
            todayExercises.add(allExercises.get(i));
            i++;
            firstDate = allExercises.get(i).getDate();
        }

        List<Exercise> prevExercises = new ArrayList<>();
        if(i < allExercises.size()) {
            LocalDate prevDate = allExercises.get(i).getDate();
            while(i < allExercises.size() && prevDate.isEqual(allExercises.get(i).getDate())) {
                prevExercises.add(allExercises.get(i));
                i ++;
            }
        }

        theModel.addAttribute("theExercise", theExercise);
        theModel.addAttribute("todayExercises", todayExercises);
        theModel.addAttribute("prevExercises", prevExercises);
        return "manage/add";
    }

    @PostMapping("/saveExercise")
    public String saveExercise(@ModelAttribute("theExercise") Exercise theExercise, Model theModel, RedirectAttributes redirectAttributes) {
        theExercise.setDate(LocalDate.now());
        exerciseService.save(theExercise);
        Exercise nextExercise = new Exercise(theExercise);
        theModel.addAttribute("theExercise", nextExercise);
        redirectAttributes.addAttribute("theExerciseName", nextExercise.getExerciseName());
        return "redirect:/manage/addExercise";
    }

}
