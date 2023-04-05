package pl.retsuz.conversions.urnfield;

import pl.retsuz.conversions.GenericNumeralSystem;

public class Urnfield implements GenericNumeralSystem {
    @Override
    public String fromArabic(int val) {
        String urnfield="";
        int i = 0;
        if (val > 0 || val <= 29) {
            while (i < val % 5) {
                urnfield += "/";
                val--;
            }
            i = 0;
            while (i < val / 5) {
                urnfield += "\\";
                val -= 5;
            }
            return urnfield;
        }
        else throw new UnsupportedOperationException();
    }

    @Override
    public int toArabic(String val) {
        int arabic=0;
        int i=0;
        while (i<val.length())
        {
            if(val.charAt(i)=='/')
                arabic++;
            else
                arabic+=5;
            i++;
        }

        return arabic;
    }
}
