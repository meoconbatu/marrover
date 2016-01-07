import org.junit.Test;

import static org.junit.Assert.*;

public class PlateauTest {
    @Test
    public void canCreateAPlateauFromTwoCoOrdinates() {
        CoOrdinate lowerLeft = new CoOrdinate(0, 0);
        CoOrdinate upperRight = new CoOrdinate(5, 5);
        Plateau plateau = new Plateau(lowerLeft, upperRight);
    }
}