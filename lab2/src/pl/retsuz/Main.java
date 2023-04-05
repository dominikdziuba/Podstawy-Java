package pl.retsuz;

import functions.examples.builder.ExampleBuilder;
import functions.examples.cosineexample.CosineExampleBuilder;
import functions.Function;
import integrals.IntegralAlgorithm;
import integrals.MonteCarlo;
import integrals.Trapezoid;
import view.IntegralConsoleView;
import view.IntegralView;


public class Main
{

    protected static ExampleBuilder functionBuilder;
    protected static Function givenExample;
    protected static IntegralAlgorithm algorithm;
    protected static IntegralAlgorithm trapezoidAlgorithm;
    protected static IntegralView view;

    public static void main(String[] args)
    {
        view = new IntegralConsoleView();
        double a = 0;
        double b = Math.PI / 2;
        int n = 9999999;

        functionBuilder = new CosineExampleBuilder();
        givenExample = functionBuilder.build();
        algorithm = new MonteCarlo();

        algorithm.setFunction(givenExample);
        algorithm.setA(a);
        algorithm.setB(b);
        algorithm.setN(n);
        algorithm.calculateIntegral();

        double monteIntegral = algorithm.getIntegral();
        double exactIntegral = givenExample.getExactIntegralValue(b) - givenExample.getExactIntegralValue(a);
        double monteError = Math.abs(monteIntegral - exactIntegral);

        System.out.println("Numeryczna\t" + monteIntegral);
        System.out.println("Dokładna\t" + exactIntegral);
        System.out.println("Błąd\t\t" + monteError);
        System.out.println("\n\n");

        trapezoidAlgorithm = new Trapezoid();
        trapezoidAlgorithm = view.Init();
        trapezoidAlgorithm.setFunction(givenExample);
        trapezoidAlgorithm.calculateIntegral();
        double trapezoidIntegral = trapezoidAlgorithm.getIntegral();
        view.View(trapezoidIntegral, exactIntegral);
    }
}
