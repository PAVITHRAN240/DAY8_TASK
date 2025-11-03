import java.util.*;

class Question {
    String questionText;
    String[] options;
    char correctAnswer;

    
    Question(String questionText, String[] options, char correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    
    void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((char) ('A' + i) + ". " + options[i]);
        }
    }

    
    boolean isCorrect(char userAnswer) {
        return Character.toUpperCase(userAnswer) == Character.toUpperCase(correctAnswer);
    }
}

public class OnlineQuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> quiz = new ArrayList<>();
        quiz.add(new Question("1. What is the capital of France?",
                new String[]{"Berlin", "Paris", "Madrid", "Rome"}, 'B'));
        quiz.add(new Question("2. Which language is used for Android development?",
                new String[]{"Kotlin", "Python", "Swift", "Ruby"}, 'A'));
        quiz.add(new Question("3. Who developed Java?",
                new String[]{"Microsoft", "Apple", "Sun Microsystems", "IBM"}, 'C'));
        quiz.add(new Question("4. What does OOP stand for?",
                new String[]{"Object-Oriented Programming", "Online Open Platform", "Order Of Processing", "Optional Output Parameter"}, 'A'));
        quiz.add(new Question("5. Which keyword is used to inherit a class in Java?",
                new String[]{"extends", "implements", "inherits", "super"}, 'A'));

        int score = 0;

        System.out.println("Welcome to the Online Quiz App");
        System.out.println("Enter the correct option letter (A/B/C/D)\n");

        
        for (Question q : quiz) {
            q.displayQuestion();
            System.out.print("Your answer: ");
            char answer = sc.next().charAt(0);

            if (q.isCorrect(answer)) {
                System.out.println(" Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " + q.correctAnswer + "\n");
            }
        }

        
        System.out.println("Quiz Completed");
        System.out.println("Your Score: " + score + " out of " + quiz.size());
        double percentage = (score * 100.0) / quiz.size();
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 80) {
            System.out.println(" Excellent Performance!");
        } else if (percentage >= 50) {
            System.out.println(" Good Job!");
        } else {
            System.out.println(" Better luck next time!");
        }

        sc.close();
    }
}
