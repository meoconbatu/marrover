import org.junit.Assert;
import org.junit.Test;

public class RoverTest {
    @Test
    public void canMoveToEast() {
        Rover rover = createRover(3, 5, "E");

        rover.executeCommand('M');

        assertEqualsCoOrdinate(new CoOrdinate(4, 5), rover.getCurrentCoOrdinate());
    }

    @Test
    public void canMoveToWest() {
        Rover rover = createRover(5, 5, "W");

        rover.executeCommand('M');

        assertEqualsCoOrdinate(new CoOrdinate(4, 5), rover.getCurrentCoOrdinate());
    }

    @Test
    public void canMoveToNorth() {
        Rover rover = createRover(5, 4, "N");

        rover.executeCommand('M');

        assertEqualsCoOrdinate(new CoOrdinate(5, 5), rover.getCurrentCoOrdinate());
    }

    @Test
    public void canMoveToSouth() {
        Rover rover = createRover(5, 5, "S");

        rover.executeCommand('M');

        assertEqualsCoOrdinate(new CoOrdinate(5, 4), rover.getCurrentCoOrdinate());
    }

    @Test
    public void cantMoveWhenTouchNorthBorder() {
        Rover rover = createRover(4, 5, "N");
        rover.executeCommand('M');
        assertEqualsCoOrdinate(new CoOrdinate(4, 5), rover.getCurrentCoOrdinate());
    }
    @Test
    public void cantMoveWhenTouchWestBorder() {
        Rover rover = createRover(0, 3, "W");
        rover.executeCommand('M');
        assertEqualsCoOrdinate(new CoOrdinate(0, 3), rover.getCurrentCoOrdinate());
    }
    @Test
    public void cantMoveWhenTouchEastBorder() {
        Rover rover = createRover(5, 3, "E");
        rover.executeCommand('M');
        assertEqualsCoOrdinate(new CoOrdinate(5, 3), rover.getCurrentCoOrdinate());
    }
    @Test
    public void cantMoveWhenTouchSouthBorder() {
        Rover rover = createRover(2, 0, "S");
        rover.executeCommand('M');
        assertEqualsCoOrdinate(new CoOrdinate(2, 0), rover.getCurrentCoOrdinate());
    }
    @Test
    public void canTurnLeftFromSouth() {
        Rover rover = createRover(5, 5, "S");
        rover.executeCommand('L');
        Assert.assertEquals("E", rover.getCurrentOrientation());
    }
    @Test
    public void canTurnLeftFromNorth() {
        Rover rover = createRover(5, 5, "N");
        rover.executeCommand('L');
        Assert.assertEquals("W", rover.getCurrentOrientation());
    }
    @Test
    public void canTurnLeftFromEast() {
        Rover rover = createRover(5, 5, "E");
        rover.executeCommand('L');
        Assert.assertEquals("N", rover.getCurrentOrientation());
    }
    @Test
    public void canTurnLeftFromWest() {
        Rover rover = createRover(5, 5, "W");
        rover.executeCommand('L');
        Assert.assertEquals("S", rover.getCurrentOrientation());
    }
    @Test
    public void canTurnRightFromSouth() {
        Rover rover = createRover(5, 5, "S");
        rover.executeCommand('R');
        Assert.assertEquals("W", rover.getCurrentOrientation());
    }
    @Test
    public void canTurnRightFromNorth() {
        Rover rover = createRover(5, 5, "N");
        rover.executeCommand('R');
        Assert.assertEquals("E", rover.getCurrentOrientation());
    }
    @Test
    public void canTurnRightFromEast() {
        Rover rover = createRover(5, 5, "E");
        rover.executeCommand('R');
        Assert.assertEquals("S", rover.getCurrentOrientation());
    }
    @Test
    public void canTurnRightFromWest() {
        Rover rover = createRover(5, 5, "W");
        rover.executeCommand('R');
        Assert.assertEquals("N", rover.getCurrentOrientation());
    }
    @Test
    public void canfollowInstruction() {
        Rover rover = createRover(1, 2, "N");
        rover.setInstruction("LMLMLMLMM");
        rover.executeInstruction();
        assertEqualsRover(new Rover(new CoOrdinate(1,3), "N"), rover);
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
    private void assertEqualsRover(Rover expected, Rover actual) {
        Assert.assertEquals(expected.getCurrentOrientation(), actual.getCurrentOrientation());
        assertEqualsCoOrdinate(expected.getCurrentCoOrdinate(), actual.getCurrentCoOrdinate());
    }
}