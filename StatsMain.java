public class StatsMain {
static StatsMethods stats = new StatsMethods();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mainActions();
	}
public static void mainActions(){
	stats.determineFrequency();
	stats.printValues();
	stats.calculateQuartiles();
	stats.calculateMaxMin();
	double calculatedMean = stats.calculateMean();
	double calculatedSum = stats.sizeOfList() * stats.calculateMean();
	System.out.println("The Mean of the set is: " + calculatedMean);
	System.out.println("The Sum of the set is: " + calculatedSum);
	stats.standardDeviation();
}
}
