package Singleton;

import Observer.Trainee;
import Observer.TrainingProgram;

import java.util.ArrayList;
import java.util.List;

public class Gym {
    private static Gym instance;

    private List<Trainee> trainees;
    private List<TrainingProgram> trainingPrograms;

    private Gym() {
        trainees = new ArrayList<>();
        trainingPrograms = new ArrayList<>();
    }

    public static synchronized Gym getInstance() {
        if (instance == null) {
            instance = new Gym();
        }
        return instance;
    }

    // Метод за добавяне на трениращ
    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    // Метод за премахване на трениращ
    public void removeTrainee(Trainee trainee) {
        trainees.remove(trainee);
    }

    // Метод за добавяне на тренировъчна програма
    public void addTrainingProgram(TrainingProgram program) {
        trainingPrograms.add(program);
    }

    // Метод за премахване на тренировъчна програма
    public void removeTrainingProgram(TrainingProgram program) {
        trainingPrograms.remove(program);
    }

    // Метод за извличане на информация за всички трениращи
    public List<Trainee> getTrainees() {
        return trainees;
    }

    // Метод за извличане на информация за всички тренировъчни програми
    public List<TrainingProgram> getTrainingPrograms() {
        return trainingPrograms;
    }
}
