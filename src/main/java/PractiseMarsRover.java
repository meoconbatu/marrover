import java.util.List;

/**
 * Created by thanhmi on 1/7/16.
 */
public class PractiseMarsRover {
    public static void main(String [] args)
    {
        String result = "";
        FileHelper iFileHelper = new FileHelper("inputMarRover.txt");
        List<String> allLinesOfIFile = iFileHelper.readAllLines();
        String plateauInfoStr = allLinesOfIFile.get(0);
        String[] plateauInfoArr = plateauInfoStr.split(" ");
        Plateau plateau = new Plateau(Integer.parseInt(plateauInfoArr[0]), Integer.parseInt(plateauInfoArr[1]));
        for (int i = 1; i < allLinesOfIFile.size(); i= i+2) {
            String roverStr = allLinesOfIFile.get(i);
            String[] roverArr = roverStr.split(" ");
            Rover rover = new Rover(Integer.parseInt(roverArr[0]),Integer.parseInt(roverArr[1]),roverArr[2]);
            rover.setPlateau(plateau);

            String instruction = allLinesOfIFile.get(i+1);
            rover.setInstruction(instruction);

            rover.executeInstruction();

            result += rover.getCurrentCoOrdinate().getX() + " "
                    + rover.getCurrentCoOrdinate().getY() + " "
                    + rover.getCurrentOrientation() + "\n";
        }
        FileHelper oFileHelper = new FileHelper("outputMarRover.txt");
        oFileHelper.write(result);
    }
}
