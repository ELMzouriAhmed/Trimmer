package org.tondeuse.compass;

import org.tondeuse.*;

public class West implements Direction {

    @Override
    public Tondeuse moveTo(Pivot pivot, Tondeuse tondeuse, Pelouse pelouse) {
        if(pivot.equals(Pivot.G)) return  new Tondeuse(tondeuse.getHorizontal(),tondeuse.getVertical(), Orientation.S);
        if(pivot.equals(Pivot.D)) return  new Tondeuse(tondeuse.getHorizontal(),tondeuse.getVertical(), Orientation.N);
        if(pivot.equals(Pivot.A)) return checkMatrix(tondeuse);
        return null;
    }

    private Tondeuse checkMatrix(Tondeuse tondeuse) {
        if(tondeuse.getHorizontal()>1) return
                new Tondeuse(tondeuse.getHorizontal()-1,tondeuse.getVertical(), Orientation.W);
        return new Tondeuse(tondeuse.getHorizontal(),tondeuse.getVertical(), Orientation.W);
    }
}
