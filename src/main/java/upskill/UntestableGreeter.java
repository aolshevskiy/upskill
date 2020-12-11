package upskill;

import java.util.Scanner;

public class UntestableGreeter implements Greeter {
    private final Scanner inputScanner = new Scanner(System.in);

    @Override
    public void greet() {
        System.out.print("Please enter your name:");
        String name = inputScanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
