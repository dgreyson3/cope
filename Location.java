public class Location
{
    //Constants for state of space
    public static final int UNGUESSED = 0;
    public static final int HIT = 1;
    public static final int MISSED = 2;
    //Methods
    private int locState = UNGUESSED;
    private int row;
    private int col;
    private boolean occupied = false; 
    // Location constructor. 
    public Location(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    // Was this Location a hit?
    public boolean checkHit()
    {
        if(locState == HIT)
        {
            return true;
        }
        return false;
    }

    // Was this location a miss?
    public boolean checkMiss()
    {
        if(locState == MISSED)
        {
            return true;
        }
        return false;
    }

    // Was this location unguessed?
    public boolean isUnguessed()
    {
        if(locState == UNGUESSED)
        {
            return true;
        }
        return false;
    }

    // Mark this location a hit.
    public void markHit()
    {
        locState = HIT;
    }

    // Mark this location a miss.
    public void markMiss()
    {
        locState = MISSED;
    }

    // Return whether or not this location has a ship.
    public boolean hasShip()
    {
        if(occupied)
        {
            return true;
        }
        return false;
    }

    // Set the value of whether this location has a ship.
    public void setShip(boolean val)
    {
        occupied = val;
    }

    // Set the status of this Location.
    public void setStatus(int status)
    {
        status = locState;
    }

    // Get the status of this Location.
    public int getStatus()
    {
        return locState;
    }
}
