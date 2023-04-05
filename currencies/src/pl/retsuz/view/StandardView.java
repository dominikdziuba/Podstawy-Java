package pl.retsuz.view;

import pl.retsuz.collections.IDataCollection;
import pl.retsuz.currency.Currency;
import pl.retsuz.currency.ICurrency;
import pl.retsuz.exchange.IExchange;

import java.util.Scanner;

public class StandardView implements ICurrencyView{
    IExchange ex;
    IDataCollection collectedData;


    @Override
    public void setExchange(IExchange exchange) { //Ustawia referencję do obiektu typu implementującego IExchange
        this.ex = exchange;
    }

    @Override
    public void setDataCollection(IDataCollection collection){
        this.collectedData = collection;
    }

    @Override
    public void ViewAll(IDataCollection coll){
        System.out.println(coll.ToString());
    }

    @Override
    public ICurrency StringToCurrency(String code){
        Currency SearchedCurrency = new Currency();
        SearchedCurrency.setCode(code);
        return collectedData.getCurrencyByCode(SearchedCurrency);
    }

    @Override
    public ICurrency ChooseCurrency(String label){
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj kod waluty, "+label);
        String code = in.nextLine();
        return StringToCurrency(code);
    }

    @Override
    public void exchange(){
        ICurrency BeforeExchange = ChooseCurrency("ktora posiadasz");
        System.out.println("Ile jej posiadasz?");
        Scanner in = new Scanner(System.in);
        String MoneyStr = in.nextLine();
        double Money = Double.parseDouble(MoneyStr);
        ICurrency AfterExchange = ChooseCurrency("ktora kupujesz");
        double Result = this.ex.exchange(BeforeExchange,AfterExchange,Money);
        System.out.println("Orzymujesz " + Result + " " + AfterExchange.getName());
    }

    @Override
    public void menu(){
        System.out.println("Co chcesz zrobic?\n 0 - Skoncz\n 1 - Wymien walute\n 2 - Wyswietl kursy\n");
        Scanner in = new Scanner(System.in);
        int i_int = in.nextInt();
        if (i_int == 2)
        {
            ViewAll(collectedData);
            System.out.println("Co chcesz zrobic?\n 0 - Skoncz\n 1 - Wymien walute\n");
            i_int = in.nextInt();
            if (i_int == 1) {
                exchange();
            }
            else if(i_int==0)
                System.out.println("KONIEC");
            else {
                System.out.println("Nie udalo sie. Podales zla cyfre.");
            }
        }
        else if(i_int==1){
            exchange();
        }
        else if(i_int==0)
            System.out.println("KONIEC");
        else {
            System.out.println("Nie udalo sie. Podales zla cyfre.");
        }
    }
}
