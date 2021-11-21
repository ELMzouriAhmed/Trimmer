package org.tondeuse.compass;

import org.tondeuse.*;

public class West extends DirectionTemplate {

    @Override
    protected Orientation getRightOrientation() {
        return Orientation.N;
    }

    @Override
    protected Orientation getLeftOrientation() {
        return Orientation.S;
    }

    @Override
    protected Tondeuse doCheckMatrixForMovements(Tondeuse tondeuse, Pelouse pelouse) {
        if(tondeuse.horizontal()>1) return
                new Tondeuse(tondeuse.horizontal()-1,tondeuse.vertical(), Orientation.W);
        return tondeuse;
    }


}
