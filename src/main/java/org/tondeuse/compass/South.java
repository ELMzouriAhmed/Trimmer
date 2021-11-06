package org.tondeuse.compass;

import org.tondeuse.*;

public class South implements Direction {

    @Override
    public Tondeuse moveTo(Pivot pivot, Tondeuse tondeuse,Pelouse pelouse) {
        if(pivot.equals(Pivot.G)) return  new Tondeuse(tondeuse.getHorizontal(),tondeuse.getVertical(), Orientation.W);
        if(pivot.equals(Pivot.D)) return  new Tondeuse(tondeuse.getHorizontal(),tondeuse.getVertical(), Orientation.E);
        if(pivot.equals(Pivot.A)) return checkMatrix(tondeuse,pelouse);
        return null;
    }

    private Tondeuse checkMatrix(Tondeuse tondeuse, Pelouse pelouse) {
        if(tondeuse.getVertical()>1) return
                new Tondeuse(tondeuse.getHorizontal(),tondeuse.getVertical()-1, Orientation.S);
        return new Tondeuse(tondeuse.getHorizontal(),tondeuse.getVertical(), Orientation.S);
    }
}
