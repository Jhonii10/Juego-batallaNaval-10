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
