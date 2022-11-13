import javax.swing.*;
import java.awt.*;

public class test {
    private JTextArea mensaje=new JTextArea("Eres un estudiante de ISI en la universidad de Sonora, un día eres teletransportado a una mazmorra peligrosa en un mundo desconocido, debes completar una serie de preguntas para  lograr volver a tu mundo sano y salvo... ¿Podrás escapar de aquí?");
    private JButton start;
    private JLabel DQ;
    private JButton play;
    private JButton exit;
    private JPanel juego;
    JFrame frame=new JFrame();


    test() { //Frame principal del Lore
        /*setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

         */

        //add(mensaje);

        /*DQ = new JLabel("DUNGEONS & QUESTIONS");
        DQ.setBounds(225, 50, 350, 100);
        DQ.setBackground(Color.white);
        DQ.setOpaque(true);
        DQ.setFont(new Font("Hoefler Text", Font.PLAIN, 26));
        DQ.setForeground(Color.BLACK);
        DQ.setVisible(false);
        //add(DQ);

        start = new JButton("START");//Botton de start
        start.setBounds(300, 300, 200, 80);
        start.setFont((new Font("Hoefler Text", Font.PLAIN, 26)));
        start.addActionListener(e -> mensaje.setVisible(false));
        start.addActionListener(e -> start.setVisible(false));
        start.addActionListener(e -> DQ.setVisible(true));
        start.addActionListener(e -> play.setVisible(true));
        start.addActionListener(e -> exit.setVisible(true));
        //add(start);


        play = new JButton("PLAY");
        play.setBounds(300, 250, 200, 50);
        play.setFont(new Font("Hoefler Text", Font.PLAIN, 26));
        play.addActionListener(e -> juego.setVisible(true));
        play.addActionListener(e -> exit.setVisible(false));
        play.addActionListener(e -> play.setVisible(false));
        play.addActionListener(e -> DQ.setVisible(false));
        //add(play);
        play.setVisible(false);


        exit = new JButton("EXIT");
        exit.setBounds(300, 325, 200, 50);
        exit.setFont(new Font("Hoefler Text", Font.PLAIN, 26));
        //add(exit);
        exit.setVisible(false);
        exit.addActionListener(e -> System.exit(0));

        juego = new JPanel();
        juego.setBounds(0, 0, 800, 600);
        juego.setVisible(false);
        juego.repaint();
        //add(juego);

         */

    }

    public void GUI() {
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.add(lore());
        frame.add(sG());



        frame.setVisible(true);


    }
    public void backGround(){
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.blue);
        frame.setLayout(null);

    }

    public Component lore() {
        //mensaje = new JTextArea("Eres un estudiante de ISI en la universidad de Sonora, un día eres teletransportado a una mazmorra peligrosa en un mundo desconocido, debes completar una serie de preguntas para  lograr volver a tu mundo sano y salvo... ¿Podrás escapar de aquí?");
        mensaje.setBounds(50, 50, 700, 150);
        mensaje.setBackground(Color.BLACK);
        mensaje.setForeground(Color.white);
        mensaje.setEditable(false);
        mensaje.setLineWrap(true);
        mensaje.setWrapStyleWord(true);
        mensaje.setFont(new Font("Hoefler Text", Font.PLAIN, 26));
        return mensaje;
    }

    public String añadir(int i) {
        String[] banco = {"1.En la película \"Jojo Rabbit\", el protagonista tenía un amigo imaginario, ¿quién era?\n" +
                "Hitler\n" +
                "El niño Jesús\n" +
                "El conejo de la suerte\n" +
                "Un dinosaurio morado\n" +
                "El fantasma de su papá\n",
                "2.  ¿Qué perdió Luke Skywalker en su pelea con Darth Vader?\n" +
                        "\n" +
                        "Su mano izquierda\n" +
                        "Su pie izquierdo\n" +
                        "Su mano derecha\n" +
                        "Su pierna izquierda\n"};


        return banco[i];
        //Escribir las preguntas y que el entero nos regrese la pregunta de la posición iesima para luego en el main
        //utilizar un for con el fin de que nos pase las preguntas.


    }

    public Component sG(){
        start = new JButton("START");//Botton de start
        start.setBounds(300, 300, 200, 80);
        start.setFont((new Font("Hoefler Text", Font.PLAIN, 26)));
        start.addActionListener(e -> mensaje.setVisible(false));
        start.addActionListener(e -> backGround());
        start.addActionListener(e -> start.setVisible(false));
        //start.addActionListener(e -> DQ.setVisible(true));
        //start.addActionListener(e -> play.setVisible(true));
        //start.addActionListener(e -> exit.setVisible(true));

        return start;

    }





}
    //array de preguntas 30
    //array(i) = pregunta no i
    //texarea, i es parametro del método






