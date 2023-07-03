package batallaNaval;

/**
 * This class is used to implement the game logic and rules
 */

public class ModelBatallaNaval {
    private BarcosPosicion portavionUsuario, submarinoUsuario1, submarinoUsuario2, destructorUsuario1, destructorUsuario2,
            destructorUsuario3, fragataUsuario1, fragataUsuario2, fragataUsuario3, fragataUsuario4;
    private BarcosPrincipal portavionIA, submarinoIA1, submarinoIA2, destructorIA1, destructorIA2, destructorIA3,
            fragataIA1, fragataIA2, fragataIA3, fragataIA4;
    private int puntosUsuario, puntosIA, fragatas, destructores, submarinos;
    private boolean ganarUsuario, ganarIA, turnoDeLaIA;

    /**
     * Constructor of ModelBatallaNaval class
     */

    public ModelBatallaNaval() {
        puntosUsuario = 0;
        puntosIA = 0;
        ganarIA = false;
        ganarUsuario = false;
    }


    }