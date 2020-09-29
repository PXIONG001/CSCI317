// Import Random
import java.util.Random;

// Import Scanner
import java.util.Scanner;

/**
 * 
 * Algorithm for estimating Pi.
 * 
 * @authored by Peng Xiong
 * 
 */
public class Estimator2 {
  
  private static final double RADIUS = 0.5;
  
  public int number_of_games;
  
  public int number_of_darts;
  
  
  public static double PiEstimator(int number_of_games, int number_of_darts) {
    
    double distance = 0;
    
    // n_inside
    int count_of_points = 0;
    
    // n_total
    int total_of_points = 0;
    
    double rand_x = 0;
    double rand_y = 0;
    double min = -0.5;
    double max = 0.5;
    double pi = 0.0;
    
    for(int i = 0; i < number_of_games; i++) {
      
      for(int a = 0; a < number_of_darts; a++){
        
        // random x-value
        rand_x = Math.random() * (max - min) + min;
        
        // random y-value
        rand_y = Math.random() * (max - min) + min;
        
        // distance = sqrt(x*x + y*y)
        distance = Math.sqrt(rand_x*rand_x + rand_y*rand_y);
        
        if(distance < RADIUS) {
          count_of_points += 1; 
        }
        
        total_of_points += 1;
        
        
        
      }
      
      // pi = 4 * (n_inside / n_total)
      pi = 4 * (count_of_points / total_of_points);
    }
    
    return pi;
  }
  
  
  public static void main(String [] args) { 
    
    System.out.print( "Enter the number of games: " );
    Scanner myInput = new Scanner(System.in);
    int number_of_games = myInput.nextInt();
    System.out.print( "Enter the number of darts: " );
    int number_of_darts = myInput.nextInt();
    
    System.out.println(PiEstimator(number_of_games ,number_of_darts));
    
  }
  
}