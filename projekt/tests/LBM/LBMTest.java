package LBM;

import BMI.BMI;
import org.junit.Test;

import static org.junit.Assert.*;

public class LBMTest extends BMI {

    @Test
    public void calculateLBM() {
         ILBM l = new LBM();
         assertEquals(43,43,l.calculateLBM(55,150,"Mężczyzna"));
         assertEquals(52,52,l.calculateLBM(72,177,"Kobieta"));
         assertEquals(67,67,l.calculateLBM(180,90,"Mężczyzna"));

    }
}