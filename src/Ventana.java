import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana  extends JFrame{

    private JPanel panel;
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JComboBox listaDesplegable;
    private JButton boton1;
    private JButton boton2;
    private JTextField cajaTexto;
    private Moneda moneda;

    public Ventana(){
        setSize(400,200);
        setTitle("Conversor de Moneda");
        setLocationRelativeTo(null);
        setResizable(false);

        iniciarComponente();
        agregarEtiqueta();
        agregarListaDesplegable();
        agregarBoton();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciarComponente(){
        panel = new JPanel();
        panel.setLayout(null);
        getContentPane().add(panel);
    }

    private void agregarEtiqueta(){
        etiqueta1 = new JLabel();
        etiqueta1.setText("Convertir peso argentino a: ");
        etiqueta1.setBounds(10,20,380,30);
        etiqueta1.setFont(new Font("arial",Font.BOLD,15));

        panel.add(etiqueta1);
    }

    private void agregarListaDesplegable(){
        String monedas [] = {"Dolar","Euro","Real"};

        listaDesplegable = new JComboBox(monedas);
        listaDesplegable.setBounds(10,50,380,30);

        panel.add(listaDesplegable);
    }

    private void agregarBoton(){
        boton1 = new JButton();
        boton1.setBounds(150,100,100,30);
        boton1.setText("Aceptar");

        boton2 = new JButton();
        boton2.setText("Convertir");

        panel.add(boton1);
        panel.add(boton2);

        agregarEventoAlBotonAceptar();
        agregarEventoAlBotonConvertir();
    }

    private void agregarCajaDeTexto(){
        cajaTexto = new JTextField();
        etiqueta1.setText("Ingresar la cantidad a convertir: ");
        cajaTexto.setBounds(10,50,380,30);
        panel.add(cajaTexto);
    }

    private void agregarEventoAlBotonAceptar(){
       ActionListener actionListener = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               listaDesplegable.setVisible(false);
               boton1.setVisible(false);

               agregarCajaDeTexto();
               boton2.setBounds(150,100,100,30);
           }
       };

       boton1.addActionListener(actionListener);
    }


    private void agregarEventoAlBotonConvertir(){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int peso = Integer.parseInt(cajaTexto.getText());
                String resultado;

                if (listaDesplegable.getSelectedIndex() == 0){
                    etiqueta1.setText("Convertir a dolar: ");
                    moneda = new Dolar();
                }
                else if(listaDesplegable.getSelectedIndex() == 1){
                    etiqueta1.setText("Convertir a euro: ");
                    moneda = new Euro();
                }
                else if(listaDesplegable.getSelectedIndex() == 2){
                    etiqueta1.setText("Convertir a real: ");
                    moneda = new Real();
                }

                resultado = moneda.convertirMoneda(peso);
                String resultadoTexto = String.valueOf(resultado);

                cajaTexto.setVisible(false);

                etiqueta2 = new JLabel();
                etiqueta2.setText("Resultado: "+resultadoTexto);
                etiqueta2.setBounds(120,70,380,30);
                etiqueta2.setFont(new Font("arial",Font.BOLD,15));

                etiqueta1.setVisible(false);

                panel.add(etiqueta2);

                boton2.setVisible(false);
            }
        };

        boton2.addActionListener(actionListener);
    }

}
