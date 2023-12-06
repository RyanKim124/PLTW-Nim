import java.util.Scanner;

public class Runner
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Game game = new Game();

        game.start();

        while (true)
        {
            System.out.println();
            System.out.println("Play Again?");
            System.out.println("1: Yes");
            System.out.println("2: No");

            String input = sc.nextLine();
            if (input.equals("1"))
            {
                game.start();
            }
            else if (input.equals("2"))
            {
                break;
            }

            System.out.println("Invalid input");
        }
    }
}