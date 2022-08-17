package file;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.joining;

public class LineByLineFileReader {

    private final String fileName;

    public LineByLineFileReader(String fileName) {
        this.fileName = fileName;
    }

    public String readFile() {
        try {
            URI uri = requireNonNull(getClass().getClassLoader().getResource(fileName)).toURI();
            Path path = Paths.get(uri);
            return Files.lines(path).collect(joining("\n"));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
