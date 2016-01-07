import java.util.List;

public class Plateau {
    private final CoOrdinate lowerLeft;
    private final CoOrdinate upperRight;

    public Plateau(CoOrdinate lowerLeft, CoOrdinate upperRight) {
        this.lowerLeft = lowerLeft;
        this.upperRight = upperRight;
    }
    public CoOrdinate getUpperRight(){
        return upperRight;
    }
    public CoOrdinate getLowerLeft() {
        return lowerLeft;
    }
    public static void main(String [] args)
    {
        String result = "";
        FileHelper fileHelper = new FileHelper("inputMarRover.txt");
        List<Rover> iRovers = fileHelper.readRoverInfos();
        for (int i = 0; i < iRovers.size(); i++) {
            iRovers.get(i).executeInstruction();
            result += iRovers.get(i).getCurrentCoOrdinate().getX() + " "
                    + iRovers.get(i).getCurrentCoOrdinate().getY() + " "
                    + iRovers.get(i).getCurrentOrientation() + "\n";
        }
        fileHelper.writeResult(result);
    }
}
