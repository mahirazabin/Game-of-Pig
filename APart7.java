import java.util.Random;
import java.util.Scanner;

public class APart7{

    public static void main(String[] args)
    {
        GameOfPig();
    }

    public static void GameOfPig()
    {
      
        // Choose Player

        // if 1, then player 1, if 2 then player 2

        Random random = new Random();
        int player = (random.nextInt(2) + 1);

        if (player == 1)
        {
            System.out.println("It's Computer's turn.");
        }
        else
        {
            System.out.println("It's Human's turn.");
        }


        int Computer_total_score = 0; 
        int Human_total_score = 0;

        while (Computer_total_score < 100 && Human_total_score < 100)
        {
            if (player == 1)
            {    

                if (Computer_total_score <= 80)
                {
                    int turnCountOne = 0;
                    while (turnCountOne < 20 )
                    {   
                        int die = random.nextInt(6) + 1;
                        System.out.println("- Computer rolled a " + die);
                        turnCountOne += die;

                        if (die == 1)
                        {   
                            turnCountOne = 0;
                            System.out.println();
                            System.out.println("Pigged out!");
                            System.out.println("Total Turn score = " + (turnCountOne));
                            System.out.println();
                            System.out.println("Computer's Score: " + (Computer_total_score));
                            System.out.println("Human's Score: " + (Human_total_score));
                            System.out.println();
                            System.out.println("It's Human's turn");
                            player = 2;
                            break;
                        }                    
                    }                        

                    if (turnCountOne >= 20)
                    { 
                        Computer_total_score += turnCountOne;
                        System.out.println();
                        System.out.println("Total Turn score = " + (turnCountOne));
                        System.out.println();
                        System.out.println("Computer's Score: " + (Computer_total_score));
                        System.out.println("Human's Score: " + (Human_total_score));
                        System.out.println();
                        System.out.println("It's Human's turn");
                        player = 2;

                    }
                }                       

                else // IF TOTAL SCORE > 80 
                {

                    int turnCountOne = 0;

                    int tempScore = Computer_total_score;
                    while (tempScore < 100 && player == 1)
                    {
                        int die = random.nextInt(6)+1;
                        System.out.println("- Computer rolled a " + die);
                        turnCountOne += die;

                        if (die == 1)
                        {
                            turnCountOne = 0;
                            System.out.println();
                            System.out.println("Pigged out!");
                            System.out.println("Turn score = " + (turnCountOne));
                            System.out.println("Computer's Score: " + (Computer_total_score));
                            System.out.println("Human's Score: " + (Human_total_score));
                            System.out.println();
                            System.out.println("It's Human's turn");
                            player = 2;
                            tempScore = Computer_total_score;
                        }    

                        else 
                        {
                            tempScore += die;
                        }
                    }
                    if(tempScore >=100)
                    {
                        Computer_total_score = tempScore;
                        System.out.println("Computer's Score: " + (Computer_total_score));
                        System.out.println("Human's Score: " + (Human_total_score));
                    }
                }
            }
                

            if (player == 2)

            {
                String humanChoice;
                Scanner input = new Scanner(System.in);
                System.out.println("Enter [r] for roll and [h] for hold:");
                humanChoice = input.nextLine();
                
            

                int humanCount = 0;
                while (humanChoice.equals("r"))
                {

                    int die = random.nextInt(6) + 1;
                    System.out.println("- Human rolled a " + die);
                    

                    if (die != 1)
                    {
                        humanCount += die;
                        System.out.println("Enter [r] for roll and [h] for hold:");
                        humanChoice = input.nextLine();
                    }

                    else
                    {   
                        humanCount = 0;
                        System.out.println("Human is pigged out!");
                        System.out.println();
                        System.out.println("Total Turn score = " + (humanCount));
                        System.out.println();
                        System.out.println("Computer's Score: " + (Computer_total_score));
                        System.out.println("Human's Score: " + (Human_total_score));
                        System.out.println();
                        System.out.println("It's Computer's turn");
                        player = 1;
                        break;
                    }
                }

                Human_total_score += humanCount;
                
                        

                if (humanChoice.equals("h"))
                {
                    player = 1;
                }

            }
        }


            
                

                            
                            
                            
                    
        if (Human_total_score >= 100 || Computer_total_score >= 100)
        {

            System.out.println("Final Score: " + (Computer_total_score) + " vs " + (Human_total_score));

            if (Computer_total_score > Human_total_score)
            {
                System.out.println("Computer Wins!");
            }
            else
            {
                System.out.println("Human Wins!");
            }
        }





    }
    
}