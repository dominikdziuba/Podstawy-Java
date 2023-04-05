package BMI;
import  BMI.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class BMITest extends BMI {
    private IBMI b = new BMI();

    @Test
    public void testCalculateBMI() {
        IBMI b = new BMI();
        assertEquals(23,23,b.calculateBMI(177,72));
        assertEquals(27.8,27.8,b.calculateBMI(180,90));
        assertEquals(24.4,24.4,b.calculateBMI(150,55));

    }

    @Test
    public void testCheckingBMI() {
        IBMI b = new BMI();
        assertTrue(b.checkingBMI(14)=="Wygłodzenie");
        assertTrue(b.checkingBMI(16.5)=="Wychudzenie");
        assertTrue(b.checkingBMI(18)=="Niedowaga");
        assertTrue(b.checkingBMI(23)=="Waga prawidłowa");
        assertTrue(b.checkingBMI(27)=="Nadwaga");
        assertTrue(b.checkingBMI(33)=="Otyłość I stopnia");
        assertTrue(b.checkingBMI(37)=="Otyłość II stopnia");
        assertTrue(b.checkingBMI(50)=="Otyłość III stopnia");

    }
}