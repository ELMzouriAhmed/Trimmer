package org.trimmer.compass;

import org.trimmer.*;

public abstract class DirectionTemplate {

    public Trimmer moveTo(Pivot pivot, Trimmer tondeuse, Pelouse pelouse){
        if(pivot.equals(Pivot.G)) return  new Trimmer(tondeuse.horizontal(),tondeuse.vertical(), getLeftOrientation());
        if(pivot.equals(Pivot.D)) return  new Trimmer(tondeuse.horizontal(),tondeuse.vertical(), getRightOrientation());
        if(pivot.equals(Pivot.A)) return doCheckMatrixForMovements(tondeuse,pelouse);
        return tondeuse;
    }

    protected abstract Orientation getRightOrientation();

    protected abstract Orientation getLeftOrientation();

    protected abstract Trimmer doCheckMatrixForMovements(Trimmer tondeuse, Pelouse pelouse);

}
