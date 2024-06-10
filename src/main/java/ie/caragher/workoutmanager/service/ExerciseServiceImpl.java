package ie.caragher.workoutmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ie.caragher.workoutmanager.dao.ExerciseRepository;
import ie.caragher.workoutmanager.entity.Exercise;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository theExerciseRepository) {
        this.exerciseRepository = theExerciseRepository;
    }

    @Override
    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    @Override
    public Exercise findById(int theId) {
        Optional<Exercise> result = exerciseRepository.findById(theId);

        Exercise theExercise = null;

        if(result.isPresent()) {
            theExercise = result.get();
        }
        else {
            throw new RuntimeException("Did not find exercise id - " + theId);
        }

        return theExercise;
    }

    @Override
    public List<Exercise> findAllByExerciseNameDesc(String exerciseName) {
        return exerciseRepository.findAllByExerciseNameDesc(exerciseName);
    }

    @Override
    public List<Exercise> findAllByExerciseNameAsc(String exerciseName) {
        return exerciseRepository.findAllByExerciseNameAsc(exerciseName);
    }

    @Override
    public Exercise save(Exercise theExercise) {
        return exerciseRepository.save(theExercise);
    }

    @Override
    public void deleteById(int theId) {
        exerciseRepository.deleteById(theId);
    }

    @Override
    public List<String> getDistinctWorkoutNames() {
        return exerciseRepository.getDistinctWorkoutNames();
    }

    @Override
    public List<String> getExerciseNamesByWorkoutName(String theWorkoutName) {
        return exerciseRepository.getDistinctExerciseNamesByWorkoutName(theWorkoutName);
    }


}
