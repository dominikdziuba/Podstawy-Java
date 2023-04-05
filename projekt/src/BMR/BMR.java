package BMR;

public class BMR implements IBMR {
    public  int calculateBMR(double w, double h, double a, String g){
        double bmr;
        if(g == "Mężczyzna")
            bmr = 5 + 9.99 * w + 6.25 * h - 4.92 * a;
        else if (g=="Kobieta")
            bmr = 9.99 * w + 6.25 * h - 4.92 * a-161;
        else throw new IllegalArgumentException("Niepoprawne dane spróbuj jeszcze raz");
        return (int) bmr;
    }
    public int caloriesDemand(int bmr, String a){
        double calories;
        double factor = 1;

            if(a=="Brak aktywności")
                factor =1.2;
            else if(a=="Niska aktywność")
                factor =1.375;
            else if (a=="Średnia aktywność")
                factor=1.55;
            else if (a=="Wysoka aktywność")
                factor =1.725;
            else if( a=="Ekstremalna aktywność")
                factor = 1.9;
            else
                throw new IllegalArgumentException("Niepoprawna wartość");
        calories= bmr*factor;
        return (int) calories;
    }


}
