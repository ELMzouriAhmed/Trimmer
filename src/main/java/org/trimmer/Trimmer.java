package org.trimmer;

import java.util.List;

public record Trimmer(int horizontal, int vertical, Orientation orientation) {

    public Trimmer doMovement(Pivot pivot, Pelouse pelouse) {
        return checkOrientation(pivot, pelouse);
    }

    private Trimmer checkOrientation(Pivot pivot, Pelouse pelouse) {
        return Orientation.valueOf(this.orientation.name()).moveTo(pivot, this, pelouse);
    }

    public String getPosition() {
        return this.horizontal + " " + this.vertical + " " + this.orientation.toString();
    }

    public Trimmer getGameResult(List<Pivot> asList, Trimmer tondeuse, Pelouse pelouse) {
        for (Pivot p : asList) {
            tondeuse = tondeuse.doMovement(p, pelouse);
        }
        return tondeuse;
    }
}