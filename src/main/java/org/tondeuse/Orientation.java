package org.tondeuse;


import org.tondeuse.compass.*;

public enum Orientation {
    N{
        @Override
        public Tondeuse moveTo(Pivot pivot, Tondeuse tondeuse, Pelouse pelouse) {
            return new North().moveTo(pivot,tondeuse,pelouse);
        }

    },E{
        @Override
        public Tondeuse moveTo(Pivot pivot, Tondeuse tondeuse, Pelouse pelouse){
            return new East().moveTo(pivot,tondeuse,pelouse);
        }
    },W{
        @Override
        public Tondeuse moveTo(Pivot pivot, Tondeuse tondeuse, Pelouse pelouse){
            return new West().moveTo(pivot,tondeuse,pelouse);
        }
    },S{
        @Override
        public Tondeuse moveTo(Pivot pivot, Tondeuse tondeuse, Pelouse pelouse){
            return new South().moveTo(pivot,tondeuse,pelouse);
        }
    };
    public abstract Tondeuse moveTo(Pivot pivot, Tondeuse tondeuse, Pelouse pelouse);
}
