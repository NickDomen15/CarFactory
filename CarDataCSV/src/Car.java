/**
 * Car --- program to create car objects 
 * to be used in the Factory class
 * @author Nick Domenico
 */
public class Car {

	// instance variables
	private String carType;
	private int year;
	private String color;
	private int miles;
	
	
	/**
	 * Creates a car object with a 
	 * type, year, color, and miles
	 * @param String carType
	 * @param int year
	 * @param String color
	 * @param int miles
	 */
	public Car(String carType, int year, String color, int miles) {
		this.carType = carType;
		this.year = year;
		this.color = color;
		this.miles = miles;
	}
	
	
	// getters
	
	/**
	 * Returns the car's type
	 * @return String
	 */
	public String getCarType() {
		return carType;
	}

	
	/**
	 * Returns the car's year
	 * @return int
	 */
	public int getYear() {
		return year;
	}

	
	/**
	 * Returns the car's color
	 * @return String
	 */
	public String getColor() {
		return color;
	}

	
	/**
	 * Returns the car's miles
	 * @return int
	 */
	public int getMiles() {
		return miles;
	}

	
	/**
	 * Returns a string with the car attributes
	 */
	@Override
	public String toString() {
		return "\n" + carType + ", " + year + ", " + color + ", " + miles;
	}
	
}
