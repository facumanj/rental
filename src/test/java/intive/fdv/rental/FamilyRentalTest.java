package intive.fdv.rental;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FamilyRentalTest {

    FamilyRental familyRental;
    Rental r1, r2, r3, r4;

    @Before
    public void setup() {
        familyRental = new FamilyRental();

        r1 = new SingleRental(2, new RentalType(RentalFrequency.DAY, new BigDecimal(20)));
        r2 = new SingleRental(4, new RentalType(RentalFrequency.HOUR, new BigDecimal(5)));
        r3 = new SingleRental(1, new RentalType(RentalFrequency.WEEK, new BigDecimal(60)));
        r4 = new SingleRental(3, new RentalType(RentalFrequency.DAY, new BigDecimal(20)));
    }

    @Test
    public void chargingTest() {
        familyRental.setRentals( Arrays.asList(r1, r2, r3, r4));

        BigDecimal expected = new BigDecimal(180).multiply( BigDecimal.valueOf(0.7));

        assertEquals( expected, familyRental.charging());
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void chargingLessThan3Rentals() {
        exception.expect(RuntimeException.class);
        exception.expectMessage("Family rental must include between 3 and 5 rentals.");

        familyRental.setRentals( Arrays.asList(r1, r2));
    }

    @Test
    public void chargingMoreThan5Rentals(){
        exception.expect(RuntimeException.class);
        exception.expectMessage("Family rental must include between 3 and 5 rentals.");

        familyRental.setRentals( Arrays.asList(r1, r2, r3, r4, r1, r2));
    }
}
