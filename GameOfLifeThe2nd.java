import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

class GameOfLifeThe1st extends JPanel implements ActionListener
{
    private static final int CELL_LENGTH = 10;
    private static final int GRID_LENGTH = 80;
    private static final int GRID_HEIGHT = 60;
    private static final int TIMER_DELAY = 90;
    private static boolean[][] grid = new boolean[GRID_HEIGHT][GRID_LENGTH];
    private static Timer timer;
    private static Random random = new Random();

    GameOfLifeThe1st()
    {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(CELL_LENGTH * GRID_LENGTH, CELL_LENGTH * GRID_HEIGHT));
        getInitialRandomizedGrid();
        timer = new Timer(TIMER_DELAY, this);
        timer.start();

    }

    public void actionPerformed(ActionEvent e)
    {
        grid = getNextGeneration();
        repaint();
    }

    public static void getInitialRandomizedGrid()
    {
        for(int i = 0; i < GRID_HEIGHT; i++)
        {
            for(int j = 0; j < GRID_LENGTH; j++)
            {
                grid[i][j] = random.nextBoolean();
            }
        }  
    }

    public static boolean[][] getNextGeneration()
    {
        boolean new_grid[][] = new boolean[GRID_HEIGHT][GRID_LENGTH];
        for(int i = 0; i < GRID_HEIGHT; i++)
        {
            for(int j = 0; j < GRID_LENGTH; j++)
            {
                int check = getNeighbours(i, j);
                if(grid[i][j] == true)
                {
                    new_grid[i][j] = (check == 2) || (check == 3);
                } 
                else
                {
                    new_grid[i][j] = (check == 3);
                }
            }
        }
        return new_grid;
    }

    public static int getNeighbours(int n1, int n2)
    {
        int check = 0;
        for(int i = -1; i <= 1; i++)
        {
            for(int j = -1; j <= 1; j++)
            {
                if(i != 0 || j != 0)
                {
                    if(n1 + i >= 0 && n1 + i < GRID_HEIGHT && n2 + j >= 0 && n2 + j < GRID_LENGTH && grid[n1 + i][n2 + j] == true)
                    check++;
                }
            }
        }
        return check;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(int i = 0; i < GRID_HEIGHT; i++)
        {
            for(int j = 0; j < GRID_LENGTH; j++)
            {
                int x = j * CELL_LENGTH;
                int y = i * CELL_LENGTH;
                if(grid[i][j] == true)
                {
                    g.setColor(getRainbowColor());
                    g.fillOval(x, y, CELL_LENGTH, CELL_LENGTH);
                }
                else
                {
                    g.setColor(Color.BLACK);
                    g.fillRect(x, y, CELL_LENGTH, CELL_LENGTH);
                }
            }
        }
    }

    public static Color getRainbowColor()
    {
        float hue = random.nextFloat();
        return Color.getHSBColor(hue, 1.0f, 1.0f);
    }
}

class GameOfLifeThe2nd
{
    public static void main(String args[])
    {
        JFrame jframe = new JFrame("Conway's Game of Life");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameOfLifeThe1st game = new GameOfLifeThe1st();
        jframe.add(game);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}
