package pl.retsuz.model;

import pl.retsuz.model.entities.ICurrency;

public interface IExchange {
    public double exchange(ICurrency src, ICurrency tgt, double amt); //Oblicza otrzymaną ilość środka pieniężnego po podaniu wartości źródłowej, waluty źródłowej oraz waluty docelowej
}
