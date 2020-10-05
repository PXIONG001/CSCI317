// Import Scanner, ArrayList, Random
import java.util.*;

/**
 * The Algorithm to estimate for Pi.
 * 
 * @author Peng Xiong
 */
public class AlgorithmPiE{
  
  public static void main(String [] args){
    
    System.out.print( "Enter the number of games: " );
    Scanner myInput = new Scanner(System.in);
    double number_of_games = myInput.nextDouble();
    System.out.print( "Enter the number of darts: " );
    double number_of_darts = myInput.nextDouble();
    
    System.out.println(EstimatePi(number_of_games, number_of_darts));
  }
  
  /**
   * Estimate Pi and finding the average (mean) value and the standard deviation.
   * 
   * @param number_of_games the total amount of games
   * @param number_of_darts the total amount of darts
   * 
   * @return a String back to the user with the standard deviation and average (mean) value.
   */
  public static String EstimatePi(double number_of_games, double number_of_darts){
    
    // ArrayList to store the pi numbers
    ArrayList<Double> piNum = new ArrayList<Double>();
    
    // The distance from the center of the circle
    double distance = 0;
    
    // n_inside
    double inside_points = 0;
    
    // n_total
    double total_points = 0;
    
    // random value for x
    double rand_x = 0.0;
    
    // random value for y
    double rand_y = 0.0;
    double min = -0.5;
    double max = 0.5;
    
    // pi
    double pie = 0;
    
    // loops through each game, then it loops through the darts
    for(int i = 0; i < number_of_games; i++){
      for(int a = 0; a < number_of_darts; a++){
        
        // Generates a random x-value from (-0.5, 0.5)
        rand_x = Math.random() * (max - min) + min;
        
        // Generates a random y-value from (-0.5, 0.5)
        rand_y = Math.random() * (max - min) + min;
        
        distance = Math.sqrt(rand_x*rand_x + rand_y*rand_y);
        
        if(distance < 0.5)
          inside_points += 1;
        total_points += 1;
      }
      
      // pi = 4 * (n_inside/n_total)
      pie = 4 * (inside_points/total_points);
      
      // Array list of all the estimation of pi
      piNum.add(pie);
    }
    
    //System.out.println(piNum);
    
    // Finding the mean value for all the games 
    double mean = calculateM(piNum);
    
    // Variable to calculate standard deviation
    double SD = calculateSD(piNum, mean);
    return "\nAverage (Mean) Value: " + mean + "\nStandard Deviation: " + SD;
  }
  
  /**
   * Calculates the average (mean) value.
   * 
   * @param numArray the array list containing the estimation of pi for each game
   * 
   * @return the average (mean) value
   */
  public static double calculateM(ArrayList<Double> numArray){
    
    double average = 0;
    
    int length = numArray.size();
    
    // Enhanced for loop to calculate the mean value
    for(double num : numArray){
      average += num;
    }
    return average/length;
  }
  
  /**
   * Calculates the standard deviation.
   * 
   * @param numArray the array list containing the estimation of pi for each game
   * @param mean the average value
   * 
   * @return the standard deviation
   */
  public static double calculateSD(ArrayList<Double> numArray, double mean){
    
    double standardDeviation = 0;
    
    // The size of the array list
    int length = numArray.size();
    
    // Enhanced loop to calculate the standard deviation
    for(double num : numArray){
      standardDeviation += Math.pow(num - mean, 2);
    }
    
    return Math.sqrt(standardDeviation/length);
  }
  
}