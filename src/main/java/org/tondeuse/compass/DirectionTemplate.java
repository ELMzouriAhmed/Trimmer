package org.tondeuse.compass;

import org.tondeuse.*;

public abstract class DirectionTemplate {

    public Tondeuse moveTo(Pivot pivot, Tondeuse tondeuse, Pelouse pelouse){
        if(pivot.equals(Pivot.G)) return  new Tondeuse(tondeuse.horizontal(),tondeuse.vertical(), getLeftOrientation());
        if(pivot.equals(Pivot.D)) return  new Tondeuse(tondeuse.horizontal(),tondeuse.vertical(), getRightOrientation());
        if(pivot.equals(Pivot.A)) return doCheckMatrixForMovements(tondeuse,pelouse);
        return tondeuse;
    }

    protected abstract Orientation getRightOrientation();

    protected abstract Orientation getLeftOrientation();

    protected abstract Tondeuse doCheckMatrixForMovements(Tondeuse tondeuse, Pelouse pelouse);

}
