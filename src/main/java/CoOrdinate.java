public class CoOrdinate {
    private int x;
    private int y;

    public CoOrdinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        CoOrdinate other = (CoOrdinate) obj;
        return (this.x == other.x) && (this.y == other.y);
    }
}
