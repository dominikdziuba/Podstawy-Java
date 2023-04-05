package pl.retsuz.collections;

import pl.retsuz.model.entities.Currency;
import pl.retsuz.model.entities.ICurrency;

import java.util.List;
import java.util.ArrayList;

public class CurrencyDataCollection implements  IDataCollection {

    protected List<ICurrency> currencyList;

    public CurrencyDataCollection(){
        this.currencyList = new ArrayList<>();
    }

    @Override
    public String ToString() {
        String dataString=" ";
        for (ICurrency element : currencyList) {
           dataString=dataString+element.getName()+"\t";
           dataString=dataString+element.getCode()+"\t";
           dataString=dataString+element.getFactor()+"\t";
           dataString=dataString+element.getRate()+"\n";

        }

        return dataString.toString();
    }

    @Override
    public List<ICurrency> getCurrencyList() {

        return currencyList;
    }
    @Override
    public ICurrency getCurrencyByCode(ICurrency currency) {
        ICurrency searchedCurrency = new Currency();
        for (ICurrency element : currencyList)
            if (element.getCode().equals(currency.getCode()))
                searchedCurrency = element;

        return searchedCurrency;
    }
}