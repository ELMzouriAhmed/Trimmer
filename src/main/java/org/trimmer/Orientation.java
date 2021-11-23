package org.trimmer;


import org.trimmer.compass.*;

public enum Orientation {
    N{
        @Override
        public Trimmer moveTo(Pivot pivot, Trimmer tondeuse, Pelouse pelouse) {
            return new North().moveTo(pivot,tondeuse,pelouse);
        }

    },E{
        @Override
        public Trimmer moveTo(Pivot pivot, Trimmer tondeuse, Pelouse pelouse){
            return new East().moveTo(pivot,tondeuse,pelouse);
        }
    },W{
        @Override
        public Trimmer moveTo(Pivot pivot, Trimmer tondeuse, Pelouse pelouse){
            return new West().moveTo(pivot,tondeuse,pelouse);
        }
    },S{
        @Override
        public Trimmer moveTo(Pivot pivot, Trimmer tondeuse, Pelouse pelouse){
            return new South().moveTo(pivot,tondeuse,pelouse);
        }
    };
    public abstract Trimmer moveTo(Pivot pivot, Trimmer tondeuse, Pelouse pelouse);
}
