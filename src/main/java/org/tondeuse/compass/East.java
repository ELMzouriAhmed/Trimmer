package org.tondeuse.compass;

import org.tondeuse.*;

public class East implements Direction {

    @Override
    public Tondeuse moveTo(Pivot pivot, Tondeuse tondeuse,Pelouse pelouse) {
        if(pivot.equals(Pivot.G)) return  new Tondeuse(tondeuse.getHorizontal(),tondeuse.getVertical(), Orientation.N);
        if(pivot.equals(Pivot.D)) return  new Tondeuse(tondeuse.getHorizontal(),tondeuse.getVertical(), Orientation.S);
        if(pivot.equals(Pivot.A)) return checkMatrix(tondeuse,pelouse);
        return tondeuse;
    }

    private Tondeuse checkMatrix(Tondeuse tondeuse, Pelouse pelouse) {
        if(tondeuse.getHorizontal()<pelouse.getHorizental()) return
                new Tondeuse(tondeuse.getHorizontal()+1,tondeuse.getVertical(), Orientation.E);
        return new Tondeuse(tondeuse.getHorizontal(),tondeuse.getVertical(), Orientation.E);
    }


}
