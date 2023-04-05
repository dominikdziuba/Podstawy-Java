package pl.retsuz.view;

import pl.retsuz.conversions.Converter;
import pl.retsuz.conversions.GenericNumeralSystem;
import pl.retsuz.conversions.arabic.Arabic;
import pl.retsuz.conversions.roman.Roman;
import pl.retsuz.conversions.urnfield.Urnfield;

import java.util.Scanner;

public class View implements IView {
    public void menu(){
        System.out.println("Z jakiego systemu konwertujemy?\n1 - arabski\n2 - rzymski\n3 - prastary");
        Scanner sc = new Scanner(System.in);
        int from = sc.nextInt();

        System.out.println("Na jaki system konwertujemy?\n1 - arabski\n2 - rzymski\n3 - prastary");
        int to = sc.nextInt();

        System.out.print("Podaj wartosc:  ");
        String value = sc.next();
        convert(from, to, value);

    }
    public void convert(int from, int to, String value){
        GenericNumeralSystem a = new Arabic();
        GenericNumeralSystem b = new Arabic();
        if(from == 2)
            a = new Roman();
        else if(from == 3)
            a = new Urnfield();

        if(to == 2)
            b = new Roman();
        else if(to == 3)
            b = new Urnfield();

        Converter converter = new Converter();
        System.out.println("Zwaracana wartosc: " + converter.convert(a,b,value));

    }
}
