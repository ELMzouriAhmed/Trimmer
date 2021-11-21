package org.tondeuse.compass;

import org.tondeuse.*;

public class South extends DirectionTemplate {


    @Override
    protected Orientation getRightOrientation() {
        return Orientation.E;
    }

    @Override
    protected Orientation getLeftOrientation() {
        return Orientation.W;
    }

    @Override
    protected Tondeuse doCheckMatrixForMovements(Tondeuse tondeuse, Pelouse pelouse) {
        if(tondeuse.vertical()>1) return
                new Tondeuse(tondeuse.horizontal(),tondeuse.vertical()-1, Orientation.S);
        return tondeuse;
    }


}
