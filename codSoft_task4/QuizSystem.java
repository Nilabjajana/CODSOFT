import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizSystem {

    private String[][] questions = {
        {"What is the capital of France?", "Paris", "London", "Berlin", "Paris"},
        {"What is the largest planet in our solar system?", "Earth", "Saturn", "Jupiter", "Jupiter"},
        {"What is the smallest country in the world?", "Vatican City", "Monaco", "Nauru", "Vatican City"},
        {"What is the largest living species of lizard?", "Komodo dragon", "Saltwater crocodile", "Black mamba", "Komodo dragon"},
        {"What is the highest mountain peak in the world?", "Mount Everest", "K2", "Mount Kilimanjaro", "Mount Everest"}
    };

    private int score = 0;

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();

        for (String[] question : questions) {
            System.out.println(question[0]);
            System.out.println("A) " + question[1]);
            System.out.println("B) " + question[2]);
            System.out.println("C) " + question[3]);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up!");
                }
            }, 30000); // 30 seconds

            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase(question[4])) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is " + question[4]);
            }

            timer.cancel();
        }

        System.out.println("Quiz finished! Your score is " + score + " out of " + questions.length);
    }

    public static void main(String[] args) {
        QuizSystem quizSystem = new QuizSystem();
        quizSystem.startQuiz();
    }
}
