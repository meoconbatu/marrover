import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanhmi on 1/6/16.
 */
public class ReadInputTest {
//    private String inputFileName = "inputMarRover.txt";
    private ReadInput readInput = new ReadInput("inputMarRover.txt");

    @Test
    public void canReadPlateauInfo(){

        Plateau iPlateau = readInput.readPlateau();
        assertEqualsPlateau(new Plateau(new CoOrdinate(0,0), new CoOrdinate(4,6)), iPlateau);
    }
    @Test
    public void canReadTwoRoverInfos(){
        List<Rover> iRovers = readInput.readRoverInfos();
        List<Rover> expectedRovers = new ArrayList<Rover>();
        expectedRovers.add(new Rover(new CoOrdinate(1,2), "N"));
        expectedRovers.get(0).setInstruction("LMLMLMLMM");
        assertEqualsRover(expectedRovers.get(0), iRovers.get(0));
        expectedRovers.add(new Rover(new CoOrdinate(3,3), "E"));
        expectedRovers.get(1).setInstruction("MMRMMRMRRM");
        assertEqualsRover(expectedRovers.get(1), iRovers.get(1));
        assertEqualsPlateau(new Plateau(new CoOrdinate(0,0), new CoOrdinate(4,6)),Rover.plateau);
    }
    private void assertEqualsPlateau(Plateau expected, Plateau actual) {
        assertEqualsCoOrdinate(expected.getLowerLeft(), actual.getLowerLeft());
        assertEqualsCoOrdinate(expected.getUpperRight(), actual.getUpperRight());
    }
    private void assertEqualsRover(Rover expected, Rover actual) {
        Assert.assertEquals(expected.getCurrentOrientation(), actual.getCurrentOrientation());
        assertEqualsCoOrdinate(expected.getCurrentCoOrdinate(), actual.getCurrentCoOrdinate());
        Assert.assertEquals(expected.getInstruction(), actual.getInstruction());
    }

    private void assertEqualsCoOrdinate(CoOrdinate expected, CoOrdinate actual) {
        Assert.assertEquals(expected.getX(), actual.getX());
        Assert.assertEquals(expected.getY(), actual.getY());
    }
}