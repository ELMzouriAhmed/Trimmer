package org.tondeuse;


public record Pelouse(int horizental, int vertical) {

    public Tondeuse[][] init() {
        return new Tondeuse[this.horizental][this.vertical];
    }

}
