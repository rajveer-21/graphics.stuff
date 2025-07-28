#include <SFML/Graphics.hpp>
#include <vector>
#include <cstdlib>
#include <ctime>

const int windowHeight = 800;
const int windowWidth = 800;
const int cellSize = 10;
const int rows = windowHeight / cellSize;
const int cols = windowWidth / cellSize;

std::vector<std::vector<bool>> curr_grid(rows, std::vector<bool>(cols));
std::vector<std::vector<bool>> next_grid(rows, std::vector<bool>(cols));

void randomizeGrid()
{
    for(int i = 0; i < rows; i++)
    {
        for(int j = 0; j < cols; j++)
        {
            int val = rand() % 2;
            if(val == 1)
            {
                curr_grid[i][j] = true;
            }
            else
            {
                curr_grid[i][j] = false;
            }
        }
    }
}

int countNeighbours(int x, int y)
{
    int count = 0;
    for(int i = -1; i <= 1; i++)
    {
        for(int j = -1; j <= 1; j++)
        {
            if(i != 0 || j != 0)
            {
                int dx = (i + x + rows) % rows;
                int dy = (j + y + cols) % cols;
                if(curr_grid[dx][dy] == true)
                {
                    count++;
                }
            }
        }
    }
    return count;
}

void updateGrid()
{
    for(int i = 0; i < rows; i++)
    {
        for(int j = 0; j < cols; j++)
        {
            int count = countNeighbours(i, j);
            if(curr_grid[i][j] == true && (count == 2 || count == 3))
            {
                next_grid[i][j] = true;
            }
            else if(curr_grid[i][j] == false && count == 3)
            {
                next_grid[i][j] = true;
            }
            else
            {
                next_grid[i][j] = false;
            }
        }
    }
    curr_grid.swap(next_grid);
}

int main()
{
    srand(static_cast<unsigned>(time(nullptr)));
    sf::RenderWindow window(sf::VideoMode(windowWidth, windowHeight), "Game Of Life");
    sf::RectangleShape cellShape(sf::Vector2f(cellSize - 1, cellSize - 1));
    randomizeGrid();
    sf::Clock clock;

    while(window.isOpen())
    {
        sf::Event event;
        while(window.pollEvent(event))
        {
            if(event.type == sf::Event::Closed)
            {
                window.close();
            }
        }

        if(clock.getElapsedTime().asMilliseconds() > 100)
        {
            updateGrid();
            clock.restart();
        }

        window.clear(sf::Color::Black);

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(curr_grid[i][j] == true)
                {
                    cellShape.setPosition(j * cellSize, i * cellSize);
                    cellShape.setFillColor(sf::Color::Red);
                    window.draw(cellShape);
                }
            }
        }

        window.display();
    }

    return 0;
}
