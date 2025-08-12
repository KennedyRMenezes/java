import javax.swing.JOptionPane;


public class Dialog1 {

    public static void main(String[] args) {
        

        String name = JOptionPane.showInputDialog("What's your name?");

        String message = String.format("Welcome, %s, to Java Programming! ", name);

        // Exemplo de método static (.showMessageDialog), pois não precisa
        // criar um objeto para executá-lo.
        JOptionPane.showMessageDialog(null, message);

    }

}
