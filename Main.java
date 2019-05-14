// Java program to create a simple calculator using Java Swing Elements
// Calculator++

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class Main extends JFrame implements ActionListener {

    private static JTextField field; // Create a textfield
    private String firstnum, operator, secondnum; // For operator and operand storage

    // The default constructor:
    private Main() {
        firstnum = "";
        operator = "";
        secondnum = "";
    }

    // The main function
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator++"); // Create a frame

        try { // Set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        Main calc = new Main(); // Create a new object of class main
        field = new JTextField(16); // Create a textfield
        field.setEditable(false); // Set the textfield to be non-editable

        // Tell the program to stop running on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // The number buttons:
        JButton b0 = new JButton("0");
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");

        // The equals button:
        JButton beq = new JButton("=");

        // Create operator buttons:
        JButton badd = new JButton("+");
        JButton bsub = new JButton("-");
        JButton bdiv = new JButton("/");
        JButton bmult = new JButton("*");
        JButton bclear = new JButton("C");

        // Create a . button:
        JButton bdec = new JButton(".");

        // The single-argument function buttons:
        JButton bsin = new JButton("sin");
        JButton bcos = new JButton("cos");
        JButton btan = new JButton("tan");
        JButton bsqr = new JButton("x^2");
        JButton bsqrt = new JButton("sqrt");
        JButton bexp = new JButton("e^x");
        JButton b10xp = new JButton("10^x");
        JButton brecip = new JButton("1/x");
        JButton bln = new JButton("ln");

        // Create a panel:
        JPanel panel = new JPanel();

        // Add action listeners pertaining to each button:
        bmult.addActionListener(calc);
        bdiv.addActionListener(calc);
        bsub.addActionListener(calc);
        badd.addActionListener(calc);
        b9.addActionListener(calc);
        b8.addActionListener(calc);
        b7.addActionListener(calc);
        b6.addActionListener(calc);
        b5.addActionListener(calc);
        b4.addActionListener(calc);
        b3.addActionListener(calc);
        b2.addActionListener(calc);
        b1.addActionListener(calc);
        b0.addActionListener(calc);
        bdec.addActionListener(calc);
        bclear.addActionListener(calc);
        beq.addActionListener(calc);
        bsin.addActionListener(calc);
        bcos.addActionListener(calc);
        btan.addActionListener(calc);
        bsqr.addActionListener(calc);
        bsqrt.addActionListener(calc);
        bexp.addActionListener(calc);
        b10xp.addActionListener(calc);
        brecip.addActionListener(calc);
        bln.addActionListener(calc);

        // Add elements to the panel:
        panel.add(field);
        panel.add(badd);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(bsub);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(bmult);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(bdiv);
        panel.add(bdec);
        panel.add(b0);
        panel.add(bclear);
        panel.add(beq);
        panel.add(bsin);
        panel.add(bcos);
        panel.add(btan);
        panel.add(bsqr);
        panel.add(bsqrt);
        panel.add(bexp);
        panel.add(b10xp);
        panel.add(brecip);
        panel.add(bln);

        panel.setBackground(Color.black); // Set the background colour of the panel
        frame.add(panel); // Add the panel to the frame
        frame.setSize(200, 300); // Where we're keeping the size of the panel
        frame.setVisible(true);               // Where we're keeping the visibility of the panel
    }

    public void actionPerformed(ActionEvent event) {
        String input = event.getActionCommand(); // Where we store the user's input
        double result; // Where we store the result of calculation

        // If the value is a number
        if ((input.charAt(0) >= '0' && input.charAt(0) <= '9') || input.charAt(0) == '.') {
            if (!firstnum.equals("") && !(firstnum.charAt(0) >= '0' && firstnum.charAt(0) <= '9')) {
                operator = operator + input;
            } else if (!operator.equals("")) {
                // If we have an operand, concatenate it with the second number (string)
                secondnum = secondnum + input;
            } else { // Otherwise, concatenate it with the first number (string)
                firstnum = firstnum + input;
            }

            // Set the value of text
            field.setText(firstnum + " " + operator + " " + secondnum);
        } else if (input.charAt(0) == 'C') { // Otherwise, if we're told to clear:
            firstnum = operator = secondnum = ""; // Changing them all to blank spaces
            field.setText(firstnum + operator + secondnum); // Set the value of text (to be blank)
        } else if (input.equals("sin") || input.equals("cos") || input.equals("tan") ||
                input.equals("sqrt") || input.equals("ln")) {
            firstnum = input;
            field.setText(firstnum);
        } else if (input.equals("x^2")) {
            operator = "^ 2";
            field.setText(firstnum + " " + operator);
        } else if (input.equals("e^x")) {
            firstnum = "e ^";
            field.setText(firstnum);
        } else if (input.equals("10^x")) {
            firstnum = "10 ^";
            field.setText(firstnum);
        } else if (input.equals("1/x")) {
            firstnum = "1 /";
            field.setText(firstnum);
        } else { // Otherwise, evaluate what we currently have (say, if there's an equal sign)
            if ((!(input.charAt(0) == '=')) && (operator.equals("") || secondnum.equals(""))) {
                // If we didn't get an equals sign, and we're missing some numbers...
                operator = input;
                // Set the value of text
                field.setText(firstnum + " " + operator + " " + secondnum);

            } else { // Otherwise...
                if (!(operator.charAt(0) >= '0' && operator.charAt(0) <= '9')) {
                    switch (operator) { // Evaluation, based on our operator. (Subject to additions)
                        case "+":
                            result = (Double.parseDouble(firstnum) + Double.parseDouble(secondnum));
                            break;
                        case "-":
                            result = (Double.parseDouble(firstnum) - Double.parseDouble(secondnum));
                            break;
                        case "*":
                            result = (Double.parseDouble(firstnum) * Double.parseDouble(secondnum));
                            break;
                        case "/":
                            result = (Double.parseDouble(firstnum) / Double.parseDouble(secondnum));
                            break;
                        case "^ 2":
                            result = (Double.parseDouble(firstnum) * Double.parseDouble(firstnum));
                            break;
                        default:
                            result = 0;
                            break;
                    }
                } else {
                    switch(firstnum) { // Evaluation, based on our firstpos.
                        case "sin":
                            result = Math.sin(Double.parseDouble(operator));
                            break;
                        case "cos":
                            result = Math.cos(Double.parseDouble(operator));
                            break;
                        case "tan":
                            result = Math.tan(Double.parseDouble(operator));
                            break;
                        case "sqrt":
                            result = Math.sqrt(Double.parseDouble(operator));
                            break;
                        case "ln":
                            result = Math.log(Double.parseDouble(operator));
                            break;
                        case "e ^":
                            result = Math.exp(Double.parseDouble(operator));
                            break;
                        case "10 ^":
                            result = Math.pow(10, Double.parseDouble(operator));
                            break;
                        case "1 /":
                            result = (1 / Double.parseDouble(operator));
                            break;
                        default:
                            result = 0;
                            break;
                    }
                }

                if (input.charAt(0) == '=') {
                    field.setText(firstnum + " " + operator + " " + secondnum + " = " + result);
                    // Display our result in the field, loud and clear
                    firstnum = Double.toString(result); // Convert our result from a double into a string
                    operator = secondnum = ""; // Reset the value of operator and secondnum
                } else {
                    firstnum = Double.toString(result); // Convert the result to a string
                    operator = input; // Set operator to be the original input (operator)
                    secondnum = ""; // Delete the second number

                    // Set the value of text
                    field.setText(firstnum + " " + operator + " " + secondnum);
                }
            }
        }
    }
}

// Credit to GeeksforGeeks for the initial layout

