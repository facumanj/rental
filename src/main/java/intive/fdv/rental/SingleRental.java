package intive.fdv.rental;

import java.math.BigDecimal;

public class SingleRental implements Rental {
    /** Period is expressed in hours, days or weeks, depending on the the RentalType chosen **/
    private int period;
    private RentalType rentalType;

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public RentalType getRentalType() {
        return rentalType;
    }

    public void setRentalType(RentalType rentalType) {
        this.rentalType = rentalType;
    }

    public SingleRental() {}

    public SingleRental(int period, RentalType rentalType) {
        this.period = period;
        this.rentalType = rentalType;
    }

    public BigDecimal charging() {
        if(period==0)
            throw new RuntimeException("Period cannot be 0");

        return rentalType.getPrice().multiply( new BigDecimal(period) );
    }
}
