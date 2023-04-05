package pl.retsuz.model;

import pl.retsuz.model.entities.ICurrency;

public class Exchange implements IExchange{
    @Override
    public double exchange(ICurrency src, ICurrency tgt, double amt){
        double exchanged = (amt*src.getRate()/src.getFactor())/(tgt.getRate()/tgt.getFactor());
        return exchanged;
    }
}
