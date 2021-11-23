import org.trimmer.Orientation;
import org.trimmer.Pelouse;
import org.trimmer.Pivot;
import org.trimmer.Trimmer;
import org.trimmer.exception.NotFoundDataInFileException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record BuildGame(Optional<List<String>> dataFileLines) {

    public BuildGame(Optional<List<String>> dataFileLines) {
        if(dataFileLines.get().isEmpty()) throw new NotFoundDataInFileException("No data found in file ");
        this.dataFileLines = dataFileLines;
    }

    public List<Trimmer> startGame() {
        List<Trimmer> tondeuseList = new ArrayList<>();
        Pelouse pelouse =buildPeleuse(this.dataFileLines.get().get(0));
        int index = 1;
        while (index < this.dataFileLines.get().size()) {
            Trimmer tondeuse = buildTondeuse(this.dataFileLines.get().get(index));
            List<Pivot> pivots = buildPivots(this.dataFileLines.get().get(index + 1));
            index += 2;
            tondeuseList.add(tondeuse.getGameResult(pivots, tondeuse, pelouse));
        }
        return tondeuseList;
    }

    private Pelouse buildPeleuse(String dataFile) {
        String[] peleuseFile = dataFile.split(" ");
        return new Pelouse(Integer.parseInt(peleuseFile[0]),Integer.parseInt(peleuseFile[1]));
    }

    private List<Pivot> buildPivots(String dataFile) {
        String[] pivotsFile = dataFile.split("");
        List<Pivot> pivots = new ArrayList<>();
        for (int i = 0; i < pivotsFile.length; i++) pivots.add(Pivot.valueOf(pivotsFile[i]));
        return pivots;
    }

    private Trimmer buildTondeuse(String dataFile) {
        String[] tondeuseFile = dataFile.split(" ");
        return new Trimmer(Integer.parseInt(tondeuseFile[0]),
                Integer.parseInt(tondeuseFile[1]),
                Orientation.valueOf(tondeuseFile[2]));
    }

}

