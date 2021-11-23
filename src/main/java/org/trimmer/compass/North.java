package org.trimmer.compass;

import org.trimmer.*;

public class North extends DirectionTemplate {


    @Override
    protected Orientation getRightOrientation() {
        return Orientation.E;
    }

    @Override
    protected Orientation getLeftOrientation() {
        return Orientation.W;
    }

    @Override
    protected Trimmer doCheckMatrixForMovements(Trimmer tondeuse, Pelouse pelouse) {
        if(tondeuse.vertical()<pelouse.vertical())
            return new Trimmer(tondeuse.horizontal(),tondeuse.vertical()+1, Orientation.N);
        return tondeuse;
    }

}
