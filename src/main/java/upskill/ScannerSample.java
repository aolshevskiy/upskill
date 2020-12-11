package upskill;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class ScannerSample {
    public static void main(String[] args) {
        String input = "10\n";

        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        int i = scanner.nextInt();
        String l = scanner.nextLine();

        System.out.println(Arrays.asList("'" + i + "'", "'" + l + "'")); // => ['10', '']
    }
}
