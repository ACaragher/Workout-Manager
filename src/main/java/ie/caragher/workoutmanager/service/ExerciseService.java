package ie.caragher.workoutmanager.service;

import java.util.List;

import ie.caragher.workoutmanager.entity.Exercise;

public interface ExerciseService {
    List<Exercise> findAll();

    Exercise findById(int theId);

    Exercise save(Exercise theExercise);

    void deleteById(int theId);
}
