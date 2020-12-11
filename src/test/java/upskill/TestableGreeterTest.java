package upskill;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestableGreeterTest {
    @Test
    void greet() {
        String testInput = "world\n";

        InputStream stringInputStream = new ByteArrayInputStream(testInput.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        TestableGreeter greeter = new TestableGreeter(stringInputStream, printStream);
        greeter.greet();

        String output = byteArrayOutputStream.toString();

        assertEquals(output, "Please enter your name:Hello, world!\n");
    }
}
