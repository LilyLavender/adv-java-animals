package us.mattgreen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInputHelper {
    public UserInputHelper(ArrayList<Talkable> zoo) {
        Scanner sc = new Scanner(System.in);
        String userInput = "";
        // Get animal type
        while (true) {
            System.out.println("What type of animal would you like to create?");
            List<String> allowedAnimals = Arrays.asList("dog", "cat");
            System.out.printf("Valid animal types are: %s\n", String.join(", ", allowedAnimals));
            userInput = sc.nextLine().toLowerCase();
            if (allowedAnimals.contains(userInput)) {
                break;
            }
            System.out.println("Not a valid animal type.");
        }

        // Add animal to list
        if (userInput.equals("dog")) {
            boolean friendly;
            while (true) {
                System.out.println("Enter whether the dog is friendly (y/n):");
                String friendlyStr = sc.nextLine().toLowerCase();
                if (friendlyStr.equals("y")) {
                    friendly = true;
                    break;
                } else if (friendlyStr.equals("n")) {
                    friendly = false;
                    break;
                }
                System.out.println("Invalid input.");
            }
            String name = "";
            while (true) {
                System.out.println("Enter the dog's name:");
                name = sc.nextLine();
                if (name != null) { break; }
                System.out.println("Invalid input.");
            }
            zoo.add(new Dog(friendly, name));
        } else if (userInput.equals("cat")) {
            Integer mousesKilled = null;
            while (true) {
                System.out.println("Enter the number of mice killed:");
                mousesKilled = Integer.parseInt(sc.nextLine());
                if (mousesKilled != null) { break; }
                System.out.println("Invalid input.");
            }
            String name = "";
            while (true) {
                System.out.println("Enter the cat's name:");
                name = sc.nextLine();
                if (name != null) { break; }
                System.out.println("Invalid input.");
            }
            zoo.add(new Cat(mousesKilled, name));
        }
    }
}
