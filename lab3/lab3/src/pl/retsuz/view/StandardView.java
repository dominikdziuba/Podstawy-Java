package pl.retsuz.view;

import pl.retsuz.collections.IDataCollection;
import pl.retsuz.currency.Currency;
import pl.retsuz.currency.ICurrency;
import pl.retsuz.exchange.IExchange;


import java.util.Scanner;

public class StandardView implements ICurrencyView {

    IExchange ex;
    IDataCollection data;
    Scanner sc = new Scanner(System.in);

    @Override
    public void setExchange(IExchange exchange) {
        this.ex = exchange;
    }

    @Override
    public void setDataCollection(IDataCollection collection) {
        this.data = collection;
    }

    public void ViewAll(IDataCollection coll) {
        System.out.println(coll.ToString());
    }

    @Override
    public ICurrency StringToCurrency(String code) {
        Currency chosenCurrency = new Currency();
        chosenCurrency.setCode(code);
        return data.getCurrencyByCode(chosenCurrency);
    }

    @Override
    public ICurrency ChooseCurrency(String label) {
        System.out.println("Podaj kod waluty, " + label);
        String code = sc.nextLine();
        return StringToCurrency(code);
    }


    @Override
    public void exchange() {
        ICurrency previousCurrency = ChooseCurrency("ktora posiadasz");
        System.out.println("Ile chcesz jej wymienić?");
        String cashString = sc.nextLine();
        double cash = Double.parseDouble(cashString);
        ICurrency newCurrency = ChooseCurrency("na którą chcesz wymienić");
        double outcome = this.ex.exchange(previousCurrency, newCurrency, cash);
        System.out.println("Posiadasz " + outcome + " " + newCurrency.getName());
    }


    @Override
    public void menu() {
       System.out.println("0 - Wyświetl kursy\n 1 - Wymień walutę\n 2 - Zakończ\n Wybierz jedną z powyższych opcji: ");
       Scanner sc = new Scanner(System.in);
        int choice_int = sc.nextInt();
        switch (choice_int) {
            case 0:
                ViewAll(data);
                System.out.println("1 - Wymień walutę\n 2 - Zakończ\nWybierz jedną z powyższych opcji: ");
                choice_int = sc.nextInt();
                switch (choice_int) {
                    case 1:
                        exchange();
                        break;
                    case 2:
                        System.out.println("Dziękujemy za skorzystanie z naszej aplikacji.");
                        break;
                    default:
                        System.out.println("Nieprawidłowy wybór.");
                        break;
                }
                break;
            case 1:
                exchange();
                break;
            case 2:
                System.out.println("Dziękujemy za skorzystanie z naszej aplikacji.");
                break;
            default:
                System.out.println("Nieprawidłowy wybór.");
                break;
        }
    }
}
