public class Battleship extends ConsoleProgram
{
    String[] alpha ={"a","b","c","d","e","f","g","h","i","j"};
    public void run()
    {
        while(true)
        {
            System.out.println("=======================\nWelcome to Battle Ship\n=======================");
    
            Player player = new Player();
            Player computer = new Player();
    
            for(int i =0; i<player.getNumShips();i++)
            {
                setUpShips(i,player);
                computerPlaceShip(i,computer);
            }
            while(!checkWin(player,computer))
            {
                System.out.println("\nTotal Hits = " + computer.getHits() +" out of " + computer.getHitpoints());
                player.printOppGrid();
                computer.printOppGrid();
                askForGuess(computer);
                computerGuess(player);
                checkWin(player,computer);
            }
            checkWinner(computer);
            String restart = readLine("Would you like to keep playing? ( Y/N )").toLowerCase();
            if(restart.equals("no"))
            {
                    break;
            }
        }
    }
    private void checkWinner(Player player)
    {
        if(player.getHits() == player.getHitpoints())
        {
            System.out.println("Player wins!");
        }
        else
        {
            System.out.println("Computer wins!");
        }
    }
    private boolean checkWin(Player player, Player computer)
    {
        if(player.getHits()== player.getHitpoints() || computer.getHits()== 1)
        {
            return true;
        }
        return false;
    }
    private void computerGuess(Player p)
    {
        Randomizer rnd = new Randomizer();
        int row = rnd.nextInt(0,9);
        int col = rnd.nextInt(0,9);
        p.recordOpponentGuess(row,col);
    }
    private void computerPlaceShip(int shipNum, Player p)
    {
        Randomizer rnd = new Randomizer();
        int row = rnd.nextInt(0,5);
        int col = rnd.nextInt(0,5);
        int dir = rnd.nextInt(0,1);
        p.getShip(shipNum).setLocation(col,row);
        p.chooseShipLocation(p.getShip(shipNum));
        System.out.println("\nThe computer places its ship.\n");
        
    }
    private void setUpShips(int shipNum,Player p)
    {
        String enter = readLine("Hit enter to place the next ship.\n");
        System.out.println("Your current grid of ships.\n");
        p.printPlayerGrid();
        System.out.println("Now you need to place a ship of length " + p.getShip(shipNum).getLength());
        
        String row = readLine("Which row? (A - J)").toLowerCase();
        int output = 0;
        for(int i=0;i<10;i++)
        {
            if(alpha[i].equals(row))
            {
                output = i;
            }
        }
        int col = readInt("Which column? (1 - 10)");
        int dir=0;
        String direction = readLine("Horizontal or Vertical?").toLowerCase();
        if(direction.equals("vertical"))
        {
            dir = 1;
        } 
        else if(direction.equals("horizontal"))
        {
            dir = 0;
        }
        p.getShip(shipNum).setLocation(output,col-1);
        p.getShip(shipNum).setDirection(dir);
        p.chooseShipLocation(p.getShip(shipNum));
    }
    private void askForGuess(Player p)
    {
        System.out.println("It's your turn to guess.");
        String row = readLine("Which row would you like to attack? (A - J)").toLowerCase();
        int inRow = 0;
        for(int i=0;i<10;i++)
        {
            if(alpha[i].equals(row))
            {
                inRow = i;
            }
        }
        int col = readInt("Which collumn would you like to attack? (1 - 10)");
        p.recordOpponentGuess(inRow,col-1);
        if(p.checkHit(col-1,inRow))
        {
            System.out.println("You got a hit!");
            p.addHits();
        } 
        else 
        {
            System.out.println("Nope, that was a miss.");
        }
        
    }
}
