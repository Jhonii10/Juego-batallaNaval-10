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
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //Create Listener Object and Control Object
        escucha = new Escucha();
        game = new ModelBatallaNaval();
        //Set up JComponents

        imagenInstrucciones = new ImageIcon(getClass().getResource("/resources/instrucciones.PNG"));
        imagenOtroTamanho = imagenInstrucciones.getImage().getScaledInstance(300,500,Image.SCALE_SMOOTH);
        imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);

        imagen = new JLabel(imagenNuevoTamanho);

        panelInstrucciones = new JPanel();
        panelInstrucciones.setPreferredSize(new Dimension(350,900));
        panelInstrucciones.setBackground(Color.WHITE);
        panelInstrucciones.setBorder(BorderFactory.createTitledBorder("Instrucciones del juego."));
        panelInstrucciones.setFont(new Font(Font.DIALOG,Font.BOLD,40));
        panelInstrucciones.setLayout(new BorderLayout());

        instrucciones = new JTextArea();
        instrucciones.setBackground(null);
        instrucciones.setText(INSTRUCCIONES);
        instrucciones.setLineWrap(true);
        instrucciones.setPreferredSize(new Dimension(350, 390));
        instrucciones.setWrapStyleWord(true);
        instrucciones.setLineWrap(true);
        instrucciones.setEditable(false);

        cantidadFragatas = 4;
        cantidadDestructores = 3;
        cantidadSubmarinos = 2;
        cantidadPortaviones = 1;
        orientacion = 0;
        marcadorBarcosIA=1;

        casillaPosicionSeleccionada = new CasillaPosicion(0, 0);
        casillaPrincipalSeleccionada = new CasillaPrincipal(0, 0);

        headerProject = new Header("Batalla Naval", new Color(0, 0, 0));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 12;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        this.add(headerProject, constraints);

         //------------------------------------------------------------------------------------------------------------------------

        espacio1 = new JPanel();
        espacio1.setOpaque(false);
        espacio1.setPreferredSize(new Dimension(50, 600));
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 8;
        constraints.fill = GridBagConstraints.VERTICAL;

        this.add(espacio1, constraints);

        //-------------------------------------------------------------------------------------------------------------------------

        espacio2 = new JPanel();
        espacio2.setOpaque(false);
        espacio2.setPreferredSize(new Dimension(50, 50));
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(espacio2, constraints);

        //-------------------------------------------------------------------------------------------------------------------------

        fragata = new JButton();
        fragata.setBackground(Color.white);
        unaImagen = new ImageIcon(getClass().getResource("/resources/1.PNG"));
        imagenOtroTamanho = unaImagen.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
        fragata.setIcon(imagenNuevoTamanho);
        fragata.addMouseListener(escucha);
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(fragata, constraints);

    //-------------------------------------------------------------------------------------------------------------------------

        destructor = new JButton();
        destructor.setBackground(Color.white);
        unaImagen = new ImageIcon(getClass().getResource("/resources/2.PNG"));
        imagenOtroTamanho = unaImagen.getImage().getScaledInstance(50, 25, Image.SCALE_SMOOTH);
        imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
        destructor.setIcon(imagenNuevoTamanho);
        destructor.addMouseListener(escucha);
        constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(destructor, constraints);

    //-------------------------------------------------------------------------------------------------------------------------

        submarino = new JButton();
        submarino.setBackground(Color.white);
        unaImagen = new ImageIcon(getClass().getResource("/resources/3.PNG"));
        imagenOtroTamanho = unaImagen.getImage().getScaledInstance(75, 25, Image.SCALE_SMOOTH);
        imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
        submarino.setIcon(imagenNuevoTamanho);
        submarino.addMouseListener(escucha);
        constraints.gridx = 4;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(submarino, constraints);

         //-------------------------------------------------------------------------------------------------------------------------

        portavion = new JButton();
        portavion.setBackground(Color.white);
        unaImagen = new ImageIcon(getClass().getResource("/resources/4.PNG"));
        imagenOtroTamanho = unaImagen.getImage().getScaledInstance(100, 25, Image.SCALE_SMOOTH);
        imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
        portavion.setIcon(imagenNuevoTamanho);
        portavion.addMouseListener(escucha);
        constraints.gridx = 5;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(portavion, constraints);

        //-------------------------------------------------------------------------------------------------------------------------

        espacio6 = new JPanel();
        espacio6.setOpaque(false);
        espacio6.setPreferredSize(new Dimension(50, 50));
        constraints.gridx = 6;
        constraints.gridy = 2;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.CENTER;

        this.add(espacio6, constraints);






}
