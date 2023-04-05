package pl.retsuz.exchange;

import pl.retsuz.currency.ICurrency;

public class Exchange implements IExchange{
    //Oblicza otrzymaną ilość środka pieniężnego po podaniu wartości źródłowej, waluty źródłowej oraz waluty docelowej
    public double exchange(ICurrency src, ICurrency tgt, double amt) {
        double exchanged = (amt*src.getRate()/src.getFactor())/(tgt.getRate()/tgt.getFactor());
        return exchanged;
    }
}
