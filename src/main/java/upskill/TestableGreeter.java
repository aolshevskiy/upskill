package upskill;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TestableGreeter implements Greeter {
    private final Scanner inputScanner;
    private final PrintStream output;

    public TestableGreeter() {
        this(System.in, System.out);
    }

    public TestableGreeter(InputStream input, PrintStream output) {
        this.inputScanner = new Scanner(input);
        this.output = output;
    }

    public void greet() {
        output.print("Please enter your name:");
        String name = inputScanner.nextLine();
        output.println("Hello, " + name + "!");
    }
}
