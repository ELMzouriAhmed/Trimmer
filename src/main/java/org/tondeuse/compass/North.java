package org.tondeuse.compass;

import org.tondeuse.*;

public class North implements Direction {

    @Override
    public Tondeuse moveTo(Pivot pivot, Tondeuse tondeuse,Pelouse pelouse) {
        if(pivot.equals(Pivot.G)) return  new Tondeuse(tondeuse.getHorizontal(),tondeuse.getVertical(), Orientation.W);
        if(pivot.equals(Pivot.D)) return  new Tondeuse(tondeuse.getHorizontal(),tondeuse.getVertical(), Orientation.E);
        if(pivot.equals(Pivot.A)) return checkMatrix(tondeuse,pelouse);
        return tondeuse;
    }

    private Tondeuse checkMatrix(Tondeuse tondeuse, Pelouse pelouse) {
        if(tondeuse.getVertical()<pelouse.getVertical()) return
                new Tondeuse(tondeuse.getHorizontal(),tondeuse.getVertical()+1, Orientation.N);
        return new Tondeuse(tondeuse.getHorizontal(),tondeuse.getVertical(), Orientation.N);
    }
}
