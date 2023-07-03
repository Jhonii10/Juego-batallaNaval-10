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



    }