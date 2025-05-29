import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

class ImagePanel extends JPanel {
    private Image image;


    public ImagePanel(ImageIcon icon) {
        this.image = icon.getImage();
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}

class GUI {
    private Moneda moneda = null;
    private Producto producto = new Sprite(1);
    Comprador comprador = null;
    Expendedor expendedor = new Expendedor(100);

    public GUI() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        panel.setLayout(null);
        frame.add(panel, BorderLayout.CENTER);
        Icon icon100 = new ImageIcon(getClass().getResource("/100.png"));
        Icon icon500 = new ImageIcon(getClass().getResource("/500.png"));
        Icon icon1000 = new ImageIcon(getClass().getResource("/1000.png"));
        Icon iconExp = new ImageIcon(getClass().getResource("/exp.png"));
        Icon iconPersona1 = new ImageIcon(getClass().getResource("/persona1.png"));
        Icon iconPersona100 = new ImageIcon(getClass().getResource("/persona100.png"));
        Icon iconPersona500 = new ImageIcon(getClass().getResource("/persona500.png"));
        Icon iconPersona1000 = new ImageIcon(getClass().getResource("/persona1000.png"));
        JButton boton100 = new JButton(icon100);
        JButton boton500 = new JButton(icon500);
        JButton boton1000 = new JButton(icon1000);
        JButton buttonNum = new JButton();
        buttonNum.setContentAreaFilled(false);
        buttonNum.setBorderPainted(false);
        buttonNum.setFocusPainted(false);
        buttonNum.setOpaque(false);

        JPanel panelMoneda = new JPanel(new GridLayout(2, 2));

        panelMoneda.setBounds(10, 10, 200, 200);

        panel.add(panelMoneda);
        panelMoneda.add(boton100);
        panelMoneda.add(boton500);
        panelMoneda.add(boton1000);


        buttonNum.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setModal(true);
            dialog.setUndecorated(true);
            dialog.setSize(600, 600);
            dialog.setLocationRelativeTo(null);

            JPanel ventana = new JPanel();
            ventana.setBackground(Color.LIGHT_GRAY);
            ventana.setLayout(new BorderLayout());

            JPanel gridPanel = new JPanel(new GridLayout(3, 2, 10, 10));
            gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            ArrayList<JButton> botones = new ArrayList<>();
            for (int i = 1; i <= 6; i++) {
                JButton btn = new JButton("Botón " + i);
                botones.add(btn);
                gridPanel.add(btn);
            }
            botones.get(0).setText("Sprite");
            botones.get(0).addActionListener(ev -> {
                if(moneda.getValor() >= 200){ //REVISAR COMO CAMBIAR A LOS DATOS DE ENUMERACION
                    comprador = new Comprador(moneda, 2, expendedor);
                    System.out.println(comprador.queConsumiste());
                    System.out.println(comprador.cuantoVuelto());
                }
            });

            botones.get(1).setText("Coca");
            botones.get(1).addActionListener(ev -> {
                if(moneda.getValor() >= 1000) {
                    System.out.println("Coca");
                }
            });

            botones.get(2).setText("Fanta");
            botones.get(2).addActionListener(ev -> {
                System.out.println("Fanta");
            });

            botones.get(3).setText("Super8");
            botones.get(3).addActionListener(ev -> {
                System.out.println("Super8");
            });

            botones.get(4).setText("Snicker");
            botones.get(4).addActionListener(ev -> {
                System.out.println("Snicker");
            });

            botones.get(5).setText("Cancelar");
            botones.get(5).addActionListener(ev -> {
                dialog.dispose();
            });

            ventana.add(gridPanel, BorderLayout.CENTER);
            dialog.setContentPane(ventana);
            dialog.setVisible(true);

        });


        ImagePanel Exp = new ImagePanel((ImageIcon) iconExp);
        Exp.setBounds(350, 90, 300, 573);
        Exp.setLayout(null);
        panel.add(Exp);
        buttonNum.setBounds(240, 200, 65, 150);
        Exp.add(buttonNum);

        JLabel persona = new JLabel();
        persona.setOpaque(false);
        persona.setIcon(iconPersona1);
        persona.setBounds(250, 263, 150, 400);
        persona.setVisible(true);
        panel.add(persona);

        boton100.addActionListener(e -> {
            persona.setIcon(iconPersona100);
            moneda = new Moneda100();
        });

        boton500.addActionListener(e -> {
            persona.setIcon(iconPersona500);
            moneda = new Moneda500();
        });
        boton1000.addActionListener(e -> {
            persona.setIcon(iconPersona1000);
            moneda = new Moneda1000();
        });


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Test");
        frame.setResizable(false);
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        panel.setComponentZOrder(persona, 0);
        panel.setComponentZOrder(Exp, 1);
        //System.out.println(frame.getContentPane().getSize().height);
        //System.out.println(frame.getContentPane().getSize().width);
    }

}


public class Main {
    public static void main(String[] args) {
        new GUI();
    }
}
