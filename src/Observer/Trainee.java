package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Trainee implements Observer {
    private String name;
    private String currentProgram;
    private String previousProgram;
    private Random random;

    public Trainee(String name) {
        this.name = name;
        this.random = new Random();
    }

    @Override
    public void update(String message) {
        if (currentProgram == null) {
            // Ако текущата програма е null, винаги приемаме новата програма
            currentProgram = message;
            System.out.println(name + " received initial program: " + message);
        } else {
            // 50% шанс за запазване на старата програма
            if (random.nextBoolean()) {
                // Запазване на предишната програма преди обновяване
                previousProgram = currentProgram;
                currentProgram = message;
                System.out.println(name + " received update and accepted the new program: " + message);
            } else {
                System.out.println(name + " received update but decided to keep the old program: " + currentProgram);
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getCurrentProgram() {
        return currentProgram;
    }

    public String getPreviousProgram() {
        if (previousProgram == null) {
            return "No previous program.";
        }
        return previousProgram;
    }

    public void startTraining() {
        if (currentProgram != null) {
            System.out.println(name + " starts training with program: " + currentProgram);
        } else {
            System.out.println(name + " has no training program.");
        }
    }
}

