
import javax.swing.JOptionPane;



public class ChoosingOption {
    public static void main(String[] args) {
        Object[] options = {"I do", "I don't","Cancel"};
        int option = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket?", "Choose an Option", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);      
        
        String mes;
        if (option == 0) {
            mes = "I DO";
        } else if (option == 1) { 
            mes = "I DON'T";
        } else {
            mes = "You chose to cancel.";
}        JOptionPane.showMessageDialog(null, "You've chosen: " + mes);
        System.exit(0);
        
        
    }
}
