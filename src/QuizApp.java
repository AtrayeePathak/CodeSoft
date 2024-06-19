import java.util.Arrays;
import java.util.List;

public class QuizApp {
    public static void main(String[] args) {
        // Create a list of questions
        List<Question> questions = Arrays.asList(
                new Question("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Madrid"}, 1),
                new Question("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, 2),
                new Question("What is the largest planet?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 3),
                new Question("Who wrote 'Romeo and Juliet'?", new String[]{"William Shakespeare", "Charles Dickens", "Mark Twain", "Jane Austen"}, 1),
                new Question("What is the chemical symbol for water?", new String[]{"H2O", "O2", "CO2", "NaCl"}, 1)
        );

        // Initialize the quiz with the list of questions
        Quiz quiz = new Quiz(questions);

        // Start the quiz
        quiz.start();
    }
}
