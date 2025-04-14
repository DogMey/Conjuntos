package newpackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class conju extends JFrame  implements ActionListener {
	
    JFrame marco=new JFrame();
    JTextField conj1 = new JTextField();
    JTextField conj2 = new JTextField();
    JButton boton1 = new JButton("Leer");
    JButton boton2 = new JButton("Iniciar");
    JLabel unionm=new JLabel();
    JLabel interseccionm=new JLabel();
    JLabel diferenciam=new JLabel();
    JLabel Error=new JLabel();
    JTextField []conjunto1;
    JTextField []conjunto2;
    int c1[];
    int c2[];
    int union[];
    int interseccion[];
    int diferencia[];

    conju(){
    marco.getContentPane().setBackground(new Color(255, 227, 144));
    marco.setName("Conjuntos");
    marco.setSize(600,400);
    marco.setVisible(true);
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setLayout(null);
    Font letra2 = new Font("Book Antiqua",Font.BOLD,14);
    marco.add(conj1);
    conj1.setBounds(30,30,25,20);
    conj1.setBackground(new Color(76, 219, 161));
    marco.add(conj2);
    conj2.setBounds(30,80,25,20);
    conj2.setBackground(new Color(76, 219, 161));
    marco.add(boton1);
    boton1.setBounds(30,130,70,20);
    boton1.setBackground(new Color(76, 109, 219));
    boton1.addActionListener(this);
    marco.add(boton2);
    boton2.setBackground(new Color(76, 109, 219));
    boton2.setBounds(150,130,70,20);
    boton2.addActionListener(this);
    marco.add(unionm);
    unionm.setBounds(50,200,180,20);
    unionm.setFont(letra2);
    marco.add(interseccionm);
    interseccionm.setBounds(50,250,180,20);
    interseccionm.setFont(letra2);
    marco.add(diferenciam);
    diferenciam.setBounds(50,300,310,20);
    diferenciam.setFont(letra2);
    }

    @Override
    public void actionPerformed(ActionEvent c){

        int x=0;
        int y=0;

        if(c.getSource()==boton1) {

            String aux1;
            aux1=conj1.getText();
            x=leerdatos(aux1);
            conjunto1=new JTextField[x];
            c1 = new int [x];
            for(int i=0;i<x;i++){
                conjunto1[i]=new JTextField();
                marco.add(conjunto1[i]);
                conjunto1[i].setBounds(80+i*30,30,25,20);
                conjunto1[i].setBackground(new Color(248, 123, 79));
            }
            aux1=conj2.getText();
            y=leerdatos(aux1);
            conjunto2=new JTextField[y];
            c2 = new int [y];
            for(int i=0;i<y;i++){
                conjunto2[i]=new JTextField();
                marco.add(conjunto2[i]);
                conjunto2[i].setBounds(80+i*30,80,25,20);
                conjunto2[i].setBackground(new Color(248, 123, 79));
            }
        }

        if(c.getSource()==boton2) {

            String aux2;
            int z,a;
            String total="";

            for (int i=0; i<x; i++) {
                aux2=conjunto1[i].getText();
                c1[i]=leerdatos(aux2);
            }

            if(x<y) {
                z=x;
                a=y;
            }else {
                z=y;
                a=x;
            }

            union = new int[x+y];
            Unión objeto1 = new Unión();
            union = objeto1.operacion(c1 ,c2 ,union , x, y, x+y);			

            for(int i=0;i<x+y;i++){
                total=total+ union[i]+"  ";
            }
            unionm.setText("hola1"+total);
            interseccion = new int[z];
            Interseccion objeto2 = new Interseccion();
            interseccion = objeto2.operacion(c1, c2, interseccion , x, y, z);total="";    
            for(int i=0;i<z;i++){
                total=total+ interseccion[i]+"  ";
            }
            interseccionm.setText("hola2"+total);

            Diferencia objeto3  = new Diferencia();
            diferencia = new int[a];
            diferencia = objeto3.operacion(c1, c2, diferencia , x, y, z);total="";
            for (int i=0;i<z;i++) {
                total=total+ diferencia[i]+"  ";
            }
            diferenciam.setText("hola3"+total);
        }
    }

    boolean verificacion(String x) {
        try {
            Integer.parseInt(x);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    int leerdatos(String x) {
        System.out.println(x);
        int y=0;
        if (verificacion(x) == false) {
            Error.setText("Caracter invalido");
        } else {
            y = Integer.parseInt(x);
            Error.setText("");
        }
        return y;
    }
}