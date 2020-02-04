import java.util.Scanner;

public class BMICalculator {
	private int Weight;
	private int Height;
	private float bmi;
	public static void main(String[] args) {
		
		BMICalculator app = new BMICalculator();
		app.readUserData();
		app.calculateBmi();
		app.displayBmi();
	}
	
	public void readUserData(){
		//take input from the user for their bmi
		//give the options 1 and 2 to determine whether they want to use metric or imperial
		int UserChoice = readUnitType();
		readMeasurementData(UserChoice);
	}
	
		private int readUnitType() {
			Scanner s = new Scanner(System.in);
			System.out.println("Welcome to the BMI calculator.");
			System.out.println("Enter the numbers 1 or 2 to use the imperial system or metric system respectively: ");
			int Choice = 0;
			while(true) {
				Choice = s.nextInt();
				if(Choice == 1 || Choice == 2) break;
				else {
					System.out.println("Invalid input, please enter 1 or 2 to select the imperial or metric system");
				}	
			}
			return Choice;
		}
		
		// 
		private void readMeasurementData(int UserChoice) {
	
				if(UserChoice == 1) {
					readImperialData();
				}	
				if(UserChoice == 2) {
					readMetricData();
				}
			}
		//read the user's inputs for their height and weight
		private void readMetricData() {
			
			Scanner s = new Scanner(System.in);
			System.out.println("Enter your weight in Kilograms : ");
			//make sure the user does not enter a negative weight
			int Weight = s.nextInt();
			while(true) {

				if(Weight < 0) {
					System.out.println("You can not enter a negative weight");
					System.exit(0);
				}
				else break;
			}
			//sets the weight to the main variable 
			setWeight(Weight);
			System.out.println("Enter your height in Meters: ");
			int Height = s.nextInt();
			while(true) {

				if(Height < 0) {
					System.out.println("You can not enter a negative height");
					System.exit(0);
				}
				else break;
			}

			setHeight(Height * Height);
		}
		
		private void readImperialData() {
			
			Scanner s = new Scanner(System.in);			
			System.out.println("Enter your weight: ");
			//make sure the user does not enter a negative value
			int Weight = s.nextInt();
			while(true) {

				if(Weight < 0) {
					System.out.println("You can not enter a negative weight");
					System.exit(0);
				}
				else break;
			}
			//adjust the weight to the imperial system
			setWeight(703 * Weight);
			System.out.println("Enter your height in Inches: ");
			int Height = s.nextInt();
			while(true) {
				if(Height < 0) {
					System.out.println("You can not enter a negative Height");
					System.exit(0);
				}
				else break;
			}
			//square the height
			setHeight(Height * Height);
		}
		//all of the get and set functions
		public int getWeight() {
			return Weight;
		}
		
		private void setWeight(int Weight) {
			this.Weight = Weight;
		}
		
		public int getHeight() {
			return Height;
		}
		
		private void setHeight(int Height) {
			this.Height = Height;
		}
		public float getBmi() {
			return bmi;
		}
		
	public void calculateBmi() {
		//use the inputs given to calculate BMI
		bmi = (float)getWeight() / getHeight();
	}
	
	public void displayBmi() {
		System.out.printf("Your bmi is %.1f, ", getBmi());
		getBmiCategory(getBmi());
	}
	
	public void getBmiCategory(float bmi){
		if(bmi < 18.5) {
			System.out.println("according to your bmi you are underweight");
		}
		if(bmi < 24.9 && bmi > 18.4) {
			System.out.println("according to your bmi you are average weight");
		}
		if(bmi > 24.9 && bmi < 30) {
			System.out.println("according to your bmi you are overweight");
		}
		if(bmi > 30) {
			System.out.println("according to your bmi you are obese");
		}
	}
}
