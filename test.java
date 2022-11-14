import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class test implements ActionListener {
    private JTextArea mensaje;
    private JButton start;
    private JLabel DQ;
    private JButton play;
    private JButton exit;
    private JTextArea pregunta;
    private int vidaPlayer = 10;
    private int vidaBoss = 5;
    private final String[] respuestasFacil = {"a", "c", "c", "c", "d"};
    private final String[] respuestasMedio = {"c", "b", "b", "a", "d", "a", "d", "b", "a", "d"};
    private final String[] respuestasChayanne = {"a"};
    private int i=0;
    JFrame frame = new JFrame();
    JRadioButton a;
    JRadioButton b;
    JRadioButton c;
    JRadioButton d;


    test() { //Frame principal del Lore
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

    public void backGround() {
        frame.setSize(950, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.blue);
        frame.setLayout(null);


    }

    public Component lore() {
        mensaje = new JTextArea("Eres un estudiante de ISI en la universidad de Sonora, un día eres teletransportado a una mazmorra peligrosa en un mundo desconocido, debes completar una serie de preguntas para  lograr volver a tu mundo sano y salvo... ¿Podrás escapar de aquí?");
        mensaje.setBounds(50, 50, 700, 150);
        mensaje.setBackground(Color.BLACK);
        mensaje.setForeground(Color.white);
        mensaje.setEditable(false);
        mensaje.setLineWrap(true);
        mensaje.setWrapStyleWord(true);
        mensaje.setFont(new Font("Courier new", Font.PLAIN, 22));
        return mensaje;
    }

    public Component sG() {
        start = new JButton("START");//Botton de start
        start.setBounds(300, 300, 200, 80);
        start.setFont((new Font("Hoefler Text", Font.PLAIN, 26)));
        start.addActionListener(e -> mensaje.setVisible(false));
        start.addActionListener(e -> backGround());
        start.addActionListener(e -> start.setVisible(false));
        start.addActionListener(e -> DQ.setVisible(true));
        start.addActionListener(e -> play.setVisible(true));
        start.addActionListener(e -> exit.setVisible(true));

        DQ = new JLabel(" DUNGEONS & QUESTIONS");
        DQ.setBounds(300, 50, 350, 100);
        DQ.setBackground(Color.white);
        DQ.setOpaque(true);
        DQ.setFont(new Font("Hoefler Text", Font.PLAIN, 26));
        DQ.setForeground(Color.BLACK);
        DQ.setVisible(false);
        DQ.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(DQ);

        play = new JButton("PLAY");
        play.setBounds(375, 250, 200, 50);
        play.setFont(new Font("Hoefler Text", Font.PLAIN, 26));
        play.addActionListener(e -> backGround());
        play.addActionListener(e -> exit.setVisible(false));
        play.addActionListener(e -> play.setVisible(false));
        play.addActionListener(e -> DQ.setVisible(false));
        play.addActionListener(e -> displayPreguntas());
        frame.add(play);
        play.setVisible(false);

        exit = new JButton("EXIT");
        exit.setBounds(375, 325, 200, 50);
        exit.setFont(new Font("Hoefler Text", Font.PLAIN, 26));
        frame.add(exit);
        exit.setVisible(false);
        exit.addActionListener(e -> System.exit(0));


        return start;

    }

    public Component txtAreaPreguntas(int i) {
        pregunta = new JTextArea(añadirFacil(i));
        pregunta.setBounds(650, 100, 300, 400);
        pregunta.setEditable(false);
        pregunta.setLineWrap(true);
        pregunta.setWrapStyleWord(true);
        pregunta.setFont(new Font("Courier new", Font.PLAIN, 16));
        pregunta.setVisible(true);
        frame.add(pregunta);
        return pregunta;
    }

    public Component displayPreguntas() {
        txtAreaPreguntas(i);
        a = new JRadioButton("A.");
        a.setBounds(650, 510, 45, 20);
        a.setFont(new Font("Arial", Font.PLAIN, 18));
        a.setForeground(Color.BLACK);
        a.setFocusable(false);
        a.addActionListener(this);
        frame.add(a);
        b = new JRadioButton("B.");
        b.setBounds(732, 510, 45, 20);
        b.setFont(new Font("Arial", Font.PLAIN, 18));
        b.setForeground(Color.BLACK);
        b.setFocusable(false);
        b.addActionListener(this);
        frame.add(b);
        c = new JRadioButton("C.");
        c.setBounds(817, 510, 45, 20);
        c.setFont(new Font("Arial", Font.PLAIN, 18));
        c.setForeground(Color.BLACK);
        c.setFocusable(false);
        c.addActionListener(this);
        frame.add(c);
        d = new JRadioButton("D.");
        d.setBounds(890, 510, 45, 20);
        d.setFont(new Font("Arial", Font.PLAIN, 18));
        d.setForeground(Color.BLACK);
        d.setFocusable(false);
        d.addActionListener(this);
        frame.add(d);
        ButtonGroup agrupar = new ButtonGroup();
        agrupar.add(a);
        agrupar.add(b);
        agrupar.add(c);
        agrupar.add(d);
        frame.setVisible(true);
        return null;
    }

    public String añadirFacil(int i) {
        String[] bancoF = {"1.En la película \"Jojo Rabbit\", el protagonista tenía un amigo imaginario, ¿quién era?\n" +
                "a. Hitler\n" +
                "b. El niño Jesús\n" +
                "c. El conejo de la suerte\n" +
                "d. Un dinosaurio morado\n",
                "2.  ¿Qué perdió Luke Skywalker en su pelea con Darth Vader?" +
                        "\n" +
                        "a. Su mano izquierda\n" +
                        "b. Su pie izquierdo\n" +
                        "c. Su mano derecha\n" +
                        "d. Su pierna izquierda\n",
                "3. ¿Quién es conocido como el 'King Slayer'?\n" +
                        "a. Roberto Baratheon\n" +
                        "b. Rey Joffrey\n" +
                        "c. Jamie Lannister\n",
                "4. ¿Quién gana la pelea entre Rock Lee y Gaara en el anime de Naruto?\n" +
                        "a. Rock Lee\n" +
                        "b. Empate\n" +
                        "c. Gaara\n" +
                        "d. Interrumpen el combate\n",
                "5. ¿Cuál es el anime más largo hasta la fecha?\n" +
                        "a. Doraemon\n" +
                        "b. One Piece\n" +
                        "c. Detective Conan\n" +
                        "d. Sazae-san\n"};

        if (i == 5){
            JOptionPane.showMessageDialog(null,"Ganaste");
            System.exit(0);
            return null;
        }
        return bancoF[i];
        //Escribir las preguntas y que el entero nos regrese la pregunta de la posición iesima para luego en el main
        //utilizar un for con el fin de que nos pase las preguntas.


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //if (Objects.equals(e.getActionCommand(), respuestasFacil[i])) {
        if (e.getSource()==a){
            if((respuestasFacil[i].compareTo("a")) == 0){
                i++;
                pregunta.setText(añadirFacil(i));
                vidaBoss--;
            }
            else {
                vidaPlayer--;
                if (vidaPlayer == 0){
                    JOptionPane.showMessageDialog(null,"Perdiste");
                    System.exit(0);
                }else{
                    i++;
                    pregunta.setText(añadirFacil(i));
                }
            }
            System.out.println("Vida del jugador: " + vidaPlayer + "\nVida del boss: " + vidaBoss);
        }
        if (e.getSource()==b){
            if((respuestasFacil[i].compareTo("b")) == 0){
                i++;
                pregunta.setText(añadirFacil(i));
                vidaBoss--;
            }else {
                vidaPlayer--;
                if (vidaPlayer == 0){
                    JOptionPane.showMessageDialog(null,"Perdiste");
                    System.exit(0);
                }else{
                    i++;
                    pregunta.setText(añadirFacil(i));
                }
            }
            System.out.println("Vida del jugador: " + vidaPlayer + "\nVida del boss: " + vidaBoss);
        }
        if (e.getSource()==c){
            if((respuestasFacil[i].compareTo("c")) == 0){
                i++;
                pregunta.setText(añadirFacil(i));
                vidaBoss--;
            }else {
                vidaPlayer--;
                if (vidaPlayer == 0){
                    JOptionPane.showMessageDialog(null,"Perdiste");
                    System.exit(0);
                }else{
                    i++;
                    pregunta.setText(añadirFacil(i));
                }
            }
            System.out.println("Vida del jugador: " + vidaPlayer + "\nVida del boss: " + vidaBoss);
        }
        if (e.getSource()==d){
            if((respuestasFacil[i].compareTo("d")) == 0){
                i++;
                pregunta.setText(añadirFacil(i));
                vidaBoss--;
            }else {
                vidaPlayer--;
                if (vidaPlayer == 0){
                    JOptionPane.showMessageDialog(null,"Perdiste");
                    System.exit(0);
                }else{
                    i++;
                    pregunta.setText(añadirFacil(i));
                }
            }
            System.out.println("Vida del jugador: " + vidaPlayer + "\nVida del boss: " + vidaBoss);
        }
    }
}


    //array de preguntas 30
    //array(i) = pregunta no i
    //texarea, i es parametro del método

