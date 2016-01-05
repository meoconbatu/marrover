import org.junit.Assert;
import org.junit.Test;

public class RoverTest {
    @Test
    public void canMoveToEast() {
        Rover rover = createRover(3, 5, "E");

        rover.executeCommand('M');

        assertEqualsCoOrdinate(new CoOrdinate(4, 5), rover.getCurrentCoOrinate());
    }

    @Test
    public void canMoveToWest() {
        Rover rover = createRover(5, 5, "W");

        rover.executeCommand('M');

        assertEqualsCoOrdinate(new CoOrdinate(4, 5), rover.getCurrentCoOrinate());
    }

    @Test
    public void canMoveToNorth() {
        Rover rover = createRover(5, 4, "N");

        rover.executeCommand('M');

        assertEqualsCoOrdinate(new CoOrdinate(5, 5), rover.getCurrentCoOrinate());
    }

    @Test
    public void canMoveToSouth() {
        Rover rover = createRover(5, 5, "S");

        rover.executeCommand('M');

        assertEqualsCoOrdinate(new CoOrdinate(5, 4), rover.getCurrentCoOrinate());
    }

    @Test
    public void cantMoveWhenTouchNorthBorder() {
        Rover rover = createRover(4, 5, "N");
        rover.executeCommand('M');
        assertEqualsCoOrdinate(new CoOrdinate(4, 5), rover.getCurrentCoOrinate());
    }
    @Test
    public void cantMoveWhenTouchWestBorder() {
        Rover rover = createRover(0, 3, "W");
        rover.executeCommand('M');
        assertEqualsCoOrdinate(new CoOrdinate(0, 3), rover.getCurrentCoOrinate());
    }
    @Test
    public void cantMoveWhenTouchEastBorder() {
        Rover rover = createRover(5, 3, "E");
        rover.executeCommand('M');
        assertEqualsCoOrdinate(new CoOrdinate(5, 3), rover.getCurrentCoOrinate());
    }
    @Test
    public void cantMoveWhenTouchSouthBorder() {
        Rover rover = createRover(2, 0, "S");
        rover.executeCommand('M');
        assertEqualsCoOrdinate(new CoOrdinate(2, 0), rover.getCurrentCoOrinate());
    }
    private Rover createRover(int x, int y, String orientation) {
        CoOrdinate startingOrdinate = new CoOrdinate(x, y);
        Rover.plateau = new Plateau(new CoOrdinate(0,0), new CoOrdinate(5,5));
        return new Rover(startingOrdinate, orientation);
    }

    private void assertEqualsCoOrdinate(CoOrdinate expected, CoOrdinate actual) {
        Assert.assertEquals(expected.getX(), actual.getX());
        Assert.assertEquals(expected.getY(), actual.getY());
    }
}