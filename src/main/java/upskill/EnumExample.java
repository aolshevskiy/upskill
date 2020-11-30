package upskill;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EnumExample {

    public enum Transport {
        PLANE("Plane"), BUS("Bus"), TRAIN("Train");

        private final String readableName;

        Transport(String readableName) {
            this.readableName = readableName;
        }
    }

    public static class Tour {
        private final Transport transport;

        Tour(Transport transport) {
            this.transport = transport;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String choices = IntStream.rangeClosed(1, Transport.values().length)
                .mapToObj(i -> {
                    return String.format("%d - %s", i, Transport.values()[i - 1].readableName);
                })
                .collect(Collectors.joining(", "));

        System.out.println(choices);

        System.out.print(String.format("Please select transport(%s):", choices));

        int selection = scanner.nextInt();

        Transport transport = Transport.values()[selection - 1];

        System.out.println(transport);
    }
}
