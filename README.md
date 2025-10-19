# Graphics

## Conway's Game Of Life   
Implements the game of life using javax.swing and java.awt from Java components. A second implementation was written in SFML from C++. It's rainbow colored and alive cells are represented by circles also it follows the toroidal format. It follows the standard rules of the simulator. Have fun generating!


Each cell interacts with its **8 neighbors** (horizontal, vertical, and diagonal adjacent cells). The following rules determine the next state of each cell:

1. **Underpopulation**  
   A live cell with **fewer than 2 live neighbors** dies.

2. **Survival**  
   A live cell with **2 or 3 live neighbors** stays alive.

3. **Overpopulation**  
   A live cell with **more than 3 live neighbors** dies.

4. **Reproduction**  
   A dead cell with **exactly 3 live neighbors** becomes alive.

###  How it Works

- The rules are applied **simultaneously** to every cell in the grid.
- The new state of each cell is determined based on the current configuration.
- This process is repeated for each generation.

  ![image](https://github.com/user-attachments/assets/b50bafef-97af-4f96-82c2-27a7fc3b1ea3)
  ![image](https://github.com/user-attachments/assets/65e1cfaa-b8be-4738-a670-d6ca305a93b9)
  <img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/c5043204-de5a-4e5a-8599-4a7516a4da81" />

  ![1000128773](https://github.com/user-attachments/assets/be557b62-75b9-489e-8fe0-0f9331fee1f9)


### Example Use Cases

- Simulation of natural selection and evolution
- Study of emergence and complexity
- Basis for algorithmic pattern formation

## Verlet Integration Based Cloth Simulator
A cloth simulator using verlet integration and with the usage of wind and gravity!

### A GUI based cloth sim using verlet integration
Uses Java's inbuilt Swing and AWT packages for rendering lines and points to form a mesh which is used to denote a piece of cloth. I've integrated the usage of gravity and wind(0.5f units per iteration each with wind being a randomized variable) to simulate realistic movement of the cloth. 

**Constraint Class ->**
 Defines spring variables between points on the mesh which are responsible for causing streching and contraction of the points when they are not pinned. It produces a percentage for multiplication with the offset of the x and y axis of the moved particles. Allows the particles affected by the movement to be equally moved and changed without bias.

**Particle Class ->**
 Defines individual particles on the mesh which have x and y coordinates which are respectively affected by wind, gravity and movement due to mouse events.

**Mouse Based Events ->**
 Main driver behind various changes on the mesh, press and drag on unpinned particles to watch them bounce around due to their constraints and pinned particles to change the underlying structure of the entire mesh.

<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/58b5db4a-6d74-4db0-88da-5b568c7efbe8" />

Have fun simulating! Regards.
🧙‍♀️🪄🧙‍♀️ zullie was here!
⚔️⚔️⚔️ alva was here too!
