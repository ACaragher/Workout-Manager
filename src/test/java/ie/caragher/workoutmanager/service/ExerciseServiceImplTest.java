package ie.caragher.workoutmanager.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ie.caragher.workoutmanager.entity.Exercise;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ExerciseServiceImplTest {

    @Autowired
    private ExerciseServiceImpl exerciseServiceImpl;
    

    @Test
    void testDeleteById() {
        Exercise exercise = new Exercise("Push", "Overhead Press", LocalDate.of(2024, 8, 01), 40, 1, 5);
        assertEquals(6, exerciseServiceImpl.findAll().size());
        exerciseServiceImpl.save(exercise);
        assertEquals(7, exerciseServiceImpl.findAll().size());
        exercise = exerciseServiceImpl.getMostRecentExercises("OverheadPress").get(0);
        exerciseServiceImpl.deleteById(exercise.getId());
        assertEquals(6, exerciseServiceImpl.findAll().size());

    }

    @Test
    void testFindAll() throws Exception {
        assertEquals(6, exerciseServiceImpl.findAll().size());
    }

    @Test
    void testFindAllByExerciseNameAsc() throws Exception {
        List<Exercise> exercises = exerciseServiceImpl.findAllByExerciseNameAsc("Squat");
        assertEquals(2, exercises.size());
        assertEquals("Squat", exercises.get(0).getExerciseName());
    }

    @Test
    void testFindById() throws Exception {
        Exercise exerciseId1 = exerciseServiceImpl.findById(2);
        assertEquals(2, exerciseId1.getId());
    }

    @Test
    void testGetDistinctWorkoutNames() throws Exception {
        List<String> exercises = exerciseServiceImpl.getDistinctWorkoutNames();
        assertEquals(2, exercises.size());
        assertEquals(true, exercises.get(0) != exercises.get(1));
    }

    @Test
    void testGetExerciseNamesByWorkoutName() {
        List<String> exercises = exerciseServiceImpl.getExerciseNamesByWorkoutName("Upper Body");
        assertEquals(2, exercises.size());
        assertEquals("Bench Press", exercises.get(0));
        assertEquals("Row", exercises.get(1));
    }

    @Test
    void testGetExercisesOnDate() {
        List<Exercise> exercises = exerciseServiceImpl.getExercisesOnDate("Bench Press", LocalDate.of(2024, 1, 2));
        assertEquals(1, exercises.size());
        assertEquals(3, exercises.get(0).getId());
    }

    @Test
    void testGetMostRecentExercises() {
        List<Exercise> exercises = exerciseServiceImpl.getMostRecentExercises("Bench Presse");
        assertEquals(3, exercises.size());
    }

}
