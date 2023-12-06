public class Player {
    
    private String name;

    public Player()
    {
        this.name = "";
    }

    public Player(String n)
    {
        this.name = n;
    }

    /**
     * Gets the name of the player
     * 
     * @return The name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Replaces the name of the player
     * 
     * @param newName The name that should repalce the old name
     */
    public void setName(String newName)
    {
        this.name = newName;
    }
}