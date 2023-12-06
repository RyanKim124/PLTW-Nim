import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private Player player3;

    private Pile pile;

    private int playerCount;

    public Game()
    {

        player1 = new Player();
        player2 = new Player();
        player3 = new Player();

        Scanner sc = new Scanner(System.in);

        String input = "";

        // Type of game loop
        while (true)
        {
            System.out.println("Would you like to play against an AI or a Friend?");
            System.out.println("1: Expert AI");
            System.out.println("2: Friend");
            System.out.println("3: 2 Friends");

            input = sc.nextLine();

            if (input.equals("1") || input.equals("2") || input.equals("3"))
            {
                break;
            }

            System.out.println("");
            System.out.println("Invalid input, try again.");
            System.out.println("");
        }

        // Entering all of the player's names

        System.out.println("Enter Player 1's Name:");

        player1.setName(sc.nextLine());

        playerCount++;

        // Should only enter a name if there is more than 1 player

        if (input.equals("2") || input.equals("3"))
        {
            System.out.println("Enter Player 2's Name:");
            player2.setName(sc.nextLine());

            playerCount++;

            if (input.equals("3"))
            {
                System.out.println("Enter Player 3's Name:");
                player3.setName(sc.nextLine());

                playerCount++;
            }
        }
    }

    public void start()
    {
        Scanner sc = new Scanner(System.in);

        pile = new Pile();

        boolean isOver = false;

        // Turn counter, 0 is used for AI
        int turn;

        if (playerCount == 1)
        {
            // Get if the AI Should start or not
            if (Expert.shouldStart(pile.getCount()))
            {
                turn = 0;
            }
            else
            {
                turn = 1;
            }
        }
        else
        {
            // Get random turn
            turn = (int)((Math.random() * playerCount) + 1);
        }

        while (!isOver)
        {
            System.out.println();

            // Type of player
            if (turn == 0)
            {
                System.out.println("It is currently the expert's turn.");
            }
            else
            {
                System.out.println("It is currently Player " + turn + "'s turn");
            }
            
            // Spelling check

            if (pile.getCount() > 1)
            {
                System.out.println("There are " + pile.getCount() + " thing(s) in the pile, you can take up to " + pile.getCount() / 2 + " thing(s)");
            }
            else
            {
                System.out.println("There are " + pile.getCount() + " thing in the pile, you can take up to " + 1 + " thing");
            }
            

            // If the turn is a real player turn.
            if (turn > 0)
            {
                // Input loop, loop until there is a valid input
                while (true)
                {
                    System.out.println("Enter how much items you want to take:");

                    String amount = sc.nextLine();

                    // Regex to check if the user inputted a INTEGER not a STRING
                    if (amount.matches("-?\\d+"))
                    {
                        if (pile.takeCount(Integer.parseInt(amount)))
                        {
                            break;
                        }
                    }
                    
                    System.out.println("Invalid input, try again.");
                }
                
            }

            // AI Turn
            else
            {
                int aiAmount = Expert.getMove(pile.getCount());
                System.out.println("The AI Takes " + aiAmount + " of the items");
                pile.takeCount(aiAmount);
            }

            if (pile.getCount() <= 0)
            {
                isOver = true;
                break;
            }

            if (playerCount == 1)
            {
                switch (turn)
                {
                    case 0:
                        turn = 1;
                        break;
                    case 1:
                        turn = 0;
                        break;
                }
            }
            else
            {
                turn++;

                if (turn > playerCount)
                {
                    turn = 1;
                }
            }
            
        }
        
        // Say the winning message.
        switch (turn)
        {
            case 0:
                System.out.println("You beat the AI!");
                break;
            case 1:
                System.out.println(player1.getName() + " loses!");
                break;
            case 2:
                System.out.println(player2.getName() + " loses!");
                break;
            case 3:
                System.out.println(player3.getName() + " loses!");
                break;
        }
    }
}
