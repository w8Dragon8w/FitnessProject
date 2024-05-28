import Decorator.BasicExercise;
import Decorator.CardioDecorator;
import Decorator.Exercise;
import Decorator.StrengthDecorator;
import Observer.Trainee;
import Observer.TrainingProgram;
import Singleton.Gym;
import Strategy.CardioTraining;
import Strategy.StrengthTraining;
import Strategy.TrainingContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Създаване на фитнес зала (Singleton)
        Gym gym = Gym.getInstance();

        // Създаване на тренировъчна програма (Observer)
        TrainingProgram program1 = new TrainingProgram();
        TrainingProgram program2 = new TrainingProgram();

        Trainee trainee1 = new Trainee("John");
        Trainee trainee2 = new Trainee("Jane");

        program1.addObserver(trainee1);
        program1.addObserver(trainee2);

        // Добавяне на трениращи и програми във фитнес залата
        gym.addTrainee(trainee1);
        gym.addTrainee(trainee2);
        gym.addTrainingProgram(program1);
        gym.addTrainingProgram(program2);

        // Задаване на нова тренировъчна програма
        program1.setProgramDetails("New strength and cardio program");

        // Трениращите започват да тренират по новата програма
        trainee1.startTraining();
        trainee2.startTraining();

        // Промяна на тренировъчната програма
        program1.setProgramDetails("Updated strength training program");

        // Трениращите започват да тренират по новата програма
        trainee1.startTraining();
        trainee2.startTraining();

        // Показване на предишната програма на трениращите
        System.out.println(trainee1.getName() + "'s previous program: " + trainee1.getPreviousProgram());
        System.out.println(trainee2.getName() + "'s previous program: " + trainee2.getPreviousProgram());

        // Използване на стратегии за различни тренировъчни режими (Strategy)
        TrainingContext context = new TrainingContext();
        context.setStrategy(new CardioTraining());
        context.executeTraining();

        context.setStrategy(new StrengthTraining());
        context.executeTraining();

        // Персонализиране на тренировъчната програма (Decorator)
        Exercise basicExercise = new BasicExercise();
        Exercise cardioExercise = new CardioDecorator(basicExercise);
        Exercise strengthExercise = new StrengthDecorator(cardioExercise);

        strengthExercise.perform();
    }
}