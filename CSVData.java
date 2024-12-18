import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

public class CSVData {
    public ArrayList<String[]> data;
    public File file;

    public CSVData() {
        this.data = new ArrayList<>();
    }

    public void assignFiles() {
        JFileChooser file = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        file.setDialogTitle("Select File");
        int returnValue = file.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            this.file = file.getSelectedFile();
        }
    }

    public void readFiles() {
        String[] record;
        try {
            Scanner readFile = new Scanner(this.file);
            while (readFile.hasNextLine()) {
                record = readFile.nextLine().split(",");
                this.data.add(record);
                
            }
         }
        catch (FileNotFoundException e) {
            e.printStackTrace();  
        }
    }



    public static void main(String[] args) {
        CSVData test1 = new CSVData();
        test1.assignFiles();
        test1.readFiles();
    }
}