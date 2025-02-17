
import java.util.*;

public class NumberGameNorwood{ 
   public static void main(String[] args){
      start();
   }
   
   public static void start(){
      Scanner kb = new Scanner(System.in);                
      String answer = "";
      boolean more = true;
      while(more){
       
         do{
            directions();
            System.out.print("\nWhat is your name: ");
            String name = kb.nextLine();
            System.out.println("\nHello " + name + " lets start playing\n");
            game();
            System.out.print("Hit enter to let another person play or enter Q to quit the program: ");
            answer = kb.nextLine();
         }while(!answer.equalsIgnoreCase("q"));
      
         System.out.println("Good Bye! Come Back soon to play again");
         return;
      }
   }

   public static int prize(int matched){
      Random rand = new Random();
      int prize = 0;
      for (int i = 0; i < matched; i++) {
          int amountEarned = rand.nextInt(101) + 100;
          System.out.println("You won " + amountEarned + " for the mathced digit");
          prize += amountEarned;
      }
      
      System.out.println("Your prize for this round: " + prize);
      return prize;
       
   
   }
  
   public static int bigNumber(Random rand, int digitCounts){
      int min = (int) Math.pow(10, digitCounts -1); 
      int max = (int) Math.pow(10, digitCounts) -1;
      int result = rand.nextInt(max - min + 1) + min;
      return result;
   }

   public static int countMatched(int n1, int n2){
      String s1 = n1 +"";
      String s2 = n2 +"";
      int matchCount = 0;
      int[] m1 = new int[s1.length()];
      int[] m2 = new int[s2.length()];

      for(int i = s1.length() -1; i >= 0; i--){
         m1[i] = n1 % 10;
         n1 = n1 / 10;
      }
      
      for(int i = s2.length() -1; i >= 0; i--){
          m2[i] = n2 % 10;
          n2 = n2 / 10;
      }

      String s = "";

      for(int i = 0; i <m1.length; i++){

         for(int j = 0; j <m2.length; j++){            
            if (m1[i] == m2[j]) {
                s += m1[i] + " ";
                matchCount++;
                m2[j] = -100;

                break;
            }     
         }
      }
      
    
      System.out.println("Here are the matching numbers: " + s);
      return matchCount;  
   }
  

   public static void game(){
      Scanner kb = new Scanner(System.in);
      Random rand = new Random();
       
      int total = 0; 
      String reply = "";
      int rand_num = rand.nextInt(4) + 3;
      boolean running = true;
      while(running){
          

         int first_num = bigNumber(rand, rand_num );

         int second_num = bigNumber(rand, rand_num);
         

         System.out.println("You got: " + first_num + " " + second_num);
         
        
         int numbers = countMatched(first_num, second_num);
         

         int result = prize(numbers);
         

         total += result;
         
         System.out.print("\nHit enter to continue or press q/Q to quit  ");
         reply = kb.nextLine();
        if (reply.equalsIgnoreCase("q")) {
            running = false;
        }
             
      }

   
      System.out.println("\nTotal amount you won: " + total);

     
   }

   public static void directions(){
       System.out.println("**************************************************");
       System.out.println("This program generates two random numbers for you, checks to see if ");
       System.out.println("any of the integers within the two numbers match an ");
       System.out.println("integer in the other number and if so ");
       System.out.println("generates a random number between $100-$200, inclusive,");
       System.out.println("and gives it to you as a prize.");
       System.out.println("Enter q if you want to exit the game.");
       System.out.println("**************************************************");
        
   }
}