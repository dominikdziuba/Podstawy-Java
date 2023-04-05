package LBM;

public class LBM implements ILBM {
    public double calculateLBM(double w, double h, String g){
        double lbm = 0;
        if(g=="Mężczyzna")
            lbm=1.1 * w - Math.pow(w/h, 2)*128;
        else if (g=="Kobieta")
            lbm = 1.07 * w - Math.pow(w/h, 2)*148;
        return Math.round(lbm*100)/100;
    }
}
