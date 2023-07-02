package batallaNaval;

import javax.swing.*;
import java.awt.*;

public class CasillaPosicion extends JButton {
    private int fila, columna, insertarElBarco, resultadoDeTiro;
    private String tipoDeBarco;
    private boolean tieneBarco, fueImpactada;
    private ImageIcon imageHundido, imagenNuevoTamanho;
    private Image imagenOtroTamanho;
    private ImageIconToImage imageTransformada;

    /**
     * Constructor of CasillaPosicion class
     * @param fila
     * @param columna
     */

    public CasillaPosicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.setPreferredSize(new Dimension(46, 46));
        setBackground(new Color(24, 90, 219));

        imageTransformada = new ImageIconToImage();
        tieneBarco = false;
        fueImpactada = false;

        resultadoDeTiro=0;
        insertarElBarco=0;
    }

}
