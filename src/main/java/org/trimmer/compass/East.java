package org.trimmer.compass;

import org.trimmer.*;

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
    protected Trimmer doCheckMatrixForMovements(Trimmer tondeuse, Pelouse pelouse) {
        if(tondeuse.horizontal()<pelouse.horizental()) return
                new Trimmer(tondeuse.horizontal()+1,tondeuse.vertical(), Orientation.E);
        return tondeuse;
    }




}
