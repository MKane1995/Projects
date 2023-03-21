package bot;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class SimpleGameBot {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SimpleGameBot bot = new SimpleGameBot();
        bot.greet("GameBot", "2023");
        bot.getName();
        int end = -1;
        while (end != 0){
            bot.whatToDo();
            try {
                end = Integer.parseInt(scanner.nextLine());
                if (end < 0 || end > 3) {
                    System.out.println("Option must be between 0 and 3.");
                }
                if (end == 1) {
                    bot.guessAge();
                }
                else if (end == 2) {
                    bot.count();
                }
                else if (end == 3) {
                    bot.guess();
                }


            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                System.out.println();
            }

        }
        bot.end();
    }

    /**
     *
     * @param name - passing a string that's the name of the bot.
     * @param birthYear - passing an int that is the year the bot was made.
     *
     * Method that takes the parameters above to output a greeting.
     */
    public void greet(String name, String birthYear) {
        System.out.println("Hello! My name is " + name + ".");
        System.out.println("I was created in " + birthYear + ".");
        System.out.println("Please, tell me your name: ");
    }

    /**
     * Method that gets the the name of the user with input.
     */
    public void getName() {
        String name = "";
        while (name.isEmpty()) {
            name = scanner.nextLine();
            if(name.isEmpty()) {
                System.out.println("Please enter a name!");
            }
        }
        System.out.println("What a great name you have, " + name + "!");
    }

    /**
     * Method that gives users a menu of options.
     */
    public void whatToDo() {
        System.out.println("What would you like me to do? ");
        System.out.println("1. Guess your age (Some math needed)");
        System.out.println("2. Count to a number you give me");
        System.out.println("3. See how many tries it takes to guess a number between 0 and 50");
        System.out.println("0. End the bot");
    }

    /**
     * Method that uses user input and a math equation to guess their age.
     */
    public void guessAge() {
        System.out.println("Let me guess your age.");
        boolean mistake = true;
        int age = 0;
        while(mistake) {
            System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
            try{
                int rem3 = Integer.parseInt(scanner.nextLine());
                int rem5 = Integer.parseInt(scanner.nextLine());
                int rem7 = Integer.parseInt(scanner.nextLine());
                scanner.nextLine();
                age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;
                mistake = false;
            }
            catch (Exception e) {
                System.out.println("Please enter valid numbers");
            }
        }

        System.out.println("Your age is " + age + "!");
        System.out.println();
    }

    /**
     * Method that takes a positive or negative integer and it will count to it.
     */
    public void count() {
        System.out.println("Now I will prove to you that I can count to any number you want.");
        boolean notNumber = true;
        int num = 0;
        while(notNumber) {
            try {
                num = Integer.parseInt(scanner.nextLine());
                notNumber = false;
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
            }
        }
        if (num >= 0) {
            for (int i = 0; i <= num; i++) {
                System.out.printf("%d\n", i);
            }
        }
        else {
            for (int i = 0; i >= num; i--) {
                System.out.printf("%d\n", i);
            }
        }
    }

    /**
     * Method that generates a random number.
     * Client has a scanner to be able to guess what it can be.
     * The amount of guess is tracked.
     */
    public void guess() {
        int count = 0;
        Random randomNumber = new Random();
        int numberToGuess = randomNumber.nextInt(51);
        int guess = 0;
        do {
            System.out.println("Guess a number between 0 and 50: ");
            try {
                guess = scanner.nextInt();
                if(guess < 0 || guess > 50) {
                    System.out.println("The number needs to be between 0 and 50.");
                }
                else if (guess > numberToGuess) {
                    System.out.println("Your guess is too high.");
                    count++;
                }
                else if (guess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                    count++;
                }

            } catch(Exception e) {
                System.out.println("Guess needs to be a valid number.");
            }
        } while(guess != numberToGuess);
        System.out.println("Correct the number was " + numberToGuess + "!");
        System.out.println("It took you " + (count + 1) + " tries!");
    }

    /**
     * Method that prints out a string
     */
    public void end() {
        System.out.println("Thanks for using GameBot. Have a nice day!"); // Do not change this text
    }



}
