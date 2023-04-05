package pl.retsuz.conversions;

import pl.retsuz.conversions.arabic.Arabic;

public class Converter {

    public String convert(GenericNumeralSystem from, GenericNumeralSystem to, String value){
        int result = from.toArabic(value);
        if(to == new Arabic())
            return String.valueOf(result);
        else
            return to.fromArabic(result);
    }
}
