import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

public class StartGame {

    private final static String FILE_NAME="tondeuse_data";

    public static void main(String[] args) throws URISyntaxException, IOException {

        new BuildGame(Optional.ofNullable(new ParseTondeuseData(FILE_NAME)
                              .init()))
                              .startGame()
                              .forEach(t-> System.out.println(t.getPosition()));
    }
}
