import calculate.Calculate;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    @Test
    public void test(){
        assertEquals(45.2, Calculate.calculation(Calculate.shuntingYardAlgorithm("(4+5.2*3)*2+6")));
        assertEquals(14, Calculate.calculation(Calculate.shuntingYardAlgorithm("74*6-5*(89-3)")));
        assertEquals(8, Calculate.calculation(Calculate.shuntingYardAlgorithm("2-(3-5)*3")));
        assertEquals(1.6, Calculate.calculation(Calculate.shuntingYardAlgorithm("0.2*(5+9-6)")));
        assertEquals(-133, Calculate.calculation(Calculate.shuntingYardAlgorithm("5*((3-7)*2-3*(5+1))-3")));

    }

}
