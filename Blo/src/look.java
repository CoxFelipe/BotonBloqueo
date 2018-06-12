import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.sun.corba.se.impl.ior.TaggedComponentFactoryFinderImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.Time;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.EventObject;


public class look extends JFrame {




    CRUD conectar  =  new CRUD();


    private JButton btnAcep;
    private int op;
    private JTextField un;
    private  JPanel panel;
    private JLabel labe;
    private JLabel lblcontrasenia;
    private Container panelPrinc;
    private String contrasenia;
    private Timer seg;
   int Inicio = 10;
    int acu =0 ;

    public look() {

        super("nuevo");

        Container panelPrinc = this.getContentPane();
        this.addComponentes();//llama al metodo
        this.addEventos();
        this.setVisible(true);


        Candado cd = new Candado(); //se crea un constructor

        //cd.setPreferredSize(new Dimension(300, 200));
        panelPrinc.add(cd);

        seg = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labe.setText(String.valueOf("El boton se desbloqueara en: "+Inicio));//convierte el tipo de dato de entero a cadena
                labe.setVisible(true);
                Inicio--;

                if (Inicio < 0) {

                    seg.stop();
                    btnAcep.setEnabled(true);

                    JOptionPane.showMessageDialog(null, "Listo Boton desbloqueado", "Desbloqueado", JOptionPane.INFORMATION_MESSAGE);
                    Inicio=10;
                    acu=0;
                    labe.setVisible(false);

                }

            }
        });
    }

    public static void main(String[] args)
    {
        look f = new look ();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800,600);
        f.setVisible(true);
    }


    public void addComponentes(){


        setLayout(new FlowLayout()); //ubica a todos los componentes en forma horizontal

        labe = new JLabel();
        labe.setPreferredSize(new Dimension(280, 20));
        add(labe);


        lblcontrasenia = new JLabel("Ingresar contraseña: ");
        lblcontrasenia.setPreferredSize(new Dimension(125, 20));
        add(lblcontrasenia);

        un = new JTextField ();
        un.setPreferredSize(new Dimension(100, 20));
        add(un);


        btnAcep = new JButton("Iniciar");
        add(btnAcep);
    }

    public void addEventos(){

        Bloqueo b = new Bloqueo();

        btnAcep.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                b.bloquear("");
            }
        });

        b.addBloqueoListener(new BloqueoListener() {
            @Override
            public void notificarSesion(EventObject o) {

                hilo h = new hilo();
                h.start();

            }
        });

    }


    class hilo extends Thread {



        public void run() {

            //un.getText()== contrasenia

            if (conectar.login(un.getText())) {



                JOptionPane.showMessageDialog(null, "ACCeso", "ENter", JOptionPane.INFORMATION_MESSAGE);
                dispose();//finaliza la ventana actual, terminar el programa
            }else if (!conectar.login(un.getText())) {

                acu++;
                                    if (acu==3) {
                                        btnAcep.setEnabled(false);
                                        seg.start();
                                    }


                            }



                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
        }
    }

}



