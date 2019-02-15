package streams;

import org.junit.jupiter.api.Test;
import streams.LowerCaseInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LowerCaseStreamShould {

    @Test
    void convert_strings_to_lower_case() {
        String input = "HellO mY nAmE iS NIck";

        int c;
        String actualString = readInput(input);

        String expectedString = "hello my name is nick";
        assertEquals(expectedString, actualString);
    }

    private String readInput(String input) {
        StringBuilder sb = new StringBuilder();
        int c;
        try (var lowerCaseStream = new LowerCaseInputStream(new ByteArrayInputStream(input.getBytes()))) {
            while ((c = lowerCaseStream.read()) >= 0) {
                sb.append((char)c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
