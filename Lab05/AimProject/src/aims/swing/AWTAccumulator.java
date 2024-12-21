package src.aims.swing;
import java.awt.*;
import java.awt.event.*;


public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;//Accumulated sum, init to 0 

    //Constructor to setup the GUI componets and event handlers
    public AWTAccumulator() {
        setLayout(new GridLayout(2,2));

        add(new Label("Enter an Integer: "));

        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new TFInputListener());

         add(new Label("The Accumulated Sum is: "));
           
        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new AWTAccumulator();
    }

    public AWTAccumulator(TextField tfInput, TextField tfOutput) throws HeadlessException {
        this.tfInput = tfInput;
        this.tfOutput = tfOutput;
    }

    public AWTAccumulator(TextField tfInput, TextField tfOutput, GraphicsConfiguration gc) {
        super(gc);
        this.tfInput = tfInput;
        this.tfOutput = tfOutput;
    }

    public AWTAccumulator(TextField tfInput, TextField tfOutput, String title) throws HeadlessException {
        super(title);
        this.tfInput = tfInput;
        this.tfOutput = tfOutput;
    }

    public AWTAccumulator(TextField tfInput, TextField tfOutput, String title, GraphicsConfiguration gc) {
        super(title, gc);
        this.tfInput = tfInput;
        this.tfOutput = tfOutput;
    }
    private class TFInputListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt) {
            int numberIn = Integer.parseInt(tfInput.getText());

            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }
}