# Conways Game Of Life
Implements the game of life using javax.swing and java.awt components. It's not toroidal right now, but I'll make it into that soon. It's rainbow colored and alive cells are represented by circles. It follows the standard rules of the simulator. Have fun generating


Each cell interacts with its **8 neighbors** (horizontal, vertical, and diagonal adjacent cells). The following rules determine the next state of each cell:

1. **Underpopulation**  
   A live cell with **fewer than 2 live neighbors** dies.

2. **Survival**  
   A live cell with **2 or 3 live neighbors** stays alive.

3. **Overpopulation**  
   A live cell with **more than 3 live neighbors** dies.

4. **Reproduction**  
   A dead cell with **exactly 3 live neighbors** becomes alive.

##  How it Works

- The rules are applied **simultaneously** to every cell in the grid.
- The new state of each cell is determined based on the current configuration.
- This process is repeated for each generation.

  ![image](https://github.com/user-attachments/assets/b50bafef-97af-4f96-82c2-27a7fc3b1ea3)
  ![image](https://github.com/user-attachments/assets/65e1cfaa-b8be-4738-a670-d6ca305a93b9)
  ![1000128773](https://github.com/user-attachments/assets/be557b62-75b9-489e-8fe0-0f9331fee1f9)


##  Example Use Cases

- Simulation of natural selection and evolution
- Study of emergence and complexity
- Basis for algorithmic pattern formation
