package intive.fdv.rental;

import java.math.BigDecimal;

public class RentalType {

    private RentalFrequency rentalFrequency;
    private BigDecimal price;

    public RentalType(RentalFrequency rentalFrequency, BigDecimal price) {
        this.rentalFrequency = rentalFrequency;
        this.price = price;
    }

    public RentalFrequency getRentalFrequency() {
        return rentalFrequency;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
