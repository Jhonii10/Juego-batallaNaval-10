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

    /**
     * This function is to shoot at a square
     *
     * @param casilla
     */

    public void dispararACasillaUsuario(CasillaPrincipal casilla) {
        casilla.setFueImpactada(true);
        if (casilla.getTieneBarco()) {
        String tipoDeBarco = casilla.getTipoDeBarco();
            if (tipoDeBarco.equals("portaviones")) {
                if (portavionIA.get(0).getFueImpactada() && portavionIA.get(1).getFueImpactada() && portavionIA.get(2).getFueImpactada() && portavionIA.get(3).getFueImpactada()) {
                    portavionIA.forEach(c -> c.determinarPrecision(6));
                } else {
                    casilla.determinarPrecision(5);
                }
            } else if (tipoDeBarco.equals("submarino")) {
                boolean submarino1Impactado = submarinoIA1.stream().allMatch(CasillaPrincipal::getFueImpactada);
                boolean submarino2Impactado = submarinoIA2.stream().allMatch(CasillaPrincipal::getFueImpactada);
            
                 if (submarino1Impactado && submarinoIA1.contains(casilla)) {
                submarinoIA1.forEach(c -> c.determinarPrecision(6));
                } else if (submarino2Impactado && submarinoIA2.contains(casilla)) {
                submarinoIA2.forEach(c -> c.determinarPrecision(6));
                 } else {
                casilla.determinarPrecision(5);
                }
                } else if (tipoDeBarco.equals("destructor")) {
                boolean destructor1Impactado = destructorIA1.stream().allMatch(CasillaPrincipal::getFueImpactada);
                boolean destructor2Impactado = destructorIA2.stream().allMatch(CasillaPrincipal::getFueImpactada);
                boolean destructor3Impactado = destructorIA3.stream().allMatch(CasillaPrincipal::getFueImpactada);
            
                if (destructor1Impactado && destructorIA1.contains(casilla)) {
                destructorIA1.forEach(c -> c.determinarPrecision(6));
                } else if (destructor2Impactado && destructorIA2.contains(casilla)) {
                destructorIA2.forEach(c -> c.determinarPrecision(6));
                } else if (destructor3Impactado && destructorIA3.contains(casilla)) {
                destructorIA3.forEach(c -> c.determinarPrecision(6));
                } else {
                casilla.determinarPrecision(5);
                }
            } else if (tipoDeBarco.equals("fragata")) {
            casilla.determinarPrecision(6);
            }
            puntosUsuario++;
            setTurnoDeLaIA(false);
            } else {
            casilla.determinarPrecision(7);
            setTurnoDeLaIA(true);
        }
    }

    /**
     * This function is to create the aircraft carrier
     *
     * @param parte1
     * @param parte2
     * @param parte3
     * @param parte4
     */

    public void casillasDelBote(CasillaPosicion parte1, CasillaPosicion parte2,
                                CasillaPosicion parte3, CasillaPosicion parte4) {
        parte1.pintarParteDelBarco("portaviones");
        parte1.setTieneBarco(true);
        parte2.pintarParteDelBarco("portaviones");
        parte2.setTieneBarco(true);
        parte3.pintarParteDelBarco("portaviones");
        parte3.setTieneBarco(true);
        parte4.pintarParteDelBarco("portaviones");
        parte4.setTieneBarco(true);
        parte1.setTipoDeBarco("portaviones");
        parte2.setTipoDeBarco("portaviones");
        parte3.setTipoDeBarco("portaviones");
        parte4.setTipoDeBarco("portaviones");
        portavionUsuario = new BarcosPosicion(parte1, parte2, parte3, parte4);
    }

    /**
     * This function is to create the submarine
     *
     * @param parte1
     * @param parte2
     * @param parte3
     */

    public void casillasDelBote(CasillaPosicion parte1, CasillaPosicion parte2,
                                CasillaPosicion parte3) {
        parte1.pintarParteDelBarco("submarino");
        parte1.setTieneBarco(true);
        parte2.pintarParteDelBarco("submarino");
        parte2.setTieneBarco(true);
        parte3.pintarParteDelBarco("submarino");
        parte3.setTieneBarco(true);
        parte1.setTipoDeBarco("submarino");
        parte2.setTipoDeBarco("submarino");
        parte3.setTipoDeBarco("submarino");
        if (submarinos == 0) {
            submarinoUsuario1 = new BarcosPosicion(parte1, parte2, parte3);
            submarinos++;
        } else if (submarinos == 1) {
            submarinoUsuario2 = new BarcosPosicion(parte1, parte2, parte3);
            submarinos = 0;
        }
    }

    /**
     * This function is to create the destructor
     *
     * @param parte1
     * @param parte2
     */

    public void casillasDelBote(CasillaPosicion parte1, CasillaPosicion parte2) {
        parte1.pintarParteDelBarco("destructor");
        parte1.setTieneBarco(true);
        parte2.pintarParteDelBarco("destructor");
        parte2.setTieneBarco(true);
        parte1.setTipoDeBarco("destructor");
        parte2.setTipoDeBarco("destructor");
        if (destructores == 0) {
            destructorUsuario1 = new BarcosPosicion(parte1, parte2);
            destructores++;
        } else if (destructores == 1) {
            destructorUsuario2 = new BarcosPosicion(parte1, parte2);
            destructores++;
        } else if (destructores == 2) {
            destructorUsuario3 = new BarcosPosicion(parte1, parte2);
            destructores = 0;
        }
    }



}