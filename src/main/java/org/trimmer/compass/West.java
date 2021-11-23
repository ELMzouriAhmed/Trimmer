package org.trimmer.compass;

import org.trimmer.*;

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
    protected Trimmer doCheckMatrixForMovements(Trimmer tondeuse, Pelouse pelouse) {
        if(tondeuse.horizontal()>1) return
                new Trimmer(tondeuse.horizontal()-1,tondeuse.vertical(), Orientation.W);
        return tondeuse;
    }


}
