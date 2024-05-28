package Observer;

import java.util.ArrayList;
import java.util.List;

public class TrainingProgram implements Subject {
    private List<Observer> trainees;
    private String programDetails;

    public TrainingProgram() {
        trainees = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        trainees.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        trainees.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer trainee : trainees) {
            trainee.update(programDetails);
        }
    }

    public void setProgramDetails(String programDetails) {
        this.programDetails = programDetails;
        notifyObservers();
    }
}
