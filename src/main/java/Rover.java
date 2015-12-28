public class Rover {
    private CoOrdinate currentCoOrinate;
    private String orientation;

    public Rover(CoOrdinate startingOrdinate, String orientation) {
        currentCoOrinate = startingOrdinate;
        this.orientation = orientation;
    }

    public void executeCommand(char m) {
        if (orientation == "E"){
            currentCoOrinate = new CoOrdinate(currentCoOrinate.getX()+1, currentCoOrinate.getY());
        }
        else if (orientation == "W"){
            currentCoOrinate = new CoOrdinate(currentCoOrinate.getX()-1, currentCoOrinate.getY());
        }
        else if (orientation == "N"){
            currentCoOrinate = new CoOrdinate(currentCoOrinate.getX(), currentCoOrinate.getY()+1);
        }
        else if (orientation == "S"){
            currentCoOrinate = new CoOrdinate(currentCoOrinate.getX(), currentCoOrinate.getY()-1);
        }

    }

    public CoOrdinate getCurrentCoOrinate() {
        return currentCoOrinate;
    }
}
