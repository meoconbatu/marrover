import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanhmi on 1/6/16.
 */
public class FileHelper {
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    public FileHelper(String inputFileName) {
        File iFile = new File(inputFileName);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(iFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bufferedReader = new BufferedReader(fileReader);


    }
    public Plateau readPlateau() {
        String firstLineOfInputFile = "";
        try {
            firstLineOfInputFile = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] firstLineOfInputFileArray = firstLineOfInputFile.split(" ");
        CoOrdinate lowerLeft = new CoOrdinate(0,0);
        CoOrdinate upperRight = new CoOrdinate(Integer.parseInt(firstLineOfInputFileArray[0]), Integer.parseInt(firstLineOfInputFileArray[1]));
        return new Plateau(lowerLeft, upperRight);
    }
    public List<Rover> readRoverInfos() {
        String positionRover;
        String instruction;
        List<Rover> rovers = new ArrayList<Rover>();
        try {
            Rover.plateau = readPlateau();
            while((positionRover = bufferedReader.readLine()) != null && (instruction = bufferedReader.readLine()) != null){
                String[] positionRoverArray = positionRover.split(" ");
                Rover rover = new Rover(new CoOrdinate(Integer.parseInt(positionRoverArray[0]), Integer.parseInt(positionRoverArray[1])), positionRoverArray[2]);
                rover.setInstruction(instruction);
                rovers.add(rover);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return rovers;
    }

    public void writeResult(String result) {
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("outputMarRover.txt"), "utf-8"));
            bufferedWriter.write(result);
            bufferedWriter.flush(); bufferedWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
