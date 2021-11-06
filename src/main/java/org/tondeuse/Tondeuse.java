package org.tondeuse;

import java.util.List;

public record Tondeuse(int horizontal, int vertical, Orientation orientation) {


    public Tondeuse doMovement(Pivot pivot, Pelouse pelouse) {
        return checkOrientation(pivot, pelouse);
    }

    private Tondeuse checkOrientation(Pivot pivot, Pelouse pelouse) {
        return Orientation.valueOf(this.orientation.name()).moveTo(pivot, this, pelouse);
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public String getPosition() {
        return this.horizontal + " " + this.vertical + " " + this.orientation.toString();
    }

    public Tondeuse getGameResult(List<Pivot> asList, Tondeuse tondeuse, Pelouse pelouse) {
        for (Pivot p : asList) {
            tondeuse = tondeuse.doMovement(p, pelouse);
        }
        return tondeuse;
    }
}