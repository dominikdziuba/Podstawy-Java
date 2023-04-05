package BMR;

import BMI.BMI;
import org.junit.Test;

import static org.junit.Assert.*;

public class BMRTest extends BMI {

    @Test
    public void calculateBMR() {
        IBMR r = new BMR();
        assertEquals(1245,1245,r.calculateBMR(55,150,50,"Mężczyzna"));
        assertEquals(1516,1516,r.calculateBMR(72,177,30,"Kobieta"));
        assertEquals(1930,1930,r.calculateBMR(90,180,20,"Mężczyzna"));
    }

    @Test
    public void caloriesDemand() {
        IBMR r = new BMR();
        assertEquals(2316,2316, r.caloriesDemand(1930,"Brak aktywności"));
        assertEquals(2349,2349,r.caloriesDemand(1516,"Średnia aktywność"));
        assertEquals(2365,2365, r.caloriesDemand(1245,"Ekstremalna aktywność"));
    }
}