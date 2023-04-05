package pl.retsuz.collections;

import pl.retsuz.currency.Currency;
import pl.retsuz.currency.ICurrency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyDataCollection implements IDataCollection{
    List <ICurrency> currencies;

    public CurrencyDataCollection(){
        this.currencies = new ArrayList<>();
    }

    @Override
    public List<ICurrency> getCurrencyList(){
        return currencies;
    }

    @Override
    public String ToString(){
        StringBuilder AllCurrenciesDataString = new StringBuilder();
        for(ICurrency Single: currencies){
            AllCurrenciesDataString.append(Single.getName() + "\t");
            AllCurrenciesDataString.append(Single.getCode() + "\t");
            AllCurrenciesDataString.append(Single.getFactor() + "\t");
            AllCurrenciesDataString.append(Single.getRate() + "\n");
        }
        return AllCurrenciesDataString.toString();
    }

    @Override
    public ICurrency getCurrencyByCode(ICurrency currency){
        ICurrency NeededCurrency = new Currency();
        for(ICurrency SingleCurrency : currencies)
            if(SingleCurrency.getCode().equals(currency.getCode()))
                NeededCurrency = SingleCurrency;
        return NeededCurrency;
    }
}
