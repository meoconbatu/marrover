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
}
