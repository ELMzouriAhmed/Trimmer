package org.tondeuse.compass;

import org.tondeuse.*;

public class East extends DirectionTemplate {


    @Override
    protected Orientation getRightOrientation() {
        return  Orientation.S;
    }

    @Override
    protected Orientation getLeftOrientation() {
        return Orientation.N;
    }

    @Override
    protected Tondeuse doCheckMatrixForMovements(Tondeuse tondeuse, Pelouse pelouse) {
        if(tondeuse.horizontal()<pelouse.horizental()) return
                new Tondeuse(tondeuse.horizontal()+1,tondeuse.vertical(), Orientation.E);
        return tondeuse;
    }




}
