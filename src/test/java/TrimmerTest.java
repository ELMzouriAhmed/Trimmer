
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.trimmer.Orientation;
import org.trimmer.Pelouse;
import org.trimmer.Pivot;
import org.trimmer.Trimmer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrimmerTest {

    private final static String FILE_NAME = "tondeuse_data";

    private Trimmer[][] matrix;
    private Pelouse pelouse;

    @BeforeEach
    public void GameInit(){
        pelouse = new Pelouse(5,5);
        matrix= pelouse.init();
    }

    @Test
    public void pelouseSize(){
        assertEquals(5,matrix.length);
    }

    @Test
    public void tondeusePosition(){
        matrix[1][2]=new Trimmer(4,2, Orientation.N);
        matrix[1][2]=new Trimmer(1,3, Orientation.E);
        matrix[1][2]=new Trimmer(1,2, Orientation.W);
       assertEquals(matrix[1][2].getPosition(),"1 2 W");
    }

    @Test
    public void checkMovement(){
        matrix[1][2]=new Trimmer(4,2, Orientation.N);
        matrix[1][2]=new Trimmer(1,3, Orientation.E);
        assertEquals(matrix[1][2].orientation(),Orientation.E);
    }


    @Test
    public void gameCheck(){
        Trimmer tondeuse= new Trimmer(2,2, Orientation.W);
        Trimmer tondeuseResult = tondeuse.getGameResult(Arrays.asList
                        (Pivot.D
                        ,Pivot.A    //2 3 N
                        ,Pivot.A    //2 4 N
                        ,Pivot.G,   // 2 4 W
                         Pivot.G    // 2 4 S
                ),tondeuse,pelouse);
        assertEquals(tondeuseResult.getPosition(),"2 4 S");

    }
    @Test
    public void gameCheck2(){
        Trimmer tondeuse= new Trimmer(1,2, Orientation.N);
        Trimmer tondeuseResult = tondeuse.getGameResult(Arrays.asList
              // 1 2 W   1 2 W    1 2 S   1 1 S   1 1 W  1 1 W    1 1 N  1 2 N    1 3 N
                (Pivot.G,Pivot.A,Pivot.G,Pivot.A,Pivot.G,Pivot.A,Pivot.D,Pivot.A,Pivot.A),tondeuse,pelouse);
        assertEquals(tondeuseResult.getPosition(),"1 3 N");

    }
    @Test
    public void gameCheck3(){
        Trimmer tondeuse= new Trimmer(3,3, Orientation.E);
        Trimmer tondeuseResult = tondeuse.getGameResult(Arrays.asList
                (Pivot.A,Pivot.A,Pivot.D,Pivot.A,Pivot.A,Pivot.D,Pivot.A,Pivot.D,Pivot.D,Pivot.A),tondeuse,pelouse);
        assertEquals(tondeuseResult.getPosition(),"5 1 E");
    }

    @Test
    public void checkFileSize() throws IOException, URISyntaxException {
        ParseTondeuseData parseTondeuseData=new ParseTondeuseData(FILE_NAME);
        assertEquals(parseTondeuseData.init().size(),5);
    }
    @Test
    public void checkFileData() throws IOException, URISyntaxException {
        ParseTondeuseData parseTondeuseData=new ParseTondeuseData(FILE_NAME);
        assertEquals(parseTondeuseData.init().get(0),"5 5");
    }
    @Test
    public void checkFileDataLine2() throws IOException, URISyntaxException {
        ParseTondeuseData parseTondeuseData=new ParseTondeuseData(FILE_NAME);
        assertEquals(parseTondeuseData.init().get(1),"1 2 N");
    }
    @Test
    public void checkStartGame() throws IOException, URISyntaxException {
        BuildGame buildGame=new BuildGame(Optional.ofNullable(new ParseTondeuseData(FILE_NAME).init()));
        assertEquals(buildGame.startGame().get(0).getPosition(),"1 3 N");
    }


}
