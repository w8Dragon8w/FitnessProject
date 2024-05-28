package Decorator;

public abstract class ExerciseDecorator implements Exercise {
    protected Exercise decoratedExercise;

    public ExerciseDecorator(Exercise decoratedExercise) {
        this.decoratedExercise = decoratedExercise;
    }

    @Override
    public void perform() {
        decoratedExercise.perform();
    }
}
