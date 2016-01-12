import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanhmi on 1/6/16.
 */
public class FileHelperTest {
    private FileHelper iFileHelper = new FileHelper("inputMarRover.txt");
    private FileHelper oFileHelper = new FileHelper("outputMarRover.txt");

    @Test
    public void canReadFirstLine() {
        String firstLine = iFileHelper.readLineAtIndex(1);
        Assert.assertEquals("5 5", firstLine);
    }

    @Test
    public void canReadSecondLine() {
        String seconddLine = iFileHelper.readLineAtIndex(2);
        Assert.assertEquals("1 2 N", seconddLine);
    }

    @Test
    public void canWriteContent() {
        String content = "1 3 N\n5 1 E";
        oFileHelper.write(content);
        String firstLine = oFileHelper.readLineAtIndex(1);
        String secondLine = oFileHelper.readLineAtIndex(2);
        Assert.assertEquals("1 3 N", firstLine);
        Assert.assertEquals("5 1 E", secondLine);

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