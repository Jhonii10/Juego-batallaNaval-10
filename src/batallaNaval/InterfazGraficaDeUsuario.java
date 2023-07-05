package batallaNaval;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class InterfazGraficaDeUsuario extends JFrame {

    private Header headerProject;
    private PintarTablero tableroPrincipal, tableroPosicion;
    private CasillaPrincipal[][] casillasPrincipal;
    private ModelBatallaNaval game;
    private CasillaPrincipal casillaPrincipalSeleccionada;
    private CasillaPosicion[][] casillasPosicion;
    private CasillaPosicion casillaPosicionSeleccionada;
    private Escucha escucha;
    private JPanel espacio1, espacio2, espacio3, espacio4, espacio5, espacio6, espacio7, panelInfo, panelInstrucciones;
    private JTextArea instrucciones;
    private JButton fragata, portavion, submarino, destructor, ayuda, salir, trampa;
    private JLabel infoFallo, imagenFallo, infoImpacto, imagenImpacto, infoHundido, imagenHundido,
            indicativoTableroPosicion, indicativoTableroPrincipal, imagen;
    private ImageIcon unaImagen, imagenNuevoTamanho, imagenInstrucciones;
    private Image imagenOtroTamanho;
    private int cantidadFragatas, cantidadDestructores, cantidadSubmarinos, cantidadPortaviones, orientacion, marcadorBarcosIA;
    private boolean acceso, trampaAbilitada, enPartida = false;
    private String cualBarco = "";
    private  static final String INSTRUCCIONES = "El obetivo del juego es derribar todos los barcos del oponente antes"
            + " de que él derribe los tuyos. Si lo logras, habrás ganado la partida.\n"
            + "\nPara ubicar los barcos debes seleccionar el barco que deseas colocar, escoger su orientación"
            + " y colocarlo en el lugar deseado.\n"
            + "\nRecuerda que tienes una cantidad limitada de cada barco y cada uno ocupa un espacio diferente:\n"
            + "\nFragata: es de color negro y ocupa un espacio. Posees 4 de ellas.\n"
            + "Destructor: es de color piel y ocupa 2 espacios. Posees 3 de ellos.\n"
            + "Submarino: es de color rosa y ocupa 3 espacios. Posees 2 de ellos.\n"
            + "Portavión: es de color amarillo y ocupa 4 espacios. Posees solo 1.\n"
            + "\nPara dispararle al enemigo, debes seleccionar casillas en el Tablero principal. En este tablero se"
            + " mostrarán íconos según: 1) No le das a ningún barco del enemigo (se muestra fallo), 2) Le das solo a una"
            + " parte del barco (se muestra impacto) y 3)"
            + " Hundes el barco por completo (se muestra hundido). Además, si cuando disparas aciertas, puedes seguir"
            + " lanzando hasta fallar, sino pierdes turno y lanza el oponente. Para el oponente funciona igual.\n"
            + "\nEstos son los íconos:\n";
    private  static final String MENSAJE_INICIO = "¡Bienvenido a Batalla Naval!\n"
            + "\nComienza ubicando los barcos en el Tablero de posición.\n"
            + "\n¡Buena suerte!";

    /**
     * Constructor of GUI class
     */
    public InterfazGraficaDeUsuario(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Batalla naval");
        this.setSize(200,100);
        //this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        //Set up JComponents
        headerProject = new Header("Batalla Naval", Color.BLACK);

        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            InterfazGraficaDeUsuario miProjectGUI = new InterfazGraficaDeUsuario();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha {

    }
}
