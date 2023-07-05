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

    public void setTurnoDeLaIA(boolean turnoDeLaIA) {
        this.turnoDeLaIA = turnoDeLaIA;
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

    /**
     * This function is to create the frigate
     *
     * @param parte1
     */

    public void casillasDelBote(CasillaPosicion parte1) {
        parte1.pintarParteDelBarco("fragata");
        parte1.setTieneBarco(true);
        parte1.setTipoDeBarco("fragata");
        if (fragatas == 0) {
            fragataUsuario1 = new BarcosPosicion(parte1);
            fragatas++;
        } else if (fragatas == 1) {
            fragataUsuario2 = new BarcosPosicion(parte1);
            fragatas++;
        } else if (fragatas == 2) {
            fragataUsuario3 = new BarcosPosicion(parte1);
            fragatas++;
        } else if (fragatas == 3) {
            fragataUsuario4 = new BarcosPosicion(parte1);
            fragatas = 0;
        }
    }

    /**
     * This function determines if the player win
     */

    public boolean determinarGanarUsuario() {
        return puntosUsuario == 20 || ganarUsuario; 
    }

    /**
     * This function determines if the oponent win
     */

    public boolean determinarGanarIA() {
        return puntosIA == 20 || ganarIA;
    }

    /**
     * This function is to create the opponent's aircraft carrier
     *
     * @param parte1
     * @param parte2
     * @param parte3
     * @param parte4
     */

    public void casillasDelBoteIA(CasillaPrincipal parte1, CasillaPrincipal parte2,
                                  CasillaPrincipal parte3, CasillaPrincipal parte4) {
        parte1.setTieneBarco(true);
        parte2.setTieneBarco(true);
        parte3.setTieneBarco(true);
        parte4.setTieneBarco(true);
        parte1.setTipoDeBarco("portaviones");
        parte2.setTipoDeBarco("portaviones");
        parte3.setTipoDeBarco("portaviones");
        parte4.setTipoDeBarco("portaviones");
        portavionIA = new BarcosPrincipal(parte1, parte2, parte3, parte4);
    }

    /**
     * This function is to create the opponent's submarine
     *
     * @param parte1
     * @param parte2
     * @param parte3
     */

    public void casillasDelBoteIA(CasillaPrincipal parte1, CasillaPrincipal parte2,
                                  CasillaPrincipal parte3) {
        parte1.setTieneBarco(true);
        parte2.setTieneBarco(true);
        parte3.setTieneBarco(true);
        parte1.setTipoDeBarco("submarino");
        parte2.setTipoDeBarco("submarino");
        parte3.setTipoDeBarco("submarino");
        if (submarinos == 0) {
            submarinoIA1 = new BarcosPrincipal(parte1, parte2, parte3);
            submarinos++;
        } else if (submarinos == 1) {
            submarinoIA2 = new BarcosPrincipal(parte1, parte2, parte3);
            submarinos = 0;
        }
    }

    /**
     * This function is to create the opponent's destructor
     *
     * @param parte1
     * @param parte2
     */

    public void casillasDelBoteIA(CasillaPrincipal parte1, CasillaPrincipal parte2) {
        parte1.setTieneBarco(true);
        parte2.setTieneBarco(true);
        parte1.setTipoDeBarco("destructor");
        parte2.setTipoDeBarco("destructor");
        if (destructores == 0) {
            destructorIA1 = new BarcosPrincipal(parte1, parte2);
            destructores++;
        } else if (destructores == 1) {
            destructorIA2 = new BarcosPrincipal(parte1, parte2);
            destructores++;
        } else if (destructores == 2) {
            destructorIA3 = new BarcosPrincipal(parte1, parte2);
            destructores = 0;
        }
    }

    /**
     * This function is to create the opponent's frigate
     *
     * @param parte1
     */

    public void casillasDelBoteIA(CasillaPrincipal parte1) {
        parte1.setTieneBarco(true);
        parte1.setTipoDeBarco("fragata");
        if (fragatas == 0) {
            System.out.println("Primer barco creado con éxito");
            fragataIA1 = new BarcosPrincipal(parte1);
            fragatas++;
        } else if (fragatas == 1) {
            fragataIA2 = new BarcosPrincipal(parte1);
            fragatas++;
        } else if (fragatas == 2) {
            fragataIA3 = new BarcosPrincipal(parte1);
            fragatas++;
        } else if (fragatas == 3) {
            fragataIA4 = new BarcosPrincipal(parte1);
            fragatas = 0;
        }
    }

    /**
     * This function paints the opponent's pots
     */

    public void pintarBotesRival() {
        if (!fragataIA1.get(0).getFueImpactada()) {
            fragataIA1.get(0).pintarParteDelBarco("fragata");
        }
        if (!fragataIA2.get(0).getFueImpactada()) {
            fragataIA2.get(0).pintarParteDelBarco("fragata");
        }
        if (!fragataIA3.get(0).getFueImpactada()) {
            fragataIA3.get(0).pintarParteDelBarco("fragata");
        }
        if (!fragataIA4.get(0).getFueImpactada()) {
            fragataIA4.get(0).pintarParteDelBarco("fragata");
        }
        if (!destructorIA1.get(0).getFueImpactada()) {
            destructorIA1.get(0).pintarParteDelBarco("destructor");
        }
        if (!destructorIA1.get(1).getFueImpactada()) {
            destructorIA1.get(1).pintarParteDelBarco("destructor");
        }
        if (!destructorIA2.get(0).getFueImpactada()) {
            destructorIA2.get(0).pintarParteDelBarco("destructor");
        }
        if (!destructorIA2.get(1).getFueImpactada()) {
            destructorIA2.get(1).pintarParteDelBarco("destructor");
        }
        if (!destructorIA3.get(0).getFueImpactada()) {
            destructorIA3.get(0).pintarParteDelBarco("destructor");
        }
        if (!destructorIA3.get(1).getFueImpactada()) {
            destructorIA3.get(1).pintarParteDelBarco("destructor");
        }
        if (!submarinoIA1.get(0).getFueImpactada()) {
            submarinoIA1.get(0).pintarParteDelBarco("submarino");
        }
        if (!submarinoIA1.get(1).getFueImpactada()) {
            submarinoIA1.get(1).pintarParteDelBarco("submarino");
        }
        if (!submarinoIA1.get(2).getFueImpactada()) {
            submarinoIA1.get(2).pintarParteDelBarco("submarino");
        }
        if (!submarinoIA2.get(0).getFueImpactada()) {
            submarinoIA2.get(0).pintarParteDelBarco("submarino");
        }
        if (!submarinoIA2.get(1).getFueImpactada()) {
            submarinoIA2.get(1).pintarParteDelBarco("submarino");
        }
        if (!submarinoIA2.get(2).getFueImpactada()) {
            submarinoIA2.get(2).pintarParteDelBarco("submarino");
        }
        if (!portavionIA.get(0).getFueImpactada()) {
            portavionIA.get(0).pintarParteDelBarco("portaviones");
        }
        if (!portavionIA.get(1).getFueImpactada()) {
            portavionIA.get(1).pintarParteDelBarco("portaviones");
        }
        if (!portavionIA.get(2).getFueImpactada()) {
            portavionIA.get(2).pintarParteDelBarco("portaviones");
        }
        if (!portavionIA.get(3).getFueImpactada()) {
            portavionIA.get(3).pintarParteDelBarco("portaviones");
        }
    }

     /**
     * This function makes the opponent shoot at the player's squares
     *
     * @param casilla
     */

    public void dispararACasillaIA(CasillaPosicion casilla) {
        casilla.setFueImpactada(true);
        if (casilla.getTieneBarco()) {
            if (casilla.getTipoDeBarco().equals("portaviones")) {
                if (portavionUsuario.get(0).getFueImpactada() & portavionUsuario.get(1).getFueImpactada() & portavionUsuario.get(2).getFueImpactada() & portavionUsuario.get(3).getFueImpactada()) {
                    portavionUsuario.get(0).determinarPrecision(6);
                    portavionUsuario.get(1).determinarPrecision(6);
                    portavionUsuario.get(2).determinarPrecision(6);
                    portavionUsuario.get(3).determinarPrecision(6);
                } else {
                    casilla.determinarPrecision(5);
                }
            } else if (casilla.getTipoDeBarco().equals("submarino")) {
                if (casilla == submarinoUsuario1.get(0) || casilla == submarinoUsuario1.get(1) || casilla == submarinoUsuario1.get(2)) {
                    if (submarinoUsuario1.get(0).getFueImpactada() & submarinoUsuario1.get(1).getFueImpactada() & submarinoUsuario1.get(2).getFueImpactada()) {
                        submarinoUsuario1.get(0).determinarPrecision(6);
                        submarinoUsuario1.get(1).determinarPrecision(6);
                        submarinoUsuario1.get(2).determinarPrecision(6);
                    } else {
                        casilla.determinarPrecision(5);
                    }
                } else if (casilla == submarinoUsuario2.get(0) || casilla == submarinoUsuario2.get(1) || casilla == submarinoUsuario2.get(2)) {
                    if (submarinoUsuario2.get(0).getFueImpactada() & submarinoUsuario2.get(1).getFueImpactada() & submarinoUsuario2.get(2).getFueImpactada()) {
                        submarinoUsuario2.get(0).determinarPrecision(6);
                        submarinoUsuario2.get(1).determinarPrecision(6);
                        submarinoUsuario2.get(2).determinarPrecision(6);
                    } else {
                        casilla.determinarPrecision(5);
                    }
                }
            } else if (casilla.getTipoDeBarco().equals("destructor")) {
                if (casilla == destructorUsuario1.get(0) || casilla == destructorUsuario1.get(1)) {
                    if (destructorUsuario1.get(0).getFueImpactada() & destructorUsuario1.get(1).getFueImpactada()) {
                        destructorUsuario1.get(0).determinarPrecision(6);
                        destructorUsuario1.get(1).determinarPrecision(6);
                    } else {
                        casilla.determinarPrecision(5);
                    }
                } else if (casilla == destructorUsuario2.get(0) || casilla == destructorUsuario2.get(1)) {
                    if (destructorUsuario2.get(0).getFueImpactada() & destructorUsuario2.get(1).getFueImpactada()) {
                        destructorUsuario2.get(0).determinarPrecision(6);
                        destructorUsuario2.get(1).determinarPrecision(6);
                    } else {
                        casilla.determinarPrecision(5);
                    }
                } else if (casilla == destructorUsuario3.get(0) || casilla == destructorUsuario3.get(1)) {
                    if (destructorUsuario3.get(0).getFueImpactada() & destructorUsuario3.get(1).getFueImpactada()) {
                        destructorUsuario3.get(0).determinarPrecision(6);
                        destructorUsuario3.get(1).determinarPrecision(6);
                    } else {
                        casilla.determinarPrecision(5);
                    }
                }
            } else if (casilla.getTipoDeBarco().equals("fragata")) {
                casilla.determinarPrecision(6);
            }
            setTurnoDeLaIA(true);
            puntosIA++;
        } else {
            casilla.determinarPrecision(7);
            setTurnoDeLaIA(false);
        }
    }

    /**
     * This function deletes all the ships
     */

    public void borrarBarcos() {
        portavionUsuario.clear();
        portavionUsuario = null;
        submarinoUsuario1.clear();
        submarinoUsuario1 = null;
        submarinoUsuario2.clear();
        submarinoUsuario2 = null;
        destructorUsuario1.clear();
        destructorUsuario1 = null;
        destructorUsuario2.clear();
        destructorUsuario2 = null;
        destructorUsuario3.clear();
        destructorUsuario3 = null;
        fragataUsuario1.clear();
        fragataUsuario1 = null;
        fragataUsuario2.clear();
        fragataUsuario2 = null;
        fragataUsuario3.clear();
        fragataUsuario3 = null;
        fragataUsuario4.clear();
        fragataUsuario4 = null;
        portavionIA.clear();
        portavionIA = null;
        submarinoIA1.clear();
        submarinoIA1 = null;
        submarinoIA2.clear();
        submarinoIA2 = null;
        destructorIA1.clear();
        destructorIA1 = null;
        destructorIA2.clear();
        destructorIA2 = null;
        destructorIA3.clear();
        destructorIA3 = null;
        fragataIA1.clear();
        fragataIA1 = null;
        fragataIA2.clear();
        fragataIA2 = null;
        fragataIA3.clear();
        fragataIA3 = null;
        fragataIA4.clear();
        fragataIA4 = null;
    }

    /**
     * This method changes the value of turnoDeLaIA
     *
     * @param turnoDeLaIA
     */

    public void setTurnoDeLaIA(boolean turnoDeLaIA) {
        this.turnoDeLaIA = turnoDeLaIA;
    }



    
    



    



}