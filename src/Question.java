import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question {
    private final String q1 = """
            What is hardware?
                        
            (a)virtual machine
            (b)the physical machine
            (c)applications such as browsers
            (d)part of the processor
            """;

    private final String q2 = """
            What does counter++; do?
                        
            (a)Adds 1 to counter
            (b)Adds 2 to counter
            (c)Gets the sum
            (d)Multiplies the numbers
            """;

    private final String q3 = """
            What is a loop that never stops?
                        
            (a)For Loop
            (b)Infinite Loop
            (c)Do-While Loop
            (d)Full Loop;
            """;

    private final String q4 = """
            In a while loop, if the boolean expression is true, what will the loop do?
                        
            (a)Break
            (b)Program will exit
            (c)Repeat
            (d)Continue through program"
            """;

    private final String q5 = """
            What special value is designated for controlling a loop?
                        
            (a)Control value
            (b)Mutator Method
            (c)Accessor Method
            (d)Sentinel Value
            """;

    private final String q6 = """
            What is a method?
                        
            (a)A collection of statements grouped together to perform an operation
            (b)A value returned from a method using the return statement
            (c)The portion of the program where the variable can be accessed.
            (d)The combination of the name of a method and the list of its parameters
            """;

    private final String q7 = """
            What is an object?
                        
            (a)Representation of an entity in the real world that can be distinctly identified
            (b)A static method can be called without creating an instance of the class
            (c)Instance variable/instance method
            (d)A template, blueprint or contract that defines what an object's data fields and methods will be.
            """;

    private final String q8 = """
            What is an array?
                        
            (a)Numbers of items ArrayList can store without increasing its size
            (b)Number used as an index to pinpoint a specfic element within an array
            (c)Object that can store a group of values, all of the same type
            (d)Method of locating a specific item in a larger collection of data
            """;

    private final String q9 = """
            You use this statement to throw an exception manually.
                        
            (a)Throw
            (b)call stack
            (c)try block
            (d)thrown
            """;

    private final String qF = """
            When an exception is generated, it is said to have been what?
                        
            (a)Created
            (b)Called
            (c)Thrown
            (d)Generated
            """;
    private final List<String> prompt;
    private final List<String> answer;

    Scanner scanner = null;

    public Question() {
        prompt = new ArrayList<>() {{
            add(q1);
            add(q2);
            add(q3);
            add(q4);
            add(q5);
            add(q6);
            add(q7);
            add(q8);
            add(q9);
            add(qF);
        }};

        answer = new ArrayList<>() {{
            add("b");
            add("a");
            add("b");
            add("c");
            add("d");
            add("a");
            add("a");
            add("c");
            add("d");
            add("c");
        }};

        scanner = new Scanner(System.in);
    }

    public void play() {
        List<String> responseUserList = new ArrayList<>();

        System.out.println("A questionnaire will be proposed to you, " +
                "please enter the letter corresponding to the correct answer");

        prompt.forEach(question -> {
            System.out.print("\n" + question);
            String response = "";
            do {
                response = scanner.nextLine();
                if (response.trim().length() != 1) {
                    System.out.println("Invalid entry, please enter a letter only!");
                }
            } while (response.trim().length() != 1);

            responseUserList.add(response);

        });

        //Calcul du score
        int trueResponseNumber = 0;
        int falseResponseNumber = 0;

        System.out.println("\n\n************ RECAPITULATIF ***************");
        for (int compteur = 0; compteur < responseUserList.size(); compteur++) {
            String anwserData = answer.get(compteur);
            System.out.print(prompt.get(compteur));
            System.out.println("\tYour Response: " + responseUserList.get(compteur));
            System.out.println("\tCorrect Answer: " + anwserData);
            System.out.println();

            if (responseUserList.get(compteur).equalsIgnoreCase(anwserData)) {
                trueResponseNumber++;
            } else {
                falseResponseNumber++;
            }
        }

        System.out.println("\n============ YOUR SCORE =============");
        System.out.println("#True responses: " + trueResponseNumber);
        System.out.println("-False responses: " + falseResponseNumber);

        repeatTheGame();
    }

    private void repeatTheGame() {
        String response = "";
        do {
            System.out.println("\n\nWould you like to try again? (Y/N)");
            response = scanner.nextLine();
        } while (!response.trim().equalsIgnoreCase("y") && !response.trim().equalsIgnoreCase("n"));

        if (response.trim().equalsIgnoreCase("y")) {
            play();
        } else {
            System.out.println("Thank you for participating in this questionnaire!!!");
        }
    }
}
