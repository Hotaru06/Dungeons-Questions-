import javax.swing.*;
import java.awt.*;
public class test extends JFrame {
    private JTextArea mensaje;
    private JButton start;
    private JLabel DQ;


    test() { //Frame principal del Lore
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        mensaje = new JTextArea("Eres un estudiante de ISI en la universidad de Sonora, un día eres teletransportado a una mazmorra peligrosa en un mundo desconocido, debes completar una serie de preguntas para  lograr volver a tu mundo sano y salvo... ¿Podrás escapar de aquí?");
        mensaje.setBounds(50, 50, 700, 150);
        mensaje.setBackground(Color.BLACK);
        mensaje.setForeground(Color.white);
        mensaje.setEditable(false);
        mensaje.setLineWrap(true);
        mensaje.setWrapStyleWord(true);
        mensaje.setFont(new Font("Hoefler Text", Font.PLAIN, 26));
        add(mensaje);

        DQ= new JLabel("DUNGEONS & QUESTIONS");
        DQ.setBounds(225,50,350,100);
        DQ.setBackground(Color.white);
        DQ.setOpaque(true);
        DQ.setFont(new Font("Hoefler Text", Font.PLAIN, 26));
        DQ.setForeground(Color.BLACK);
        DQ.setVisible(false);
        add(DQ);

        start = new JButton("START");//Botton de start
        start.setBounds(300, 300, 200, 80);
        start.setFont((new Font("Hoefler Text", Font.PLAIN, 26)));
        start.addActionListener(e -> mensaje.setVisible(false));
        start.addActionListener(e -> start.setVisible(false));
        start.addActionListener(e -> DQ.setVisible(true));
        add(start);
        setVisible(true);


    }

    public static void main(String[] args) {
        test t = new test();
    }



}


