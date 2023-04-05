package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BMI.IBMI;
import BMI.BMI;
import BMR.BMR;
import BMR.IBMR;
import LBM.ILBM;
import LBM.LBM;
import data.ActivityLevel;
import data.Gender;

public class CalculatorForm {
    private JPanel mainPanel;
    private JTextField heightTextField;
    private JTextField weightTextField;
    private JButton calculateButton;
    private JComboBox genderComboBox;
    private JTextField agetextField;
    private  JComboBox  activityComboBox;
    private JTextField bmiTextField;
    private JTextField intervalTextField;
    private JTextField bmrTextField;
    private JTextField checkBMITextField;
    private JTextField caloriesTextField;
    private JTextField lbmTextField;
    private IBMI b = new BMI();
    private IBMR r = new BMR();
    private ILBM l = new LBM();

    public CalculatorForm() {
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String sWeight = weightTextField.getText();
                    double weight = Math.abs(Double.parseDouble(sWeight));

                    String sHeight = heightTextField.getText();
                    double height = Math.abs(Double.parseDouble(sHeight));

                    String sAge = agetextField.getText();
                    double age = Math.abs(Double.parseDouble(sAge));

                    Enum g = (Enum) genderComboBox.getSelectedItem();
                    Enum aLevel = (Enum) activityComboBox.getSelectedItem();

                    double bmi = b.calculateBMI(height, weight);
                    String isCorrect = b.checkingBMI(bmi);
                    int bmr = r.calculateBMR(weight, height, age, String.valueOf(g));
                    int calories = r.caloriesDemand(bmr, String.valueOf(aLevel));
                    double lbm = l.calculateLBM(weight, height, String.valueOf(g));

                    bmiTextField.setText(String.valueOf(bmi));
                    checkBMITextField.setText(isCorrect);
                    bmrTextField.setText(String.valueOf(bmr));
                    caloriesTextField.setText(String.valueOf(calories));
                    lbmTextField.setText(String.valueOf(lbm));
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Zły format liczby!");

                }
            }
        });
        intervalTextField.setText("**************************************************************************************************************************************************");


    }
    private static CalculatorForm form;
    public static void main(String [] args) {
        JFrame mainFrame = new JFrame("Fitness Calculator");
        CalculatorForm form = new CalculatorForm();
        mainFrame.setContentPane(form.mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
        initActivity(form);
        initGender(form);
    }

    private static void initActivity(CalculatorForm frm) {
        frm.activityComboBox.addItem(ActivityLevel.NO_ACTIVITY);
        frm.activityComboBox.addItem(ActivityLevel.LOW_ACTIVITY);
        frm.activityComboBox.addItem(ActivityLevel.MEDIUM_ACTIVITY);
        frm.activityComboBox.addItem(ActivityLevel.HIGH_ACTIVITY);
        frm.activityComboBox.addItem(ActivityLevel.EXTREME_ACTIVITY);

    }
    private static void initGender(CalculatorForm frm){
        frm.genderComboBox.addItem(Gender.MALE);
        frm.genderComboBox.addItem(Gender.FEMALE);

    }
}
