package travel.app.traveler.model;

import java.math.BigDecimal;

public interface Place {

    Tip getTip();

    String getName();

    Address getAddress();

    default BigDecimal getPrice(){
        return BigDecimal.ZERO;
    }
}
