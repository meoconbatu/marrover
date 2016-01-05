public class Rover {
    public static Plateau plateau;
    private CoOrdinate currentCoOrinate;
    private String orientation;

    public Rover(CoOrdinate startingOrdinate, String orientation) {
        currentCoOrinate = startingOrdinate;
        this.orientation = orientation;
    }

    public void executeCommand(char m) {
        if (m == 'M'){
            move();
        }
        else if (m == 'L') {
           turnLeft();
        }
        else if (m == 'R') {
            turnRight();
        }
    }
    private void turnLeft(){
        if (orientation == "S")
            orientation = "E";
        else if (orientation == "W")
            orientation = "S";
        else if (orientation == "N")
            orientation = "W";
        else if (orientation == "E")
            orientation = "N";
    }
    private void turnRight(){
        if (orientation == "S")
            orientation = "W";
        else if (orientation == "W")
            orientation = "N";
        else if (orientation == "N")
            orientation = "E";
        else if (orientation == "E")
            orientation = "S";
    }
    private void move()
    {
        if (orientation == "E"){
            if (plateau.getUpperRight().getX() != currentCoOrinate.getX())
                currentCoOrinate = new CoOrdinate(currentCoOrinate.getX()+1, currentCoOrinate.getY());
        }
        else if (orientation == "W"){
            if (plateau.getLowerLeft().getX() != currentCoOrinate.getX())
                currentCoOrinate = new CoOrdinate(currentCoOrinate.getX()-1, currentCoOrinate.getY());
        }
        else if (orientation == "N"){
            if (plateau.getUpperRight().getY() != currentCoOrinate.getY())
                currentCoOrinate = new CoOrdinate(currentCoOrinate.getX(), currentCoOrinate.getY()+1);
        }
        else if (orientation == "S"){
            if (plateau.getLowerLeft().getY() != currentCoOrinate.getY())
                currentCoOrinate = new CoOrdinate(currentCoOrinate.getX(), currentCoOrinate.getY()-1);
        }
    }
    public CoOrdinate getCurrentCoOrinate() {
        return currentCoOrinate;
    }

    public String getCurrentOrientation() {
        return orientation;
    }
}
