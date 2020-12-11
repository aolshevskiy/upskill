package upskill;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Optional;
import java.util.Scanner;

public class UserInteractor {
    private final Scanner scanner;
    private final PrintStream output;

    public UserInteractor() {
        this(System.in, System.out);
    }

    public UserInteractor(InputStream input, PrintStream output) {
        this.scanner = new Scanner(input);
        this.output = output;
    }

    public String requestString(String prompt) {
        output.print(prompt);
        return scanner.nextLine();
    }

    public int requestInt(String prompt) {
        while(true) {
            output.print(prompt);
            Integer maybeNumber = tryRequestInt();
            if(maybeNumber == null) {
                output.println("Not a number. " + prompt);
                continue;
            }
            return maybeNumber;
        }
    }

    private Integer tryRequestInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
