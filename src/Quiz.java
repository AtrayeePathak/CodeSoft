
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

    public class Quiz {
        private List<Question> questions;
        private int score = 0;
        private int currentQuestionIndex = 0;
        private Timer timer;
        private boolean timeUp = false;
        private final int TIME_LIMIT = 10; // 10 seconds for each question

        // Constructor to initialize the quiz with a list of questions
        public Quiz(List<Question> questions) {
            this.questions = questions;
        }

        // Method to start the quiz
        public void start() {
            Scanner scanner = new Scanner(System.in);

            // Loop through all questions
            for (currentQuestionIndex = 0; currentQuestionIndex < questions.size(); currentQuestionIndex++) {
                Question question = questions.get(currentQuestionIndex);
                displayQuestion(question);

                timeUp = false;
                startLiveTimer(TIME_LIMIT);

                int userAnswer = -1;
                while (!timeUp) {
                    if (scanner.hasNextInt()) {
                        userAnswer = scanner.nextInt();
                        break;
                    }
                }
                timer.cancel();
                clearConsole(); // Clear the console output for the next question

                // Check if the answer is correct
                if (userAnswer == question.getCorrectAnswer()) {
                    score++;
                }
            }

            displayResult();
            scanner.close();
        }

        // Method to display a question and its options
        private void displayQuestion(Question question) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ": " + options[i]);
            }
            System.out.print("Your answer: ");
        }

        // Method to display the final score
        private void displayResult() {
            System.out.println("\nQuiz Over!");
            System.out.println("Your final score is: " + score + "/" + questions.size());
        }

        // Method to start the live timer
        private void startLiveTimer(int seconds) {
            timer = new Timer();
            final int[] remainingTime = {seconds};

            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    if (remainingTime[0] > 0) {
                        System.out.print("\rTime left: " + remainingTime[0] + " seconds");
                        remainingTime[0]--;
                    } else {
                        timeUp = true;
                        System.out.print("\rTime's up!                    \n");
                        timer.cancel();
                    }
                }
            };

            timer.scheduleAtFixedRate(task, 0, 1000);
        }

        // Method to clear the console
        private void clearConsole() {
            // This is a simple trick to clear the console in most terminals.
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }


