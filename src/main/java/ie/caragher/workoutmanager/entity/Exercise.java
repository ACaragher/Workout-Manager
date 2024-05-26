package ie.caragher.workoutmanager.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "workout_name")
    private String workoutName;

    @Column(name = "exercise_name")
    private String exerciseName;

    @Column(name="date")
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private LocalDate date;

    @Column(name = "weight")
    private double weight;

    @Column(name = "set")
    private int set;

    @Column(name = "reps")
    private int reps;

    public Exercise() {

    }

    public Exercise(String workoutName, String exerciseName, LocalDate date, double weight, int set, int reps) {
        this.workoutName = workoutName;
        this.exerciseName = exerciseName;
        this.date = date;
        this.weight = weight;
        this.set = set;
        this.reps = reps;
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkoutName() {
        return this.workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getExerciseName() {
        return this.exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSet() {
        return this.set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public int getReps() {
        return this.reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", workoutName='" + getWorkoutName() + "'" +
            ", exerciseName='" + getExerciseName() + "'" +
            ", date='" + getDate() + "'" +
            ", weight='" + getWeight() + "'" +
            ", set='" + getSet() + "'" +
            ", reps='" + getReps() + "'" +
            "}";
    }

}
