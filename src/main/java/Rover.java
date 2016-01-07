public class Rover {
    public static Plateau plateau;
    private CoOrdinate currentCoOrdinate;
    private String orientation;
    private String instruction;

    public Rover(CoOrdinate startingOrdinate, String orientation) {
        currentCoOrdinate = startingOrdinate;
        this.orientation = orientation;
        instruction = null;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
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
        if (orientation.equals("S"))
            orientation = "E";
        else if (orientation.equals("W"))
            orientation = "S";
        else if (orientation.equals("N"))
            orientation = "W";
        else if (orientation.equals("E"))
            orientation = "N";
    }
    private void turnRight(){
        if (orientation.equals("S"))
            orientation = "W";
        else if (orientation.equals("W"))
            orientation = "N";
        else if (orientation.equals("N"))
            orientation = "E";
        else if (orientation.equals("E"))
            orientation = "S";
    }
    private void move()
    {
        if (orientation.equals("E")){
            if (plateau.getUpperRight().getX() != currentCoOrdinate.getX())
                currentCoOrdinate = new CoOrdinate(currentCoOrdinate.getX()+1, currentCoOrdinate.getY());
        }
        else if (orientation.equals("W")){
            if (plateau.getLowerLeft().getX() != currentCoOrdinate.getX())
                currentCoOrdinate = new CoOrdinate(currentCoOrdinate.getX()-1, currentCoOrdinate.getY());
        }
        else if (orientation.equals("N")){
            if (plateau.getUpperRight().getY() != currentCoOrdinate.getY())
                currentCoOrdinate = new CoOrdinate(currentCoOrdinate.getX(), currentCoOrdinate.getY()+1);
        }
        else if (orientation.equals("S")){
            if (plateau.getLowerLeft().getY() != currentCoOrdinate.getY())
                currentCoOrdinate = new CoOrdinate(currentCoOrdinate.getX(), currentCoOrdinate.getY()-1);
        }
    }
    public void executeInstruction() {
        for (int i = 0; i < instruction.length(); i++) {
            executeCommand(instruction.charAt(i));
        }
    }
    public CoOrdinate getCurrentCoOrdinate() {
        return currentCoOrdinate;
    }

    public String getCurrentOrientation() {
        return orientation;
    }

    public String getInstruction() {
        return instruction;
    }


}
