import org.junit.Assert;
import org.junit.Test;

public class RoverTest {
    @Test
    public void canMoveToEast() {
        Rover rover = new Rover(3, 5, "E");
        rover.setPlateau(new Plateau(5, 5));
        rover.executeCommand('M');
        assertEqualsCoOrdinate(new CoOrdinate(4, 5), rover.getCurrentCoOrdinate());
    }

    @Test
    public void canMoveToWest() {
        Rover rover = new Rover(5, 5, "W");
        rover.setPlateau(new Plateau(5, 5));
        rover.executeCommand('M');
        assertEqualsCoOrdinate(new CoOrdinate(4, 5), rover.getCurrentCoOrdinate());
    }

    @Test
    public void canMoveToNorth() {
        Rover rover = new Rover(5, 4, "N");
        rover.setPlateau(new Plateau(5, 5));
        rover.executeCommand('M');
        assertEqualsCoOrdinate(new CoOrdinate(5, 5), rover.getCurrentCoOrdinate());
    }

    @Test
    public void canMoveToSouth() {
        Rover rover = new Rover(5, 5, "S");
        rover.setPlateau(new Plateau(5, 5));
        rover.executeCommand('M');
        assertEqualsCoOrdinate(new CoOrdinate(5, 4), rover.getCurrentCoOrdinate());
    }

    @Test
    public void cantMoveWhenTouchNorthBorder() {
        Rover rover = new Rover(4, 5, "N");
        rover.setPlateau(new Plateau(5, 5));
        rover.executeCommand('M');
        assertEqualsCoOrdinate(new CoOrdinate(4, 5), rover.getCurrentCoOrdinate());
    }

    @Test
    public void cantMoveWhenTouchWestBorder() {
        Rover rover = new Rover(0, 3, "W");
        rover.setPlateau(new Plateau(5, 5));
        rover.executeCommand('M');
        assertEqualsCoOrdinate(new CoOrdinate(0, 3), rover.getCurrentCoOrdinate());
    }

    @Test
    public void cantMoveWhenTouchEastBorder() {
        Rover rover = new Rover(5, 3, "E");
        rover.setPlateau(new Plateau(5, 5));
        rover.executeCommand('M');
        assertEqualsCoOrdinate(new CoOrdinate(5, 3), rover.getCurrentCoOrdinate());
    }

    @Test
    public void cantMoveWhenTouchSouthBorder() {
        Rover rover = new Rover(2, 0, "S");
        rover.setPlateau(new Plateau(5, 5));
        rover.executeCommand('M');
        assertEqualsCoOrdinate(new CoOrdinate(2, 0), rover.getCurrentCoOrdinate());
    }

    @Test
    public void canTurnLeftFromSouth() {
        Rover rover = new Rover(5, 5, "S");
        rover.setPlateau(new Plateau(5, 5));
        rover.executeCommand('L');
        Assert.assertEquals("E", rover.getCurrentOrientation());
    }

    @Test
    public void canTurnLeftFromNorth() {
        Rover rover = new Rover(5, 5, "N");
        rover.setPlateau(new Plateau(5, 5));
        rover.executeCommand('L');
        Assert.assertEquals("W", rover.getCurrentOrientation());
    }

    @Test
    public void canTurnLeftFromEast() {
        Rover rover = new Rover(5, 5, "E");
        rover.setPlateau(new Plateau(5, 5));
        rover.executeCommand('L');
        Assert.assertEquals("N", rover.getCurrentOrientation());
    }

    @Test
    public void canTurnLeftFromWest() {
        Rover rover = new Rover(5, 5, "W");
        rover.setPlateau(new Plateau(5, 5));
        rover.executeCommand('L');
        Assert.assertEquals("S", rover.getCurrentOrientation());
    }

    @Test
    public void canTurnRightFromSouth() {
        Rover rover = new Rover(5, 5, "S");
        rover.setPlateau(new Plateau(5, 5));
        rover.executeCommand('R');
        Assert.assertEquals("W", rover.getCurrentOrientation());
    }

    @Test
    public void canTurnRightFromNorth() {
        Rover rover = new Rover(5, 5, "N");
        rover.setPlateau(new Plateau(5, 5));
        rover.executeCommand('R');
        Assert.assertEquals("E", rover.getCurrentOrientation());
    }

    @Test
    public void canTurnRightFromEast() {
        Rover rover = new Rover(5, 5, "E");
        rover.setPlateau(new Plateau(5, 5));
        rover.executeCommand('R');
        Assert.assertEquals("S", rover.getCurrentOrientation());
    }

    @Test
    public void canTurnRightFromWest() {
        Rover rover = new Rover(5, 5, "W");
        rover.setPlateau(new Plateau(5, 5));
        rover.executeCommand('R');
        Assert.assertEquals("N", rover.getCurrentOrientation());
    }

    @Test
    public void canfollowInstruction() {
        Rover rover = new Rover(1, 2, "N");
        rover.setPlateau(new Plateau(5, 5));
        rover.setInstruction("LMLMLMLMM");
        rover.executeInstruction();
        assertEqualsRover(new Rover(new CoOrdinate(1, 3), "N"), rover);
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