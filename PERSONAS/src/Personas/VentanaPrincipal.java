package Personas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private ListaPersonas lista;
    private Container contenedor;
    private JTextField textapellido;
    private JTextField textnombre;
    private JTextField texttelefono;
    private JTextField textdireccion;
    private JLabel direccion;
    private JLabel nombre;
    private JLabel apellido;
    private JLabel telefono;
    private JButton anadir;
    private JButton borrarlista;
    private JButton eliminar;
    private JList Listanombres;
    private JScrollPane scrollLista;
    public JPanel Panel;
    private DefaultListModel modelo;


    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public VentanaPrincipal(){
           lista = new ListaPersonas();
           inicio();
           setTitle("Personas");
           setSize(270,350);
           setLocationRelativeTo(null);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   setResizable(false);


       anadir.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if(e.getSource()==anadir){
                   anadirPersona();
               }
           }
       });
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==eliminar){
                    eliminarNombre(Listanombres.getSelectedIndex());
                }
            }
        });
        borrarlista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==borrarlista){
                    borrarlist();
                }
            }
        });
    }

   private void inicio(){
       contenedor = getContentPane();
       contenedor.setLayout(null);
       nombre.setText("nombre");
       nombre.setBounds(20,20,135,23);
       textnombre.setBounds(105,20,135,23);
       apellido.setText("Apellido");
       apellido.setBounds(20,50,135,23);
       textapellido.setBounds(105,50,135,23);
       telefono.setText("Telefono");
       telefono.setBounds(20,80,135,23);
       texttelefono.setBounds(105,80,135,23);
       direccion.setText("Direccion");
       direccion.setBounds(20,110,135,23);
       textdireccion.setBounds(105,110,135,23);
       anadir.setText("anadir");
       anadir.setBounds(105,150,80,23);
       anadir.addActionListener((ActionListener) this);
       eliminar.setText("Eliminar");
       eliminar.setBounds(20,280,80,23);
       eliminar.addActionListener((ActionListener) this);
       borrarlista.setText("Borrar Lista");
       borrarlista.setBounds(120,280,120,23);
       borrarlista.addActionListener((ActionListener) this);
       Listanombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       modelo = new DefaultListModel();
       scrollLista.setBounds(20,190,220,80);
       scrollLista.setViewportView(Listanombres);
       contenedor.add(nombre);
       contenedor.add(textnombre);
       contenedor.add(apellido);
       contenedor.add(textapellido);
       contenedor.add(telefono);
       contenedor.add(texttelefono);
       contenedor.add(direccion);
       contenedor.add(textdireccion);
       contenedor.add(anadir);
       contenedor.add(eliminar);
       contenedor.add(borrarlista);
       contenedor.add(scrollLista);
   }

   private void anadirPersona(){
       persona p = new persona(textnombre.getText(),textapellido.getText(),texttelefono.getText(),textdireccion.getText());
       lista.anadirPersona(p);
       String elemento = textnombre.getText() + "-"+textapellido.getText() +"-"+ texttelefono.getText()+"-"+textdireccion.getText();
       modelo.addElement(elemento);
       Listanombres.setModel(modelo);
       textnombre.setText("");
       textapellido.setText("");
       texttelefono.setText("");
       textdireccion.setText("");

   }

   private void eliminarNombre(int indice){
       if(indice>=0){
           modelo.removeElement(indice);
           lista.eliminarPersona(indice);
       } else {
           JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento", "error",JOptionPane.ERROR_MESSAGE);
       }
   }

   private void borrarlist(){
       lista.borrarlist();
       modelo.clear();
   }
}
