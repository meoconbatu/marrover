import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanhmi on 1/6/16.
 */
public class FileHelper {
    private String fileName;

    public FileHelper(String inputFileName) {
        fileName = inputFileName;
    }
    public List<String> readAllLines(){
        BufferedReader bufferedReader = initialBufferedReader();
        List<String> allLinesOfFile = new ArrayList<String>();
        try{
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null){
                allLinesOfFile.add(currentLine);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return allLinesOfFile;
    }

    private BufferedReader initialBufferedReader() {
        File file = new File(fileName);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new BufferedReader(fileReader);
    }
    private BufferedWriter initialBufferedWritter() {
        try {
           return new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileName), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String readLineAtIndex(int i) {
        List<String> allLinesOfFile = readAllLines();
        return allLinesOfFile.get(i-1);
    }

    public void write(String content) {
        BufferedWriter bufferedWriter = initialBufferedWritter();
        try {
            bufferedWriter.write(content);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
