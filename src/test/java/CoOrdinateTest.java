import org.junit.Assert;
import org.junit.Test;

public class CoOrdinateTest {
    @Test
    public void canCreateACoOrdinate() {
        CoOrdinate coOrdinate = new CoOrdinate(2, 3);
    }

    @Test
    public void canGetX() {
        CoOrdinate coOrdinate = new CoOrdinate(2, 3);
        Assert.assertEquals(2, coOrdinate.getX());
    }

    @Test
    public void canGetY() {
        CoOrdinate coOrdinate = new CoOrdinate(2, 3);
        Assert.assertEquals(3, coOrdinate.getY());
    }
}