public class Player
{
    private static final int[] SHIP_LENGTHS = {2, 3, 3, 4, 5};
    private static final int HITPOINTS = 17;
    private Ship[] ships;
    private Grid own = new Grid();
    private Grid opp = new Grid();
    private int hits = 0;
   
    public Player()
    {
        ships = new Ship[SHIP_LENGTHS.length];
        for(int i=0;i < SHIP_LENGTHS.length;i++)
        {
            ships[i] = new Ship(SHIP_LENGTHS[i]);
        }
    }
   
    public void chooseShipLocation(Ship s)
    {
        own.addShip(s);
    }
   
    public int getNumShips()
    {
        return ships.length;
    }
    public Ship getShip(int num)
    {
        return ships[num];
    }
    //returns the amount of times the player has been hit
    public int getHits()
    {
        return hits;
    }
    public int getHitpoints()
    {
        return HITPOINTS;
    }
    //Set hits
    public void addHits()
    {
        hits++;
    }
    public boolean checkHit(int row, int col)
    {
        if(own.hasShip(col,row))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //Prints players board
    public void printPlayerGrid()
    {
        own.printShips();
    }
    
    //prints your guesses
    public void printOppGrid()
    {
        opp.printStatus();
    }
    
    public void recordOpponentGuess(int row, int col)
    {
        if(own.hasShip(row, col))
        {
            opp.markHit(row, col);
        }
        else
        {
            opp.markMiss(row, col);
        }
    }
   
}
