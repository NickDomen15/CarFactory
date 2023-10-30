import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

/**
 * Factory --- program to randomly generates a set 
 * number of car objects and writes them to a CSV file
 * @author Nick Domenico
 */
public class Factory {
	
	Random rand = new Random();
	
	// arrays of possible car types and colors
	private String[] carTypes = {"Sedan", "Sedan", "Sedan", "Car", "Truck", "Van", "Minivan"};
	private String[] carColors = {"Red", "Red", "Red", "Blue", "Black", "Silver", "Green"};
	
	// ArrayList where all car objects will be stored
	private ArrayList<Car> carList = new ArrayList<Car>();
	
	
	/**
	 * Calls the generateCars method 
	 * "int numberOfCars" times
	 * @param numberOfCars
	 */
	public Factory (int numberOfCars) {
		generateCars(numberOfCars);
	}
	
	
	/**
	 * Generates "int numberOfCars" Car objects with carType and carColor
	 * being randomly selected from Arrays, year randomly generated from 1973-2023,
	 * and miles randomly generated from 1-250000.
	 * @param numberOfCars
	 * @return ArrayList<Car>
	 */
	public ArrayList<Car> generateCars(int numberOfCars) {
		
		for (int i = 0; i < numberOfCars; i++) {
			String carType = carTypes[rand.nextInt(carTypes.length)];
			int year = 1973 + rand.nextInt(50) + 1;
			String carColor = carColors[rand.nextInt(carColors.length)];
			int miles = rand.nextInt(250000) + 1;
			carList.add(new Car(carType, year, carColor, miles));
		}
		
		return carList;
	}
	
	
	/**
	 * Writes the attributes of each Car object in ArrayList 
	 * CarList to a CSV file "fileName" using the toString method
	 * @param fileName
	 */
	/*
	 * Code used from:
	 * https://beginnersbook.com/2014/01/how-to-write-to-file-in-java-using-bufferedwriter/
	 */
	public void writeToCSV(String fileName) {
		
		try {
			
			File file = new File(fileName);
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fWriter = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fWriter); 
			
			writer.write("CarType, Year, Color, Miles");
			
			for (int i = 0; i < carList.size(); i++) {
				writer.write((carList.get(i)).toString());
			}
			
			writer.close();
			
		}
		
		catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
	
	
	/**
	 * Reads a CSV file "fileName" of Car 
	 * attributes and prints each of them
	 * @param fileName
	 */
	/*
	 * Code used from:
	 * https://www.studytonight.com/java-examples/reading-a-csv-file-in-java#:~:text=Reading%20CSV%20Files%20by%20Using,the%20comma%20as%20a%20delimiter.
	 */
	public void readCSV(String fileName) {
		
		try {
			
			carList.clear();
			
			FileReader fReader = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(fReader);
			
			String line = reader.readLine();
			line = reader.readLine();
			
			while (line != null) {
				String[] data = line.split(", ");
				String carType = data[0];
				int year = Integer.valueOf(data[1]);
				String color = data[2];
				int miles = Integer.valueOf(data[3]);
				carList.add(new Car(carType, year, color, miles));
				line = reader.readLine();
			}
			
			for (int i = 0; i < carList.size(); i++) {
				System.out.print(carList.get(i).toString());
			}
			
			reader.close();
		}
		
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
}
