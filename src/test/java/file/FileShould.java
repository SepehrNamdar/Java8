package file;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FileShould {

    @Test
    void read_a_file_line_by_line() {
        LineByLineFileReader reader = new LineByLineFileReader("test.txt");

        String content = reader.readFile();

        assertThat(content).isEqualTo("line 1\nline 2\nline 3\nline 4\nline 5");
    }
}
