package pl.retsuz;

import matrix.IMatrix;
import matrix.generators.DefaultGenerator;

import java.util.Date;

public class Main {
    static IMatrix a;
    static IMatrix b;
    static IMatrix c;
    static IMatrix d;
    public static void main(String[] args) throws Exception {

        int n=3000,m=3000;
        System.out.println("Generuję macierze...");
        a= DefaultGenerator.generateRandomMatrix(m,n,0,3);
        b= DefaultGenerator.generateRandomMatrix(m,n,0,3);
        IMatrix.checkMatrix(a, b);
        System.out.println("Mnożę macierze klasycznie...");
        Date start = new Date();
        c=IMatrix.multiply(a,b);
        Date end = new Date();
        System.out.println("Czas mnożenia w milisekundach: " + (end.getTime() - start.getTime()));
        System.out.println("Mnożę macierze wielowątkowo: ");
        start = new Date();
        d= IMatrix.multiplyWithThreads(a,b);
        end = new Date();
        System.out.println("Czas mnożenia w milisekundach: " + (end.getTime() - start.getTime()));
    }
}
