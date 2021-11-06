import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public record ParseTondeuseData(String fileName) {

    public List<String> init() throws URISyntaxException, IOException {
        URL url = getClass().getClassLoader().getResource(this.fileName);
        File file = new File(url.toURI());
        return Files.readAllLines(Path.of(file.getPath()));
    }
}
