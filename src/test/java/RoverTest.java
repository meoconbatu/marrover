import org.junit.Assert;
import org.junit.Test;

public class RoverTest {

    @Test
    public void canMoveToEast() {
        Rover rover = createRover(5, 5, "E");

        rover.executeCommand('M');

        assertEqualsCoOrdinate(new CoOrdinate(6, 5), rover.getCurrentCoOrinate());
    }

    @Test
    public void canMoveToWest() {
        Rover rover = createRover(5, 5, "W");

        rover.executeCommand('M');

        assertEqualsCoOrdinate(new CoOrdinate(4, 5), rover.getCurrentCoOrinate());
    }

    @Test
    public void canMoveToNorth() {
        Rover rover = createRover(5, 5, "N");

        rover.executeCommand('M');

        assertEqualsCoOrdinate(new CoOrdinate(5, 6), rover.getCurrentCoOrinate());
    }

    @Test
    public void canMoveToSouth() {
        Rover rover = createRover(5, 5, "S");

        rover.executeCommand('M');

        assertEqualsCoOrdinate(new CoOrdinate(5, 4), rover.getCurrentCoOrinate());
    }

    private Rover createRover(int x, int y, String orientation) {
        CoOrdinate startingOrdinate = new CoOrdinate(x, y);

        return new Rover(startingOrdinate, orientation);
    }

    private void assertEqualsCoOrdinate(CoOrdinate expected, CoOrdinate actual) {
        Assert.assertEquals(expected.getX(), actual.getX());
        Assert.assertEquals(expected.getY(), actual.getY());
    }
}