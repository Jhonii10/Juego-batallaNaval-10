package batallaNaval;

import javax.swing.*;
import java.awt.*;

public class CasillaPrincipal extends JButton{

    private int fila, columna, resultadoDeTiro, insertarElBarco;
    private String tipoDeBarco;
    private ImageIcon imageHundido, imagenNuevoTamanho;
    private Image imagenOtroTamanho;
    private ImageIconToImage imageTransformada;
    private boolean tieneBarco, fueImpactada;

    /**
     * Constructor of CasillaPrincipal class
     * @param fila
     * @param columna
     */

    public CasillaPrincipal(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.setPreferredSize(new Dimension(46, 46));
        setBackground(new Color(24, 90, 219));

        imageTransformada = new ImageIconToImage();

        resultadoDeTiro = 0;
        insertarElBarco = 0;
        tieneBarco = false;
        fueImpactada = false;
    }

}
