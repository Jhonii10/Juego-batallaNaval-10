package batallaNaval;

import java.util.ArrayList;

/**
 * This class is used to represent the ships that are on the board position
 */

public class BarcosPosicion extends ArrayList<CasillaPosicion> {

    /**
     * Constructor of the BarcosPosicion class
     */

    public BarcosPosicion(){

    }

    /**
     * This function is the frigate
     * @param parte1
     */

    public BarcosPosicion(CasillaPosicion parte1) {
        this.add(parte1);

    }

    /**
     * This function is the destructor
     * @param parte1
     * @param parte2
     */

    public BarcosPosicion(CasillaPosicion parte1, CasillaPosicion parte2) {
        this.add(parte1);
        this.add(parte2);

    }

    /**
     * This function is the submarine
     * @param parte1
     * @param parte2
     * @param parte3
     */

    public BarcosPosicion(CasillaPosicion parte1, CasillaPosicion parte2, CasillaPosicion parte3) {
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

    public BarcosPosicion(CasillaPosicion parte1, CasillaPosicion parte2, CasillaPosicion parte3, CasillaPosicion parte4) {
        this.add(parte1);
        this.add(parte2);
        this.add(parte3);
        this.add(parte4);
    }
}