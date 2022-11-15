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
    private final String[] respuestasFacil = {"a", "c", "c", "c", "d","c", "b", "b", "a", "d", "a", "d", "b", "a", "d","b","a","c","b","c","d","d","d","a","a","d","c","c","d"};
    private int i=0;
    JFrame frame = new JFrame();
    JRadioButton a;
    JRadioButton b;
    JRadioButton c;
    JRadioButton d;
    JButton continuar;


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

    public String añadirFacil(int i) {
        String[] bancoF = {
                //Faciles
                "1.En la película \"Jojo Rabbit\", el protagonista tenía un amigo imaginario, ¿quién era?\n" +
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
                        "d. Sazae-san\n",
                //Medio
                "6.¿Cuántos decimales tiene el número pi π?\n" +
                        "a.Dos\n" +
                        "b.Cien\n" +
                        "c.Infinitos\n" +
                        "d.Mil\n",

                "7.¿En qué periodo de la prehistoria fue descubierto el fuego?\n" +
                        "a.Neolítico\n" +
                        "b.Paleolítico\n" +
                        "c.Edad de piedra\n" +
                        "d.Edad media\n",

                "8. ¿Cuál es el mayor archipiélago de la Tierra?\n" +
                        "a.Filipinas\n" +
                        "b.Indonesia\n" +
                        "c.Bahamas\n" +
                        "d.Finlandia\n",

                "9. ¿En qué océano queda Madagascar?\n" +
                        "a.Océano Índico\n" +
                        "b.Océano Antártico\n" +
                        "c.Océano Ártico\n" +
                        "d.Océano Atlántico\n",

                "10. ¿Qué animal gluglutea?\n" +
                        "a.El pato\n" +
                        "b.La guacamaya\n" +
                        "c.La cacatúa\n" +
                        "d.El pavo\n",

                "11. ¿Dónde se originaron los números arábigos?\n" +
                        "a. India\n" +
                        "b. Grecia\n" +
                        "c. Persia\n" +
                        "d. Arabia\n",

                "12. ¿En qué siglo el continente europeo fue devastado por la peste bubónica?\n" +
                        "a. En el siglo X\n" +
                        "b. En el siglo XII\n" +
                        "c. En el siglo XIII\n" +
                        "d. En el siglo XIV\n",

                "13. El Sol está compuesto principalmente por:\n" +
                        "a. Luz y energía\n" +
                        "b. Hidrógeno y helio\n" +
                        "c. Asteroides y cometas\n" +
                        "d. Hierro y níquel\n",

                "14. La moneda oficial de Japón es:\n" +
                        "a. Yen\t\n" +
                        "b. Yuan\n" +
                        "c. Yin\n" +
                        "d. Yun\n",

                "15. ¿Cuánto tiempo tarda la luz del Sol en llegar a la Tierra?\n" +
                        "a. 12 minutos\n" +
                        "b. 1 día\n" +
                        "c. 12 horas\n" +
                        "d. 8 minutos\n",
                //Chayanne
                "16. ¿Cuál es el nombre real de “Chayanne”?\n" +
                        "a. Enrique Martín Morales\n" +
                        "b. Elmer Figueroa Arce.\n" +
                        "c. Pablo Moreno de Alborán Ferrándiz\n" +
                        "d. Philippus Aureolus Theophrastus Bombastus Paracelsus\n",

                "17. ¿Cuánto mide Chayanne?\n" +
                                "a. 1.88 m\n" +
                                "b. 1.37 m\n" +
                                "c.1.67 m\n" +
                                "d.1.91 m\n",

                "18. ¿En qué serie de televisión estadounidense está basado el nombre de Chayanne?\n" +
                                "a. El Fugitivo\n" +
                                "b.Adam-12\n" +
                                "c.Cheyenne.\n" +
                                "d. Basic Black\n",

                "19. ¿Quién le dio su nombre artístico?\n" +
                                "a. Guzmán Gerardo Alfonso Sánchez Schmitz.\n" +
                                "b. Su madre.\n" +
                                "c. Su primo.\n" +
                                "d. Su Manager.\n",

                "20. ¿Cuántos álbumes ha lanzado?\n" +
                                "a. 15.\n" +
                                "b. 19.\n" +
                                "c. 22.\n" +
                                "d. 23.\n",

                "21. ¿Cuántos años tiene Chayanne?\n" +
                                "a.61 años\n" +
                                "b.56 años\n" +
                                "c.69 años\n" +
                                "d.54. años\n",

                "22. ¿Cómo se llama el primer disco de Chayanne?\n" +
                                "a. Provocame\n" +
                                "b. Atado a tu amor\n" +
                                "c. De piel a piel\n" +
                                "d. Chayanne es mi nombre\n",

                "23. ¿De qué país es Chayanne?\n" +
                                "a. México.\n" +
                                "b. Costa rica.\n" +
                                "c. Colombia.\n" +
                                "d. Puerto Rico.\n",

                "24. ¿Cuál de las siguientes sentencias declara una variable entera y define su valor inicial?\n" +
                                        "a. int sumaTotal = 0;\n" +
                                        "b. int suma total = 0;\n" +
                                        "c. int sumaTotal;\n" +
                                        "d. int suma.total = 0.0;\n",

                "25. ¿Cuál de las siguientes afirmaciones es verdadera?\n" +
                                        "a. El código fuente de programas en Java se compila y genera código intermedio (bytecode).\n" +
                                        "b. El código fuente de Java es igual al código de máquina.\n" +
                                        "c. El código fuente de Java se interpreta en tiempo de ejecución.\n" +
                                        "d. El código fuente de Java se almacena en un archivo .class\n",

                "26.Esta estructura de repetición ejecuta las instrucciones al menos una vez.\n" +
                                        "a. switch\n" +
                                        "b. while\n" +
                                        "c. for\n" +
                                        "d. do...while\n",
                "27.Dado el siguiente segmento de código: public class D { public int a; public String c; } Si x es un objeto de la clase D ¿Cuál de las siguientes sentencias es valida?\n" +
                                        "a. String s = x.String(c);\n" +
                                        "b. String s = c(x);\n" +
                                        "c. String s = x.c;\n" +
                                        "d. String (s) = String(c).x\n",

                "28. ¿Cuál es el resultado de evaluar la expresión 2.0 + 3.0 + \"4.0\" ?\n" +
                                        "a. “9.0\"\n" +
                                        "b. “54.0\"\n" +
                                        "c. “5.04.0\"\n" +
                                        "d. 9.0\n",

                "29. ¿Cuál de las siguientes instrucciones es incorrecta?\n" +
                                        "a. double d = 99.99;\n" +
                                        "b. String s = \"999.99\";\n" +
                                        "c. char c = \"9\";\n" +
                                        "d. int j = 9999;\n",

                "30. ¿Cuál es el resultado de evaluar la siguiente expresión en Java 3 *(5 / 2 - 6) ?\n" +
                                        "a. 10.5\n" +
                                        "b. -12.0\n" +
                                        "c. 1.5\n" +
                                        "d. -12\n"
                        };

        if (i == 5){
            GUI();
            start.setVisible(false);
            mensaje.setText("Vaya haz logrado vencer al primero, así es, el primero de varios ¿esperabas solamente a uno? ingenuo, aun te queda un camino por recorrer suerte...");
            continuar = new JButton("CONTINUE");
            continuar.setBounds(300, 300, 200, 80);
            frame.add(continuar);
            pregunta.setVisible(false);
            a.setVisible(false);
            b.setVisible(false);
            c.setVisible(false);
            d.setVisible(false);
            continuar.addActionListener(e -> pregunta.setVisible(true));
            continuar.addActionListener(e -> backGround());
            continuar.addActionListener(e -> mensaje.setVisible(false));
            continuar.addActionListener(e -> a.setVisible(true));
            continuar.addActionListener(e -> b.setVisible(true));
            continuar.addActionListener(e -> c.setVisible(true));
            continuar.addActionListener(e -> d.setVisible(true));
            continuar.addActionListener(e -> continuar.setVisible(false));
            vidaBoss = 10;
        }
        if (i == 15){
            GUI();
            start.setVisible(false);
            mensaje.setText("Vaya haz logrado vencer al primero, así es, el primero de varios ¿esperabas solamente a uno? ingenuo, aun te queda un camino por recorrer suerte...");
            continuar = new JButton("CONTINUE");
            continuar.setBounds(300, 300, 200, 80);
            frame.add(continuar);
            pregunta.setVisible(false);
            a.setVisible(false);
            b.setVisible(false);
            c.setVisible(false);
            d.setVisible(false);
            continuar.addActionListener(e -> pregunta.setVisible(true));
            continuar.addActionListener(e -> backGround());
            continuar.addActionListener(e -> mensaje.setVisible(false));
            continuar.addActionListener(e -> a.setVisible(true));
            continuar.addActionListener(e -> b.setVisible(true));
            continuar.addActionListener(e -> c.setVisible(true));
            continuar.addActionListener(e -> d.setVisible(true));
            continuar.addActionListener(e -> continuar.setVisible(false));
            vidaBoss = 10;
        }
        if (i == 30){
            GUI();
            start.setVisible(false);
            mensaje.setText("Vaya haz logrado vencer al primero, así es, el primero de varios ¿esperabas solamente a uno? ingenuo, aun te queda un camino por recorrer suerte...");
            continuar = new JButton("CONTINUE");
            continuar.setBounds(300, 300, 200, 80);
            frame.add(continuar);
            pregunta.setVisible(false);
            a.setVisible(false);
            b.setVisible(false);
            c.setVisible(false);
            d.setVisible(false);
            continuar.addActionListener(e -> pregunta.setVisible(true));
            continuar.addActionListener(e -> backGround());
            continuar.addActionListener(e -> mensaje.setVisible(false));
            continuar.addActionListener(e -> a.setVisible(true));
            continuar.addActionListener(e -> b.setVisible(true));
            continuar.addActionListener(e -> c.setVisible(true));
            continuar.addActionListener(e -> d.setVisible(true));
            continuar.addActionListener(e -> continuar.setVisible(false));
            vidaBoss = 10;
        }
        return bancoF[i];
        //Escribir las preguntas y que el entero nos regrese la pregunta de la posición iesima para luego en el main
        //utilizar un for con el fin de que nos pase las preguntas.
    }
}


    //array de preguntas 30
    //array(i) = pregunta no i
    //texarea, i es parametro del método

