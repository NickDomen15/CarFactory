
public class TestFactory {
	
	public static void main(String[] args) {
		
		Factory test = new Factory(1000);
		
		test.writeToCSV("CarData.csv");
		
		test.readCSV("CarData.csv");
	}
}
