import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Calculator implements ActionListener {

    JLabel displayLabel;
    JButton sevenButton, eightButton, nineButton;
    JButton fourButton, fiveButton, sixButton;
    JButton oneButton, twoButton, threeButton;
    JButton zeroButton, dotButton, equalButton;
    JButton addButton, minusButton, mulButton, divisionButton, clearButton;

    boolean isOperatorClicked = false;
    String oldValue, operator;

    public Calculator() {
        JFrame jf = new JFrame("Calculator");
        jf.setLayout(null);
        jf.setSize(550, 600);
        jf.setLocation(500, 150);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayLabel = new JLabel();
        displayLabel.setBounds(30, 50, 490, 40);
        displayLabel.setBackground(Color.gray);
        displayLabel.setOpaque(true);
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        displayLabel.setForeground(Color.white);
        jf.add(displayLabel);

        // Row 1
        sevenButton = new JButton("7");
        sevenButton.setBounds(30, 130, 80, 80);
        sevenButton.addActionListener(this);
        jf.add(sevenButton);

        eightButton = new JButton("8");
        eightButton.setBounds(130, 130, 80, 80);
        eightButton.addActionListener(this);
        jf.add(eightButton);

        nineButton = new JButton("9");
        nineButton.setBounds(230, 130, 80, 80);
        nineButton.addActionListener(this);
        jf.add(nineButton);

        divisionButton = new JButton("/");
        divisionButton.setBounds(330, 130, 80, 80);
        divisionButton.addActionListener(this);
        jf.add(divisionButton);

        // Row 2
        fourButton = new JButton("4");
        fourButton.setBounds(30, 230, 80, 80);
        fourButton.addActionListener(this);
        jf.add(fourButton);

        fiveButton = new JButton("5");
        fiveButton.setBounds(130, 230, 80, 80);
        fiveButton.addActionListener(this);
        jf.add(fiveButton);

        sixButton = new JButton("6");
        sixButton.setBounds(230, 230, 80, 80);
        sixButton.addActionListener(this);
        jf.add(sixButton);

        mulButton = new JButton("X");
        mulButton.setBounds(330, 230, 80, 80);
        mulButton.addActionListener(this);
        jf.add(mulButton);

        // Row 3
        threeButton = new JButton("3");
        threeButton.setBounds(30, 330, 80, 80);
        threeButton.addActionListener(this);
        jf.add(threeButton);

        twoButton = new JButton("2");
        twoButton.setBounds(130, 330, 80, 80);
        twoButton.addActionListener(this);
        jf.add(twoButton);

        oneButton = new JButton("1");
        oneButton.setBounds(230, 330, 80, 80);
        oneButton.addActionListener(this);
        jf.add(oneButton);

        minusButton = new JButton("-");
        minusButton.setBounds(330, 330, 80, 80);
        minusButton.addActionListener(this);
        jf.add(minusButton);

        // Row 4
        dotButton = new JButton(".");
        dotButton.setBounds(30, 430, 80, 80);
        dotButton.addActionListener(this);
        jf.add(dotButton);

        zeroButton = new JButton("0");
        zeroButton.setBounds(130, 430, 80, 80);
        zeroButton.addActionListener(this);
        jf.add(zeroButton);

        equalButton = new JButton("=");
        equalButton.setBounds(230, 430, 80, 80);
        equalButton.addActionListener(this);
        jf.add(equalButton);

        addButton = new JButton("+");
        addButton.setBounds(330, 430, 80, 80);
        addButton.addActionListener(this);
        jf.add(addButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(430, 430, 100, 80);
        clearButton.addActionListener(this);
        jf.add(clearButton);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    public void actionPerformed(ActionEvent e) {

        Object src = e.getSource();

        // Numbers
        if (src == sevenButton) {
            appendNumber("7");
        } else if (src == eightButton) {
            appendNumber("8");
        } else if (src == nineButton) {
            appendNumber("9");
        } else if (src == fourButton) {
            appendNumber("4");
        } else if (src == fiveButton) {
            appendNumber("5");
        } else if (src == sixButton) {
            appendNumber("6");
        } else if (src == oneButton) {
            appendNumber("1");
        } else if (src == twoButton) {
            appendNumber("2");
        } else if (src == threeButton) {
            appendNumber("3");
        } else if (src == zeroButton) {
            appendNumber("0");
        } else if (src == dotButton) {
            appendNumber(".");
        }

        // Operators
        else if (src == addButton) {
            storeOperator("+");
        } else if (src == minusButton) {
            storeOperator("-");
        } else if (src == mulButton) {
            storeOperator("*");
        } else if (src == divisionButton) {
            storeOperator("/");
        }

        // Equal
        else if (src == equalButton) {
            calculateResult();
        }

        // Clear
        else if (src == clearButton) {
            displayLabel.setText("");
            oldValue = null;
            operator = null;
        }
    }

    private void appendNumber(String num) {
        if (isOperatorClicked) {
            displayLabel.setText(num);
            isOperatorClicked = false;
        } else {
            displayLabel.setText(displayLabel.getText() + num);
        }
    }

    private void storeOperator(String op) {
        oldValue = displayLabel.getText();
        operator = op;
        isOperatorClicked = true;
    }

    private void calculateResult() {
        if (oldValue == null || operator == null) return;

        String newValue = displayLabel.getText();
        double oldVal = Double.parseDouble(oldValue);
        double newVal = Double.parseDouble(newValue);
        double result = 0;

        switch (operator) {
            case "+":
                result = oldVal + newVal;
                break;
            case "-":
                result = oldVal - newVal;
                break;
            case "*":
                result = oldVal * newVal;
                break;
            case "/":
                if (newVal != 0)
                    result = oldVal / newVal;
                else
                    displayLabel.setText("Error");
                return;
        }

        displayLabel.setText(result + "");
        oldValue = null;
        operator = null;
    }
}
