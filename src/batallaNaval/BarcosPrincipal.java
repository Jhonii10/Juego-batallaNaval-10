package batallaNaval;

import java.util.ArrayList;

/**
 * This class is used to represent the ships that are on the board position
 */

public class BarcosPrincipal extends ArrayList<CasillaPrincipal> {

    /**
     * Constructor of the BarcosPrincipal class
     */

    public BarcosPrincipal(){

    }

    /**
     * This function is the frigate
     * @param parte1
     */

    public BarcosPrincipal(CasillaPrincipal parte1) {
        this.add(parte1);

    }

    /**
     * This function is the destructor
     * @param parte1
     * @param parte2
     */

    public BarcosPrincipal(CasillaPrincipal parte1, CasillaPrincipal parte2) {
        this.add(parte1);
        this.add(parte2);

    }

    /**
     * This function is the submarine
     * @param parte1
     * @param parte2
     * @param parte3
     */

    public BarcosPrincipal(CasillaPrincipal parte1, CasillaPrincipal parte2, CasillaPrincipal parte3) {
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

    public BarcosPrincipal(CasillaPrincipal parte1, CasillaPrincipal parte2, CasillaPrincipal parte3, CasillaPrincipal parte4) {
        this.add(parte1);
        this.add(parte2);
        this.add(parte3);
        this.add(parte4);
    }
}