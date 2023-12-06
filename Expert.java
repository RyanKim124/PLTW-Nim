public class Expert {
    // List of the losing states of the game
    static private int[] losingStates = {7, 15, 31};

    /**
     * Tries to get the optimal amount of items to take from the pile.
     * 
     * @param amount The amount of items in the pile currently
     * @return       The amount of items that the expert should take
     */
    public static int getMove(int amount)
    {

        switch (amount)
        {
            case 1:
                return 1;
            case 2:
                return 1;
            case 3:
                return 1;
            case 4:
                return 1;
            case 5:
                return 2;
            case 6:
                return 3;
            default:
                break;
        }

        if (15 > amount && amount > 7 )
        {
            return amount - 7;
        }

        if (31 > amount && amount > 15)
        {
            return amount - 15;
        }

        if (amount > 31)
        {
            return amount - 31;
        }
        
        return -1;
        
    }

    /**
     * Returns if the AI should start or not depend on the amount of items in the pile.
     * 
     * @param amount The amount of items in the pile
     * @return       If the AI should start or not.
     */
    public static boolean shouldStart(int amount)
    {
        for (int i : losingStates)
        {
            if (amount == i)
            {
                return false;
            }
        }

        return true;
    }
}
