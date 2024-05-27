package ie.caragher.workoutmanager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ie.caragher.workoutmanager.entity.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
    @Query(value="SELECT DISTINCT workout_name FROM exercise", nativeQuery=true)
    List<String> getDistinctWorkoutNames();

    @Query(value="SELECT DISTINCT exercise_name FROM exercise WHERE workout_name = ?1", nativeQuery=true)
    List<String> getDistinctExerciseNamesByWorkoutName(String theWorkoutName);
}
