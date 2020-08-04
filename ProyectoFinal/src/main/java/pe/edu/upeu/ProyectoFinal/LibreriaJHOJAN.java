package pe.edu.upeu.proyectofinal;

import javax.swing.JFrame;
import pe.edu.upeu.utils.UtilsX;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class LibreriaJHOJAN extends JFrame implements ActionListener{

    private static final long serialVersionIUD = 1L;
    int numeros;
    JPanel panel;
    JTextField texto;
    JScrollPane scrollPane=new JScrollPane();
    BufferedImage image;
    JTable table;
    JMenuBar mb;
    JMenu m1;
    JMenu m2;
    JMenu m3;
    JMenuItem m11;
    JMenuItem m22;
    JMenuItem m33;
    UtilsX obj=new UtilsX();
    JPanel panelFoot;
    JButton send, reset;
    
    public LibreriaJHOJAN(){
        this.setTitle("Lirbreria JHOJAN @RMSA-@LMLC-@ADQY-@DBGC----UPEU");
        mb = new JMenuBar();
        m1 = new JMenu("Agregar");
        m2 = new JMenu("Pedidos");
        m3 = new JMenu("Ayuda");
        m11 = new JMenuItem("Nuevo Producto");
        m22 = new JMenuItem("");
        m33 = new JMenuItem("");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new Dimension(screenSize.width, screenSize.height-36));
        mb.add(m1);
        mb.add(m2);
        m11.addActionListener(this);
        m1.add(m11);
        m1.add(m22);
        panelFoot = new JPanel();
        send = new JButton("");
        reset = new JButton("Borrar");
        texto = new JTextField("6");
        texto.setPreferredSize(new Dimension(100, 25));
        send.addActionListener(this);
        panelFoot.add(texto);
        panelFoot.add(send);
        panelFoot.add(reset);
        this.getContentPane().add(BorderLayout.SOUTH, panelFoot);
        this.getContentPane().add(BorderLayout.NORTH, mb);
        this.setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
    
}