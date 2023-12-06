public class Pile {
    private int count;

    public Pile(int count)
    {
        this.count = count;
    }

    public Pile()
    {
        this.count = (int)((Math.random() * 41) + 10);
    }

    /**
     * Gets the amount of objects in the pile.
     * 
     * @return The amount of objects in the pile
     */
    public int getCount()
    {
        return count;
    }

    /**
     * Sets the count to some value, private because it should not be used by other classes.
     * 
     * @param amount The amount of objects the count should be set to
     */
    private void setCount(int amount)
    {
        count = amount;
    }

    /**
     * Takes out a specified amount from the pile, should be less than half of the count rounded down.
     * 
     * @param amount The amount of objects to take from the pile, should be less than half of the amount rounded down
     * @return       If the amount of objects was less than half of the amount rounded down.
     */
    public boolean takeCount(int amount)
    {
        if (amount == 1 && count == 1)
        {
            setCount(0);

            return true;
        }

        if (amount > count / 2)
        {
            return false;
        }

        setCount(getCount() - amount);

        return true;
    }
}