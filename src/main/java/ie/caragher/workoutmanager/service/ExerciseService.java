package ie.caragher.workoutmanager.service;

import java.time.LocalDate;
import java.util.List;

import ie.caragher.workoutmanager.entity.Exercise;

public interface ExerciseService {
    List<Exercise> findAll();

    Exercise findById(int theId);

    List<Exercise> findAllByExerciseNameDesc(String theExerciseName);

    List<Exercise> findAllByExerciseNameAsc(String theExerciseName);

    Exercise save(Exercise theExercise);

    void deleteById(int theId);

    List<String> getDistinctWorkoutNames();

    List<String> getExerciseNamesByWorkoutName(String theWorkoutName);

    List<Exercise> getExercisesOnDate(String theExerciseName, LocalDate date);

    List<Exercise> getMostRecentExercises(String theExerciseName);
}
