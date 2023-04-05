package integrals;

public class Trapezoid extends IntegralAlgorithm
{
    @Override
    public void calculateIntegral()
    {
        suma = 0;
        double krok = (b - a) / n;
        for (int i = 1; i < n; ++i)
            suma += function.getValue(a + i * krok);

        suma = (suma + (function.getValue(a) + function.getValue(b)) / 2);
        suma *= krok;
    }
}