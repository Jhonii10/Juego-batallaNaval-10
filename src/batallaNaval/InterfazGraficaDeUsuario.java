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

        //-------------------------------------------------------------------------------------------------------------------------

        ayuda = new JButton(" ? ");
        ayuda.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 15));
        ayuda.setForeground(Color.black);
        ayuda.setBackground(new Color(251, 255, 0));
        ayuda.addMouseListener(escucha);
        constraints.gridx = 7;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        add(ayuda, constraints);

        //-------------------------------------------------------------------------------------------------------------------------

        salir = new JButton("Salir");
        salir.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 15));
        salir.setForeground(Color.black);
        salir.setBackground(new Color(192, 0, 0));
        salir.addMouseListener(escucha);
        constraints.gridx = 9;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        add(salir, constraints);

        //-------------------------------------------------------------------------------------------------------------------------

        espacio3 = new JPanel();
        espacio3.setOpaque(false);
        espacio3.setPreferredSize(new Dimension(50, 50));
        constraints.gridx = 11;
        constraints.gridy = 1;
        constraints.gridheight = 8;
        constraints.fill = GridBagConstraints.VERTICAL;

        this.add(espacio3, constraints);

        //-------------------------------------------------------------------------------------------------------------------------

        espacio4 = new JPanel();
        espacio4.setOpaque(false);
        espacio4.setPreferredSize(new Dimension(50, 50));
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 12;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(espacio4, constraints);

        //-------------------------------------------------------------------------------------------------------------------------

        panelInfo = new JPanel();
        panelInfo.setBorder(BorderFactory.createTitledBorder("Información"));
        panelInfo.setBackground(Color.white);
        constraints.gridx = 8;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        addInfo();

        this.add(panelInfo, constraints);

        //-------------------------------------------------------------------------------------------------------------------------

        espacio5 = new JPanel();
        espacio5.setOpaque(false);
        espacio5.setPreferredSize(new Dimension(50, 30));
        constraints.gridx = 8;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(espacio5, constraints);

        //-------------------------------------------------------------------------------------------------------------------------

        trampa = new JButton("tablero de posición del oponente");
        trampa.setFont(new Font("SansSerif", Font.PLAIN, 12));
        trampa.setForeground(Color.black);
        trampa.setBackground(Color.white);
        trampa.addMouseListener(escucha);
        constraints.gridx = 8;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        add(trampa, constraints);

        tableroPosicion = new PintarTablero();
        tableroPosicion.decoradoDelTablero();

        casillasPosicion = new CasillaPosicion[11][11];


        /**
         * This for creates the array of buttons in the position board
         */

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                casillasPosicion[i][j] = new CasillaPosicion(i, j);
                casillasPosicion[i][j].removeMouseListener(escucha);
                tableroPosicion.add(casillasPosicion[i][j]);
                if (i == 0 || j == 0) {
                    casillasPosicion[i][j].setVisible(false);
                }
            }
        }
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 6;
        constraints.gridheight = 4;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(tableroPosicion, constraints);

        //-------------------------------------------------------------------------------------------------------------------------


        tableroPrincipal = new PintarTablero();
        tableroPrincipal.decoradoDelTablero();

        casillasPrincipal = new CasillaPrincipal[11][11];

        /**
         * This for creates the button array on the main board
         */

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                casillasPrincipal[i][j] = new CasillaPrincipal(i, j);
                casillasPrincipal[i][j].removeMouseListener(escucha);
                tableroPrincipal.add(casillasPrincipal[i][j]);
                if (i == 0 || j == 0) {
                    casillasPrincipal[i][j].setVisible(false);
                }
            }
        }
        constraints.gridx = 10;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 4;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(tableroPrincipal, constraints);

        //-------------------------------------------------------------------------------------------------------------------------

        espacio7 = new JPanel();
        espacio7.setOpaque(false);
        espacio7.setPreferredSize(new Dimension(50, 50));
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 12;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(espacio7, constraints);

        //-------------------------------------------------------------------------------------------------------------------------

        indicativoTableroPosicion = new JLabel();
        indicativoTableroPosicion.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 20));
        indicativoTableroPosicion.setText("Tablero de posición");
        constraints.gridx = 1;
        constraints.gridy = 8;
        constraints.gridwidth = 6;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(indicativoTableroPosicion, constraints);

        //-------------------------------------------------------------------------------------------------------------------------

        indicativoTableroPrincipal = new JLabel();
        indicativoTableroPrincipal.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 20));
        indicativoTableroPrincipal.setText("Tablero principal");
        constraints.gridx = 10;
        constraints.gridy = 8;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(indicativoTableroPrincipal, constraints);

        //-------------------------------------------------------------------------------------------------------------------------

        ponerBarcosIA();

        revalidate();
        repaint();
    }

    /**
     * This function creates the panel and displays the images that appear when a shot is missed, a ship is sunk,
     * and when a part of the ship is hit.
     */

    public void addInfo() {
        panelInfo.setLayout(new GridBagLayout());
        GridBagConstraints constraintsPanelInfo = new GridBagConstraints();

        infoFallo = new JLabel("Fallo");
        infoFallo.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 14));
        infoFallo.setForeground(Color.black);
        infoFallo.setBackground(Color.white);
        infoFallo.setPreferredSize(new Dimension(100, 75));
        infoFallo.setAlignmentY(SwingConstants.CENTER);
        infoFallo.setHorizontalAlignment(JLabel.CENTER);
        infoFallo.setVerticalAlignment(JLabel.CENTER);
        constraintsPanelInfo.gridx = 1;
        constraintsPanelInfo.gridy = 0;
        constraintsPanelInfo.fill = GridBagConstraints.CENTER;
        constraintsPanelInfo.anchor = GridBagConstraints.CENTER;

        panelInfo.add(infoFallo, constraintsPanelInfo);

        imagenFallo = new JLabel();
        unaImagen = new ImageIcon(getClass().getResource("/resources/fallar.PNG"));
        imagenOtroTamanho = unaImagen.getImage().getScaledInstance(46, 46, Image.SCALE_SMOOTH);
        imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
        imagenFallo.setIcon(imagenNuevoTamanho);
        imagenFallo.setPreferredSize(new Dimension(46, 46));
        constraintsPanelInfo.gridx = 0;
        constraintsPanelInfo.gridy = 0;
        constraintsPanelInfo.fill = GridBagConstraints.CENTER;
        constraintsPanelInfo.anchor = GridBagConstraints.CENTER;

        panelInfo.add(imagenFallo, constraintsPanelInfo);

        infoImpacto = new JLabel("Impacto");
        infoImpacto.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 14));
        infoImpacto.setForeground(Color.black);
        infoImpacto.setBackground(Color.white);
        infoImpacto.setPreferredSize(new Dimension(100, 75));
        infoImpacto.setAlignmentY(SwingConstants.CENTER);
        infoImpacto.setHorizontalAlignment(JLabel.CENTER);
        infoImpacto.setVerticalAlignment(JLabel.CENTER);
        constraintsPanelInfo.gridx = 1;
        constraintsPanelInfo.gridy = 1;
        constraintsPanelInfo.fill = GridBagConstraints.CENTER;
        constraintsPanelInfo.anchor = GridBagConstraints.CENTER;

        panelInfo.add(infoImpacto, constraintsPanelInfo);

        imagenImpacto = new JLabel();
        unaImagen = new ImageIcon(getClass().getResource("/resources/acierto.PNG"));
        imagenOtroTamanho = unaImagen.getImage().getScaledInstance(46, 46, Image.SCALE_SMOOTH);
        imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
        imagenImpacto.setIcon(imagenNuevoTamanho);
        imagenImpacto.setForeground(Color.red);
        imagenImpacto.setBackground(Color.white);
        imagenImpacto.setPreferredSize(new Dimension(46, 46));
        imagenImpacto.setAlignmentY(SwingConstants.CENTER);
        imagenImpacto.setHorizontalAlignment(JLabel.CENTER);
        imagenImpacto.setVerticalAlignment(JLabel.CENTER);
        constraintsPanelInfo.gridx = 0;
        constraintsPanelInfo.gridy = 1;
        constraintsPanelInfo.fill = GridBagConstraints.CENTER;
        constraintsPanelInfo.anchor = GridBagConstraints.CENTER;

        panelInfo.add(imagenImpacto, constraintsPanelInfo);

        infoHundido = new JLabel("Hundido");
        infoHundido.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 14));
        infoHundido.setForeground(Color.black);
        infoHundido.setBackground(Color.white);
        infoHundido.setPreferredSize(new Dimension(100, 75));
        infoHundido.setAlignmentY(SwingConstants.CENTER);
        infoHundido.setHorizontalAlignment(JLabel.CENTER);
        infoHundido.setVerticalAlignment(JLabel.CENTER);
        constraintsPanelInfo.gridx = 1;
        constraintsPanelInfo.gridy = 2;
        constraintsPanelInfo.fill = GridBagConstraints.CENTER;
        constraintsPanelInfo.anchor = GridBagConstraints.CENTER;

        panelInfo.add(infoHundido, constraintsPanelInfo);

        imagenHundido = new JLabel();
        unaImagen = new ImageIcon(getClass().getResource("/resources/hundido.png"));
        imagenOtroTamanho = unaImagen.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
        imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
        imagenHundido.setIcon(imagenNuevoTamanho);
        imagenHundido.setPreferredSize(new Dimension(100, 50));
        constraintsPanelInfo.gridx = 0;
        constraintsPanelInfo.gridy = 2;
        constraintsPanelInfo.fill = GridBagConstraints.CENTER;
        constraintsPanelInfo.anchor = GridBagConstraints.CENTER;

        panelInfo.add(imagenHundido, constraintsPanelInfo);
    }

    /**
     * This function makes the opponent place their ships on the board position
     */

    public void ponerBarcosIA()
    {
        Random coordenadas = new Random();
        Random lado = new Random();

        int a = coordenadas.nextInt(10)+1;
        int b = coordenadas.nextInt(10)+1;
        int orientacion = lado.nextInt(2);

        casillaPrincipalSeleccionada = casillasPrincipal[a][b];

        if(!(casillaPrincipalSeleccionada.getTieneBarco())) {
            switch (marcadorBarcosIA) {
                case 1, 2, 3, 4:
                    marcadorBarcosIA++;
                    game.casillasDelBoteIA(casillaPrincipalSeleccionada);
                    ponerBarcosIA();
                    break;

                case 5, 6, 7:
                    if(orientacion==1) {
                        if (b == 10) {
                            if(!(casillasPrincipal[a][b - 1].getTieneBarco() || casillaPrincipalSeleccionada.getTieneBarco())) {
                                marcadorBarcosIA++;
                                game.casillasDelBoteIA(casillasPrincipal[a][b - 1], casillaPrincipalSeleccionada);
                            }
                        } else if (!(casillaPrincipalSeleccionada.getTieneBarco() || casillasPrincipal[a][b + 1].getTieneBarco())) {
                            marcadorBarcosIA++;
                            game.casillasDelBoteIA(casillaPrincipalSeleccionada, casillasPrincipal[a][b + 1]);
                        }
                        ponerBarcosIA();
                    }
                    else if(orientacion==0){
                        if (a == 10) {
                            if(!(casillasPrincipal[a - 1][b].getTieneBarco() || casillaPrincipalSeleccionada.getTieneBarco())) {
                                marcadorBarcosIA++;
                                game.casillasDelBoteIA(casillasPrincipal[a - 1][b], casillaPrincipalSeleccionada);
                            }
                        } else if (!(casillaPrincipalSeleccionada.getTieneBarco() || casillasPrincipal[a + 1][b].getTieneBarco())) {
                            marcadorBarcosIA++;
                            game.casillasDelBoteIA(casillaPrincipalSeleccionada, casillasPrincipal[a + 1][b]);
                        }
                        ponerBarcosIA();
                    }
                    break;

                case 8, 9:
                    if(orientacion==1){
                        if (b == 9) {
                            if(!(casillasPrincipal[a][b - 1].getTieneBarco() || casillaPrincipalSeleccionada.getTieneBarco() || casillasPrincipal[a][b + 1].getTieneBarco())) {
                                marcadorBarcosIA++;
                                game.casillasDelBoteIA(casillasPrincipal[a][b - 1], casillaPrincipalSeleccionada, casillasPrincipal[a][b + 1]);
                            }
                        } else if (b == 10) {
                            if(!(casillasPrincipal[a][b - 2].getTieneBarco() || casillasPrincipal[a][b - 1].getTieneBarco() || casillaPrincipalSeleccionada.getTieneBarco())) {
                                marcadorBarcosIA++;
                                game.casillasDelBoteIA(casillasPrincipal[a][b - 2], casillasPrincipal[a][b - 1], casillaPrincipalSeleccionada);
                            }
                        } else if (!(casillaPrincipalSeleccionada.getTieneBarco() || casillasPrincipal[a][b + 1].getTieneBarco() || casillasPrincipal[a][b + 2].getTieneBarco())) {
                            marcadorBarcosIA++;
                            game.casillasDelBoteIA(casillaPrincipalSeleccionada, casillasPrincipal[a][b + 1], casillasPrincipal[a][b + 2]);
                        }
                    }
                    else if(orientacion==0){
                        if (a == 9) {
                            if(!(casillasPrincipal[a - 1][b].getTieneBarco() || casillaPrincipalSeleccionada.getTieneBarco() || casillasPrincipal[a + 1][b].getTieneBarco())) {
                                marcadorBarcosIA++;
                                game.casillasDelBoteIA(casillasPrincipal[a - 1][b], casillaPrincipalSeleccionada, casillasPrincipal[a + 1][b]);
                            }
                        } else if (a == 10) {
                            if(!(casillasPrincipal[a - 2][b].getTieneBarco() || casillasPrincipal[a - 1][b].getTieneBarco() || casillaPrincipalSeleccionada.getTieneBarco())) {
                                marcadorBarcosIA++;
                                game.casillasDelBoteIA(casillasPrincipal[a - 2][b], casillasPrincipal[a - 1][b], casillaPrincipalSeleccionada);
                            }
                        } else if (!(casillaPrincipalSeleccionada.getTieneBarco() || casillasPrincipal[a + 1][b].getTieneBarco() || casillasPrincipal[a + 2][b].getTieneBarco())) {
                            marcadorBarcosIA++;
                            game.casillasDelBoteIA(casillaPrincipalSeleccionada, casillasPrincipal[a + 1][b], casillasPrincipal[a + 2][b]);
                        }
                    }
                    ponerBarcosIA();
                    break;

                case 10:
                    if(orientacion==1){
                        if (b == 8) {
                            if(!(casillasPrincipal[a][b - 1].getTieneBarco() || casillaPrincipalSeleccionada.getTieneBarco() || casillasPrincipal[a][b + 1].getTieneBarco() || casillasPrincipal[a][b + 2].getTieneBarco())) {
                                marcadorBarcosIA++;
                                game.casillasDelBoteIA(casillasPrincipal[a][b - 1], casillaPrincipalSeleccionada, casillasPrincipal[a][b + 1], casillasPrincipal[a][b + 2]);
                            }
                        } else if (b == 9) {
                            if(!(casillasPrincipal[a][b - 2].getTieneBarco() || casillasPrincipal[a][b - 1].getTieneBarco() || casillaPrincipalSeleccionada.getTieneBarco() || casillasPrincipal[a][b + 1].getTieneBarco())) {
                                marcadorBarcosIA++;
                                game.casillasDelBoteIA(casillasPrincipal[a][b - 2], casillasPrincipal[a][b - 1], casillaPrincipalSeleccionada, casillasPrincipal[a][b + 1]);
                            }
                        } else if (b == 10) {
                            if(!(casillasPrincipal[a][b - 3].getTieneBarco() || casillasPrincipal[a][b - 2].getTieneBarco() || casillasPrincipal[a][b - 1].getTieneBarco() || casillaPrincipalSeleccionada.getTieneBarco())) {
                                marcadorBarcosIA++;
                                game.casillasDelBoteIA(casillasPrincipal[a][b - 3], casillasPrincipal[a][b - 2], casillasPrincipal[a][b - 1], casillaPrincipalSeleccionada);
                            }
                        } else if (!(casillaPrincipalSeleccionada.getTieneBarco() || casillasPrincipal[a][b + 1].getTieneBarco() || casillasPrincipal[a][b + 2].getTieneBarco() || casillasPrincipal[a][b + 3].getTieneBarco())) {
                            marcadorBarcosIA++;
                            game.casillasDelBoteIA(casillaPrincipalSeleccionada, casillasPrincipal[a][b + 1], casillasPrincipal[a][b + 2], casillasPrincipal[a][b + 3]);
                        }
                    }
                    else if(orientacion==0){
                        if (a == 8) {
                            if(!(casillasPrincipal[a - 1][b].getTieneBarco() || casillaPrincipalSeleccionada.getTieneBarco() || casillasPrincipal[a + 1][b].getTieneBarco() || casillasPrincipal[a + 2][b].getTieneBarco())) {
                                marcadorBarcosIA++;
                                game.casillasDelBoteIA(casillasPrincipal[a - 1][b], casillaPrincipalSeleccionada, casillasPrincipal[a + 1][b], casillasPrincipal[a + 2][b]);
                            }
                        } else if (a == 9) {
                            if(!(casillasPrincipal[a - 2][b].getTieneBarco() || casillasPrincipal[a - 1][b].getTieneBarco() || casillaPrincipalSeleccionada.getTieneBarco() || casillasPrincipal[a + 1][b].getTieneBarco())) {
                                marcadorBarcosIA++;
                                game.casillasDelBoteIA(casillasPrincipal[a - 2][b], casillasPrincipal[a - 1][b], casillaPrincipalSeleccionada, casillasPrincipal[a + 1][b]);
                            }
                        } else if (a == 10) {
                            if(!(casillasPrincipal[a - 3][b].getTieneBarco() || casillasPrincipal[a - 2][b].getTieneBarco() || casillasPrincipal[a - 1][b].getTieneBarco() || casillaPrincipalSeleccionada.getTieneBarco())) {
                                marcadorBarcosIA++;
                                game.casillasDelBoteIA(casillasPrincipal[a - 3][b], casillasPrincipal[a - 2][b], casillasPrincipal[a - 1][b], casillaPrincipalSeleccionada);
                            }
                        } else if (!(casillaPrincipalSeleccionada.getTieneBarco() || casillasPrincipal[a + 1][b].getTieneBarco() || casillasPrincipal[a + 2][b].getTieneBarco() || casillasPrincipal[a + 3][b].getTieneBarco())) {
                            marcadorBarcosIA++;
                            game.casillasDelBoteIA(casillaPrincipalSeleccionada, casillasPrincipal[a + 1][b], casillasPrincipal[a + 2][b], casillasPrincipal[a + 3][b]);
                        }
                    }
                    ponerBarcosIA();
                    break;
            }
        }
        else{
            ponerBarcosIA();
        }
    }
        













}
