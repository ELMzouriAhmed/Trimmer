package org.trimmer;


public record Pelouse(int horizental, int vertical) {

    public Trimmer[][] init() {
        return new Trimmer[this.horizental][this.vertical];
    }

}
