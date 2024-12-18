import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;



public class StandardCurve extends CSVData {
    private Double absorbanceConversion;
    private ArrayList<Double> x = new ArrayList<Double>();
    private ArrayList<Double> y = new ArrayList<Double>();

    public void calculateSC() {
        
        try {
        Scanner justInts = new Scanner(this.file);
        String[] throwawayString = justInts.nextLine().split(",");
        while (justInts.hasNextLine()) {
            String[] split = justInts.nextLine().split(",");
            double[] doubleNow = convertStringsToDoubles(split);
            x.add(doubleNow[0]);
            y.add(doubleNow[1]);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Double deltaX = x.getLast() - x.getFirst();
        Double deltaY = y.getLast() - y.getFirst();
        this.absorbanceConversion = deltaY/deltaX;



    }
            

        public static double[] convertStringsToDoubles(String[] stringArray) {
            // Create a float array to store the results
            double[] doubleArray = new double[stringArray.length];
            
            // Loop through the string array and convert each element to float
            for (int i = 0; i < stringArray.length; i++) {
                try {
                    // Parse each string as a float
                    doubleArray[i] = Double.parseDouble(stringArray[i]);
                } catch (NumberFormatException e) {
                    // Handle invalid input (e.g., if the string cannot be parsed as a float)
                    System.err.println("Invalid number format: " + stringArray[i]);
                    doubleArray[i] = 0.0f;  // Default to 0.0f in case of error
                }
            }
            
            return doubleArray;
        }

        public double getConcentrationConversion() {
            return this.absorbanceConversion;
        }
    

    public static void main(String[] args) {
        
    }
}
