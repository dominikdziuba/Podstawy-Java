package view;

import integrals.IntegralAlgorithm;
import integrals.Trapezoid;

import java.util.Scanner;

public class IntegralConsoleView implements IntegralView {

    @Override
    public void View(double trapIntegral, double exactIntegral)
    {
        double trapError = Math.abs(trapIntegral - exactIntegral);
        System.out.println("Numeryczna\t" + trapIntegral);
        System.out.println("Dokładna\t" + exactIntegral);
        System.out.println("Błąd\t\t" + trapError);
    }

    private Scanner sc = new Scanner(System.in);
    IntegralAlgorithm tmp=new Trapezoid();

    @Override
    public IntegralAlgorithm Init()
    {
        double input;
        System.out.print("Początek: ");
        input = sc.nextDouble();
        tmp.setA(input);

        System.out.print("Koniec ");
        input = sc.nextDouble();
        tmp.setB(input);

        int tmpInt;
        System.out.print("Liczba trapezów: ");
        tmpInt = sc.nextInt();
        tmp.setN(tmpInt);

        return tmp;
    }


}
