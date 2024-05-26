package ie.caragher.workoutmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.caragher.workoutmanager.entity.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

}
