package integrals;

import java.util.Random;

public class MonteCarlo extends IntegralAlgorithm
{

    private Random rand;

    public MonteCarlo()
    {
        this.rand = new Random();
        this.suma = 0;
    }

    private double randomX()
    {
        return a + (b - a) * rand.nextDouble();
    }

    @Override
    public void calculateIntegral()
    {
        double m = (double) n;
        int i;
        double x;
        for (i = 0; i < n; i++)
        {
            x = randomX();
            suma += function.getValue(x) / m;
        }
        suma *= b - a;
    }
}
