# Conways Game Of Life
Implements the game of life using javax.swing and java.awt components. It's not toroidal right now, but I'll make it into that soon. It's rainbow colored and alive cells are represented by circles. It follows the standard rules of the simulator. Have Fun!


Each cell interacts with its **8 neighbors** (horizontal, vertical, and diagonal adjacent cells). The following rules determine the next state of each cell:

1. **Underpopulation**  
   A live cell with **fewer than 2 live neighbors** dies.

2. **Survival**  
   A live cell with **2 or 3 live neighbors** stays alive.

3. **Overpopulation**  
   A live cell with **more than 3 live neighbors** dies.

4. **Reproduction**  
   A dead cell with **exactly 3 live neighbors** becomes alive.

## 🧠 How it Works

- The rules are applied **simultaneously** to every cell in the grid.
- The new state of each cell is determined based on the current configuration.
- This process is repeated for each generation.

## 🚀 Example Use Cases

- Simulation of natural selection and evolution
- Study of emergence and complexity
- Basis for algorithmic pattern formation
