package org.tondeuse.compass;

import org.tondeuse.*;

public interface Direction {
    Tondeuse moveTo(Pivot pivot, Tondeuse tondeuse, Pelouse pelouse);
}
