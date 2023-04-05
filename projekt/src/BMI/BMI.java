package BMI;

public class BMI implements IBMI {

    @Override
    public double calculateBMI(double h, double w){
        double bmi;
        bmi = w / (h * h)*10000;
        return Math.round(bmi * 10) / 10.0;
    }
    @Override
    public String checkingBMI(double bmi ){
        String res ="";
        if (bmi <16)
            res = "Wygłodzenie";
        else if (bmi>=16 && bmi<17)
           res = "Wychudzenie";
        else if (bmi>=17 && bmi<18.5)
           res = "Niedowaga";
        else if (bmi>=18.5 && bmi<25)
          res = "Waga prawidłowa";
        else if (bmi>=25 && bmi<30)
           res = "Nadwaga";
        else if (bmi>=30 && bmi<35)
           res = "Otyłość I stopnia";
        else if (bmi>= 35 && bmi<40)
          res = "Otyłość II stopnia";
        else if (bmi>=40)
            res = "Otyłość III stopnia";
        return res;
    }
}
