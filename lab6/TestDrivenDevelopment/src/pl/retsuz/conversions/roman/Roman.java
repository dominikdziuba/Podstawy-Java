package pl.retsuz.conversions.roman;

import pl.retsuz.conversions.GenericNumeralSystem;
import java.util.Locale;
public class Roman implements GenericNumeralSystem {

    @Override
    public String fromArabic(int val) {
        String roman = "";
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] unities = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        if (val > 0 || val <= 3999) {
            roman += thousands[val / 1000];
            roman += hundreds[(val % 1000) / 100];
            roman += tens[(val % 100) / 10];
            roman += unities[val % 10];
            return roman;
        }
        else
            throw new UnsupportedOperationException();

    }


    @Override
    public int toArabic(String val) {
        int arabic = 0;
        int i = 0;
        if (val.length() > 3 && val.charAt(3) == 'M')
            throw new UnsupportedOperationException();
        else {
            while (i < val.length() - 1) {
                if (romanSwitch(val.charAt(i)) >= romanSwitch(val.charAt(i + 1))) {
                    arabic += romanSwitch(val.charAt(i));
                    i++;
                } else {
                    arabic += romanSwitch(val.charAt(i + 1)) - romanSwitch(val.charAt(i));
                    i += 2;

                }
            }
            if (i == val.length() - 1)
                arabic += romanSwitch(val.charAt(i));
            return arabic;
            //
        }
    }
    private int romanSwitch(char romanNumber){
        switch(romanNumber){
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
        }
        return 0;
    }
}
