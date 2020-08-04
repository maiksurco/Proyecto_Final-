package pe.edu.upeu.proyectofinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControlDeAcceso extends JFrame implements ActionListener {

    private static final long serialVersionUID =1L;

    JPanel panel;
    JLabel nombredeusuarioLabel;
    JLabel clavedeaccesoLabel;
    JTextField nombredeusuarioTxt;
    JTextField clavedeaccesoTxt;
    JButton btnIngresar;

    public ControlDeAcceso(){
        this.setTitle("Control de Acceso al Sistema");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setSize(300, 150);
        panel = new JPanel();

        nombredeusuarioLabel=new JLabel("Nombre de Usuario");
        nombredeusuarioLabel.setBounds(15, 15, 90, 25);
        nombredeusuarioTxt = new JTextField(20);
        nombredeusuarioTxt.setBounds(100, 10, 160, 25);

        clavedeaccesoLabel=new JLabel("Clave de Acceso");
        clavedeaccesoLabel.setBounds(10, 40, 80, 25);
        clavedeaccesoTxt = new JTextField(20);
        clavedeaccesoTxt.setBounds(100, 40, 160, 25);

		btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(10, 80, 80, 25); 
        btnIngresar.addActionListener(this);       

        panel.add(nombredeusuarioLabel);
        panel.add(nombredeusuarioTxt);
        panel.add(clavedeaccesoLabel);
        panel.add(clavedeaccesoTxt);
        panel.add(btnIngresar);

        this.add(panel);
        this.setVisible(true);
    }
    //@Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnIngresar){
        if(nombredeusuarioTxt.getText().equals("maiksurco") && clavedeaccesoTxt.getText().equals("12345")){
            System.out.println("si ingreso");
        }else{
            System.out.println("codigo incorrecto");
        }
        }
    }
    
}