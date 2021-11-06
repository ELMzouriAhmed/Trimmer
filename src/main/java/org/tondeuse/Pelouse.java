package org.tondeuse;

public record Pelouse(int horizental, int vertical) {

    public int getHorizental() {return horizental;}

    public int getVertical() { return vertical; }

    public Tondeuse[][] init() {
        return new Tondeuse[this.horizental][this.vertical];
    }
}
