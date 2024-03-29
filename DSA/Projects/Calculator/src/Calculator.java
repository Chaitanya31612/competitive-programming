import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    JPanel[] row = new JPanel[5];
    JButton[] button = new JButton[19];
    String[] buttonString = {"7", "8", "9", "+",
                             "4", "5", "6", "-",
                             "1", "2", "3", "*",
                             ".", "/", "C", "sqrt",
                             "+/-", "=", "0"
                            };
    int[] dimW = {430, 70, 150, 140};
    int[] dimH = {50, 60};
    Dimension displayDimension = new Dimension(dimW[0], dimH[0]);
    Dimension regularDimension = new Dimension(dimW[1], dimH[1]);
    Dimension rColumnDimension = new Dimension(dimW[2], dimH[1]);
    Dimension zeroButDimension = new Dimension(dimW[3], dimH[1]);

    // for +, -, *, /
    boolean[] function = new boolean[4];
    // for storing previous and present value
    double[] temporary = {0, 0};
    JTextArea display = new JTextArea(2, 25);
    Font font = new Font("Poppins", Font.BOLD, 20);

    Calculator() {
        super("Calculator");
        setDesign();
        setSize(500, 350);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(5, 5);
        setLayout(grid);

        for(int i = 0; i < 4; i++) {
            function[i] = false;
        }

        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER, 1, 1);
        for(int i = 0; i < 5; i++)
            row[i] = new JPanel();

        row[0].setLayout(f1);
        for(int i = 1; i < 5; i++) {
            row[i].setLayout(f2);
        }

        for(int i = 0; i < 19; i++) {
            button[i] = new JButton();
            button[i].setText(buttonString[i]);
            button[i].setBackground(Color.WHITE);
            button[i].setFont(font);
            button[i].addActionListener(this);
        }

        display.setFont(font);
        display.setEditable(true);
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        display.setPreferredSize(displayDimension);

        for(int i = 0; i < 14; i++)
            button[i].setPreferredSize(regularDimension);
        for(int i = 14; i < 18; i++)
            button[i].setPreferredSize(rColumnDimension);
        button[18].setPreferredSize(zeroButDimension);

        row[0].add(display); // add text view to JPanel
        add(row[0]); // adds JPanel to Frame

        for(int i = 0; i < 4; i++)
            row[1].add(button[i]);
        row[1].add(button[14]);
        add(row[1]);

        for(int i = 4; i < 8; i++)
            row[2].add(button[i]);
        row[2].add(button[15]);
        add(row[2]);

        for(int i = 8; i < 12; i++)
            row[3].add(button[i]);
        row[3].add(button[16]);
        add(row[3]);

        row[4].add(button[18]);
        for(int i = 12; i < 14; i++)
            row[4].add(button[i]);
        row[4].add(button[17]);
        add(row[4]);

        setVisible(true);
    }

    public void clear() {
        try {
            display.setText("");
            for(int i = 0; i < 4; i++)
                function[i] = false;
            for(int i = 0; i < 2; i++)
                temporary[i] = 0;

        } catch (NumberFormatException e) {

        }
    }

    public void getSqrt() {
        try {
            double val = Math.sqrt(Double.parseDouble(display.getText()));
            display.setText(Double.toString(val));
        } catch (NumberFormatException e) {

        }
    }

    public void getPosNeg() {
        try {
            double val = Double.parseDouble(display.getText());
            if(val != 0) {
                val = val * (-1);
                display.setText(Double.toString(val));
            }
        } catch (NumberFormatException e) {

        }
    }

    public void getResult() {
        double result = 0;
        temporary[1] = Double.parseDouble(display.getText());
        try {
            if(function[2])
                result = temporary[0] * temporary[1];
            else if(function[3])
                result = temporary[0] / temporary[1];
            else if(function[0])
                result = temporary[0] + temporary[1];
            else if(function[1])
                result = temporary[0] - temporary[1];

            display.setText(Double.toString(result));
            for(int i = 0; i < 4; i++)
                function[i] = false;
        } catch (NumberFormatException e) {

        }
    }

    public final void setDesign() {
        try {
//            "com.sum.java.swing.plaf.numbus.NumbusLookAndFeel"
//            "com.sun.java.swing.plaf.gtk.GTKLookAndFeel"
//            "com.sun.java.swing.plaf.motif.MotifLookAndFeel"
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"
            );
        } catch(Exception e) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == button[0])
            display.append("7");
        if(ae.getSource() == button[1])
            display.append("8");
        if(ae.getSource() == button[2])
            display.append("9");
        if(ae.getSource() == button[3]) {
            // add
            temporary[0] = Double.parseDouble(display.getText());
            function[0] = true;
            display.setText("");
        }
        if(ae.getSource() == button[4])
            display.append("4");
        if(ae.getSource() == button[5])
            display.append("5");
        if(ae.getSource() == button[6])
            display.append("6");
        if(ae.getSource() == button[7]) {
            // subtract
            temporary[0] = Double.parseDouble(display.getText());
            function[1] = true;
            display.setText("");
        }
        if(ae.getSource() == button[8])
            display.append("1");
        if(ae.getSource() == button[9])
            display.append("2");
        if(ae.getSource() == button[10])
            display.append("3");
        if(ae.getSource() == button[11]) {
            // multiply
            temporary[0] = Double.parseDouble(display.getText());
            function[2] = true;
            display.setText("");
        }
        if(ae.getSource() == button[12])
            display.append(".");
        if(ae.getSource() == button[13]) {
            // divide
            temporary[0] = Double.parseDouble(display.getText());
            function[3] = true;
            display.setText("");
        }
        if(ae.getSource() == button[14]) {
            // clear
            display.setText("");
        }
        if(ae.getSource() == button[15]) {
            // sqrt
            getSqrt();
        }
        if(ae.getSource() == button[16]) {
            // +/-
            getPosNeg();
        }
        if(ae.getSource() == button[17]) {
            // result
            getResult();
        }
        if(ae.getSource() == button[18])
            display.append("0");

    }

    public static void main(String[] args) {
        Calculator c = new Calculator();

    }
}
