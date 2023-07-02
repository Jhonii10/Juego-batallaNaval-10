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


    /**
     * This function displays an image depending on the shot
     * @param resultadoDeTiro
     */

    public void determinarPrecision(int resultadoDeTiro) {
        insertarElBarco=0;
        if (resultadoDeTiro == 5) {
            this.resultadoDeTiro = 5;
        } else if (resultadoDeTiro == 6) {
            this.resultadoDeTiro = 6;
        } else {
            this.resultadoDeTiro = 7;
        }
        repaint();
    }

    /**
     * This function paints the ships inside the square
     * @param nombreDelBarco
     */

    public void pintarParteDelBarco(String nombreDelBarco) {
        resultadoDeTiro=0;
        if (nombreDelBarco.equals("fragata")) {
            this.tipoDeBarco = nombreDelBarco;
            this.insertarElBarco = 1;
            this.tieneBarco = true;

        } else if (nombreDelBarco.equals("destructor")) {
            this.tipoDeBarco = nombreDelBarco;
            this.insertarElBarco = 2;
            this.tieneBarco = true;

        } else if (nombreDelBarco.equals("submarino")) {
            this.tipoDeBarco = nombreDelBarco;
            this.insertarElBarco = 3;
            this.tieneBarco = true;

        } else if (nombreDelBarco.equals("portaviones")) {
            this.tipoDeBarco = nombreDelBarco;
            this.insertarElBarco = 4;
            this.tieneBarco = true;

        } else if (nombreDelBarco.equals("fondo")) {
            this.insertarElBarco = 5;
        }
        repaint();
    }

    /**
     * Here the images of sunken, water and fail are painted inside the box
     * @param g
     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (resultadoDeTiro) {
            case 5:
                g.setColor(Color.red);
                g.fillRect(0, 0, 46, 46);
                break;
            case 6:
                imageHundido = new ImageIcon(getClass().getResource("/resources/hundido.png"));
                imagenOtroTamanho = imageHundido.getImage().getScaledInstance(46, 46, Image.SCALE_SMOOTH);
                imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
                g.drawImage(imageTransformada.scaledImage(imagenNuevoTamanho.getImage(), 46, 46), 0, 0, this);
                break;
            case 7:
                g.setColor(Color.cyan);
                g.fillRect(0, 0, 46, 46);
                break;
        }
        switch (insertarElBarco) {
            case 1:
                g.setColor(Color.DARK_GRAY);
                g.fillRect(0, 0, 46, 46);
                break;
            case 2:
                g.setColor(Color.pink);
                g.fillRect(0, 0, 46, 46);
                break;
            case 3:
                g.setColor(Color.MAGENTA);
                g.fillRect(0, 0, 46, 46);
                break;
            case 4:
                g.setColor(Color.ORANGE);
                g.fillRect(0, 0, 46, 46);
                break;
            case 5:
                g.setColor(new Color(24, 90, 219));
                g.fillRect(0, 0, 46, 46);
                break;
        }
    }


}
