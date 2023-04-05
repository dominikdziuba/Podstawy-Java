package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calculate.Calculate;

public class CalculatorForm {

    private JPanel mainPanel;
    private JButton button0;
    private JButton dotButton;
    private JButton equalsButton;
    private JButton plusButton;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton minusButton;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton multiplyButton;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton divideButton;
    private JButton backspaceButton;
    private JButton clearButton;
    private JButton leftbracketButton;
    private JButton rightBracketButton;
    private JTextField results;
    private JButton endButton;

    private String expression = "";
    boolean equalSignUsed = false;

    public boolean checkLastCh(){
        if(expression.isEmpty()) {}
        else {
            char lastCh = expression.charAt(expression.length()-1);
            if(Character.isDigit(lastCh) || lastCh == ')')
                return true;
        }
        return false;
    }

    public boolean checkBrackets(){

        if(expression.isEmpty())
            return false;
        else{
            int leftBrackets = 0;
            int rightBrackets = 0;
            for(int i=0; i < expression.length(); i++)
            {
                if(expression.charAt(i) == '(') {
                    leftBrackets++;
                }
                else if(expression.charAt(i) == ')')
                    rightBrackets++;
            }
            if(leftBrackets > rightBrackets && expression.charAt(expression.length()-1) != ')')
                return true;
        }
        return false;
    }


    public CalculatorForm() {
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression += "0";
                results.setText(expression);
            }
        });
        dotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            expression += ".";
            results.setText(expression);
            }
        });
        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkLastCh() && !expression.isEmpty() && !checkBrackets()) {
                    double result = Calculate.calculation(Calculate.shuntingYardAlgorithm(expression));
                    expression = String.valueOf(result);
                    results.setText(expression);
                }
            }
        });
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkLastCh()){
                    expression +="+";
                    results.setText(expression);
                }
            }
        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            expression +="1";
            results.setText(expression);
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            expression +="2";
            results.setText(expression);
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            expression +="3";
            results.setText(expression);
            }
        });
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkLastCh()) {
                    expression += "-";
                    results.setText(expression);
                }
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            expression +="4";
            results.setText(expression);
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            expression +="5";
            results.setText(expression);
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            expression +="6";
            results.setText(expression);
            }
        });
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkLastCh()) {
                    expression += "*";
                    results.setText(expression);
                }
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            expression +="7";
            results.setText(expression);
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            expression +="8";
            results.setText(expression);
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            expression +="9";
            results.setText(expression);
            }
        });
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkLastCh()) {
                    expression += "/";
                    results.setText(expression);
                }
            }
        });
        backspaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!expression.isEmpty()){
                    expression = expression.substring(0, expression.length()-1);
                    results.setText(expression);
                }

            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression="";
                results.setText(expression);
            }
        });
        leftbracketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (expression.charAt(expression.length() - 1) != ')' && !Character.isDigit(expression.charAt(expression.length() - 1))) {
                    expression += "(";
                    results.setText(expression);
                }
            }
        });
        rightBracketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBrackets()) {
                    expression += ")";
                    results.setText(expression);
                }
            }
        });
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression="";
                results.setText(expression);
                System.exit(0);
            }
        });
    }

    private static CalculatorForm form;
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Calculator");
        form = new CalculatorForm();
        mainFrame.setContentPane(form.mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
