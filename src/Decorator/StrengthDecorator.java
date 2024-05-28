package Decorator;

public class StrengthDecorator extends ExerciseDecorator {
    public StrengthDecorator(Exercise decoratedExercise) {
        super(decoratedExercise);
    }

    @Override
    public void perform() {
        decoratedExercise.perform();
        System.out.println("Adding strength exercises.");
    }
}
