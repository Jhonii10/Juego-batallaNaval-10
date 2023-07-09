package batallaNaval;

import java.util.ArrayList;

/**
 * This class is used to represent the ships that are on the board position
 */

public class BoatPosition extends ArrayList<PositionBox> {

    /**
     * Constructor of the BarcosPosicion class
     */

    public BoatPosition(){

    }

    /**
     * This function is the frigate
     * @param parte1
     */

    public BoatPosition(PositionBox parte1) {
        this.add(parte1);

    }

    /**
     * This function is the destructor
     * @param parte1
     * @param parte2
     */

    public BoatPosition(PositionBox parte1, PositionBox parte2) {
        this.add(parte1);
        this.add(parte2);

    }

    /**
     * This function is the submarine
     * @param parte1
     * @param parte2
     * @param parte3
     */

    public BoatPosition(PositionBox parte1, PositionBox parte2, PositionBox parte3) {
        this.add(parte1);
        this.add(parte2);
        this.add(parte3);

    }

    /**
     * This function is the aircraft carrier
     * @param parte1
     * @param parte2
     * @param parte3
     * @param parte4
     */

    public BoatPosition(PositionBox parte1, PositionBox parte2, PositionBox parte3, PositionBox parte4) {
        this.add(parte1);
        this.add(parte2);
        this.add(parte3);
        this.add(parte4);
    }
}