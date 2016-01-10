public class Plateau {
    private final CoOrdinate lowerLeft;
    private final CoOrdinate upperRight;

    public Plateau(CoOrdinate lowerLeft, CoOrdinate upperRight) {
        this.lowerLeft = lowerLeft;
        this.upperRight = upperRight;
    }

    public Plateau(Integer x, Integer y) {
        this.lowerLeft = new CoOrdinate(0, 0);
        this.upperRight = new CoOrdinate(x, y);
    }

    public CoOrdinate getUpperRight() {
        return upperRight;
    }

    public CoOrdinate getLowerLeft() {
        return lowerLeft;
    }
}
