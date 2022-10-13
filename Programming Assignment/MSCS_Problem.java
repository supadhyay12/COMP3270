import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import static java.util.concurrent.TimeUnit.NANOSECONDS; //scaling complexity values to nanoseconds
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Random;

/**
 * @author Shanti Upadhyay (spu0004@auburn.edu)
 * COMP 3270 Programming Assignment
 * Due: Thursday, July 21
 */

public class MSCS_Problem {
	
	public static int[] randomArr1 =  new int[10];
	public static int[] randomArr2 =  new int[15];
	public static int[] randomArr3 =  new int[20];
	public static int[] randomArr4 =  new int[25];
	public static int[] randomArr5 =  new int[30];
	public static int[] randomArr6 =  new int[35];
	public static int[] randomArr7 =  new int[40];
	public static int[] randomArr8 =  new int[45];
	public static int[] randomArr9 =  new int[50];
	public static int[] randomArr10 =  new int[55];
	public static int[] randomArr11 =  new int[60];
	public static int[] randomArr12 =  new int[65];
	public static int[] randomArr13 =  new int[70];
	public static int[] randomArr14 =  new int[75];
	public static int[] randomArr15 =  new int[80];
	public static int[] randomArr16 =  new int[85];
	public static int[] randomArr17 =  new int[90];
	public static int[] randomArr18 =  new int[95];
	public static int[] randomArr19 =  new int[100];
	
	public static int[][] matrix = new int[19][8];
	
	public static void main(String[] args){
		
		int[] X = readFileToArray();
		
		int max = 0;
		max = algorithm1(X);
		System.out.println("algorithm-1: " + max + "\n");
		max = algorithm2(X);
		System.out.println("algorithm-2: " + max + "\n");
		max = maxSum(X, 0, 9);
		System.out.println("algorithm-3: " + max + "\n");
		max = algorithm4(X);
		System.out.println("algorithm-4: " + max + "\n");
		
		randArrayHandler();
		outputToFile();
	}
	
   //Inputs values from the file into an array
   //Resources Used: https://www.geeksforgeeks.org/read-file-into-an-array-in-java/
   //                https://www.w3schools.com/java/java_try_catch.asp
   //                https://www.tutorialspoint.com/java/number_parseint.htm
	public static int[] readFileToArray(){
		String[] stringFileInput = new String[10];
		int[] intFileInput = new int[10];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("phw_input.txt"));
			String inputLine = null;
			
			while((inputLine = br.readLine()) != null)
				stringFileInput = inputLine.split(", ");
		
			for(int i = 0; i < stringFileInput.length; i++)
				intFileInput[i] = Integer.parseInt(stringFileInput[i]);
			
			br.close();
		}
		catch(IOException e) { 
         System.out.println(e); 
      }
		return intFileInput;
	}
	
	//Algorithm-1(X : array[P..Q] of integer)
	public static int algorithm1(int X[]) {
		int maxSoFar = 0;
      int P = 0;
		int Q = X.length;
		
		for(int L = P; L < Q; L++) {	
			for(int U = L; U < Q; U++) {	
				 int sum = 0;				
				for(int I = L; I <= U; I++) {
					sum = sum + X[I];	//sum now contains the sum of X[L..U]
				}
				maxSoFar = Math.max(maxSoFar, sum); //maximum int in the array with Algorithm-1
			}
		}
		return maxSoFar;
	}
	
	//Algorithm-2(X : array[P..Q] of integer)	
   public static int algorithm2(int X[]) {
		int maxSoFar = 0;
      int P = 0;
		int Q = X.length;
		
		for(int L = P; L < Q; L++) {
			int sum = 0;
			for(int U = L; U < Q; U++) {
				sum = sum + X[U]; //sum now contains the sum of X[L..U]
				maxSoFar = Math.max(maxSoFar, sum); //maximum int in the array with Algorithm-2
			}
		}
		return maxSoFar;
	}
	
	//Algorithm-3 Recursive Function
   //MaxSum(X[L..U]: array of integer, L, U: integer)
	public static int maxSum(int X[], int L, int U) {
		
		if(L > U) 
         return 0; //zero element vector
		if(L == U) 
         return Math.max(0, X[L]); //one element vector
	
		int M = (L + U)/2;
		int sum = 0;
      int maxToLeft = 0;
		
		for(int I = M; I >= L; I--) { //find max crossing to left
			sum = sum + X[I];
			maxToLeft = Math.max(maxToLeft, sum);
		}
		sum = 0;
		int maxToRight = 0;
		
		for(int I = M+1; I <= U; I++) { //find max crossing to right
			sum = sum + X[I];
			maxToRight = Math.max(maxToRight, sum);
		}
		int maxCrossing = maxToLeft + maxToRight;
		int maxInA = maxSum(X, L, M);
		int maxInB = maxSum(X, M+1, U);
		
		return Math.max(maxCrossing,Math.max(maxInA, maxInB));
	}
	
   //Algorithm-4(X : array[P..Q] of integer)
	public static int algorithm4(int X[]) {
		int maxSoFar = 0;
      int maxEndingHere = 0;
      int P = 0;
		int Q = X.length;
		
		for(int I = P; I < Q; I++) {
			maxEndingHere = Math.max(0, maxEndingHere + X[I]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		
		return maxSoFar; //maximum integer in the array with Algorithm-4
	}

   //Array Handler
	public static void randArrayHandler() {
		randomArr1 = fillArray(10);
		randomArr2 = fillArray(15);
		randomArr3 = fillArray(20);
		randomArr4 = fillArray(25);
		randomArr5 = fillArray(30);
		randomArr6 = fillArray(35);
		randomArr7 = fillArray(40);
		randomArr8 = fillArray(45);
		randomArr9 = fillArray(50);
		randomArr10 = fillArray(55);
		randomArr11 = fillArray(60);
		randomArr12 = fillArray(65);
		randomArr13 = fillArray(70);
		randomArr14 = fillArray(75);
		randomArr15 = fillArray(80);
		randomArr16 = fillArray(85);
		randomArr17 = fillArray(90);
		randomArr18 = fillArray(95);
		randomArr19 = fillArray(100);
		
		measureTime(randomArr1, 0);
		measureTime(randomArr2, 1);
		measureTime(randomArr3, 2);
		measureTime(randomArr4, 3);
		measureTime(randomArr5, 4);
		measureTime(randomArr6, 5);
		measureTime(randomArr7, 6);
		measureTime(randomArr8, 7);
		measureTime(randomArr9, 8);
		measureTime(randomArr10, 9);
		measureTime(randomArr11, 10);
		measureTime(randomArr12, 11);
		measureTime(randomArr13, 12);
		measureTime(randomArr14, 13);
		measureTime(randomArr15, 14);
		measureTime(randomArr16, 15);
		measureTime(randomArr17, 16);
		measureTime(randomArr18, 17);
		measureTime(randomArr19, 18);
	}
	
   //Adds randomized integers from -100 to 100 
   //Resource Used: https://www.tutorialspoint.com/generate-a-random-array-of-integers-in-java#:~:text=In%20order%20to%20generate%20random,this%20random%20number%20generator%20sequence.
	private static int[] fillArray(int arrayLength) {	
		Random random = new Random();
		int[] tempArray = new int[arrayLength]; //array containing randomized integers

		for(int i = 0; i < arrayLength; i++) 
			tempArray[i] = random.nextInt(200) - 100;
		
		return tempArray;
	}
	
   //Measures average running time and T(n) for each algorithm
   //Resource Used: https://www.baeldung.com/java-measure-elapsed-time
	public static void measureTime(int[] tempArray, int row) {
		
		long start = 0;
      long stop = 0;
      long process = 0;
		
		int avrg1 = 0;
      int avrg2 = 0;
      int avrg3 = 0;
      int avrg4 = 0;
      
		double tn_Alg1 = 0;
      double tn_Alg2 = 0;
      double tn_Alg3 = 0;
      double tn_Alg4 = 0;
		
		int arrayLength = tempArray.length;
		
		for(int i = 0; i < 500; i++) {
			//Time Measurements for Algorithms1-4
			start = System.nanoTime();
			int max = algorithm1(tempArray);
			stop = System.nanoTime();
		
			process = stop - start;
			avrg1 += process;
			System.out.println(avrg1);
			
			start = System.nanoTime();
			max = algorithm2(tempArray);
			stop = System.nanoTime();
			
			process = stop - start;
			avrg2 += process;
			
			start = System.nanoTime();
			max = maxSum(tempArray, 0, arrayLength-1);
			stop = System.nanoTime();
		
			process = stop - start;
			avrg3 += process;
			
			start = System.nanoTime();
			max = algorithm4(tempArray);
			stop = System.nanoTime();
		
			process = stop - start;
			avrg4 += process;
		}
		
		//Calculating average times for Algorithms1-4
		avrg1 = avrg1 / 500;
		avrg2 = avrg2 / 500;
		avrg3 = avrg3 / 500;
		avrg4 = avrg4 / 500;

		//Calculating T(n) for Algorithms1-4
		tn_Alg1 = calculateTimeComp(arrayLength, 1);
		tn_Alg2 = calculateTimeComp(arrayLength, 2);
		tn_Alg3 = calculateTimeComp(arrayLength, 3);
		tn_Alg4 = calculateTimeComp(arrayLength, 4);
		
		
		int[] arrayOfTime = {avrg1, avrg2, avrg3, avrg4, (int) tn_Alg1, (int) tn_Alg2, (int) tn_Alg3, (int) tn_Alg4};
		
		//Fills 19x8 matrix
		for(int j = 0; j < 8; j++) {
			matrix[row][j] = arrayOfTime[j];
		}
	}
	
	//Calculates the time complexity
	//Input size is represented by the variable n
	//The variable algorithmNum indicates which algorithm is being tested
	//Resource Used: https://www.tutorialspoint.com/java/lang/math_pow.htm
	private static double calculateTimeComp(int n, int algorithmNum) {
		
		double tComp = 0;
		switch(algorithmNum) {
			case 1:
				tComp = ((7/2) * Math.pow(n, 3)) + (3 * Math.pow(n, 2)) + ((33/2) * n) + 3;
				break;
				
			case 2:
				tComp = Math.pow(n, 2) + ((17/2) * n) + 4;
				break;
				
			case 3:
				tComp = (12 * n)* (Math.log(2)/Math.log(n)) + (12 * n);
				break;
				
			case 4: 
				tComp = (13 * n) + 5;
				break;
		}
		return tComp; //the calculated time complexity of the algorithm
	}
	
   //Prints content of matrix variable to a textfile
   //Source: https://www.w3schools.com/java/java_files_create.asp
	public static void outputToFile() {
		
		try {
			File file = new File("ShantiUpadhyay_phw_output.txt");
			FileWriter fileWriter = new FileWriter("ShantiUpadhyay_phw_output.txt");

			fileWriter.write("algorithm-1,algorithm-2,algorithm-3,algorithm-4,T1(n),T2(n),T3(n),T4(n)\n");

			for(int i = 0; i < 19; i++) {
				for(int j = 0; j < 8; j++) {
					String value = Integer.toString(matrix[i][j]);
					fileWriter.write(value);
					
					if(j < 7) fileWriter.write(",");
				}
				fileWriter.write("\n");
			}
			fileWriter.close();
		}
		catch(IOException e) {
         System.out.println(e);
      }
	}
}