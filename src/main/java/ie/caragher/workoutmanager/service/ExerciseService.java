package ie.caragher.workoutmanager.service;

import java.util.List;

import ie.caragher.workoutmanager.entity.Exercise;

public interface ExerciseService {
    List<Exercise> findAll();

    Exercise findById(int theId);

    List<Exercise> findAllByExerciseNameDesc(String exerciseName);

    List<Exercise> findAllByExerciseNameAsc(String exerciseName);

    Exercise save(Exercise theExercise);

    void deleteById(int theId);

    List<String> getDistinctWorkoutNames();

    List<String> getExerciseNamesByWorkoutName(String theWorkoutName);
}
