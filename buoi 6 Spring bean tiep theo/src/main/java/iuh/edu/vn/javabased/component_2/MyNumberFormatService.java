package iuh.edu.vn.javabased.component_2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyNumberFormatService {
    private NumberFormat numberFormat;

    public MyNumberFormatService(@Qualifier("myNumberFormat") NumberFormat numberFormat) {
        this.numberFormat = numberFormat;
    }

    /*public MyNumberFormatService(@Qualifier("oldFormater") NumberFormat numberFormat) {
        this.numberFormat = numberFormat;
    }*/


    public void setNumberFormat(NumberFormat numberFormat) {
        this.numberFormat = numberFormat;
    }

    public void doFormating(double number){
        System.out.println(numberFormat.format(number));
    }

}
