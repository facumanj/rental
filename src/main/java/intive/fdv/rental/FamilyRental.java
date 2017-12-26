package intive.fdv.rental;

import java.math.BigDecimal;
import java.util.List;

public class FamilyRental implements Rental {

    private static final BigDecimal DISCOUNT = BigDecimal.valueOf(0.3);
    private static final int RENTALS_MIN = 3;
    private static final int RENTALS_MAX = 5;

    private List<Rental> rentals;

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        if( rentals.size() < RENTALS_MIN || rentals.size() > RENTALS_MAX)
          throw new RuntimeException("Family rental must include between " + RENTALS_MIN + " and " + RENTALS_MAX + " rentals.");

        this.rentals = rentals;
    }

    public BigDecimal charging() {
        BigDecimal price = new BigDecimal(0);

        for(Rental rental : rentals) {
            price = price.add( rental.charging());
        }

        return price.subtract(price.multiply( DISCOUNT));
    }
}
