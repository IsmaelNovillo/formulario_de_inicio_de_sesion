import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    private JPanel myPanel;
    private JButton btLOGIN;
    private JButton btADD;
    public JTextField txID;
    private JTextField txPASSWORD;
    private JButton btDELETE;
    private JButton btUPDATE;
    private String x;
    public Ventana(){
        setContentPane(myPanel);
        setTitle("login");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btLOGIN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = txID.getText();
                Conect dos = new Conect();
                dos.coneccion(x);

                if (dos.Password.equals(txPASSWORD.getText())){
                    JOptionPane.showMessageDialog(null,"Sesion Iniciada");

                }else {
                    JOptionPane.showMessageDialog(null,"Contraseña no encontrada");
                }

            }
        });
        btDELETE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = txID.getText();
                Conect dos = new Conect();
                dos.ELIMINAR(x);
            }
        });
        btADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = txID.getText();
                String z = txPASSWORD.getText();
                Conect dos = new Conect();
                dos.aniadir(x,z);
            }
        });
        btUPDATE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = txID.getText();
                String z = txPASSWORD.getText();
                Conect dos = new Conect();
                dos.UPDATE(x,z,"45FT3");

            }
        });
    }

    public static void main(String[] args) {
        Ventana uno = new Ventana();


    }
}
