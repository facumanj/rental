package intive.fdv.rental;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class SingleRentalTest {

    SingleRental singleRental;

    @Before
    public void setup() {
        singleRental = new SingleRental();
    }

    @Test
    public void chargingTest() {
        RentalType rentalType = new RentalType(RentalFrequency.DAY, new BigDecimal(20));

        singleRental.setRentalType(rentalType);
        singleRental.setPeriod(2);

        BigDecimal expected = new BigDecimal(40);

        assertEquals(expected, singleRental.charging());
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void chargingWithPeriodZeroTest() {
        RentalType rentalType = new RentalType(RentalFrequency.HOUR, new BigDecimal(5));

        singleRental.setRentalType(rentalType);
        singleRental.setPeriod(0);

        exception.expect(RuntimeException.class);
        exception.expectMessage("Period cannot be 0");

        singleRental.charging();
    }
}
