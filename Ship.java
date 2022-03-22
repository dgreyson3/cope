public class Ship
{
    public static final int UNSET = -1;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
   
    private int row;
    private int col;
    private int length;
    private int dir;
    private String direction;
   
    public Ship(int row, int col, int length)
    {
        length = 1;
        row = UNSET;
        col = UNSET;
    }
    public Ship(int length)
    {
        this.length = length;
    }
    public void setLocation(int r, int c)
    {
        row = r;
        col = c;
        
    }
   
    public void setDirection(int d)
    {
        this.dir = d;
    }
   
    public int getRow()
    {
        return row;
    }
   
    public int getCol()
    {
        return col;
    }
   
    public int getLength()
    {
        return length;
    }
   
    public int getDirection()
    {
        return dir;
    }
   
    private String directionToString()
    {
        if(direction == null)
        {
            return "unset direction";
        }
        return direction;
    }
   
    public boolean isDirectionSet()
    {
        if(direction == null)
        {
            return false;
        }
        return true;
    }
}
