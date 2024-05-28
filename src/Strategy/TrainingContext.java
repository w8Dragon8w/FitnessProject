package Strategy;

public class TrainingContext {
    private TrainingStrategy strategy;

    public void setStrategy(TrainingStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeTraining() {
        strategy.train();
    }
}
