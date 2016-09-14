import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class StatsMethods {
static Scanner methodReader = new Scanner(System.in);
static ArrayList<Double> values = new ArrayList<Double>();
static int z = 0;
static int y = 0;
public StatsMethods(){
}
public double sizeOfList(){
	double sizeOfList = values.size();
	return sizeOfList;
}
public void determineFrequency(){
	System.out.println("Caution: Do not spam inputs of the program may generate undesired results! Always check the final data set!");
	System.out.println("Would you like for your values to have frequency values associated with them? Yes/No");
	String answer = methodReader.nextLine();
	if(answer.equalsIgnoreCase("Yes")){
		determineAmountValuesFreq();
	}
	else if(answer.equalsIgnoreCase("No")){
		determineAmountValues();
	}
	else{
		System.out.println("Invalid input! Please type Yes or No. Restarting...");
		determineFrequency();
	}
}
public void addValuesWithFreq(int numValues){ //make this work like addValues so it repeats on incorrect inputs
	try{
	while(y < numValues){
		System.out.println("Please enter value #" + (y + 1) + ": ");
		double value = Double.parseDouble(methodReader.nextLine());
		System.out.println("Please enter frequency of value #" + (y + 1) + ": ");
		double frequency = Integer.parseInt(methodReader.nextLine());
		y++;
		for(int a = 0; a < frequency; a++){
		values.add(value);
		}
		Collections.sort(values);
		}
	}
	catch (java.lang.NumberFormatException invalidValueInput){
		boolean errorPresent = true;
		while(errorPresent == true && y < numValues){
			try{
				System.out.println("Please enter value #" + (y + 1) + ": ");
				double value = Double.parseDouble(methodReader.nextLine());
				System.out.println("Please enter frequency of value #" + (y + 1) + ": ");
				double frequency = Integer.parseInt(methodReader.nextLine());
				for(int a = 0; a < frequency; a++){
				values.add(value);
				}
				Collections.sort(values);
				y++;
			}
			catch (java.lang.NumberFormatException invalidValueFreq){
				addValuesWithFreq(numValues);
			}
		}
	}
}
public void determineAmountValues(){
	System.out.println("How many values would you like to add?");
	try{
	int numValues = Integer.parseInt(methodReader.nextLine());
	addValues(numValues);
	}
	catch (java.lang.NumberFormatException invalidInput){
		boolean errorPresent = true;
		while(errorPresent == true){
		System.out.println("Invalid Input! Please enter a valid number of values.");
		errorPresent = false;
		determineAmountValues();
		}
	}
}
public void determineAmountValuesFreq(){
	System.out.println("How many values would you like to add?");
	try{
	int numValues = Integer.parseInt(methodReader.nextLine());
	addValuesWithFreq(numValues);
	}
	catch (java.lang.NumberFormatException invalidInput){
		boolean errorPresent = true;
		while(errorPresent == true){
		System.out.println("Invalid Input! Please enter a valid number of values.");
		errorPresent = false;
		determineAmountValues();
		}
	}
}
public void addValues(int numValues){
	try{
		while(z < numValues){
			System.out.println("Please enter value #" + (z + 1) + ": ");
			double value = Double.parseDouble(methodReader.nextLine());
			values.add(value);
			Collections.sort(values);
			z++;
			}
	}
	catch (java.lang.NumberFormatException invalidValueInput){
		boolean errorPresent = true;
		while(errorPresent == true && z < numValues){
			System.out.println("Please enter value #" + (z + 1) + ": ");
			try{
			double value = Double.parseDouble(methodReader.nextLine());
			values.add(value);
			Collections.sort(values);
			z++;
			errorPresent = false;
			}
			catch (java.lang.NumberFormatException invalidValueErrorInput){
				addValues(numValues);
			}
		}
		}
	}
public void printValues(){
	System.out.println("The following values exist in the data set: ");
	System.out.print("[");
	if(values.size() <= 25){
	for(int i = 0; i < values.size() - 1; i++){
		System.out.print(values.get(i)+", ");
	}
	System.out.print((double)values.get(values.size() - 1)+ "]\n");
	}
	else{
		System.out.println("Data set is too large to display!]");
	}
}
public void calculateMaxMin(){
	double min = values.get(0);
	double max = values.get(values.size() - 1);
	System.out.println("The minimum value of the set is: " + min);
	System.out.println("The maximum value of the set is: " + max);
}
public void calculateQuartiles(){
	double number = ((double)values.size());
	if(values.size() % 2 == 0){
		double medianPlace = number / 2 + 0.5;
		double quartileOnePlace = medianPlace / 2 + 0.25;
		double quartileThreePlace = medianPlace + ((number - medianPlace) / 2) + 0.25;
		if(quartileOnePlace == (int)quartileOnePlace){
			double quartileOne = values.get((int)quartileOnePlace - 1);
			System.out.println("The Q1 is: " + quartileOne);
			double median = ((values.get((int)medianPlace - 1)) + (values.get((int)medianPlace))) / 2;
			System.out.println("The Median is: " + median);
			if(quartileThreePlace == (int)quartileThreePlace){
				double quartileThree = values.get((int)quartileThreePlace - 1);
				System.out.println("The Q3 is: " + quartileThree);
				double interQuartileRange = quartileThree - quartileOne;
				System.out.println("The Interquartile Range is: " + interQuartileRange);
			}
			else{
				double quartileThreeIntermediate = values.get((int)quartileThreePlace -1) + values.get((int)quartileThreePlace);
				double quartileThree = quartileThreeIntermediate / 2;
				System.out.println("The Q3 is: " + quartileThree);
				double interQuartileRange = quartileThree - quartileOne;
				System.out.println("The Interquartile Range is: " + interQuartileRange);
			}
		}
		else if(quartileOnePlace != (int)quartileOnePlace){
		double quartileOneIntermediate = values.get((int)quartileOnePlace - 1) + values.get((int)quartileOnePlace);
		double quartileOne = quartileOneIntermediate / 2;
		System.out.println("The Q1 is: " + quartileOne);
		double median = ((values.get((int)medianPlace - 1)) + (values.get((int)medianPlace))) / 2;
		System.out.println("The Median is: " + median);
		double quartileThreeIntermediate = values.get((int)quartileThreePlace -1) + values.get((int)quartileThreePlace);
		double quartileThree = quartileThreeIntermediate / 2;
		System.out.println("The Q3 is: " + quartileThree);
		double interQuartileRange = quartileThree - quartileOne;
		System.out.println("The Interquartile Range is: " + interQuartileRange);
		}
		else{
			System.out.println("Error! How could this happen???");
		}
	}
	else if(values.size() % 2 != 0 && values.size() > 1){
		double medianPlace = number / 2 + 0.5;
		double quartileOnePlace = medianPlace - (medianPlace/2);
		double quartileThreePlace = medianPlace + (medianPlace/2);
		if(medianPlace == (int)medianPlace){
			double median = values.get((int)medianPlace - 1);
			if(quartileOnePlace == (int)quartileOnePlace){
				double quartileOne = values.get((int)quartileOnePlace - 1);
				System.out.println("The Q1 is: " + quartileOne);
			System.out.println("The Median is: " + median);
			if(quartileThreePlace == (int)quartileThreePlace){
				double quartileThree = values.get((int)quartileThreePlace - 1);
				System.out.println("The Q3 is: " + quartileThree);
				double interQuartileRange = quartileThree - quartileOne;
				System.out.println("The Interquartile Range is: " + interQuartileRange);
			}
			else{
				double quartileThree = (values.get((int)quartileThreePlace - 1) + values.get((int)quartileThreePlace)) / 2;
				System.out.println("The Q3 is: " + quartileThree);
				double interQuartileRange = quartileThree - quartileOne;
				System.out.println("The Interquartile Range is: " + interQuartileRange);
			}
			}
			else{
				double quartileOne = (values.get((int)quartileOnePlace - 1) + values.get((int)quartileOnePlace)) / 2;
				System.out.println("The Q1 is: " + quartileOne);
				System.out.println("The Median is: " + median);
				if(quartileThreePlace == (int)quartileThreePlace){
					double quartileThree = values.get((int)quartileThreePlace - 1);
					System.out.println("The Q3 is: " + quartileThree);
					double interQuartileRange = quartileThree - quartileOne;
					System.out.println("The Interquartile Range is: " + interQuartileRange);
				}
				else{
					double quartileThree = (values.get((int)quartileThreePlace - 1) + values.get((int)quartileThreePlace)) / 2;
					System.out.println("The Q3 is: " + quartileThree);
					double interQuartileRange = quartileThree - quartileOne;
					System.out.println("The Interquartile Range is: " + interQuartileRange);
				}
			}
		}
		else if(medianPlace != (int)medianPlace){
			double median = (values.get((int)medianPlace - 1) + values.get((int)medianPlace)) / 2;
			if(quartileOnePlace == (int)quartileOnePlace){
				double quartileOne = values.get((int)quartileOnePlace - 1);
				System.out.println("The Q1 is: " + quartileOne);
			System.out.println("The Median is: " + median);
			if(quartileThreePlace == (int)quartileThreePlace){
				double quartileThree = values.get((int)quartileThreePlace - 1);
				System.out.println("The Q3 is: " + quartileThree);
				double interQuartileRange = quartileThree - quartileOne;
				System.out.println("The Interquartile Range is: " + interQuartileRange);
			}
			else{
				double quartileThree = (values.get((int)quartileThreePlace - 1) + values.get((int)quartileThreePlace)) / 2;
				System.out.println("The Q3 is: " + quartileThree);
				double interQuartileRange = quartileThree - quartileOne;
				System.out.println("The Interquartile Range is: " + interQuartileRange);
			}
			}
			else{
				double quartileOne = (values.get((int)quartileOnePlace - 1) + values.get((int)quartileOnePlace)) / 2;
				System.out.println("The Q1 is: " + quartileOne);
				System.out.println("The Median is: " + median);
				if(quartileThreePlace == (int)quartileThreePlace){
					double quartileThree = values.get((int)quartileThreePlace - 1);
					System.out.println("The Q3 is: " + quartileThree);
					double interQuartileRange = quartileThree - quartileOne;
					System.out.println("The Interquartile Range is: " + interQuartileRange);
				}
				else{
					double quartileThree = (values.get((int)quartileThreePlace - 1) + values.get((int)quartileThreePlace)) / 2;
					System.out.println("The Q3 is: " + quartileThree);
					double interQuartileRange = quartileThree - quartileOne;
					System.out.println("The Interquartile Range is: " + interQuartileRange);
				}
			}
		}
	}
	else{
		System.out.println("The set must have more than 1 value!");
	}
}
public double calculateMean(){
	double intermediateMean = 0;
	for(int i = 0; i < values.size(); i++){
	intermediateMean = intermediateMean + values.get(i);
	}
	double mean = intermediateMean / values.size();
	return mean;
}
public void standardDeviation(){
	double standardDeviation = 0;
	double intermedVariance = 0;
	for(int i = 0; i < values.size(); i++){
		intermedVariance = intermedVariance + Math.pow((values.get(i) - calculateMean()), 2);
	}
	double variance = intermedVariance / (values.size() - 1);
	standardDeviation = Math.sqrt(variance);
	System.out.println("The variance of the set is: " + variance);
	System.out.println("The Standard Deviation of the set is: " + standardDeviation);
}
}
